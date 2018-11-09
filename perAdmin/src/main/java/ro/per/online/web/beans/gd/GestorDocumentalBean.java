package ro.per.online.web.beans.gd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.exceptions.PerException;
import ro.per.online.lazydata.LazyModelDocumentos;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.TipoDocumento;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.repositories.ITipoDocumentoRepository;
import ro.per.online.services.UserService;
import ro.per.online.services.impl.DocumentoServiceImpl;
import ro.per.online.util.FacesUtilities;

/**
 * Bean pentru managerul de documente.
 *
 * @author STAD
 *
 */

@Setter
@Getter
@Controller("gestorDocumentalBean")
@Scope(Constantes.SESSION)
public class GestorDocumentalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constante para evitar literales repetidos.
	 */
	private static final String CARGAFICHEROS = "Carga de ficheros";

	/**
	 * Obiectul de tip Document pentru înregistrarea de noi documente.
	 */
	private Documento documento;

	/**
	 * Obiect care conține parametrii de căutare pentru documente.
	 */
	private DocumentoBusqueda documentoBusqueda;

	/**
	 * Obiect care va conține fișierul care urmează să fie descărcat.
	 */
	private transient StreamedContent file;

	/**
	 * Numele documentului
	 */
	private String nombreDoc;

	/**
	 * Listează unde sunt stocați utilizatorii care vor fi asociați unui document.
	 */
	private List<Users> listaUsuarios = new ArrayList<>();

	/**
	 * Mapa care relaționeză documentele și utilizatorii.
	 */
	private Map<Long, String> mapaUsuarios;

	/**
	 * Mapa care relaționeză documentele și utilizatorii.
	 */
	private Map<Long, Boolean> mapaEdicion;

	/**
	 * Lista valorilor booleene pentru vizualizarea coloanelor in pagina.
	 */
	private List<Boolean> list;

	/**
	 * Servicio de documentos.
	 */
	@Autowired
	private transient DocumentoServiceImpl documentoService;

	/**
	 * Repositorio de tipos de documento.
	 */
	@Autowired
	private transient ITipoDocumentoRepository tipoDocumentoRepository;

	/**
	 * Service de usuarios.
	 */
	@Autowired
	private transient UserService usuarioService;

	/**
	 * Lazy Model para la consulta paginada de documentos en base de datos.
	 */
	private LazyModelDocumentos model;

	/**
	 * Elimina un documento definitivamente.
	 * @param doc Documento a eliminar
	 */
	public void borrarDocumento(final Documento doc) {
		try {
			doc.setUsuario(null);
			this.documentoService.delete(doc);
			this.buscaDocumento();
		}
		catch (final DataAccessException e) {
		}
	}

	/**
	 * Lanza la búsqueda de documentos en la base de datos que correspondan con los parámetros contenidos en el objeto
	 * de búsqueda. SE realiza paginación desde el servidor.
	 *
	 */
	public void buscaDocumento() {
		this.model.setBusqueda(this.documentoBusqueda);
		this.model.load(0, Constantes.TAMPAGINA, "fechaAlta", SortOrder.DESCENDING, null);
		this.nombreDoc = "";
	}

	/**
	 * Carga un documento que se recibe a través de un evento FileUploadEvent. Esta carga se realiza sobre el objeto
	 * documento y no se guarda en base de datos. Se hace una comprobación para verificar si el tipo de documento se
	 * corresponde a la realidad.
	 * @param event Evento que se lanza en la carga del documento y que contiene el mismo
	 */
	public void cargaFichero(final FileUploadEvent event) {
		try {
			final TipoDocumento tipo = this.tipoDocumentoRepository.findByNombre("OTROS");
			final UploadedFile uFile = event.getFile();
			this.documento = this.documentoService.cargaDocumentoSinGuardar(uFile, tipo, null);
			this.nombreDoc = uFile.getFileName();
		}
		catch (final PerException ex) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, CARGAFICHEROS,
					"Se ha producido un error en la cargad el fichero");
		}
	}

	/**
	 * Graba un nuevo documento en la base de datos.
	 *
	 * @param nombreDocumento Nombre del documento
	 * @param tipoDocumento Tipo al que pertenece el documento
	 * @param descripcion Breve descripción del documento
	 * @param materiaIndexada Palabras clave por las que se podrá buscar el documento
	 */
	public void creaDocumento(final String nombreDocumento, final TipoDocumento tipoDocumento, final String descripcion,
			final String materiaIndexada) {
		if (!this.nombreDoc.isEmpty() && !nombreDocumento.isEmpty() && (tipoDocumento != null)) {
			try {
				this.documento.setNombre(nombreDocumento);
				this.documento.setTipoDocumento(tipoDocumento);
				this.documento.setDescripcion(descripcion);
				final Users usuario = this.usuarioService
						.fiindOne(SecurityContextHolder.getContext().getAuthentication().getName());
				this.documento.setUsuario(usuario);
				this.documento.setMateriaIndexada(materiaIndexada);
				this.documento.setDateDeleted(null);
				this.documentoService.save(this.documento);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, "ALTA",
						"Se ha guardado su documento con éxito");
				this.recargaLista();
				RequestContext.getCurrentInstance().reset("formAlta:asociado");
				this.nombreDoc = "";
			}
			catch (final DataAccessException e) {
			}
		}
		else {
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR, "Alta de documentos",
					"Complete los campos obligatorios antes de continuar.", null);
		}
	}

	/**
	 * Inicia la descarga del documento que se recibe como parámetro.
	 * @param document Documento a descargar
	 */
	public void descargarFichero(final Documento document) {
		final Documento docAux = this.documentoService.findOne(document.getId());
		this.setFile(null);
		if (docAux != null) {
			try {
				this.setFile(this.documentoService.descargaDocumento(docAux));
			}
			catch (final PerException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						e.getMessage());
			}
		}
		else {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, CARGAFICHEROS,
					"A apărut o eroare la descărcarea fișierului");
		}
	}

	/**
	 * Recupera el documento a modificar e inicia el proceso de modificación.
	 *
	 * @param doc Documento a modificar
	 * @return URL de la vista de edición
	 */
	public String editarDocumento(final Documento doc) {
		final Documento docAux = this.documentoService.findOne(doc.getId());
		String redireccion = null;

		if (docAux != null) {
			this.documento = docAux;
			this.nombreDoc = this.documentoService.obtieneNombreFichero(this.documento);
			redireccion = "/gestorDocumental/editarDocumento?faces-redirect=true";
		}
		else {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, CARGAFICHEROS,
					"Se ha producido un error al acceder al documento");
		}
		return redireccion;
	}

	/**
	 * Realiza la baja lógica del documento que podrá ser recuperado desde la papelera.
	 *
	 * @param document Documento al que se dará de baja lógica
	 */
	public void eliminarDocumento(final Documento document) {
		try {
			document.setDateDeleted(new Date());
			document.setUserDeleted(SecurityContextHolder.getContext().getAuthentication().getName());
			this.documentoService.save(document);
			this.buscaDocumento();
		}
		catch (final DataAccessException e) {
		}
	}

	/**
	 * Inicializa el objeto.
	 */
	@PostConstruct
	public void init() {
		this.documentoBusqueda = new DocumentoBusqueda();
		this.list = new ArrayList<>();
		for (int i = 0; i <= 5; i++) {
			this.list.add(Boolean.TRUE);
		}
		this.model = new LazyModelDocumentos(this.documentoService);
		this.mapaEdicion = new HashMap<>();
	}

	/**
	 * Reseteo del objeto de búsqueda y limpieza de la lista de resultados.
	 */
	public void limpiarBusqueda() {
		this.documentoBusqueda = new DocumentoBusqueda();
		this.model.setRowCount(0);
	}

	/**
	 * Graba el documento modificado.
	 */
	public void modificaDocumento() {
		try {
			this.documentoService.save(this.documento);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, "MODIFCARE",
					"Documentul a fost modificat");
			this.recargaLista();
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, "MODIFCARE",
					"A apărut o eroare la modificarea documentului");
		}
	}

	/**
	 * Inicia la creación de un nuevo documento.
	 * @return ruta de la vista
	 */
	public String nuevoDocumento() {
		this.documento = new Documento();
		this.nombreDoc = "";
		return "/gestorDocumental/nuevoDocumento?faces-redirect=true";
	}

	/**
	 * Muestra/oculta las columnas de la tabla de resultados de la búsqueda.
	 *
	 * @param e La columna a mostrar/ocultar
	 */
	public void onToggle(final ToggleEvent e) {
		this.list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Recarga la lista de resultados no eliminados.
	 */
	public void recargaLista() {
		this.documentoBusqueda.setEliminado(false);
		this.buscaDocumento();

	}

	/**
	 * Recarga la lista de resultados eliminados.
	 */
	public void recargaListaEliminados() {
		this.documentoBusqueda.setEliminado(true);
		this.buscaDocumento();
	}

	/**
	 * Recupera un documento desde la papelera.
	 * @param doc Documento a recuperar
	 */
	public void recuperarDocumento(final Documento doc) {
		try {
			this.documentoService.recuperarDocumento(doc);
			this.buscaDocumento();
		}
		catch (final DataAccessException e) {
		}

	}

	/**
	 * Resetea el objeto de búsqueda, limpia la lista de resultados y establece el booleano de eliminado a false para
	 * indicar que sólo se van a buscar documentos no eliminados.
	 * @return ruta siguiente
	 */
	public String resetBusqueda() {
		this.documentoBusqueda = new DocumentoBusqueda();
		this.model.setRowCount(0);
		this.nombreDoc = "";
		this.documentoBusqueda.setEliminado(false);
		return "/gestorDocumental/buscarDocumento?faces-redirect=true";
	}

	/**
	 * Resetea el objeto de búsqueda, limpia la lista de resultados y establece el booleano de eliminado a false para
	 * indicar que sólo se van a buscar documentos eliminados.
	 * @return ruta
	 */
	public String resetBusquedaEliminados() {
		this.nombreDoc = "";
		this.documentoBusqueda.setEliminado(true);
		this.buscaDocumento();
		return "/administracion/papelera/papelera?faces-redirect=true";

	}

	/**
	 * Vacía la papelera de reciclaje.
	 */
	public void vaciarPapelera() {
		try {
			final List<Documento> documentosEliminados = this.documentoService.vaciarPapelera();
			final StringBuffer nombreFicherosEliminados = new StringBuffer().append("\n\n");
			for (final Documento docu : documentosEliminados) {
				nombreFicherosEliminados.append('-').append(docu.getNombre()).append("\n");
			}
			this.buscaDocumento();
		}
		catch (final DataAccessException e) {
		}
	}

}

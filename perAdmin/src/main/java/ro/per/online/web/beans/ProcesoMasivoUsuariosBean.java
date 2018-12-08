package ro.per.online.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionException;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.jsf.scope.FacesViewScope;
import ro.per.online.lazydata.LazyDataUsers;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.SeccionesEnum;
import ro.per.online.services.OperacionMasivaFicheroService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;

/**
 * Driver pentru prelucrarea masivă a utilizatorilor.
 * @author STAD
 */

@Getter
@Setter
@Controller("procesoMasivoBean")
@Scope(FacesViewScope.NAME)
public class ProcesoMasivoUsuariosBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7449854572833321412L;

	/**
	 * Clasă pentru căutarea de utilizatori.
	 */
	private UsuarioBusqueda usuarioBusqueda;

	/**
	 * Serviciu de users.
	 */
	@Autowired
	private transient UserService usuarioService;

	/**
	 * Servicio de operaciones masivas.
	 */
	@Autowired
	private transient OperacionMasivaFicheroService operacionMasivaFicheroService;

	/**
	 * Clase de utilidades para mensajes.
	 */
	@Autowired
	private transient FacesUtilities facesUtilities;

	/**
	 * Componente de utilidades.
	 */
	@Autowired
	private transient Utilities utilities;

	/**
	 * Número máximo de columnas visibles en la vista.
	 */
	private int numeroColumnasListadoUsuarios = 17;

	/**
	 * LazyModel para la paginación desde servidor de los datos de la búsqueda de usuarios.
	 */
	private LazyDataUsers model;

	/**
	 * Lista de booleanos para el control de la visualización de columnas en la vista.
	 */
	private List<Boolean> list;

	/**
	 * Variable usada para mostrar o no la tabla de resultados de la búsqueda.
	 */
	private boolean mostrarTabla;

	/**
	 * Contexto actual.
	 */
	private transient ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

	/**
	 * Indica si es borrado masivo o bloqueo masivo.
	 */
	private String esBorradoMasivo;

	/**
	 * Indica el título de la página.
	 */
	private String titulo;

	/**
	 * Indica el nombre de la plantillaDescarga.
	 */
	private String plantillaDescarga;

	/**
	 * Objeto que contendrá el fichero a descargar.
	 */
	private transient StreamedContent file;

	/**
	 * Lista de usuarios seleccionados para procesar (set para que no haya usuarios repetidos).
	 */
	private Set<Users> listaUsuariosSeleccionados;

	/**
	 * Inicializa las variables necesarias del controlador.
	 */
	@PostConstruct
	public void init() {
		final HttpServletRequest req = (HttpServletRequest) context.getRequest();
		esBorradoMasivo = String.valueOf(req.getParameter("esBorrado"));
		plantillaDescarga = Constantes.PLANTILLAALTA;
		usuarioBusqueda = new UsuarioBusqueda();
		usuarioBusqueda.setUsuariosSeleccionados(new ArrayList<>());
		listaUsuariosSeleccionados = new HashSet<>();
		model = new LazyDataUsers(usuarioService);
		setList(utilities.listaTrue(numeroColumnasListadoUsuarios));
		preparPantallaPorOperacion();
	}

	/**
	 * Establece el título de la página.
	 */
	public void preparPantallaPorOperacion() {
		if (Constantes.TRUE.equals(esBorradoMasivo)) {
			titulo = "Ștergerea masivă a membrilor";
		}
		else if (Constantes.FALSE.equals(esBorradoMasivo)) {
			titulo = "Blocarea masivă a membrilor";
			usuarioBusqueda.setValidated(true);
		}
		else {
			titulo = "Înregistrarea masivă a membrilor";
		}
	}

	/**
	 * Busca usuarios a través de los datos introducidos en el filtro.
	 */
	public void buscarUsuarios() {
		model.setUserBusqueda(usuarioBusqueda);
		mostrarTabla = true;
	}

	/**
	 * Borra los resultados de búsquedas anteriores.
	 */
	public void limpiarBusqueda() {
		usuarioBusqueda = new UsuarioBusqueda();
		mostrarTabla = false;
	}

	/**
	 * Ejecuta la operación al pulsar el botón. Se ejecutará una cosa u otra dependiendo de la operación seleccionada.
	 */
	public void procesarUsuarios() {
		if (Boolean.valueOf(esBorradoMasivo)) {
			bajaLogicaMasiva();
		}
		else {
			bloqueoMasivo();
		}
	}

	/**
	 * Bloquea los usuarios indicados en la lista.
	 */
	private void bloqueoMasivo() {

		try {
			final List<String> listaSeleccionados = validarListaSeleccionados(listaUsuariosSeleccionados);
			if (!listaSeleccionados.isEmpty()) {
				usuarioService.desactivar(listaSeleccionados);
				final String mensaje = "Membrii prezenți în listă au fost blocați cu succes.";
				utilities.procesarResultadoOperacion(Constantes.USUARIOSMASIVOS, "DEZACTIVARE", mensaje,
						Constantes.PROCESOMASIVO, SeccionesEnum.ADMINISTRACION, facesUtilities);
			}
		}
		catch (final TransactionException te) {
			utilities.procesarExcepcion(te, SeccionesEnum.OTROS, "blochează utilizatorii masiv", facesUtilities);
		}
	}

	/**
	 * Valida la lista de usuarios seleccionados para que no se procese una lista vacía.
	 * @param setSeleccionados set de usuarios seleccionados
	 * @return lista de usuarios seleccionados
	 */
	private List<String> validarListaSeleccionados(final Set<Users> setSeleccionados) {
		if (listaUsuariosSeleccionados == null || listaUsuariosSeleccionados.isEmpty()) {
			facesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR, "Membri selectați",
					"Trebuie să selectați cel puțin un membru din listă pentru a procesa operația masivă.",
					Constantes.IDMENSAJEGLOBAL);
		}
		return new ArrayList<>(
				setSeleccionados.stream().map(Users::getUsername).collect(Collectors.toCollection(ArrayList::new)));
	}

	/**
	 * Da de baja a los usuarios indicados en la lista.
	 */
	private void bajaLogicaMasiva() {
		try {
			final List<String> listaSeleccionados = validarListaSeleccionados(listaUsuariosSeleccionados);
			if (!listaSeleccionados.isEmpty()) {
				usuarioService.bajaLogica(listaSeleccionados);
				final String mensaje = "Membrii prezenți în listă au fost eliminați cu succes.";
				utilities.procesarResultadoOperacion(Constantes.USUARIOSMASIVOS, "ELIMINARE", mensaje,
						Constantes.PROCESOMASIVO, SeccionesEnum.OTROS, facesUtilities);
			}
		}
		catch (final TransactionException te) {
			utilities.procesarExcepcion(te, SeccionesEnum.OTROS, "eliminare masivă a membrilor", facesUtilities);
		}
	}

	/**
	 * Método para añadir nuevos usuarios a la lista de usuarios seleccionados.
	 */
	public void aniadirUsuariosCambioPaginaTabla() {

		if (usuarioBusqueda.getUsuariosSeleccionados() != null
				&& !usuarioBusqueda.getUsuariosSeleccionados().isEmpty()) {
			listaUsuariosSeleccionados.addAll(usuarioBusqueda.getUsuariosSeleccionados());
			usuarioBusqueda.setUsuariosSeleccionados(new ArrayList<>(listaUsuariosSeleccionados));
		}
	}

	/**
	 * Método que borra el usuario desmarcado de la lista de usuarios seleccionados.
	 * @param event evento lanzado al desmarcar un usuario de la tabla.
	 */
	public void checkDesmarcado(final UnselectEvent event) {
		final Users usuario = (Users) event.getObject();
		listaUsuariosSeleccionados.remove(usuario);
		model.setDataSource(listaUsuariosSeleccionados);
	}

	/**
	 * Añade un usuario a la lista de usuarios seleccionados.
	 * @param event evento lanzado al seleccionar un usuario de la tabla
	 */
	public void checkSeleccionado(final SelectEvent event) {
		final Users usuario = (Users) event.getObject();
		listaUsuariosSeleccionados.add(usuario);
		model.setDataSource(listaUsuariosSeleccionados);
	}

	/**
	 * Método que capura el evento "Seleccionar todos" o "Deseleccionar todos" en la vista de alertas.
	 * @param toogleEvent evento que se lanza al marcar/desmarcar la opción "Seleccionar todos".
	 */
	public void checkSeleccionarTodos(final ToggleSelectEvent toogleEvent) {
		if (toogleEvent.isSelected()) {
			listaUsuariosSeleccionados = new HashSet<>(usuarioService.buscarUsuario(usuarioBusqueda));
		}
		else {
			listaUsuariosSeleccionados = new HashSet<>();
		}
		model.setDataSource(listaUsuariosSeleccionados);
		usuarioBusqueda.setUsuariosSeleccionados(new ArrayList<>(listaUsuariosSeleccionados));
	}

	/**
	 * Método para descargar una plantillaDescarga excel para la carga masiva de usuarios.
	 * @param plantilla a descargar
	 */
	public void descargarPlantillaMasivaUsuarios() {
		final String plantilla = Constantes.PLANTILLAALTA;
		try {
			setFile(utilities.descargarFichero("/static/ficheros/" + plantilla,
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", plantilla));
		}
		catch (final IOException e) {
			facesUtilities.setMensajeError("A apărut o eroare la descărcarea șablonului.", Constantes.IDMENSAJEGLOBAL);
		}
	}

	/**
	 * Guarda los usuariosque aparecen en el fichero excel cargado en la aplicación siempre que sean correctos.
	 * @param event evento de carga
	 */
	public void cargaFicheroUsuarios(final FileUploadEvent event) {
		operacionMasivaFicheroService.procesarOperacionMasivaFichero(event, "ÎNREGISTRARE",
				"Înregistrare membrii masiv.");

	}

	/**
	 * Bloquea el acceso a los usuarios que aparezcan en el fichero excel cargado en la aplicación.
	 * @param event evento de carga
	 */
	public void bloqueoFicheroUsuarios(final FileUploadEvent event) {
		operacionMasivaFicheroService.procesarOperacionMasivaFichero(event, "DEZACTIVARE",
				"executând blocarea în masă a utilizatorilor.");
	}

	/**
	 * Borra de manera lógica los usuarios que aparezcan en el fichero excel cargado en la aplicación.
	 * @param event evento de carga
	 */
	public void borradoFicheroUsuarios(final FileUploadEvent event) {
		operacionMasivaFicheroService.procesarOperacionMasivaFichero(event, "ELIMINARE",
				"executând eliminarea logică în masă a utilizatorilor.");
	}
}

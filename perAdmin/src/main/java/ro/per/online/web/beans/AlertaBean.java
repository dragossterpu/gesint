package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;
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
import ro.per.online.lazydata.LazyDataAlertas;
import ro.per.online.lazydata.LazyDataUsers;
import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.PersonalData;
import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.TipoDocumento;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.AlertChannelEnum;
import ro.per.online.persistence.entities.enums.SeccionesEnum;
import ro.per.online.persistence.entities.enums.TipoRegistroEnum;
import ro.per.online.services.AlertaService;
import ro.per.online.services.DocumentoService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.RegistroActividadService;
import ro.per.online.services.TeamService;
import ro.per.online.services.UserService;
import ro.per.online.services.impl.RegistroActividadServiceImpl;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;

/**
 * Controlador de las operaciones relacionadas con la gestión de alertas.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("alertaBean")
@Scope(Constantes.SESSION)
public class AlertaBean implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Numero de columnas de la tabla de alertas.
	 */
	private static final int NUMBERCOLUMNASTABLA = 4;

	/**
	 * Alerta nueva.
	 */
	private transient Alerta alerta;

	/**
	 * Service de alertas.
	 */
	@Autowired
	private transient AlertaService alertaService;

	/**
	 * Service de usuarios.
	 */
	@Autowired
	private transient UserService usuarioService;

	/**
	 * Lazy model para las usuarios.
	 */
	private transient LazyDataUsers modelUser;

	/**
	 * Clase de búsqueda de usuarios.
	 */
	private UsuarioBusqueda usuarioBusqueda;

	/**
	 * Clase de búsqueda de alertas.
	 */
	private AlertaBusqueda alertaBusqueda;

	/**
	 * LazyModel para la visualización paginada de datos en la vista.
	 */
	private LazyDataAlertas model;

	/**
	 * Listado de alertas por usuario.
	 */
	private List<Alerta> lstAlertas;

	/**
	 * Usuario que se esta modificando en el momento.
	 */
	private Alerta alertaActual;

	/**
	 * Indica qué colomnas aparecen en el listado.
	 */
	private List<Boolean> list;

	/**
	 * Lista de usuarios seleccionados.
	 */
	private List<Users> usuariosSeleccionados;

	/**
	 * Lista de usuarios seleccionados.
	 */
	private List<Users> usuariosSeleccionadosFinales;

	/**
	 * Nombre de usuario que se usará para mandar el correo a un único destinatario.
	 */
	private String nombreUsuario = Constantes.ESPACIO;

	/**
	 * Indica si se quiere buscar por datos de usuario (opción 1) o datos de expediente (opción 2).
	 */
	private Integer opcion = 1;

	/**
	 * Lista numelor din echipa de conducere.
	 */
	private List<Team> listaTeams;

	/**
	 * Variala utilizata pentruinjectarea serviciului de team.
	 *
	 */
	@Autowired
	private transient TeamService teamService;

	/**
	 * Servicio de registro de actividad.
	 */
	@Autowired
	private transient RegistroActividadServiceImpl registroActividadService;

	/**
	 * Objeto de búsqueda de usuario.
	 */
	private Team team;

	private Integer numarMembrii;

	/**
	 * Lista de judete.
	 */
	private List<PProvince> provinces;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private ProvinceService provinceService;

	/**
	 * Variabila utilizata pentru a recupera emailul unor utilizatori externi.
	 *
	 */
	private String utilizatorExtern;

	/**
	 * Lista de tipos de documentación asociados a la solicitud.
	 */
	private List<Documento> listadoDocumentos;

	/**
	 * Servicio de documentos.
	 */
	@Autowired
	private transient DocumentoService documentoService;

	/**
	 * Mapa con las extensiones de archivo aceptadas en el sistema.
	 */
	private Map<String, String> extensiones;

	/**
	 * Servicio del registro de actividad.
	 */
	@Autowired
	private transient RegistroActividadService regActividadService;

	/**
	 * Bean de datos comunes de la aplicación.
	 */
	@Autowired
	private transient ApplicationBean applicationBean;

	/**
	 * Archivo siendo subido o descargado.
	 */
	private transient StreamedContent file;

	/**
	 * Lista documentos cargados .
	 */
	private List<Documento> documentosCargados;

	/**
	 * Abre el diálogo para búsqueda de usuarios.
	 */
	public void abrirDialogoBusquedaUsuarios() {
		this.team = new Team();
		this.modelUser = new LazyDataUsers(this.usuarioService);
		this.opcion = 2;
		this.provinces = this.provinceService.fiindAll();
		this.listaTeams = this.teamService.fiindByTeam();
		this.numarMembrii = this.listaTeams.size();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgBusqueda').show();");
	}

	/**
	 * Deschide dialogul pentru incarcarea documentelor.
	 */
	public void abrirDialogoCargaDoc() {
		this.documentosCargados = new ArrayList();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgCargaDoc').show();");
	}

	/**
	 * Busca la alerta en el array local de alertas.
	 * @param id Long
	 * @return Alerta
	 */
	private Alerta buscarAlertaEnLocal(final Long id) {
		Alerta result = null;
		for (final Alerta alertaLocal : this.lstAlertas) {
			if (alertaLocal.getId() == id) {
				result = alertaLocal;
				break;
			}
		}
		return result;
	}

	/**
	 * Busca alertas en base al filtro de búsqueda.
	 */
	public void buscarAlertas() {
		this.model.setBusqueda(this.alertaBusqueda);
		this.model.load(0, Constantes.TAMPAGINA, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
	}

	/**
	 * Busca usuarios en base a un filtro.
	 */
	public void buscarUsuarios() {
		if (this.opcion == 1) {
			this.modelUser.setUserBusqueda(this.usuarioBusqueda);
			this.modelUser.load(0, Constantes.TAMPAGINA, "dateCreate", SortOrder.DESCENDING, null);
		}
		else if (this.opcion == 2) {
			this.listaTeams = this.teamService.fiindByTeam();
			this.numarMembrii = this.listaTeams.size();
		}
	}

	/**
	 * Devuelve un listado de alertas por el correo del usuario.
	 * @param usuario User
	 * @return List<Alerta>
	 */
	public List<Alerta> cargarListaAlertas(final Users usuario) {
		this.lstAlertas = this.alertaService.buscarAlertasPorUsuario(usuario);
		return this.lstAlertas;
	}

	/**
	 * Borra la alerta actual que se esta visualizando.
	 */
	public void clearAlerta() {
		this.alertaActual = null;
	}

	/**
	 * Carga alerta por el identificador.
	 * @param alertaLocal Alerta
	 */
	public void detalleAlerta(final Alerta alertaLocal) {
		this.alertaActual = this.buscarAlertaEnLocal(alertaLocal.getId());
	}

	/**
	 * Envia alerta a los usuarios indicados.
	 */
	public Date enviarAlerta() {
		Date fechaEnvio = null;
		try {
			if (this.usuariosSeleccionadosFinales.isEmpty()) {
				Users usuario = this.usuarioService.fiindOne(this.nombreUsuario);
				if (usuario == null) {
					usuario = new Users();
					final PersonalData pd = new PersonalData();
					pd.setAlertChannel(AlertChannelEnum.EMAIL);
					usuario.setPersonalData(pd);
					usuario.setUsername(this.nombreUsuario);
				}
				this.usuariosSeleccionadosFinales.add(usuario);
			}
			this.alertaService.sendAlert(this.alerta, this.usuariosSeleccionadosFinales);
			this.registroActividadService.guardarRegistroAltaModificacion(this.alerta.getId(),
					this.alerta.getDescripcion(), SeccionesEnum.ALERTAS.name(), Constantes.DELAALERTA);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
					"Alerta a fost trimisă corect.");
			this.limpiarCamposNuevaAlerta();
			fechaEnvio = new Date();
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la trimiterea avertizării, încercați din nou mai târziu");
			this.registroActividadService.guardarRegistroError(SeccionesEnum.ALERTAS.name(), Constantes.ALERTA, e);
		}
		return fechaEnvio;
	}

	/**
	 * Envia la alerta a un usuario en especifico.
	 * @param usuario User
	 */
	public void enviarAlertaUsuario(final Users usuario) {
		try {
			this.alertaService.sendAlertUsuario(this.alerta, usuario);
			this.registroActividadService.guardarRegistroAltaModificacion(this.alerta.getId(),
					this.alerta.getDescripcion(), SeccionesEnum.ALERTAS.name(), Constantes.DELAALERTA);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
					"La alerta se ha enviado correctamente.");
			this.limpiarDatosCambiarPestana();
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"Se ha producido un error al enviar la alerta, inténtelo de nuevo más tarde");
			this.registroActividadService.guardarRegistroError(SeccionesEnum.ALERTAS.name(), Constantes.ALERTA, e);
		}
	}

	/**
	 * Entra en la pantalla de enviar nueva alerta.
	 * @return String
	 */
	public String enviarAlertaUsuarios() {
		this.alerta = new Alerta();
		this.usuariosSeleccionados = new ArrayList<>();
		this.usuariosSeleccionadosFinales = new ArrayList<>();
		this.modelUser = new LazyDataUsers(this.usuarioService);
		return "/alertas/nuevaAlerta?faces-redirect=true";
	}

	/**
	 * Comprueba si un archivo se corresponde con alguno de los documentos solicitados tanto en nombre como en
	 * extensión.
	 * @param archivo subido
	 * @return booleano si o no
	 */
	private boolean esDocumentacion(final UploadedFile archivo) {
		final String nombreArchivo = archivo.getFileName();
		boolean esValido = false;
		esValido = nombreArchivo.toLowerCase().startsWith(archivo.getFileName().toLowerCase());
		return esValido;
	}

	/**
	 * Método para establecer los usuarios en el listado general.
	 */
	public void establecerUsuariosFinales() {
		if (this.opcion == 2) {
			for (final Users user : this.usuariosSeleccionadosFinales) {
				user.getUsername();
				if (!this.usuariosSeleccionadosFinales.contains(user)) {
					this.usuariosSeleccionadosFinales.add(user);
				}
			}
		}
		else if (this.opcion == 3) {
			final Users usuarioExterno = new Users();
			usuarioExterno.setUsername("Utilizator extern");
			this.usuariosSeleccionadosFinales.add(usuarioExterno);
		}
	}

	/**
	 * Guarda un archivo subido por el usuario como documento de la solicitud, tras validar que no es un archivo
	 * corrupto y que encaja con alguno de los solicitados.
	 * @param event lanzado desde el formulario
	 * @return ruta de la vista
	 */
	public String gestionarCargaDocumento(final FileUploadEvent event) {
		try {
			final UploadedFile archivo = event.getFile();
			// 19 es el id del tipodocumento para "template"
			final TipoDocumento tipo = TipoDocumento.builder().id(19L).build();
			final Users usuario = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (this.esDocumentacion(archivo)) {
				final Documento documento = this.documentoService.cargaDocumento(archivo, tipo, usuario);
				this.documentosCargados.add(documento);
				// if (opcion == 3) {
				// alerta.setDestinatario(utilizatorExtern);
				// }
				// alerta.setDateCreate(new Date());
				// alerta.setUserCreate(usuario.getUsername());
				// List<Documento> documentos = new ArrayList();
				// documentos.add(documento);
				// List<Users> users = usuariosSeleccionadosFinales;
				// String destinatario = "";
				// for (final Users usu : users) {
				// destinatario.concat(usu.getUsername().concat(","));
				// }
				// alerta.setDestinatario(destinatario);
				// alerta.setDocumentos(documentos);
				// alerta = alertaService.save(alerta);
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constantes.ALTA,
						"Document/e încărcat cu succes", "msgs");
			}
			else {
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR, "Încărcarea fișierelor",
						"Fișierul " + archivo.getFileName()
								+ " nu este valabil, numele sau extensia nu corespunde cu documentul încărcat.",
						"msgs");
			}
		}

		catch (DataAccessException |

				PerException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, TipoRegistroEnum.EROARE.name(),
					"A apărut o eroare la încărcarea documentului, încercați din nou mai târziu");
			final String descripcion = "A apărut o eroare la încărcarea documentului";
			this.regActividadService.guardarRegistroError(descripcion, SeccionesEnum.GESTORDOCUMENTAL.getDescripcion(),
					e);
		}
		return "/alertas/cargaDocumentos";
	}

	/**
	 * Método init de AlertaBean.
	 */
	@PostConstruct
	public void init() {
		this.alerta = new Alerta();
		this.alertaBusqueda = new AlertaBusqueda();
		this.usuarioBusqueda = new UsuarioBusqueda();
		this.team = new Team();
		this.numarMembrii = 0;
		this.provinces = new ArrayList();
		this.listaTeams = new ArrayList();
		this.list = new ArrayList<>();
		for (int i = 0; i < NUMBERCOLUMNASTABLA; i++) {
			this.list.add(Boolean.TRUE);
		}
		this.model = new LazyDataAlertas(this.alertaService);
		this.buscarAlertas();
		Utilities.limpiarSesion("alertaBean");
	}

	/**
	 * Limpia el buscador de usuarios por datos y el de por expedientes.
	 */
	public void limpiarBuscadores() {
		this.usuarioBusqueda = new UsuarioBusqueda();
		this.usuariosSeleccionados = new ArrayList<>();
		this.modelUser = new LazyDataUsers(this.usuarioService);
	}

	/**
	 * Limpia la búsqueda del filtro.
	 */
	public void limpiarBusqueda() {
		this.alertaBusqueda = new AlertaBusqueda();
		this.model = new LazyDataAlertas(this.alertaService);
	}

	/**
	 * Limpia los campos de usuarios seleccionados y la lista de usuarios.
	 */
	public void limpiarCamposNuevaAlerta() {
		this.usuariosSeleccionados = new ArrayList<>();
		this.alerta = new Alerta();
		this.usuariosSeleccionadosFinales = new ArrayList<>();
		this.modelUser = new LazyDataUsers(this.usuarioService);
	}

	/**
	 * Limpia los datos de la pestaña de envio alertas.
	 */
	private void limpiarDatosCambiarPestana() {
		this.alerta.setAsunto(null);
		this.alerta.setDescripcion(null);
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogMessage').hide()");
	}

	/**
	 * Muestra el cuadro de dialogo de alertas con la alerta actual.
	 * @param a Alerta
	 */
	public void mostrarDialogoAlertaConDetalle(final Alerta a) {
		this.alertaActual = a;
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogAlertas').show();");
	}

	/**
	 * Muestra el cuadro de dialogo de alertas.
	 */
	public void mostrarDialogoAlertas() {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogAlertas').show();");
	}

	/**
	 * Método para añadir nuevos usuarios a la lista de usuarios seleccionados.
	 */
	public void onChangePageUsuarios() {
		if ((this.usuariosSeleccionados != null) && !this.usuariosSeleccionados.isEmpty()) {
			this.usuariosSeleccionadosFinales.addAll(this.usuariosSeleccionados);
			this.usuariosSeleccionados = new ArrayList<>(this.usuariosSeleccionadosFinales);
		}
	}

	/**
	 * Método que asocia un usuario al seleccionar su checkbox.
	 * @param event evento lanzado que contiene la inspección
	 */
	public void onRowSelectedUser(final SelectEvent event) {
		if (this.opcion == 1) {
			final Users i = (Users) event.getObject();
			this.usuariosSeleccionadosFinales.add(i);
			this.modelUser.setDatasource(this.usuariosSeleccionadosFinales);
		}
		else {
			final Team team = (Team) event.getObject();
			this.usuariosSeleccionadosFinales.add(team.getUser());
			this.modelUser.setDatasource(this.usuariosSeleccionadosFinales);
		}
	}

	/**
	 * Método que desasocia un usuario al deseleccionar su checkbox.
	 * @param event evento lanzado que contiene la inspección.
	 */
	public void onRowUnSelectedUser(final UnselectEvent event) {
		if (this.opcion == 1) {
			final Users us = (Users) event.getObject();
			this.usuariosSeleccionadosFinales.remove(us);
			this.modelUser.setDatasource(this.usuariosSeleccionadosFinales);
		}
		else {
			final Team team = (Team) event.getObject();
			this.usuariosSeleccionadosFinales.remove(team.getUser());
			this.modelUser.setDatasource(this.usuariosSeleccionadosFinales);
		}
	}

	/**
	 * Método que desasocia un usuario al deseleccionar su checkbox.
	 * @param event evento lanzado que contiene usuario
	 */
	public void onRowUnSelectedUsu(final UnselectEvent event) {
		final Users usu = (Users) event.getObject();
		this.usuariosSeleccionadosFinales.remove(usu);
		this.modelUser.setDatasource(this.usuariosSeleccionadosFinales);
	}

	/**
	 *
	 * Controla las columnas visibles en la lista de resultados del buscador.
	 *
	 * @param e ToggleEvent
	 *
	 */
	public void onToggle(final ToggleEvent e) {
		this.list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Método que capura el evento "Seleccionar todos" o "Deseleccionar todos" en la vista de alertas.
	 * @param toogleEvent ToggleSelectEvent
	 */
	public void onToggleSelectUsers(final ToggleSelectEvent toogleEvent) {
		if (toogleEvent.isSelected()) {
			this.usuariosSeleccionadosFinales = new ArrayList<>(
					this.usuarioService.buscarUsuarioCriteria(this.usuarioBusqueda));
		}
		else {
			this.usuariosSeleccionadosFinales = new ArrayList<>();
		}
		this.modelUser.setDatasource(this.usuariosSeleccionadosFinales);
		this.usuariosSeleccionados = new ArrayList<>(this.usuariosSeleccionadosFinales);
	}

	/**
	 * Elimina a un usuario de la lista de usuarios seleccionados para recibir la alerta.
	 * @param usuario User
	 */
	public void quitarUsuario(final Users usuario) {
		this.usuariosSeleccionadosFinales.remove(usuario);
		final List<Users> usuariosBorrar = new ArrayList<>();
		for (final Users usu : this.usuariosSeleccionadosFinales) {
			if (usu.getUsername().equals(usuario.getUsername())) {
				usuariosBorrar.add(usu);
			}
		}
		this.usuariosSeleccionadosFinales.removeAll(usuariosBorrar);
	}
}

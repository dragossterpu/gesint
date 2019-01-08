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
import ro.per.online.constantes.NumeroMagic;
import ro.per.online.exceptions.PerException;
import ro.per.online.lazydata.LazyDataAlertas;
import ro.per.online.lazydata.LazyDataUsers;
import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.TipoDocumento;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.AlertChannelEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.RoleEnum;
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
 * Controlorul operațiunilor legate de gestionarea alertelor.
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
	private static final long serialVersionUID = NumeroMagic.NUMBERONELONG;

	/**
	 * Numărul de coloane din tabelul de alerte.
	 */
	private static final int NUMBERCOLUMNASTABLA = NumeroMagic.NUMBERFIVE;

	/**
	 * Alerta noua.
	 */
	private transient Alerta alerta;

	/**
	 * Variala utilizata pentru injectarea serviciului de alerte.
	 */
	@Autowired
	private transient AlertaService alertaService;

	/**
	 * Variala utilizata pentru injectarea serviciului de utilizatori.
	 */
	@Autowired
	private transient UserService usuarioService;

	/**
	 * Lazy model pentru utilizatori.
	 */
	private transient LazyDataUsers modelUser;

	/**
	 * Clasa de căutare a utilizatorilor.
	 */
	private UsuarioBusqueda usuarioBusqueda;

	/**
	 * Clasa de căutare a alertelor.
	 */
	private AlertaBusqueda alertaBusqueda;

	/**
	 * LazyModel pentru afișarea paginată a datelor din vizualizare.
	 */
	private LazyDataAlertas model;

	/**
	 * Listă de alerte per utilizator.
	 */
	private List<Alerta> lstAlertas;

	/**
	 * Utilizator care se modifică în acest moment.
	 */
	private Alerta alertaActual;

	/**
	 * Indicați ce colomne apar în listă.
	 */
	private List<Boolean> list;

	/**
	 * Lista utilizatorilor selectați.
	 */
	private List<Users> usuariosSeleccionados;

	/**
	 * Lista utilizatorilor externi selectați.
	 */
	private List<Users> usuariosExternosSeleccionados;

	/**
	 * Lista utilizatorilor selectați final.
	 */
	private List<Users> usuariosSeleccionadosFinales;

	/**
	 * Numele de utilizator care va fi folosit pentru a trimite e-mailul unui singur destinatar.
	 */
	private String nombreUsuario = Constantes.ESPACIO;

	/**
	 * Indicați dacă doriți să căutați după echipa de conducere (opțiunea 1), membrii (opțiunea 2) sau destinatari
	 * externi (opțiunea 3)
	 */
	private Integer opcion = 1;

	/**
	 * Lista numelor din echipa de conducere.
	 */
	private List<Team> listaTeams;

	/**
	 * Variala utilizata pentru injectarea serviciului pentru echipa de conducere.
	 *
	 */
	@Autowired
	private transient TeamService teamService;

	/**
	 * Variala utilizata pentru injectarea serviciului înregistrare a activității.
	 */
	@Autowired
	private transient RegistroActividadServiceImpl registroActividadService;

	/**
	 * Obiectul echipei de conducere.
	 */
	private Team team;

	/**
	 * Numar de membri
	 */
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
	 * Lista de documente asociate cererii.
	 */
	private List<Documento> listadoDocumentos;

	/**
	 * Serviciul de documente.
	 */
	@Autowired
	private transient DocumentoService documentoService;

	/**
	 * Extensiile de fișier acceptate în sistem..
	 */
	private Map<String, String> extensiones;

	/**
	 * Serviciul de înregistrare a activității.
	 */
	@Autowired
	private transient RegistroActividadService regActividadService;

	/**
	 * Bean de date comune de aplicatie.
	 */
	@Autowired
	private transient ApplicationBean applicationBean;

	/**
	 * Fișier încărcat sau descărcat.
	 */
	private transient StreamedContent file;

	/**
	 * Lista documentelor încărcate.
	 */
	private List<Documento> documentosCargados;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private UserService userService;

	/**
	 * Deschideți dialogul pentru căutarea utilizatorilor.
	 */
	public void abrirDialogoBusquedaUsuarios() {
		this.team = new Team();
		this.modelUser = new LazyDataUsers(this.usuarioService);
		this.opcion = NumeroMagic.NUMBERTWO;
		this.provinces = this.provinceService.fiindAll();
		this.listaTeams = this.teamService.fiindByTeam();
		this.numarMembrii = this.listaTeams.size();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute(Constantes.DIALOGBUSQUEDASHOW);
	}

	/**
	 * Deschide dialogul pentru incarcarea documentelor.
	 */
	public void abrirDialogoCargaDoc() {
		this.documentosCargados = new ArrayList<>();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgCargaDoc').show();");
	}

	/**
	 * Găsiți alerta din matricea de alertă locală.
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
	 * Căutați alerte pe baza filtrului de căutare.
	 */
	public void buscarAlertas() {
		this.model.setBusqueda(this.alertaBusqueda);
		this.model.load(0, NumeroMagic.NUMBERFIFTEEN, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
	}

	/**
	 * Căutați utilizatori pe baza unui filtru.
	 */
	public void buscarUsuarios() {
		if (this.opcion == NumeroMagic.NUMBERONE) {
			this.modelUser.setUserBusqueda(this.usuarioBusqueda);
			this.modelUser.load(0, NumeroMagic.NUMBERFIFTEEN, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
		}
		else if (this.opcion == NumeroMagic.NUMBERTWO) {
			this.listaTeams = this.teamService.fiindByTeam();
			this.numarMembrii = this.listaTeams.size();
		}
	}

	// /**
	// * Returnează o listă de alerte cu e-mail-ul utilizatorului.
	// * @param usuario User
	// * @return List<Alerta>
	// */
	// public List<Alerta> cargarListaAlertas(final Users usuario) {
	// this.lstAlertas = this.alertaService.buscarAlertasPorUsuario(usuario);
	// return this.lstAlertas;
	// }

	/**
	 * Șterge alerta curentă care este vizionată.
	 */
	public void clearAlerta() {
		this.alertaActual = null;
	}

	/**
	 * Încarcă alerta cu identificator ei.
	 * @param alertaLocal Alerta
	 */
	public void detalleAlerta(final Alerta alertaLocal) {
		this.alertaActual = this.buscarAlertaEnLocal(alertaLocal.getId());
	}

	/**
	 * Trimiteți alerte destinatarilor indicați.
	 */
	public Date enviarAlerta() {
		Date fechaEnvio = null;
		try {
			if (this.usuariosSeleccionadosFinales.isEmpty()) {
				Users usuario = this.usuarioService.fiindOne(this.nombreUsuario);
				if (usuario == null) {
					usuario = new Users();
					usuario.setAlertChannel(AlertChannelEnum.EMAIL);
					usuario.setUsername(this.nombreUsuario);
				}
				this.usuariosSeleccionadosFinales.add(usuario);
			}
			this.alertaService.sendAlert(this.alerta, this.usuariosSeleccionadosFinales);
			this.registroActividadService.guardarRegistroAltaModificacion(this.alerta.getId(),
					this.alerta.getDescripcion(), SeccionesEnum.ALERTAS.name(), Constantes.DELAALERTA);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
					"Alerta/Comunicarea a fost trimisă corect.");
			this.limpiarBuscadores();
			fechaEnvio = new Date();
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la trimiterea Alertei/Comunicării ".concat(Constantes.DESCERRORMENSAJE));
			this.registroActividadService.guardarRegistroError(SeccionesEnum.ALERTAS.name(), Constantes.ALERTA, e);
		}
		return fechaEnvio;
	}

	/**
	 * Salvati alerta in baza de date.
	 */
	public Date guardarAlerta() {
		final Date fechaEnvio = null;
		try {
			if (!this.usuariosSeleccionadosFinales.isEmpty()) {
				alerta.setListDestinatarios(usuariosSeleccionadosFinales);
				if (!this.documentosCargados.isEmpty()) {
					alerta.setDocumentos(documentosCargados);
				}
				alerta.setAsunto(this.alerta.getAsunto());
				alerta.setChannel(AlertChannelEnum.EMAIL);
				alerta.setDescripcion(this.alerta.getDescripcion());
				if (this.alerta.getAutomatic()) {
					alerta.setAutomatic(this.alerta.getAutomatic());
					alerta.setFechaEnvio(this.alerta.getFechaEnvio());
				}
				alertaService.save(alerta);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ERRORMENSAJE,
						"Alerta/Comunicarea a fost salvată cu succes.");
			}
			else {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						"Nu se pot salva alerte sau comunicări fara destinatari.");
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la salvarea Alertei/Comunicării ".concat(Constantes.DESCERRORMENSAJE));
			// this.registroActividadService.guardarRegistroError(SeccionesEnum.ALERTAS.name(), Constantes.ALERTA, e);
		}
		return fechaEnvio;
	}

	/**
	 * Trimiteți alerta unui anumit utilizator
	 * @param usuario User
	 */
	public void enviarAlertaUsuario(final Users usuario) {
		try {
			this.alertaService.sendAlertUsuario(this.alerta, usuario);
			this.registroActividadService.guardarRegistroAltaModificacion(this.alerta.getId(),
					this.alerta.getDescripcion(), SeccionesEnum.ALERTAS.name(), Constantes.DELAALERTA);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
					"Alerta/Comunicarea a fost trimisă corect.");
			this.limpiarDatosCambiarPestana();
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la trimiterea Alertei/Comunicării ".concat(Constantes.DESCERRORMENSAJE));
			this.registroActividadService.guardarRegistroError(SeccionesEnum.ALERTAS.name(), Constantes.ALERTA, e);
		}
	}

	/**
	 * Intrarea în pagină pentru a trimite o nouă alertă.
	 * @return String
	 */
	public String enviarAlertaUsuarios() {
		this.alerta = new Alerta();
		this.utilizatorExtern = Constantes.ESPACIO;
		this.listaTeams = new ArrayList<>();
		this.usuariosSeleccionados = new ArrayList<>();
		this.listadoDocumentos = new ArrayList<>();
		this.documentosCargados = new ArrayList<>();
		this.usuariosSeleccionadosFinales = new ArrayList<>();
		this.modelUser = new LazyDataUsers(this.usuarioService);
		return "/alertas/nuevaAlerta?faces-redirect=true";
	}

	/**
	 * Verificați dacă un fișier corespunde oricărui document solicitat atât în nume, cât și în extensie.
	 * @param archivo subido
	 * @return booleano da sau nu
	 */
	private boolean esDocumentacion(final UploadedFile archivo) {
		final String nombreArchivo = archivo.getFileName();
		boolean esValido = false;
		esValido = nombreArchivo.toLowerCase().startsWith(archivo.getFileName().toLowerCase());
		return esValido;
	}

	/**
	 * Metoda de stabilire a utilizatorilor în lista generală.
	 */
	public void establecerUsuariosFinales() {
		final Users usua = new Users();
		if (this.opcion == NumeroMagic.NUMBERTWO) {
			for (final Users user : this.usuariosSeleccionados) {
				user.getUsername();
				if (!this.usuariosSeleccionadosFinales.contains(user)) {
					this.usuariosSeleccionadosFinales.add(user);
				}
			}
		}
		else if (this.opcion == NumeroMagic.NUMBERTHREE) {
			if (utilizatorExtern != null) {
				final String[] claves = utilizatorExtern.split(Constantes.COMA);
				for (final String clave : claves) {
					final String nombre = clave.trim();
					final Users usu = userService.fiindOne(nombre);
					if (usu == null) {
						usua.setUsername(nombre);
						usua.setAddress(null);
						usua.setAlertChannel(AlertChannelEnum.EMAIL);
						usua.setBirthDate(new Date());
						usua.setCivilStatus(null);
						usua.setEducation(EducationEnum.NESPECIFICAT);
						usua.setEmail(nombre);
						usua.setProvince(null);
						usua.setIdCard(null);
						usua.setLastName("VIA EMAIL");
						usua.setLocality(null);
						usua.setName(Constantes.DESTINATAR);
						usua.setNumberCard(null);
						usua.setPassword("$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
						usua.setPersonalEmail(nombre);
						usua.setPhone(null);

						usua.setRole(RoleEnum.ROLE_ALTUL);
						usua.setSex(null);
						usua.setValidated(false);
						usua.setWorkplace(null);
						userService.save(usua);
						if (!this.usuariosSeleccionadosFinales.contains(usua)) {
							this.usuariosSeleccionadosFinales.add(usua);
						}
					}

					else {
						if (!this.usuariosSeleccionadosFinales.contains(usu)) {
							this.usuariosSeleccionadosFinales.add(usu);
						}
					}
				}
			}
		}
		else {
			for (final Users user : this.usuariosSeleccionados) {
				user.getUsername();
				if (!this.usuariosSeleccionadosFinales.contains(user)) {
					this.usuariosSeleccionadosFinales.add(user);
				}
			}
		}
	}

	/**
	 * Metoda de încărcare a documentelor.
	 */
	public void cargarDocumentos() {
		for (final Documento doc : this.listadoDocumentos) {
			this.documentosCargados.add(doc);
		}

	}

	/**
	 * Salvați un fișier încărcat de utilizator ca document al cererii, după ce ați confirmat că nu este un fișier
	 * corupt și că se potrivește cu oricare dintre cele solicitate.
	 * @param event eveniment lansat din formular
	 * @return ruta traseu
	 */
	public void gestionarCargaDocumento(final FileUploadEvent event) {
		try {
			final UploadedFile archivo = event.getFile();
			// 19 es el id del tipodocumento para "template"
			final TipoDocumento tipo = TipoDocumento.builder().id(19L).build();
			final Users usuario = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (this.esDocumentacion(archivo)) {
				final Documento documento = this.documentoService.cargaDocumento(archivo, tipo, usuario);
				this.listadoDocumentos.add(documento);
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constantes.ALTA,
						"Documentul/ele încărcat/e cu succes", Constantes.MSGS);
			}
			else {
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR, Constantes.CARGADOC,
						"Fișierul încărcat " + archivo.getFileName()
								+ " nu este valabil, numele sau extensia nu corespunde cu documentul încărcat.",
						Constantes.MSGS);
			}
		}

		catch (DataAccessException | PerException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, TipoRegistroEnum.EROARE.name(),
					"A apărut o eroare la încărcarea documentului. ".concat(Constantes.DESCERRORMENSAJE));
			final String descripcion = "A apărut o eroare la încărcarea documentului";
			this.regActividadService.guardarRegistroError(descripcion, SeccionesEnum.GESTORDOCUMENTAL.getDescripcion(),
					e);
		}
		// final RequestContext context = RequestContext.getCurrentInstance();
		// context.execute("PF('dlgCargaDoc').show();");
	}

	/**
	 * Realizează eliminarea logică a documentului care poate fi recuperat din coșul de gunoi.
	 * @param document Documentul care o sa fie eliminat logic.
	 */
	public void eliminarDocumento(final Documento document) {
		try {
			this.listadoDocumentos.remove(document);
			this.documentoService.delete(document);
		}
		catch (final DataAccessException e) {
		}
	}

	/**
	 * Realizează eliminarea logică a documentului care poate fi recuperat din coșul de gunoi.
	 * @param document Documentul care o sa fie eliminat logic.
	 */
	public void eliminarDocumentoFinal(final Documento document) {
		try {
			this.documentosCargados.remove(document);
			this.documentoService.delete(document);
		}
		catch (final DataAccessException e) {
		}
	}

	/**
	 * Metoda Init a lui AlertaBean.
	 */
	@PostConstruct
	public void init() {
		this.alerta = new Alerta();
		this.alertaBusqueda = new AlertaBusqueda();
		this.usuarioBusqueda = new UsuarioBusqueda();
		this.usuariosExternosSeleccionados = usuarioService.findByName();
		this.usuariosSeleccionadosFinales = new ArrayList<>();
		this.team = new Team();
		this.numarMembrii = 0;
		this.provinces = new ArrayList<>();
		this.listaTeams = new ArrayList<>();
		this.list = new ArrayList<>();
		for (int i = 0; i < NUMBERCOLUMNASTABLA; i++) {
			this.list.add(Boolean.TRUE);
		}
		this.model = new LazyDataAlertas(this.alertaService);
		this.buscarAlertas();
		Utilities.limpiarSesion("alertaBean");
	}

	/**
	 * Acesta curăță utilizatorul de date și cel de fișiere.
	 */
	public void limpiarBuscadores() {
		this.usuarioBusqueda = new UsuarioBusqueda();
		this.usuariosSeleccionados = new ArrayList<>();
		// this.usuariosSeleccionadosFinales = new ArrayList<>();
		this.modelUser = new LazyDataUsers(this.usuarioService);
	}

	/**
	 * Curățați filtre de căutarea.
	 */
	public void limpiarBusqueda() {
		this.alertaBusqueda = new AlertaBusqueda();
		this.model = new LazyDataAlertas(this.alertaService);
	}

	// /**
	// * Curăță câmpurile utilizatorilor selectați și lista de utilizatori..
	// */
	// public void limpiarCamposNuevaAlerta() {
	// this.usuariosSeleccionados = new ArrayList<>();
	// this.alerta = new Alerta();
	// this.usuariosSeleccionadosFinales = new ArrayList<>();
	// this.modelUser = new LazyDataUsers(this.usuarioService);
	// }

	/**
	 * Curăță datele din fila de trimitere a alertelor..
	 */
	private void limpiarDatosCambiarPestana() {
		this.alerta.setAsunto(null);
		this.alerta.setDescripcion(null);
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute(Constantes.DIALOGMESGHIDE);
	}

	/**
	 * Afișează caseta de dialog Alertă cu alerta curentă.
	 * @param a Alerta
	 */
	public void mostrarDialogoAlertaConDetalle(final Alerta alert) {
		this.alertaActual = alert;
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute(Constantes.DIALOGALERTAS);
	}

	/**
	 * Afișează caseta de dialog Alertă.
	 */
	public void mostrarDialogoAlertas() {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute(Constantes.DIALOGALERTAS);
	}

	/**
	 * Metoda de a adăuga noi utilizatori la lista de utilizatori selectați.
	 */
	public void onChangePageUsuarios() {
		if ((this.usuariosSeleccionados != null) && !this.usuariosSeleccionados.isEmpty()) {
			this.usuariosSeleccionadosFinales.addAll(this.usuariosSeleccionados);
			this.usuariosSeleccionados = new ArrayList<>(this.usuariosSeleccionadosFinales);
		}
	}

	/**
	 * Metodă care asociază un utilizator când își selectează caseta de selectare pentru membrii.
	 * @param event eveniment lansat care conține alerta
	 */
	public void onRowSelectedUser(final SelectEvent event) {
		final Users usu = (Users) event.getObject();
		this.usuariosSeleccionadosFinales.add(usu);
		this.modelUser.setDsource(this.usuariosSeleccionadosFinales);
	}

	/**
	 * Metodă care asociază un utilizator când își selectează caseta de selectare pentru echipa de conducere.
	 * @param event eveniment lansat care conține alerta
	 */
	public void onRowSelectedTeam(final SelectEvent event) {
		final Team team = (Team) event.getObject();
		this.usuariosSeleccionadosFinales.add(team.getUser());
		this.modelUser.setDsource(this.usuariosSeleccionadosFinales);
	}

	/**
	 * Metodă care dezasociază un utilizator când deselectează caseta de selectare pentru membrii.
	 * @param event eveniment lansat care conține alerta
	 */
	public void onRowUnSelectedUser(final UnselectEvent event) {
		final Users us = (Users) event.getObject();
		this.usuariosSeleccionadosFinales.remove(us);
		this.modelUser.setDsource(this.usuariosSeleccionadosFinales);
	}

	/**
	 * Metodă care dezasociază un utilizator când deselectează caseta de selectare pentru echipa de conducere.
	 * @param event eveniment lansat care conține alerta
	 */
	public void onRowUnSelectedTeam(final UnselectEvent event) {
		final Team team = (Team) event.getObject();
		this.usuariosSeleccionadosFinales.remove(team.getUser());
		this.modelUser.setDsource(this.usuariosSeleccionadosFinales);
	}

	/**
	 * Controlează coloanele vizibile în lista rezultatelor motorului de căutare.
	 * @param e ToggleEvent
	 */
	public void onToggle(final ToggleEvent e) {
		this.list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" membrii în vizualizarea Avertizări.
	 * @param toogleEvent ToggleSelectEvent
	 */
	public void onToggleSelectUsers(final ToggleSelectEvent toogleEvent) {
		if (toogleEvent.isSelected()) {
			this.usuariosSeleccionados = new ArrayList<>(
					this.usuarioService.buscarUsuarioCriteria(this.usuarioBusqueda));
			for (final Users user : this.usuariosSeleccionados) {
				user.getUsername();
				if (!this.usuariosSeleccionadosFinales.contains(user)) {
					this.usuariosSeleccionadosFinales.add(user);
				}
			}
		}
		else {
			this.usuariosSeleccionados = new ArrayList<>();
		}
		this.modelUser.setDsource(this.usuariosSeleccionadosFinales);
	}

	/**
	 * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" membrii equipei în vizualizarea
	 * Avertizări.
	 * @param toogleEvent ToggleSelectEvent
	 */
	public void onToggleSelectTeam(final ToggleSelectEvent toogleEvent) {

		if (toogleEvent.isSelected()) {
			this.listaTeams = this.teamService.fiindByTeam();
			for (final Team team : listaTeams) {
				team.getUser();
				this.usuariosSeleccionadosFinales.add(team.getUser());
			}
		}
		else {
			this.usuariosSeleccionados = new ArrayList<>();
		}
		this.modelUser.setDsource(this.usuariosSeleccionadosFinales);
	}

	/**
	 * Eliminați un utilizator din lista utilizatorilor selectați pentru a primi alerta.
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

	/**
	 * Descărcați un document încărcat de utilizator.
	 * @param documento documentul selectat
	 */
	public void descargarFichero(final Documento documento) {
		setFile(null);
		try {
			setFile(documentoService.descargaDocumento(documento));
		}
		catch (final PerException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la descărcarea fișierului");
		}
	}
}

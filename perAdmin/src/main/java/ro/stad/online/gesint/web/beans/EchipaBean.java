package ro.per.online.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.poi.util.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.constantes.NumeroMagic;
import ro.per.online.lazydata.LazyDataUsers;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.PTeam;
import ro.per.online.persistence.entities.PersonalData;
import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.AlertChannelEnum;
import ro.per.online.persistence.entities.enums.CivilStatusEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.RoleEnum;
import ro.per.online.persistence.entities.enums.SexEnum;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;
import ro.per.online.services.LocalityService;
import ro.per.online.services.PTeamService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.TeamService;
import ro.per.online.services.UserService;
import ro.per.online.util.CorreoElectronico;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Generador;

/**
 * Clase utilizada pentru a incarca date in pagina de echipa PER.
 *
 * @author STAD
 *
 */
@Component("teamBean")
@Setter
@Getter
@NoArgsConstructor
@Scope(Constantes.SESSION)
public class TeamBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Obtener DNI.
	 * @param prenume
	 * @param nume
	 * @return dni + letra
	 */
	public static String mail(final String nume, final String prenume, final int numero) {
		// final String limpioName = nume.toLowerCase();
		final String limpioName = Normalizer.normalize(nume.toLowerCase(), Normalizer.Form.NFD);
		final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		final String nombre = pattern.matcher(limpioName).replaceAll(Constantes.ESPACIO);
		final String limpioPrenume = Normalizer.normalize(prenume.toLowerCase(), Normalizer.Form.NFD);
		final String prenombre = pattern.matcher(limpioPrenume).replaceAll(Constantes.ESPACIO);
		if (numero % 2 == 0) {
			return nombre.concat(Constantes.PUNTO).concat(prenombre.concat(Generador.nombresMail()));
		}
		else {
			if (numero % 17 == 0) {
				return prenombre.substring(0, 1).concat(nombre.concat(Generador.nombresMail()));
			}
			return prenombre.concat(nombre.concat(Generador.nombresMail()));
		}
	}

	/**
	 * Lista de elemente vizibile.
	 */
	private List<Boolean> list;

	/**
	 * Variala utilizata pentruinjectarea serviciului de team.
	 *
	 */
	@Autowired
	private transient TeamService teamService;

	/**
	 * Variala utilizata pentruinjectarea serviciului de team.
	 *
	 */
	@Autowired
	private transient PTeamService pteamService;

	/**
	 * Lista de usuarios seleccionados.
	 */
	private List<Users> usuariosSeleccionadosFinales;

	/**
	 * Numele de utilizator care va fi folosit pentru al inregisdtra in echipa.
	 */
	private String nombreUsuario = Constantes.ESPACIO;

	/**
	 * Lazy model para las usuarios.
	 */
	private transient LazyDataUsers modelUser;

	/**
	 * Service de usuarios.
	 */
	@Autowired
	private transient UserService usuarioService;

	/**
	 * Membru nou in echipa de conducere.
	 */
	private transient Team team;

	/**
	 * Functii in echipa de conducere.
	 */
	private transient PTeam functia;

	/**
	 * Clase de búsqueda de usuarios.
	 */
	private UsuarioBusqueda usuarioBusqueda;

	/**
	 * Lista utilizatorilor selectați.
	 */
	private List<Users> usuariosSeleccionados;

	/**
	 * Lista judetelor.
	 */
	private List<PProvince> listaProvincias;

	/**
	 * Judetul selectațat.
	 */
	private PProvince provinciaSelect;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private ProvinceService provinceService;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private UserService userService;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private LocalityService localityService;

	/**
	 * Lista numelor din echipa de conducere.
	 */
	private List<Team> listaTeams;

	/**
	 * Lista pozitiilor membrilor din echipa de conducere.
	 */
	private List<Team> listaPozitie;

	/**
	 * Lista numelor din echipa de conducere.
	 */
	private List<PTeam> listaFunctii;

	/**
	 * Indică dacă doriți să căutați după datele utilizatorului (opțiunea 1).
	 */
	private Integer opcion = NumeroMagic.NUMBERONE;

	/**
	 * Variabila utilizata pentru un utilizator.
	 *
	 */
	private Users user;

	/**
	 * Fotoografia utilizator.
	 */
	private byte[] photoSelected;

	/**
	 * Lista de localitati.
	 */
	private List<PLocality> localidades;

	/**
	 * Lista de localitati.
	 */
	private List<PLocality> localidadesSelected;

	/**
	 * Lista de judete.
	 */
	private List<PProvince> provinces;

	/**
	 * Variable utilizada para almacenar el contexto actual.
	 *
	 */
	private TypeLocalityEnum tipLocalidadSelected;

	/**
	 * Nombre del documento.
	 */
	private String nombreDoc;

	/**
	 * Mensaje de error que se muestra al usuario.
	 */
	private transient String mensajeError;

	/**
	 * Envío de correos electrónicos.
	 */
	@Autowired
	private transient CorreoElectronico correo;

	/**
	 * Deschide dialogul de căutare pentru utilizatori.
	 */
	public void abrirDialogoBusquedaUsuarios() {
		functia = new PTeam();
		listaProvincias = provinceService.fiindAll();
		listaTeams = teamService.fiindByTeam();
		listaFunctii = pteamService.fiindAll();
		modelUser = new LazyDataUsers(usuarioService);
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute(Constantes.DIALOGBUSQUEDASHOW);
	}

	/**
	 * Deschide dialogul pentru pozitionarea membrilor.
	 */
	public void abrirDialogoModificaMembru(final Team tea) {
		this.team = new Team();
		this.team = tea;
		this.listaFunctii = new ArrayList<>();
		listaFunctii = pteamService.fiindAll();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgModifica').show();");
	}

	/**
	 * Deschide dialogul pentru pozitionarea membrilor.
	 */
	public void abrirDialogoOrdenaMembru() {
		listaTeams = teamService.fiindByTeam();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgOrdena').show();");
	}

	public void alta() {
		String sex = null;
		Date fecha = null;
		int numero = 0;
		for (int i = 0; i < 1000; i++) {
			numero = i;
			final Users user = new Users();
			user.setDateCreate(Generador.obtenerFechaRegistru());
			user.setName(Generador.apellidoFinal3().toUpperCase());

			user.setPassword("$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
			fecha = Generador.obtenerFechaNastere();
			user.setBirthDate(fecha);
			user.setSex(SexEnum.randomLetter());
			final PProvince pro = new PProvince();
			pro.setIndicator(Generador.provinciasFinal());
			user.setProvince(pro);
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			final String anString = sdf.format(fecha);
			if (user.getSex().getName().equals("MAN")) {
				user.setLastName(Generador.nombreFinalHombre());
				if (Integer.valueOf(anString) >= 2000) {
					sex = "5";
				}
				else {
					sex = "1";
				}

			}
			else {
				user.setLastName(Generador.nombreFinal());
				if (Integer.valueOf(anString) >= 2000) {
					sex = "6";
				}
				else {
					sex = "2";
				}
			}
			user.setEmail(mail(user.getName(), user.getLastName(), numero));
			user.setIdCard(Generador.generaCnp(sex, fecha, pro));
			user.setAddress(Generador.nombresCalleFinal().concat("  Nr: ").concat(Generador.getNumeroCalle()));

			user.setCivilStatus(CivilStatusEnum.randomLetter());
			if (user.getCivilStatus().equals(CivilStatusEnum.WIDOWED)) {
				user.setCivilStatus(CivilStatusEnum.MARRIED);
			}
			user.setEducation(EducationEnum.randomLetter());

			List<PLocality> loc = new ArrayList<>();
			Long indice = Long.valueOf(Generador.getNumero());
			if (pro.getIndicator().equals("IF")) {
				indice = 2L;
			}
			loc = localityService.findByProvinceAndNivel(pro, indice);
			PLocality locality = new PLocality();
			if (pro.getIndicator().equals("B")) {
				Long id = null;
				if (user.getIdCard().substring(6, 8).equals("41")) {
					id = 72L;
				}
				else if (user.getIdCard().substring(6, 8).equals("42")) {
					id = 73L;
				}
				else if (user.getIdCard().substring(6, 8).equals("43")) {
					id = 74L;
				}
				else if (user.getIdCard().substring(6, 8).equals("44")) {
					id = 75L;
				}
				else if (user.getIdCard().substring(6, 8).equals("45")) {
					id = 76L;
				}
				else {
					id = 77L;
				}
				locality = localityService.findById(Long.valueOf(id));
			}
			else {

				final Random rand = new Random();
				locality = loc.get(rand.nextInt(loc.size()));
			}
			user.setLocality(locality);
			user.setNumberCard(Generador.getDni());
			user.setPersonalEmail(user.getEmail());
			user.setPhone(Generador.getTelefon());
			user.setAlertChannel(AlertChannelEnum.EMAIL);
			user.setValidated(true);
			user.setWorkplace(Generador.meserii());
			user.setUsername(user.getPersonalEmail());
			user.setRole(RoleEnum.ROLE_MEMBRU);
			user.setUserCreate("system");
			userService.save(user);
		}

	}

	/**
	 * Cautată un utilizator cu cnp-ul și returneaza adevărat sau fals.
	 * @return boolean
	 */
	private boolean buscarUsuarioPorNif() {
		Boolean resultado = true;
		final Users use = this.userService.findByIdCard(this.user.getIdCard());
		if (use != null && !use.getIdCard().equals(this.user.getIdCard())) {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Căută utilizatori pe baza unui filtru.
	 */
	public void buscarUsuarios() {
		modelUser.setUserBusqueda(usuarioBusqueda);
		modelUser.load(0, NumeroMagic.NUMBERFIFTEEN, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
	}

	/**
	 * Căută utilizatori pe baza unui filtru.
	 * @return
	 */
	public List<Users> buscaUsuarios() {
		modelUser.setUserBusqueda(usuarioBusqueda);
		return modelUser.load(0, NumeroMagic.NUMBERFIFTEEN, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
	}

	/**
	 * Carga un documento que se recibe a través de un evento FileUploadEvent. Esta carga se realiza sobre el objeto
	 * documento y no se guarda en base de datos. Se hace una comprobación para verificar si el tipo de documento se
	 * corresponde a la realidad.
	 *
	 * @param event Evento que se lanza en la carga del documento y que contiene el mismo
	 * @throws IOException
	 */
	public void cargaImagen(final FileUploadEvent event) throws IOException {
		this.nombreDoc = Constantes.ESPACIO;
		final UploadedFile uFile = event.getFile();
		user = userService.cargaImagenSinGuardar(IOUtils.toByteArray(uFile.getInputstream()), user);
		nombreDoc = uFile.getFileName();
	}

	/**
	 * Eliminarea unui membru al echipei.
	 * @param team membru candidat pentru eliminare
	 */
	public void eliminarMembru(final Users team) {
		try {
			Team te = new Team();
			te = teamService.findByUser(team);
			teamService.delete(te);
			listaTeams.remove(te);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ELIMINAREMENSAJE,
					Constantes.OKELIMINMENSAJE);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la eliminarea membrului echipei de conducere. "
							.concat(Constantes.DESCERRORMENSAJE));
		}

	}

	/**
	 * Metoda de stabilire a utilizatorilor din lista generală.
	 */
	public void establecerUsuariosFinales() {
		usuariosSeleccionadosFinales.add(user);
		modelUser.setDsource(usuariosSeleccionadosFinales);
		this.usuariosSeleccionadosFinales = usuariosSeleccionados;
	}

	/**
	 * Transmite datele utilizatorului pe care dorim să le modificăm în formular, astfel încât acestea să schimbe
	 * valorile pe care le doresc.
	 *
	 * @param usuario Utilizator recuperat din formularul de căutare al utilizatorului
	 * @return URL-ul paginii de modificare a utilizatorului
	 */
	public String getFormModificarUsuario(final Team tm) {
		this.team = tm;
		this.user = tm.getUser();
		this.photoSelected = null;
		this.provinciaSelect = new PProvince();
		provinciaSelect = user.getProvince();
		this.localidades = new ArrayList<>();
		localidadesSelected = localityService.findByProvince(provinciaSelect);
		this.provinces = provinceService.fiindAll();
		return "/teams/modifyTeam?faces-redirect=true";
	}

	/**
	 * Inițializarea datelor.
	 */
	@PostConstruct
	public void init() {
		this.usuarioBusqueda = new UsuarioBusqueda();
		this.user = new Users();
		this.listaTeams = new ArrayList<>();
		this.listaTeams = teamService.fiindByTeam();
		this.functia = new PTeam();
		this.list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			this.list.add(Boolean.TRUE);
		}

		limpiarBuscadores();
		// Utilities.limpiarSesion("teamBean");
	}

	/**
	 * Curăță căutarea utilizatorilor
	 */
	public void limpiarBuscadores() {
		usuarioBusqueda = new UsuarioBusqueda();
		user = new Users();
		usuariosSeleccionados = new ArrayList<>();
		modelUser = new LazyDataUsers(usuarioService);
	}

	/**
	 * Curăță câmpurile utilizatorilor selectați și lista de utilizatori.
	 */
	public void limpiarCamposNewTeam() {
		usuariosSeleccionadosFinales = new ArrayList<>();
		modelUser = new LazyDataUsers(usuarioService);
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute(Constantes.DIALOGMESGHIDE);
	}

	/**
	 * Guardar cambios del usuario.
	 * @param usu User
	 */
	public void modificarUsuario(final Users usu) {
		try {
			this.user = usu;

			if (validar()) {
				new PersonalData();
				user.setLocality(localidadesSelected.get(0));
				userService.save(user);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
						Constantes.OKMODMENSAJE);
			}
			else {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.CAMBIODATOS,
						Constantes.DESCERRORMENSAJE);
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.CAMBIODATOS,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Înregistrează utilizatorul indicat.
	 */
	public void modificaTeam(final Team tea) {
		this.team = new Team();
		try {
			this.team = tea;
			;
			teamService.save(tea);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
					Constantes.REGMODOK);
			final RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgModifica').hide();");

		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}

	}

	/**
	 * Acces pentru a inregistra un nou membru.
	 * @return String
	 */
	public String nuevoMembru() {
		team = new Team();
		functia = new PTeam();
		usuariosSeleccionados = new ArrayList<>();
		usuariosSeleccionadosFinales = new ArrayList<>();
		modelUser = new LazyDataUsers(usuarioService);
		return "/teams/newTeam?faces-redirect=true";
	}

	/**
	 * Metoda de a adăuga noi utilizatori la lista de utilizatori selectați.
	 */
	public void onChangePageUsuarios() {
		if (usuariosSeleccionados != null && !usuariosSeleccionados.isEmpty()) {
			usuariosSeleccionadosFinales.addAll(usuariosSeleccionados);
			usuariosSeleccionados = new ArrayList<>(usuariosSeleccionadosFinales);
		}
	}

	public void onReorder() {
		try {
			reordenarMembru();

			final FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Modificarea descrierii unui membru al equipei.
	 * @param event eveniment care capturează team de editat
	 */
	public void onRowEdit(final RowEditEvent event) {

		try {
			final Team team = (Team) event.getObject();
			teamService.save(team);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.REGMODOK,
					team.getTeam().getDescription());
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Metodă care asociază o inspecție când selectați caseta de selectare.
	 *
	 * @param event eveniment lansat care conține utilizatorul
	 */

	public void onRowSelectedUser(final SelectEvent event) {
		this.user = (Users) event.getObject();
		usuariosSeleccionadosFinales.add(user);
		modelUser.setDsource(usuariosSeleccionadosFinales);
	}

	/**
	 * Metoda care se execută la selectare.
	 * @param event SelectEvent
	 */
	public void onSelect(final SelectEvent event) {
		this.team = (Team) event.getObject();
	}

	/**
	 *
	 * Controlează coloanele vizibile în lista rezultatelor motorului de căutare.
	 *
	 * @param eve ToggleEvent
	 *
	 */

	public void onToggle(final ToggleEvent eve) {
		this.list.set((Integer) eve.getData(), eve.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" în vizualizarea Team.
	 *
	 * @param toogleEvent ToggleSelectEvent
	 */
	public void onToggleSelectUsers(final ToggleSelectEvent toogleEvent) {
		if (toogleEvent.isSelected()) {
			usuariosSeleccionadosFinales = buscaUsuarios();
			modelUser.setDsource(usuariosSeleccionadosFinales);
			usuariosSeleccionados = new ArrayList<>(usuariosSeleccionadosFinales);
		}
	}

	/**
	 * Elimina un utilizator din lista utilizatorilor selectați pentru a fi in echipa de conducere.
	 * @param usuario Users
	 */
	public void quitarUsuario(final Users usuario) {
		usuariosSeleccionadosFinales.remove(usuario);
	}

	/**
	 * Funcție care reorientează pozitia
	 * @throws DataAccessException excepție de acces la date
	 */
	private void reordenarMembru() {
		try {
			Team team;
			for (int i = 0; i < this.listaTeams.size(); i++) {
				team = this.listaTeams.get(i);

				team.setRank(i + 1L);
				this.teamService.save(team);
				final RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dlgOrdena').hide();");
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Înregistrează utilizatorul indicat.
	 */
	public String save() {
		String volver = null;

		try {
			if (usuariosSeleccionadosFinales.isEmpty()) {
				final Users usuario = usuarioService.fiindOne(nombreUsuario);
				if (usuario != null) {
					usuariosSeleccionadosFinales.add(usuario);
				}
			}
			for (final Users user : usuariosSeleccionadosFinales) {
				final boolean existeUsuario = teamService.existsByUser(user);
				if (existeUsuario) {
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR,
							" Nu se poate înregistra utilizatorul  '"
									+ user.getName().concat(".").concat(user.getLastName())
									+ "'  deoarece acesta există în echipa de conducere ",
							"");

				}
				else {
					final Team tea = new Team();
					tea.setUser(user);
					final PTeam pteam = new PTeam();
					pteam.setId(team.getId());
					tea.setTeam(pteam);
					listaPozitie = teamService.findAllByOrderByRankDesc();
					final Long rank = listaPozitie.get(0).getRank() + 1;
					tea.setRank(rank);
					teamService.save(tea);
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ALTAMENSAJE,
							Constantes.OKALTAMENSAJE);
					limpiarCamposNewTeam();
					listaTeams = teamService.fiindByTeam();
					final RequestContext context = RequestContext.getCurrentInstance();
					context.execute("PF('dlgBusqueda').hide();");
					volver = "/teams/teams?faces-redirect=true";
				}

			}

		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
			volver = "/teams/newTeam?faces-redirect=true";
		}
		return volver;

	}

	/**
	 * Método con las validaciones llevadas a cabo al guardar los datos de un usuario 1. Username no repetido 2. Nif no
	 * repetido 3. Nif valido
	 *
	 * @return boolean
	 */
	private boolean validar() {
		boolean validado = true;

		if (!validarUsername()) {
			this.mensajeError = "Membrul există deja în sistem";
			validado = true;
		}
		// if (!validarNifUnico()) {
		// this.mensajeError = "CNP-ul există deja în sistem";
		// validado = true;
		// }
		return validado;
	}

	/**
	 * Metodă de validare a unicității CNP.
	 * @return boolean
	 */
	private boolean validarNifUnico() {
		boolean resultado = true;
		if (!StringUtils.isEmpty(this.user.getIdCard()) && this.user.getIdCard() != null) {
			try {
				resultado = buscarUsuarioPorNif();
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						"A apărut o eroare la validarea cnp-ului membrului. ".concat(Constantes.DESCERRORMENSAJE));
			}
		}
		return resultado;
	}

	/**
	 * Metoda de validare a unicității numelui de utilizator.
	 * @return boolean
	 */
	private boolean validarUsername() {
		boolean resultado = true;
		final Users use = this.userService.fiindOne(this.user.getUsername());
		if (use != null && !use.getUsername().equals(this.user.getUsername())) {
			resultado = false;
		}
		return resultado;
	}
}

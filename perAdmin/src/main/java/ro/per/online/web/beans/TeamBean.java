package ro.per.online.web.beans;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.lazydata.LazyDataUsers;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.PTeam;
import ro.per.online.persistence.entities.PersonalData;
import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.CivilStatusEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.RoleEnum;
import ro.per.online.persistence.entities.enums.SexEnum;
import ro.per.online.services.LocalityService;
import ro.per.online.services.PTeamService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.TeamService;
import ro.per.online.services.UserService;
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
@SessionScoped
public class TeamBean implements Serializable {

	private static final long serialVersionUID = 1L;

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
	private Integer opcion = 1;

	/**
	 * Variabila utilizata pentru un utilizator.
	 * 
	 */
	private Users user;

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
	 * Eliminarea unui membru al echipei.
	 * @param team membru candidat pentru eliminare
	 */
	public void eliminarMembru(final Users team) {
		try {
			Team te = new Team();
			te = teamService.findByUser(team);
			teamService.delete(te);
			listaTeams.remove(te);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO,
					"Membru al echipei de conducere eliminat", null);
		}
		catch (DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la eliminarea membrului echipei de conducere, încercați din nou mai târziu");
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
	 * Deschide dialogul de căutare pentru utilizatori.
	 */
	public void abrirDialogoBusquedaUsuarios() {
		functia = new PTeam();
		listaProvincias = provinceService.fiindAll();
		listaTeams = teamService.fiindByTeam();
		listaFunctii = pteamService.fiindAll();
		modelUser = new LazyDataUsers(usuarioService);
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgBusqueda').show();");
	}

	/**
	 * Deschide dialogul pentru pozitionarea membrilor.
	 */
	public void abrirDialogoOrdenaMembru() {
		listaTeams = teamService.fiindByTeam();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgOrdena').show();");
	}

	/**
	 * Modificarea descrierii unui membru al equipei.
	 * @param event eveniment care capturează team de editat
	 */
	public void onRowEdit(final RowEditEvent event) {

		try {
			final Team team = (Team) event.getObject();
			teamService.save(team);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO,
					"Membru al echipei de conducere modificat", team.getTeam().getDescription());
		}
		catch (DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare în încercarea de a modifica membrul echipei de conducere, încercați din nou mai târziu");
		}
	}

	/**
	 * Înregistrează utilizatorul indicat.
	 */
	public void save() {
		try {
			if (usuariosSeleccionadosFinales.isEmpty()) {
				Users usuario = usuarioService.fiindOne(nombreUsuario);
				if (usuario != null) {
					usuariosSeleccionadosFinales.add(usuario);
				}
			}
			for (Users user : usuariosSeleccionadosFinales) {
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
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, " Înregistrare corectă ",
							"Membrul a fost înregistrat corect.");
					limpiarCamposNewTeam();
					listaTeams = teamService.fiindByTeam();
				}

			}

		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la înregistrarea utilizatorului, încercați din nou mai târziu.");
		}
	}

	/**
	 * Curăță câmpurile utilizatorilor selectați și lista de utilizatori.
	 */
	public void limpiarCamposNewTeam() {
		usuariosSeleccionadosFinales = new ArrayList<>();
		modelUser = new LazyDataUsers(usuarioService);
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogMessage').hide()");
	}

	/**
	 * Căută utilizatori pe baza unui filtru.
	 * @return
	 */
	public List<Users> buscaUsuarios() {
		modelUser.setSearchUser(usuarioBusqueda);
		return modelUser.load(0, Constantes.TAMPAGINA, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
	}

	/**
	 * Căută utilizatori pe baza unui filtru.
	 */
	public void buscarUsuarios() {
		modelUser.setSearchUser(usuarioBusqueda);
		modelUser.load(0, Constantes.TAMPAGINA, "dateCreate", SortOrder.DESCENDING, null);
	}

	/**
	 * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" în vizualizarea Team.
	 * 
	 * @param toogleEvent ToggleSelectEvent
	 */
	public void onToggleSelectUsers(final ToggleSelectEvent toogleEvent) {
		if (toogleEvent.isSelected()) {
			usuariosSeleccionadosFinales = buscaUsuarios();
			modelUser.setDatasource(usuariosSeleccionadosFinales);
			usuariosSeleccionados = new ArrayList<>(usuariosSeleccionadosFinales);
		}
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

	/**
	 * Metodă care asociază o inspecție când selectați caseta de selectare.
	 *
	 * @param event eveniment lansat care conține utilizatorul
	 */

	public void onRowSelectedUser(final SelectEvent event) {
		this.user = (Users) event.getObject();
		usuariosSeleccionadosFinales.add(user);
		modelUser.setDatasource(usuariosSeleccionadosFinales);
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
	 * Método para establecer los usuarios de las evaluaciones en el listado general.
	 */
	public void establecerUsuariosFinales() {
		usuariosSeleccionadosFinales.add(user);
		modelUser.setDatasource(usuariosSeleccionadosFinales);
		this.usuariosSeleccionadosFinales = usuariosSeleccionados;
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
		limpiarBuscadores();
	}

	public void alta() {
		for (int i = 0; i < 100; i++) {
			Users user = new Users();
			user.setDateCreate(Generador.ObtenerFecha());
			user.setEmail("proba@gmail.com");
			user.setLastName(Generador.apellidoFinal());
			user.setName(Generador.nombreFinal());
			user.setPassword("$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
			PersonalData pd = new PersonalData();
			pd.setAddress(Generador.nombresCalleFinal().concat("Nr :").concat(Generador.getNumeroCalle()));
			pd.setBirthDate(Generador.ObtenerFecha());
			pd.setCivilStatus(CivilStatusEnum.MARRIED);
			pd.setEducation(EducationEnum.BASIC);
			pd.setIdCard(Generador.getUnidadNumber());
			PProvince pro = new PProvince();
			pro.setId(Generador.provinciasFinal());
			pd.setProvince(pro);
			List<PLocality> loc = new ArrayList<>();
			loc = localityService.findByProvince(pro);
			PLocality locality = new PLocality();
			Random rand = new Random();
			locality = loc.get(rand.nextInt(loc.size()));
			pd.setLocality(locality);
			pd.setNumberCard(Generador.getDni());
			pd.setPersonalEmail(mail(user.getName(), user.getLastName()));
			pd.setPhone(Generador.getTelefon());
			pd.setSex(SexEnum.UNSPECIFIED);
			pd.setValidated(true);
			pd.setWorkplace("Nespecificat");
			user.setPersonalData(pd);
			user.setUsername(pd.getPersonalEmail());
			user.setRole(RoleEnum.ROLE_MEMBER);
			user.setUserCreate("system");
			userService.save(user);
		}
	}

	/**
	 * Obtener DNI.
	 * @param prenume
	 * @param nume
	 * @return dni + letra
	 */
	public static String mail(String nume, String prenume) {
		String email = null;
		String limpioName = Normalizer.normalize(nume.toLowerCase(), Normalizer.Form.NFD);
		limpioName.replace(" ", ".");
		String limpioPrenume = Normalizer.normalize(prenume.toLowerCase(), Normalizer.Form.NFD);
		limpioPrenume.replace(" ", ".");
		return limpioName.concat(".").concat(limpioPrenume.concat(Generador.nombresMail()));
	}

}

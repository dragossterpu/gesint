package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.lazydata.LazyDataUsers;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.PersonalData;
import ro.per.online.persistence.entities.Users;
import ro.per.online.services.CountryService;
import ro.per.online.services.LocalityService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;
import ro.per.online.web.componentes.ListasParametros;

/**
 * Controlor de operațiuni legate de gestionarea utilizatorilor. Înregistrarea utilizatorilor, modificarea
 * utilizatorilor, ștergerea utilizatorilor, căutarea utilizatorilor, parola de căutare și restaurare.
 * 
 * @author STAD
 */

@Setter
@Getter
@Controller("userBean")
@Scope("session")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Ruta buscador de isnpecciones.
	 */
	private static final String RUTABUSCAUSERS = "/users/users?faces-redirect=true";

	/**
	 * Utilizator/Membru.
	 */
	private Users user;

	/**
	 * Constante del parámetro de sesión usuario búsqueda.
	 */
	private static final String BUSQUEDA = "searchUsers";

	/**
	 * Objeto de búsqueda de usuario.
	 */
	private UsuarioBusqueda searchUsers;

	/**
	 * Lista de judete.
	 */
	private List<PProvince> provinces;

	/**
	 * Judetul
	 */
	private PProvince province;

	/**
	 * Lista de booleanos para el control de la visualización de columnas en la vista.
	 */
	private List<Boolean> list;

	/**
	 * Número máximo de columnas visibles en la vista.
	 */
	private int numeroColumnasListadoUsarios = 9;

	/**
	 * Array que contiene los niveles seleccionables.
	 */
	private int[] nivelesSelect = IntStream.rangeClosed(12, 30).toArray();

	/**
	 * LazyModel para la paginación desde servidor de los datos de la búsqueda de usuarios.
	 */
	private LazyDataUsers model;

	/**
	 * Servicio de usuarios.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 * 
	 */
	@Autowired
	private ProvinceService provinceService;

	/**
	 * Variabila utilizata pentru a injecta serviciul tarii.
	 * 
	 */
	@Autowired
	private CountryService countryService;

	/**
	 * Variabila utilizata pentru a injecta serviciul localitatilor.
	 * 
	 */
	@Autowired
	private LocalityService localityService;

	/**
	 * Lista de localitati.
	 */
	private List<PLocality> localidades;

	/**
	 * Variabilă folosită pentru a stoca valoarea provinciei selectate.
	 * 
	 */
	private PProvince provinciSelec;

	/**
	 * Contexto actual.
	 */
	private transient ExternalContext context;

	/**
	 * Clase utilizada para obtener los valores de las listas.
	 */
	@Autowired
	private transient ListasParametros listaParametros;

	/**
	 * Usuario.
	 */
	private Users usuario;

	/**
	 * Identificador de la provincia del usuario.
	 */
	private transient Long idProvincia;

	/**
	 * Encriptador de palabras clave.
	 */
	@Autowired
	private transient BCryptPasswordEncoder passwordEncoder;

	/**
	 * Mensaje de error que se muestra al usuario.
	 */
	private transient String mensajeError;

	/**
	 * Afișează profilul utilizatorului
	 * 
	 * @return URL-ul paginii unde se vede profilul utilizatorului.
	 */
	public String getUserPerfil() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.fiindOne(username);
		return "/principal/miPerfil?faces-redirect=true";
	}

	/**
	 * Metodă care ne duce la formularul de înregistrare a utilizatorilor noi, inițializând tot ceea ce este necesar
	 * pentru afișarea corectă a paginii (enums, utilizator nou,..etc). Seapeleaza din pagina căutare utilizator.
	 * 
	 * @return url-ul páginii de inregistrare utilizator
	 */
	public String newUser() {
		user = new Users();
		user.setDateCreate(new Date());
		return "/users/registerUser?faces-redirect=true";
	}

	/**
	 * Returnează formularul de căutare utilizator în starea sa inițială și șterge rezultatele căutărilor anterioare
	 * dacă este navigat din meniu sau dintr-o altă secțiune.
	 *
	 * @return pagina de căutare a utilizatorilor
	 */
	public String getSearchFormUsers() {
		cleanSearch();
		return "/users/users.xhtml?faces-redirect=true";
	}

	/**
	 * Șterge rezultatele căutărilor anterioare.
	 * 
	 */
	public void cleanSearch() {
		setProvinciSelec(null);
		this.searchUsers = new UsuarioBusqueda();
		this.model = new LazyDataUsers(this.userService);
		model.setRowCount(0);
	}

	/**
	 * Caută utilizatori în funcție de filtrele introduse în formularul de căutare.
	 */
	public void searchUsers() {
		model.setSearchUser(searchUsers);
		model.load(0, Constantes.TAMPAGINA, "dateCreate", SortOrder.DESCENDING, null);
	}

	/**
	 * Transmite datele utilizatorului pe care dorim să le modificăm în formular, astfel încât acestea să schimbe
	 * valorile pe care le doresc.
	 * 
	 * @param usuario Utilizator recuperat din formularul de căutare al utilizatorului
	 * @return URL-ul paginii de modificare a utilizatorului
	 */
	public String getFormModifyUser(final Users usua) {
		this.usuario = usua;
		this.provinces = provinceService.fiindAll();
		// final Users usu = userService.fiindOne(usuario.getUsername());
		return "/users/modifyUser?faces-redirect=true";
	}

	/**
	 * Se generează o nouă parolă și se trimite prin poștă către utilizator.
	 * @return String
	 */
	public String restaurarClave() {
		try {
			final String password = Utilities.getPassword();
			this.usuario.setPassword(this.passwordEncoder.encode(password));
			final String cuerpoCorreo = "Noua dvs. parolă este: " + password;
			this.userService.save(this.usuario);
			// this.correoService.envioCorreo(this.usuario.getUsername(), "Restauración de la contraseña",
			// cuerpoCorreo);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CLAVE,
					"Un e-mail a fost trimis utilizatorului cu noua parolă");
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.CLAVE,
					"A apărut o eroare în regenerarea sau trimiterea parolei");
		}
		return "/users/modifyUser?faces-redirect=true";
	}

	/**
	 * Activați / dezactivați vizibilitatea coloanelor din tabelul cu rezultate.
	 * 
	 * @param e checkbox al coloanei selectate
	 */
	public void onToggle(ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Returnează o listă a localităților care aparțin unui judet. Acesta este folosit pentru a reîncărca lista
	 * localităților în funcție de judetul selectat.
	 */
	public void onChangeProvincia(PProvince provincia) {
		if (provincia != null) {
			setLocalidades(localidades = localityService.findByProvince(provincia));
		}
		else {
			setLocalidades(null);
		}
	}

	/**
	 * Guardar cambios del usuario.
	 * @param usu User
	 */
	public void guardarCambios(final Users usu) {
		try {
			this.usuario = usu;

			if (validar()) {
				final PProvince provinciaSeleccionada = this.provinces.stream()
						.filter(provincia -> provincia.getId().equals(this.idProvincia)).collect(Collectors.toList())
						.get(0);
				PersonalData pd = new PersonalData();
				pd.setAddress(usuario.getPersonalData().getAddress());
				pd.setBirthDate(usuario.getPersonalData().getBirthDate());
				pd.setCivilStatus(usuario.getPersonalData().getCivilStatus());
				pd.setEducation(usuario.getPersonalData().getEducation());
				pd.setIdCard(usuario.getPersonalData().getIdCard());
				pd.setLocality(usuario.getPersonalData().getLocality());
				pd.setNumberCard(usuario.getPersonalData().getNumberCard());
				pd.setPersonalEmail(usuario.getPersonalData().getPersonalEmail());
				pd.setPhone(usuario.getPersonalData().getPhone());
				pd.setPhoto(usuario.getPersonalData().getPhoto());
				pd.setProvince(provinciaSeleccionada);
				pd.setSex(usuario.getPersonalData().getSex());
				pd.setValidated(usuario.getPersonalData().getValidated());
				pd.setWorkplace(usuario.getPersonalData().getWorkplace());
				this.userService.save(this.usuario);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
						"Se ha modificado corectamente el usuario");
			}
			else {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.CAMBIODATOS,
						this.mensajeError);
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.CAMBIODATOS,
					"A apărut o eroare");
		}
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
			this.mensajeError = "El usuario ya existe en el sistema";
			validado = false;
		}
		if (!validarNifUnico()) {
			this.mensajeError = "El nif ya existe en el sistema";
			validado = false;
		}
		return validado;
	}

	/**
	 * Metoda de validare a unicității numelui de utilizator.
	 * @return boolean
	 */
	private boolean validarUsername() {
		boolean resultado = true;
		final Users use = this.userService.fiindOne(this.usuario.getUsername());
		if (use != null && !use.getUsername().equals(this.usuario.getUsername())) {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Metodă de validare a unicității CNP.
	 * @return boolean
	 */
	private boolean validarNifUnico() {
		boolean resultado = true;
		if (!StringUtils.isEmpty(this.usuario.getPersonalData().getIdCard())
				&& this.usuario.getPersonalData().getIdCard() != null) {
			try {
				resultado = buscarUsuarioPorNif();
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						"Se ha producido un error a validar el nif del usuario, inténtelo de nuevo más tarde");
			}
		}
		return resultado;
	}

	/**
	 * Cautată un utilizator cu cnp-ul și returneaza adevărat sau fals.
	 * @return boolean
	 */
	private boolean buscarUsuarioPorNif() {
		Boolean resultado = true;
		final Users use = this.userService.findByIdCard(this.usuario.getPersonalData().getIdCard());
		if (use != null && !use.getPersonalData().getIdCard().equals(this.usuario.getPersonalData().getIdCard())) {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Inicializeaza bean-ul.
	 */
	@PostConstruct
	public void init() {
		this.usuario = new Users();
		this.provinces = new ArrayList<>();
		provinces = provinceService.fiindAll();
		this.localidades = new ArrayList<>();
		this.searchUsers = new UsuarioBusqueda();
		cleanSearch();
		this.list = new ArrayList<>();
		for (int i = 0; i <= numeroColumnasListadoUsarios; i++) {
			list.add(Boolean.TRUE);
		}
		this.model = new LazyDataUsers(userService);
	}

}

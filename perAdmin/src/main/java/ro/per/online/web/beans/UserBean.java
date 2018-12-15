package ro.per.online.web.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.apache.poi.util.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
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
import ro.per.online.persistence.entities.enums.AlertChannelEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;
import ro.per.online.services.LocalityService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;

/**
 * Controlor de operațiuni legate de gestionarea utilizatorilor. Înregistrarea utilizatorilor, modificarea
 * utilizatorilor, ștergerea utilizatorilor, căutarea utilizatorilor, parola de căutare și restaurare.
 *
 * @author STAD
 */

@Setter
@Getter
@Controller("userBean")
@Scope(Constantes.SESSION)

public class UserBean implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Utilizator/Membru.
	 */
	private Users user;

	/**
	 * Objeto de búsqueda de usuario.
	 */
	private UsuarioBusqueda userBusqueda;

	/**
	 * Lista de judete.
	 */
	private List<PProvince> provinces;

	/**
	 * Judet.
	 */
	private PProvince provinciaSelect;

	/**
	 * Judet.
	 */
	private PProvince provincia;

	/**
	 * Lista de booleanos para el control de la visualización de columnas en la vista.
	 */
	private List<Boolean> list;

	/**
	 * Número máximo de columnas visibles en la vista.
	 */
	private int numeroColumnasListadoUsarios = 9;

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
	 * Lista de localitati.
	 */
	private List<PLocality> localidadesSelected;

	/**
	 * Localitate aleasa.
	 */
	private PLocality localidadSelected;

	/**
	 * Usuario.
	 */
	private Users usuario;

	/**
	 * Educatie
	 */
	private EducationEnum education;

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
	 * Variable utilizada para almacenar el contexto actual.
	 *
	 */
	private PProvince grupoLocalidadesSelected;

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
	 * Fotoografia utilizator.
	 */
	private byte[] photoSelected;

	private Long idProvincia;

	private Long idLocalidad;

	private Date currentDate;

	/**
	 * Returnează o listă a localităților care aparțin unui judet. Acesta este folosit pentru a reîncărca lista
	 * localităților în funcție de judetul selectat.
	 * @param List<PLocality> lista de localitati
	 */
	public List<PLocality> actualizarLocalidades(final Long prov) {
		this.localidades = new ArrayList<>();

		this.provincia = provinceService.findById(prov);
		if (this.provincia != null) {
			try {
				this.localidades = localityService.findByProvince(provincia);
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, "Error", "Error");
			}
		}
		return localidades;
	}

	/**
	 * Caută utilizatori în funcție de filtrele introduse în formularul de căutare.
	 */
	public void buscarUsuario() {
		model.setUserBusqueda(userBusqueda);
		model.load(0, Constantes.TAMPAGINA, "dateCreate", SortOrder.DESCENDING, null);
	}

	/**
	 * Cautată un utilizator cu cnp-ul și returneaza adevărat sau fals.
	 * @return boolean
	 */
	private boolean buscarUsuarioPorNif() {
		Boolean resultado = true;
		final Users use = this.userService.findByIdCard(this.usuario.getIdCard());
		if (use != null && !use.getIdCard().equals(this.usuario.getIdCard())) {
			resultado = false;
		}
		return resultado;
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

		final UploadedFile uFile = event.getFile();
		this.usuario = userService.cargaImagenSinGuardar(IOUtils.toByteArray(uFile.getInputstream()), usuario);
		nombreDoc = uFile.getFileName();
	}

	/**
	 * Incarcam datele personale ale utilizatorului
	 * @param provincia
	 * @param nuevaLocalidad
	 * @param usuario
	 * @return usuario
	 */
	private void cargarDatosPersonaleUser(final PProvince provincia, final PLocality nuevaLocalidad,
			final Users usuario) {
		final PersonalData pd = new PersonalData();
		usuario.setLocality(nuevaLocalidad);
		usuario.setProvince(provincia);

	}

	/**
	 * Eliminación de un usuario.
	 * @param usuario a eliminar
	 * @see webapp.administracion.usuario.usuarioBusqueda.xhtml (2 matches)
	 * @see webapp.administracion.usuario.usuarios.xhtml (2 matches)
	 */
	public void eliminarUsuario(final Users usuario) {
		try {
			userService.delete(usuario);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.ERRORMENSAJE);
		}
	}

	/**
	 * Metodă care ne duce la formularul de înregistrare a utilizatorilor noi, inițializând tot ceea ce este necesar
	 * pentru afișarea corectă a paginii (enums, utilizator nou,..etc). Se apeleaza din pagina căutare utilizator.
	 *
	 * @return url-ul páginii de inregistrare utilizator
	 */
	public String getFormAltaUsuario() {
		this.usuario = new Users();
		this.photoSelected = null;
		this.provinciaSelect = new PProvince();
		this.localidadSelected = new PLocality();
		this.localidades = new ArrayList();
		this.idLocalidad = null;
		this.idProvincia = null;
		this.provinces = provinceService.fiindAll();
		// Minor de varsta
		final Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, -18);
		this.currentDate = date.getTime();
		return "/users/altaUser.xhtml?faces-redirect=true";
	}

	/**
	 * Transmite datele utilizatorului pe care dorim să le modificăm în formular, astfel încât acestea să schimbe
	 * valorile pe care le doresc.
	 *
	 * @param usuario Utilizator recuperat din formularul de căutare al utilizatorului
	 * @return URL-ul paginii de modificare a utilizatorului
	 */
	public String getFormModificarUsuario(final Users usua) {
		this.usuario = usua;
		this.photoSelected = null;
		this.provinciaSelect = new PProvince();
		this.localidadSelected = new PLocality();
		provinciaSelect = usua.getProvince();
		this.localidades = new ArrayList();
		this.idLocalidad = null;
		this.idProvincia = null;
		localidadesSelected = localityService.findByProvince(provinciaSelect);
		this.provinces = provinceService.fiindAll();
		return "/users/modifyUser?faces-redirect=true";
	}

	/**
	 * Método que obtiene la imágen para previsualizar en caso de que el documento sea de tipo imágen.
	 * @return StreamedContent
	 */
	public StreamedContent getImageUserSelected() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.photoSelected));
	}

	/**
	 * Returnează formularul de căutare utilizator în starea sa inițială și șterge rezultatele căutărilor anterioare
	 * dacă este navigat din meniu sau dintr-o altă secțiune.
	 *
	 * @return pagina de căutare a utilizatorilor
	 */
	public String getSearchFormUsers() {
		limpiarBusqueda();
		return "/users/users.xhtml?faces-redirect=true";
	}

	/**
	 * Afișează profilul utilizatorului
	 *
	 * @return URL-ul paginii unde se vede profilul utilizatorului.
	 */
	public String getUserPerfil() {
		final String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.fiindOne(username);
		return "/principal/miPerfil?faces-redirect=true";
	}

	/**
	 * Inicializeaza bean-ul.
	 */
	@PostConstruct
	public void init() {
		this.tipLocalidadSelected = null;
		usuario = new Users();
		provinces = new ArrayList<>();
		this.provinces = provinceService.fiindAll();
		localidades = new ArrayList<>();
		provincia = new PProvince();
		this.provinciaSelect = new PProvince();
		userBusqueda = new UsuarioBusqueda();
		limpiarBusqueda();
		list = new ArrayList<>();
		for (int i = 0; i <= numeroColumnasListadoUsarios; i++) {
			list.add(Boolean.TRUE);
		}
		this.model = new LazyDataUsers(userService);
		if (this.userBusqueda.getProvinciaSelected() != null) {
			this.localidades = localityService.findByProvince(grupoLocalidadesSelected);
		}
		Utilities.limpiarSesion("userBean");
	}

	/**
	 * Șterge rezultatele căutărilor anterioare.
	 *
	 */
	public void limpiarBusqueda() {
		userBusqueda = new UsuarioBusqueda();
		this.model = new LazyDataUsers(this.userService);
		model.setRowCount(0);
	}

	/**
	 * Salvați modificările utilizatorului
	 * @param usu User
	 */
	public void modificarUsuario(final Users usu) {
		try {
			this.usuario = usu;

			if (validar()) {
				usuario.setLocality(localidadesSelected.get(0));
				userService.save(usuario);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
						"Utilizatorul a fost modificat corect");
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
	 * Inregistratrea utilizatorului.
	 * @param usu User
	 */
	public void altaUsuario(final Users usu) {
		try {
			this.usuario = usu;

			if (validar()) {
				final PersonalData pd = new PersonalData();
				usuario.setLocality(localityService.findById(idLocalidad));
				usuario.setEmail(usuario.getUsername());
				usuario.setValidated(true);
				usuario.setProvince(provinceService.findById(idProvincia));
				usuario.setAlertChannel(AlertChannelEnum.EMAIL);
				usuario.setPassword("$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
				userService.save(usuario);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
						"Utilizatorul a fost înregistrat corect");
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
	 * Muestra el diálogo de nueva imágen.
	 * @param relacion ActividadPuesto
	 * @param tipoImg int
	 */
	public void mostrarDialogoNuevaImagen(final Users usuario) {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlg').show();");
	}

	/**
	 * Guarda un nuevo municipio.
	 *
	 * @param nombre del municipio nuevo
	 * @param provincia a la que se asocia el nuevo municipio
	 */
	public void nuevoMunicipio(final String nombre, final PProvince provincia, final TypeLocalityEnum tipLoclalitate,
			final Users usuario) {
		final boolean existeLocalidad = localityService.existeByNameIgnoreCaseAndProvincia(nombre.trim(), provincia);
		this.tipLocalidadSelected = null;
		tipLocalidadSelected = tipLoclalitate;
		if (existeLocalidad) {
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
					"Acțiunea nu este permisă. Există deja o localitate care aparține aceluiași judeș cu același nume.",
					null, "inputNombre");
		}
		else {
			PLocality nuevaLocalidad;
			try {
				nuevaLocalidad = localityService.crearLocalidad(nombre, provincia, tipLocalidadSelected);
				localidadesSelected.add(nuevaLocalidad);
				Collections.sort(localidadesSelected, (o1, o2) -> Long.compare(o1.getId(), o2.getId()));
				// Incarcam si salvam noua localitate in datele utilizatorului
				cargarDatosPersonaleUser(provincia, nuevaLocalidad, usuario);
				userService.save(usuario);
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
						"Eroare în salvarea localității. Încercați din nou mai târziu.", null, "inputNombre");
			}
		}
	}

	/**
	 * Activați / dezactivați vizibilitatea coloanelor din tabelul cu rezultate.
	 *
	 * @param e checkbox al coloanei selectate
	 */
	public void onToggle(final ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Se generează o nouă parolă și se trimite prin poștă către utilizator.
	 * @return String
	 */
	public String restaurarClave() {
		try {
			final String password = Utilities.getPassword();
			this.usuario.setPassword(this.passwordEncoder.encode(password));
			// final String cuerpoCorreo = "Noua dvs. parolă este: " + password;
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
	 * Metodă de validare a unicității CNP.
	 * @return boolean
	 */
	private boolean validarNifUnico() {
		boolean resultado = true;
		if (!StringUtils.isEmpty(this.usuario.getIdCard()) && this.usuario.getIdCard() != null) {
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

}

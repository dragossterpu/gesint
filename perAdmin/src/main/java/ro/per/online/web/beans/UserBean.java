package ro.per.online.web.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
	 * Usuario.
	 */
	private Users usuario;

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

	/**
	 * Método que obtiene la imágen para previsualizar en caso de que el documento sea de tipo imágen.
	 * @return StreamedContent
	 */
	public StreamedContent getImageUserSelected() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.photoSelected));
	}

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
	public String getFormAltaUsuario() {
		user = new Users();
		return "/users/registerUser?faces-redirect=true";
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
	 * Șterge rezultatele căutărilor anterioare.
	 * 
	 */
	public void limpiarBusqueda() {
		userBusqueda = new UsuarioBusqueda();
		this.model = new LazyDataUsers(this.userService);
		model.setRowCount(0);
	}

	/**
	 * Caută utilizatori în funcție de filtrele introduse în formularul de căutare.
	 */
	public void buscarUsuario() {
		model.setUserBusqueda(userBusqueda);
		model.load(0, Constantes.TAMPAGINA, "dateCreate", SortOrder.DESCENDING, null);
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
		provinciaSelect = usua.getPersonalData().getProvince();
		this.localidades = new ArrayList();
		localidadesSelected = localityService.findByProvince(provinciaSelect);
		this.provinces = provinceService.fiindAll();
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
	 * Activați / dezactivați vizibilitatea coloanelor din tabelul cu rezultate.
	 * 
	 * @param e checkbox al coloanei selectate
	 */
	public void onToggle(final ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Returnează o listă a localităților care aparțin unui judet. Acesta este folosit pentru a reîncărca lista
	 * localităților în funcție de judetul selectat.
	 * @param List<PLocality> lista de localitati
	 */
	public List<PLocality> getLocalidades() {
		this.localidades = new ArrayList<>();
		if (this.grupoLocalidadesSelected != null) {
			try {
				this.localidades = localityService.findByProvince(grupoLocalidadesSelected);
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, "Error", "Error");
			}
		}
		return localidades;
	}

	/**
	 * Guardar cambios del usuario.
	 * @param usu User
	 */
	public void modificarUsuario(final Users usu) {
		try {
			this.usuario = usu;

			if (validar()) {
				final PersonalData pd = new PersonalData();
				pd.setAddress(usuario.getPersonalData().getAddress());
				pd.setBirthDate(usuario.getPersonalData().getBirthDate());
				pd.setCivilStatus(usuario.getPersonalData().getCivilStatus());
				pd.setEducation(usuario.getPersonalData().getEducation());
				pd.setIdCard(usuario.getPersonalData().getIdCard());
				pd.setLocality(localidadesSelected.get(0));
				pd.setNumberCard(usuario.getPersonalData().getNumberCard());
				pd.setPersonalEmail(usuario.getPersonalData().getPersonalEmail());
				pd.setPhone(usuario.getPersonalData().getPhone());
				pd.setPhoto(usuario.getPersonalData().getPhoto());
				pd.setProvince(usuario.getPersonalData().getProvince());
				pd.setSex(usuario.getPersonalData().getSex());
				pd.setValidated(usuario.getPersonalData().getValidated());
				pd.setWorkplace(usuario.getPersonalData().getWorkplace());
				userService.save(usuario);
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
	 * Eliminación de un usuario.
	 * @param usuario a eliminar
	 * @see webapp.administracion.usuario.usuarioBusqueda.xhtml (2 matches)
	 * @see webapp.administracion.usuario.usuarios.xhtml (2 matches)
	 */
	public void eliminarUsuario(final Users usuario) {
		try {
			userService.delete(usuario);
		}
		catch (DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.ERRORMENSAJE);
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
		boolean existeLocalidad = localityService.existeByNameIgnoreCaseAndProvincia(nombre.trim(), provincia);
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
			catch (DataAccessException e) {
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
						"Eroare în salvarea localității. Încercați din nou mai târziu.", null, "inputNombre");
			}
		}
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
		pd.setAddress(usuario.getPersonalData().getAddress());
		pd.setBirthDate(usuario.getPersonalData().getBirthDate());
		pd.setCivilStatus(usuario.getPersonalData().getCivilStatus());
		pd.setEducation(usuario.getPersonalData().getEducation());
		pd.setIdCard(usuario.getPersonalData().getIdCard());
		pd.setLocality(nuevaLocalidad);
		pd.setNumberCard(usuario.getPersonalData().getNumberCard());
		pd.setPersonalEmail(usuario.getPersonalData().getPersonalEmail());
		pd.setPhone(usuario.getPersonalData().getPhone());
		pd.setPhoto(usuario.getPersonalData().getPhoto());
		pd.setProvince(provincia);
		pd.setSex(usuario.getPersonalData().getSex());
		pd.setValidated(usuario.getPersonalData().getValidated());
		pd.setWorkplace(usuario.getPersonalData().getWorkplace());
		usuario.setPersonalData(pd);
	}

	/**
	 * Carga un documento que se recibe a través de un evento FileUploadEvent. Esta carga se realiza sobre el objeto
	 * documento y no se guarda en base de datos. Se hace una comprobación para verificar si el tipo de documento se
	 * corresponde a la realidad.
	 * 
	 * @param event Evento que se lanza en la carga del documento y que contiene el mismo
	 * @throws IOException
	 */
	public void cargaImagen(FileUploadEvent event) throws IOException {

		UploadedFile uFile = event.getFile();
		this.usuario = userService.cargaImagenSinGuardar(IOUtils.toByteArray(uFile.getInputstream()), usuario);
		nombreDoc = uFile.getFileName();
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

	}

}

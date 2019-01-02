package ro.per.online.web.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import ro.per.online.constantes.NumeroMagic;
import ro.per.online.lazydata.LazyDataUsers;
import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
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
	private PProvince provinciSelec;

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
	private int numeroColumnasListadoUsarios = NumeroMagic.NUMBERSEVENTEEN;

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

	/**
	 * Identificadorul judetului
	 */
	private String idProvincia;

	/**
	 * Identificadorul localitatii
	 */
	private Long idLocalidad;

	/**
	 * Data actuala
	 */
	private Date currentDate;

	/**
	 * eliminat
	 */
	private Boolean eliminado;

	/**
	 * Returnează o listă a localităților care aparțin unui judet. Acesta este folosit pentru a reîncărca lista
	 * localităților în funcție de judetul selectat.
	 * @param List<PLocality> lista de localitati
	 */
	public List<PLocality> actualizarLocalidades(final String prov) {
		setLocalidades(null);

		this.provincia = provinceService.findById(prov);
		if (this.provincia != null) {
			try {
				setLocalidades(localityService.findByProvince(provincia));
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						Constantes.DESCERRORMENSAJE);
			}
		}
		return localidades;
	}
	/**
	 * Returnează o listă a localităților care aparțin unui judet. Acesta este folosit pentru a reîncărca lista
	 * localităților în funcție de judetul selectat.
	 * @param List<PLocality> lista de localitati
	 */
	public List<PLocality> actualLocalidades(final String prov) {
		setLocalidades(null);

		this.provincia = provinceService.findByName(prov);
		if (this.provincia != null) {
			try {
				setLocalidades(localityService.findByProvince(provincia));
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						Constantes.DESCERRORMENSAJE);
			}
		}
		return localidades;
	}
	/**
	 * Caută utilizatori în funcție de filtrele introduse în formularul de căutare.
	 */
	public void buscarUsuario() {
		model.setUserBusqueda(userBusqueda);
		model.load(0, Constantes.TAMPAGINA, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
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
		usuario.setLocality(nuevaLocalidad);
		usuario.setProvince(provincia);

	}

	/**
	 * Eliminación de un usuario.
	 * @param usuario a eliminar
	 * @see webapp.administracion.usuario.usuarioBusqueda.xhtml (2 matches)
	 * @see webapp.administracion.usuario.usuarios.xhtml (2 matches)
	 */
	public void eliminarUsuario(final Users usu) {
		try {
			this.usuario = usu;
			userService.delete(usuario);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ELIMINAREMENSAJE,
					Constantes.OKELIMINMENSAJE);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
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
		setProvinciSelec(null);
		setLocalidades(null);
		this.idLocalidad = null;
		this.idProvincia = null;
		try {
			setProvinces(provinceService.fiindAll());
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
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
		final Users usu = userService.fiindOne(usua.getUsername());
		String redireccion = null;
		if (usu != null) {
			this.usuario = usua;						
			setProvinciSelec(usuario.getProvince());
			setLocalidades(localityService.findByProvince(usuario.getProvince()));
			if(usuario.getLocality() == null) {
				for (final PLocality lacal : localidades) {
					if (lacal.getResidence()) {
						usuario.setLocality(lacal); 
						break;
					}
				}
				
			}
			
			redireccion = "/users/modifyUser?faces-redirect=true";
		}
		else {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.MODIFICAREMENSAJE,
					"A apărut o eroare la accesarea membrului. Membrul nu există.");
		}
		return redireccion;
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
		try {
			user = userService.fiindOne(username);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroar în căutatrea membrului.".concat(Constantes.DESCERRORMENSAJE));
		}
		return "/principal/miPerfil?faces-redirect=true";
	}

	/**
	 * Inicializeaza bean-ul.
	 */
	@PostConstruct
	public void init() {
		this.tipLocalidadSelected = null;
		usuario = new Users();
		eliminado = false;
		provinces = new ArrayList<>();
		this.provinces = provinceService.fiindAll();
		localidades = new ArrayList<>();
		provincia = new PProvince();
		setProvinciSelec(null);
		userBusqueda = new UsuarioBusqueda();
		limpiarBusqueda();
		list = new ArrayList<>();
		for (int i = 0; i <= numeroColumnasListadoUsarios; i++) {
			list.add(Boolean.TRUE);
		}
		this.model = new LazyDataUsers(userService);
		extractLocalitati();
		Utilities.limpiarSesion("userBean");
	}

	/**
	 * Metoda care obtine localitatile dupa un judet
	 *
	 */
	private void extractLocalitati() {
		if (this.userBusqueda.getProvinciaSelected() != null) {
			try {
				setLocalidades(localityService.findByProvince(grupoLocalidadesSelected));
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						"A apărut o eroar în căutatrea localităților care aparțin județului. Încercați din nou mai târziu.");
			}
		}
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
	public void modificarUsuario(final Users usu, final String prov, final String local) {
		final String valida = Constantes.MODIFICAREMENSAJE;
		this.provincia = provinceService.findByName(prov);
		this.localidadSelected= localityService.findByName(local);
		try {
			this.usuario = usu;
			if (validar(valida)) {
				if (eliminado == false) {
					usuario.setDateDeleted(null);
				}
				else {
					usuario.setDateDeleted(new Date());
				}
				usuario.setLocality(localidadSelected);
				usuario.setProvince(provincia);
				userService.save(usuario);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
						"Membrul a fost modificat corect");
			}
			else {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.CAMBIODATOS,
						this.mensajeError);
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.CAMBIODATOS,
					Constantes.DESCERRORMENSAJE);
		}
	}


	/**
	 * Inregistratrea utilizatorului.
	 * @param usu User
	 */
	public void altaUsuario(final Users usu) {
		try {
			this.usuario = new Users();
			this.usuario = usu;
			final String valida = "Înregistrare";
			// Validam noul utilizator
			if (validar(valida)) {
				usuario.setLocality(localityService.findById(idLocalidad));
				usuario.setEmail(usuario.getUsername());
				usuario.setValidated(true);
				usuario.setProvince(provinceService.findById(idProvincia));
				usuario.setAlertChannel(AlertChannelEnum.EMAIL);
				usuario.setPassword("$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
				userService.save(usuario);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
						"Membrul a fost înregistrat corect");
			}
			else {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						this.mensajeError);
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
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
	public void nuevoMunicipio(final String nombre, final String prov, final TypeLocalityEnum tipLoclalitate,
			final Users usuario) {
		Boolean existeLocalidad = false;
		this.provincia = provinceService.findByName(prov);
		if(provincia == null) {
			this.provincia = provinceService.findById(prov);
		}
		try {
			existeLocalidad = localityService.existeByNameIgnoreCaseAndProvincia(nombre.trim(), provincia);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
					"S-a produs o erroare în căutarea localitații. Încercați din nou mai târziu.", null, "inputNombre");
		}
		this.tipLocalidadSelected = null;
		tipLocalidadSelected = tipLoclalitate;
		if (existeLocalidad) {
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
					"Acțiunea nu este permisă. Există deja o localitate care aparține aceluiași județ cu același nume.",
					null, "inputNombre");
		}
		else {
			PLocality nuevaLocalidad;
			try {
				nuevaLocalidad = localityService.crearLocalidad(nombre, provincia, tipLocalidadSelected);
				setLocalidades(localityService.findByProvince(provincia));
//				Collections.sort(localidadesSelected, (o1, o2) -> Long.compare(o1.getId(), o2.getId()));
				// Incarcam si salvam noua localitate in datele utilizatorului
				cargarDatosPersonaleUser(provincia, nuevaLocalidad, usuario);
//				userService.save(usuario);
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
	private boolean validar(final String valida) {
		boolean validado = true;

		if (!validarUsername()) {

			this.mensajeError = "Membrul există deja în sistem";

			validado = false;
		}
		if (!validarNifUnico()) {
			if (valida.equals(Constantes.ALTAMENSAJE)) {
				this.mensajeError = "CNP-ul există deja în sistem";
			}
			else {
				this.mensajeError = "CNP-ul nu este corect.";
			}
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

				if (cnpCorect()) {
					resultado = buscarUsuarioPorNif();
				}
				else {
					resultado = false;
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
							" Datele introduse pentru validarea cnp-ului nu sunt corecte. Verificați aceste date și încercați din nou.");
				}
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						"A apărut o eroare la validarea CNP-ului membrului, încercați din nou mai târziu");
			}
		}
		return resultado;
	}

	/**
	 * Metoda de validare a unicității numelui de utilizator.
	 * @return boolean
	 */
	private boolean cnpCorect() {
		boolean resultado = true;
		if (validaSex() && valideazaAn()) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Metoda de validare a unicității numelui de utilizator.
	 * @return boolean
	 */
	private boolean validaSex() {
		boolean resultado = true;
		final String cnp = this.usuario.getIdCard().substring(0, 1);
		final String sex = this.usuario.getSex().getName();
		if (sex.equals("MAN") && cnp.equals("1") || sex.equals("WOMAN") && cnp.equals("2")) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Metoda de validare a unicității numelui de utilizator.
	 * @return boolean
	 */
	private boolean valideazaAn() {
		boolean resultado = true;
		if (this.usuario.getIdCard().length() > 7) {
			final String an = this.usuario.getIdCard().substring(1, 3);
			final String luna = this.usuario.getIdCard().substring(3, 5);
			final String zi = this.usuario.getIdCard().substring(5, 7);
			final Date fecha = this.usuario.getBirthDate();
			final SimpleDateFormat sdf = new SimpleDateFormat("yy");
			final SimpleDateFormat lsdf = new SimpleDateFormat("MM");
			final SimpleDateFormat zsdf = new SimpleDateFormat("dd");
			final String anString = sdf.format(fecha);
			final String lunaString = lsdf.format(fecha);
			final String ziString = zsdf.format(fecha);
			if (an.equals(anString) && luna.equals(lunaString) && zi.equals(ziString)) {
				resultado = true;
			}
			else {
				resultado = false;
			}
		}
		else {
			resultado = false;
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

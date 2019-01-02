package ro.per.online.services.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.faces.application.FacesMessage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.util.StringUtils;

import ro.per.online.constantes.Constantes;
import ro.per.online.exceptions.PerException;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.AlertChannelEnum;
import ro.per.online.persistence.entities.enums.CivilStatusEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.RoleEnum;
import ro.per.online.persistence.entities.enums.SeccionesEnum;
import ro.per.online.persistence.entities.enums.SexEnum;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;
import ro.per.online.services.LocalityService;
import ro.per.online.services.OperacionMasivaFicheroService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;
import ro.per.online.web.beans.ApplicationBean;

/**
 * Implementación de la interfaz donde se define la lógica de negocio para los usuarios.
 * @author STAD
 */
@Service
public class OperacionMasivaFicheroServiceImpl implements OperacionMasivaFicheroService {

	/**
	 * Servicio de usuarios.
	 */
	@Autowired
	private UserService usuarioService;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private ProvinceService provinceService;

	/**
	 * Encriptador para la contraseña.
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Componente de utilidades.
	 */
	@Autowired
	private Utilities utilities;

	/**
	 * Clase de utilidades para mensajes.
	 */
	@Autowired
	private transient FacesUtilities facesUtilities;

	/**
	 * Variable utilizada para inyectar el servicio de aplicación.
	 */
	@Autowired
	private transient ApplicationBean applicationController;

	/**
	 * Variabila utilizata pentru a injecta serviciul localitatilor.
	 *
	 */
	@Autowired
	private LocalityService localityService;

	/**
	 * Localitate aleasa.
	 */
	private PLocality localidad;

	/**
	 * Variabila pentru cnp
	 */
	private String cnp;

	/**
	 * Variabila pentru data nasterii
	 */
	private Date fecha;

	/**
	 * Procesa la operación masiva de un fichero.
	 * @param event evento de donde se obtendrá el fichero
	 * @param tipoRegistro tipo de operación
	 * @param mensajeExcepcion mensaje en caso de que ocurra un fallo
	 */
	@Override
	public void procesarOperacionMasivaFichero(final FileUploadEvent event, final String tipoRegistro,
			final String mensajeExcepcion) {
		try {
			final String mensaje = cargaFicheroOperacionMasiva(event.getFile(), tipoRegistro);
			if (StringUtils.isEmpty(mensaje)) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ALTA,
						"Toți utilizatorii au fost procesați cu succes.");
			}

			else {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						Constantes.EXISTERORI.concat(mensajeExcepcion) + mensaje);
			}
		}
		catch (final TransactionException | IOException | NoSuchElementException te) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.EXISTERORI.concat(mensajeExcepcion));
		}
	}

	/**
	 * Carga un excel de usuarios válidos.
	 * @param uFile Fichero
	 * @param operacion tipo de operación realizada
	 * @return lista de usuarios
	 * @throws IOException excepción lanzada
	 */
	private String cargaFicheroOperacionMasiva(final UploadedFile uFile, final String operacion) throws IOException {
		String mensajeSalida;
		final List<String> listaUsuariosExistentesBBDD = usuarioService
				.buscarListaDeUsernames(obtenerUsernamesDelFichero(devolverIteradorNuevo(uFile)));
		mensajeSalida = leerFicheroYGuardar(listaUsuariosExistentesBBDD, devolverIteradorNuevo(uFile), operacion);

		return mensajeSalida;
	}

	/**
	 * Devuelve un iterador de filas nuevo para el fichero.
	 * @param uFile fichero a leer
	 * @return iterador de filas
	 * @throws IOException Excepción de entrada/salida.
	 */
	private Iterator<Row> devolverIteradorNuevo(final UploadedFile uFile) throws IOException {
		final Workbook workbook = new XSSFWorkbook(uFile.getInputstream());
		final Sheet sheet = workbook.getSheetAt(0);
		return sheet.iterator();
	}

	/**
	 * Obtiene la lista de nombres de usuarios del fichero.
	 * @param rowIterator iterador de filas del fichero
	 * @return lista de nombres de usuarios
	 */
	private List<String> obtenerUsernamesDelFichero(final Iterator<Row> rowIterator) {
		final List<String> listaUsernames = new ArrayList<>();
		final DataFormatter dataFormatter = new DataFormatter();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			final String username = dataFormatter.formatCellValue(rowIterator.next().cellIterator().next());
			if (!StringUtils.isEmpty(username.trim())) {
				listaUsernames.add(username);
			}
		}

		return listaUsernames;
	}

	/**
	 * Lee el fichero fila a fila y realiza las operaciones pertinentes.
	 * @param listaBBDD lista de usuarios que se encuentran en BBDD.
	 * @param iteradorFilas iterador de filas
	 * @param operacion operación que se va a realizar
	 * @throws ParseException
	 * @returnmensaje de salida con los usuarios correctos y en estado de error
	 */
	private String leerFicheroYGuardar(final List<String> listaBBDD, final Iterator<Row> iteradorFilas,
			final String operacion) {
		final DataFormatter dataFormatter = new DataFormatter();
		final List<Users> listaUsuariosGuardar = new ArrayList<>();
		final StringBuilder mensaje = new StringBuilder();
		Row row;
		iteradorFilas.next();
		while (iteradorFilas.hasNext()) {
			row = iteradorFilas.next();
			final String username = dataFormatter.formatCellValue(row.cellIterator().next());
			if (!StringUtils.isEmpty(username.trim())) {
				final String resultadoLlenar = llenarListaGuardar(listaBBDD, operacion, listaUsuariosGuardar, row,
						username);
				if (!StringUtils.isEmpty(resultadoLlenar)) {
					mensaje.append(resultadoLlenar);
				}
			}
		}
		String hayErrores = "Rezolvați-le și încercați din nou.";
		if (!listaUsuariosGuardar.isEmpty() && operacion.equals(Constantes.ALTA)) {
			usuarioService.guardado(listaUsuariosGuardar);
			hayErrores = hayErrores.concat(" Restul membrilor au fost salvați cu succes.");
		}
		else if (operacion.equals(Constantes.ELIMINARE)) {
			usuarioService.bajaLogica(listaBBDD);
			hayErrores = hayErrores.concat(" Restul membrilor s-au eliminat cu succes.");
		}
		else if (operacion.equals(Constantes.BLOCARE)) {
			usuarioService.desactivar(listaBBDD);
			hayErrores = hayErrores.concat(" Restul membrilor s-au blocat cu succes.");
		}

		if (!StringUtils.isEmpty(mensaje.toString())) {
			mensaje.append(hayErrores);
		}

		return mensaje.toString();
	}

	/**
	 * Llena la lista con los usuarios a guardar en BBDD.
	 * @param listaBBDD lista de usuarios que existen en BBDD
	 * @param operacion operación a realizar
	 * @param listaUsuariosGuardar lista de usuarios que se van a guardar
	 * @param row fila del fichero
	 * @param username nombre de usuario
	 * @return mensaje con los resultados de la operación
	 * @throws ParseException
	 */
	private String llenarListaGuardar(final List<String> listaBBDD, final String operacion,
			final List<Users> listaUsuariosGuardar, final Row row, final String username) {
		final DataFormatter dataFormatter = new DataFormatter();
		final StringBuilder mensaje = new StringBuilder();
		if (operacion.equals(Constantes.ALTA)) {
			if (!listaBBDD.contains(username)) {
				final Users usuario = new Users();
				usuario.setUsername(username);
				try {
					obtenerDatosUsuarioAlta(usuario, row.cellIterator(), dataFormatter, mensaje);
					listaUsuariosGuardar.add(usuario);
				}
				catch (final Exception e) {
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
							Constantes.ERRORMENSAJE);
				}
			}
			else {
				anadirRegistroError(mensaje, row, (Constantes.MEMBRUL + username + "' există deja în baza de date."));
			}
		}
		else {
			if (!listaBBDD.contains(username) && operacion.equals(Constantes.ALTA)) {
				anadirRegistroError(mensaje, row, (Constantes.MEMBRUL + username + "' nu este găsit în baza de date."));
			}
		}

		return mensaje.toString();
	}

	/**
	 * Obtiene los datos del usuario que va a ser creado en BBDD del fichero de excel.
	 * @param usuario usuario al que se añadirán los datos
	 * @param colIterator iterador de columnas
	 * @param dataFormatter formateador de columnas
	 * @throws ParseException
	 * @throws PdyrhException excepción de PDYRH
	 */
	private void obtenerDatosUsuarioAlta(final Users usuario, final Iterator<Cell> colIterator,
			final DataFormatter dataFormatter, final StringBuilder mensaje) throws PerException {
		String cellValue;
		cnp = Constantes.ESPACIO;
		colIterator.next();
		// Nume
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setName(cellValue);
		// Prenume
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setLastName(cellValue);
		// CNP
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setIdCard(cellValue);
		cnp = usuario.getIdCard();
		// Utilizator
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setUsername(cellValue);
		// Email
		usuario.setEmail(cellValue);
		// Email personal
		usuario.setPersonalEmail(cellValue);
		// Rol
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		utilities.existeRol(RoleEnum.valueOf(cellValue));
		usuario.setRole(RoleEnum.valueOf(cellValue));
		// TELEFON
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setPhone(cellValue);
		// NUMAR SI SERIA CARD DE IDENTITATE
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setNumberCard(cellValue);
		// ADRESA
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setAddress(cellValue);
		// DATA NASTERII
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		final SimpleDateFormat formatoDeFecha = new SimpleDateFormat(Constantes.FORMFECHA);
		try {

			usuario.setBirthDate(formatoDeFecha.parse(cellValue));
			fecha = usuario.getBirthDate();
		}
		catch (final ParseException e1) {
			mensaje.append("Eroare apărută la procesarea datei de naștere");
			utilities.procesarExcepcion(e1, SeccionesEnum.OTROS, "Eroare apărută la procesarea datei de naștere",
					facesUtilities);
		}
		// NIVEL DE EDUCATIE
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		utilities.existeEducatie(EducationEnum.valueOf(cellValue));
		usuario.setEducation(EducationEnum.valueOf(cellValue));
		// LOC DE MUNCA
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		usuario.setWorkplace(cellValue);
		// SEX
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		utilities.existeSex(SexEnum.valueOf(cellValue));
		final String sex = cellValue;
		if (valideazaCnp(sex, fecha, cnp)) {
			usuario.setSex(SexEnum.valueOf(cellValue));
		}
		else {
			mensaje.append(
					"Datele introduse în registru nu sunt corecte. Verificați , data nașterii, sexul sau cnp-ul membrului.");
		}
		// STARE CIVILA
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		utilities.existeCivilStatus(CivilStatusEnum.valueOf(cellValue));
		usuario.setCivilStatus(CivilStatusEnum.valueOf(cellValue));
		// PROVINCIA
		cellValue = obtenerIdCelda(dataFormatter.formatCellValue(colIterator.next()).trim());
		utilities.esEntero(cellValue);
		PProvince provincia = new PProvince();
		try {
			provincia.setIndicator(String.valueOf(cellValue));
		}
		catch (final NumberFormatException e) {
			mensaje.append(" Codul judeţului trebuie să fie numeric.");
			throw new PerException("Codul judeţului trebuie să fie numeric.");
		}
		provincia = provinceService.findById(provincia.getIndicator());
		if (provincia != null) {
			usuario.setProvince(provincia);
		}
		else {
			mensaje.append(" Judeţul nu este prezent în baza de date.");
			throw new PerException("Judeţul nu este prezent în baza de date.");
		}
		// TIPUL LOCALITATII
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		utilities.existeTypeLocality(TypeLocalityEnum.valueOf(cellValue));
		final TypeLocalityEnum tipulLocalitatii = TypeLocalityEnum.valueOf(cellValue);
		// LOCALITATEA
		cellValue = dataFormatter.formatCellValue(colIterator.next());
		// Cautam localitatea dupa nume
		this.localidad = localityService.localidadByNameIgnoreCaseAndProvincia(cellValue, provincia);
		// Daca nu exista o cream
		if (localidad == null) {
			usuario.setLocality(localityService.crearLocalidad(cellValue, provincia, tipulLocalitatii));
		}
		else {
			usuario.setLocality(localidad);
		}
		usuario.setPassword(passwordEncoder.encode("1"));
		// MEMBRU ACTIV
		usuario.setValidated(true);
		// SCANAL DE COMUNICARE
		usuario.setAlertChannel(AlertChannelEnum.EMAIL);
	}

	/**
	 * Metoda de validare a unicității numelui de utilizator.
	 * @return boolean
	 */
	private boolean valideazaCnp(final String sex, final Date fecha, final String cnp) {
		boolean resultado = true;
		if (cnp.length() == 11) {
			final String an = cnp.substring(1, 3);
			final String luna = cnp.substring(3, 5);
			final String zi = cnp.substring(5, 7);
			final String cnpul = cnp.substring(0, 1);
			final Date data = fecha;
			final SimpleDateFormat sdf = new SimpleDateFormat("yy");
			final SimpleDateFormat lsdf = new SimpleDateFormat("MM");
			final SimpleDateFormat zsdf = new SimpleDateFormat("dd");
			final String anString = sdf.format(data);
			final String lunaString = lsdf.format(data);
			final String ziString = zsdf.format(data);
			if (an.equals(anString) && luna.equals(lunaString) && zi.equals(ziString)
					&& (sex.equals("MAN") && cnpul.equals("1") || sex.equals("WOMAN") && cnpul.equals("2"))) {
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
	 * Añade un registro de error al StringBuilder.
	 * @param mensaje mensaje al que se añadirá el registro erróneo
	 * @param row fila en la que se ha producido el error
	 * @param e el error que ha casuado el problema
	 */
	private void anadirRegistroError(final StringBuilder mensaje, final Row row, final String e) {
		if (StringUtils.isEmpty(mensaje)) {
			mensaje.append("Următoarele înregistrări conțin un tip de eroare și nu au fost salvate:");
		}
		mensaje.append("înregistrarea membrului de pe rândul ").append(row.getRowNum())
				.append(":  al fișierului de proces masiv").append(e);
	}

	/**
	 * Obține ID-ul unui corp sau al unei celule din excel.
	 * @param celda valor de la celda
	 * @return id obtenido
	 */
	private String obtenerIdCelda(final String celda) {

		String valor = Constantes.ESPACIO;
		valor = celda.substring(0, celda.indexOf(Constantes.LINIE)).trim();
		return valor;
	}
}

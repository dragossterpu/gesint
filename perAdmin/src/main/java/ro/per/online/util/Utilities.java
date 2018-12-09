
package ro.per.online.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.Years;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import ro.per.online.constantes.Constantes;
import ro.per.online.exceptions.PerException;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.CivilStatusEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.RegistroEnum;
import ro.per.online.persistence.entities.enums.RoleEnum;
import ro.per.online.persistence.entities.enums.SeccionesEnum;
import ro.per.online.persistence.entities.enums.SexEnum;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;
import ro.per.online.services.RegistroActividadService;

/**
 * Métodos de utilidades.
 * @author STAD
 */
@Component
public class Utilities {
	/**
	 * Servicio de actividad.
	 */
	@Autowired
	private RegistroActividadService registro;

	/**
	 * Elimina los bean de la sesión que no contienen ese nombre.
	 *
	 * @param listaBeans Nombre de los beans que no se tienen que eliminar de la sesión.
	 */
	public static void cleanSession(final List<String> listaBeans) {
		final Map<String, Object> mapaSesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for (final String cabecera : mapaSesion.keySet()) {
			final String ubicacion = mapaSesion.get(cabecera).getClass().getPackage().toString().toLowerCase();
			if (ubicacion.contains("bean") && "navegacionBean".equals(cabecera) == Boolean.FALSE
					&& listaBeans.contains(cabecera) == Boolean.FALSE) {
				mapaSesion.remove(cabecera);
			}
		}
	}

	/**
	 * Elimina los bean de la sesión que no contienen ese nombre.
	 *
	 * @param nombreBeanActual Nombre del bean que no se tiene que eliminar de la sesión.
	 */
	public static void cleanSession(final String nombreBeanActual) {
		final Map<String, Object> mapaSesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for (final String cabecera : mapaSesion.keySet()) {
			final String ubicacion = mapaSesion.get(cabecera).getClass().getPackage().toString().toLowerCase();
			if (ubicacion.contains("bean") && "navegacionBean".equals(cabecera) == Boolean.FALSE
					&& cabecera.equals(nombreBeanActual) == Boolean.FALSE) {
				mapaSesion.remove(cabecera);
			}
		}
	}

	/**
	 * Carga la plantilla y genera el texto final con los parámetros proporcionados.
	 *
	 * @param template plantilla (txt,html,etc.)
	 * @param parametros info a añadir a la plantilla
	 * @return texto compilado
	 * @throws PebbleException error al compilar
	 * @throws IOException error al cargar la plantilla
	 */
	public static String generarTextoConPlantilla(final String template, final Map<String, Object> parametros)
			throws PebbleException, IOException {

		final PebbleEngine engine = new PebbleEngine.Builder().autoEscaping(false).build();
		final PebbleTemplate compiledTemplate = engine.getTemplate(template);

		final Writer writer = new StringWriter();
		compiledTemplate.evaluate(writer, parametros);

		final String textoCompilado = writer.toString();

		return textoCompilado;
	}

	/**
	 * Formatea una fecha según un patrón recibido como parámetro.
	 *
	 * @param date fecha a formatear
	 * @param pattern patrón de fecha
	 * @return fecha formateada
	 */

	public static String getFechaFormateada(final Date date, final String pattern) {
		final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	// ************* Generating new password PER ********************//
	/**
	 * Devuelve una contraseña basada en una combinación de letras y números.
	 *
	 * @author STAD
	 * @return contraseña
	 */
	public static String getPassword() {
		return getPinLetters() + getPinNumber();
	}

	/**
	 * Recupera una cadena de cuatro letras al azar.
	 *
	 * @author STAD
	 * @return letras
	 */
	public static String getPinLetters() {
		return getRandomChars("ABCDEFGHIJKLMNOPRSTUVXYZWQ", 4);
	}

	/**
	 * Recupera una cadena de cuatro números al azar.
	 *
	 * @author STAD
	 * @return números
	 */
	public static String getPinNumber() {
		return getRandomChars("0123456789", 4);
	}

	// ************* Generating new password PER END ********************//

	/**
	 * Recupera una cadena de caracteres aleatorios a partir de un conjunto de caracteres y una longitud determinada.
	 *
	 * @author STAD
	 * @param key cadena de caracteres posibles
	 * @param length número de caracteres deseados
	 * @return cadena de caracteres elegidos
	 */
	public static String getRandomChars(final String key, final int length) {
		final StringBuilder pswd = new StringBuilder();
		final Random r = new Random();

		for (int i = 0; i < length; i++) {
			pswd.append(key.charAt(r.nextInt(key.length())));
		}

		return pswd.toString();
	}

	/**
	 * Comprueba si un objeto es nulo o blanco.
	 * @param obj El objeto a comprobar.
	 * @return true, Si el objeto es nulo o su valor en String es blanco.
	 */
	public static boolean isNullOrBlank(final Object obj) {
		if (obj == null) {
			return true;
		}
		if ("".equals(obj.toString())) {
			return true;
		}
		return false;
	}

	/**
	 * Elimina los bean de la sesión que no contienen ese nombre.
	 * @param nombreBeanActual Nombre del bean que no se tiene que eliminar de la sesión.
	 */
	public static void limpiarSesion(final String nombreBeanActual) {
		final Map<String, Object> mapaSesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for (final String cabecera : mapaSesion.keySet()) {
			final String ubicacion = mapaSesion.get(cabecera).getClass().getPackage().toString().toLowerCase();
			if (ubicacion.contains("bean") && "navegacionBean".equals(cabecera) == Boolean.FALSE
					&& cabecera.equals(nombreBeanActual) == Boolean.FALSE) {
				mapaSesion.remove(cabecera);
			}
		}
	}

	/**
	 * Converts a Map to a List filled with its entries. This is needed since very few if any JSF iteration components
	 * are able to iterate over a map.
	 */
	public static <T, S> List<Map.Entry<T, S>> mapToList(final Map<T, S> map) {

		if (map == null) {
			return null;
		}

		final List<Map.Entry<T, S>> list = new ArrayList<Map.Entry<T, S>>();
		list.addAll(map.entrySet());

		return list;
	}

	/**
	 * Genera un mensaje de error a partir de una excepción.
	 *
	 * @param e Excepción
	 * @return Mensaje
	 */
	public static String messageError(final Exception e) {
		String message = Arrays.toString(e.getStackTrace());
		if (message.length() > 2000) {
			message = message.substring(message.length() - 2000);
		}
		return message;
	}

	/**
	 * Método para evitar los nulos en cadenas de texto.
	 * @param cadena de entrada
	 * @return cadena de salida
	 */
	public static String nullToBlank(final String cadena) {
		String cad = cadena;
		if (cad == null) {
			cad = "";
		}
		return cad;
	}

	/**
	 * Indica qué tipo de operación se va a guardar en el registro.
	 * @param idObjeto Long
	 * @param borrado boolean
	 * @return RegistroEnum
	 */
	public static RegistroEnum procesarOperacion(final Long idObjeto, final boolean borrado) {
		final RegistroEnum tipoRegistro;
		if (idObjeto != null) {
			if (borrado) {
				tipoRegistro = RegistroEnum.BAJA;
			}
			else {
				tipoRegistro = RegistroEnum.MODIFICACION;
			}
		}
		else {
			tipoRegistro = RegistroEnum.ALTA;
		}
		return tipoRegistro;
	}

	/**
	 * Las clases de utilidad no deben tener constructor publico
	 *
	 */
	private Utilities() {
		// throw new IllegalStateException("Utiles class");
	}

	/**
	 * Obtiene el número de años entre 2 fechas.
	 * @param start fecha de inicio
	 * @param end fecha de fin
	 * @return número de años
	 */
	public int calcularYearsBetween(final ReadableInstant start, final ReadableInstant end) {
		return Years.yearsBetween(start, end).getYears();
	}

	/**
	 * convierte un objeto Date a LocalDate.
	 * @param date fecha en Date
	 * @return fecha en localDate
	 */
	public LocalDate dateToLocalDate(final Date date) {
		LocalDate out = null;

		if (date != null) {
			final DateTime dt = new DateTime(date);
			out = dt.toLocalDate();
		}

		return out;
	}

	/**
	 * Verificați dacă există un rol trecut prin parametru.
	 * @param descripcion del enum
	 * @throws PerException excepción propia de per
	 */
	public void existeRol(final RoleEnum descripcion) throws PerException {
		if (!RoleEnum.getRoles().contains(descripcion)) {
			throw new PerException("Câmpul rol nu este un valid.");
		}
	}
	/**
	 * Verificați dacă există un rol trecut prin parametru.
	 * @param descripcion del enum
	 * @throws PerException excepción propia de per
	 */
	public void existeRol(final String descripcion) throws PerException {
		if (!RoleEnum.getRoles().contains(descripcion)) {
			throw new PerException("Câmpul rol nu este un valid.");
		}
	}
	/**
	 * Verificați dacă există un camp valabil pentru educatie trecut ca parametru.
	 * @param descripcion del enum
	 * @throws PerException excepción propia de per
	 */
	public void existeEducatie(final EducationEnum descripcion) throws PerException {
		if (!EducationEnum.getEducation().contains(descripcion)) {
			throw new PerException("Câmpul educație nu este un valid.");
		}
	}

	/**
	 * Verificați dacă există un camp valabil pentru sex trecut ca parametru.
	 * @param descripcion del enum
	 * @throws PerException excepción propia de per
	 */
	public void existeSex(final SexEnum descripcion) throws PerException {
		if (!SexEnum.getSex().contains(descripcion)) {
			throw new PerException("Câmpul sex nu este un valid.");
		}
	}

	/**
	 * Verificați dacă există un camp valabil pentru stare civila trecut ca parametru.
	 * @param descripcion del enum
	 * @throws PerException excepción propia de per
	 */
	public void existeCivilStatus(final CivilStatusEnum descripcion) throws PerException {
		if (!CivilStatusEnum.getStatus().contains(descripcion)) {
			throw new PerException("Câmpul stare civila nu este un valid.");
		}
	}

	/**
	 * Verificați dacă există un camp valabil pentru stare civila trecut ca parametru.
	 * @param descripcion del enum
	 * @throws PerException excepción propia de per
	 */
	public void existeTypeLocality(final TypeLocalityEnum descripcion) throws PerException {
		if (!TypeLocalityEnum.getTypeLocality().contains(descripcion)) {
			throw new PerException("Câmpul tipul localității nu este un valid.");
		}
	}

	/**
	 * Verificați dacă un șir introdus de parametru este un număr.
	 * @param numero cadena número
	 * @throws PerException excepción propia de per
	 */
	public void esEntero(final String numero) throws PerException {
		final String regex = "\\d+";
		if (!numero.matches(regex)) {
			throw new PerException("Valoarea trebuie să fie un număr întreg.");
		}
	}

	/**
	 * Obtiene los datos del usuario logado.
	 * @return usuario logado
	 */
	public Users getUsuarioLogado() {
		return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	/**
	 * Método que procesa la excepción para lanzar un mensaje de error y guardar registro.
	 * @param excepcion Excepción capturada.
	 * @param accion Acción que ha disparado la excepción.
	 * @param facesUtilities para establecer el mensaje que se mostrará.
	 * @param seccion Sección donde se produce la excepción
	 */
	public void procesarExcepcion(final Exception excepcion, final SeccionesEnum seccion, final String accion,
			final FacesUtilities facesUtilities) {
		facesUtilities.setMensajeError("A apărut o eroare ".concat(accion), Constantes.IDMENSAJEGLOBAL);
		registro.registrarError(seccion, excepcion);
	}

	/**
	 * Devuelve una lista recargada con TRUE del tamaño indicado por parámetro.
	 * @param tamano tamaño de la lista
	 * @return lista con valores true
	 */
	public List<Boolean> listaTrue(final int tamano) {
		final List<Boolean> list = new ArrayList<>();
		for (int i = 0; i <= tamano; i++) {
			list.add(Boolean.TRUE);
		}
		return list;
	}

	/**
	 * Método para descargar un archivo de la carpeta resources.
	 * @param rutaResource ruta del fichero
	 * @param contenType tipo documento
	 * @param nombre nombre del fichero
	 * @return contenido del flujo
	 * @throws IOException excepción entrada/salida
	 */
	public StreamedContent descargarFichero(final String rutaResource, final String contenType, final String nombre)
			throws IOException {
		final InputStream inputStream = new ClassPathResource(rutaResource).getInputStream();
		// No cerrar el stream. Da error al descargar si se cierra
		return new DefaultStreamedContent(inputStream, contenType, nombre);
	}

	/**
	 * Método que procesa el resultado de una operación de BBDD para mostrar mensaje y guardar registro. El mensaje es
	 * con confirmación para volver a la pantalla anterior o refrescar.
	 * @param descripcion Descripción del objeto modificado
	 * @param operacion tipo de operación (alta, baja...)
	 * @param mensaje mensaje que se mostrará al usuario
	 * @param seccion donde se produce el resultado
	 * @param apartado del menú donde se produce
	 * @param facesUtilities para establecer el mensaje que se mostrará.
	 */
	public void procesarResultadoOperacion(final String descripcion, final String operacion, final String mensaje,
			final String apartado, final SeccionesEnum seccion, final FacesUtilities facesUtilities) {
		facesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, operacion, mensaje);
		registro.registrarActividad(seccion, operacion, apartado.concat(Constantes.OPERACION.concat(operacion)
				.concat(Constantes.DE).concat(descripcion).concat(Constantes.SEHAREALEXITO)));
	}
}

package ro.per.online.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.context.FacesContext;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.Years;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import ro.per.online.persistence.entities.enums.RegistroEnum;

/**
 * Métodos de utilidades.
 * 
 * @author STAD
 *
 */
public class Utilities {

	/**
	 * Elimina los bean de la sesión que no contienen ese nombre.
	 * 
	 * @param listaBeans Nombre de los beans que no se tienen que eliminar de la sesión.
	 */
	public static void cleanSession(List<String> listaBeans) {
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
	public static void cleanSession(String nombreBeanActual) {
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
	public static String generarTextoConPlantilla(String template, Map<String, Object> parametros)
			throws PebbleException, IOException {

		PebbleEngine engine = new PebbleEngine.Builder().autoEscaping(false).build();
		PebbleTemplate compiledTemplate = engine.getTemplate(template);

		Writer writer = new StringWriter();
		compiledTemplate.evaluate(writer, parametros);

		String textoCompilado = writer.toString();

		return textoCompilado;
	}

	/**
	 * Formatea una fecha según un patrón recibido como parámetro.
	 * 
	 * @param date fecha a formatear
	 * @param pattern patrón de fecha
	 * @return fecha formateada
	 */

	public static String getFechaFormateada(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
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
	public static String getRandomChars(String key, int length) {
		StringBuilder pswd = new StringBuilder();
		Random r = new Random();

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
	public static void limpiarSesion(String nombreBeanActual) {
		Map<String, Object> mapaSesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for (String cabecera : mapaSesion.keySet()) {
			String ubicacion = mapaSesion.get(cabecera).getClass().getPackage().toString().toLowerCase();
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
	public static <T, S> List<Map.Entry<T, S>> mapToList(Map<T, S> map) {

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
	public static String messageError(Exception e) {
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
	public static RegistroEnum procesarOperacion(Long idObjeto, boolean borrado) {
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

}
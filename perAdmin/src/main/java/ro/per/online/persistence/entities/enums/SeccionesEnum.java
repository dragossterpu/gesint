package ro.per.online.persistence.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Enumerado para los diferentes tipos de secciones utilizadas para la gestión de mensajes.
 *
 * @author STAD
 *
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SeccionesEnum {

	/**
	 * Sección de usuarios.
	 */
	LOGIN("LOGIN"),

	/**
	 * Sección de usuarios.
	 */
	USUARIOS("UTILIZATORI"),

	/**
	 * Sección de inicio.
	 */
	HOME("INICIO"),
	/**
	 * Sección de administración de formularios.
	 */
	ADMINFORMULARIOS("ADMINISTRARE DE FORMULARE"),

	/**
	 * Sección de administración.
	 */
	ADMINISTRACION("ADMINISTRARE"),

	/**
	 * Sección de alertas y avisos.
	 */
	ALERTAS("ALERTE/COMUNICAȚII"),

	/**
	 * Sección de estadísticas de evaluaciones.
	 */
	ESTADISTICA("STATISTICA"),

	/**
	 * Sección de estadísticas de usuario.
	 */
	ESTADISTICAUSUARIO("STATISTICILE MEMBRILOR"),

	/**
	 * Proiecte.
	 */
	PROJECT("PROIECTE"),

	/**
	 * Publicatii.
	 */
	PUBLICATIONS("PUBLICAȚII"),

	/**
	 * Sección de formularios.
	 */
	COMUNICACIONES("COMUNICAȚII"),

	/**
	 * Sección de gestor documental.
	 */
	GESTORDOCUMENTAL("MANAGER DOCUMENTAR"),

	/**
	 * Sección de administración.
	 */
	SOLICITUDES("APLICAȚII"),

	/**
	 * Sección de valorame.
	 */
	VALORAME("DA-MI NOTA"),

	/**
	 * Sección de propiedades.
	 */
	PROPIEDADES("PROPRIETĂȚI"),

	/**
	 * Sección de otros.
	 */
	OTROS("ALTELE");

	/**
	 * Descripción de la sección.
	 */
	private String descripcion;

}

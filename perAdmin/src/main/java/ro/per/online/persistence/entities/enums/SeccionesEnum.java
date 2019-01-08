package ro.per.online.persistence.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Sunt listate pentru diferitele tipuri de secțiuni utilizate pentru gestionarea mesajelor.
 *
 * @author STAD
 *
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SeccionesEnum {

	/**
	 * Secțiunea de autentificare
	 */
	LOGIN("LOGIN"),

	/**
	 * Secțiunea Utilizatori.
	 */
	USUARIOS("MEMBRII"),

	/**
	 * Secțiunea de Început.
	 */
	HOME("INICIO"),
	/**
	 * Secțiunea de administrare formulare.
	 */
	ADMINFORMULARIOS("ADMINISTRAȚIE FORMULARE"),

	/**
	 * Secțiunea de administrare.
	 */
	ADMINISTRACION("ADMINISTRARE"),

	/**
	 * Secțiune de Alerte și avertismente.
	 */
	ALERTAS("COMUNICAȚII"),

	/**
	 * Secțiune de Statistica si Evaluări .
	 */
	ESTADISTICA("STATISTICĂ"),

	/**
	 * Secțiunea Statistici utilizator.
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
	 * Secțiunea de formulare.
	 */
	COMUNICACIONES("COMUNICAȚII"),

	/**
	 * Secțiunea de management al documentelor.
	 */
	GESTORDOCUMENTAL("MANAGER DOCUMENTAR"),

	/**
	 * Secțiunea de solicitări.
	 */
	SOLICITUDES("APLICAȚII"),

	/**
	 * Secțiunea de proprietăți.
	 */
	PROPIEDADES("PROPRIETĂȚI"),

	/**
	 * Alte secțiuni.
	 */
	OTROS("ALTELE");

	/**
	 * Descrierea secțiunii.
	 */
	private String descripcion;

}

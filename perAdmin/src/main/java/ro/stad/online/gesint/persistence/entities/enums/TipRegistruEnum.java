package ro.per.online.persistence.entities.enums;

/**
 * 
 * Enumeración con los posibles valores del registro de actividad.
 * 
 */

public enum TipoRegistroEnum {
	/**
	 * El registro corresponde a un alta.
	 */
	INREGISTRARE,
	/**
	 * El registro corresponde a una modificación.
	 */
	MODIFICARE,
	/**
	 * El registro corresponde a un baja.
	 */
	ELIMINARE,
	/**
	 * El registro corresponde a un error.
	 */
	EROARE
}

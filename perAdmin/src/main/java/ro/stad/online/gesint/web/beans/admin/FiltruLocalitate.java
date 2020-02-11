package ro.per.online.web.beans.admin;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;

/**
 * Controlor de operațiuni legate de căutarea de localitati. Resetați valorile căutării.
 *
 * @author STAD
 */
@Setter
@Getter
public class LocalitateBusqueda implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Numele localitatii.
	 */
	private String nume;

	/**
	 * Judete selectionate.
	 */
	private String idProvincia;

	/**
	 * Filtru tipul localitatii utilizator.
	 */
	private TypeLocalityEnum tip;

	/**
	 * Resetați valorile formularului de căutare a localitatilor
	 */
	public void resetValues() {
		setNume(Constantes.ESPACIO);
		setIdProvincia(Constantes.ESPACIO);
		setTip(null);
	}

}

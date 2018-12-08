package ro.per.online.persistence.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Stări active și inactive.
 *
 * @author STAD
 *
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EstadoEnum {

	/**
	 * Activ.
	 */
	ACTIV("activ"),
	/**
	 * Inactiv
	 */
	INACTIV("inactiv");

	/**
	 * Descrierea enum.
	 */
	private String description;
}

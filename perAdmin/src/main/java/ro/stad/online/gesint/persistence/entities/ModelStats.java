package ro.per.online.persistence.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase model Stats.
 * @author STAD
 *
 */
@Getter
@Setter
public class ModelStats implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Descripción de ocurrencias.
	 */
	private String descripcion;

	/**
	 * Cantidad de ocurrencias.
	 */
	private Long cantidad;

	/**
	 * Porcentaje.
	 */
	private Long porcentage;

}

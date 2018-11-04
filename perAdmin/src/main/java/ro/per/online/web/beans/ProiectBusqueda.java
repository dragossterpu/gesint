package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Controlador de las operaciones relacionadas con la búsqueda de proyectos. Reseteo de valores de búsqueda.
 * 
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProiectBusqueda implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Filtru nume de utilizator de creacion.
	 */
	private String username;

	/**
	 * Filtru nume proiect.
	 */
	private String nume;

	/**
	 * Filtru proiect aprobat sau nu.
	 */
	private Boolean validated;

	/**
	 * Filtr materia indexata.
	 */
	private String materiaIndexata;

	/**
	 * Filtru data inregistrarii incepand.
	 */
	private Date dateFrom;

	/**
	 * Filtru data inregistrarii pana.
	 */
	private Date dateUntil;

}

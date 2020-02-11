package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.PTeam;
import ro.per.online.persistence.entities.enums.RoleEnum;

/**
 * Controlor al operațiunilor legate de căutarea utilizatorilor. Resetați valorile căutării.
 *
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamBusqueda implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Filtru nune de utilizator.
	 */
	private String username;

	/**
	 * Filtru rol utilizator.
	 */
	private RoleEnum role;

	/**
	 * Filtru nume utilizator.
	 */
	private String name;

	/**
	 * Filtru prenume utilizator.
	 */
	private String lastName;

	/**
	 * Filtru email utilizator.
	 */
	private String email;

	/**
	 * Filtru judet utilizator.
	 */
	private PProvince provincia;

	/**
	 * Filtru judet utilizator.
	 */
	private String idProvincia;

	/**
	 * Filtru data inregistrarii incepand.
	 */
	private Date dateFrom;

	/**
	 * Filtru data inregistrarii pana.
	 */
	private Date dateUntil;

	/**
	 * Variable utilizada para almacenar el valor de la provincia seleccionada.
	 *
	 */
	private PProvince provinciaSelected;

	/**
	 * Variable para functie
	 */
	private Long idFunctia;

	/**
	 * Variabla pentru lista de functii
	 */
	private List<PTeam> listTeam;
}

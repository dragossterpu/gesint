package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.enums.CivilStatusEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.RoleEnum;
import ro.per.online.persistence.entities.enums.SexEnum;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;

/**
 * Controlador de las operaciones relacionadas con la búsqueda de usuarios. Reseteo de valores de búsqueda.
 * 
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchUser implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Filtru nune de utilizator.
	 */
	private String username;

	/**
	 * Filtru cnp de utilizator.
	 */
	private String idCard;

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
	private PProvince province;

	/**
	 * Filtru localitate utilizator.
	 */
	private PLocality locality;

	/**
	 * Filtru nivel de studii utilizator.
	 */
	private EducationEnum education;

	/**
	 * Filtru sex utilizator.
	 */
	private SexEnum sex;

	/**
	 * Filtru stare civila utilizator.
	 */
	private CivilStatusEnum civilStatus;

	/**
	 * Filtru tipul localitatii utilizator.
	 */
	private TypeLocalityEnum typeLocality;

	/**
	 * Filtru activ/inactiv utilizator.
	 */
	private Boolean validated;

	/**
	 * Filtru data inregistrarii incepand.
	 */
	private Date dateFrom;

	/**
	 * Filtru data inregistrarii pana.
	 */
	private Date dateUntil;

}

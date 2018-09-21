package ro.mira.peronline.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import ro.mira.peronline.persistence.entities.enums.CivilStatusEnum;
import ro.mira.peronline.persistence.entities.enums.EducationEnum;
import ro.mira.peronline.persistence.entities.enums.SexEnum;

/**
 *
 * Entitate aditionala pentru completarea datelor utilizatorului..
 *
 * @author STAD
 *
 */
@Getter
@Setter
@Embeddable
public class PersonalData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Email personal.
	 */
	private String personalEmail;

	/**
	 * Judetul.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	private PProvince province;

	/**
	 * Localitatea.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	private PLocality locality;

	/**
	 * Telefonul.
	 */
	private String phone;

	/**
	 * Adresa.
	 */
	private String address;

	/**
	 * CNP utilizator.
	 */
	private String idCard;

	/**
	 * Numar buletin de identitate utilizator.
	 */
	private String numberCard;

	/**
	 * Data nasterii utilizator.
	 */
	private Date birthDate;

	/**
	 * Educatie utilizator.
	 */
	@Column(name = "education")
	@Enumerated(EnumType.STRING)
	private EducationEnum education;

	/**
	 * Loc de munca utilizator.
	 */
	private String workplace;

	/**
	 * Sex utilizator.
	 */
	@Column(name = "sex")
	@Enumerated(EnumType.STRING)
	private SexEnum sex;

	/**
	 * Stare civila utilizator.
	 */
	@Column(name = "civilStatus")
	@Enumerated(EnumType.STRING)
	private CivilStatusEnum civilStatus;

	/**
	 * Fotoografia utilizator.
	 */
	private Byte photo;

	/**
	 * Utilizator validat.
	 */
	private Boolean validated;
}

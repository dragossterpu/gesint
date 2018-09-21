package ro.mira.peronline.persistence.entities.enums;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Defineste sexul utilizatorului
 *
 * @author STAD
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SexEnum {
	/**
	 * Bărbat .
	 */
	MAN("Bărbat"),

	/**
	 * Femeie.
	 */
	WOMAN("Femeie"),

	/**
	 * Altul.
	 */
	OTHER("Altul"),

	/**
	 * Nespecificat.
	 */
	UNSPECIFIED("Nespecificat");

	/**
	 * Descrierea enum.
	 */
	private String description;

	/**
	 * Recupera la lista de sex in aplicatie.
	 * @return List<SexEnum>
	 * @see ro.mira.per.controller.AdminController.getRoles()
	 */
	public static List<SexEnum> getSex() {
		List<SexEnum> sexs = new ArrayList<>();
		for (SexEnum sex : SexEnum.values()) {
			sexs.add(sex);
		}
		return sexs;
	}

	/**
	 * @return Numele enum-ului "
	 */
	public String getName() {
		return name();
	}
}

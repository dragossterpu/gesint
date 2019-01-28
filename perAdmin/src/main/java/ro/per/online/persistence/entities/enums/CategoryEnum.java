package ro.per.online.persistence.entities.enums;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Defineste tipul de proiect care se publica
 *
 * @author STAD
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CategoryEnum {
	/**
	 * Statut .
	 */
	STATUT("Statut"),

	/**
	 * Lege.
	 */
	LEGE("Lege"),

	/**
	 * Proiect.
	 */
	PROIECT("Proiect"),

	/**
	 * Comunicat.
	 */
	COMUNICAT("Comunicat"),

	/**
	 * Raport.
	 */
	RAPORT("Raport"),

	/**
	 * Informare.
	 */
	INFORMARE("Informare"),

	/**
	 * Rezolutie.
	 */
	REZOLUTIE("Rezoluție");

	/**
	 * @return Returnează o listă cu descrierile enum.
	 *
	 */
	public static List<CategoryEnum> getCategoria() {
		final List<CategoryEnum> categorii = new ArrayList<>();
		for (final CategoryEnum categoria : CategoryEnum.values()) {
			categorii.add(categoria);
		}
		return categorii;
	}

	/**
	 * Descrierea enum.
	 */
	private String description;

	/**
	 * @return Numele enum-ului "
	 */
	public String getName() {
		return name();
	}
}

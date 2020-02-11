package ro.per.online.persistence.entities.enums;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Defineste tipul localitatii.
 *
 * @author STAD
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TypeLocalityEnum {
	/**
	 * Oraș.
	 */
	CITY("Oraș"),

	/**
	 * Municipiu.
	 */
	MUNICIPALITY("Municipiu"),

	/**
	 * Sat.
	 */
	COMMUNE("Comună"),

	/**
	 * Sector.
	 */
	SECTOR("Sector");

	/**
	 * @return Returnează o listă cu descrierile enum.
	 *
	 */
	public static List<TypeLocalityEnum> getTypeLocality() {
		List<TypeLocalityEnum> typeLocalitys = new ArrayList<>();
		for (TypeLocalityEnum typeLocality : TypeLocalityEnum.values()) {
			typeLocalitys.add(typeLocality);
		}
		return typeLocalitys;
	}

	/**
	 * Descrierea enum.
	 */
	private String description;

	/**
	 * Devuelve numele.
	 * @return String
	 */
	public String getNombre() {
		return this.name();
	}
}

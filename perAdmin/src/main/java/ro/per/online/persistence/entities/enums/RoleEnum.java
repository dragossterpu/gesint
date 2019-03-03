package ro.per.online.persistence.entities.enums;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Defineste rolurile sistemului. Datorită utilizării versiunii 4 de Spring Security, toate rolurile trebuie să înceapă
 * cu "ROLE_", altfel funcțiile: UserInRole, ifGranted, etc. întotdeauna se întorc false
 *
 * @author STAD
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RoleEnum {
	/**
	 * Rol administrator.
	 */
	ROLE_ADMIN("Administrator"),

	/**
	 * Rol pentru utilizatorii care se conecteaza la aplicatie.
	 */
	ROLE_ANONIM("Anonim"),

	/**
	 * Rol pentru utilizatorii membrii cu drepturi depline.
	 */
	ROLE_MEMBRU("Membru"),

	/**
	 * Rol pentru simpatizanti.
	 */
	ROLE_SIMPATIZANT("Simpatizant"),
	/**
	 * Rol pentru presedintele de filiala.
	 */
	ROLE_PRESEDINTE_ORG("Președinte filială"),
	/**
	 * Rol pentru presedintele de filiala.
	 */
	ROLE_VICE_PRESEDINTE_ORG("VicePreședinte filială"),

	/**
	 * Rol pentru presedintele de filiala.
	 */
	ROLE_SEF_LOCAL("Șef organizație locală");

	/**
	 * @return Returnează o listă cu descrierile enum.
	 *
	 */
	public static List<RoleEnum> getRoles() {
		final List<RoleEnum> roles = new ArrayList<>();
		for (final RoleEnum rol : RoleEnum.values()) {
			roles.add(rol);
		}
		return roles;
	}

	/**
	 * Descrierea enum.
	 */
	private String description;

	/**
	 * @return Nombre del enum sin el prefijo "ROLE_"
	 */
	public String getNombre() {
		return name().substring(5);
	}

}

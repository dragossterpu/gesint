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
	ROLE_MEMBER("Membru"),

	/**
	 * Rol pentru simpatizanti.
	 */
	ROLE_SYMPATHIZER("Simpatizant"),
	/**
	 * Rol pentru presedintele de filiala.
	 */
	ROLE_ADMIN_SUBSIDISRY("Președinte filială");

	/**
	 * @return Returnează o listă cu descrierile enum.
	 *
	 */
	public static List<RoleEnum> getRoles() {
		List<RoleEnum> roles = new ArrayList<>();
		for (RoleEnum rol : RoleEnum.values()) {
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

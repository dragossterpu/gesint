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
	 * Rol administrator.
	 */
	ROLE_ADMINLOCAL("Administrator local"),

	/**
	 * Rol administrator.
	 */
	ROLE_LOCAL("Administrator local secundar"),
	/**
	 * Rol pentru utilizatorii care se conecteaza la aplicatie.
	 */
	ROLE_ANONIM("Anonim"),

	/**
	 * Rol pentru utilizatorii membrii cu drepturi depline.
	 */
	ROLE_MEMBRU("Membru"),

	/**
	 * Rol pentru utilizatorii membrii cu drepturi depline.
	 */
	ROLE_COMISIE("Comisie"),

	/**
	 * Rol pentru utilizatorii membrii cu drepturi depline.
	 */
	ROLE_ALTUL("Altul"),

	/**
	 * Rol pentru simpatizanti.
	 */
	ROLE_SIMPATIZANT("Simpatizant");

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
	 * @return Returnează o listă cu descrierile enum pentru utilizatorii locali.
	 *
	 */
	public static List<RoleEnum> getRolesLocal() {
		final List<RoleEnum> rolesLocal = new ArrayList<>();
		for (final RoleEnum rol : RoleEnum.values()) {
			if (!rol.equals("ROLE_ADMIN")) {
				rolesLocal.add(rol);
			}
		}
		return rolesLocal;
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

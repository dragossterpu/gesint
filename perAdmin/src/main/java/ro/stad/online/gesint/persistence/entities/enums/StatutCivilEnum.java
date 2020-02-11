package ro.per.online.persistence.entities.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Defineste statutul civil al utilizatorului
 *
 * @author STAD
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CivilStatusEnum {
	/**
	 * Necasatorit.
	 */
	SINGLE("Necăsătorit/ă"),
	/**
	 * Casatorit.
	 */
	MARRIED("Căsătorit/ă"),
	/**
	 * Divortat.
	 */
	DIVORCED("Divorţat/ă"),

	/**
	 * Vaduv.
	 */
	WIDOWED("Văduv/ă"),

	/**
	 * Altul.
	 */
	OTHER("Alta"),

	/**
	 * Nespecificat.
	 */
	UNSPECIFIED("Nespecificat");

	private static final List<CivilStatusEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

	private static final int SIZE = VALUES.size();

	private static final Random RANDOM = new Random();

	/**
	 * @return Returnează o listă cu descrierile enum.
	 *
	 */
	public static List<CivilStatusEnum> getStatus() {
		final List<CivilStatusEnum> civilStatuts = new ArrayList<>();
		for (final CivilStatusEnum civilStatut : CivilStatusEnum.values()) {
			civilStatuts.add(civilStatut);
		}
		return civilStatuts;
	}

	public static CivilStatusEnum randomLetter() {
		return VALUES.get(RANDOM.nextInt(SIZE));
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

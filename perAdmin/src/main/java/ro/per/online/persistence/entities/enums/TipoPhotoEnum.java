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
 * Defineste tipul fotografiei
 *
 * @author STAD
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoPhotoEnum {
	/**
	 * Necasatorit.
	 */
	PNG("png"),
	/**
	 * Casatorit.
	 */
	BMP("bmp"),
	/**
	 * Divortat.
	 */
	JPEG("jpeg"),

	/**
	 * Vaduv.
	 */
	JPG("jpg");

	private static final List<TipoPhotoEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

	private static final int SIZE = VALUES.size();

	private static final Random RANDOM = new Random();

	/**
	 * @return Returnează o listă cu descrierile enum.
	 *
	 */
	public static List<TipoPhotoEnum> getStatus() {
		List<TipoPhotoEnum> tipsPhotos = new ArrayList<>();
		for (TipoPhotoEnum tipPhoto : TipoPhotoEnum.values()) {
			tipsPhotos.add(tipPhoto);
		}
		return tipsPhotos;
	}

	public static TipoPhotoEnum randomLetter() {
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

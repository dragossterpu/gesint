package ro.stad.online.gesint.persistence.entities.enums;

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
public enum TipPhotoEnum {
        /**
         * Png.
         */
        PNG("png"),
        /**
         * bmp.
         */
        BMP("bmp"),
        /**
         * jpeg.
         */
        JPEG("jpeg"),

        /**
         * jpg.
         */
        JPG("jpg");
        /**
         * Valoare statica VALUES
         */
        private static final List<TipPhotoEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

        /**
         * Valoare statica SIZE
         */
        private static final int SIZE = VALUES.size();

        /**
         * Valoare statica RANDOM
         */
        private static final Random RANDOM = new Random();

        /**
         * @return Returnează o listă cu descrierile enum.
         *
         */
        public static List<TipPhotoEnum> getStatus() {
                List<TipPhotoEnum> tipsPhotos = new ArrayList<>();
                for (TipPhotoEnum tipPhoto : TipPhotoEnum.values()) {
                        tipsPhotos.add(tipPhoto);
                }
                return tipsPhotos;
        }

        /**
         * Metoda care obtine o valoare rendom
         * @return
         */
        public static TipPhotoEnum randomLetter() {
                return VALUES.get(RANDOM.nextInt(SIZE));
        }

        /**
         * Descrierea enum.
         */
        private String descripere;

        /**
         * @return Numele enum-ului "
         */
        public String getName() {
                return name();
        }
}

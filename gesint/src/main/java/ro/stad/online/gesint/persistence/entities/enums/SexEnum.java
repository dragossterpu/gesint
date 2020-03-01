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
        WOMAN("Femeie");

        /**
         * Valoare statica VALUES
         */
        private static final List<SexEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

        /**
         * Valoare statica SIZE
         */
        private static final int SIZE = VALUES.size();

        /**
         * Valoare statica RANDOM
         */
        private static final Random RANDOM = new Random();

        /**
         * Recupera la lista de sex in aplicatie.
         * @return List<SexEnum>
         * @see ro.mira.per.controller.AdminController.getRoles()
         */
        public static List<SexEnum> getSex() {
                final List<SexEnum> sexs = new ArrayList<>();
                for (final SexEnum sex : SexEnum.values()) {
                        sexs.add(sex);
                }
                return sexs;
        }

        /**
         * Metoda care obtine o valoare rendom
         * @return
         */
        public static SexEnum randomLetter() {
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

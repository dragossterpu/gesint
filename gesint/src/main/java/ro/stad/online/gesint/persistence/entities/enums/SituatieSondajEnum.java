package ro.stad.online.gesint.persistence.entities.enums;

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
public enum SituatieSondajEnum {

        /**
         * Activ.
         */
        ACTIV("Activ"),
        /**
         * Casatorit.
         */
        FINALIZAT("Finalizat"),
        /**
         * Neînceput.
         */
        NEINCEPUT("Neînceput");

        /**
         * @return Descrierea enum-ului "
         */
        private String description;

        /**
         * @return Numele enum-ului "
         */
        public String getName() {
                return name();
        }
}

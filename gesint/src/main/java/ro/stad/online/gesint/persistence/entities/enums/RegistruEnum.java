package ro.stad.online.gesint.persistence.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * Enumerarea cu valorile posibile ale tipurilor de înregistrări de activitate.
 * @author STAD
 * 
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RegistruEnum {
        /**
         * Registrul corespunde unei inregistrari.
         */
        INREGISTRARE("Înregistrare"),
        /**
         * ERegistrul corespunde unei modificari.
         */
        MODIFICARE("Modificare"),
        /**
         * Registrul corespunde unei eliminari.
         */
        ELIMINARE("Eliminare"),
        /**
         * Registrul corespunde unei blocari.
         */
        BLOCARE("Blocare"),
        /**
         * Registrul corespunde unei activari.
         */
        ACTIVARE("Activare"),
        /**
         * Registrul corespunde unei cautari
         */
        CAUTARE("Căutare"),
        /**
         * Registrul corespunde uneierori.
         */
        EROARE("Eroare");

        /**
         * Descrierea tipului de înregistrare.
         */
        private String descriere;

        /**
         * @return Numele enum
         */
        public String getName() {
                return name();
        }

}

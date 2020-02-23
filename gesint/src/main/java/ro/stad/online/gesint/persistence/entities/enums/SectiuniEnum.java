package ro.stad.online.gesint.persistence.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Sunt listate pentru diferitele tipuri de secțiuni utilizate pentru gestionarea mesajelor.
 *
 * @author STAD
 *
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SectiuniEnum {

        /**
         * Secțiunea de autentificare
         */
        LOGIN("LOGIN"),

        /**
         * Secțiunea Utilizatori.
         */
        USERS("MEMBRU"),

        /**
         * Secțiunea de Început.
         */
        HOME("ACASĂ"),
        /**
         * Secțiunea de administrare formulare.
         */
        ADMINFORMULAR("ADMINISTRAȚIE FORMULARE"),

        /**
         * Secțiunea de administrare.
         */
        ADMINISTRARE("ADMINISTȚIE"),

        /**
         * Secțiune de corespondenta.
         */
        CORESPONDENTA("CORESPONDENȚĂ"),

        /**
         * Secțiune de Statistica si Evaluări .
         */
        STATISTICA("STATISTICĂ"),

        /**
         * Secțiunea Statistici utilizator.
         */
        STATISTICAUTILIZATOR("STATISTICĂ MEMBRU"),

        /**
         * Proiect.
         */
        PROIECT("PROIECT"),

        /**
         * Publicatii.
         */
        PUBLICATIONS("PUBLICAȚII"),

        /**
         * Secțiunea de comunicatii.
         */
        COMUNICARI("COMUNICAȚII"),
        /**
         * Secțiunea de judet.
         */
        JUDET("JUDEȚ"),
        /**
         * Secțiunea de management al documentelor.
         */
        MANAGERDOCUMENTE("MANAGER DOCUMENTE"),

        /**
         * Secțiunea de aplicatii.
         */
        SONDAJ("SONDAJ"),

        /**
         * Secțiunea de proprietăți.
         */
        PROPIETATI("PROPRIETĂȚI"),

        /**
         * Secțiunea de localitati.
         */
        LOCALITATI("LOCALITĂȚI"),

        /**
         * Secțiunea de partid.
         */
        PARTID("PARTID"),
        /**
         * Secțiunea echipa.
         */
        ECHIPA("ECHIPĂ"),
        /**
         * Secțiunea functie.
         */
        FUNCTIE("FUNCȚIE"),
        /**
         * Secțiunea procesare masiva utilizatori.
         */
        PROCESMASIV("PROCESARE_MASIVĂ"),
        /**
         * Alte secțiuni.
         */
        ALTELE("ALTELE");

        /**
         * Descrierea secțiunii.
         */
        private String descriere;

        /**
         * @return Numele enum
         */
        public String getName() {
                return name();
        }

}

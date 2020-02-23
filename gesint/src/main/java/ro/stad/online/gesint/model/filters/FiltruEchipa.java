package ro.stad.online.gesint.model.filters;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.enums.RolEnum;

/**
 * Controlor al operațiunilor legate de căutarea ECHIPEI. Resetați valorile căutării.
 *
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltruEchipa implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Filtru nune de utilizator.
         */
        private String username;

        /**
         * Filtru rol utilizator.
         */
        private RolEnum role;

        /**
         * Filtru nume utilizator.
         */
        private String nume;

        /**
         * Filtru prenume utilizator.
         */
        private String prenume;

        /**
         * Filtru email utilizator.
         */
        private String email;

        /**
         * Filtru judet utilizator.
         */
        private Judet judet;

        /**
         * Filtru judet utilizator.
         */
        private String idJudet;

        /**
         * Filtru data inregistrarii incepand.
         */
        private Date dataIncepand;

        /**
         * Filtru data inregistrarii pana.
         */
        private Date dataPana;

        /**
         * Variable utilizada para almacenar el valor de la judet seleccionada.
         *
         */
        private Judet judetSelectat;

        /**
         * Variable para functie
         */
        private Long idFunctia;

        /**
         * Variabla pentru lista de functii
         */
        private List<Functie> listaFunctii;
}

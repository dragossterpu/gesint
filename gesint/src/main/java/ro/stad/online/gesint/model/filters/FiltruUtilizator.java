package ro.stad.online.gesint.model.filters;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.RolEnum;
import ro.stad.online.gesint.persistence.entities.enums.SexEnum;
import ro.stad.online.gesint.persistence.entities.enums.StatutCivilEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;

/**
 * Controler al operațiunilor legate de căutarea utilizatorilor. Resetați valorile de căutare.
 *
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltruUtilizator implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Filtru nune de utilizator.
         */
        private String username;

        /**
         * Filtru cnp de utilizator.
         */
        private String idCard;

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
        private Long id;

        /**
         * Filtru localitate utilizator.
         */
        private Localitate localitate;

        /**
         * Filtru localitate utilizator.
         */
        private List<Localitate> listaLocalitatiSelectate;

        /**
         * Filtru lista nivel de studii utilizator.
         */
        private List<EducatieEnum> listaEducatie;

        /**
         * Filtru sex utilizator.
         */
        private SexEnum sex;

        /**
         * Filtru judet utilizator.
         */
        private String idJudet;

        /**
         * Filtru judet utilizator.
         */
        private List<String> listaIdJudet;

        /**
         * Filtru localitate utilizator.
         */
        private Long idLocalitate;

        /**
         * Filtru localitate utilizator.
         */
        private List<String> listaIdLocalitate;

        /**
         * Filtru stare civila utilizator.
         */
        private StatutCivilEnum statutCivil;

        /**
         * Filtru tipul localitatii utilizator.
         */
        private TipLocalitateEnum tipLocalitate;

        /**
         * Filtru activ/inactiv utilizator.
         */
        private Boolean validat;

        /**
         * Filtru destinatar extern.
         */
        private Boolean destinatarExtern;

        /**
         * Filtru data inregistrarii incepand.
         */
        private Date dateFrom;

        /**
         * Filtru data inregistrarii pana.
         */
        private Date dateUntil;

        /**
         * VariablA utilizata pentru judetul selectionat.
         *
         */
        private Judet judetSelectat;

        /**
         * VariablA utilizata pentru judetul selectionat.
         *
         */
        private List<Judet> listaJudeteSelectate;

        /**
         * Lista utilizatorilor selectați.
         */
        private List<Utilizator> utilizatoriSelectionati;

        /**
         * Variabilă pentru persoanele șterse
         */
        private String eliminat;

        /**
         * Variable para functie
         */
        private Long idFunctia;

        /**
         * Variabla pentru lista de functii
         */
        private List<Functie> listaFunctii;
}

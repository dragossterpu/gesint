package ro.stad.online.gesint.services;

import java.util.List;

import org.primefaces.model.SortOrder;

import ro.stad.online.gesint.model.filters.FiltruRegistru;
import ro.stad.online.gesint.persistence.entities.RegistruActivitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 *
 * Interfață de service pentru Registrul de Activitate.
 *
 * @author STAD
 *
 **/
public interface RegistruActivitateService {

        /**
         * Metoda care inregitraza un jurnal de activitate de tip eliminare.
         * @param infoUtilizator String
         * @return List<String>
         */
        List<String> cautareUtilizatorDupaRegistru(String infoUtilizator);

        /**
         * Metoda care cauta în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruRegistru FiltruRegistru Obiect care conține criteriile de căutare
         * @return Lista List<RegistruActivitate>
         *
         */
        List<RegistruActivitate> cautareRegistruActivitateCriteria(int first, int pageSize, String sortField,
                        SortOrder sortOrder, FiltruRegistru filtruRegistru);

        /**
         * Metoda care obține numărul de registre din baza de date
         * @param filtruRegistru FiltruRegistru
         * @return int
         */
        int getCounCriteria(FiltruRegistru filtruRegistru);

        /**
         * Metoda care inregitraza un jurnal de activitate.
         * @param idObiect Long
         * @param descriere String
         * @param ambitul String
         * @param obiect String
         */
        void salveazaRegistruInregistrareModificare(Long idObiect, String descriere, String ambit, String obiect);

        /**
         * Metoda care inregitraza un jurnal de activitate de tip eliminare.
         * @param idObiect Long
         * @param descriere String
         * @param ambitul String
         * @param obiect String
         */
        void salveazaRegistruEliminare(Long idObiect, String descriere, String ambitul, String obiect);

        /**
         * Metoda care inregitraza un jurnal de activitate de tip eroare.
         * @param ambitul String
         * @param obiect String
         * @param e Exception
         */
        void salveazaRegistruEroare(String ambitul, String obiect, Exception e);

        /**
         * Metoda care inregitraza un jurnal de activitate de tip login ok.
         * @param utilizator Utilizator
         */
        void salveazaRegistruLoginOK(Utilizator utilizator);

        /**
         * Metoda care inregitraza un jurnal de activitate de tip login ko.
         * @param utilizator String
         */
        void salveazaRegistruLoginKO(String utilizator);

        /**
         * Metoda care inregistreaza un jurnal de actiovitate
         * @param sectiune SectiuniEnum
         * @param tip String
         * @param descriere String
         */
        void inregistrareActivitate(String sectiune, String tip, String descriere);

        /**
         * Guarda en el registro de actividad el error que se ha producido.
         * @param seccion Dónde se produce el error
         * @param exception Excepción generada
         */
        void inregistrareEroare(String seccion, Exception exception);

        /**
         * Metoda care inregistreaza un jurnal de activitate
         * @param entity RegistruActivitate
         */
        void save(RegistruActivitate entity);

        /**
         * Metoda care înregistrează un jurnal de activitate.
         * @param sectiune String
         * @param tipReg String
         * @param descriere String
         * @param utilizator Utilizator
         */
        void inregistrareRegistruActivitate(String sectiune, String tipReg, String descriere, Utilizator user);

}

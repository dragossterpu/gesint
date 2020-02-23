package ro.stad.online.gesint.services;

import java.util.List;

import org.primefaces.model.SortOrder;

import ro.stad.online.gesint.model.filters.FiltruRezultat;
import ro.stad.online.gesint.persistence.entities.PartidRezultateJudete;
import ro.stad.online.gesint.persistence.entities.PartidRezultateLocalitate;

/**
 * Declarația metodelor care vor fi utilizate pentru persistența rezultatelor de la alegeri.
 * @author STAD
 *
 */
public interface RezultatService {

        /**
         * Cautare în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruRezultat FiltruRezultat Obiect care conține criteriile de căutare
         * @return Lista de documente List<PartidRezultateJudete>
         *
         */
        List<PartidRezultateJudete> cautareRezultatCriteria(int first, int pageSize, String sortField,
                        SortOrder sortOrder, FiltruRezultat filtruRezultat);

        /**
         * Cautare în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruRezultat FiltruRezultat Obiect care conține criteriile de căutare
         * @return Lista de documente List<PartidRezultateJudete>
         *
         */
        List<PartidRezultateLocalitate> cautareRezultatCriteriaLoc(int first, int pageSize, String sortField,
                        SortOrder sortOrder, FiltruRezultat filtruRezultat);

        /**
         * Metoda care cauta anii alegerilor
         * @return List<Integer>
         */
        List<Integer> cautaAni();

        /**
         * Metoda care obține numărul de registre din baza de date
         * @param filtruDocument FiltruDocument
         * @return int
         */
        int getCounCriteria(FiltruRezultat filtruDocument);

        /**
         * Metoda care salveaza sau actualizeaza un registru in baza dedate.
         * @param rezultat PartidRezultateJudete
         * @return PartidRezultateJudete
         */
        PartidRezultateJudete save(PartidRezultateJudete rezultat);

        /**
         * Metoda care cauta un partid dupa id
         * @param idPartid Long
         * @return partid PartidRezultateJudete
         */
        PartidRezultateJudete fiindOne(Long idPartid);

}

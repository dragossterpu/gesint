package ro.stad.online.gesint.services;

import java.util.List;

import org.hibernate.Criteria;
import org.primefaces.model.SortOrder;

import ro.stad.online.gesint.model.filters.FiltruProiect;
import ro.stad.online.gesint.persistence.entities.Proiect;

/**
 * Interfață pentru serviciul de ProiectService.
 *
 * @author STAD
 *
 */
public interface ProiectService {

        /**
         * Metodă care caută în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruProiect FiltruProiect Obiect care conține criteriile de căutare
         * @return Lista de proiecte List<Proiect>
         *
         */
        List<Proiect> cautareProiecteCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
                        FiltruProiect filtruProiect);

        /**
         * Metoda care elimina un proiect
         * @param proiect Proiect
         */
        void delete(Proiect proiect);

        /**
         * Metoda care returneaza toate proiectele inregistrate
         * @return lista List<Proiect>
         */
        List<Proiect> findAll();

        /**
         * Metoda care obținețe numărul de registre din baza de date
         * @param filtruProiect FiltruProiect
         * @return int
         */
        int getCounCriteria(FiltruProiect filtruProiect);

        /**
         * Metoda care salveaza sau actualizeaza un proiect.
         * @param proiect Proiect
         * @return Proiect actualizat
         */
        Proiect save(Proiect proiect);

        /**
         * Metoda care cauta toate proiectele ordonate dupa nivel de la mare la mic
         * @return lista List<Proiect>
         */
        List<Proiect> findAllByOrderByRankDesc();

        /**
         * Metoda care pregăteste ultimele criterii ca parametru pentru paginarea Primefaces.
         *
         * @param criteria Criteria
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param defaultField câmpul de ordonare prin defect
         */
        void pregatirePaginareOrdenareCriteria(Criteria criteria, int first, int pageSize, String sortField,
                        SortOrder sortOrder, String defaultField);
}

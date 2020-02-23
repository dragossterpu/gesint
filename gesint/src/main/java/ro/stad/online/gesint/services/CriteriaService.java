package ro.stad.online.gesint.services;

import org.hibernate.Criteria;
import org.primefaces.model.SortOrder;

/**
 * Interfață utilizată pentru a reduce duplicarea codului în criterii motorului de căutare.
 *
 * @author STAD
 *
 */
public interface CriteriaService {

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

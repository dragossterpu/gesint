package ro.stad.online.gesint.services.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Service;

import ro.stad.online.gesint.services.CriteriaService;

/**
 * Clase utilizada para reducir la duplicidad de código en los critera de los cautatores.
 *
 * @author STAD
 *
 */
@Service("criteriaService")
public class CriteriaServiceImpl implements CriteriaService {

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
        @Override
        public void pregatirePaginareOrdenareCriteria(final Criteria criteria, final int first, final int pageSize,
                        final String sortField, final SortOrder sortOrder, final String defaultField) {
                criteria.setFirstResult(first);
                criteria.setMaxResults(pageSize);

                if (sortField != null && sortOrder.equals(SortOrder.ASCENDING)) {
                        criteria.addOrder(Order.asc(sortField));
                }
                else if (sortField != null && sortOrder.equals(SortOrder.DESCENDING)) {
                        criteria.addOrder(Order.desc(sortField));
                }
                else if (sortField == null) {
                        criteria.addOrder(Order.asc(defaultField));
                }
        }

}

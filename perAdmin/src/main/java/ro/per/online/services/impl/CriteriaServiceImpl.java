package ro.per.online.services.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Service;

import ro.per.online.services.CriteriaService;

/**
 * Clase utilizada para reducir la duplicidad de código en los critera de los buscadores.
 *
 * @author EZENTIS
 *
 */
@Service("criteriaService")
public class CriteriaServiceImpl implements CriteriaService {

	/**
	 * Prepara el criteria pasado como parámetro para la paginación de Primefaces.
	 *
	 * @param criteria criteria a configurar
	 * @param first primer elemento
	 * @param pageSize tamaño de cada página de resultados
	 * @param sortField campo por el que se ordenan los resultados
	 * @param sortOrder sentido de la ordenacion (ascendente/descendente)
	 * @param defaultField campo de ordenación por defecto
	 */
	@Override
	public void prepararPaginacionOrdenCriteria(final Criteria criteria, final int first, final int pageSize,
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

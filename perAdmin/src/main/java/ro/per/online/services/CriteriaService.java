package ro.per.online.services;

import org.hibernate.Criteria;
import org.primefaces.model.SortOrder;

/**
 * Interfaz utilizada para reducir la duplicidad de código en los critera de los buscadores.
 *
 * @author STAD
 *
 */
public interface CriteriaService {

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
	void prepararPaginacionOrdenCriteria(Criteria criteria, int first, int pageSize, String sortField,
			SortOrder sortOrder, String defaultField);

}

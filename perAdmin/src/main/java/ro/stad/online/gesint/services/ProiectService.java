package ro.per.online.services;

import java.util.List;

import org.hibernate.Criteria;
import org.primefaces.model.SortOrder;

import ro.per.online.persistence.entities.Proiecte;
import ro.per.online.web.beans.ProiectBusqueda;

/**
 * Interfaz del servicio para la gestión de proyectos.
 *
 * @author STAD
 *
 */
public interface ProiectService {

	/**
	 * Busca proiecte con los parametros de búsqueda.
	 * @param proiectBusqueda ProiectBusqueda
	 * @param sortOrder SortOrder
	 * @param sortField String
	 * @param pageSize int
	 * @param first int
	 *
	 * @return List<Proiecte>
	 *
	 *
	 */
	List<Proiecte> buscarProiecteCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			ProiectBusqueda proiectBusqueda);

	/**
	 * Elimina un proiect
	 *
	 * @param proiect Proiecte
	 */
	void delete(Proiecte proiect);

	/**
	 * Returneaza o lista cu toate proiectele.
	 * @return List<Proiecte>
	 */
	List<Proiecte> findAll();

	/**
	 * Obtiene el conteo de criteria.
	 * @param proiectBusqueda ProiectBusqueda
	 * @return int
	 */
	int getCounCriteria(ProiectBusqueda proiectBusqueda);

	/**
	 * Salvați sau actualizați un proiect.
	 *
	 * @param proiect
	 * @return Proiect actualizat
	 */
	Proiecte save(Proiecte proiect);

	/**
	 * Obtinem nivelul cel mai mare
	 *
	 * @param team
	 * @return Team actualizat
	 */
	List<Proiecte> findAllByOrderByRankDesc();

	/**
	 * @param criteria
	 * @param first
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @param defaultField
	 *
	 */
	void prepararPaginacionOrdenCriteria(Criteria criteria, int first, int pageSize, String sortField,
			SortOrder sortOrder, String defaultField);
}

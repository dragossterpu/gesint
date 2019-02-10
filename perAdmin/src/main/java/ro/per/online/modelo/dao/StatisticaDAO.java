package ro.per.online.modelo.dao;

import java.util.List;

import ro.per.online.modelo.dto.estadisticas.StatisticaDTO;
import ro.per.online.modelo.filters.StatisticaBusqueda;

/**
 * Interfața metodelor statistice.
 *
 * @author STAD
 *
 */
public interface StatisticaDAO extends PerDAO {

	/**
	 * Metoda de filtrare pentru generale
	 * @param filter filtru
	 * @return Lista de estadistica
	 */
	List<StatisticaDTO> filterGeneraleStatistica(StatisticaBusqueda filter);

}

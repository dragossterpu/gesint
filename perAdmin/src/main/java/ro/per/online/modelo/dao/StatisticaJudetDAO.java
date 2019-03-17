package ro.per.online.modelo.dao;

import java.util.List;

import ro.per.online.modelo.dto.estadisticas.StatisticaJudetDTO;
import ro.per.online.modelo.dto.estadisticas.StatisticaJudetMinimDTO;
import ro.per.online.modelo.filters.StatisticaJudeteBusqueda;

/**
 * Interfața metodelor statistice.
 *
 * @author STAD
 *
 */
public interface StatisticaJudetDAO extends PerDAO {

	/**
	 * Metoda de obtinere a datelor minim
	 * @return StatisticaJudetMinimDTO
	 */
	List<StatisticaJudetMinimDTO> dateMinime();

	/**
	 * Metoda de filtrare pentru generale
	 * @param filter filtru
	 * @return Lista de estadistica
	 */
	List<StatisticaJudetDTO> filterStatisticaJudet(StatisticaJudeteBusqueda filter);

	/**
	 * Metoda de filtrare pentru generale
	 * @param filter filtru
	 * @return Lista de estadistica
	 */
	List<StatisticaJudetDTO> filterStatisticaJudetProcentaj(StatisticaJudeteBusqueda filter);
}

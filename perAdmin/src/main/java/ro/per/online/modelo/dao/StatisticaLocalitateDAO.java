package ro.per.online.modelo.dao;

import java.util.List;

import ro.per.online.modelo.dto.estadisticas.StatisticaLocalitateDTO;
import ro.per.online.modelo.filters.StatisticaJudeteBusqueda;

/**
 * Interfața metodelor statistice.
 *
 * @author STAD
 *
 */
public interface StatisticaLocalitateDAO extends PerDAO {

	/**
	 * Metoda de filtrare pentru generale lcalitati
	 * @param filter filtru
	 * @return Lista de estadistica
	 */
	List<StatisticaLocalitateDTO> filterStatisticaLocalitateProcentaj(StatisticaJudeteBusqueda filter);
}

package ro.stad.online.gesint.model.dao;

import java.util.List;

import ro.stad.online.gesint.model.dto.statistica.StatisticaLocalitateDTO;
import ro.stad.online.gesint.model.filters.FiltruStatisticaJudete;

/**
 * Interfața metodelor statistice.
 *
 * @author STAD
 *
 */
public interface StatisticaLocalitateDAO extends GesintDAO {

        /**
         * Metoda de filtrare pentru generale localitati
         * @param filter filtru
         * @return lista List<StatisticaLocalitateDTO> Lista de estadistica
         */
        List<StatisticaLocalitateDTO> filterStatisticaLocalitateProcentaj(FiltruStatisticaJudete filter);
}

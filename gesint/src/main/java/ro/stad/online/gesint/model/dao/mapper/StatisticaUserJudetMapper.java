package ro.stad.online.gesint.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.stad.online.gesint.model.dto.statistica.StatisticaJudetDTO;

/**
 * Clasa Mapper de rapoarte statistice care transfera conținutul BD la un DTO.
 *
 * @author STAD
 *
 */
public final class StatisticaUserJudetMapper implements RowMapper<StatisticaJudetDTO> {

        /**
         * Clasa construita pentru a evita duplicitate de cod
         */
        StatisticaAbstractMapper statMaper;

        /**
         * Conversia unui registru la o clasă dto.
         * @param rs ResultSet
         * @param rowNum int
         * @return StatisticaJudetDTO fila stadistica
         */
        @Override
        public StatisticaJudetDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                return statMaper.dtoMaperr(rs);

        }

}

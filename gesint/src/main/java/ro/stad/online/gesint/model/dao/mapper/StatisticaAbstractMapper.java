package ro.stad.online.gesint.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.dto.statistica.StatisticaJudetDTO;

/**
 * Clasa construita pentru a evita duplicitate de cod
 *
 * @author STAD
 *
 */
public final class StatisticaAbstractMapper {

        /**
         * Conversia unui registru la o clasă dto.
         * @param rs ResultSet
         * @param rowNum int
         * @return StatisticaJudetDTO fila stadistica
         */
        StatisticaJudetDTO dtoMaperr(final ResultSet rs) throws SQLException {
                final StatisticaJudetDTO dto = new StatisticaJudetDTO();
                dto.setCodJudet(rs.getString("cod_judet"));
                dto.setNume(rs.getString(Constante.NUME));
                dto.setTotalLocuitori(rs.getInt("populatie"));
                dto.setNumarMembrii(rs.getInt("numero"));
                dto.setProcentaj(rs.getFloat("procentaj"));
                dto.setLocuitoriVot(rs.getInt("locuitoriVot"));
                dto.setMembriiMinim(rs.getInt("membrii_minim"));
                return dto;
        }

}

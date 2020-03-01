package ro.stad.online.gesint.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.dto.statistica.RezultateDTO;

/**
 * Clasa Mapper de rapoarte statistice care transfera conținutul BD la un DTO.
 *
 * @author STAD
 *
 */
public final class RezultateMapper implements RowMapper<RezultateDTO> {

        /**
         * Conversia unui registru la o clasă dto.
         * @param rs ResultSet
         * @param rowNum int
         * @return RezultateDTO fila stadistica
         */
        @Override
        public RezultateDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                final RezultateDTO dto = new RezultateDTO();

                dto.setNume(rs.getString(Constante.NUME));
                dto.setMandatePartid(rs.getInt("mandatePartid"));
                dto.setTotalMandate(rs.getInt("totalMandate"));
                dto.setTotalVoturi(rs.getInt("totalVoturi"));
                dto.setVoturiPartid(rs.getInt("voturiPartid"));
                dto.setSigla(rs.getString("sigla"));
                dto.setId(rs.getLong(Constante.ID));
                return dto;
        }

}

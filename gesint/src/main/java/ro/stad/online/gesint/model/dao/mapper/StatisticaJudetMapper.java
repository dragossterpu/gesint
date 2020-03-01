package ro.stad.online.gesint.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.dto.statistica.StatisticaJudetDTO;

/**
 * Clasa Mapper de rapoarte statistice care transfera conținutul BD la un DTO.
 *
 * @author STAD
 *
 */
public final class StatisticaJudetMapper implements RowMapper<StatisticaJudetDTO> {

	/**
	 * Conversia unui registru la o clasă dto.
	 * @param rs ResultSet
	 * @param rowNum int
	 * @return StatisticaJudetDTO fila stadistica
	 */
	@Override
	public StatisticaJudetDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		final StatisticaJudetDTO dto = new StatisticaJudetDTO();
		dto.setCodJudet(rs.getString("cod_judet"));
		dto.setNume(rs.getString(Constante.NUME));
		dto.setTotalLocuitori(rs.getInt("populatie"));
		dto.setNumarMembrii(rs.getInt("numero"));
		dto.setProcentaj(rs.getFloat("procentaj"));
		dto.setLocuitoriVot(rs.getInt("locuitoriVot"));
		dto.setMembriiMinim(rs.getInt("membrii_minim"));
		dto.setVoturiMinim(rs.getInt("voturi_minim"));
		return dto;
	}

}

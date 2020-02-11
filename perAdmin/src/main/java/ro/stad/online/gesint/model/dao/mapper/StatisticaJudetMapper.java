package ro.per.online.modelo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.per.online.modelo.dto.estadisticas.StatisticaJudetDTO;

/**
 * Clasa Mapper de rapoarte statistice care transfera conținutul BD la un DTO.
 *
 * @author STAD
 *
 */
public final class StatisticaJudetMapper implements RowMapper<StatisticaJudetDTO> {

	/**
	 * Conversia unui rând de rapoarte de interogări pe corp la o clasă dto.
	 *
	 * @return fila stadistica
	 */
	@Override
	public StatisticaJudetDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		final StatisticaJudetDTO dto = new StatisticaJudetDTO();

		dto.setCode_province(rs.getString("code_province"));
		dto.setNume(rs.getString("name"));
		dto.setTotalLocuitori(rs.getInt("population"));
		dto.setNumarMembrii(rs.getInt("numero"));
		dto.setProcentaj(rs.getFloat("procentaj"));
		dto.setLocuitoriVot(rs.getInt("locuitoriVot"));
		dto.setMembriiMinim(rs.getInt("membrii_minim"));
		dto.setVoturiMinim(rs.getInt("voturi_minim"));
		return dto;
	}

}

package ro.per.online.modelo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.per.online.modelo.dto.estadisticas.StatisticaLocalitateDTO;

/**
 * Clasa Mapper de rapoarte statistice care transfera conținutul BD la un DTO.
 *
 * @author STAD
 *
 */
public final class StatisticaLocalitateMapper implements RowMapper<StatisticaLocalitateDTO> {

	/**
	 * Conversia unui rând de rapoarte de interogări pe corp la o clasă dto.
	 *
	 * @return fila stadistica
	 */
	@Override
	public StatisticaLocalitateDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		final StatisticaLocalitateDTO dto = new StatisticaLocalitateDTO();
		dto.setNumeProvincie(rs.getString("numeprovincie"));
		dto.setCodeProvincie(rs.getString("code_province"));
		dto.setNumeLocalitate(rs.getString("name"));
		dto.setSector(rs.getString("sector"));
		dto.setTotalLocuitori(rs.getInt("locuitori"));
		dto.setNumarMembrii(rs.getInt("numero"));
		dto.setProcentaj(rs.getFloat("procentaj"));
		dto.setLocuitoriVot(rs.getInt("locuitoriVot"));
		dto.setTotalMembrii(rs.getInt("totalMembrii"));
		dto.setMembriiMinim(rs.getInt("membrii_minim"));
		dto.setVoturiMinim(rs.getInt("voturi_minim"));
		return dto;
	}

}

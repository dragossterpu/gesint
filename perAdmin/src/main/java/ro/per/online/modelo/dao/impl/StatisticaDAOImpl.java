package ro.per.online.modelo.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.per.online.modelo.dao.StatisticaDAO;
import ro.per.online.modelo.dao.mapper.StatisticaMapper;
import ro.per.online.modelo.dto.estadisticas.StatisticaDTO;
import ro.per.online.modelo.filters.StatisticaBusqueda;

/**
 * Clasa care implementează metodele de obținere a datelor de statistici.
 *
 * @author STAD
 *
 */
@Repository
public class StatisticaDAOImpl implements StatisticaDAO {

	/**
	 * namedParameterJdbcTemplate.
	 *
	 */
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Sursa de date.
	 *
	 */
	@Override
	@Autowired
	public void setDataSource(DataSource ds) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	/**
	 * Datele statisticii generale.
	 *
	 * @return
	 */
	@Override
	public List<StatisticaDTO> filterGeneraleStatistica(StatisticaBusqueda filter) {

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final StringBuilder sql = new StringBuilder();

		sql.append(" SELECT COUNT(*) AS numarTotal,");
		sql.append("(SELECT COUNT(*) FROM users WHERE education= 'LICEU') AS totalcuLiceu,");
		sql.append("(SELECT COUNT(*) FROM users WHERE education= 'STUDIISUPERIOARE') AS totalStudiiSup,");
		sql.append("(SELECT COUNT(*) FROM users WHERE education= 'BAZIC') AS totalBazice,");
		sql.append("(SELECT SUM(population)FROM pprovince)AS locuitoriTotal,");
		sql.append("(SELECT COUNT(*) FROM users WHERE sex= 'MAN') AS totalBarbati,");
		sql.append("(SELECT COUNT(*) FROM users WHERE sex= 'WOMAN') AS totalFemei,");
		sql.append(
				"(SELECT DISTINCT ROUND((SELECT SUM(population)FROM pprovince)- ((SELECT SUM(population)FROM pprovince)*0.2)) AS locuitori FROM pprovince ) AS totalVot,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimaLuna()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimaLuna,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimDouaLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimDouaLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimTreiLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimTreiLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimPatruLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimPatruLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimCinciLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimCinciLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimSaseLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimSaseLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimSapteLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimSapteLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimOptLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimOptLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimNouaLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimNouaLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimZeceLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimZeceLuni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimUnspeLuni()) + "' AND DATE '" + sdf.format(filter.getFechaDesde())
				+ "') AS totalUltimUnspeLuni,");
		sql.append(
				"(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '" + sdf.format(filter.getFechaUltimAn())
						+ "' AND DATE '" + sdf.format(filter.getFechaDesde()) + "') AS totalUltimAn,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimaLunaAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimaLunaAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimDouaLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimDouaLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimTreiLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimTreiLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimPatruLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimPatruLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimCinciLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimCinciLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimSaseLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimSaseLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimSapteLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimSapteLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimOptLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimOptLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimNouaLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimNouaLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimZeceLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimZeceLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimUnspeLuniAnTrecut()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimAn()) + "') AS totalUltimUnspeLuniAnAtras,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimiDoiAni()) + "' AND DATE '" + sdf.format(filter.getFechaUltimAn())
				+ "') AS totalUltimiDoiAni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimiTreiAni()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimiDoiAni()) + "') AS totalUltimiiTreiAni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimiPatruAni()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimiTreiAni()) + "') AS totalUltimiiPatruAni,");
		sql.append("(SELECT COUNT(*)  FROM users WHERE DATE_create BETWEEN DATE '"
				+ sdf.format(filter.getFechaUltimiCinciAni()) + "' AND DATE '"
				+ sdf.format(filter.getFechaUltimiPatruAni()) + "') AS totalUltimiiCinciAni,");
		sql.append(
				"(SELECT COUNT(*) FROM users u, plocality l WHERE  u.LOCALITY_ID = l.id AND l.nivel =3)AS mediuRural,");
		sql.append(
				"(SELECT COUNT(*) FROM users u, plocality l WHERE  u.LOCALITY_ID = l.id AND l.nivel in(2,3))AS mediuUrban,");
		sql.append("(SELECT SUM(locuitori) FROM plocality WHERE nivel =3) AS locuitoriTotalRural, ");
		sql.append("(SELECT SUM(locuitori) FROM plocality WHERE nivel in(2,3)) AS locuitoriTotalUrban ");
		sql.append("FROM users ");

		final MapSqlParameterSource parameters = new MapSqlParameterSource();

		parameters.addValue("fechaDesde", filter.getFechaDesde());
		parameters.addValue("fechaUltimAn", filter.getFechaUltimAn());
		parameters.addValue("fechaUltimaLuna", filter.getFechaUltimaLuna());
		parameters.addValue("fechaUltimDouaLuni", filter.getFechaUltimDouaLuni());
		parameters.addValue("fechaUltimTreiLuni", filter.getFechaUltimTreiLuni());
		parameters.addValue("fechaUltimPatruLuni", filter.getFechaUltimPatruLuni());
		parameters.addValue("fechaUltimCinciLuni", filter.getFechaUltimCinciLuni());
		parameters.addValue("fechaUltimSaseLuni", filter.getFechaUltimSaseLuni());
		parameters.addValue("fechaUltimSapteLuni", filter.getFechaUltimSapteLuni());
		parameters.addValue("fechaUltimOptLuni", filter.getFechaUltimOptLuni());
		parameters.addValue("fechaUltimNouaLuni", filter.getFechaUltimNouaLuni());
		parameters.addValue("fechaUltimZeceLuni", filter.getFechaUltimZeceLuni());
		parameters.addValue("fechaUltimUnspeLuni", filter.getFechaUltimUnspeLuni());
		parameters.addValue("fechaUltimaLunaAnTrecut", filter.getFechaUltimaLunaAnTrecut());
		parameters.addValue("fechaUltimaDouaLuniAnTrecut", filter.getFechaUltimDouaLuniAnTrecut());
		parameters.addValue("fechaUltimaTreiLuniAnTrecut", filter.getFechaUltimTreiLuniAnTrecut());
		parameters.addValue("fechaUltimaPatruLuniAnTrecut", filter.getFechaUltimPatruLuniAnTrecut());
		parameters.addValue("fechaUltimaCinciLuniAnTrecut", filter.getFechaUltimCinciLuniAnTrecut());
		parameters.addValue("fechaUltimaSaseLuniAnTrecut", filter.getFechaUltimSaseLuniAnTrecut());
		parameters.addValue("fechaUltimaSapteLuniAnTrecut", filter.getFechaUltimSapteLuniAnTrecut());
		parameters.addValue("fechaUltimaOptLuniAnTrecut", filter.getFechaUltimOptLuniAnTrecut());
		parameters.addValue("fechaUltimaNouaLuniAnTrecut", filter.getFechaUltimNouaLuniAnTrecut());
		parameters.addValue("fechaUltimaZeceLuniAnTrecut", filter.getFechaUltimZeceLuniAnTrecut());
		parameters.addValue("fechaUltimaUnspeLuniAnTrecut", filter.getFechaUltimUnspeLuniAnTrecut());
		parameters.addValue("fechaUltimiDoiAni", filter.getFechaUltimiDoiAni());
		parameters.addValue("fechaUltimiTreiAni", filter.getFechaUltimiTreiAni());
		parameters.addValue("fechaUltimiPatruAni", filter.getFechaUltimiPatruAni());
		parameters.addValue("fechaUltimiCinciAni", filter.getFechaUltimiCinciAni());
		return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaMapper());
	}

}

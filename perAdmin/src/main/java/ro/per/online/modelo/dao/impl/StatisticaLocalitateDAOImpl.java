package ro.per.online.modelo.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.per.online.modelo.dao.StatisticaLocalitateDAO;
import ro.per.online.modelo.dao.mapper.StatisticaLocalitateMapper;
import ro.per.online.modelo.dto.estadisticas.StatisticaLocalitateDTO;
import ro.per.online.modelo.filters.StatisticaJudeteBusqueda;

/**
 * Clasa care implementează metodele de obținere a datelor de statistici.
 *
 * @author STAD
 *
 */
@Repository
public class StatisticaLocalitateDAOImpl implements StatisticaLocalitateDAO {

	/**
	 * namedParameterJdbcTemplate.
	 *
	 */
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Datele statisticii generale.
	 * @param StatisticaJudeteBusqueda filter
	 * @return List<StatisticaJudetDTO>
	 */
	@Override
	public List<StatisticaLocalitateDTO> filterStatisticaLocalitateProcentaj(final StatisticaJudeteBusqueda filter) {
		final StringBuilder sql = new StringBuilder();

		sql.append(
				"SELECT totalMembrii,numeprovincie, code_province,name,sector, numero, locuitori, procentaj, locuitoriVot  FROM (SELECT (select count(*) from users where code_province='"
						+ filter.getCode_province() + "')as totalMembrii,"
						+ " (SELECT name FROM pprovince WHERE code_province= '" + filter.getCode_province()
						+ "') as numeprovincie, '" + filter.getCode_province() + "' as code_province, "
						+ " ss.name,ss.sector, ss.numero,ss.locuitori,ROUND((ss.numero*100.0)/(ss.locuitori),2) AS procentaj,"
						+ " (select ROUND(ss.locuitori-(ss.locuitori*0.21)) as locuitori) as locuitoriVot "
						+ " FROM ( SELECT COUNT(*) as numero, l.name,l.locuitori,l.sector FROM USERS U, PLOCALITY l  WHERE u.locality_id = l.id AND U.code_province= "
						+ " '" + filter.getCode_province() + "' "
						+ " GROUP BY u.locality_id, l.name, l.locuitori,l.sector ORDER BY numero desc) as SS ) as dd ORDER BY dd.procentaj DESC");

		final MapSqlParameterSource parameters = new MapSqlParameterSource();

		parameters.addValue("fechaDesde", filter.getFechaDesde());

		return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaLocalitateMapper());
	}

	/**
	 * Sursa de date.
	 *
	 */
	@Override
	@Autowired
	public void setDataSource(final DataSource ds) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

}

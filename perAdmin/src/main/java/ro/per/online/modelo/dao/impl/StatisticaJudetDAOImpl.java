package ro.per.online.modelo.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.per.online.modelo.dao.StatisticaJudetDAO;
import ro.per.online.modelo.dao.mapper.StatisticaJudetMapper;
import ro.per.online.modelo.dto.estadisticas.StatisticaJudetDTO;
import ro.per.online.modelo.filters.StatisticaJudeteBusqueda;

/**
 * Clasa care implementează metodele de obținere a datelor de statistici.
 *
 * @author STAD
 *
 */
@Repository
public class StatisticaJudetDAOImpl implements StatisticaJudetDAO {

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
	public void setDataSource(final DataSource ds) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	/**
	 * Datele statisticii generale.
	 * @param StatisticaJudeteBusqueda filter
	 * @return List<StatisticaJudetDTO>
	 */
	@Override
	public List<StatisticaJudetDTO> filterStatisticaJudet(final StatisticaJudeteBusqueda filter) {
		final StringBuilder sql = new StringBuilder();

		sql.append(
				" SELECT ss.name, ss.numero,ss.population,ss.code_province, ROUND((ss.numero*100.0)/(ss.population),2) AS procentaj , (select ROUND(ss.population-(ss.population*0.21)) as locuitori) as locuitoriVot FROM ( SELECT COUNT(*) as numero, P.NAME, P.code_province,p.population FROM USERS U, PPROVINCE P WHERE u.code_province = p.code_province"
						+ " group by u.code_province,p.name,p.population ,P.code_province ORDER BY numero "
						+ filter.getDescendent() + ") as SS  limit 7 offset 0 ");

		final MapSqlParameterSource parameters = new MapSqlParameterSource();

		parameters.addValue("fechaDesde", filter.getFechaDesde());

		return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaJudetMapper());
	}

	/**
	 * Datele statisticii generale.
	 * @param StatisticaJudeteBusqueda filter
	 * @return List<StatisticaJudetDTO>
	 */
	@Override
	public List<StatisticaJudetDTO> filterStatisticaJudetProcentaj(final StatisticaJudeteBusqueda filter) {
		final StringBuilder sql = new StringBuilder();

		sql.append(
				"SELECT name, numero, population, procentaj, code_province,locuitoriVot from (SELECT ss.name, ss.code_province,ss.numero,ss.population,ROUND((ss.numero*100.0)/(ss.population),2) "
						+ "AS procentaj, (select ROUND(ss.population-(ss.population*0.21)) as locuitori) as locuitoriVot FROM ( SELECT COUNT(*) as numero, P.NAME, p.population,p.code_province FROM USERS U, PPROVINCE P WHERE u.code_province = p.code_province "
						+ " group by u.code_province,p.name,p.population,p.code_province  ORDER BY numero "
						+ filter.getDescendent() + ") as SS  ) as dd order by dd.procentaj " + filter.getDescendent());

		final MapSqlParameterSource parameters = new MapSqlParameterSource();

		if (filter.getGeneralJudetProcentaj().equals("NO")) {
			sql.append(" limit 7 offset 0");
		}

		parameters.addValue("fechaDesde", filter.getFechaDesde());

		return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaJudetMapper());
	}

}

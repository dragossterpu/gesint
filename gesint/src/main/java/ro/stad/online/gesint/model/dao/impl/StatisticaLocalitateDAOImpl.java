package ro.stad.online.gesint.model.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.model.dao.StatisticaLocalitateDAO;
import ro.stad.online.gesint.model.dao.mapper.StatisticaLocalitateMapper;
import ro.stad.online.gesint.model.dto.statistica.StatisticaLocalitateDTO;
import ro.stad.online.gesint.model.filters.FiltruStatisticaJudete;

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
         */
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        /**
         * Metoda care obtine datele statisticii generale.
         * @param FiltruStatisticaJudete filter
         * @return list List<StatisticaJudetDTO> lista cu rezultatele
         */
        @Override
        public List<StatisticaLocalitateDTO> filterStatisticaLocalitateProcentaj(final FiltruStatisticaJudete filter) {
                final StringBuilder sql = new StringBuilder(NumarMagic.NUMBERFIFTY);

                sql.append(Constante.SQLSELECTSTATLOC).append(filter.getCodJudet())
                                .append(Constante.SQLSELECTSTATLOCTOTMEM).append(filter.getCodJudet())
                                .append("') as numeprovincie,").append(Constante.SPATIUVIRGULASUS)
                                .append(filter.getCodJudet()).append(Constante.SQLSELECTSTATLOCCODJ)
                                .append(filter.getCodJudet()).append(Constante.SQLSELECTSTATLOCNUM)
                                .append(filter.getCodJudet()).append(Constante.SPATIUVIRGULASUS)
                                .append(Constante.SQLSELECTSTATGROUP);

                final MapSqlParameterSource parameters = new MapSqlParameterSource();
                return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaLocalitateMapper());
        }

        /**
         * Sursa de date.
         * @param ds DataSource
         */
        @Override
        @Autowired
        public void setDataSource(final DataSource ds) {
                this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
        }

}

package ro.stad.online.gesint.model.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.dao.StatisticaJudetDAO;
import ro.stad.online.gesint.model.dao.mapper.StatisticaJudetMapper;
import ro.stad.online.gesint.model.dao.mapper.StatisticaJudetMinimMapper;
import ro.stad.online.gesint.model.dao.mapper.StatisticaUserJudetMapper;
import ro.stad.online.gesint.model.dto.statistica.StatisticaJudetDTO;
import ro.stad.online.gesint.model.dto.statistica.StatisticaJudetMinimDTO;
import ro.stad.online.gesint.model.filters.FiltruStatisticaJudete;

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
         */
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        /**
         * Metoda de obtinere a datelor minim
         * @return lista List<StatisticaJudetMinimDTO> lista cu rezultate
         */
        @Override
        public List<StatisticaJudetMinimDTO> dateMinime() {
                final StringBuilder sql = new StringBuilder();
                sql.append("select sum(membrii_minim) as membrii_minim, sum (voturi_minim)as voturi_minim from judet");
                final MapSqlParameterSource parameters = new MapSqlParameterSource();
                return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaJudetMinimMapper());
        }

        /**
         * Metoda care obtine datele statisticii generale.
         * @param FiltruStatisticaJudete filter
         * @return lista List<StatisticaJudetDTO> lista cu rezultate
         */
        @Override
        public List<StatisticaJudetDTO> filterStatisticaJudet(final FiltruStatisticaJudete filter) {
                final StringBuilder sql = new StringBuilder();

                sql.append(" SELECT ss.nume, ss.numero,ss.membrii_minim, ss.populatie,ss.cod_judet, ROUND((ss.numero*100.0)/(ss.membrii_minim),2) AS procentaj , (select ROUND(ss.populatie-(ss.populatie*0.21)) as locuitori) as locuitoriVot FROM ( SELECT COUNT(*) as numero, p.nume, P.cod_judet,p.populatie,p.membrii_minim  FROM utilizator U, judet P WHERE u.cod_judet = p.cod_judet"
                                + " group by u.cod_judet,p.nume,p.populatie ,p.cod_judet,p.membrii_minim  ORDER BY numero "
                                + filter.getDescendent() + ") as SS order by procentaj " + filter.getDescendent()
                                + Constante.LIMITOFFSET);
                final MapSqlParameterSource parameters = new MapSqlParameterSource();
                return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaUserJudetMapper());
        }

        /**
         * Datele statisticii generale.
         * @param FiltruStatisticaJudete filter
         * @return List<StatisticaJudetDTO> lista cu rezultate
         */
        @Override
        public List<StatisticaJudetDTO> filterStatisticaJudetProcentaj(final FiltruStatisticaJudete filter) {
                final StringBuilder sql = new StringBuilder();
                sql.append("SELECT nume,membrii_minim,voturi_minim, numero, populatie, procentaj, cod_judet,locuitoriVot from (SELECT ss.nume,ss.membrii_minim,ss.voturi_minim, ss.cod_judet,ss.numero,ss.populatie,ROUND((ss.numero*100.0)/(ss.membrii_minim),2) "
                                + "AS procentaj, (select ROUND(ss.populatie-(ss.populatie*0.21)) as locuitori) as locuitoriVot FROM ( SELECT COUNT(*) as numero, p.nume, p.populatie,p.cod_judet ,p.membrii_minim,p.voturi_minim FROM utilizator U, judet P WHERE u.cod_judet = p.cod_judet "
                                + " group by u.cod_judet,p.nume,p.populatie,p.cod_judet,p.membrii_minim,p.voturi_minim  ORDER BY numero "
                                + filter.getDescendent() + ") as SS  ) as dd order by dd.procentaj "
                                + filter.getDescendent());
                final MapSqlParameterSource parameters = new MapSqlParameterSource();
                if (filter.getGeneralJudetProcentaj().equals(Constante.NO)) {
                        sql.append(Constante.LIMITOFFSET);
                }
                return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaJudetMapper());
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

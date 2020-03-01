package ro.stad.online.gesint.model.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.model.dao.RezultateDAO;
import ro.stad.online.gesint.model.dao.mapper.RezultateMapper;
import ro.stad.online.gesint.model.dto.statistica.RezultateDTO;
import ro.stad.online.gesint.model.filters.FiltruRezultat;

/**
 * Clasa care implementează metodele de obținere a datelor de rezultate.
 *
 * @author STAD
 *
 */
@Repository
public class RezultateDAOImpl implements RezultateDAO {

        /**
         * namedParameterJdbcTemplate.
         */
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        /**
         * Metoda care obtine datele statisticii generale.
         * @param filter FiltruRezultat
         * @return lista List<RezultateDTO> lista cu rezultatele
         */
        @Override
        public List<RezultateDTO> filterGeneraleRezultate(final FiltruRezultat filter) {

                final StringBuilder sql = new StringBuilder(NumarMagic.NUMBERHUNDRED);
                sql.append(Constante.SQLSELECTREZULTAT).append(filter.getAnAlegeri()).append(Constante.SPATIU);
                if (filter.getIdPartid() != null) {
                        sql.append(Constante.ANDPARTIDSQL).append(filter.getIdPartid()).append(Constante.SPATIU);
                }
                extractMetodPartiJudet(filter, sql);
                if (!Constante.SPATIU.equals(filter.getIdProvincia()) && filter.getIdProvincia() != null) {
                        sql.append(Constante.ANDJUDETSQL).append(filter.getIdProvincia())
                                        .append(Constante.SPATIUVIRGULASUS);
                }
                sql.append(" GROUP BY p.nume ,p.sigla,p.id  ORDER BY  voturiPartid DESC ,p.nume");

                if (filter.getSuntGenerale()) {
                        sql.append(" limit 10 offset 0");
                }

                final MapSqlParameterSource parameters = new MapSqlParameterSource();
                return namedParameterJdbcTemplate.query(sql.toString(), parameters, new RezultateMapper());
        }

        /**
         * @param filter
         * @param sql
         */
        private void extractMetodPartiJudet(final FiltruRezultat filter, final StringBuilder sql) {
                if (!Constante.SPATIU.equals(filter.getIdProvincia()) && filter.getIdProvincia() != null) {
                        sql.append(Constante.ANDJUDETSQL).append(filter.getIdProvincia())
                                        .append(Constante.SPATIUVIRGULASUS);
                }
                sql.append(Constante.SQLSUBSELECTREZULTAT).append(filter.getAnAlegeri()).append(Constante.SPATIU);
                if (filter.getIdPartid() != null) {
                        sql.append(Constante.ANDPARTIDSQL).append(filter.getIdPartid()).append(Constante.SPATIUMARE);
                }
                if (!Constante.SPATIU.equals(filter.getIdProvincia()) && filter.getIdProvincia() != null) {
                        sql.append(Constante.ANDJUDETSQL).append(filter.getIdProvincia())
                                        .append(Constante.SPATIUVIRGULASUS);
                }
                sql.append(Constante.SQLASMANDATE).append(filter.getAnAlegeri()).append(Constante.SPATIUMARE);
                if (filter.getIdPartid() != null) {
                        sql.append(Constante.ANDPARTIDSQL).append(filter.getIdPartid()).append(Constante.SPATIUMARE);
                }
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

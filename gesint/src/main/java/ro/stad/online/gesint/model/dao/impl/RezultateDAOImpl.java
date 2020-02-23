package ro.stad.online.gesint.model.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.stad.online.gesint.constante.Constante;
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

                final StringBuilder sql = new StringBuilder();
                sql.append(" SELECT distinct p.nume,p.sigla,p.id,  SUM(rpj.total_voturi_partid) AS voturiPartid ,SUM(rpj.numar_mandate) AS mandatePartid ,(SELECT sum(total_voturi_partid) FROM partid_rezultat_judet ");
                sql.append("WHERE an_alegeri= " + filter.getAnAlegeri() + Constante.SPATIU);
                if (filter.getIdPartid() != null) {
                        sql.append(" AND partid = " + filter.getIdPartid() + Constante.SPATIU);
                }
                if (!Constante.SPATIU.equals(filter.getIdProvincia()) && filter.getIdProvincia() != null) {
                        sql.append(" AND id_judet = '" + filter.getIdProvincia() + Constante.SPATIUVIRGULASUS);
                }
                sql.append(" )AS totalVoturi, (SELECT sum(numar_mandate) FROM partid_rezultat_judet ");
                sql.append(" WHERE an_alegeri= " + filter.getAnAlegeri() + Constante.SPATIU);
                if (filter.getIdPartid() != null) {
                        sql.append(" AND partid = " + filter.getIdPartid() + Constante.SPATIUMARE);
                }
                if (!"".equals(filter.getIdProvincia()) && filter.getIdProvincia() != null) {
                        sql.append(" AND id_judet = '" + filter.getIdProvincia() + Constante.SPATIUVIRGULASUS);
                }
                sql.append(" )AS totalMandate  FROM partid_rezultat_judet rpj , partid p WHERE rpj.partid= p.id  AND rpj.an_alegeri= "
                                + filter.getAnAlegeri() + " ");
                if (filter.getIdPartid() != null) {
                        sql.append(" AND partid = " + filter.getIdPartid() + Constante.SPATIUMARE);
                }
                if (!"".equals(filter.getIdProvincia()) && filter.getIdProvincia() != null) {
                        sql.append(" AND id_judet = '" + filter.getIdProvincia() + "'");
                }
                sql.append(" GROUP BY p.nume ,p.sigla,p.id  ORDER BY  voturiPartid DESC ,p.nume");

                if (filter.getSuntGenerale()) {
                        sql.append(" limit 10 offset 0");
                }

                final MapSqlParameterSource parameters = new MapSqlParameterSource();
                return namedParameterJdbcTemplate.query(sql.toString(), parameters, new RezultateMapper());
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

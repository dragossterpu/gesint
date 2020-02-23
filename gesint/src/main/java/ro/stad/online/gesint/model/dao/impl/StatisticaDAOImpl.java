package ro.stad.online.gesint.model.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.dao.StatisticaDAO;
import ro.stad.online.gesint.model.dao.mapper.StatisticaMapper;
import ro.stad.online.gesint.model.dto.statistica.StatisticaDTO;
import ro.stad.online.gesint.model.filters.FiltruStatistica;

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
         */
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        /**
         * Sursa de date.
         * @param ds DataSource
         *
         */
        @Override
        @Autowired
        public void setDataSource(final DataSource ds) {
                this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
        }

        /**
         * Datele statisticii generale.
         * @param filter FiltruStatistica
         * @return lista List<StatisticaDTO> lista cu rezultatele
         */
        @Override
        public List<StatisticaDTO> filterGeneraleStatistica(final FiltruStatistica filter) {

                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                final StringBuilder sql = new StringBuilder();

                sql.append(" SELECT COUNT(*) AS numarTotal,");
                sql.append("(SELECT COUNT(*) FROM utilizator WHERE educatie= 'LICEU') AS totalcuLiceu,");
                sql.append("(SELECT COUNT(*) FROM utilizator WHERE educatie= 'STUDIISUPERIOARE') AS totalStudiiSup,");
                sql.append("(SELECT COUNT(*) FROM utilizator WHERE educatie= 'BAZIC') AS totalBazice,");
                sql.append("(SELECT SUM(populatie)FROM judet)AS locuitoriTotal,");
                sql.append("(SELECT COUNT(*) FROM utilizator WHERE sex= 'MAN') AS totalBarbati,");
                sql.append("(SELECT COUNT(*) FROM utilizator WHERE sex= 'WOMAN') AS totalFemei,");
                sql.append("(SELECT DISTINCT ROUND((SELECT SUM(populatie)FROM judet)- ((SELECT SUM(populatie)FROM judet)*0.2)) AS locuitori FROM judet ) AS totalVot,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimaLuna()) + Constante.ANDDATE
                                + sdf.format(filter.getDataIncepand()) + "') AS totalUltimaLuna,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimDouaLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimaLuna())
                                + "') AS totalUltimDouaLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimTreiLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimDouaLuni())
                                + "') AS totalUltimTreiLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimPatruLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimTreiLuni())
                                + "') AS totalUltimPatruLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimCinciLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimPatruLuni())
                                + "') AS totalUltimCinciLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimSaseLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimCinciLuni())
                                + "') AS totalUltimSaseLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimSapteLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimSaseLuni())
                                + "') AS totalUltimSapteLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimOptLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimSapteLuni())
                                + "') AS totalUltimOptLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimNouaLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimOptLuni())
                                + "') AS totalUltimNouaLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimZeceLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimNouaLuni())
                                + "') AS totalUltimZeceLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimUnspeLuni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimZeceLuni())
                                + "') AS totalUltimUnspeLuni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimAn()) + Constante.ANDDATE
                                + sdf.format(filter.getDataUltimUnspeLuni()) + "') AS totalLuna12,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimAn()) + Constante.ANDDATE
                                + sdf.format(filter.getDataIncepand()) + "') AS totalUltimAn,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimaLunaAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimaLunaAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimDouaLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimDouaLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimTreiLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimTreiLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimPatruLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimPatruLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimCinciLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimCinciLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimSaseLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimSaseLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimSapteLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimSapteLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimOptLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimOptLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimNouaLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimNouaLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimZeceLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimZeceLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimUnspeLuniAnTrecut())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimAn())
                                + "') AS totalUltimUnspeLuniAnAtras,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimiDoiAni()) + "' AND DATE '"
                                + sdf.format(filter.getDataUltimAn()) + "') AS totalUltimiDoiAni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimiTreiAni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimiDoiAni())
                                + "') AS totalUltimiiTreiAni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimiPatruAni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimiTreiAni())
                                + "') AS totalUltimiiPatruAni,");
                sql.append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimiCinciAni())
                                + Constante.ANDDATE + sdf.format(filter.getDataUltimiPatruAni())
                                + "') AS totalUltimiiCinciAni,");
                sql.append("(SELECT COUNT(*)  FROM utilizator WHERE DATE_create <= '"
                                + sdf.format(filter.getDataUltimiCinciAni()) + "') AS totalAntCinciAni,");

                sql.append("(SELECT COUNT(*)  FROM utilizator WHERE data_nasterii BETWEEN DATE '"
                                + sdf.format(filter.getDataPana25()) + Constante.ANDDATE
                                + sdf.format(filter.getDataIncepand()) + "') AS totalPana25,");
                sql.append(Constante.SELECTCOUNTUSERBIRTDATE + sdf.format(filter.getDataPana25()) + Constante.ANDDATE
                                + sdf.format(filter.getDataIncepand()) + "' and sex= 'MAN') AS totalBarbati25,");
                sql.append(Constante.SELECTCOUNTUSERBIRTDATE + sdf.format(filter.getDataPana40()) + Constante.ANDDATE
                                + sdf.format(filter.getDataPana25()) + "') AS totalPana40,");
                sql.append(Constante.SELECTCOUNTUSERBIRTDATE + sdf.format(filter.getDataPana40()) + Constante.ANDDATE
                                + sdf.format(filter.getDataPana25()) + "' and sex= 'MAN') AS totalBarbati40,");
                sql.append(Constante.SELECTCOUNTUSERBIRTDATE + sdf.format(filter.getDataPana60()) + Constante.ANDDATE
                                + sdf.format(filter.getDataPana40()) + "') AS totalPana60,");
                sql.append(Constante.SELECTCOUNTUSERBIRTDATE + sdf.format(filter.getDataPana60()) + Constante.ANDDATE
                                + sdf.format(filter.getDataPana40()) + "' and sex= 'MAN') AS totalBarbati60,");
                sql.append("(SELECT COUNT(*)  FROM utilizator WHERE data_nasterii <= '" + sdf.format(filter.getDataPana60())
                                + "') AS totalMayor60,");
                sql.append("(SELECT COUNT(*) FROM utilizator u, localitate l WHERE  u.localitate_id = l.id AND l.nivel =3)AS mediuRural,");
                sql.append("(SELECT COUNT(*) FROM utilizator u, localitate l WHERE  u.localitate_id = l.id AND l.nivel in(2,1))AS mediuUrban,");
                sql.append("(SELECT SUM(locuitori) FROM localitate WHERE nivel =3) AS locuitoriTotalRural, ");
                sql.append("(SELECT SUM(locuitori) FROM localitate WHERE nivel in(2,3)) AS locuitoriTotalUrban ");
                sql.append("FROM utilizator ");

                final MapSqlParameterSource parameters = new MapSqlParameterSource();

                parameters.addValue("dataIncepand", filter.getDataIncepand());
                parameters.addValue("dataUltimAn", filter.getDataUltimAn());
                parameters.addValue("dataUltimaLuna", filter.getDataUltimaLuna());
                parameters.addValue("dataUltimDouaLuni", filter.getDataUltimDouaLuni());
                parameters.addValue("dataUltimTreiLuni", filter.getDataUltimTreiLuni());
                parameters.addValue("dataUltimPatruLuni", filter.getDataUltimPatruLuni());
                parameters.addValue("dataUltimCinciLuni", filter.getDataUltimCinciLuni());
                parameters.addValue("dataUltimSaseLuni", filter.getDataUltimSaseLuni());
                parameters.addValue("dataUltimSapteLuni", filter.getDataUltimSapteLuni());
                parameters.addValue("dataUltimOptLuni", filter.getDataUltimOptLuni());
                parameters.addValue("dataUltimNouaLuni", filter.getDataUltimNouaLuni());
                parameters.addValue("dataUltimZeceLuni", filter.getDataUltimZeceLuni());
                parameters.addValue("dataUltimUnspeLuni", filter.getDataUltimUnspeLuni());
                parameters.addValue("dataUltimaLunaAnTrecut", filter.getDataUltimaLunaAnTrecut());
                parameters.addValue("dataUltimaDouaLuniAnTrecut", filter.getDataUltimDouaLuniAnTrecut());
                parameters.addValue("dataUltimaTreiLuniAnTrecut", filter.getDataUltimTreiLuniAnTrecut());
                parameters.addValue("dataUltimaPatruLuniAnTrecut", filter.getDataUltimPatruLuniAnTrecut());
                parameters.addValue("dataUltimaCinciLuniAnTrecut", filter.getDataUltimCinciLuniAnTrecut());
                parameters.addValue("dataUltimaSaseLuniAnTrecut", filter.getDataUltimSaseLuniAnTrecut());
                parameters.addValue("dataUltimaSapteLuniAnTrecut", filter.getDataUltimSapteLuniAnTrecut());
                parameters.addValue("dataUltimaOptLuniAnTrecut", filter.getDataUltimOptLuniAnTrecut());
                parameters.addValue("dataUltimaNouaLuniAnTrecut", filter.getDataUltimNouaLuniAnTrecut());
                parameters.addValue("dataUltimaZeceLuniAnTrecut", filter.getDataUltimZeceLuniAnTrecut());
                parameters.addValue("dataUltimaUnspeLuniAnTrecut", filter.getDataUltimUnspeLuniAnTrecut());
                parameters.addValue("dataUltimiDoiAni", filter.getDataUltimiDoiAni());
                parameters.addValue("dataUltimiTreiAni", filter.getDataUltimiTreiAni());
                parameters.addValue("dataUltimiPatruAni", filter.getDataUltimiPatruAni());
                parameters.addValue("dataUltimiCinciAni", filter.getDataUltimiCinciAni());
                return namedParameterJdbcTemplate.query(sql.toString(), parameters, new StatisticaMapper());
        }

}

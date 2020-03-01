package ro.stad.online.gesint.model.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
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
                final StringBuilder sql = new StringBuilder(NumarMagic.NUMBERTWOTHOUSAND);

                sql.append(" SELECT COUNT(*) AS numarTotal,").append(Constante.SQLCOUNTEDUCATIE)
                                .append(" 'LICEU') AS totalcuLiceu,").append(Constante.SQLCOUNTEDUCATIE)
                                .append(" 'STUDIISUPERIOARE') AS totalStudiiSup,").append(Constante.SQLCOUNTEDUCATIE)
                                .append(" 'BAZIC') AS totalBazice,")
                                .append("(SELECT SUM(populatie)FROM judet)AS locuitoriTotal,")
                                .append(Constante.SQLCOUNTSEX).append(" 'MAN') AS totalBarbati,")
                                .append(Constante.SQLCOUNTSEX).append(" 'WOMAN') AS totalFemei,")
                                .append(Constante.SQLSELECT).append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimaLuna())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataIncepand())).append("') AS totalUltimaLuna,")
                                .append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimDouaLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimaLuna())).append(Constante.SQLAS)
                                .append(" totalUltimDouaLuni,")
                                .append(Constante.SELECTCOUNTUSERBETWENN + sdf.format(filter.getDataUltimTreiLuni()))
                                .append(Constante.ANDDATE).append(sdf.format(filter.getDataUltimDouaLuni()))
                                .append(Constante.SQLAS).append(" totalUltimTreiLuni,")
                                .append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimPatruLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimTreiLuni())).append(Constante.SQLAS)
                                .append(" totalUltimPatruLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimCinciLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimPatruLuni())).append(Constante.SQLAS)
                                .append(" totalUltimCinciLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimSaseLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimCinciLuni())).append(Constante.SQLAS)
                                .append(" totalUltimSaseLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimSapteLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimSaseLuni())).append(Constante.SQLAS)
                                .append(" totalUltimSapteLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimOptLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimSapteLuni())).append(Constante.SQLAS)
                                .append(" totalUltimOptLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimNouaLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimOptLuni())).append(Constante.SQLAS)
                                .append(" totalUltimNouaLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimZeceLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimNouaLuni())).append(Constante.SQLAS)
                                .append(" totalUltimZeceLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimUnspeLuni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimZeceLuni())).append(Constante.SQLAS)
                                .append(" totalUltimUnspeLuni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimAn()) + Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimUnspeLuni())).append(Constante.SQLAS)
                                .append(" totalLuna12,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimAn()) + Constante.ANDDATE)
                                .append(sdf.format(filter.getDataIncepand())).append(Constante.SQLAS)
                                .append(" totalUltimAn,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimaLunaAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimaLunaAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimDouaLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimDouaLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimTreiLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimTreiLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimPatruLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimPatruLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimCinciLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimCinciLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimSaseLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimSaseLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimSapteLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimSapteLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimOptLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimOptLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimNouaLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append("totalUltimNouaLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimZeceLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimZeceLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimUnspeLuniAnTrecut())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimUnspeLuniAnAtras,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimiDoiAni())).append("' AND DATE '")
                                .append(sdf.format(filter.getDataUltimAn())).append(Constante.SQLAS)
                                .append(" totalUltimiDoiAni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimiTreiAni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimiDoiAni())).append(Constante.SQLAS)
                                .append(" totalUltimiiTreiAni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimiPatruAni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimiTreiAni())).append(Constante.SQLAS)
                                .append(" totalUltimiiPatruAni,").append(Constante.SELECTCOUNTUSERBETWENN)
                                .append(sdf.format(filter.getDataUltimiCinciAni())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataUltimiPatruAni())).append(Constante.SQLAS)
                                .append(" totalUltimiiCinciAni,")
                                .append("(SELECT COUNT(*)  FROM utilizator WHERE DATE_create <= '")
                                .append(sdf.format(filter.getDataUltimiCinciAni())).append(Constante.SQLAS)
                                .append(" totalAntCinciAni,")
                                .append("(SELECT COUNT(*)  FROM utilizator WHERE data_nasterii BETWEEN DATE '")
                                .append(sdf.format(filter.getDataPana25())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataIncepand())).append(Constante.SQLAS)
                                .append(" totalPana25,").append(Constante.SELECTCOUNTUSERBIRTDATE)
                                .append(sdf.format(filter.getDataPana25())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataIncepand())).append(Constante.SQLANDMAN)
                                .append(" totalBarbati25,").append(Constante.SELECTCOUNTUSERBIRTDATE)
                                .append(sdf.format(filter.getDataPana40())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataPana25())).append(Constante.SQLAS)
                                .append(" totalPana40,").append(Constante.SELECTCOUNTUSERBIRTDATE)
                                .append(sdf.format(filter.getDataPana40()) + Constante.ANDDATE)
                                .append(sdf.format(filter.getDataPana25())).append(Constante.SQLANDMAN)
                                .append(" totalBarbati40,").append(Constante.SELECTCOUNTUSERBIRTDATE)
                                .append(sdf.format(filter.getDataPana60())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataPana40())).append(Constante.SQLAS)
                                .append(" totalPana60,").append(Constante.SELECTCOUNTUSERBIRTDATE)
                                .append(sdf.format(filter.getDataPana60())).append(Constante.ANDDATE)
                                .append(sdf.format(filter.getDataPana40())).append(Constante.SQLANDMAN)
                                .append(" totalBarbati60,")
                                .append("(SELECT COUNT(*)  FROM utilizator WHERE data_nasterii <= '")
                                .append(sdf.format(filter.getDataPana60())).append(Constante.SQLAS)
                                .append(" totalMayor60,").append(Constante.SQLCOUNTNIVELLOC)
                                .append(" =3)AS mediuRural,").append(Constante.SQLCOUNTNIVELLOC)
                                .append(" in(2,1))AS mediuUrban,").append(Constante.SQLCOUNTNIVEL)
                                .append(" =3) AS locuitoriTotalRural, ").append(Constante.SQLCOUNTNIVEL)
                                .append(" in(2,3)) AS locuitoriTotalUrban ").append("FROM utilizator ");

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

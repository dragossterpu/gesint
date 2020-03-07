package ro.stad.online.gesint.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.UtilizatorSondaj;

/**
 * Declarația metodelor care vor fi utilizate pentru persistența votarii sondajelor.
 * @author STAD
 *
 */
public interface SondajVotService {

        /**
         * Inregistreaza votul unui sondaj.
         * @param votSondaj UtilizatorSondaj
         * @return UtilizatorSondaj actualizat
         */
        UtilizatorSondaj save(UtilizatorSondaj votSondaj);

        /**
         * Metoda care cauta votantii unui sondaj.
         * @param sondaj Sondaj
         * @return List<UtilizatorSondaj>
         */
        List<UtilizatorSondaj> findAllBySondaj(Sondaj sondaj);

        /**
         * Metoda care dupa finalizarea unui sondajelimina toti utilizatorii care au votat
         * @param Sondaj sond
         */
        @Transactional(readOnly = false)
        void deleteBySondaj(Sondaj sond);

}

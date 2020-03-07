package ro.stad.online.gesint.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.UtilizatorSondaj;

/**
 * Repositoriu de votanti de sondaje.
 * @author STAD
 *
 */
public interface SondajVotRepository extends CrudRepository<UtilizatorSondaj, Long> {

        /**
         * Metoda care obține votantii unui sondaj din baza de date
         * @param Sondaj sondaj
         * @return List<UtilizatorSondaj>
         */
        List<UtilizatorSondaj> findAllBySondaj(Sondaj sondaj);

        /**
         * Metoda care dupa finalizarea unui sondajelimina toti utilizatorii care au votat
         * @param Sondaj sond
         */
        void deleteBySondaj(Sondaj sonda);

}

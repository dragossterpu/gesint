package ro.stad.online.gesint.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Optiune;

/**
 * Repositoriu pentru entitatea Optiune.
 * @author STAD
 */
public interface OptiuneRepository extends CrudRepository<Optiune, Long> {

        /**
         * Cauta toate optiunile inregistrate ale unui judet
         * @return List<Optiune>)
         */
        List<Optiune> findByJudet(Judet code);

}

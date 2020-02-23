package ro.stad.online.gesint.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.stad.online.gesint.persistence.entities.Judet;

/**
 * Repositoriu pentru entitatea Judet.
 * @author STAD
 */
public interface JudetRepository extends CrudRepository<Judet, String> {

        /**
         * Cauta toate judetele ordonate dupa nume
         * @return List<Judet>
         *
         */
        List<Judet> findAllByOrderByNumeAsc();

        /**
         * Cauta un judet dupa numele acestuia
         * @param descripcion
         * @return judet
         *
         */
        Judet findByNume(String descriere);

}

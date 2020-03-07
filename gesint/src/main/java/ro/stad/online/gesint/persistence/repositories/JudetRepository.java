package ro.stad.online.gesint.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

        /**
         * Cauta judete
         * @param List<String> string
         * @return List<Judet> judete
         */
        @Query(value = "select * from judet where cod_judet in ( :judete)", nativeQuery = true)
        List<Judet> findAllByIndicator(@Param("judete") List<String> judete);

}

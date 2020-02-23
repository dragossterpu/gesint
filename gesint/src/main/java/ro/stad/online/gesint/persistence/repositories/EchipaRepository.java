package ro.stad.online.gesint.persistence.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ro.stad.online.gesint.persistence.entities.Echipa;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 * Repositoriu pentru entitatea Echipa.
 * @author STAD
 */
public interface EchipaRepository extends CrudRepository<Echipa, Long> {

        /**
         * Elimina un membru al echipei primit ca parametru.
         * @param user
         * @return resultatul eliminarii
         */
        @Override
        void delete(Echipa echipa);

        /**
         * Verificați existența utilizatorilor care au atribuit o echipa primit ca parametru.
         * @param functieId Long
         * @return int resultatul comprobarii
         */
        @Query(value = "select count(*) from utilizator where team_id =:functieId", nativeQuery = true)
        int existsByTeam(@Param("functieId") Long functieId);

        /**
         * Verificați existența utilizatorilor care au atribuit o echipa primit ca parametru.
         * @param user
         * @return resultatul comprobarii
         */
        boolean existsByUser(Utilizator user);

        /**
         * Devuelve todas las unidades de base de datos.
         * @return lista de unidades
         */
        Iterable<Echipa> findAllByOrderByRankAsc();

        /**
         * Devuelve todas las unidades de base de datos.
         * @return lista de unidades
         */
        Iterable<Echipa> findAllByOrderByRankDesc();

        /**
         * Cauta un registru in baza de date primind ca parametru membrul echipei
         * @param team
         */
        Echipa findByUser(Utilizator team);
}

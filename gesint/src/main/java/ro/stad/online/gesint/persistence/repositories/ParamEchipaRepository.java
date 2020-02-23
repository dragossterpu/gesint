package ro.stad.online.gesint.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ro.stad.online.gesint.persistence.entities.Functie;

/**
 * Repositoriu pentru entitatea Functie.
 * @author STAD
 */
public interface ParamEchipaRepository extends CrudRepository<Functie, Long> {

        /**
         * @param organization
         * @param Long idTeam
         * @return Functie functia
         *
         */
        Functie findByIdAndOrganizatie(Long idTeam, String organizatie);

        /**
         * @param organization
         * @return
         *
         */
        List<Functie> findByOrganizatie(String organization);

        /**
         * @param organization
         * @return
         *
         */
        @Query(value = "select count(*)  from PTEAM where organizatie=1", nativeQuery = true)
        int countOrganiatie(String organizatie);

}

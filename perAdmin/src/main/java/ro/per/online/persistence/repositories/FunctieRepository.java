package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.PTeam;

/**
 * Repositoriu pentru entitatea PTeam.
 * @author STAD
 */
public interface FunctieRepository extends CrudRepository<PTeam, Long> {

}

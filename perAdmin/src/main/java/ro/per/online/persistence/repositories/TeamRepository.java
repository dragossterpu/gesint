package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Team;

/**
 * Repositoriu pentru entitatea Team.
 * @author STAD
 */
public interface TeamRepository extends CrudRepository<Team, Long> {
	/**
	 * Devuelve todas las unidades de base de datos.
	 * @return lista de unidades
	 */
	Iterable<Team> findAllByOrderByRankAsc();

}

package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.Users;

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

	/**
	 * Devuelve todas las unidades de base de datos.
	 * @return lista de unidades
	 */
	Iterable<Team> findAllByOrderByRankDesc();

	/**
	 * Verificați existența utilizatorilor care au atribuit o echipa primit ca parametru.
	 * @param user
	 * @return resultatul comprobarii
	 */
	boolean existsByUser(Users user);

	/**
	 * Elimina un membru al echipei primit ca parametru.
	 * @param user
	 * @return resultatul eliminarii
	 */
	@Override
	void delete(Team team);

	/**
	 * Cauta un registru in baza de date primind ca parametru membrul echipei
	 * @param team
	 */
	Team findByUser(Users team);
}

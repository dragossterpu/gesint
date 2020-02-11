package ro.per.online.persistence.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.Users;

/**
 * Repositoriu pentru entitatea Team.
 * @author STAD
 */
public interface TeamRepository extends CrudRepository<Team, Long> {

	/**
	 * Elimina un membru al echipei primit ca parametru.
	 * @param user
	 * @return resultatul eliminarii
	 */
	@Override
	void delete(Team team);

	/**
	 * Verificați existența utilizatorilor care au atribuit o echipa primit ca parametru.
	 * @param functie
	 * @return resultatul comprobarii
	 */
	@Query(value = "select count(*) from team where team =1", nativeQuery = true)
	int existsByTeam(Long functieId);

	/**
	 * Verificați existența utilizatorilor care au atribuit o echipa primit ca parametru.
	 * @param user
	 * @return resultatul comprobarii
	 */
	boolean existsByUser(Users user);

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
	 * Cauta un registru in baza de date primind ca parametru membrul echipei
	 * @param team
	 */
	Team findByUser(Users team);
}

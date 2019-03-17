package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.Users;

/**
 * Interfață pentru serviciul de Team.
 *
 * @author STAD
 *
 */
public interface TeamService {

	/**
	 * Elimina un membru al echipei de conducere
	 *
	 * @param team membru al echipei de conducere
	 */
	void delete(Team team);

	/**
	 *
	 * @param functie PTeam
	 * @return boolean
	 */
	int existsByTeam(Long functieId);

	/**
	 *
	 * @param user Users
	 * @return boolean
	 */
	boolean existsByUser(Users user);

	/**
	 * Cauta toate functiile
	 *
	 * @return lista de functii.
	 */
	List<Team> fiindByTeam();

	/**
	 * Obtinem nivelul cel mai mare
	 *
	 * @param team
	 * @return Team actualizat
	 */
	List<Team> findAllByOrderByRankDesc();

	/**
	 * Cauta un registru in baza de date primind ca parametru membrul echipei
	 * @param team
	 * @return
	 */
	Team findByUser(Users team);

	/**
	 * Salvați sau actualizați un team.
	 *
	 * @param team
	 * @return Team actualizat
	 */
	Team save(Team team);

}

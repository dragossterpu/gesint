package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.Team;

/**
 * Interfață pentru serviciul de Team.
 *
 * @author STAD
 *
 */
public interface TeamService {

	/**
	 * Cauta toate functiile
	 *
	 * @return lista de functii.
	 */
	List<Team> fiindByTeam();

	/**
	 * Elimina un membru al echipei de conducere
	 * 
	 * @param team membru al echipei de conducere
	 */
	void delete(Team team);

	/**
	 * Salvați sau actualizați un team.
	 * 
	 * @param team
	 * @return Team actualizat
	 */
	Team save(Team team);

}

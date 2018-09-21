package ro.mira.peronline.services;

import java.util.List;

import ro.mira.peronline.persistence.entities.Team;

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

}

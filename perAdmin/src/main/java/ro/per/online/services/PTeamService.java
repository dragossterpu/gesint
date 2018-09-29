package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.PTeam;

/**
 * Interfață pentru serviciul de PTeam.
 *
 * @author STAD
 *
 */
public interface PTeamService {

	/**
	 * Cauta toate functiile
	 *
	 * @return lista de functii.
	 */
	List<PTeam> fiindAll();

}

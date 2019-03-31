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

	/**
	 * Metoda care cauta toate functile din conducerea locala
	 * @return list
	 *
	 */
	List<PTeam> fiindAllByParam();

	/**
	 * Cauta o functie
	 * @param Long idTeam
	 * @return PTeam localitatea
	 */
	PTeam findById(Long idTeam);

	/**
	 * Metoda care cauta functia din conducerea locala
	 * @return list
	 *
	 */
	PTeam findByIdAndOrganization(Long id, String organizatia);

	/**
	 * Metoda care cauta functia din conducerea locala
	 * @return list
	 *
	 */
	List<PTeam> findByOrganization(String organizatia);
}

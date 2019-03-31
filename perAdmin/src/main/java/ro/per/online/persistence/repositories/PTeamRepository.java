package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.PTeam;

/**
 * Repositoriu pentru entitatea PTeam.
 * @author STAD
 */
public interface PTeamRepository extends CrudRepository<PTeam, Long> {

	/**
	 * @param organization
	 * @param Long idTeam
	 * @return PTeam functia
	 *
	 */
	PTeam findByIdAndOrganization(Long idTeam, String organizatie);

	/**
	 * @param organization
	 * @return
	 *
	 */
	List<PTeam> findByOrganization(String organization);

}

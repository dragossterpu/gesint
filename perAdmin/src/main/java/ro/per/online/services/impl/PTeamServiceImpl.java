package ro.per.online.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.PTeam;
import ro.per.online.persistence.repositories.PTeamRepository;
import ro.per.online.services.PTeamService;

/**
 * Implementación del servicio dePTeamService.
 *
 * @author STAD
 *
 */
@Service
public class PTeamServiceImpl implements PTeamService {

	/**
	 * Repositoriu de Team.
	 */
	@Autowired
	private PTeamRepository pteamRepository;

	/**
	 * Devuelve todas las unidades de base de datos.
	 * @return lista de unidades
	 */
	@Override
	public List<PTeam> fiindAll() {
		return (ArrayList<PTeam>) pteamRepository.findAll();
	}

	/**
	 * Devuelve todas las unidades de base de datos.
	 * @return lista de unidades
	 */
	@Override
	public List<PTeam> fiindAllByParam() {
		final String organization = "Conducerea Locală";
		return pteamRepository.findByOrganization(organization);
	}

	/**
	 * Cauta o functie
	 * @param Long idTeam
	 * @return PTeam functia
	 */
	@Override
	public PTeam findById(final Long idTeam) {
		return pteamRepository.findOne(idTeam);
	}

	/**
	 * Cauta o functie
	 * @param Long idTeam
	 * @return PTeam functia
	 */
	@Override
	public PTeam findByIdAndOrganization(final Long idTeam, final String organizatie) {
		return pteamRepository.findByIdAndOrganization(idTeam, organizatie);
	}

	/**
	 * Cauta o functie
	 * @param Long idTeam
	 * @return PTeam functia
	 */
	@Override
	public List<PTeam> findByOrganization(final String organizatie) {
		return pteamRepository.findByOrganization(organizatie);
	}
}

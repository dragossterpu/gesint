package ro.per.online.services.impl;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
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
		return IterableUtils.toList(this.pteamRepository.findAll());
	}

}

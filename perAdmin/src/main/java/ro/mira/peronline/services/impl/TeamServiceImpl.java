package ro.mira.peronline.services.impl;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.mira.peronline.persistence.entities.Team;
import ro.mira.peronline.persistence.repositories.TeamRepository;
import ro.mira.peronline.services.TeamService;

/**
 * Implementación del servicio de unidades.
 *
 * @author STAD
 *
 */
@Service
public class TeamServiceImpl implements TeamService {

	/**
	 * Repositoriu de Team.
	 */
	@Autowired
	private TeamRepository teamRepository;

	/**
	 * Devuelve todas las unidades de base de datos.
	 * @return lista de unidades
	 */
	@Override
	public List<Team> fiindByTeam() {
		return IterableUtils.toList(this.teamRepository.findAllByOrderByRankAsc());
	}

}

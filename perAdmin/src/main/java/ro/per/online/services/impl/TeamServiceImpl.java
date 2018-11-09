package ro.per.online.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.repositories.TeamRepository;
import ro.per.online.services.TeamService;

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
	 * Elimina un membru al echipei de conducere
	 * 
	 * @param team membru al echipei de conducere
	 */
	@Override
	public void delete(final Team team) {
		teamRepository.delete(team);
	}

	/**
	 * Verifica existența utilizatorilor care au atribuit o echipa primit ca parametru.
	 * @param user
	 * @return resultatul comprobarii
	 */
	@Override
	public boolean existsByUser(final Users user) {
		return teamRepository.existsByUser(user);
	}

	/**
	 * Devuelve todas las unidades de base de datos.
	 * @return lista de unidades
	 */
	@Override
	public List<Team> fiindByTeam() {
		return (ArrayList<Team>) teamRepository.findAllByOrderByRankAsc();
	}

	@Override
	public List<Team> findAllByOrderByRankDesc() {
		return (ArrayList<Team>) teamRepository.findAllByOrderByRankDesc();
	}

	/**
	 * Cauta un registru in baza de date primind ca parametru membrul echipei
	 * @param team
	 * @return
	 */
	@Override
	public Team findByUser(final Users team) {
		return teamRepository.findByUser(team);
	}

	/**
	 * Salvați sau actualizați un team.
	 * 
	 * @param team
	 * @return Team actualizat
	 */
	@Override
	public Team save(final Team team) {
		final Team teamActualizado = teamRepository.save(team);
		return teamActualizado;

	}
}

package ro.per.online.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.Mapa;
import ro.per.online.persistence.repositories.MapaRepository;
import ro.per.online.services.MapaService;

/**
 * Implementación del servicio de mapa.
 *
 * @author STAD
 *
 */
@Service
public class MapaServiceImpl implements MapaService {

	/**
	 * Repositoriu de Mapa.
	 */
	@Autowired
	private MapaRepository mapaRepository;

	/**
	 * Devuelve toate registrele inregistrate in baza de date.
	 * @return lista de registre
	 */
	@Override
	public List<Mapa> fiindAll() {
		return (ArrayList<Mapa>) mapaRepository.findAll();
	}

}

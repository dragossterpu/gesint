package ro.per.online.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.PCountry;
import ro.per.online.persistence.repositories.CountryRepository;
import ro.per.online.services.CountryService;

/**
 * Implementación del servicio de tari.
 *
 * @author STAD
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	/**
	 * Repositoriu de PCountry.
	 */
	@Autowired
	private CountryRepository countryRepository;

	/**
	 * Devuelve toate tarile inregistrate in baza de date.
	 * @return lista de tari
	 */
	@Override
	public List<PCountry> fiindAll() {
		return (ArrayList<PCountry>) countryRepository.findAll();
	}

}

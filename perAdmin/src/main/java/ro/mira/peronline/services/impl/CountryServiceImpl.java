package ro.mira.peronline.services.impl;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.mira.peronline.persistence.entities.PCountry;
import ro.mira.peronline.persistence.repositories.CountryRepository;
import ro.mira.peronline.services.CountryService;

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
		return IterableUtils.toList(this.countryRepository.findAll());
	}

}

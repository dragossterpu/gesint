package ro.per.online.services.impl;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.repositories.LocalityRepository;
import ro.per.online.services.LocalityService;

/**
 * Implementación del servicio de localitati.
 *
 * @author STAD
 *
 */
@Service
public class LocalityServiceImpl implements LocalityService {

	/**
	 * Repositoriu de PLocality.
	 */
	@Autowired
	private LocalityRepository localityRepository;

	/**
	 * Devuelve toate judetele inregistrate in baza de date.
	 * @return lista de judete
	 */
	@Override
	public List<PLocality> fiindAll() {
		return IterableUtils.toList(this.localityRepository.findAll());
	}

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	@Override
	public List<PLocality> findByProvince(final PProvince province) {
		return this.localityRepository.findAllByProvince(province);
	}
}

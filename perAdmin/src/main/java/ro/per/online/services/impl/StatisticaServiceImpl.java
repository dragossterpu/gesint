package ro.per.online.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.Statistica;
import ro.per.online.persistence.entities.enums.TipStatisticaEnum;
import ro.per.online.persistence.repositories.StatisticaRepository;
import ro.per.online.services.StatisticaService;

/**
 * Implementación del servicio de Statistica.
 *
 * @author STAD
 *
 */
@Service
public class StatisticaServiceImpl implements StatisticaService {

	/**
	 * Repositoriu de Statistica.
	 */
	@Autowired
	private StatisticaRepository statisticaRepository;

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	@Override
	public List<Statistica> findByTipStatisticaAndMarcaAndIsjudet(final TipStatisticaEnum tip, final String marca,
			final Boolean isjudet) {
		return statisticaRepository.findByTipStatisticaAndMarcaAndIsjudetOrderByProcentajDesc(tip, marca, isjudet);
	}
}

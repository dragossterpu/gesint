package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.Statistica;
import ro.per.online.persistence.entities.enums.TipStatisticaEnum;

/**
 * Interfață pentru serviciul de Statistica.
 *
 * @author STAD
 *
 */
public interface StatisticaService {

	/**
	 * Cauta statistica tuturor judetelor
	 * @param Long id identificator de judet
	 * @return lista de judete.
	 */
	List<Statistica> findByTipStatisticaAndMarcaAndIsjudet(TipStatisticaEnum tip, String marca, Boolean isjudet);

}

package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Statistica;
import ro.per.online.persistence.entities.enums.TipStatisticaEnum;

/**
 * Repositoriu pentru entitatea Statistica.
 * @author STAD
 */
public interface StatisticaRepository extends CrudRepository<Statistica, Long> {

	/**
	 * Cauta judetele din statistica
	 * @param tip TipStatisticaEnum
	 * @param isjudet Boolean
	 * @para mmarca
	 * @return List<Statistica>
	 *
	 */
	List<Statistica> findByTipStatisticaAndMarcaAndIsjudetOrderByProcentajDesc(TipStatisticaEnum tip, String marca,
			Boolean isjudet);
}

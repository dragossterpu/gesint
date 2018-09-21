package ro.mira.peronline.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.mira.peronline.persistence.entities.PLocality;
import ro.mira.peronline.persistence.entities.PProvince;

/**
 * Repositoriu pentru entitatea PLocality.
 * @author STAD
 */
public interface LocalityRepository extends CrudRepository<PLocality, Long> {
	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 */
	List<PLocality> findAllByProvince(PProvince province);

}

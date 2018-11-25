package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.PProvince;

/**
 * Repositoriu pentru entitatea PProvince.
 * @author STAD
 */
public interface ProvinceRepository extends CrudRepository<PProvince, Long> {

	/**
	 * Cauta un judet dupa numele acestuia
	 * @param descripcion
	 * @return provincia
	 *
	 */
	PProvince findByName(String descripcion);

}

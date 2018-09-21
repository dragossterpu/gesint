package ro.mira.peronline.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.mira.peronline.persistence.entities.PProvince;

/**
 * Repositoriu pentru entitatea PProvince.
 * @author STAD
 */
public interface ProvinceRepository extends CrudRepository<PProvince, Long> {

}

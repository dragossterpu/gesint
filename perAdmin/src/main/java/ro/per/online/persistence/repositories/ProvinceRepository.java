package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.PProvince;

/**
 * Repositoriu pentru entitatea PProvince.
 * @author STAD
 */
public interface ProvinceRepository extends CrudRepository<PProvince, Long> {

}

package ro.mira.peronline.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.mira.peronline.persistence.entities.PCountry;

/**
 * Repositoriu pentru entitatea PCountry.
 * @author STAD
 */
public interface CountryRepository extends CrudRepository<PCountry, String> {

}

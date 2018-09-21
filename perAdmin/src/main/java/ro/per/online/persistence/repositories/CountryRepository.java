package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.PCountry;

/**
 * Repositoriu pentru entitatea PCountry.
 * @author STAD
 */
public interface CountryRepository extends CrudRepository<PCountry, String> {

}

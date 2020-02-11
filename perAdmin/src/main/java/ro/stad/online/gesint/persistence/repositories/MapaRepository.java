package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Mapa;

/**
 * Repositoriu pentru entitatea Mapa.
 * @author STAD
 */
public interface MapaRepository extends CrudRepository<Mapa, Long> {

}

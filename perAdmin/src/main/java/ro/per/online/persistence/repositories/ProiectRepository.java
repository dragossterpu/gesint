package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Proiecte;

/**
 * Repositorio de operaciones de base de datos para la entidad Proiecte.
 * 
 * @author ATOS
 *
 */
public interface ProiectRepository extends CrudRepository<Proiecte, Long> {

}

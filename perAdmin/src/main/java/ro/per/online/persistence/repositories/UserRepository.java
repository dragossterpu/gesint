package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Users;

/**
 * Repositoriu pentru entitatea Users.
 * @author STAD
 */
public interface UserRepository extends CrudRepository<Users, String> {

}

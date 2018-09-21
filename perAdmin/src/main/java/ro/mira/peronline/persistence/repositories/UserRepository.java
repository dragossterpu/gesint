package ro.mira.peronline.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.mira.peronline.persistence.entities.Users;

/**
 * Repositoriu pentru entitatea Users.
 * @author STAD
 */
public interface UserRepository extends CrudRepository<Users, String> {

}

package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Users;

/**
 * Repositorio de alerte.
 * @author STAD
 *
 */
public interface AlertaRepository extends CrudRepository<Alerta, Long> {

	/**
	 * Returnează o listă de alerte prin poșta utilizatorului.
	 * @param name String
	 * @param u User
	 * @return List<Alerta>
	 */
	List<Alerta> findAllByDestinatarioOrUsuario(String name, Users u);

}

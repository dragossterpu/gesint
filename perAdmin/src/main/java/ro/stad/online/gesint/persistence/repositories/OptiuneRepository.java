package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Optiune;
import ro.per.online.persistence.entities.PProvince;

/**
 * Repositoriu pentru entitatea Optiune.
 * @author STAD
 */
public interface OptiuneRepository extends CrudRepository<Optiune, Long> {

	/**
	 * Cauta toate optiunile inregistrate ale unui judet
	 * @return List<Optiune>)
	 */
	// @Query(value = "select * from users where role=?1 and code_province=?2", nativeQuery = true)
	List<Optiune> findByProvince(PProvince code);

}

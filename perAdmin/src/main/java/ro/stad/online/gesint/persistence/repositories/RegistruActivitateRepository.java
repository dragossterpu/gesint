package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ro.per.online.persistence.entities.RegistroActividad;

/**
 * Repositorio de registro de actividad.
 * @author STAD
 *
 */
public interface RegistroActividadRepository extends CrudRepository<RegistroActividad, Long> {

	/**
	 * Devuelve una lista de nombres de usuario cuyo nombre coincide la cadena recibida como parámetro.
	 * @param info Username del usuario de registro
	 * @return Listado de nombres de usuario cuyos nombres coinciden determinada cadena
	 *
	 */
	@Query("SELECT DISTINCT(usernameRegActividad) FROM RegistroActividad WHERE UPPER(usernameRegActividad) LIKE UPPER(:info) ORDER BY usernameRegActividad ")
	List<String> buscarPorUsuarioRegistro(@Param("info") String info);

}

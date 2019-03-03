package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.RoleEnum;

/**
 * Repositoriu pentru entitatea Users.
 * @author STAD
 */
public interface UserRepository extends CrudRepository<Users, String> {

	/**
	 * Căutați un utilizator cu CNP.
	 * @param cnp String - cnp-ul utilizatorului
	 * @return User
	 */
	Users findByIdCard(String cnp);

	/**
	 * Devuelve una lista con los usuarios que estan en una localidad
	 * @param nume dupa care se face cautarea in baza de date
	 * @return Lista de nombres de usuarios presentes en la BBDD
	 */
	List<Users> findByLocality(PLocality loca);

	/**
	 * Devuelve una lista con nombres de los usuarios que estén presentes en la lista y en BBDD.
	 * @param nume dupa care se face cautarea in baza de date
	 * @return Lista de nombres de usuarios presentes en la BBDD
	 */
	List<Users> findByName(String nume);

	/**
	 * Cauta un utilizator cu rolul si judetul.
	 * @param rol RoleEnum
	 * @param prov PProvince
	 * @return User
	 */
//	@Query(value = "select * from users where role=?1 and code_province=?2", nativeQuery = true)
	Users findByRoleAndProvince(RoleEnum rol, PProvince prov);

	/**
	 * Devuelve una lista de usuarios que coincidan con los nombres de usuarios proporcionados.
	 * @param listaUsernames lista de nombres de usuarios
	 * @return lista de usuarios encontrados
	 */
	List<Users> findByUsernameIn(final List<String> listaUsernames);

	/**
	 * Devuelve una lista con nombres de los usuarios que estén presentes en la lista y en BBDD.
	 * @param listaNombres lista de nombres que se buscarán en bbdd
	 * @return Lista de nombres de usuarios presentes en la BBDD
	 */
	@Query("SELECT u.username FROM Users u where u.username in (:listaNombres)")
	List<String> findUsernamesByUsername(@Param("listaNombres") List<String> listaNombres);

	/**
	 * Devuelve las categorias a las que pertenece una evaluaciÃ³n.
	 *
	 * @param id de la evaluacion consultada
	 * @return Listado de las categorias a las que pertenece.
	 */
	@Query(value = "select count(*) from users where sex=?1 date_create between date=?2 and date'=?3", nativeQuery = true)
	Integer findUsersBySex(String sex, String desde, String hasta);
}

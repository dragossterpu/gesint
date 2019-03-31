package ro.per.online.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.model.SortOrder;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.PTeam;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.pojo.AnNumarPojo;
import ro.per.online.web.beans.TeamBusqueda;
import ro.per.online.web.beans.UsuarioBusqueda;

/**
 * Interfață pentru serviciul de Team.
 *
 * @author STAD
 *
 */
public interface UserService {

	/**
	 * Elimina de manera lógica a una lista de usuarios.
	 * @param listaUsuarios Lista de usuarios a modificar
	 * @return lista de usuarios modificada
	 */
	List<Users> bajaLogica(List<String> listaUsuarios);

	/**
	 * Devuelve una lista con nombres de los usuarios que estén presentes en la lista y en BBDD.
	 * @param listaNombres lista de nombres que se buscarán en bbdd
	 * @return Lista de nombres de usuarios presentes en la BBDD
	 */
	List<String> buscarListaDeUsernames(List<String> listaNombres);

	/**
	 * Devuelve una lista de usuarios.
	 * @param usuarioBusqueda Objeto que contiene los parámetros de búsqueda
	 * @return Listado resultante de la búsqueda
	 */
	List<Users> buscarUsuario(UsuarioBusqueda usuarioBusqueda);

	/**
	 * Busca usuarios con los parametros de búsqueda.
	 * @param searchUser AnNumarPojo
	 * @param sortOrder SortOrder
	 * @param sortField String
	 * @param pageSize int
	 * @param first int
	 * @return List<User>
	 */
	List<Users> buscarUsuarioCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			UsuarioBusqueda searchUser);

	/**
	 * Busca usuarios utilizando criteria.
	 * @param usuarioBusqueda AnNumarPojo
	 * @return List<User>
	 */
	List<Users> buscarUsuarioCriteria(UsuarioBusqueda usuarioBusqueda);

	/**
	 * Busca usuarios utilizando criteria.
	 * @param usuarioBusqueda AnNumarPojo
	 * @return List<User>
	 */
	List<Users> buscarUsuarioCriteriaLocal(TeamBusqueda teamBusqueda);

	/**
	 * Incarcam fotografia unui utilizator.
	 * @param usuario a eliminar
	 * @throws IOException
	 */

	Users cargaImagenSinGuardar(byte[] bs, Users user) throws IOException;

	/**
	 * Eliminación de un usuario.
	 * @param usuario a eliminar
	 */
	void delete(Users usuario);

	/**
	 * Establece una lista de usuarios como inactivo.
	 * @param listaUsuarios Lista de usuarios a modificar
	 * @return lista de usuarios modificada
	 */
	List<Users> desactivar(List<String> listaUsuarios);

	/**
	 * Cauta totii utilizatorii
	 * @return lista de utilizatori.
	 */
	List<Users> fiindAll();

	/**
	 * Cautaun utilizator dupa id.
	 * @return Users userlista de utilizatori.
	 */
	Users fiindOne(String id);

	/**
	 * Căutați un utilizator cu CNP.
	 * @param cnp String - cnp-ul utilizatorului
	 * @return User
	 */
	Users findByIdCard(String cnp);

	/**
	 * Căutați un utilizator dupa localitate.
	 * @param Long id
	 * @return List<Users>
	 */
	List<Users> findByLocality(PLocality loca);

	/**
	 * Devuelve una lista de destinatari externi de PER.
	 * @return Listado resultante de la búsqueda
	 */
	List<Users> findByName();

	/**
	 * @param prov
	 * @param listaTeam
	 * @return lista
	 *
	 */
	List<Users> findByProvinceAndTeam(PProvince prov, List<PTeam> listaTeam);

	/**
	 * Cauta un utilizator cu rolul si judetul.
	 * @param rol RoleEnum
	 * @param prov PProvince
	 * @return User
	 */
	// List<Users> findByProvinceAndRol(PProvince prov, List<RoleEnum> roles);

	/**
	 * Cauta un utilizator cu rolul si judetul.
	 * @param rol RoleEnum
	 * @param prov PProvince
	 * @return User
	 */
	Users findByTeamAndProvince(PTeam team, PProvince prov);

	/**
	 * @return
	 *
	 */
	Long findCount();

	/**
	 * @param sex
	 * @param desde
	 * @param hasta
	 * @return long count
	 */
	int findUsersBySex(AnNumarPojo membru);

	/**
	 * Obtiene el conteo de criteria.
	 * @param searchUser AnNumarPojo
	 * @return int
	 */
	int getCounCriteria(UsuarioBusqueda searchUser);

	/**
	 * Guarda una lista de usuarios.
	 *
	 * @param usuarios lista
	 * @return lista de usuarios
	 */
	List<Users> guardado(List<Users> usuarios);

	/**
	 * Guarda en base de datos el usuario.
	 * @param entity Usuario a guardar.
	 * @return Usuario guardado.
	 */
	Users save(Users entity);
}

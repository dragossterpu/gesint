package ro.per.online.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.model.SortOrder;

import ro.per.online.persistence.entities.Users;
import ro.per.online.web.beans.UsuarioBusqueda;

/**
 * Interfață pentru serviciul de Team.
 *
 * @author STAD
 *
 */
public interface UserService {

	/**
	 * Busca usuarios con los parametros de búsqueda.
	 * @param searchUser UsuarioBusqueda
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
	 * @param usuarioBusqueda UsuarioBusqueda
	 * @return List<User>
	 */
	List<Users> buscarUsuarioCriteria(UsuarioBusqueda usuarioBusqueda);

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
	 * Obtiene el conteo de criteria.
	 * @param searchUser UsuarioBusqueda
	 * @return int
	 */
	int getCounCriteria(UsuarioBusqueda searchUser);

	/**
	 * Guarda en base de datos el usuario.
	 * @param entity Usuario a guardar.
	 * @return Usuario guardado.
	 */
	Users save(Users entity);
}

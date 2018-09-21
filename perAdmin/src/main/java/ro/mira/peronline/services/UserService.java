package ro.mira.peronline.services;

import java.util.List;

import org.primefaces.model.SortOrder;

import ro.mira.peronline.persistence.entities.Users;
import ro.mira.peronline.web.beans.SearchUser;

/**
 * Interfață pentru serviciul de Team.
 *
 * @author STAD
 *
 */
public interface UserService {

	/**
	 * Cauta totii utilizatorii
	 *
	 * @return lista de utilizatori.
	 */
	List<Users> fiindAll();

	/**
	 * Cautaun utilizator dupa id.
	 *
	 * @return Users userlista de utilizatori.
	 */
	Users fiindOne(String id);

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda UsuarioBusqueda
	 * @return int
	 */
	int getCounCriteria(SearchUser busqueda);

	/**
	 * Busca usuarios con los parametros de búsqueda.
	 * @param usuarioBusqueda UsuarioBusqueda
	 * @param sortOrder SortOrder
	 * @param sortField String
	 * @param pageSize int
	 * @param first int
	 *
	 * @return List<User>
	 *
	 *
	 */
	List<Users> buscarUsuarioCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			SearchUser usuarioBusqueda);

}

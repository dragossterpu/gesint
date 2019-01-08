package ro.per.online.services;

import java.util.List;

import org.primefaces.model.SortOrder;

import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Users;
import ro.per.online.web.beans.AlertaBusqueda;

/**
 * Declarația metodelor care vor fi utilizate pentru persistența alertelor..
 * @author STAD
 *
 */
public interface AlertaService {

	/**
	 * Busca alertas con los parametros de búsqueda.
	 * @param alertaBusqueda AlertaBusqueda
	 * @param sortOrder SortOrder
	 * @param sortField String
	 * @param pageSize int
	 * @param first int
	 * 
	 * @return List<Alerta>
	 *
	 * 
	 */
	List<Alerta> buscarAlertaCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			AlertaBusqueda alertaBusqueda);

	// /**
	// * Recupera las alertas del usuario que se esta modificando.
	// * @param usuarioModificando User
	// * @return List<Alerta>
	// */
	// List<Alerta> buscarAlertasPorUsuario(Users usuarioModificando);

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda AlertaBusqueda
	 * @return int
	 */
	int getCounCriteria(AlertaBusqueda busqueda);

	/**
	 * Guarda una alerta.
	 * @param alerta Alerta
	 * @return Alerta actualizado
	 */
	Alerta save(Alerta alerta);

	/**
	 * Envía una alerta pasando una lista de destinatarios.
	 * @param alerta Alerta
	 * @param usuariosSeleccionados List<User>
	 */
	void sendAlert(Alerta alerta, List<Users> usuariosSeleccionados);

	/**
	 * Envía una alerta pasando un destinatario.
	 * @param alerta Alerta
	 * @param usuario User
	 */
	void sendAlertUsuario(Alerta alerta, Users usuario);

}

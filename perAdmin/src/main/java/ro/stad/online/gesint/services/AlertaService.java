package ro.per.online.services;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import com.mitchellbosecke.pebble.error.PebbleException;

import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Documento;
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

	/**
	 * Eliminación de un usuario.
	 * @param usuario a eliminar
	 */
	void delete(Long id);

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
	void sendAlert(Alerta alerta, List<Users> usuariosSeleccionados, List<Documento> documentosCargados,
			String plantilla, Map<String, String> paramPlantilla) throws PebbleException;

	/**
	 * Cauta o alerta
	 * @param alerta Alerta
	 * @return alerta Alerta
	 */
	Alerta fiindOne(Alerta alerta);

}

package ro.per.online.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.error.PebbleException;

import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.Users;

/**
 * 
 * Clase para el envío de correos electrónicos.
 * 
 * @author STAD
 * 
 */
public interface CorreoElectronico {

	/**
	 * Envío de alerta.
	 * @param alerta Alerta
	 * @param usuariosSeleccionados Users
	 * @return Date
	 */
	Date send(final Alerta alerta, List<Users> usuariosSeleccionados, List<Documento> documentosCargados,
			String plantilla, Map<String, String> paramPlantilla) throws PebbleException;
}

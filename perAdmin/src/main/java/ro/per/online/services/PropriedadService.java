package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.Propriedades;

/**
 * Interfaz del servicio para la gestión de propriedades.
 * 
 * @author STAD
 *
 */
public interface PropriedadService {

	/**
	 * Devuelve todos los nparametros de conexión al servidor de correo.
	 * @param <Propriedades>
	 * @param filename
	 * @return List<Propriedades>
	 */
	List<Propriedades> findByFilename(String filename);
}

package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.Mapa;

/**
 * Interfață pentru serviciul de Mapa.
 *
 * @author STAD
 *
 */
public interface MapaService {

	/**
	 * Cauta toate tarile
	 * @return lista de tari.
	 */
	List<Mapa> fiindAll();

}

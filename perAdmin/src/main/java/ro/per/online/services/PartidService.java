package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.Partid;

/**
 * Interfață pentru serviciul de Partid.
 *
 * @author STAD
 *
 */
public interface PartidService {

	/**
	 * Elimina un partid.
	 *
	 * @param partid
	 */
	void delete(Partid partid);

	/**
	 * Cauta toate partidele
	 *
	 * @return lista de partid.
	 */
	List<Partid> fiindAll();

	/**
	 * Inregistreaza un partid.
	 * @param partid Partid
	 * @return partid actualizat
	 */
	Partid save(Partid partid);

}

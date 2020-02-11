package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.Optiune;
import ro.per.online.persistence.entities.PProvince;

/**
 * Interfață pentru serviciul de optiuni.
 *
 * @author STAD
 *
 */
public interface OptiuneService {

	/**
	 * Elimina o optiune.
	 *
	 * @param partid
	 */
	void delete(Optiune optiune);

	/**
	 * Cauta toate optiunile
	 *
	 * @return lista de optiuni.
	 */
	List<Optiune> fiindAll();

	/**
	 * Cautam optiunile dupa judet.
	 * @param code String
	 * @return List<Optiune> listaOptiuni
	 */
	List<Optiune> findByCodeProvince(PProvince code);

	/**
	 * Inregistreaza o optiune.
	 * @param optiune Optiune
	 * @return optiune actualizata
	 */
	Optiune save(Optiune optiune);

}

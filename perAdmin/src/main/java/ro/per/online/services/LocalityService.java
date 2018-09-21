package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;

/**
 * Interfață pentru serviciul de PLocality.
 *
 * @author STAD
 *
 */
public interface LocalityService {

	/**
	 * Cauta toate localitatile
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PLocality> fiindAll();

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PLocality> findByProvince(PProvince province);

}

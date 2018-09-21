package ro.mira.peronline.services;

import java.util.List;

import ro.mira.peronline.persistence.entities.PLocality;
import ro.mira.peronline.persistence.entities.PProvince;

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

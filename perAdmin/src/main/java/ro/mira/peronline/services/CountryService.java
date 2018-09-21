package ro.mira.peronline.services;

import java.util.List;

import ro.mira.peronline.persistence.entities.PCountry;

/**
 * Interfață pentru serviciul de PCountry.
 *
 * @author STAD
 *
 */
public interface CountryService {

	/**
	 * Cauta toate tarile
	 * @return lista de tari.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PCountry> fiindAll();

}

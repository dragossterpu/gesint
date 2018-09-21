package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.PProvince;

/**
 * Interfață pentru serviciul de PProvince.
 *
 * @author STAD
 *
 */
public interface ProvinceService {

	/**
	 * Cauta toate judetele
	 *
	 * @return lista de judete.
	 */
	List<PProvince> fiindAll();

	/**
	 * Cauta un judet
	 * @param province Judetul
	 * @return PProvince province
	 */
	PProvince fiindOne(PProvince province);

}

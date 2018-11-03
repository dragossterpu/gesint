package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;

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

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PLocality> buscaByProvincia(Long idProvincia);

	/**
	 * Comprueba si existe un municipio conociendo su nombre.
	 * 
	 * @param name nombre del municipio
	 * @param provincia a la que pertenece el municipio
	 * @return valor booleano
	 */
	boolean existeByNameIgnoreCaseAndProvincia(String name, PProvince provincia);

	/**
	 * Guarda un nuevo municipio.
	 * @param nombre del municipio
	 * @param provincia a la que pertenece el municipio
	 * @return municipio creado (true si es guardado correctamente)
	 */
	PLocality crearLocalidad(String nombre, PProvince provincia, TypeLocalityEnum tipLoclalitate);

	/**
	 * Cauta o localitate
	 * @param Long localitiId
	 * @return PLocality localitatea
	 */
	PLocality findById(Long localitiId);

}

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
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PLocality> buscaByProvincia(Long idProvincia);

	/**
	 * Guarda un nuevo municipio.
	 * @param nombre del municipio
	 * @param provincia a la que pertenece el municipio
	 * @return municipio creado (true si es guardado correctamente)
	 */
	PLocality crearLocalidad(String nombre, PProvince provincia, TypeLocalityEnum tipLoclalitate);

	/**
	 * Comprueba si existe un municipio conociendo su nombre.
	 *
	 * @param name nombre del municipio
	 * @param provincia a la que pertenece el municipio
	 * @return valor booleano
	 */
	boolean existeByNameIgnoreCaseAndProvincia(String name, PProvince provincia);

	/**
	 * Cauta un municipio conociendo su nombre.
	 *
	 * @param name nombre del municipio
	 * @param judetul
	 * @return PLocality localidad
	 */
	PLocality localidadByNameIgnoreCaseAndProvincia(String name, PProvince provincia);

	/**
	 * Cauta toate localitatile
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PLocality> fiindAll();

	/**
	 * Cauta o localitate
	 * @param Long localitiId
	 * @return PLocality localitatea
	 */
	PLocality findById(Long localitiId);
	/**
	 * Cauta o localitate
	 * @param Long localitiId
	 * @return PLocality localitatea
	 */
	PLocality findByName(String local);
	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PLocality> findByProvince(PProvince province);

}

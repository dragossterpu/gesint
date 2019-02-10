package ro.per.online.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.model.SortOrder;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;
import ro.per.online.web.beans.admin.LocalitateBusqueda;

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

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	List<PLocality> findByProvinceAndNivel(PProvince province, Long nivel);

	/**
	 * Inregistreaza o localitate.
	 * @param localitate PLocality
	 * @return localitate actualizata
	 */
	PLocality save(PLocality localitate);

	/**
	 * Incarcam fotografia unei localitati.
	 * @param PLocality localitate
	 * @throws IOException
	 */

	PLocality cargaImagenSinGuardar(byte[] bs, PLocality localitate) throws IOException;

	/**
	 * Método que devuelve el número de links en una consulta basada en criteria.
	 *
	 * @param linkBusqueda LinksBusqueda objeto con parámetros de búsqueda
	 * @return devuelve el número de registros de una consulta criteria.
	 */
	int getCounCriteria(LocalitateBusqueda localitateBusqueda);

	/**
	 * Método que devuelve la lista de links en una consulta basada en criteria.
	 *
	 * @param linkBusqueda objeto con los criterios de búsqueda
	 * @param first primer elemento
	 * @param pageSize tamaño de cada página de resultados
	 * @param sortField campo por el que se ordenan los resultados
	 * @param sortOrder sentido de la ordenacion (ascendente/descendente)
	 * @return la lista de links.
	 */
	List<PLocality> buscarLocalitateCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			LocalitateBusqueda localitateBusqueda);

	/**
	 * Elimina o localitate
	 * @param PLocality localitate
	 */
	void delete(PLocality localitate);
}

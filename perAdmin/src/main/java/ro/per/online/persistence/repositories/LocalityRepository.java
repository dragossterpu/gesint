package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;

/**
 * Repositoriu pentru entitatea PLocality.
 * @author STAD
 */
public interface LocalityRepository extends CrudRepository<PLocality, Long> {
	/**
	 * Comprueba si existe un municipio sabiendo su nombre y la provincia a la que pertenece.
	 *
	 * @param name nombre del municipio.
	 * @param provincia del municipio
	 * @return existe?
	 */
	boolean existsByNameIgnoreCaseAndProvince(String name, PProvince provincia);

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 */
	List<PLocality> findAllByProvince(PProvince province);

	/**
	 * Busca todos las localidades de una provincia.
	 *
	 * @param idProvincia id de la provincia seleccionada
	 * @return List<Localidad> Lista de localidades por provincia.
	 */
	List<PLocality> findByProvinceOrderByName(Long idProvincia);

	/**
	 * @param name
	 * @param provincia
	 * @return
	 *
	 */
	PLocality findByNameIgnoreCaseAndProvince(String name, PProvince provincia);
}

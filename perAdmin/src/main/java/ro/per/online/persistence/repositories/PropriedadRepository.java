package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.Propriedades;

/**
 * Repositorio de operaciones de base de datos para la entidad Propriedades.
 * 
 * @author ATOS
 *
 */
public interface PropriedadRepository extends CrudRepository<Propriedades, Long> {

	/**
	 * Devuelve la lista de centros ordenada por el nombre ascendente.
	 * @param idDepartamento departamento al que pertenece
	 * @return List<Propriedades> lista de propriedades.
	 * @see servicios.impl.PropriedadesServiceImpl.findByFilename(String)
	 */
	List<Propriedades> findByFilename(String filename);
}

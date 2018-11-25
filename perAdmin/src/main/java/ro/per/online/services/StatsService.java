package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.ModelStats;
import ro.per.online.web.beans.StatsBusqueda;

/**
 * Interfaz stats service.
 * @author STAD
 *
 */
public interface StatsService {

	/**
	 * Obtiene el modelo de datos de las distintas categorias de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDatosCategoriasSectores(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de datos de estados.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDatosEstados(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de datos de evolución.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDatosEvolucion(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de datos de la modalidad de prevención.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDatosModalidadPrevencion(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de datos del número de trabajadores de los formularios de evaluat.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDatosNumeroTrabajadores(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de datos de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDatosSectores(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de datos de usuarios.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDatosUsuarios(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de distribución de datos totales.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDistribucionDatosTotales(StatsBusqueda statsBusqueda);

	/**
	 * Obtiene el modelo de datos de las inscripciones al curso instruyet.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	List<ModelStats> getModeloDistribucionInscripciones(StatsBusqueda statsBusqueda);

	/**
	 * @return
	 *
	 */
	List<ModelStats> getUserByProvince(Long id);

	List<ModelStats> getUserProvince();
}

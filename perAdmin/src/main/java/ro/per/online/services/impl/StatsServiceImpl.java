package ro.per.online.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.ModelStats;
import ro.per.online.services.StatsService;
import ro.per.online.services.delegate.estadisticas.DataStatsProvider;
import ro.per.online.services.delegate.estadisticas.QueryDataStatsProvider;
import ro.per.online.web.beans.StatsBusqueda;

/**
 * Implementación de los métodos definidos en la interfaz StatsService.
 * @author Ezentis
 *
 */
@Service
public class StatsServiceImpl implements StatsService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Entity manager.
	 */
	@PersistenceContext
	private transient EntityManager entityManager;

	/**
	 * Proveedor de datos del servicio.
	 */
	private transient DataStatsProvider proveedorDatos;

	/**
	 * Inicializa el proveedor de datos especificado.
	 */
	private void initProveedorDatos() {
		proveedorDatos = new QueryDataStatsProvider(entityManager);
	}

	/**
	 * Obtiene el modelo de datos totales.
	 * @param statsBusqueda StatsBusqueda
	 * @return ModelStats
	 */
	@Override
	public ModelStats getModeloDatosTotales(final StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosTotales(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de distribución de datos totales.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDistribucionDatosTotales(final StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDistribucionDatosTotales(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos de usuarios.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosUsuarios(final StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosUsuarios(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos de evolución.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosEvolucion(final StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosEvolucion(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosSectores(StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosSectores(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos de estados.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosEstados(StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosEstados(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos de la modalidad de prevención.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosModalidadPrevencion(StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosModalidadPrevencion(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos de las inscripciones al curso instruyet.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDistribucionInscripciones(StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDistribucionInscripciones(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos del número de trabajadores de los formularios de evaluat.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosNumeroTrabajadores(StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosNumeroTrabajadores(statsBusqueda);
	}

	/**
	 * Obtiene el modelo de datos de las distintas categorias de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosCategoriasSectores(StatsBusqueda statsBusqueda) {
		initProveedorDatos();
		return proveedorDatos.getModeloDatosCategoriasSectores(statsBusqueda);
	}

}

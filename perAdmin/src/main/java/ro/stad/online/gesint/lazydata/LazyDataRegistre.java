package ro.per.online.lazydata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.persistence.entities.RegistroActividad;
import ro.per.online.services.RegistroActividadService;
import ro.per.online.web.beans.RegistroBusqueda;

/**
 * 
 * Modelo para paginación desde servidor extendiendo el modelo LazyDataModel de Primefaces.
 * 
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyDataRegistro extends LazyDataModel<RegistroActividad> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Objeto que contiene los parámetros de búsqueda.
	 */
	private transient RegistroBusqueda busqueda;

	/**
	 * Lista que sirve al modelo como fuente de datos.
	 */
	private transient List<RegistroActividad> datasource;

	/**
	 * Servicio a usar.
	 */
	private transient RegistroActividadService registroActividadService;

	/**
	 * 
	 * Constructor del modelo que recibe el servicio como parámetro.
	 * 
	 * @param servicio Servicio a emplear
	 */
	public LazyDataRegistro(final RegistroActividadService servicio) {
		this.registroActividadService = servicio;
	}

	/**
	 * Sobreescritura del método getRowData para que funcione con objetos de tipo RegistroActividad.
	 * 
	 * @param rowKey Clave de la fila sobre la que se ha hecho click en la vista
	 * @return Registro que se corresponde con la clave recibida por parámetro
	 * 
	 */
	@Override
	public RegistroActividad getRowData(final String rowKey) {
		RegistroActividad reg = null;
		for (final RegistroActividad registro : datasource) {
			if (registro.getIdRegActividad().toString().equals(rowKey)) {
				reg = registro;
			}
		}
		return reg;
	}

	/**
	 * Sobrescritura del método getRowKey.
	 * 
	 * @param solicitud Objeto del que se desea obtener la clave
	 * @return Clave del objeto pasado como parámetro
	 */

	@Override
	public Object getRowKey(final RegistroActividad solicitud) {
		return solicitud.getIdRegActividad();
	}

	/**
	 * Sobreescritura del método Load para que funcione con un critera y sólo nos devuelva estríctamente el número de
	 * registros solicitados.
	 * 
	 * @param first primer elemento que se desea recuperar
	 * @param pageSize número máximo de registros que deseamos recuperar por página
	 * @param sortField columna por la que se ordenarán los resultados. Corresponde a la propiedad 'sortBy' de la
	 * columna de la vista
	 * @param sortOrder orden por el que se desea ordenar los resultados
	 * @param filters mapa de filtros. Este valor no se utiliza en esta sobreescritura.
	 * @return lista de registros que corresponden a los criterios de búsqueda
	 * 
	 */

	@Override
	public List<RegistroActividad> load(final int first, final int pageSize, final String sortField,
			final SortOrder sortOrder, final Map<String, Object> filters) {
		List<RegistroActividad> listado = null;
		if (busqueda == null) {
			this.setRowCount(0);
		}
		else {
			this.setRowCount(registroActividadService.getCounCriteria(busqueda));
			listado = registroActividadService.buscarRegActividadCriteria(first, pageSize, sortField, sortOrder,
					busqueda);
			this.datasource = listado;
		}
		return listado;

	}
}

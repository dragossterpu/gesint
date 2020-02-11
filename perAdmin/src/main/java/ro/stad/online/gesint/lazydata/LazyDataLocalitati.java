package ro.per.online.lazydata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.services.LocalityService;
import ro.per.online.web.beans.admin.LocalitateBusqueda;

/**
 *
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel al Primefaces.
 *
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyModelLocalitati extends LazyDataModel<PLocality> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Objeto que contiene los parámetros de búsqueda.
	 */
	private LocalitateBusqueda busqueda;

	/**
	 * Servicio a usar.
	 */
	@Autowired
	private transient LocalityService servicio;

	/**
	 * Lista que sirve al modelo como fuente de datos.
	 */
	private List<PLocality> datasource;

	/**
	 * Constructor.
	 *
	 * @param service Servicio a utilizar
	 */
	public LazyModelLocalitati(final LocalityService service) {
		this.servicio = service;
		this.busqueda = new LocalitateBusqueda();
	}

	/**
	 * Sobreescritura del método getRowData para adaptarlo a nuestro modelo.
	 *
	 * @param rowKey Fila que se ha seleccionado en la vista
	 * @return Link que corresponde a la fila seleccionada
	 */
	@Override
	public PLocality getRowData(final String rowKey) {
		PLocality localitate = null;
		for (final PLocality enlace : this.datasource) {
			if (enlace != null && enlace.getId().toString().equals(rowKey)) {
				localitate = enlace;
			}
		}
		return localitate;
	}

	/**
	 * Sobreestritura del método getRowKey para adaptarlo a nuestro modelo.
	 *
	 * @param solicitud Link del que se desea recuperar la clave
	 * @return Clave del link
	 */
	@Override
	public Object getRowKey(final PLocality solicitud) {
		return solicitud.getId();
	}

	/**
	 * Sobreescritura del método load para realizar la carga paginada.
	 *
	 * @param first primer elemento de la paginación
	 * @param pageSize número máximo de registros recuperados
	 * @param sortField campo por el que se ordena
	 * @param sortOrder sentido de la orientación
	 * @param filters que se aplicarán a la búsqueda.
	 * @return listado de registros que corresponden a la búsqueda
	 */
	@Override
	public List<PLocality> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder,
			final Map<String, Object> filters) {
		List<PLocality> listado = null;
		if (this.busqueda != null) {
			setRowCount(this.servicio.getCounCriteria(this.busqueda));
			listado = this.servicio.buscarLocalitateCriteria(first, pageSize, sortField, sortOrder, this.busqueda);
			setDatasource(listado);
		}
		else {
			setRowCount(0);
		}
		return listado;

	}

}

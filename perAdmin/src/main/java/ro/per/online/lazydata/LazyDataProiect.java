package ro.per.online.lazydata;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.persistence.entities.Proiecte;
import ro.per.online.services.ProiectService;
import ro.per.online.web.beans.ProiectBusqueda;

/**
 * 
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel al Primefaces.
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyDataProiect extends LazyDataModel<Proiecte> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Obiect care conține parametrii de căutare.
	 */
	private transient ProiectBusqueda proiectBusqueda;

	/**
	 * Listă care servește modelul ca sursă de date.
	 */
	private transient List<Proiecte> datasource;

	/**
	 * Serviciu a usar.
	 */
	private transient ProiectService proiectService;

	/**
	 * 
	 * Constructor al modelului care primește serviciul ca parametru.
	 * 
	 * @param servicio Servicio a emplear
	 */
	public LazyDataProiect(final ProiectService servicio) {
		proiectService = servicio;
	}

	/**
	 * Suprascrierea metodei getRowData pentru a lucra cu obiectele utilizatorului.
	 * 
	 * @param rowKeyCheia rândului pe care a fost vizionat vizualizarea
	 * @return Utilizator care corespunde cheii primite de parametru
	 * 
	 */

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Proiecte getRowData(final String rowKey) {
		Proiecte proiect = null;
		@SuppressWarnings("unchecked")
		final List<Proiecte> listaWrapped = (List<Proiecte>) this.getWrappedData();
		final Set<Proiecte> setProiecte = new HashSet<>();
		if (listaWrapped != null) {
			setProiecte.addAll(listaWrapped);
		}
		if (getDatasource() != null) {
			setProiecte.addAll(getDatasource());
		}
		final Iterator<Proiecte> iteratorProiecte = setProiecte.iterator();
		boolean encontrado = false;
		while (iteratorProiecte.hasNext() && !encontrado) {
			final Proiecte proiecte = iteratorProiecte.next();
			if (rowKey.equals(proiecte.getId())) {
				proiect = proiecte;
				encontrado = true;
			}
		}
		return proiect;
	}

	/**
	 * Sobrescritura del método getRowKey.
	 * 
	 * @param user Objeto del que se desea obtener la clave
	 * @return Clave del objeto pasado como parámetro
	 */

	@Override
	public Object getRowKey(final Proiecte proiect) {
		return proiect.getId();
	}

	/**
	 * Suprascrieți metoda de încărcare pentru a lucra cu un criteriu și returnați numai numărul de utilizatori
	 * solicitați.
	 * 
	 * @param first primul element pe care doriți să îl recuperați
	 * @param pageSize numărul maxim de înregistrări pe care dorim să le preluăm pe pagină
	 * @param sortField columna por la que se ordenarán los resultados. Corresponde a la propiedad 'sortBy' de la
	 * columna de la vista
	 * @param sortOrder orden por el que se desea ordenar los resultados
	 * @param filters mapa de filtros. Este valor no se utiliza en esta sobreescritura.
	 * @return lista de usuarios que corresponden a los criterios de búsqueda
	 * 
	 */

	@Override
	public List<Proiecte> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder,
			final Map<String, Object> filters) {
		List<Proiecte> listado = null;
		if (proiectBusqueda == null) {
			this.setRowCount(0);
		}
		else {

			this.setRowCount(proiectService.getCounCriteria(proiectBusqueda));
			listado = proiectService.buscarProiecteCriteria(first, pageSize, sortField, sortOrder, proiectBusqueda);
		}
		return listado;

	}

}

package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.lazydata.LazyDataRegistro;
import ro.per.online.persistence.entities.RegistroActividad;
import ro.per.online.services.RegistroActividadService;

/**
 * Bean para la gestión del registro de actividad.
 *
 * @author STAD
 *
 */

@Setter
@Getter
@Controller("registroBean")
@Scope(Constantes.SESSION)
public class RegistroActividadBean implements Serializable {

	/**
		 *
		 */
	private static final long serialVersionUID = 1L;

	/**
	 * Número de columnas en la vista.
	 */
	private static final Integer NUMCOLSREGISTRO = 5;

	/**
	 * Lista de booleanos para controlar la visualización de columnas en la vista.
	 */
	private List<Boolean> list;

	/**
	 * Objeto que se usará para visualizar los registros.
	 */
	private RegistroActividad error;

	/**
	 * Objeto que contendrá el parámetros de búsqueda.
	 */
	private RegistroBusqueda registroBusqueda;

	/**
	 * LazyModel para la visualización paginada de datos en la vista.
	 */
	private LazyDataRegistro model;

	/**
	 * Servicio de registro de actividad.
	 */
	@Autowired
	private transient RegistroActividadService regActividadService;

	/**
	 * Devuelve una lista con las nombre de usuario que contengan la cadena de texto que se recibe como parámetro.
	 * @param infoUsuario Usuario por el que se hace la consulta
	 * @return Listado de resultados
	 *
	 */
	public List<String> autocompletarUsuario(final String infoUsuario) {
		return regActividadService
				.buscarPorUsuarioRegistro(Constantes.PORCENTAJE + infoUsuario + Constantes.PORCENTAJE);
	}

	/**
	 * Busca en el registro de actividad según los criterios elegidos por el usuario en la vista y carga los resultados
	 * en una lista para su visualización.
	 */
	public void buscarRegActividad() {
		model.setBusqueda(registroBusqueda);
		model.load(0, Constantes.TAMPAGINA, Constantes.FECHACREACION, SortOrder.DESCENDING, null);

	}

	/**
	 * Inicializa el bean.
	 *
	 */
	@PostConstruct
	public void init() {
		list = new ArrayList<>();
		for (int i = 0; i < NUMCOLSREGISTRO; i++) {
			list.add(Boolean.TRUE);
		}
		this.registroBusqueda = new RegistroBusqueda();
		model = new LazyDataRegistro(regActividadService);
	}

	/**
	 * Limpia los parámetros de búsqueda y el resultado.
	 */
	public void limpiarBusqueda() {
		this.registroBusqueda = new RegistroBusqueda();
		this.model = new LazyDataRegistro(regActividadService);
		this.model.setDatasource(new ArrayList<>());
	}

	/**
	 * Controla las columnas visibles en la lista de resultados del buscador.
	 * @param e Evento toggle
	 */
	public void onToggle(final ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

}

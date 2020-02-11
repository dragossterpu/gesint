package ro.per.online.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.Propriedades;
import ro.per.online.services.PropriedadService;
import ro.per.online.services.ProvinceService;

/**
 * Clase utilizada para cargar datos en el contexto de la aplicación al arrarancar el servidor.
 *
 * @author STAD
 *
 */
@Component("applicationBean")
@Setter
@Getter
@NoArgsConstructor
public class ApplicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constante para cargar la lista de datos para envio mail
	 */
	private static String MAIL = "MAIL";

	/**
	 * Constante para cargar la lista de extensiones
	 */
	private static String EXT = "extensiones";

	/**
	 * Entity Manager para gestión de la persistencia.
	 */
	@PersistenceContext
	private transient EntityManager em;

	/**
	 * Mapa que contendrá los parámetros de la aplicación.
	 */
	private Map<String, String> mapaParametrosMail;

	/**
	 * Mapa que contendrá los parámetros de la aplicación.
	 */
	private Map<String, String> mapaExtensiones;

	/**
	 * Listado de accesos remotos a Elypse.
	 */
	private List<Propriedades> listaConfMail;

	/**
	 * Listado de extensiones de un document.
	 */
	private List<Propriedades> listaExtensiones;

	@Autowired
	private ProvinceService provinceService;

	/**
	 * Lista de judete.
	 */
	private List<PProvince> provinces;

	/**
	 * Servicio de propriedades.
	 */

	@Autowired
	private transient PropriedadService propriedadService;

	/**
	 *
	 */
	private void extensiones() {
		final Map<String, String> mapaParametros = new HashMap<>();
		for (final Propriedades param : listaExtensiones) {
			mapaParametros.put(param.getName(), param.getValue());
		}
		setMapaExtensiones(mapaParametros);
	}

	/**
	 * Inicialización de datos.
	 */
	@PostConstruct
	public void init() {
		this.listaConfMail = new ArrayList<>();
		listaConfMail = propriedadService.findByFilename(MAIL);
		listaExtensiones = propriedadService.findByFilename(EXT);
		this.provinces = provinceService.fiindAll();
		paramMail();
		extensiones();
	}

	/**
	 *
	 */
	private void paramMail() {
		final Map<String, String> mapaParametros = new HashMap<>();
		for (final Propriedades param : listaConfMail) {
			mapaParametros.put(param.getName(), param.getValue());
		}
		setMapaParametrosMail(mapaParametros);
	}

	/**
	 * Método logout de backoffice.
	 * @throws IOException excepción lanzada
	 */
	public void logout() throws IOException {
		final HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().redirect(req.getContextPath() + "/logout");
	}
}

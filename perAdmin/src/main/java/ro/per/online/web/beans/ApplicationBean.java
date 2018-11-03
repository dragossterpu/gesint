package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.Propriedades;
import ro.per.online.services.PropriedadService;

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
	 * Entity Manager para gestión de la persistencia.
	 */
	@PersistenceContext
	private transient EntityManager em;

	/**
	 * Mapa que contendrá los parámetros de la aplicación.
	 */
	private Map<String, String> mapaParametrosMail;

	/**
	 * Constante para cargar la lista de datos para envio mail
	 */
	private static String MAIL = "MAIL";

	/**
	 * Listado de accesos remotos a Elypse.
	 */
	private List<Propriedades> listaConfMail;

	/**
	 * Servicio de propriedades.
	 */

	@Autowired
	private transient PropriedadService propriedadService;

	/**
	 * 
	 */
	private void paramMail() {
		Map<String, String> mapaParametros = new HashMap<>();
		for (Propriedades param : listaConfMail) {
			mapaParametros.put(param.getName(), param.getValue());
		}
		setMapaParametrosMail(mapaParametros);
	}

	/**
	 * Inicialización de datos.
	 */
	@PostConstruct
	public void init() {
		this.listaConfMail = new ArrayList();
		listaConfMail = propriedadService.findByFilename(MAIL);
		paramMail();
	}

}

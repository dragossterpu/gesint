package ro.per.online.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	 * Inicialización de datos.
	 */
	@PostConstruct
	public void init() {

	}

}

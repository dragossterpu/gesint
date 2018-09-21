package ro.mira.peronline;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Configuración del SerlvetInitializer.
 * 
 * @author STAD
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Inidicamos la clase que contiene el método main para que arranque Spring Boot.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PerApplication.class);
	}

}

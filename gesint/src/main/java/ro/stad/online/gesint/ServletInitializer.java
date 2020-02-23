package ro.stad.online.gesint;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Configurarea SerlvetInitializer.
 * 
 * @author STAD
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

        /**
         * Începem clasa care conține metoda principală de pornire Spring Boot.
         * @param application constructor spring
         * @return constructor spring
         */
        @Override
        protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
                return application.sources(GesintApplication.class);
        }

}

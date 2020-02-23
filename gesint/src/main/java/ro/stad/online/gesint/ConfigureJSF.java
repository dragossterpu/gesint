package ro.stad.online.gesint;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.FacesInitializer;

/**
 * Configurare necesară pentru utilizarea JSF împreună cu Spring.
 * 
 * @author STAD
 *
 */
@Configuration
public class ConfigureJSF {

        /**
         * Clasa care moștenește de la org.springframework.boot.web.servlet.ServletRegistrationBean pentru a putea
         * suprascrie metoda onStartup și defini JSF FacesInitializer.
         * @author STAD
         */
        public class JsfServletRegistrationBean extends ServletRegistrationBean {

                /**
                 * Constructor.
                 */
                public JsfServletRegistrationBean() {
                        super();
                }

                /**
                 * Configurare la pornirea Servlet-ului.
                 * @param servletContext context
                 * @throws ServletException exceptie de servlet
                 */
                @Override
                public void onStartup(final ServletContext servletContext) throws ServletException {

                        final FacesInitializer facesInitializer = new FacesInitializer();

                        final Set<Class<?>> clazz = new HashSet<>();
                        clazz.add(ConfigureJSF.class);
                        facesInitializer.onStartup(clazz, servletContext);
                }
        }

        /**
         * Metoda pentrufacesServletRegistration.
         * @return JsfServletRegistrationBean
         */
        @Bean
        public ServletRegistrationBean facesServletRegistration() {
                return new JsfServletRegistrationBean();
        }
}
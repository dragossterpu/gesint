package ro.stad.online.gesint;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.faces.application.ProjectStage;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.primefaces.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sun.faces.config.FacesInitializer;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.jsf.scope.FacesViewScope;

/**
 * Clasa de pornie si configuratie de Spring Boot.
 *
 * @author STAD
 *
 */
@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class GesintApplication {

        /**
         * Implementare care va fi folosită pentru paginile de eroare.
         *
         * @return ErrorPageRegistrar
         */
        @Configuration
        @Profile("dev")
        static class ConfigureJSFContextParameters implements ServletContextInitializer {

                /**
                 * Implementare care va fi folosită pentru configurare in mod dev.
                 */
                @Override
                public void onStartup(final ServletContext servletContext) throws ServletException {
                        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", Constante.XHTML);
                        servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Constante.TRUE);
                        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
                        servletContext.setInitParameter("facelets.DEVELOPMENT", Constante.TRUE);
                        servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
                        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Constante.TRUE);
                        servletContext.setInitParameter(Constants.ContextParams.THEME, "blitzer");
                        servletContext.setInitParameter(Constante.ENCONDING, Constante.UTF8);
                        servletContext.setInitParameter(Constants.ContextParams.FONT_AWESOME, Constante.TRUE);
                        servletContext.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME,
                                        ProjectStage.Development.name());
                        servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES",
                                        "/WEB-INF/springsecurity.taglib.xml");
                }
        }

        /**
         * Implementare care va fi folosită pentru configurare in mod prod.
         */
        @Configuration
        @Profile("prod")
        static class ConfigureJSFContextParametersProd implements ServletContextInitializer {
                /**
                 * Implementare care va fi folosită pentru configurare in mod prod.
                 */
                @Override
                public void onStartup(final ServletContext servletContext) throws ServletException {

                        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", Constante.XHTML);
                        servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Constante.TRUE);
                        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
                        servletContext.setInitParameter("facelets.DEVELOPMENT", "false");
                        servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "-1");
                        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Constante.TRUE);
                        servletContext.setInitParameter(Constants.ContextParams.THEME, "blitzer");
                        servletContext.setInitParameter(Constante.ENCONDING, Constante.UTF8);
                        servletContext.setInitParameter(Constants.ContextParams.FONT_AWESOME, Constante.TRUE);
                        servletContext.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME,
                                        ProjectStage.Development.name());
                        servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES",
                                        "/WEB-INF/springsecurity.taglib.xml");
                }
        }

        /**
         * RegistruPaginaEroare.
         */
        static class RegistruPaginaEroare implements ErrorPageRegistrar {

                /**
                 * registerErrorPages.
                 */
                @Override
                public void registerErrorPages(final ErrorPageRegistry registry) {
                        registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/error/403.xhtml"),
                                        new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.xhtml"),
                                        new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/5xx.xhtml"),
                                        new ErrorPage(HttpStatus.BAD_GATEWAY, "/error/5xx.xhtml"));
                }
        }

        /**
         * @return care simulează view de aplicare a jsf
         */
        @Bean
        public static CustomScopeConfigurer customScopeConfigurer() {
                final CustomScopeConfigurer configurer = new CustomScopeConfigurer();
                configurer.setScopes(
                                Collections.<String, Object> singletonMap(FacesViewScope.NAME, new FacesViewScope()));
                return configurer;
        }

        /**
         * Punctul de intrare al aplicației pentru Spring Boot.
         * @param args parametri de intrare in metoda main
         */
        public static void main(final String[] args) {
                SpringApplication.run(GesintApplication.class, args);
        }

        /**
         * Variabilă folosită pentru a injecta sesiunea.
         */
        @Autowired
        private EntityManagerFactory entityManagerFactory;

        /**
         * Implementare care va fi folosită pentru paginile de eroare.
         *
         * @return ErrorPageRegistrar
         */
        @Bean
        public ErrorPageRegistrar errorPageRegistrar() {
                return new RegistruPaginaEroare();
        }

        /**
         * Creează conexiunea la serverul de email
         *
         * @return Obiectul Sender pentru a efectua operațiuni cu conexiunea
         */
        @Bean
        public JavaMailSenderImpl javaMailSender() {
                return new JavaMailSenderImpl();
        }

        /**
         * @return HibernateJpaSessionFactoryBean.
         */
        @Bean
        public SessionFactory sessionFactory() {
                return entityManagerFactory.unwrap(SessionFactory.class);
        }

        /**
         * @return HibernateEntityManagerFactory.
         */
        @Bean
        public SessionFactory sessionFactory(final HibernateEntityManagerFactory hemf) {
                return hemf.getSessionFactory();
        }

        /**
         * This bean is only needed when running with embedded Tomcat.
         * @return tomcat Conexiune server
         */
        @Bean
        public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
                final TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

                tomcat.addContextCustomizers(context -> {
                        // register FacesInitializer
                        context.addServletContainerInitializer(new FacesInitializer(),
                                        getServletContainerInitializerHandlesTypes(FacesInitializer.class));
                        context.addWelcomeFile("index.xhtml");
                        context.addMimeMapping("eot", "application/vnd.ms-fontobject");
                        context.addMimeMapping("ttf", "application/x-font-ttf");
                        context.addMimeMapping("woff", "application/x-font-woff");
                        context.addMimeMapping("woff2", "application/fontawesome-webfont.woff2");
                });

                return tomcat;
        }

        /**
         * Inițializează containerul getServletContainerInitializerHandlesTypes.
         * @param sciClass ServletContainerInitializer
         * @return classesSet
         */
        @SuppressWarnings(Constante.RAWTYPES)
        private Set<Class<?>> getServletContainerInitializerHandlesTypes(
                        final Class<? extends ServletContainerInitializer> sciClass) {
                Set<Class<?>> coleccion;

                final HandlesTypes annotation = sciClass.getAnnotation(HandlesTypes.class);
                if (annotation == null) {
                        coleccion = Collections.emptySet();
                }
                else {
                        final Class[] classesArray = annotation.value();
                        final Set<Class<?>> classesSet = new HashSet<>(classesArray.length);
                        for (final Class clazz : classesArray) {
                                classesSet.add(clazz);
                        }
                        coleccion = classesSet;
                }

                return coleccion;
        }
}
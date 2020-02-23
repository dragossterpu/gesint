package ro.stad.online.gesint.configuration.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ro.stad.online.gesint.constante.Constante;

/**
 * Configurarea rezoluției rutelor în raport cu pagina de conectare.
 * @author STAD
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

        /**
         * Activați servletul implicit.
         */
        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                configurer.enable();
        }

        /**
         * Setați /index.html ca pagina implicită.
         */
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("redirect:/index.xhtml");
                registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
                super.addViewControllers(registry);
        }

        /**
         * Setarea rezolvării căii pe vizualizarea /access/login.xhtml atunci când utilizați acțiuni / autentificare.
         * @return resolver
         */
        @Bean
        public InternalResourceViewResolver viewResolver() {
                final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
                resolver.setPrefix("/acces/");
                resolver.setSuffix(Constante.XHTML);
                resolver.setOrder(1);
                return resolver;
        }

}

package ro.stad.online.gesint.configuration.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import ro.stad.online.gesint.model.auditor.UsernameSecurityAuditorAwareImpl;

/**
 * Clasa pentru a permite auditul entităților și pentru a defini ce implementare va fi utilizată pentru aceasta.
 * 
 * @author STAD
 *
 */
@Configuration
@EnableJpaAuditing
public class AuditableJpaConfig {

        /**
         * Definiția implementării care urmează să fie utilizată în auditul JPA.
         * 
         * @return furnizor de audit
         */
        @Bean
        public AuditorAware<String> auditorProvider() {
                return new UsernameSecurityAuditorAwareImpl();
        }
}

package ro.stad.online.gesint.model.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Implementarea interfeței Spring AuditorAware pentru a efectua auditul de login.
 * 
 * @author STAD
 *
 */
public class UsernameSecurityAuditorAwareImpl implements AuditorAware<String> {

        /**
         * Metodă care returnează numele utilizatorului care s-a autentificat cu succes.
         */
        @Override
        public String getCurrentAuditor() {
                final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                String nume = null;
                if (authentication != null && authentication.isAuthenticated()) {
                        nume = authentication.getName();
                }
                return nume;
        }
}

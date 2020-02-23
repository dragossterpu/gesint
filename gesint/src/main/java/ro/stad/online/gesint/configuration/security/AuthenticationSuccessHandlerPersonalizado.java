package ro.stad.online.gesint.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clasa care gestionează accesul cu succes la aplicație. Conectați-vă accesul pentru auditare și redirecționați la
 * cerere Index.
 *
 * @author STAD
 *
 */
@Component
public class AuthenticationSuccessHandlerPersonalizado implements AuthenticationSuccessHandler {

        /**
         * Auditul autentificărilor de succes.
         */
        @Override
        @Transactional
        public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                        final Authentication autentication) throws IOException, ServletException {
                response.setStatus(HttpServletResponse.SC_OK);
                response.sendRedirect("./index.xhtml");
        }
}

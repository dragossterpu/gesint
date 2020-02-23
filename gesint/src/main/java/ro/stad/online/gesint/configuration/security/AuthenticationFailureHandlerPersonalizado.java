package ro.stad.online.gesint.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import ro.stad.online.gesint.constante.Constante;

/**
 * Administrator de erori de autentificare la conectare.
 *
 * @author STAD
 *
 */
@Component
public class AuthenticationFailureHandlerPersonalizado extends SimpleUrlAuthenticationFailureHandler {

        /**
         * Controlează funcționarea sistemului atunci când apare o eroare la logare.
         *
         */
        @Override
        public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
                        final AuthenticationException exception) throws IOException, ServletException {

                final StringBuilder textoReg = new StringBuilder(
                                "S-a produs o încercare de conectare nereușită în sistem.");
                textoReg.append("Eroare detectată: ");
                if (exception.getMessage().contains("locked")) {
                        textoReg.append("Contul a fost blocat");
                }
                else if (exception.getMessage().contains("Bad credentials")) {
                        textoReg.append("Nume de utilizator sau parolă incorecte");
                }
                else if (exception.getMessage().contains("Maximum sessions")) {
                        textoReg.append("Există deja o sesiune deschisă pentru acest utilizator");
                }

                saveException(request, exception);
                getRedirectStrategy().sendRedirect(request, response, Constante.LOGINROUTE);

        }

}

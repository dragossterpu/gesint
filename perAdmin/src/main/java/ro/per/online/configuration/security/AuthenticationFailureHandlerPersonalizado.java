package ro.per.online.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Manejador de errores de autenticación en el login.
 * 
 * @author EZENTIS
 *
 */
@Component
public class AuthenticationFailureHandlerPersonalizado extends SimpleUrlAuthenticationFailureHandler {

	/**
	 * Controla el funcionamiento del sistema cuando se produce un error al hacer login.
	 * 
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		StringBuilder textoReg = new StringBuilder("Se ha producido un intento de login fallido en el sistema\n\n");
		textoReg.append("Error detectado: ");
		if (exception.getMessage().contains("locked")) {
			textoReg.append("Cuenta bloqueada");
		}
		else if (exception.getMessage().contains("Bad credentials")) {
			textoReg.append("Usuario o contraseña incorrectos");
		}
		else if (exception.getMessage().contains("Maximum sessions")) {
			textoReg.append("Ya existe una sesión abierta para este usuario");
		}

		saveException(request, exception);
		getRedirectStrategy().sendRedirect(request, response, "/login");

	}

}

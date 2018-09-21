package ro.per.online.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Clase que gestiona los accesos exitosos a la aplicación. Registra en acceso para auditoría y redirige a la vista
 * Index.
 * 
 * @author STAD
 *
 */
@Component
public class AuthenticationSuccessHandlerPersonalizado implements AuthenticationSuccessHandler {

	/**
	 * Auditoría de inicios de sesión satisfactorios.
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication autentication) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect("./index.xhtml");
	}
}

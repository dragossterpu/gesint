package ro.stad.online.gesint.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;

/**
 * Gestionează cererile HTTP legate de începutul și sfârșitul sesiunilor din sistem.
 *
 * @author STAD
 */
@Getter
@Setter
@Controller
public class LoginController {

        /**
         * Interceptează cererile către calea de conectare „/ login” și răspunde diferit dacă este o solicitare normală
         * sau AJAX (utilă dacă sesiunea curentă expiră).
         *
         * @param request Cerere http client
         * @param response Răspuns server http
         * @return Acțiune de autentificare mapată pe dispecerat în caz de solicitare normală, forță de redirecție în
         * cazul solicitării AJAX în cadrul unei vizualizări
         * @throws IOException în caz de EROARE în servlet
         */
        @RequestMapping(method = RequestMethod.GET, value = "/login")
        public String login(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
                String respuns = null;
                if ("partial/ajax".equals(request.getHeader("Faces-Request"))) {
                        // JSF ajax request. Return special XML response which instructs JavaScript that it should in
                        // turn perform a
                        // redirect.
                        response.setContentType("text/xml");
                        response.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").printf(
                                        "<partial-response><redirect url=\"%s\"></redirect></partial-response>",
                                        Constante.LOGIN);
                }
                else {
                        // Normal request. Perform redirect as usual.
                        respuns = Constante.LOGIN;
                }
                return respuns;
        }

        /**
         * Request Mapping de logout.
         * @return @RequestMapping
         */
        @RequestMapping(method = RequestMethod.GET, value = "/logout")
        public String logout() {
                return "logout";
        }
}

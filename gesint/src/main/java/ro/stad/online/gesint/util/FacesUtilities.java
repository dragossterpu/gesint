package ro.stad.online.gesint.util;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import ro.stad.online.gesint.constante.Constante;

/**
 * Clasa pentru instrumente de FacesUtilities.
 * @author STAD
 */
@Component("facesUtilities")
public class FacesUtilities {

        /**
         * Setați un mesaj de confirmare.
         * @param severity Severity
         * @param summary String
         * @param detail String
         */
        public static void setMesajConfirmareDialog(final Severity severity, final String summary,
                        final String detail) {
                final RequestContext context = RequestContext.getCurrentInstance();
                final FacesMessage message = new FacesMessage(severity, summary, detail);
                FacesContext.getCurrentInstance().addMessage("dialogMessage", message);
                context.execute("PF('dialogMessage').show()");
        }

        /**
         * Setați un mesaj informativ.
         *
         * @param severity Severity
         * @param summary String
         * @param detail String
         * @param idMesaj String
         */
        public static void setMensajeInformativo(final Severity severity, final String summary, final String detail,
                        final String idMesaj) {
                final FacesMessage message = new FacesMessage(severity, summary, detail);
                FacesContext.getCurrentInstance().addMessage(idMesaj, message);
        }

        /**
         * Redirecționați către o altă pagină.
         * @param pagina String
         */
        public void redirect(final String pagina) {
                final FacesContext ctx = FacesContext.getCurrentInstance();
                final ExternalContext extContext = ctx.getExternalContext();

                final String url = extContext
                                .encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, pagina));

                try {
                        extContext.redirect(url);
                }
                catch (final IOException ioe) {
                        throw new FacesException(ioe);
                }
        }

        /**
         * Afișează un mesaj de eroare pe ecran preluând textul excepției.
         * @param exception Exceptie recuperata
         * @param idMesaj Identificator de componente „mesaj / mesaje” PrimeFaces unde doriți să afișați
         */
        public void setmesajEroare(final Exception exception, final String idMesaj) {
                setMensajeInformativo(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ, exception.getMessage(),
                                idMesaj);
        }

        /**
         * Afișează un mesaj de eroare in pagina preluând textul excepției.
         * @param mesajEroare mesaj pe care vrem să-l afișăm
         * @param idMesaj Identificator de componente „mesaj / mesaje” PrimeFaces unde doriți să afișați
         */
        public void setmesajEroare(final String mesajEroare, final String idMesaj) {
                setMensajeInformativo(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ, mesajEroare, idMesaj);
        }
}

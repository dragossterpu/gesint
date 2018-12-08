package ro.per.online.util;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import ro.per.online.constantes.Constantes;

/**
 * Clase para herramientas de FacesUtilities.
 * @author STAD
 */
@Component("facesUtilities")
public class FacesUtilities {

	/**
	 * Establece un mensaje de confirmación.
	 * @param severity Severity
	 * @param summary String
	 * @param detail String
	 */
	public static void setMensajeConfirmacionDialog(final Severity severity, final String summary,
			final String detail) {
		final RequestContext context = RequestContext.getCurrentInstance();
		final FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage("dialogMessage", message);
		context.execute("PF('dialogMessage').show()");
	}

	/**
	 * Se muestra mensaje informativo.
	 *
	 * @param severity Severity
	 * @param summary String
	 * @param detail String
	 * @param idMensaje String
	 */
	public static void setMensajeInformativo(final Severity severity, final String summary, final String detail,
			final String idMensaje) {
		final FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(idMensaje, message);
	}

	/**
	 * Redirecciona a otra página.
	 * @param pagina String
	 */
	public void redirect(final String pagina) {
		final FacesContext ctx = FacesContext.getCurrentInstance();
		final ExternalContext extContext = ctx.getExternalContext();

		final String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, pagina));

		try {
			extContext.redirect(url);
		}
		catch (final IOException ioe) {
			throw new FacesException(ioe);
		}
	}

	/**
	 * Muestra un mensaje de error por pantalla recuperando el texto de la excepción.
	 * @param exception Excepción recuperada
	 * @param idMensaje identificador del componente "message/s" de PrimeFaces donde se desea mostrar
	 */
	public void setMensajeError(final Exception exception, final String idMensaje) {
		setMensajeInformativo(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE, exception.getMessage(), idMensaje);
	}

	/**
	 * Muestra un mensaje de error por pantalla recuperando el texto de la excepción.
	 * @param mensajeError mensaje que queremos mostrar
	 * @param idMensaje identificador del componente "message/s" de PrimeFaces donde se desea mostrar
	 */
	public void setMensajeError(final String mensajeError, final String idMensaje) {
		setMensajeInformativo(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE, mensajeError, idMensaje);
	}
}

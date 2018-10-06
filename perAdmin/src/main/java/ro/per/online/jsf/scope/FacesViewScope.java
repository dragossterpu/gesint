package ro.per.online.jsf.scope;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import ro.per.online.util.FacesUtilities;

/**
 *
 * Permite simular el scope View en Spring.
 *
 * @author STAD
 *
 */
public class FacesViewScope implements Scope {
	/**
	 * Nombre del scope.
	 */
	public static final String NAME = "view";

	/**
	 * Metodo que obtiene un Object.
	 * @param name String
	 * @param objectFactory ObjectFactory<?>
	 * @return Object
	 */
	@Override
	public Object get(final String name, final ObjectFactory<?> objectFactory) {
		final Object objeto;

		final FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext == null) {
			throw new IllegalStateException("FacesContext.getCurrentInstance() returned null");
		}

		final Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

		if (viewMap.containsKey(name)) {
			objeto = viewMap.get(name);
		}
		else {
			final Object object = objectFactory.getObject();
			viewMap.put(name, object);

			objeto = object;
		}

		return objeto;
	}

	/**
	 * Metodo que obtiene un id.
	 * @return String
	 */
	@Override
	public String getConversationId() {
		return null;
	}

	/**
	 * Método que registra una destrucción callback.
	 * @param name String
	 * @param callback Runnable
	 */
	@Override
	public void registerDestructionCallback(final String name, final Runnable callback) {
		FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_WARN, "OK", "OK");
	}

	/**
	 * Metodo que elimina.
	 * @param name String
	 * @return Object
	 */
	@Override
	public Object remove(final String name) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
	}

	/**
	 * Metodo que resolve.
	 * @param key String
	 * @return Object
	 */
	@Override
	public Object resolveContextualObject(final String key) {
		return null;
	}
}

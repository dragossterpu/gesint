package ro.stad.online.gesint.jsf.scope;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import ro.stad.online.gesint.constante.Constante;

/**
 *
 * Permite simularea vizualizarii in FacesViewScope.
 *
 * @author STAD
 *
 */
public class FacesViewScope implements Scope {

        /**
         * Numele FacesViewScope.
         */
        public static final String NAME = Constante.VIEW;

        /**
         * Obține obiectul sesiunii.
         * @param name nume
         * @param objectFactory obiect de factorie de factoría
         * @return Object respuns
         */
        @Override
        public Object get(final String name, final ObjectFactory<?> objectFactory) {
                final FacesContext facesContext = FacesContext.getCurrentInstance();
                if (facesContext == null) {
                        throw new IllegalStateException("FacesContext.getCurrentInstance() returned null");
                }

                final Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

                Object respuns;
                if (viewMap.containsKey(name)) {
                        respuns = viewMap.get(name);
                }
                else {
                        final Object object = objectFactory.getObject();
                        viewMap.put(name, object);

                        respuns = object;
                }
                return respuns;
        }

        /**
         * Obține id-ul conversatiei.
         * @return id id-ul conversatiei
         */
        @Override
        public String getConversationId() {
                return null;
        }

        /**
         * Eliminare jurnal.
         * @param name nume
         * @param callback callback
         */
        @Override
        public void registerDestructionCallback(final String name, final Runnable callback) {
        }

        /**
         * Elimina obiectul de sesiune.
         * @param name num
         * @return Object obiectul eliminat
         */
        @Override
        public Object remove(final String name) {
                return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
        }

        /**
         * Rezolva obiectul contextual.
         * @param key cheie
         * @return Object obiect
         */
        @Override
        public Object resolveContextualObject(final String key) {
                return null;
        }
}

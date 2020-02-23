package ro.stad.online.gesint.converters;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import ro.stad.online.gesint.constante.Constante;

/**
 * Component care permite generarea drop-down în formulare html unde opțiunile sunt asociate obiectelor.
 * 
 * @author STAD
 */
@Component("selectConverter")
public class SelectItemsConvertor implements Converter {

        /**
         * entityManagerFactory.
         */
        @PersistenceContext
        private EntityManager entityManagerFactory;

        /**
         * Având în vedere obiectul entității, acesta returnează valoarea primei sale chei din șirul de text.
         * @param context FacesContext
         * @param component UIComponent
         * @param entity Object
         * @return String value
         * 
         */
        @Override
        public String getAsString(final FacesContext context, final UIComponent component, final Object entity) {
                String value = null;
                if (entity != null && Constante.SPATIU.equals(entity) == Boolean.FALSE) {
                        Object id = entityManagerFactory.getEntityManagerFactory().getPersistenceUnitUtil()
                                        .getIdentifier(entity);
                        value = id.toString();
                }
                return value;
        }

        /**
         * Returnează obiectul care corespunde ID-ului entității primite ca parametru în valoarea trimisă din combo.
         * @param context FacesContext
         * @param component UIComponent
         * @param submitedValue String
         * @return Object entity
         */
        @Override
        public Object getAsObject(final FacesContext context, final UIComponent component, final String submitedValue) {
                Object entity = null;
                List<UIComponent> childrenList = component.getChildren();
                Iterator<UIComponent> iteratorChildren = childrenList.iterator();
                boolean encontrado = false;
                UIComponent child;
                Object item = null;
                while (iteratorChildren.hasNext() && !encontrado) {
                        child = iteratorChildren.next();
                        if (child instanceof UISelectItems) {
                                UISelectItems uiSelectItems = (UISelectItems) child;
                                @SuppressWarnings(Constante.UNCHECKED)
                                List<SelectItem> listaItems = (List<SelectItem>) uiSelectItems.getValue();
                                if (listaItems != null) {
                                        Iterator<SelectItem> iteratorItems = listaItems.iterator();
                                        while (iteratorItems.hasNext() && !encontrado) {
                                                item = iteratorItems.next();
                                                encontrado = submitedValue.equals(item.toString());
                                        }
                                }
                        }
                }
                if (encontrado) {
                        entity = item;
                }
                return entity;
        }

}

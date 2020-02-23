package ro.stad.online.gesint.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

/**
 * Clasa pentru a evita spațiile necompletate în formularele de înscriere.
 * @author STAD
 *
 */
@Component("trimConverter")
public class TrimConvertor implements Converter {

        /**
         * Metoda care elimina spațiile înainte și după un text.
         * @param context FacesContext
         * @param component UIComponent
         * @param submitedValue String
         * @return Object trimmed
         */
        @Override
        public Object getAsObject(final FacesContext context, final UIComponent component,
                        final String submittedValue) {
                String trimmed = null;
                if (submittedValue != null) {
                        trimmed = submittedValue.trim();
                        if (trimmed.isEmpty()) {
                                trimmed = null;
                        }
                }
                return trimmed;
        }

        /**
         * Metoda care recupereaza textul
         * @param context FacesContext
         * @param component UIComponent
         * @param modelValue Object
         * @return text String
         */
        @Override
        public String getAsString(final FacesContext context, final UIComponent component, final Object modelValue) {
                String text = null;
                if (modelValue != null)
                        text = modelValue.toString();
                return text;
        }

}
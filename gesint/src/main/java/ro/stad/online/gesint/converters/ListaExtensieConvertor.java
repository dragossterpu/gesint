package ro.stad.online.gesint.converters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

import ro.stad.online.gesint.constante.Constante;

/**
 * @author STAD
 */
@Component("listaExtensieConvertor")
public class ListaExtensieConvertor implements Converter {

        /**
         * Delimitator de șiruri de text care conține o listă.
         */
        private static final String SEPARATOR = ", ";

        /**
         * Transforma una cadena de texto en lista de elementos.
         */
        @Override
        public Object getAsObject(final FacesContext context, final UIComponent component,
                        final String submittedValue) {
                Object respuesta = null;
                if (submittedValue != null) {
                        respuesta = new ArrayList<>(Arrays.asList(submittedValue.split(SEPARATOR)));
                }
                return respuesta;
        }

        /**
         * Transformă o listă de elemente într-un șir de text.
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public String getAsString(final FacesContext context, final UIComponent component, final Object modelValue) {
                String raspuns = null;
                if (modelValue != null) {
                        raspuns = String.join(SEPARATOR, (List<String>) modelValue);
                }
                return raspuns;
        }

}
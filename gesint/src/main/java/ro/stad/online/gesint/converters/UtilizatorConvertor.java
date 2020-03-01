package ro.stad.online.gesint.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.primefaces.component.orderlist.OrderList;
import org.springframework.stereotype.Component;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.persistence.entities.Echipa;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 * Clasă pentru cartografierea membrilor echipei.
 * @author STAD
 *
 */
@Component("userConverter")
public class UtilizatorConvertor implements Converter {

        /**
         * Metoda care obtine un obiect.
         * @param context FacesContext
         * @param component UIComponent
         * @param value String
         * @return Object trimmed
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
                Object echipa = new Echipa();
                final Object list = ((OrderList) component).getValue();

                final List<Utilizator> listaEchipa = (ArrayList<Utilizator>) list;

                boolean oprire = false;

                for (int i = 0; i < listaEchipa.size() && !oprire; i++) {
                        if (listaEchipa.get(i).getUsername().equals(value)) {
                                echipa = listaEchipa.get(i);
                                oprire = true;
                        }
                }
                return echipa;
        }

        /**
         * Metoda care obtine un string.
         * @param context FacesContext
         * @param component UIComponent
         * @param Object value
         * @return idEchipa String
         */
        @Override
        public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
                String idEchipa = null;
                final Utilizator user = (Utilizator) value;

                if (user != null && user.getUsername() != null) {
                        idEchipa = user.getUsername();
                }

                return idEchipa;
        }

}
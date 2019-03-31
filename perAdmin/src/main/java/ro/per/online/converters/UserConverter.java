package ro.per.online.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.primefaces.component.orderlist.OrderList;
import org.springframework.stereotype.Component;

import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Team;
import ro.per.online.persistence.entities.Users;

/**
 * Clasă pentru cartografierea membrilor echipei.
 * @author STAD
 *
 */
@Component("userConverter")
public class UserConverter implements Converter {

	/**
	 * Metoda care obtine un obiect.
	 */
	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		Object team = new Team();
		final Object list = ((OrderList) component).getValue();

		final List<Users> listaTeams = (ArrayList<Users>) list;

		boolean parada = false;

		for (int i = 0; i < listaTeams.size() && !parada; i++) {
			if (listaTeams.get(i).getUsername().toString().equals(value)) {
				team = listaTeams.get(i);
				parada = true;
			}
		}

		return team;
	}

	/**
	 * Metoda care obtine un string.
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		String idTeam = null;
		final Users user = (Users) value;

		if (user != null && user.getUsername() != null) {
			idTeam = user.getUsername().toString();
		}

		return idTeam;
	}

}
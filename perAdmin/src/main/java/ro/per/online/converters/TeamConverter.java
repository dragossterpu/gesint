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

/**
 * Clasă pentru cartografierea membrilor echipei.
 * @author STAD
 *
 */
@Component("teamConverter")
public class TeamConverter implements Converter {

	/**
	 * Metoda care obtine un obiect.
	 */
	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		Object team = new Team();
		final Object list = ((OrderList) component).getValue();

		final List<Team> listaTeams = (ArrayList<Team>) list;

		boolean parada = false;

		for (int i = 0; i < listaTeams.size() && !parada; i++) {
			if (listaTeams.get(i).getId().toString().equals(value)) {
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
		final Team team = (Team) value;

		if (team != null && team.getId() != null) {
			idTeam = team.getId().toString();
		}

		return idTeam;
	}

}
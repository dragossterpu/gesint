package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.Team;
import ro.per.online.services.TeamService;

/**
 * Clase utilizada para cargar datos en la pagina de echipa PER.
 * 
 * @author STAD
 *
 */
@Component("teamBean")
@Setter
@Getter
@NoArgsConstructor
public class TeamBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Variala utilizata pentru recuperarea listei echipei de conducere.
	 * 
	 */
	private List<Team> listaTeam;

	/**
	 * Variala utilizata pentruinjectarea serviciului de team.
	 * 
	 */
	@Autowired
	private transient TeamService teamService;

	/**
	 * Inicialización de datos.
	 */
	@PostConstruct
	public void init() {
		this.listaTeam = new ArrayList<>();
		this.listaTeam = teamService.fiindByTeam();
	}

}

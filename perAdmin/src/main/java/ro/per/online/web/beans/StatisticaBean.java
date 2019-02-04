package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Mapa;
import ro.per.online.services.MapaService;
import ro.per.online.util.FacesUtilities;

/**
 * Clase utilizada pentru a incarca statistica
 *
 * @author STAD
 *
 */
@Component("statisticaBean")
@Setter
@Getter
@NoArgsConstructor
@Scope(Constantes.SESSION)
public class StatisticaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Variala utilizata pentru injectarea serviciului de mapa.
	 *
	 */
	@Autowired
	private transient MapaService mapaService;

	/**
	 * Variabila pentru mapa.
	 */
	private transient Mapa selectedMap;

	/**
	 * Lista registrelor din mapa.
	 */
	private List<Mapa> listaMapa;

	private String mapCode;

	/**
	 * Inițializarea datelor.
	 */
	@PostConstruct
	public void init() {
		this.selectedMap = new Mapa();
		this.listaMapa = new ArrayList<>();
		cautareMapas();
	}

	/**
	 *
	 *
	 */
	private void cautareMapas() {
		listaMapa = mapaService.fiindAll();
		System.out.println(listaMapa.size());
	}

	/**
	 * Limpia la lista de solicitudes y la solicitud.
	 */
	public void detalleMapa(Mapa mapa) {
		FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
				"EIntram un detalle mapa.");
		RequestContext context = RequestContext.getCurrentInstance();
		System.out.println("suntem aici");
	}

	/**
	 * Evento para el control de cambio de pestaña de grupo de datos(Membrii noi, Organizatia sau Rezultate).
	 * @param event TabChangeEvent
	 */
	public void cambioTipStatistica(final TabChangeEvent event) {
		FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
				"Evento para el control de cambio de pestaña de grupo de datos.");

	}
}

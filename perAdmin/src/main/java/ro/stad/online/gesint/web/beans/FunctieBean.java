package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.constantes.NumeroMagic;
import ro.per.online.persistence.entities.PTeam;
import ro.per.online.services.FunctieService;
import ro.per.online.services.TeamService;
import ro.per.online.services.impl.RegistroActividadServiceImpl;
import ro.per.online.util.FacesUtilities;

/**
 * Controlorul operațiunilor legate de gestionarea functiilor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("functieBean")
@Scope(Constantes.SESSION)
public class FunctiiBean implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = NumeroMagic.NUMBERONELONG;

	/**
	 * Alerta noua.
	 */
	private transient PTeam functie;

	/**
	 * Variala utilizata pentru injectarea serviciului de functii.
	 */
	@Autowired
	private transient FunctieService functieService;

	/**
	 * Variala utilizata pentru injectarea serviciului de utilizatori.
	 */
	@Autowired
	private transient TeamService teamService;

	/**
	 * Listă de functii.
	 */
	private List<PTeam> listaFunctii;

	/**
	 * Variala utilizata pentru injectarea serviciului înregistrare a activității.
	 */
	@Autowired
	private transient RegistroActividadServiceImpl registroActividadService;

	/**
	 * Alta un nuevo cuerpo del estado.
	 *
	 * @param nombreCorto del cuerpo
	 * @param descripcionCuerpo del cuerpo
	 */

	public void altaFunctie(final String numeFunctie, final String descriereFunctie, final String organization) {
		try {
			functie = new PTeam();
			SecurityContextHolder.getContext().getAuthentication().getName();
			functie.setDescription(descriereFunctie);
			functie.setOrganization(organization);
			functie.setName(numeFunctie);
			functieService.save(functie);
			listaFunctii.add(functie);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ALTA,
					"Noua funcție a fost înregistrată cu succes");
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la înregistrarea registrului. ".concat(Constantes.DESCERRORMENSAJE));
		}
	}

	/**
	 * Eliminarea totala a functiei.
	 * @param functia care se elimina
	 */
	public void eliminaFunctia(final PTeam functia) {
		try {
			final int tieneUsuarios = teamService.existsByTeam(functia.getId());
			if (tieneUsuarios > 0) {
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
						"Nu se poate elimina funcția '" + functia.getName() + "' deoarece sunt persoane care o dețin.",
						"", null);
			}
			else {
				functieService.delete(functia);
				listaFunctii.remove(functia);
				FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constantes.ELIMINAREMENSAJE,
						functia.getDescription(), Constantes.OKELIMINMENSAJE);
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Metodă folosită pentru a inițializa lista functilor care vor fi afișate pe pagină.
	 */
	@PostConstruct
	public void init() {
		listaFunctii = functieService.fiindAll();
	}

	/**
	 * Modificare de o functie
	 * @param event eventcare se recupereaza de la vista
	 */
	public void onRowEdit(final RowEditEvent event) {
		final PTeam functia = (PTeam) event.getObject();
		try {
			functieService.save(functia);
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constantes.MODIFICAREMENSAJE,
					functia.getDescription(), null);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}

	}

}

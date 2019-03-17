package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.Date;
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
import ro.per.online.persistence.entities.Partid;
import ro.per.online.services.PartidService;
import ro.per.online.services.impl.RegistroActividadServiceImpl;
import ro.per.online.util.FacesUtilities;

/**
 * Controlorul operațiunilor legate de gestionarea partidelor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("partidBean")
@Scope(Constantes.SESSION)
public class PartidiBean implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = NumeroMagic.NUMBERONELONG;

	/**
	 * Alerta noua.
	 */
	private transient Partid partid;

	/**
	 * Variala utilizata pentru injectarea serviciului de partid.
	 */
	@Autowired
	private transient PartidService partidService;

	/**
	 * Listă de Partide.
	 */
	private List<Partid> listaPartide;

	/**
	 * Variala utilizata pentru injectarea serviciului înregistrare a activității.
	 */
	@Autowired
	private transient RegistroActividadServiceImpl registroActividadService;

	/**
	 * Nou partid.
	 *
	 * @param nombreCorto del cuerpo
	 * @param descripcionCuerpo del cuerpo
	 */

	public void altaPartid(final String numePartid, final String sigla, final String oldName) {
		try {
			partid = new Partid();
			SecurityContextHolder.getContext().getAuthentication().getName();
			partid.setName(numePartid);
			partid.setSigla(sigla);
			partid.setOldName(oldName);
			partidService.save(partid);
			listaPartide.add(partid);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ALTA,
					"Noul partid a fost înregistrat cu succes");
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la înregistrarea registrului. ".concat(Constantes.DESCERRORMENSAJE));
		}
	}

	/**
	 * Eliminarea totala a partidului.
	 * @param partid care se elimina
	 */
	public void eliminaPartid(final Partid partid) {
		try {
			partid.setDateDeleted(new Date());
			partidService.delete(partid);
			listaPartide.remove(partid);
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constantes.ELIMINAREMENSAJE,
					partid.getName(), Constantes.OKELIMINMENSAJE);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Metodă folosită pentru a inițializa lista partidelor care vor fi afișate pe pagină.
	 */
	@PostConstruct
	public void init() {
		listaPartide = partidService.fiindAll();
	}

	/**
	 * Modificare de o functie
	 * @param event eventcare se recupereaza de la vista
	 */
	public void onRowEdit(final RowEditEvent event) {
		final Partid partid = (Partid) event.getObject();
		try {
			partidService.save(partid);
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constantes.MODIFICAREMENSAJE,
					partid.getName(), null);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}

	}

}

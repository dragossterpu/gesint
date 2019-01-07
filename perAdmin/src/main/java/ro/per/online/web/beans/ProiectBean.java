package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.constantes.NumeroMagic;
import ro.per.online.lazydata.LazyDataProiect;
import ro.per.online.persistence.entities.Proiecte;
import ro.per.online.services.ProiectService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;

/**
 * Clase utilizada pentru a incarca proiectele PER.
 *
 * @author STAD
 *
 */
@Component("proiectBean")
@Setter
@Getter
@NoArgsConstructor
@Scope(Constantes.SESSION)
public class ProiectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Lista de elemente vizibile.
	 */
	private List<Boolean> list;

	/**
	 * Variala utilizata pentruinjectarea serviciului de proiecte.
	 *
	 */
	@Autowired
	private transient ProiectService proiectService;

	/**
	 * Lazy model para los proyectos
	 */
	private transient LazyDataProiect modelProiect;

	/**
	 * Variabila pentru proiecte.
	 */
	private transient Proiecte proiect;

	/**
	 * Clase de búsqueda de proyectos.
	 */
	private ProiectBusqueda proiectBusqueda;

	/**
	 * Lista numelor din echipa de conducere.
	 */
	private List<Proiecte> listaProiecte;

	/**
	 * Lista pozitiilor proiectelor.
	 */
	private List<Proiecte> listaPozitie;

	/**
	 * Fotoografia.
	 */
	private byte[] photoSelected;

	/**
	 * Nombre del documento.
	 */
	private String nombreDoc;

	/**
	 * Mensaje de error que se muestra al usuario.
	 */
	private transient String mensajeError;

	/**
	 * Deschide dialogul pentru pozitionarea membrilor.
	 */
	public void abrirDialogoOrdenaProiecte() {
		listaProiecte = proiectService.findAll();
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgOrdena').show();");
	}

	/**
	 * Căută proiecte pe baza unui filtru.
	 */
	@Transactional
	public void buscarProiecte() {
		modelProiect.setProiectBusqueda(proiectBusqueda);
		modelProiect.load(0, NumeroMagic.NUMBERFIFTEEN, Constantes.FECHACREACION, SortOrder.DESCENDING, null);
	}

	/**
	 * Eliminarea unui proiect.
	 * @param proiect Proiecte proiect candidat pentru eliminare
	 */
	public void eliminarProiect(final Proiecte proiect) {
		try {
			proiectService.delete(proiect);
			listaProiecte.remove(proiect);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ELIMINAREMENSAJE,
					Constantes.OKELIMINMENSAJE);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la eliminarea proiectului.".concat(Constantes.DESCERRORMENSAJE));
		}

	}

	/**
	 * Transmite datele proiectului pe care dorim să le modificăm în formular, astfel încât acestea să schimbe valorile
	 * pe care le doresc.
	 * @return URL-ul paginii de modificare a proiectului
	 */
	public String getFormModificarProiect(final Proiecte pr) {
		this.proiect = pr;
		this.photoSelected = null;
		return "/proiecte/modifyProiect?faces-redirect=true";
	}

	/**
	 * Inițializarea datelor.
	 */
	@PostConstruct
	public void init() {
		this.proiectBusqueda = new ProiectBusqueda();
		this.proiect = new Proiecte();
		this.listaProiecte = new ArrayList<>();
		this.list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			this.list.add(Boolean.TRUE);
		}
		limpiarBusqueda();
//		Utilities.limpiarSesion("proiectBean");
	}

	/**
	 * Curăță căutarea proiectelor
	 */
	public void limpiarBusqueda() {
		proiectBusqueda = new ProiectBusqueda();
		modelProiect = new LazyDataProiect(proiectService);
		modelProiect.setRowCount(0);
	}

	/**
	 * Înregistrează proiectul indicat.
	 */
	public void modificaProiect(final Proiecte proie) {
		this.proiect = new Proiecte();
		try {
			this.proiect = proie;
			;
			proiectService.save(proiect);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.MODIFICAREMENSAJE,
					Constantes.OKMODMENSAJE);
			final RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgModifica').hide();");

		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la modificarea proiectului. ".concat(Constantes.DESCERRORMENSAJE));
		}

	}

	/**
	 * Reordeneaza proiectul
	 *
	 *
	 */
	public void onReorder() {
		try {
			reordenarProiecte();
			final FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la salvarea reordenării. ".concat(Constantes.DESCERRORMENSAJE));
		}
	}

	/**
	 * Modificarea descrierii unui membru al equipei.
	 * @param event eveniment care capturează team de editat
	 */
	public void onRowEdit(final RowEditEvent event) {

		try {
			final Proiecte proiect = (Proiecte) event.getObject();
			proiectService.save(proiect);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.MODIFICAREMENSAJE,
					proiect.getTitlu());
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare în încercarea de a modifica proiectul. ".concat(Constantes.DESCERRORMENSAJE));
		}
	}

	/**
	 * Metoda care se execută la selectare.
	 * @param event SelectEvent
	 */
	public void onSelect(final SelectEvent event) {
		this.proiect = (Proiecte) event.getObject();
	}

	/**
	 * Controlează coloanele vizibile în lista rezultatelor motorului de căutare.
	 * @param eve ToggleEvent
	 */

	public void onToggle(final ToggleEvent eve) {
		this.list.set((Integer) eve.getData(), eve.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 * Acces pentru a inregistra un nou proiect.
	 * @return String
	 */
	public String proiectNou() {
		proiect = new Proiecte();
		return "/proiecte/altaProiect?faces-redirect=true";
	}

	/**
	 * Funcție care reorientează pozitia
	 * @throws DataAccessException excepție de acces la date
	 */
	private void reordenarProiecte() {
		try {
			Proiecte proiect;
			for (int i = 0; i < this.listaProiecte.size(); i++) {
				proiect = this.listaProiecte.get(i);

				proiect.setRank(i + 1L);
				this.proiectService.save(proiect);
				final RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dlgOrdena').hide();");
			}
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la salvarea modificărilor. ".concat(Constantes.DESCERRORMENSAJE));
		}
	}

	/**
	 * Inregistratrea proiectului.
	 * @param proi Proiecte
	 */
	public void altaProiect(final Proiecte proi) {
		try {
			this.proiect = proi;
			// Cautam cea mai mare pozitie din lista
			listaPozitie = proiectService.findAllByOrderByRankDesc();
			// Adaugam inca una
			if (listaPozitie.isEmpty()) {
				proiect.setRank(1L);
			}
			else {
				final Long rank = listaPozitie.get(0).getRank() + 1;
				proiect.setRank(rank);
			}
			// Salvam proiectul
			proiectService.save(proiect);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ALTAMENSAJE,
					Constantes.OKALTAMENSAJE);

		}
		catch (

		final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}
}

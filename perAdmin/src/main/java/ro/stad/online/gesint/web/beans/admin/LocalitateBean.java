package ro.per.online.web.beans.admin;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.apache.poi.util.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.lazydata.LazyModelLocalitati;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;
import ro.per.online.services.LocalityService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;

/**
 * Bean de gestiune ale localitatilor.
 *
 * @author STAD
 */
@Setter
@Getter
@ManagedBean
@Controller("localitateBean")
@Scope("session")
public class LocalitateBean implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variabila utilizata pentru injectarea serviciului de localitati
	 */
	@Autowired
	private transient LocalityService localitateService;

	/**
	 * Lista de localitati.
	 */
	private List<PLocality> listaLocalitati;

	/**
	 * Localitatea
	 */
	private PLocality localitatea;

	/**
	 * Tara.
	 */
	private PProvince judetul;

	/**
	 * Fotoografia localitate.
	 */
	private byte[] photoSelected;

	/**
	 * Nombre del documento.
	 */
	private String nombreDoc;

	/**
	 * Obiect care conține parametrii de căutare.
	 */
	private LocalitateBusqueda localitateBusqueda;

	/**
	 * Lista de judete.
	 */
	private List<PProvince> listaJudete;

	/**
	 * Judetul selectionat.
	 */
	private String idProvincia;

	/**
	 * Variabila utilizata pentru injectarea serviciului de judete
	 */
	@Autowired
	private transient ProvinceService provinceService;

	/**
	 * LazyModel pentru afișarea paginată a datelor din vizualizare.
	 */
	private LazyModelLocalitati model;

	/**
	 * Servicio de usuarios.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Método init de ProvinceBean.
	 */
	@PostConstruct
	public void init() {
		localitateBusqueda = new LocalitateBusqueda();
		this.idProvincia = Constantes.ESPACIO;
		judetul = new PProvince();
		localitatea = new PLocality();
		listaLocalitati = new ArrayList<>();
		listaJudete = provinceService.fiindAll();
		listaLocalitati = localitateService.fiindAll();
	}

	/**
	 * Busca links en base a los campos rellenados en el formulario de filtro.
	 *
	 */
	public void cautareLocalitati() {
		this.model = new LazyModelLocalitati(this.localitateService);
		this.model.setBusqueda(this.localitateBusqueda);
		this.model.load(0, 10, Constantes.ID, SortOrder.DESCENDING, null);
	}

	/**
	 * Colectați valorile introduse în formular și înregistrați o locație normală în baza de date.
	 */
	public void modificaLocalitate(final PLocality loca) {
		try {
			this.localitatea = loca;
			this.localitateService.save(this.localitatea);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
					Constantes.REGMODOK);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Colectați valorile introduse în formular și înregistrați o locație normală în baza de date.
	 */
	public void inregistrareLocalitate(final PLocality loca, String indicator) {
		try {

			this.localitatea = loca;
			if (indicator != null) {
				localitatea.setProvince(provinceService.findById(indicator));
			}
			if (localitatea.getTypelocality().equals(TypeLocalityEnum.MUNICIPALITY)) {
				localitatea.setNivel(1L);
			}
			else if (localitatea.getTypelocality().equals(TypeLocalityEnum.CITY)) {
				localitatea.setNivel(2L);
			}
			else {
				localitatea.setNivel(3L);
			}
			this.localitateService.save(this.localitatea);
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.CAMBIODATOS,
					Constantes.REGMODOK);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					Constantes.DESCERRORMENSAJE);
		}
	}

	/**
	 * Trece datele judetului care dorim sa fie modificat
	 *
	 * @param prov Judetul recuperat
	 * @return vista modificareJudet
	 */
	public String getFormModificarLocalitate(final PLocality loca) {
		this.localitatea = loca;
		this.idProvincia = localitatea.getProvince().getIndicator();
		this.photoSelected = null;
		return "/localitati/modificareLocalitate?faces-redirect=true";
	}

	/**
	 * Trece datele judetului care dorim sa fie modificat
	 *
	 * @param prov Judetul recuperat
	 * @return vista modificareJudet
	 */
	public String getFormAltaLocalitate() {
		this.idProvincia = Constantes.ESPACIO;
		this.localitatea = new PLocality();
		this.photoSelected = null;
		return "/localitati/nouaLocalitate?faces-redirect=true";
	}

	/**
	 * Deschide dialogul de noua imagine.
	 */
	public void mostrarDialogoNuevaImagen() {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlg').show();");
	}

	/**
	 * Carga un documento que se recibe a través de un evento FileUploadEvent. Esta carga se realiza sobre el objeto
	 * documento y no se guarda en base de datos. Se hace una comprobación para verificar si el tipo de documento se
	 * corresponde a la realidad.
	 *
	 * @param event Evento que se lanza en la carga del documento y que contiene el mismo
	 * @throws IOException
	 */
	public void cargaImagen(final FileUploadEvent event) throws IOException {
		this.nombreDoc = Constantes.ESPACIO;
		final UploadedFile uFile = event.getFile();
		localitatea = localitateService.cargaImagenSinGuardar(IOUtils.toByteArray(uFile.getInputstream()), localitatea);
		nombreDoc = uFile.getFileName();
	}

	/**
	 * Returnează formularul de căutare locală în starea inițială și șterge rezultatele căutării anterioare
	 * 
	 *
	 */
	public void limpiarBusqueda() {
		this.localitateBusqueda = new LocalitateBusqueda();
		model.setRowCount(0);
		model = null;
	}

	/**
	 * Elimina o localitate
	 * 
	 * @param usuario El usuario seleccionado de la tabla del resultado de la búsqueda
	 */
	public void eliminaLocalitate(PLocality loca) {
		List<Users> membrii = new ArrayList<>();
		membrii = userService.findByLocality(loca);
		if (!membrii.isEmpty()) {
			FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
					"Nu se poate elimina localitatea. Sunt înregistrate persoane în acesta localitate. Modificații și după încercați iarăși.",
					"", "username");
		}
		else {
			try {
				localitateService.delete(loca);
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ELIMINAREMENSAJE,
						Constantes.REGMODOK);
			}
			catch (DataAccessException e) {

			}
		}

	}
}

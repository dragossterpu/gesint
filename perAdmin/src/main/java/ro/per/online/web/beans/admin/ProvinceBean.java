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
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.PCountry;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.services.ProvinceService;
import ro.per.online.util.FacesUtilities;

/**
 * Bean de gestiune ale judetelor.
 *
 * @author STAD
 */
@Setter
@Getter
@ManagedBean
@Controller("provinceBean")
@Scope("session")
public class ProvinceBean implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variabila utilizata pentru injectarea serviciului de judete
	 */
	@Autowired
	private transient ProvinceService provinceService;

	/**
	 * Lista de judete.
	 */
	private List<PProvince> listaJudete;

	/**
	 * Judetul
	 */
	private PProvince judetul;

	/**
	 * Tara.
	 */
	private PCountry tara;

	/**
	 * Fotoografia judet.
	 */
	private byte[] photoSelected;

	/**
	 * Nombre del documento.
	 */
	private String nombreDoc;

	/**
	 * Método init de ProvinceBean.
	 */
	@PostConstruct
	public void init() {
		judetul = new PProvince();
		listaJudete = new ArrayList<>();
		listaJudete = provinceService.fiindAll();
	}

	/**
	 * Recoge los valores introducidos en el formulario y da de alta un link normal en la BBDD.
	 */
	public void modificaJudet(final PProvince jud) {
		try {
			this.judetul = jud;
			this.provinceService.save(this.judetul);
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
	public String getFormModificarProvince(final PProvince prov) {
		this.judetul = prov;
		this.photoSelected = null;
		final String redireccion = null;
		return "/judete/modificareJudet?faces-redirect=true";
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
		judetul = provinceService.cargaImagenSinGuardar(IOUtils.toByteArray(uFile.getInputstream()), judetul);
		nombreDoc = uFile.getFileName();
	}
}

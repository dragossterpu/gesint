package ro.stad.online.gesint.web.beans;

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
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataJudete;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Tara;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.util.FacesUtilities;

/**
 * Bean de gestiune ale judetelor.
 *
 * @author STAD
 */
@Setter
@Getter
@ManagedBean
@Controller("judetBean")
@Scope(Constante.SESSION)
public class JudetBean implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * Variabila utilizata pentru injectarea serviciului de judete
         */
        @Autowired
        private transient JudetService judetService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Lista de judete.
         */
        private List<Judet> listaJudete;

        /**
         * Judetul
         */
        private Judet judetul;

        /**
         * Tara.
         */
        private Tara tara;

        /**
         * Fotoografia judet.
         */
        private byte[] imagineSelectata;

        /**
         * Numele documentului
         */
        private String numeDoc;

        /**
         * LazyModel pentru afișarea paginată a datelor din pagina.
         */
        private LazyDataJudete model;

        /**
         * Metodă folosită pentru a inițializa JudetBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                judetul = new Judet();
                listaJudete = new ArrayList<>();
                this.model = new LazyDataJudete(this.judetService);
                cautareJudete();
        }

        /**
         * Metodă folosită pentru căutarea județelor.
         *
         */
        public void cautareJudete() {
                this.model = new LazyDataJudete(this.judetService);
                this.model.load(0, NumarMagic.NUMBERTEN, Constante.ID, SortOrder.DESCENDING, null);
        }

        /**
         * Metodă folosită pentru a recupera valorile introduse în formular și înregistra un județ în baza de date.
         * @param jud Judet
         */
        public void modificaJudet(final Judet jud) {
                try {
                        this.judetul = jud;
                        this.judetService.save(this.judetul);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.SCHIMBDATE,
                                        Constante.REGMODOK);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea județului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.JUDET.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a deschide pagina de modificare a judetului.
         * @param prov Judetul recuperat
         * @return pagina modificareJudet
         */
        public String getFormModificareJudete(final Judet prov) {
                this.judetul = prov;
                this.imagineSelectata = null;
                return "/judete/modificareJudet?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a deschide dialogul de noua imagine.
         */
        public void arataDialogulNouaImagine() {
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlg').show();");
        }

        /**
         * Metodă folosită pentru a încărca un document primit printr-un eveniment FileUploadEvent. Această încărcare se
         * Se verifică dacă tipul de document corespunde.
         * @param event FileUploadEvent care este lansat în încărcarea documentului.
         * @throws IOException
         */
        public void incarcareImagine(final FileUploadEvent event) throws IOException {
                this.numeDoc = Constante.SPATIU;
                final UploadedFile uFile = event.getFile();
                try {
                        judetul = judetService.incarcareImaginaFaraStocare(IOUtils.toByteArray(uFile.getInputstream()),
                                        judetul);
                        numeDoc = uFile.getFileName();
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la încărcarea imaginii.".concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la încărcarea imaginii";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.JUDET.getDescriere(),
                                        e);
                }
        }
}

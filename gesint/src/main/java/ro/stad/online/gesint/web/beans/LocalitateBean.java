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
import ro.stad.online.gesint.lazydata.LazyDataLocalitati;
import ro.stad.online.gesint.model.filters.FiltruLocalitate;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.LocalitateService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;

/**
 * Controller de gestiune al localitatilor.
 *
 * @author STAD
 */
@Setter
@Getter
@ManagedBean
@Controller("localitateBean")
@Scope(Constante.SESSION)
public class LocalitateBean implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * Variabila utilizata pentru injectarea serviciului de localitati
         */
        @Autowired
        private transient LocalitateService localitateService;

        /**
         * Lista de localitati.
         */
        private List<Localitate> listaLocalitati;

        /**
         * Localitatea
         */
        private Localitate localitatea;

        /**
         * Tara.
         */
        private Judet judetul;

        /**
         * Fotoografia localitate.
         */
        private byte[] imagineSelectata;

        /**
         * Nombre del documento.
         */
        private String numeDoc;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private FiltruLocalitate filtruLocalitate;

        /**
         * Lista de judete.
         */
        private List<Judet> listaJudete;

        /**
         * Judetul selectionat.
         */
        private String idJudet;

        /**
         * Variabila utilizata pentru injectarea serviciului de judete
         */
        @Autowired
        private transient JudetService judetService;

        /**
         * LazyModel pentru afișarea paginată a datelor din pagina.
         */
        private LazyDataLocalitati model;

        /**
         * Serviciu utilizatorului
         */
        @Autowired
        private UtilizatorService utilizatorService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Metoda init() de LocalitateBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                filtruLocalitate = new FiltruLocalitate();
                this.idJudet = Constante.SPATIU;
                judetul = new Judet();
                localitatea = new Localitate();
                listaLocalitati = new ArrayList<>();
                listaJudete = judetService.fiindAll();
                listaLocalitati = localitateService.fiindAll();
        }

        /**
         * Metodă folosită pentru căutarea localităților pe baza câmpurilor completate în formularul de filtrare..
         *
         */
        public void cautareLocalitati() {
                this.model = new LazyDataLocalitati(this.localitateService);
                this.model.setFiltruLocalitate(this.filtruLocalitate);
                this.model.load(0, NumarMagic.NUMBERTEN, Constante.ID, SortOrder.DESCENDING, null);
        }

        /**
         * Metodă folosită pentru a modifica o localitatea în baza de date.
         * @param loca Localitate.
         */
        public void modificaLocalitate(final Localitate loca) {
                try {
                        this.localitatea = loca;
                        this.localitateService.save(this.localitatea);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.SCHIMBDATE,
                                        Constante.REGMODOK);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea localității";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.LOCALITATI.getDescriere(), e);
                }
        }

        /**
         * Metodă folosită pentru a înregistra localitatea în baza de date.
         * @param loca Localitate
         * @param indicator String
         */
        public void inregistrareLocalitate(final Localitate loca, final String indicator) {
                try {
                        this.localitatea = loca;
                        if (indicator != null) {
                                localitatea.setJudet(judetService.findById(indicator));
                        }
                        if (localitatea.getTipLocalitate().equals(TipLocalitateEnum.MUNICIPALITY)) {
                                localitatea.setNivel(NumarMagic.NUMBERONELONG);
                        }
                        else if (localitatea.getTipLocalitate().equals(TipLocalitateEnum.CITY)) {
                                localitatea.setNivel(NumarMagic.NUMBERTWOLONG);
                        }
                        else {
                                localitatea.setNivel(NumarMagic.NUMBERTHREEL);
                        }
                        this.localitateService.save(this.localitatea);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.SCHIMBDATE,
                                        Constante.REGMODOK);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la înregistrarea localității";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.LOCALITATI.getDescriere(), e);
                }
        }

        /**
         * Metodă folosită pentru a obtine datele localitatiii pentru a putea fi modificate.
         * @param loca Localitate recuperată
         * @return pagina modificareLocalitate
         */
        public String getFormModificarLocalitate(final Localitate loca) {
                this.localitatea = loca;
                this.idJudet = localitatea.getJudet().getIndicator();
                this.imagineSelectata = null;
                return "/localitati/modificareLocalitate?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a obtine formularul de inregistrare a noii localitati
         * @return pagina nouaLocalitate
         */
        public String getFormAltaLocalitate() {
                this.idJudet = Constante.SPATIU;
                this.localitatea = new Localitate();
                this.imagineSelectata = null;
                return "/localitati/nouaLocalitate?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a deschide dialogul de noua imagine.
         */
        public void arataDialogulNouaImagine() {
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlg').show();");
        }

        /**
         * Metodă folosită pentru a incărca un document prin FileUploadEvent. Această încărcare nu este salvată în baza
         * de date. Se verifică dacă tipul de document corespunde realității.
         * @param event FileUploadEvent Event care este lansat în încărcarea documentului și care conține același lucru
         * @throws IOException
         */
        public void incarcareImagine(final FileUploadEvent event) throws IOException {
                this.numeDoc = Constante.SPATIU;
                final UploadedFile uFile = event.getFile();
                try {
                        localitatea = localitateService.incarcareImaginaFaraStocare(
                                        IOUtils.toByteArray(uFile.getInputstream()), localitatea);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la încarcarea imaginii localității";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.LOCALITATI.getDescriere(), e);
                }
                numeDoc = uFile.getFileName();
        }

        /**
         * Metodă folosită pentru a returna formularul de căutare locală în starea inițială și pentru a șterge
         * rezultatele căutării anterioare
         */
        public void cautareCautare() {
                this.filtruLocalitate = new FiltruLocalitate();
                model.setRowCount(0);
                model = null;
        }

        /**
         * Metodă folosită pentru a elimina o localitate
         * @param loca Localitate care se va elimina
         */
        public void eliminaLocalitate(Localitate loca) {
                List<Utilizator> membrii = new ArrayList<>();
                membrii = utilizatorService.findByLocality(loca);
                if (!membrii.isEmpty()) {
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                        "Nu se poate elimina localitatea. Sunt înregistrate persoane în acesta localitate. Modificații și după încercați iarăși.",
                                        Constante.SPATIU, "username");
                }
                else {
                        try {
                                localitateService.delete(loca);
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                Constante.ELIMINAREMESAJ, Constante.REGMODOK);
                        }
                        catch (DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                final String descriere = "A apărut o eroare la eliminarea localității";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.LOCALITATI.getDescriere(), e);
                        }
                }

        }
}

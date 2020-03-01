package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.lazydata.LazyDataDocumente;
import ro.stad.online.gesint.model.filters.FiltruDocument;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.TipDocument;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.repositories.TipDocumentRepository;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.services.impl.DocumentServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Bean pentru managerul de documente.
 *
 * @author STAD
 *
 */

@Setter
@Getter
@Controller("gestorDocumentalBean")
@Scope(Constante.SESSION)
@Slf4j
public class DocumentManagementBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Constant pentru a evita repetările literale..
         */
        private static final String INCARCAREFISIER = "Încărcare fișier";

        /**
         * Obiectul de tip Document pentru înregistrarea de noi documente.
         */
        private Documentul document;

        /**
         * Obiect care conține parametrii de căutare pentru documente.
         */
        private FiltruDocument filtruDocument;

        /**
         * Obiect care va conține fișierul care urmează să fie descărcat.
         */
        private transient StreamedContent file;

        /**
         * Numele documentului
         */
        private String numeDoc;

        /**
         * Listează unde sunt stocați utilizatorii care vor fi asociați unui document.
         */
        private List<Utilizator> listaUtilizatori = new ArrayList<>();

        /**
         * Mapa care relaționeză documentele și utilizatorii.
         */
        private Map<Long, String> mapaUtiliztori;

        /**
         * Map care relaționeză documentele și utilizatorii.
         */
        private Map<Long, Boolean> mapEditie;

        /**
         * Lista valorilor booleene pentru vizualizarea coloanelor in pagina.
         */
        private List<Boolean> list;

        /**
         * Serviciu de documente.
         */
        @Autowired
        private transient DocumentServiceImpl documentService;

        /**
         * Repository de tipuri de documente.
         */
        @Autowired
        private transient TipDocumentRepository tipDocumentRepository;

        /**
         * Service de utilizatori.
         */
        @Autowired
        private transient UtilizatorService utilizatorService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Model Lazy pentru consultarea paginată a documentelor din baza de date.
         */
        private LazyDataDocumente model;

        /**
         * r Utilizator user
         */

        private Utilizator user;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private transient Utilitati utilitati;

        /**
         * Metodă folosită pentru a elimina un document.
         * @param doc Documentul
         */
        public void borrarDocumento(final Documentul doc) {
                try {
                        doc.setUtilizator(null);
                        this.documentService.delete(doc);
                        this.cautareDocument();
                        final String descriere = "Fișierul a fost eliminat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.ELIMINARE.getName(), SectiuniEnum.PROIECT.getName(), user);
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la eliminarea fișierului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));

                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                }
        }

        /**
         * Metodă folosită pentru a căuta documente din baza de date care corespund parametrilor conținuți în obiectul
         * de căutare. Paginarea se efectuează în server.
         */
        public void cautareDocument() {
                this.model.setFiltruDocument(this.filtruDocument);
                this.model.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
                this.numeDoc = Constante.SPATIU;
        }

        /**
         * Metodă folosită pentru a încărca un document primit printr-un event de tip FileUploadEvent. Se verifică dacă
         * tipul de document corespunde realității.
         * @param event FileUploadEvent Event care este lansat în încărcarea documentului
         */
        public void incarcareFisier(final FileUploadEvent event) {
                try {
                        final TipDocument tipo = this.tipDocumentRepository.findByNume("ALTELE");
                        final UploadedFile uFile = event.getFile();
                        this.document = this.documentService.incarcareDocumentFaraSalvare(uFile, tipo, null);
                        this.numeDoc = uFile.getFileName();
                }
                catch (final GesintException ex) {
                        final String descriere = "A apărut o eroare la încărcarea fișierului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, INCARCAREFISIER,
                                        descriere);
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), ex);
                }
        }

        /**
         * Metodă folosită pentru a înregistra un nou document în baza de date
         * @param numeDocumento String Numele documentului
         * @param tipDocument TipDocument Tip documentului
         * @param descriere String Scurta descriere a documentului
         * @param materiaIndexada String Cuvinte cheie dupa care se poate cauta documentul.
         */
        public void creazaDocument(final String numeDocument, final TipDocument tipDocument, final String descriere,
                        final String materiaIndexada) {
                if (!this.numeDoc.isEmpty() && !numeDocument.isEmpty() && (tipDocument != null)) {
                        try {
                                this.document.setNume(numeDocument);
                                this.document.setTipDocument(tipDocument);
                                this.document.setDescriere(descriere);
                                final Utilizator utilizator = this.utilizatorService.fiindOne(
                                                SecurityContextHolder.getContext().getAuthentication().getName());
                                this.document.setUtilizator(utilizator);
                                this.document.setMateriaIndexada(materiaIndexada);
                                this.document.setDateDeleted(null);
                                this.documentService.save(this.document);
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                RegistruEnum.INREGISTRARE.getDescriere(), "S-a înregistrat cu exit");
                                this.reincarcareLista();
                                RequestContext.getCurrentInstance().reset("formAlta:asociado");
                                this.numeDoc = Constante.SPATIU;
                                final String mesaj = "Fișierului a fost înregistrat cu succes";
                                this.regActividadService.inregistrareRegistruActivitate(mesaj,
                                                RegistruEnum.ELIMINARE.getName(), SectiuniEnum.PROIECT.getName(),
                                                utilizator);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                final String descrier = "A apărut o eroare la înregistrarera  fișierului";
                                this.regActividadService.salveazaRegistruEroare(descrier,
                                                SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                                log.error(descrier);
                        }
                }
                else {
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR, "Înregistrare de documente",
                                        "Completați câmpurile necesare înainte de a continua.", null);
                }
        }

        /**
         * Metodă folosită pentru a descărca documentul.
         * @param document Documentul
         */
        public void descarcareFisier(final Documentul document) {
                final Documentul docAux = this.documentService.findOne(document.getId());
                this.setFile(null);
                if (docAux != null) {
                        try {
                                this.setFile(this.documentService.descarcareDocument(docAux));
                        }
                        catch (final GesintException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(), e.getMessage());
                                final String descriere = "A apărut o eroare la descarcarea fișierului";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                                log.error(descriere);
                        }
                }
                else {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, INCARCAREFISIER,
                                        "A apărut o eroare la descărcarea fișierului");
                }
        }

        /**
         * Metodă folosită pentru a obține documentul pentru a fie modificat.
         * @param doc Documentul
         * @return URL de la vista de edición
         */
        public String editareDocument(final Documentul doc) {
                final Documentul docAux = this.documentService.findOne(doc.getId());
                String ruta = Constante.SPATIU;
                if (docAux != null) {
                        this.document = docAux;
                        this.numeDoc = this.documentService.obtieneNumeFisier(this.document);
                        ruta = "/gestorDocumental/editareDocument?faces-redirect=true";
                }
                else {
                        final String descriere = "A apărut o eroare la accesarea fișierului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, INCARCAREFISIER,
                                        descriere);
                        log.error(descriere);
                }
                return ruta;
        }

        /**
         * Metodă folosită pentru a obține eliminarea logica a documentului care poate fi recuperat din coșul de gunoi..
         * @param document Documentul care va elimina logic
         */
        public void eliminareDocument(final Documentul document) {
                try {
                        document.setDateDeleted(new Date());
                        document.setUserDeleted(SecurityContextHolder.getContext().getAuthentication().getName());
                        this.documentService.save(document);
                        this.cautareDocument();
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la eliminarea documentului";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                        log.error(descriere);
                }
        }

        /**
         * @PostConstruct Inițializează obiectul.
         */
        @PostConstruct
        public void init() {
                this.filtruDocument = new FiltruDocument();
                this.list = new ArrayList<>();
                for (int i = 0; i <= NumarMagic.NUMBERFIVE; i++) {
                        this.list.add(Boolean.TRUE);
                }
                this.model = new LazyDataDocumente(this.documentService);
                this.mapEditie = new HashMap<>();
                this.user = this.utilitati.getUtilizatorLogat();

        }

        /**
         * Metodă folosită pentru a obține resetarea obiectului de căutare și curățarea listei de rezultate.
         */
        public void cautareCautare() {
                this.filtruDocument = new FiltruDocument();
                this.model.setRowCount(0);
        }

        /**
         * Metodă folosită pentru a salva documentul modificat.
         */
        public void modificaDocument() {
                try {
                        this.documentService.save(this.document);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.MODIFICARE.getDescriere(), "Documentul a fost modificat");
                        this.reincarcareLista();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la modificarea documentului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.MODIFICARE.getDescriere(), descriere);
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru a incepe crearea unui nou document.
         * @return string url
         */
        public String nouDocument() {
                this.document = new Documentul();
                this.numeDoc = Constante.SPATIU;
                return "/gestorDocumental/nouDocument?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a afișa / ascunde coloanele din tabelul cu rezultatele căutării.
         * @param e ToggleEvent
         */
        public void onToggle(final ToggleEvent e) {
                this.list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metodă folosită pentru a reîncărca lista cu documentele care nu au fost șterse.
         */
        public void reincarcareLista() {
                this.filtruDocument.setEliminat(false);
                this.cautareDocument();

        }

        /**
         * Metodă folosită pentru a reîncărca lista cu documentele eliminate.
         */
        public void reincarcareListaEliminati() {
                this.filtruDocument.setEliminat(true);
                this.cautareDocument();
        }

        /**
         * Metodă folosită pentru a recupera un document din coșul de gunoi.
         * @param doc Documentul de recuperat
         */
        public void recuperareDocument(final Documentul doc) {
                try {
                        this.documentService.recupereazaDocument(doc);
                        this.cautareDocument();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la recuperarea documentului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.MODIFICARE.getDescriere(), descriere);
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                        log.error(descriere);
                }

        }

        /**
         * Metodă folosită pentru a reseta obiectul cu filtru de căutare, șterge lista de rezultate și seteaza booleanul
         * de la șters la fals pentru a indica faptul că vor fi căutate doar documentele care nu sunt șterse.
         * @return String url
         */
        public String curatareFiltru() {
                this.filtruDocument = new FiltruDocument();
                this.model.setRowCount(0);
                this.numeDoc = Constante.SPATIU;
                this.filtruDocument.setEliminat(false);
                return "/gestorDocumental/buscarDocumento?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a reseta obiectul de căutare, șterge lista de rezultate și seteaza booleanul de la
         * șters la fals pentru a indica că doar documentele șterse trebuie să fie căutate.
         * @return url
         */
        public String curatareFiltruEliminati() {
                this.numeDoc = Constante.SPATIU;
                this.filtruDocument.setEliminat(true);
                this.cautareDocument();
                return "/administracion/papelera/papelera?faces-redirect=true";

        }

        /**
         * Metodă foloită la golirea coșului de gunoi.
         */
        public void vaciarPapelera() {
                try {
                        final List<Documentul> documentosEliminados = this.documentService.golesteCosulGunoi();
                        final StringBuilder nombreFicherosEliminados = new StringBuilder().append("\n\n");
                        for (final Documentul docu : documentosEliminados) {
                                nombreFicherosEliminados.append('-').append(docu.getNume()).append("\n");
                        }
                        this.cautareDocument();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la golirea coșului de gunoi";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, "MODIFCARE", descriere);
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                        log.error(descriere);

                }
        }

}

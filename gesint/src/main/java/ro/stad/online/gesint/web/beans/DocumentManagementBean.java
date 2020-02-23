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
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.lazydata.LazyDataDocumente;
import ro.stad.online.gesint.model.filters.FiltruDocument;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.TipDocument;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.repositories.TipDocumentRepository;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.services.impl.DocumentServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;

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
         * Metodă folosită pentru a elimina un document.
         * @param doc Documentul
         */
        public void borrarDocumento(final Documentul doc) {
                try {
                        doc.setUtilizator(null);
                        this.documentService.delete(doc);
                        this.cautareDocument();
                        final String descriere = "Proiectul a fost eliminat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere, Constante.ELIMINARE,
                                        SectiuniEnum.PROIECT.getDescriere(), user);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la eliminarea documentului."
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la eliminarea documentului";
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
                this.model.load(0, NumarMagic.NUMBERFIFTEEN, "fechaAlta", SortOrder.DESCENDING, null);
                this.numeDoc = Constante.SPATIU;
        }

        /**
         * Metodă folosită pentru a încărca un document primit printr-un event de tip FileUploadEvent. Se verifică dacă
         * tipul de document corespunde realității.
         * @param event FileUploadEvent Event care este lansat în încărcarea documentului
         */
        public void cargaFichero(final FileUploadEvent event) {
                try {
                        final TipDocument tipo = this.tipDocumentRepository.findByNume("OTROS");
                        final UploadedFile uFile = event.getFile();
                        this.document = this.documentService.incarcareDocumentFaraSalvare(uFile, tipo, null);
                        this.numeDoc = uFile.getFileName();
                }
                catch (final GesintException ex) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, INCARCAREFISIER,
                                        "A apărut o eroare la încărcarea fișierului");
                        final String descriere = "A apărut o eroare la încărcarea fișierului";
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
                                final Utilizator user = this.utilizatorService.fiindOne(
                                                SecurityContextHolder.getContext().getAuthentication().getName());
                                this.document.setUtilizator(user);
                                this.document.setMateriaIndexada(materiaIndexada);
                                this.document.setDateDeleted(null);
                                this.documentService.save(this.document);
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                Constante.INREGISTRARE, "S-a înregistrat cu exit");
                                this.reincarcareLista();
                                RequestContext.getCurrentInstance().reset("formAlta:asociado");
                                this.numeDoc = Constante.SPATIU;
                                final String mesaj = "Documentul a fost înregistrat cu succes";
                                this.regActividadService.inregistrareRegistruActivitate(mesaj, Constante.ELIMINARE,
                                                SectiuniEnum.PROIECT.getDescriere(), user);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ,
                                                "A apărut o eroare la înregistrarea documentului."
                                                                .concat(Constante.DESCEROAREMESAJ));
                                final String mesaj = "A apărut o eroare la înregistrarea documentului";
                                this.regActividadService.salveazaRegistruEroare(mesaj,
                                                SectiuniEnum.PROIECT.getDescriere(), e);
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
                                                Constante.EROAREMESAJ, e.getMessage());
                                final String mesaj = "A apărut o eroare la descarcarea fișierului";
                                this.regActividadService.salveazaRegistruEroare(mesaj,
                                                SectiuniEnum.PROIECT.getDescriere(), e);
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
         * @throws GesintException
         */
        public String editareDocument(final Documentul doc) throws GesintException {
                final Documentul docAux = this.documentService.findOne(doc.getId());
                String ruta = Constante.SPATIU;
                if (docAux != null) {
                        this.document = docAux;
                        this.numeDoc = this.documentService.obtieneNumeFisier(this.document);
                        ruta = "/gestorDocumental/editareDocument?faces-redirect=true";
                }
                else {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, INCARCAREFISIER,
                                        "Se ha producido un error al acceder al documento");
                }
                return ruta;
        }

        /**
         * Realiza la baja lógica del documento que podrá ser recuperado desde la papelera.
         *
         * @param document Documentul al que se dará de baja lógica
         */
        public void eliminareDocument(final Documentul document) {
                try {
                        document.setDateDeleted(new Date());
                        document.setUserDeleted(SecurityContextHolder.getContext().getAuthentication().getName());
                        this.documentService.save(document);
                        this.cautareDocument();
                }
                catch (final DataAccessException e) {
                }
        }

        /**
         * Inicializa el objeto.
         */
        @PostConstruct
        public void init() {
                this.filtruDocument = new FiltruDocument();
                this.list = new ArrayList<>();
                for (int i = 0; i <= 5; i++) {
                        this.list.add(Boolean.TRUE);
                }
                this.model = new LazyDataDocumente(this.documentService);
                this.mapEditie = new HashMap<>();
                try {
                        user = utilizatorService
                                        .fiindOne(SecurityContextHolder.getContext().getAuthentication().getName());
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                }
        }

        /**
         * Reseteo del objeto de búsqueda y limpieza de la lista de resultados.
         */
        public void cautareCautare() {
                this.filtruDocument = new FiltruDocument();
                this.model.setRowCount(0);
        }

        /**
         * Graba el documento modificado.
         */
        public void modificaDocument() {
                try {
                        this.documentService.save(this.document);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, "MODIFCARE",
                                        "Documentul a fost modificat");
                        this.reincarcareLista();
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, "MODIFCARE",
                                        "A apărut o eroare la modificarea documentului");
                }
        }

        /**
         * Inicia la creación de un nuevo documento.
         * @return ruta de la vista
         */
        public String nouDocument() {
                this.document = new Documentul();
                this.numeDoc = "";
                return "/gestorDocumental/nouDocument?faces-redirect=true";
        }

        /**
         * Muestra/oculta las columnas de la tabla de resultados de la búsqueda.
         *
         * @param e La columna a mostrar/ocultar
         */
        public void onToggle(final ToggleEvent e) {
                this.list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Recarga la lista de resultados no eliminados.
         */
        public void reincarcareLista() {
                this.filtruDocument.setEliminat(false);
                this.cautareDocument();

        }

        /**
         * Recarga la lista de resultados eliminados.
         */
        public void reincarcareListaEliminati() {
                this.filtruDocument.setEliminat(true);
                this.cautareDocument();
        }

        /**
         * Recupera un documento desde la papelera.
         * @param doc Documentul a recuperar
         */
        public void recuperareDocument(final Documentul doc) {
                try {
                        this.documentService.recupereazaDocument(doc);
                        this.cautareDocument();
                }
                catch (final DataAccessException e) {
                }

        }

        /**
         * Resetea el objeto de búsqueda, limpia la lista de resultados y establece el booleano de eliminado a false
         * para indicar que sólo se van a buscar documentos no eliminados.
         * @return ruta siguiente
         */
        public String curatareFiltru() {
                this.filtruDocument = new FiltruDocument();
                this.model.setRowCount(0);
                this.numeDoc = Constante.SPATIU;
                this.filtruDocument.setEliminat(false);
                return "/gestorDocumental/buscarDocumento?faces-redirect=true";
        }

        /**
         * Resetea el objeto de búsqueda, limpia la lista de resultados y establece el booleano de eliminado a false
         * para indicar que sólo se van a buscar documentos eliminados.
         * @return ruta
         */
        public String curatareFiltruEliminati() {
                this.numeDoc = Constante.SPATIU;
                this.filtruDocument.setEliminat(true);
                this.cautareDocument();
                return "/administracion/papelera/papelera?faces-redirect=true";

        }

        /**
         * Vacía la papelera de reciclaje.
         */
        public void vaciarPapelera() {
                try {
                        final List<Documentul> documentosEliminados = this.documentService.golesteCosulGunoi();
                        final StringBuffer nombreFicherosEliminados = new StringBuffer().append("\n\n");
                        for (final Documentul docu : documentosEliminados) {
                                nombreFicherosEliminados.append('-').append(docu.getNume()).append("\n");
                        }
                        this.cautareDocument();
                }
                catch (final DataAccessException e) {
                }
        }

}

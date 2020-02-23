package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.mitchellbosecke.pebble.error.PebbleException;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.lazydata.LazyDataCorespondente;
import ro.stad.online.gesint.lazydata.LazyDataUtilizatori;
import ro.stad.online.gesint.model.filters.FiltruCorespondenta;
import ro.stad.online.gesint.model.filters.FiltruEchipa;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Echipa;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.TipDocument;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.CanalAlertaEnum;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.RolEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipRegistruEnum;
import ro.stad.online.gesint.services.CorespondentaService;
import ro.stad.online.gesint.services.DocumentService;
import ro.stad.online.gesint.services.EchipaService;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.ParamEchipaService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.services.impl.RegistruActivitateServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Controlorul operațiunilor legate de gestionarea corespondentelor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("corespondentaBean")
@Scope(Constante.SESSION)
public class CorespondentaBean implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = NumarMagic.NUMBERONELONG;

        /**
         * Numărul de coloane din tabelul de corespondenta.
         */
        private static final int NUMARCOLOANE = NumarMagic.NUMBERFIVE;

        /**
         * Corespondenta noua.
         */
        private transient Corespondenta corespondenta;

        /**
         * Variala utilizata pentru injectarea serviciului de corespondenta.
         */
        @Autowired
        private transient CorespondentaService corespondentaService;

        /**
         * Variala utilizata pentru injectarea serviciului de utilizatori.
         */
        @Autowired
        private transient UtilizatorService utilizatorService;

        /**
         * Lazy model pentru utilizatori.
         */
        private transient LazyDataUtilizatori modelUser;

        /**
         * Clasa de căutare a utilizatorilor.
         */
        private FiltruUtilizator filtruUtilizator;

        /**
         * Clasa de căutare a corespondentelor.
         */
        private FiltruCorespondenta filtruCorespondenta;

        /**
         * LazyModel pentru afișarea paginată a datelor.
         */
        private LazyDataCorespondente model;

        /**
         * Listă de corespondente per utilizator.
         */
        private List<Corespondenta> lstCorespondente;

        /**
         * Utilizator care se modifică în acest moment.
         */
        private Corespondenta corespondentaActuala;

        /**
         * Indicați ce colomne apar în listă.
         */
        private List<Boolean> list;

        /**
         * Lista utilizatorilor selectați.
         */
        private List<Utilizator> utilizatoriSelectionati;

        /**
         * Lista utilizatorilor externi selectați.
         */
        private List<Utilizator> utilizatoriExterniSelectionati;

        /**
         * Lista utilizatorilor selectați final.
         */
        private List<Utilizator> utilizatoriSelectionatiFinali;

        /**
         * Numele de utilizator care va fi folosit pentru a trimite e-mailul unui singur destinatar.
         */
        private String numeUtilizator = Constante.SPATIU;

        /**
         * Indicați dacă doriți să căutați după echipa de conducere (opțiunea 1), membrii (opțiunea 2) sau destinatari
         * externi (opțiunea 3)
         */
        private Integer opcion = 1;

        /**
         * Lista numelor din echipa de conducere.
         */
        private List<Echipa> listaEchipa;

        /**
         * Variala utilizata pentru injectarea serviciului pentru echipa de conducere.
         *
         */
        @Autowired
        private transient EchipaService echipaService;

        /**
         * Variala utilizata pentru injectarea serviciului înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateServiceImpl registruActivitateService;

        /**
         * Obiectul echipei de conducere.
         */
        private Echipa echipa;

        /**
         * Numar de membri
         */
        private Integer numarMembrii;

        /**
         * Lista de judete.
         */
        private List<Judet> judete;

        /**
         * Variabila utilizata pentru a injecta serviciul provinciei.
         *
         */
        @Autowired
        private JudetService judetService;

        /**
         * Variabila utilizata pentru a recupera emailul unor utilizatori externi.
         *
         */
        private String utilizatorExtern;

        /**
         * Lista de documente asociate cererii.
         */
        private List<Documentul> listaDocumente;

        /**
         * Serviciul de documente.
         */
        @Autowired
        private transient DocumentService documentService;

        /**
         * Extensiile de fișier acceptate în sistem..
         */
        private Map<String, String> extensie;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Bean de date comune de aplicatie.
         */
        @Autowired
        private transient ApplicationBean applicationBean;

        /**
         * Fișier încărcat sau descărcat.
         */
        private transient StreamedContent file;

        /**
         * Lista documentelor încărcate.
         */
        private List<Documentul> documenteIncarcate;

        /**
         * Dias inactividad de un usuario.
         */
        private long zileInactivitate;

        /**
         * Data actuala
         */
        private Date currentDate;

        /**
         * Variabila pentru lista de functii existente in baza de date
         */
        private List<Utilizator> listUsersCentral;

        /**
         * Variabila pentru lista de functii existente in baza de date
         */
        private List<Utilizator> listUsersLocal;

        /**
         * Variabila utilizata pentru a injecta serviciul functilor
         *
         */
        @Autowired
        private ParamEchipaService pEchipaService;

        /**
         * Objeto de búsqueda de usuario.
         */
        private FiltruEchipa filtruEchipa;

        /**
         * Numar de membri in conducerea locala.
         */
        private int rowCountLocal;

        /**
         * Numar de membri in conducerea centrala.
         */
        private int rowCountCentral;

        /**
         * Lista functilor locale.
         */
        private List<Functie> listaFunctiiLocal;

        /**
         * Metodă care caută corespondente pe baza filtrului de căutare.
         */
        public void cautareCorespondente() {
                this.model.setFiltruCorespondenta(this.filtruCorespondenta);
                this.model.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
        }

        /**
         * Găsiți corespondenta din matricea de alertă locală.
         * @param id Long
         * @return Corespondenta
         */
        private Corespondenta cautareCorespondentaLocal(final Long id) {
                Corespondenta result = new Corespondenta();
                for (final Corespondenta corespondentaLocal : this.lstCorespondente) {
                        if (corespondentaLocal.getId() == id) {
                                result = corespondentaLocal;
                                break;
                        }
                }
                return result;
        }

        /**
         * Metoda care caută utilizatori pe baza unui filtru.
         * @return modelUser
         */
        public void cautareUtilizatori() {
                if (this.opcion == NumarMagic.NUMBERONE) {
                        this.modelUser.setFiltruUtilizator(this.filtruUtilizator);
                        this.modelUser.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING,
                                        null);
                }
                else if (this.opcion == NumarMagic.NUMBERTWO) {
                        if (filtruUtilizator.getIdFunctia() != null) {
                                filtruEchipa.setIdFunctia(filtruUtilizator.getIdFunctia());
                                final List<Functie> lista = new ArrayList<>();
                                filtruEchipa.setListaFunctii(lista);
                        }
                        else {
                                filtruEchipa.setListaFunctii(listaFunctiiLocal);
                        }
                        if (filtruUtilizator.getNume() != null) {
                                filtruEchipa.setNume(filtruUtilizator.getNume());
                        }
                        if (filtruUtilizator.getIdJudet() != null) {
                                filtruEchipa.setIdJudet(filtruUtilizator.getIdJudet());
                        }
                        listUsersLocal = utilizatorService.cautareUtilizatorCriteriaLocal(filtruEchipa);
                        rowCountLocal = listUsersLocal.size();
                }

        }

        /**
         * Metoda care sterge corespondenta curentă care este vizionată.
         */
        public void curataCorespondenta() {
                this.corespondentaActuala = new Corespondenta();
        }

        /**
         * Metoda care curăță utilizatorul de date și cel de fișiere.
         */
        public void curatareFiltre() {
                this.filtruUtilizator = new FiltruUtilizator();
                this.utilizatoriSelectionati = new ArrayList<>();
                this.modelUser = new LazyDataUtilizatori(this.utilizatorService);
        }

        /**
         * Metoda care curăță filtrul de căutarea.
         */
        public void curatareFiltru() {
                this.filtruCorespondenta = new FiltruCorespondenta();
                this.model = new LazyDataCorespondente(this.corespondentaService);
        }

        /**
         * Metoda care descarcă un document încărcat de utilizator.
         * @param documentul documentul selectat
         */
        public void descarcareFisier(final Documentul documentul) {
                setFile(null);
                try {
                        setFile(documentService.descarcareDocument(documentul));
                }
                catch (final GesintException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la descărcarea fișierului");
                        final String descriere = "A apărut o eroare la descărcarea fișierului";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                }
        }

        /**
         * Metoda care deschide dialogul pentru căutarea utilizatorilor.
         */
        public void deschideDialogCautareUtilizatori() {

                this.filtruEchipa = new FiltruEchipa();
                filtruUtilizator = new FiltruUtilizator();
                this.modelUser = new LazyDataUtilizatori(this.utilizatorService);
                this.opcion = NumarMagic.NUMBERONE;
                this.judete = this.judetService.fiindAll();
                this.listUsersLocal = new ArrayList<>();
                listaFunctiiLocal = incarcamToateFunctileLocale();
                this.numarMembrii = this.listaEchipa.size();
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute(Constante.DIALOGCAUTARE);
                List<Functie> lista = new ArrayList<>();
                lista = incarcamToateFunctileCentrale();
                filtruEchipa.setListaFunctii(lista);
                listUsersCentral = utilizatorService.cautareUtilizatorCriteriaLocal(filtruEchipa);
                rowCountCentral = listUsersCentral.size();
        }

        /**
         * Metoda care deschide dialogul pentru incarcarea documentelor.
         */
        public void deschideDialogIncarcarDocument() {
                this.documenteIncarcate = new ArrayList<>();
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgIncarcareDocument').show();");
        }

        /**
         * Metoda care afișează pagina Corespondenta cu corespondenta curentă.
         * @param corespond Corespondenta
         */
        public void deschidereDialogCorespondentaCuDate(final Corespondenta corespond) {
                this.corespondentaActuala = corespond;
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute(Constante.DIALOGCORESPONDENTA);
        }

        /**
         * Metoda care afișează pagina Corespondenta.
         */
        public void deschidereDialogCorespondenta() {
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute(Constante.DIALOGCORESPONDENTA);
        }

        /**
         * Metoda care incarcă corespondenta cu identificator ei.
         * @param corespond Corespondenta
         */
        public void detaliuCorespondenta(final Corespondenta corespond) {
                this.corespondentaActuala = this.cautareCorespondentaLocal(corespond.getId());
        }

        /**
         * Metoda care elimina o corespondenta.
         * @param corespondenta Corespondenta aleasa pentru eliminare
         */
        public void eliminareCorespondenta(final Corespondenta corespond) {
                try {
                        this.corespondenta = corespond;
                        final List<Documentul> documente = documentService.findByCorespondenta(corespondenta);
                        if (!documente.isEmpty()) {
                                for (final Documentul doc : documente) {
                                        documentService.delete(doc);
                                }
                        }
                        corespondentaService.delete(corespondenta.getId());
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.ELIMINAREMESAJ,
                                        Constante.OKELIMINAREMESAJ);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la eliminarea  corespondenței";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.CORESPONDENTA.getDescriere(), e);
                }
        }

        /**
         * Metoda care realizează o eliminarea logică a documentului (poate fi recuperat din coșul de gunoi).
         * @param document Documentul care o sa fie eliminat logic.
         */
        public void eliminareDocument(final Documentul document) {
                try {
                        this.listaDocumente.remove(document);
                        this.documentService.delete(document);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la eliminarea fișierului";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                }
        }

        /**
         * Metoda care realizează eliminarea logică a documentului (poate fi recuperat din coșul de gunoi).
         * @param document Documentul care o sa fie eliminat logic.
         */
        public void eliminareDocumentFinal(final Documentul document) {
                try {
                        this.documenteIncarcate.remove(document);
                        this.documentService.delete(document);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la eliminarea fișierului";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                }
        }

        /**
         * Metoda care elimina un utilizator din lista utilizatorilor selectați pentru a primi corespondenta.
         * @param utili User
         */
        public void eliminareUtilizator(final Utilizator utili) {
                this.utilizatoriSelectionatiFinali.remove(utili);
                final List<Utilizator> utilizatorEliminare = new ArrayList<>();
                for (final Utilizator usu : this.utilizatoriSelectionatiFinali) {
                        if (usu.getUsername().equals(utili.getUsername())) {
                                utilizatorEliminare.add(usu);
                        }
                }
                this.utilizatoriSelectionatiFinali.removeAll(utilizatorEliminare);
        }

        /**
         * Metoda care verifică dacă un fișier corespunde atât în nume, cât și în extensie.
         * @param fisier UploadedFile fisier incarcat
         * @return booleano esteValabil
         */
        private boolean esteDocumentatie(final UploadedFile fisier) {
                final String numeFisier = fisier.getFileName();
                boolean esteValabil = false;
                esteValabil = numeFisier.toLowerCase().startsWith(fisier.getFileName().toLowerCase());
                return esteValabil;
        }

        /**
         * Metoda care salveaza un fișier încărcat de utilizator, după ce ați confirmat că nu este un fișier corupt și
         * că se potrivește cu oricare dintre cele solicitate.
         * @param event eveniment lansat din formular
         * @return ruta traseu
         */
        public void gestioneazaIncarcareDocument(final FileUploadEvent event) {
                try {
                        final UploadedFile fisier = event.getFile();
                        // 19 es el id del tipodocumento para "template"
                        final TipDocument tip = TipDocument.builder().id(19L).build();
                        final Utilizator utilizator = (Utilizator) SecurityContextHolder.getContext()
                                        .getAuthentication().getPrincipal();
                        if (this.esteDocumentatie(fisier)) {
                                final Documentul documentul = this.documentService.incarcareDocument(fisier, tip,
                                                utilizator);
                                this.listaDocumente.add(documentul);
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constante.INREGISTRARE,
                                                "Fișierul/ele încărcat/e cu succes", Constante.MSGS);
                        }
                        else {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                Constante.INCARCAREFISIER,
                                                "Fișierul încărcat " + fisier.getFileName()
                                                                + " nu este valabil, numele sau extensia nu corespunde cu fișierul încărcat.",
                                                Constante.MSGS);
                        }
                }

                catch (DataAccessException | GesintException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        TipRegistruEnum.EROARE.name(), "A apărut o eroare la încărcarea fișierului. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la încărcarea fișierului";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                }

        }

        /**
         * Metoda care salveaza un fișier încărcat de utilizator ca document al cererii, după ce ați confirmat că nu
         * este un fișier corupt și că se potrivește cu oricare dintre cele solicitate.
         * @param event eveniment lansat din formular
         * @return ruta traseu
         */
        public void gestioneazaIncarcareDocumentMod(final FileUploadEvent event) {
                try {

                        final UploadedFile fisier = event.getFile();
                        // 19 es el id del tipodocumento para "template"
                        final TipDocument tip = TipDocument.builder().id(19L).build();
                        final Utilizator utilizator = (Utilizator) SecurityContextHolder.getContext()
                                        .getAuthentication().getPrincipal();
                        if (this.esteDocumentatie(fisier)) {
                                final Documentul documentul = this.documentService.incarcareDocument(fisier, tip,
                                                utilizator);
                                this.listaDocumente.add(documentul);
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constante.INREGISTRARE,
                                                "Fișierul/ele încărcat/e cu succes", Constante.MSGS);
                        }
                        else {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                Constante.INCARCAREFISIER,
                                                "Fișierul încărcat " + fisier.getFileName()
                                                                + " nu este valabil, numele sau extensia nu corespunde cu fișierul încărcat.",
                                                Constante.MSGS);
                        }
                }

                catch (DataAccessException | GesintException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        TipRegistruEnum.EROARE.name(), "A apărut o eroare la încărcarea fișierului. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la încărcarea fișierului";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
                }

        }

        /**
         * Metoda care transmite datele utilizatorului pe care dorim să le modificăm în formular.
         * @param usuario Utilizator recuperat din formularul de căutare al utilizatorului
         * @return URL-ul paginii de modificare a utilizatorului
         */
        public String getFormModificareCorespondenta(final Corespondenta corespo) {
                Corespondenta acomun = new Corespondenta();
                try {
                        acomun = corespondentaService.fiindOne(corespo);
                }

                catch (DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        TipRegistruEnum.EROARE.name(), "A apărut o eroare la căutarea corespondenței . "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la căutarea corespondenței ";
                        this.regActividadService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.CORESPONDENTA.getDescriere(), e);
                }
                String redirectionare = Constante.SPATIU;
                this.listaDocumente = new ArrayList<>();
                this.documenteIncarcate = new ArrayList<>();
                this.documenteIncarcate = documentService.findByCorespondenta(acomun);
                if (acomun != null) {
                        this.corespondenta = acomun;
                        redirectionare = "/corespondente/modificareCorespondenta?faces-redirect=true";
                }
                else {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.MODIFICAREMESAJ,
                                        "A apărut o eroare la accesarea corespondenței. Corespondența nu există.");
                }
                return redirectionare;
        }

        /**
         * Metoda care arata pagina pentru o noua corespondenta
         * @return String
         */
        public String getFormNouaCorespondenta() {
                this.corespondenta = new Corespondenta();
                this.utilizatorExtern = Constante.SPATIU;
                this.listaEchipa = new ArrayList<>();
                this.utilizatoriSelectionati = new ArrayList<>();
                this.listaDocumente = new ArrayList<>();
                this.documenteIncarcate = new ArrayList<>();
                this.utilizatoriSelectionatiFinali = new ArrayList<>();
                this.modelUser = new LazyDataUtilizatori(this.utilizatorService);
                final Calendar date = Calendar.getInstance();
                date.add(Calendar.DAY_OF_YEAR, 1);
                this.currentDate = date.getTime();
                return "/corespondente/nouaCorespondenta?faces-redirect=true";
        }

        /**
         * Metodă care recupereaza toate functiile centrale
         * @param "Conducerea Centrală"
         * @return lista List<Functie> lista cu functii centrale
         *
         */
        private List<Functie> incarcamToateFunctileCentrale() {
                List<Functie> listaPEchipa = new ArrayList<>();
                try {
                        listaPEchipa = pEchipaService.findByOrganization(Constante.CONDUCERECENTRALA);
                }

                catch (DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        TipRegistruEnum.EROARE.name(),
                                        "A apărut o eroare la căutarea funcților. ".concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la căutarea funcților";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }
                return listaPEchipa;
        }

        /**
         * Metodă care recuperează toate functiile locale
         * @param "Conducerea Locală"
         * @return lista List<Functie> lista cu functii locale
         *
         */
        private List<Functie> incarcamToateFunctileLocale() {
                return pEchipaService.findByOrganization(Constante.CONDUCERELOCALA);
        }

        /**
         * Metodă de încărcare a documentelor.
         */
        public void incarcareDocument() {
                for (final Documentul doc : this.listaDocumente) {
                        this.documenteIncarcate.add(doc);
                }
        }

        /**
         * @PostConstruct Metodă Init CorespondentaBean.
         */
        @PostConstruct
        public void init() {
                this.corespondenta = new Corespondenta();
                this.filtruCorespondenta = new FiltruCorespondenta();
                this.filtruUtilizator = new FiltruUtilizator();
                this.utilizatoriExterniSelectionati = utilizatorService.findByName();
                this.utilizatoriSelectionatiFinali = new ArrayList<>();
                this.echipa = new Echipa();
                this.numarMembrii = 0;
                this.judete = new ArrayList<>();
                this.listaFunctiiLocal = new ArrayList<>();
                this.list = new ArrayList<>();
                for (int i = 0; i < NUMARCOLOANE; i++) {
                        this.list.add(Boolean.TRUE);
                }
                this.model = new LazyDataCorespondente(this.corespondentaService);
                Utilitati.cautareSesiune("corespondentaBean");
        }

        /**
         * Metodă care asociază un utilizator când își selectează caseta de selectare pentru echipa de conducere.
         * @param event eveniment lansat care conține corespondenta
         */
        public void onRowSelectedTeam(final SelectEvent event) {
                final Echipa echipa = (Echipa) event.getObject();
                this.utilizatoriSelectionatiFinali.add(echipa.getUser());
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Metodă care asociază un utilizator când își selectează caseta de selectare pentru membrii.
         * @param event eveniment lansat care conține corespondenta
         */
        public void onRowSelectedUser(final SelectEvent event) {
                final Utilizator usu = (Utilizator) event.getObject();
                this.utilizatoriSelectionatiFinali.add(usu);
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Metodă care dezasociază un utilizator când deselectează caseta de selectare pentru echipa de conducere.
         * @param event eveniment lansat care conține corespondenta
         */
        public void onRowUnSelectedTeam(final UnselectEvent event) {
                final Echipa echipa = (Echipa) event.getObject();
                this.utilizatoriSelectionatiFinali.remove(echipa.getUser());
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Metodă care dezasociază un utilizator când deselectează caseta de selectare pentru membrii.
         * @param event eveniment lansat care conține corespondenta
         */
        public void onRowUnSelectedUser(final UnselectEvent event) {
                final Utilizator us = (Utilizator) event.getObject();
                this.utilizatoriSelectionatiFinali.remove(us);
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Controlează coloanele vizibile în lista rezultatelor motorului de căutare.
         * @param e ToggleEvent
         */
        public void onToggle(final ToggleEvent e) {
                this.list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" membrii equipei în vizualizarea
         * Avertizări.
         * @param toogleEvent ToggleSelectEvent
         */
        public void onToggleSelectTeam(final ToggleSelectEvent toogleEvent) {
                if (toogleEvent.isSelected()) {
                }
                else {
                        this.utilizatoriSelectionati = new ArrayList<>();
                }
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" membrii în vizualizarea
         * Avertizări.
         * @param toogleEvent ToggleSelectEvent
         */
        public void onToggleSelectUsers(final ToggleSelectEvent toogleEvent) {
                if (toogleEvent.isSelected()) {
                        this.utilizatoriSelectionati = new ArrayList<>(
                                        this.utilizatorService.cautareUtilizatorCriteria(this.filtruUtilizator));
                        for (final Utilizator user : this.utilizatoriSelectionati) {
                                user.getUsername();
                                if (!this.utilizatoriSelectionatiFinali.contains(user)) {
                                        this.utilizatoriSelectionatiFinali.add(user);
                                }
                        }
                }
                else {
                        this.utilizatoriSelectionati = new ArrayList<>();
                }
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" membrii în vizualizarea
         * Avertizări.
         * @param toogleEvent ToggleSelectEvent
         */
        public void onToggleSelectUsersCL(final ToggleSelectEvent toogleEvent) {
                if (toogleEvent.isSelected()) {
                        this.utilizatoriSelectionati = new ArrayList<>(listUsersLocal);
                        for (final Utilizator user : this.utilizatoriSelectionati) {
                                user.getUsername();
                                if (!this.utilizatoriSelectionatiFinali.contains(user)) {
                                        this.utilizatoriSelectionatiFinali.add(user);
                                }
                        }
                }
                else {
                        this.utilizatoriSelectionati = new ArrayList<>();
                }
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Metodă care salveaza corespondenta in baza de date.
         */
        public String salvareCorespondenta() {
                try {
                        if (!this.utilizatoriSelectionatiFinali.isEmpty() || corespondenta.getDestinatari() != null) {

                                // Daca venim de modificare
                                if (corespondenta.getDestinatari() == null) {
                                        String destina = Constante.SPATIU;
                                        final StringBuilder destinatari = new StringBuilder();
                                        for (final Utilizator usu : utilizatoriSelectionatiFinali) {
                                                destinatari.append(Constante.VIRGULA);
                                                destinatari.append(usu.getUsername());
                                        }
                                        destina = destinatari.toString().substring(1);
                                        corespondenta.setDestinatari(destina);
                                }
                                corespondenta.setTitlu(corespondenta.getTipCorespondenta().getDescription()
                                                .concat(Constante.PUNCTSPATIU).concat(corespondenta.getTitlu()));
                                corespondenta.setCanal(CanalAlertaEnum.EMAIL);
                                corespondenta.setDescriere(this.corespondenta.getDescriere());
                                if (this.corespondenta.getAutomatic()) {
                                        corespondenta.setAutomatic(true);
                                        corespondenta.setDataTrimiteri(this.corespondenta.getDataTrimiteri());
                                }
                                else {
                                        corespondenta.setAutomatic(false);
                                }
                                corespondentaService.save(corespondenta);
                                if (!this.documenteIncarcate.isEmpty()) {
                                        for (final Documentul documentul : documenteIncarcate) {
                                                documentul.setCorespondenta(corespondenta);
                                                documentul.setValidat(true);
                                                documentService.save(documentul);
                                        }
                                }
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                Constante.INREGISTRARE,
                                                "Comunicarea electonică a fost salvată cu succes.");
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ, "Nu se pot salva comunicări fara destinatari.");
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la salvarea Alertei/Comunicării "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        // this.registruActivitateService.salveazaRegistruEroare(SectiuniEnum.ALERTAS.name(),
                        // Constante.ALERTA, e);
                }
                return "/corespondente/corespondente?faces-redirect=true";
        }

        /**
         * Metoda de a adăuga noi utilizatori la lista de utilizatori selectați.
         */
        public void schimbarePaginaUtilizatori() {
                if ((this.utilizatoriSelectionati != null) && !this.utilizatoriSelectionati.isEmpty()) {
                        this.utilizatoriSelectionatiFinali.addAll(this.utilizatoriSelectionati);
                        this.utilizatoriSelectionati = new ArrayList<>(this.utilizatoriSelectionatiFinali);
                }
        }

        /**
         * Metoda de stabilire a utilizatorilor în lista generală.
         */
        public void stabilireUtilizatoriFinali() {
                final Utilizator usua = new Utilizator();
                if (this.opcion == NumarMagic.NUMBERTWO) {
                        for (final Utilizator user : this.utilizatoriSelectionati) {
                                user.getUsername();
                                if (!this.utilizatoriSelectionatiFinali.contains(user)) {
                                        this.utilizatoriSelectionatiFinali.add(user);
                                }
                        }
                }
                else if (this.opcion == NumarMagic.NUMBERFOUR) {
                        if (utilizatorExtern != null) {
                                final String[] chei = utilizatorExtern.split(Constante.VIRGULA);
                                for (final String cheie : chei) {
                                        final String nume = cheie.trim();
                                        final Utilizator usu = utilizatorService.fiindOne(nume);
                                        if (usu == null) {
                                                usua.setUsername(nume);
                                                usua.setDestinatarExtern(true);
                                                usua.setAdresa(null);
                                                usua.setCanalCorespondenta(CanalAlertaEnum.EMAIL);
                                                usua.setDataNasterii(new Date());
                                                usua.setStatutCivil(null);
                                                usua.setEducatie(EducatieEnum.NESPECIFICAT);
                                                usua.setEmail(nume);
                                                usua.setCodJudet(null);
                                                usua.setIdCard(null);
                                                usua.setPrenume("VIA EMAIL");
                                                usua.setLocalitate(null);
                                                usua.setNume(Constante.DESTINATAR);
                                                usua.setNumarCard(null);
                                                usua.setPassword(
                                                                "$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
                                                usua.setPersonalEmail(nume);
                                                usua.setPhone(null);

                                                usua.setRole(RolEnum.ROLE_SIMPATIZANT);
                                                usua.setSex(null);
                                                usua.setValidat(false);
                                                usua.setLocMunca(null);
                                                utilizatorService.save(usua);
                                                if (!this.utilizatoriSelectionatiFinali.contains(usua)) {
                                                        this.utilizatoriSelectionatiFinali.add(usua);
                                                }
                                        }

                                        else {
                                                if (!this.utilizatoriSelectionatiFinali.contains(usu)) {
                                                        this.utilizatoriSelectionatiFinali.add(usu);
                                                }
                                        }
                                }
                        }
                }
                else {
                        for (final Utilizator user : this.utilizatoriSelectionati) {
                                user.getUsername();
                                if (!this.utilizatoriSelectionatiFinali.contains(user)) {
                                        this.utilizatoriSelectionatiFinali.add(user);
                                }
                        }
                }
        }

        /**
         * Metodă care trimite corespondenta destinatarilor indicați.
         * @throws PebbleException
         */
        public String trimiteCorespondenta() throws PebbleException {
                final Map<String, String> paramPlantilla = new HashMap<>();
                String destina = Constante.SPATIU;
                final StringBuilder destinatari = new StringBuilder();
                try {
                        if (this.utilizatoriSelectionatiFinali.isEmpty()) {
                                Utilizator utilizator = this.utilizatorService.fiindOne(this.numeUtilizator);
                                if (utilizator == null) {
                                        utilizator = new Utilizator();
                                        utilizator.setCanalCorespondenta(CanalAlertaEnum.EMAIL);
                                        utilizator.setUsername(this.numeUtilizator);
                                }
                                this.utilizatoriSelectionatiFinali.add(utilizator);

                        }

                        final String titlu = corespondenta.getTipCorespondenta().getDescription()
                                        .concat(Constante.PUNCTSPATIU).concat(corespondenta.getTitlu());
                        paramPlantilla.put("titlu", titlu);
                        paramPlantilla.put("secretariat", "secretariat@per.ro");
                        paramPlantilla.put("telefon", "0733.061.651");
                        paramPlantilla.put("cuerpo", corespondenta.getDescriere());

                        corespondenta.setTitlu(corespondenta.getTipCorespondenta().getDescription()
                                        .concat(Constante.PUNCTSPATIU).concat(corespondenta.getTitlu()));
                        corespondenta.setDataTrimiteri(new Date());
                        corespondenta.setCanal(CanalAlertaEnum.EMAIL);
                        for (final Utilizator usu : utilizatoriSelectionatiFinali) {
                                destinatari.append(Constante.VIRGULA);
                                destinatari.append(usu.getUsername());
                        }
                        destina = destinatari.toString().substring(1);
                        corespondenta.setDestinatari(destina);
                        this.corespondentaService.save(corespondenta);
                        this.corespondentaService.trimitereCorespondenta(this.corespondenta,
                                        this.utilizatoriSelectionatiFinali, documenteIncarcate,
                                        Constante.TEMPLATEEMAILBASE, paramPlantilla);

                        // Comprbar que la lista no es vacia
                        if (!documenteIncarcate.isEmpty()) {
                                for (final Documentul doc : documenteIncarcate) {
                                        doc.setCorespondenta(corespondenta);
                                        doc.setValidat(true);
                                        doc.setDescriere("Document anexat la trimiterea e-mailului :"
                                                        .concat(corespondenta.getTitlu()));
                                        documentService.save(doc);
                                }
                        }
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.TRIMITEREALERTA,
                                        "Corespondența electronică a fost trimisă corect.");
                        this.curatareFiltre();
                }
                catch (

                final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la trimiterea corespondenței electronice"
                                                        .concat(Constante.DESCEROAREMESAJ));
                }
                return "/corespondente/corespondente?faces-redirect=true";
        }

}

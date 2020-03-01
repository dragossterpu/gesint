package ro.stad.online.gesint.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.poi.util.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataUtilizatori;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Echipa;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;
import ro.stad.online.gesint.services.EchipaService;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.LocalitateService;
import ro.stad.online.gesint.services.ParamEchipaService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Clase utilizada pentru a incarca date in pagina de echipa PER.
 *
 * @author STAD
 *
 */
@Component("echipaBean")
@Setter
@Getter
@NoArgsConstructor
@Scope(Constante.SESSION)
@Slf4j
public class EchipaBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Lista de elemente vizibile.
         */
        private List<Boolean> list;

        /**
         * Variala utilizata pentruinjectarea serviciului de echipa.
         *
         */
        @Autowired
        private transient EchipaService echipaService;

        /**
         * Variala utilizata pentruinjectarea serviciului de echipa.
         *
         */
        @Autowired
        private transient ParamEchipaService pEchipaService;

        /**
         * Lista utilizatorilor selectați.
         */
        private List<Utilizator> utilizatoriSelectionatiFinali;

        /**
         * Numele de utilizator care va fi folosit pentru al inregistra in echipa.
         */
        private String numeUtilizator = Constante.SPATIU;

        /**
         * Lazy model pentru utilizatori.
         */
        private transient LazyDataUtilizatori modelUser;

        /**
         * Service de utilizatori.
         */
        @Autowired
        private transient UtilizatorService utilizatorService;

        /**
         * Membru nou in echipa de conducere.
         */
        private transient Echipa echipa;

        /**
         * Functii in echipa de conducere.
         */
        private transient Functie functia;

        /**
         * Clasa de căutare a utilizatorului.
         */
        private FiltruUtilizator filtruUtilizator;

        /**
         * Lista utilizatorilor selectați.
         */
        private List<Utilizator> utilizatoriSelectionati;

        /**
         * Lista judetelor.
         */
        private List<Judet> listaJudete;

        /**
         * Judetul selectațat.
         */
        private Judet judetSelectat;

        /**
         * Variabila utilizata pentru a injecta serviciul provinciei.
         *
         */
        @Autowired
        private transient JudetService judetService;

        /**
         * Variabila utilizata pentru a injecta serviciul provinciei.
         *
         */
        @Autowired
        private transient LocalitateService localitateService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Lista numelor din echipa de conducere.
         */
        private List<Echipa> listaEchipa;

        /**
         * Lista pozitiilor membrilor din echipa de conducere.
         */
        private List<Echipa> listaPozitie;

        /**
         * Lista numelor din echipa de conducere.
         */
        private List<Functie> listaFunctii;

        /**
         * Indică dacă doriți să căutați după datele utilizatorului (opțiunea 1).
         */
        private Integer opcion = NumarMagic.NUMBERONE;

        /**
         * Variabila utilizata pentru un utilizator.
         *
         */
        private Utilizator user;

        /**
         * Fotografia utilizator.
         */
        private byte[] imagineSelectata;

        /**
         * Lista de localitati.
         */
        private List<Localitate> localitati;

        /**
         * Lista de localitati.
         */
        private List<Localitate> localitatiSelectate;

        /**
         * Lista de judete.
         */
        private List<Judet> judete;

        /**
         * Variabilă folosită pentru a stoca TipLocalitateEnum.
         *
         */
        private TipLocalitateEnum tipLocalitateSelectat;

        /**
         * Numele documentului
         */
        private String numeDoc;

        /**
         * Mesaj de eroare afișat utilizatorului.
         */
        private transient String mesajEroare;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private transient Utilitati utilitati;

        /**
         * Metodă care deschide dialogul de căutare al utilizatorilor.
         */
        public void deschideDialogCautareUtilizatori() {
                this.functia = new Functie();
                try {
                        this.listaJudete = this.judetService.fiindAll();
                        this.listaEchipa = this.echipaService.fiindByTeam();
                        this.listaFunctii = this.pEchipaService.fiindAll();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la dechiderea cautarii utilizator";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));

                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                this.modelUser = new LazyDataUtilizatori(utilizatorService);
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute(Constante.DIALOGCAUTARE);
        }

        /**
         * Deschide dialogul pentru pozitionarea membrilor.
         */
        public void deschideDialogoModificareMembru(final Echipa echip) {
                this.echipa = new Echipa();
                this.echipa = echip;
                this.listaFunctii = new ArrayList<>();
                try {
                        this.listaFunctii = this.pEchipaService.fiindAll();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la deschiderea dialogului modificării utilizatorului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));

                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgModifica').show();");
        }

        /**
         * Deschide dialogul pentru pozitionarea membrilor.
         */
        public void deschideDialogOrdenaMembru() {
                try {
                        this.listaEchipa = echipaService.fiindByTeam();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la deschiderea dialogului ordonează utilizatorul";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));

                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgOrdena').show();");
        }

        /**
         * Cautată un utilizator cu cnp-ul și returneaza adevărat sau fals.
         * @return boolean
         */
        private boolean cautareUtilizatorPorNif() {
                Boolean resultat = true;
                final Utilizator use = this.utilizatorService.findByIdCard(this.user.getIdCard());
                if (use != null && !use.getIdCard().equals(this.user.getIdCard())) {
                        resultat = false;
                }
                return resultat;
        }

        /**
         * Căută utilizatori pe baza unui filtru.
         */
        public void cautareUtilizatori() {
                this.modelUser.setFiltruUtilizator(this.filtruUtilizator);
                this.modelUser.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
        }

        /**
         * Căută utilizatori pe baza unui filtru.
         * @return
         */
        public List<Utilizator> cautareUtilizatoriL() {
                this.modelUser.setFiltruUtilizator(this.filtruUtilizator);
                return this.modelUser.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING,
                                null);
        }

        /**
         * Metodă care încarcă un document primit printr-un event FileUploadEvent. Această încărcare se face pe obiectul
         * document și nu este salvată în baza de date. Se verifică dacă tipul de document corespunde.
         * @param event FileUploadEvent Event care este lansat în încărcarea documentului
         * @throws IOException
         */
        public void incarcareImagine(final FileUploadEvent event) throws IOException {
                this.numeDoc = Constante.SPATIU;
                final UploadedFile uFile = event.getFile();
                try {
                        this.user = this.utilizatorService
                                        .incarcareImaginaFaraStocare(IOUtils.toByteArray(uFile.getInputstream()), user);
                        this.numeDoc = uFile.getFileName();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la la încărcarea imaginii";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă care elimină un membru al echipei.
         * @param echipa membru candidat pentru eliminare
         */
        public void eliminarMembru(final Utilizator membru) {
                Utilizator user = this.utilitati.getUtilizatorLogat();
                try {
                        Echipa echip = this.echipaService.findByUser(membru);
                        this.echipaService.delete(echip);
                        this.listaEchipa.remove(echip);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.ELIMINARE.getDescriere(), Constante.OKELIMINAREMESAJ);
                        final String descriere = Constante.UTILIZATORUL.concat(user.getNumeComplet())
                                        .concat(" a eliminat cu succes membrul: ".concat(
                                                        membru.getNumeComplet().concat(" din echipa de conducere: ")));
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.ELIMINARE.getName(), SectiuniEnum.USERS.getName(), user);
                        log.info(descriere);
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la eliminarea membrului din echipa de conducere.";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }

        }

        /**
         * Metoda de stabilire a utilizatorilor din lista generală.
         */
        public void stabilireUtilizatoriFinali() {
                this.utilizatoriSelectionatiFinali.add(this.user);
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
                this.utilizatoriSelectionatiFinali = this.utilizatoriSelectionati;
        }

        /**
         * Metodă care transmite datele membrului pe care dorim să le modificăm în formular.
         * @param usuario Utilizator recuperat din formularul de căutare al utilizatorului
         * @return URL-ul paginii de modificare a membrului
         */
        public String getFormModificareUser(final Echipa membru) {
                this.echipa = membru;
                this.user = membru.getUser();
                this.imagineSelectata = null;
                this.judetSelectat = new Judet();
                this.judetSelectat = this.user.getCodJudet();
                this.localitati = new ArrayList<>();
                try {
                        this.localitatiSelectate = this.localitateService.findByJudet(this.judetSelectat);
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la modificarea membrului echipei";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                this.judete = this.judetService.fiindAll();
                return "/teams/modifyTeam?faces-redirect=true";
        }

        /**
         * @PostConstruct Inițializarea datelor din bean.
         */
        @PostConstruct
        public void init() {
                this.filtruUtilizator = new FiltruUtilizator();
                this.user = new Utilizator();
                this.listaEchipa = new ArrayList<>();
                try {
                        this.listaEchipa = this.echipaService.fiindByTeam();
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la obținerea funcților echipei de conducere";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                this.functia = new Functie();
                this.list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                        this.list.add(Boolean.TRUE);
                }

                cautareFiltre();
                Utilitati.cautareSesiune("echipaBean");
        }

        /**
         * Curăță căutarea utilizatorilor
         */
        public void cautareFiltre() {
                this.filtruUtilizator = new FiltruUtilizator();
                this.user = new Utilizator();
                this.utilizatoriSelectionati = new ArrayList<>();
                this.modelUser = new LazyDataUtilizatori(this.utilizatorService);
        }

        /**
         * Curăță câmpurile utilizatorilor selectați și lista de utilizatori.
         */
        public void curatareCampuriNouaEchipa() {
                this.utilizatoriSelectionatiFinali = new ArrayList<>();
                this.modelUser = new LazyDataUtilizatori(this.utilizatorService);
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute(Constante.DIALOGMESGHIDE);
        }

        /**
         * Metodă care salează modificările utilizatorului.
         * @param usu Utilizator
         */
        public void modificareUtilizator(final Utilizator usu) {
                Utilizator utilizator = utilitati.getUtilizatorLogat();
                try {
                        this.user = usu;
                        if (valideaza()) {
                                this.user.setLocalitate(this.localitatiSelectate.get(0));
                                this.utilizatorService.save(this.user);
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                Constante.SCHIMBDATE, Constante.OKMODIFICAREMESAJ);
                                final String descriere = Constante.UTILIZATORUL.concat(usu.getNumeComplet())
                                                .concat(" a fost modificat cu succes de: ")
                                                .concat(utilizator.getUsername());
                                this.regActividadService.inregistrareRegistruActivitate(descriere,
                                                RegistruEnum.MODIFICARE.getName(), SectiuniEnum.USERS.getName(), user);
                                log.info(descriere);
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.SCHIMBDATE, Constante.DESCEROAREMESAJ);
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.SCHIMBDATE,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea utilizatorului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă care salvează sau modifică un membru.
         * @param membru Echipa
         */
        public void modificaTeam(final Echipa membru) {
                this.echipa = new Echipa();
                try {
                        this.echipa = membru;
                        this.echipaService.save(membru);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.SCHIMBDATE,
                                        Constante.OKMODIFICAREMESAJ);
                        final RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dlgModifica').hide();");
                        log.info("S-a modificat cu succes membrul echipei");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la salvarea/modificarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă care deschide pagina pentru a inregistra un nou membru.
         * @return String
         */
        public String nuevoMembru() {
                this.echipa = new Echipa();
                this.functia = new Functie();
                this.utilizatoriSelectionati = new ArrayList<>();
                this.utilizatoriSelectionatiFinali = new ArrayList<>();
                this.modelUser = new LazyDataUtilizatori(this.utilizatorService);
                return "/teams/newTeam?faces-redirect=true";
        }

        /**
         * Metodă de a adăuga noi utilizatori la lista de utilizatori selectați.
         */
        public void schimbarePaginaUtilizatori() {
                if (this.utilizatoriSelectionati != null && !this.utilizatoriSelectionati.isEmpty()) {
                        this.utilizatoriSelectionatiFinali.addAll(this.utilizatoriSelectionati);
                        this.utilizatoriSelectionati = new ArrayList<>(this.utilizatoriSelectionatiFinali);
                }
        }

        /**
         * Metodă care reordoneaza membrii echipei
         */
        public void onReorder() {
                try {
                        reordonareMembru();
                        final FacesContext facesContext = FacesContext.getCurrentInstance();
                        facesContext.addMessage(null,
                                        new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la reordonarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă care modifică descrierea unui membru al equipei.
         * @param event RowEditEvent event care capturează echipa
         */
        public void onRowEdit(final RowEditEvent event) {
                try {
                        final Echipa membrul = (Echipa) event.getObject();
                        this.echipa = membrul;
                        this.echipaService.save(this.echipa);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.OKMODIFICAREMESAJ,
                                        echipa.getTeam().getDescriere());
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă care asociază o inspecție când selectați caseta de selectare.
         * @param event eveniment lansat care conține utilizatorul
         */

        public void onRowSelectedUser(final SelectEvent event) {
                this.user = (Utilizator) event.getObject();
                this.utilizatoriSelectionatiFinali.add(this.user);
                this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
        }

        /**
         * Metodă care se execută la selectare.
         * @param event SelectEvent
         */
        public void onSelect(final SelectEvent event) {
                this.echipa = (Echipa) event.getObject();
        }

        /**
         * Metodă care controlează coloanele vizibile în lista rezultatelor motorului de căutare.
         * @param eve ToggleEvent
         */

        public void onToggle(final ToggleEvent eve) {
                this.list.set((Integer) eve.getData(), eve.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metodă care captează evenimentul "Selectați toate" sau "Deselectați toate" în vizualizarea Echipa.
         * @param toogleEvent ToggleSelectEvent
         */
        public void onToggleSelectUsers(final ToggleSelectEvent toogleEvent) {
                if (toogleEvent.isSelected()) {
                        this.utilizatoriSelectionatiFinali = cautareUtilizatoriL();
                        this.modelUser.setDsource(this.utilizatoriSelectionatiFinali);
                        this.utilizatoriSelectionati = new ArrayList<>(this.utilizatoriSelectionatiFinali);
                }
        }

        /**
         * Metodă care elimină un utilizator din lista utilizatorilor selectați pentru a fi in echipa de conducere.
         * @param user Utilizator
         */
        public void eliminareUtilizator(final Utilizator user) {
                this.utilizatoriSelectionatiFinali.remove(user);
        }

        /**
         * Metodă care care reordonează pozitia in lista
         * @throws DataAccessException excepție de acces la date
         */
        private void reordonareMembru() {
                try {
                        Echipa echipa;
                        for (int i = 0; i < this.listaEchipa.size(); i++) {
                                echipa = this.listaEchipa.get(i);
                                echipa.setRank(i + NumarMagic.NUMBERONELONG);
                                this.echipaService.save(echipa);
                                final RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dlgOrdena').hide();");
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la reordonarea echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Înregistrează utilizatorul indicat.
         */
        public String save() {
                String intoarcere = Constante.SPATIU;
                Utilizator utilizator = utilitati.getUtilizatorLogat();
                try {
                        if (this.utilizatoriSelectionatiFinali.isEmpty()) {
                                final Utilizator utiliz = this.utilizatorService.fiindOne(this.numeUtilizator);
                                if (utiliz != null) {
                                        this.utilizatoriSelectionatiFinali.add(utiliz);
                                }
                        }
                        for (final Utilizator use : this.utilizatoriSelectionatiFinali) {
                                final boolean existaUtilizator = this.echipaService.existsByUser(use);
                                if (existaUtilizator) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        " Nu se poate înregistra utilizatorul  '"
                                                                        .concat(use.getNume().concat(Constante.PUNCT))
                                                                        .concat(use.getPrenume())
                                                                        .concat("'  deoarece acesta există în echipa de conducere "),
                                                        Constante.SPATIU);

                                }
                                else {
                                        final Echipa tea = new Echipa();
                                        tea.setUser(use);
                                        final Functie pteam = new Functie();
                                        pteam.setId(this.echipa.getId());
                                        tea.setTeam(pteam);
                                        this.listaPozitie = this.echipaService.findAllByOrderByRankDesc();
                                        final Long rank = this.listaPozitie.get(0).getRank() + 1;
                                        tea.setRank(rank);
                                        this.echipaService.save(tea);
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                        RegistruEnum.INREGISTRARE.getDescriere(),
                                                        Constante.OKINREGISTRAREMESAJ);
                                        curatareCampuriNouaEchipa();
                                        this.listaEchipa = this.echipaService.fiindByTeam();
                                        final String descriere = Constante.UTILIZATORUL
                                                        .concat(tea.getUser().getNumeComplet())
                                                        .concat(" a fost inregistrat cu succes de: ")
                                                        .concat(utilizator.getUsername());
                                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                                        RegistruEnum.INREGISTRARE.getName(),
                                                        SectiuniEnum.ECHIPA.getName(), utilizator);
                                        log.info(descriere);
                                        final RequestContext context = RequestContext.getCurrentInstance();
                                        context.execute("PF('dialogCautare').hide();");
                                        intoarcere = "/teams/teams?faces-redirect=true";
                                }
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la salvarea membrului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                        intoarcere = "/teams/newTeam?faces-redirect=true";
                }
                return intoarcere;

        }

        /**
         * Metoda cu validările efectuate la salvarea datelor unui utilizator 1. Nume de utilizator nu se repetă 2. CNP
         * nu se repetă 3. CNP valabil
         * @return boolean
         */
        private boolean valideaza() {
                boolean validat = true;
                if (!valideazaUsername()) {
                        this.mesajEroare = "Membrul există deja în sistem";
                        validat = false;
                }
                if (!valideazaCnpUnic()) {
                        this.mesajEroare = "CNP-ul există deja în sistem";
                        validat = false;
                }
                return validat;
        }

        /**
         * Metodă de validare a unicității CNP.
         * @return boolean
         */
        private boolean valideazaCnpUnic() {
                boolean resultat = true;
                if (!StringUtils.isEmpty(this.user.getIdCard()) && this.user.getIdCard() != null) {
                        try {
                                resultat = cautareUtilizatorPorNif();
                        }
                        catch (final DataAccessException e) {
                                final String descriere = "A apărut o eroare la validarea cnp-ului membrului";
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(),
                                                descriere.concat(Constante.DESCEROAREMESAJ));
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.ECHIPA.getDescriere(), e);
                                log.error(descriere);
                        }
                }
                return resultat;
        }

        /**
         * Metoda de validare a unicității numelui de utilizator.
         * @return boolean
         */
        private boolean valideazaUsername() {
                boolean resultat = true;
                Utilizator use = null;
                try {
                        use = this.utilizatorService.fiindOne(this.user.getUsername());
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la căutarea utilizatorului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                if (use != null && !use.getUsername().equals(this.user.getUsername())) {
                        resultat = false;
                }
                return resultat;
        }

}

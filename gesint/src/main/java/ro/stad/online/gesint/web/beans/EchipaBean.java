package ro.stad.online.gesint.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

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
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataUtilizatori;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Echipa;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.CanalAlertaEnum;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.RolEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.SexEnum;
import ro.stad.online.gesint.persistence.entities.enums.StatutCivilEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;
import ro.stad.online.gesint.services.EchipaService;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.LocalitateService;
import ro.stad.online.gesint.services.ParamEchipaService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Generator;
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
        private JudetService judetService;

        /**
         * Variabila utilizata pentru a injecta serviciul provinciei.
         *
         */
        @Autowired
        private LocalitateService localitateService;

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
         * Metodă care deschide dialogul de căutare al utilizatorilor.
         */
        public void deschideDialogCautareUtilizatori() {
                functia = new Functie();
                listaJudete = judetService.fiindAll();
                listaEchipa = echipaService.fiindByTeam();
                listaFunctii = pEchipaService.fiindAll();
                modelUser = new LazyDataUtilizatori(utilizatorService);
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
                listaFunctii = pEchipaService.fiindAll();
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgModifica').show();");
        }

        /**
         * Deschide dialogul pentru pozitionarea membrilor.
         */
        public void deschideDialogOrdenaMembru() {
                listaEchipa = echipaService.fiindByTeam();
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgOrdena').show();");
        }

        /**
         * Metoda care da de alta utilizatori
         */
        public void alta() {
                String sex = null;
                Date data = null;
                int numero = 0;
                for (int i = 0; i < 1000; i++) {
                        numero = i;
                        final Utilizator user = new Utilizator();
                        user.setDateCreate(Generator.obtenerFechaRegistru());
                        user.setNume(Generator.apellidoFinal3().toUpperCase());

                        user.setPassword("$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
                        data = Generator.obtenerFechaNastere();
                        user.setDataNasterii(data);
                        user.setSex(SexEnum.randomLetter());
                        final Judet pro = new Judet();
                        pro.setIndicator(Generator.provinciasFinal());
                        user.setCodJudet(pro);
                        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                        final String anString = sdf.format(data);
                        if (user.getSex().getName().equals("MAN")) {
                                user.setPrenume(Generator.nombreFinalHombre());
                                if (Integer.valueOf(anString) >= 2000) {
                                        sex = "5";
                                }
                                else {
                                        sex = "1";
                                }
                        }
                        else {
                                user.setPrenume(Generator.nombreFinal());
                                if (Integer.valueOf(anString) >= 2000) {
                                        sex = "6";
                                }
                                else {
                                        sex = "2";
                                }
                        }
                        user.setEmail(mail(user.getNume(), user.getPrenume(), numero));
                        user.setIdCard(Generator.generaCnp(sex, data, pro));
                        user.setAdresa(Generator.numeStraziFinal().concat("  Nr: ").concat(Generator.getNumeroCalle()));

                        user.setStatutCivil(StatutCivilEnum.randomLetter());
                        if (user.getStatutCivil().equals(StatutCivilEnum.WIDOWED)) {
                                user.setStatutCivil(StatutCivilEnum.MARRIED);
                        }
                        user.setEducatie(EducatieEnum.randomLetter());

                        List<Localitate> loc = new ArrayList<>();
                        Long indice = Long.valueOf(Generator.getNumero());
                        if (pro.getIndicator().equals(Constante.IF)) {
                                indice = NumarMagic.NUMBERTWOLONG;
                        }
                        loc = localitateService.findByJudetAndNivel(pro, indice);
                        Localitate locality = new Localitate();
                        if (pro.getIndicator().equals(Constante.B)) {
                                Long id = null;
                                if (user.getIdCard().substring(NumarMagic.NUMBERSIX, NumarMagic.NUMBEREIGHT)
                                                .equals("41")) {
                                        id = NumarMagic.NUMBERSEVENTYTWOLONG;
                                }
                                else if (user.getIdCard().substring(NumarMagic.NUMBERSIX, NumarMagic.NUMBEREIGHT)
                                                .equals("42")) {
                                        id = NumarMagic.NUMBERSEVENTYTHREELONG;
                                }
                                else if (user.getIdCard().substring(NumarMagic.NUMBERSIX, NumarMagic.NUMBEREIGHT)
                                                .equals("43")) {
                                        id = NumarMagic.NUMBERSEVENTYFOURLONG;
                                }
                                else if (user.getIdCard().substring(NumarMagic.NUMBERSIX, NumarMagic.NUMBEREIGHT)
                                                .equals("44")) {
                                        id = NumarMagic.NUMBERSEVENTYFIVELONG;
                                }
                                else if (user.getIdCard().substring(NumarMagic.NUMBERSIX, NumarMagic.NUMBEREIGHT)
                                                .equals("45")) {
                                        id = NumarMagic.NUMBERSEVENTYSIXLONG;
                                }
                                else {
                                        id = NumarMagic.NUMBERSEVENTYSEVENLONG;
                                }
                                locality = localitateService.findById(Long.valueOf(id));
                        }
                        else {

                                final Random rand = new Random();
                                locality = loc.get(rand.nextInt(loc.size()));
                        }
                        user.setLocalitate(locality);
                        user.setNumarCard(Generator.getDni());
                        user.setPersonalEmail(user.getEmail());
                        user.setPhone(Generator.getTelefon());
                        user.setCanalCorespondenta(CanalAlertaEnum.EMAIL);
                        user.setValidat(true);
                        user.setLocMunca(Generator.meserii());
                        user.setUsername(user.getPersonalEmail());
                        user.setRole(RolEnum.ROLE_MEMBRU);
                        user.setUserCreate("system");
                        utilizatorService.save(user);
                }

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
                modelUser.setFiltruUtilizator(filtruUtilizator);
                modelUser.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
        }

        /**
         * Căută utilizatori pe baza unui filtru.
         * @return
         */
        public List<Utilizator> cautareUtilizatoriL() {
                modelUser.setFiltruUtilizator(filtruUtilizator);
                return modelUser.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
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
                        user = utilizatorService
                                        .incarcareImaginaFaraStocare(IOUtils.toByteArray(uFile.getInputstream()), user);
                        numeDoc = uFile.getFileName();
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la încărcarea imaginii. ".concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la la încărcarea imaginii";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă care elimină un membru al echipei.
         * @param echipa membru candidat pentru eliminare
         */
        public void eliminarMembru(final Utilizator membru) {
                try {
                        Echipa echip = new Echipa();
                        echip = echipaService.findByUser(membru);
                        echipaService.delete(echip);
                        listaEchipa.remove(echip);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.ELIMINAREMESAJ,
                                        Constante.OKELIMINAREMESAJ);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la eliminarea membrului echipei de conducere. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la eliminarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }

        }

        /**
         * Metoda de stabilire a utilizatorilor din lista generală.
         */
        public void stabilireUtilizatoriFinali() {
                utilizatoriSelectionatiFinali.add(user);
                modelUser.setDsource(utilizatoriSelectionatiFinali);
                this.utilizatoriSelectionatiFinali = utilizatoriSelectionati;
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
                judetSelectat = user.getCodJudet();
                this.localitati = new ArrayList<>();
                try {
                        localitatiSelectate = localitateService.findByJudet(judetSelectat);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la modificarea membrului echipei de conducere. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la modificarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }
                this.judete = judetService.fiindAll();
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
                this.listaEchipa = echipaService.fiindByTeam();
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
                filtruUtilizator = new FiltruUtilizator();
                user = new Utilizator();
                utilizatoriSelectionati = new ArrayList<>();
                modelUser = new LazyDataUtilizatori(utilizatorService);
        }

        /**
         * Curăță câmpurile utilizatorilor selectați și lista de utilizatori.
         */
        public void curatareCampuriNouaEchipa() {
                utilizatoriSelectionatiFinali = new ArrayList<>();
                modelUser = new LazyDataUtilizatori(utilizatorService);
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute(Constante.DIALOGMESGHIDE);
        }

        /**
         * Metodă care salează modificările utilizatorului.
         * @param usu Utilizator
         */
        public void modificareUtilizator(final Utilizator usu) {
                try {
                        this.user = usu;
                        if (valideaza()) {
                                user.setLocalitate(localitatiSelectate.get(0));
                                utilizatorService.save(user);
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                Constante.SCHIMBDATE, Constante.OKMODIFICAREMESAJ);
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
                        echipaService.save(membru);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.SCHIMBDATE,
                                        Constante.REGMODOK);
                        final RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dlgModifica').hide();");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la salvarea/modificarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă care deschide pagina pentru a inregistra un nou membru.
         * @return String
         */
        public String nuevoMembru() {
                echipa = new Echipa();
                functia = new Functie();
                utilizatoriSelectionati = new ArrayList<>();
                utilizatoriSelectionatiFinali = new ArrayList<>();
                modelUser = new LazyDataUtilizatori(utilizatorService);
                return "/teams/newTeam?faces-redirect=true";
        }

        /**
         * Metodă de a adăuga noi utilizatori la lista de utilizatori selectați.
         */
        public void schimbarePaginaUtilizatori() {
                if (utilizatoriSelectionati != null && !utilizatoriSelectionati.isEmpty()) {
                        utilizatoriSelectionatiFinali.addAll(utilizatoriSelectionati);
                        utilizatoriSelectionati = new ArrayList<>(utilizatoriSelectionatiFinali);
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
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la reordonarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
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
                        echipaService.save(echipa);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.REGMODOK,
                                        echipa.getTeam().getDescriere());
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea membrului echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă care asociază o inspecție când selectați caseta de selectare.
         * @param event eveniment lansat care conține utilizatorul
         */

        public void onRowSelectedUser(final SelectEvent event) {
                this.user = (Utilizator) event.getObject();
                utilizatoriSelectionatiFinali.add(user);
                modelUser.setDsource(utilizatoriSelectionatiFinali);
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
                        utilizatoriSelectionatiFinali = cautareUtilizatoriL();
                        modelUser.setDsource(utilizatoriSelectionatiFinali);
                        utilizatoriSelectionati = new ArrayList<>(utilizatoriSelectionatiFinali);
                }
        }

        /**
         * Metodă care elimină un utilizator din lista utilizatorilor selectați pentru a fi in echipa de conducere.
         * @param user Utilizator
         */
        public void eliminareUtilizator(final Utilizator user) {
                utilizatoriSelectionatiFinali.remove(user);
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
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la reordonarea echipei";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }
        }

        /**
         * Înregistrează utilizatorul indicat.
         */
        public String save() {
                String intoarcere = Constante.SPATIU;
                try {
                        if (utilizatoriSelectionatiFinali.isEmpty()) {
                                final Utilizator utiliz = utilizatorService.fiindOne(numeUtilizator);
                                if (utiliz != null) {
                                        utilizatoriSelectionatiFinali.add(utiliz);
                                }
                        }
                        for (final Utilizator user : utilizatoriSelectionatiFinali) {
                                final boolean existaUtilizator = echipaService.existsByUser(user);
                                if (existaUtilizator) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        " Nu se poate înregistra utilizatorul  '"
                                                                        + user.getNume().concat(Constante.PUNCT)
                                                                                        .concat(user.getPrenume())
                                                                        + "'  deoarece acesta există în echipa de conducere ",
                                                        "");

                                }
                                else {
                                        final Echipa tea = new Echipa();
                                        tea.setUser(user);
                                        final Functie pteam = new Functie();
                                        pteam.setId(echipa.getId());
                                        tea.setTeam(pteam);
                                        listaPozitie = echipaService.findAllByOrderByRankDesc();
                                        final Long rank = listaPozitie.get(0).getRank() + 1;
                                        tea.setRank(rank);
                                        echipaService.save(tea);
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                        Constante.INREGISTRAREMESAJ, Constante.OKINREGISTRAREMESAJ);
                                        curatareCampuriNouaEchipa();
                                        listaEchipa = echipaService.fiindByTeam();
                                        final RequestContext context = RequestContext.getCurrentInstance();
                                        context.execute("PF('dialogCautare').hide();");
                                        intoarcere = "/teams/teams?faces-redirect=true";
                                }
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la salvarea membrului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
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
                        validat = true;
                }
                if (!valideazaCnpUnic()) {
                        this.mesajEroare = "CNP-ul există deja în sistem";
                        validat = true;
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
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ,
                                                "A apărut o eroare la validarea cnp-ului membrului. "
                                                                .concat(Constante.DESCEROAREMESAJ));
                                final String descriere = "A apărut o eroare la validarea cnp-ului membrului";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.ECHIPA.getDescriere(), e);
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
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la căutarea utilizatorului. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la căutarea utilizatorului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.ECHIPA.getDescriere(),
                                        e);
                }
                if (use != null && !use.getUsername().equals(this.user.getUsername())) {
                        resultat = false;
                }
                return resultat;
        }

        /**
         * Obtener DNI.
         * @param prenume
         * @param nume
         * @return dni + letra
         */
        public static String mail(final String nume, final String prenume, final int numar) {
                final String numeCurat = Normalizer.normalize(nume.toLowerCase(), Normalizer.Form.NFD);
                final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                final String nnume = pattern.matcher(numeCurat).replaceAll(Constante.SPATIU);
                final String prenumaCurat = Normalizer.normalize(prenume.toLowerCase(), Normalizer.Form.NFD);
                final String pprenume = pattern.matcher(prenumaCurat).replaceAll(Constante.SPATIU);
                if (numar % NumarMagic.NUMBERTWO == 0) {
                        return nnume.concat(Constante.PUNCT).concat(pprenume.concat(Generator.nombresMail()));
                }
                else {
                        if (numar % NumarMagic.NUMBERSEVENTEEN == 0) {
                                return pprenume.substring(0, 1).concat(nnume.concat(Generator.nombresMail()));
                        }
                        return pprenume.concat(nnume.concat(Generator.nombresMail()));
                }
        }
}

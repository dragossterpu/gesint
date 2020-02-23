package ro.stad.online.gesint.web.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.poi.util.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.Visibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataUtilizatori;
import ro.stad.online.gesint.model.filters.FiltruEchipa;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.CanalAlertaEnum;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.LocalitateService;
import ro.stad.online.gesint.services.ParamEchipaService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Controlor de operațiuni legate de gestionarea utilizatorilor. Înregistrarea utilizatorilor, modificarea
 * utilizatorilor, ștergerea utilizatorilor, căutarea utilizatorilor, parola de căutare și restaurare.
 *
 * @author STAD
 */

@Setter
@Getter
@Controller("userBean")
@Scope(Constante.SESSION)

public class UtilizatorBean implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = NumarMagic.NUMBERELEVENLONG;

        /**
         * Constanta pentru logs
         */
        private static final Logger LOG = LoggerFactory.getLogger(UtilizatorBean.class.getSimpleName());

        /**
         * Numărul maxim de coloane vizibile.
         */
        private static final int NUMARTCOLOANELISTAUTILIZATORI = NumarMagic.NUMBERSEVEN;

        /**
         * Utilizator/Membru.
         */
        private Utilizator user;

        /**
         * Obiectul de cautare al utilizatorilor.
         */
        private FiltruUtilizator filtruUtilizator;

        /**
         * Obiectul de cautare al echipei.
         */
        private FiltruEchipa filtruEchipa;

        /**
         * Lista de judete.
         */
        private List<Judet> judete;

        /**
         * Lista de utilizatori locali.
         */
        private List<Utilizator> listUsersLocal;

        /**
         * Judet selectat.
         */
        private Judet judetSelect;

        /**
         * Judet.
         */
        private Judet judet;

        /**
         * Lista Booleans pentru controlul afișării coloanelor din vedere.
         */
        private List<Boolean> list;

        /**
         * LazyModel pentru paginarea de pe serverul de date de căutare a utilizatorilor.
         */
        private LazyDataUtilizatori model;

        /**
         * Serviciu de utilizatori.
         */
        @Autowired
        private UtilizatorService utilizatorService;

        /**
         * Variabila utilizata pentru a injecta serviciul provinciei.
         *
         */
        @Autowired
        private JudetService judetService;

        /**
         * Variabila utilizata pentru a injecta serviciul localitatilor.
         *
         */
        @Autowired
        private LocalitateService localitateService;

        /**
         * Variabila utilizata pentru a injecta serviciul functilor
         *
         */
        @Autowired
        private ParamEchipaService echipaService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Lista de localitati.
         */
        private List<Localitate> localitati;

        /**
         * Lista de localitati selectat.
         */
        private List<Localitate> localitatiSelectate;

        /**
         * Localitate aleasa.
         */
        private Localitate localitateSelectata;

        /**
         * Utilizator.
         */
        private Utilizator utilizator;

        /**
         * Utilizator pentru modificare.
         */
        private Utilizator utilizatorModificat;

        /**
         * Educatie
         */
        private EducatieEnum educatie;

        /**
         * Encryptor pentru cuvinte cheie.
         */
        @Autowired
        private transient BCryptPasswordEncoder passwordEncoder;

        /**
         * Mesaj de eroare afișat utilizatorului.
         */
        private transient String mesajEroare;

        /**
         * Variabilă folosită pentru a stoca grupul localitatii selectate.
         *
         */
        private Judet grupLocalitatiSelectate;

        /**
         * Variabilă folosită pentru a stoca tipul localitate selectat.
         *
         */
        private TipLocalitateEnum tipLocalitateSelectat;

        /**
         * Numele documentului.
         */
        private String numeDoc;

        /**
         * Fotoografia utilizator.
         */
        private byte[] imagineSelectata;

        /**
         * Identificatorul judetului
         */
        private String idJudet;

        /**
         * Identificatorul localitatii
         */
        private Long idLocalidad;

        /**
         * Data actuala
         */
        private Date currentDate;

        /**
         * eliminat
         */
        private Boolean eliminat;

        /**
         * Variabila pentru mesaj
         */
        private String mesaj;

        /**
         * Variabila pentru lista de functii existente in bbdd
         */
        private List<Functie> listaFunctii;

        /**
         * Variabila pentru lista de functii existente in bbdd
         */
        private List<Functie> listaFunctiiLocal;

        /**
         * Variabila pentru o functie existente in bbdd
         */
        private Functie pteam;

        /**
         * Text care identifică fila activă a formularului de statistici.
         */
        private String filaActiva;

        /**
         * Numar de membri in conducerea locala.
         */
        private int rowCountLocal;

        /**
         * Numar de membri in conducerea centrala.
         */
        private int rowCountCentral;

        /**
         * Variabila pentru lista de functii existente in bbdd
         */
        private List<Functie> listaFunctiiCentral;

        /**
         * Variabila pentru lista de functii existente in bbdd
         */
        private List<Utilizator> listUsersCentral;

        /**
         * Variabila pentru id-ul functiei unui membru
         */
        private Long functieIdUser;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private Utilitati utilitati;

        /**
         * Metodă folosită pentru a returna o listă a localităților care aparțin unui judet. Acesta este folosit pentru
         * a reîncărca lista localităților în funcție de judetul selectat.
         * @param localitati List<Localitate> lista de localitati
         */
        public List<Localitate> actualizareLocalitati(final String prov) {

                localitati = new ArrayList<>();
                this.judet = judetService.findById(prov);
                if (this.judet != null) {
                        try {
                                localitati = localitateService.findByJudet(judet);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                LOG.error("actualizareLocalitati: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare la căutarea localităților din județ";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                        }
                }
                return localitati;
        }

        /**
         * Metodă folosită pentru a returna o listă a localităților care aparțin unui judet. Acesta este folosit pentru
         * a reîncărca lista localităților în funcție de judetul selectat.
         * @param jude String
         * @return localitati List<Localitate> lista de localitati
         */
        public List<Localitate> actualLocalitati(final String jude) {
                localitati = new ArrayList<>();
                this.judet = judetService.findByName(jude);
                if (this.judet != null) {
                        try {
                                localitati = localitateService.findByJudet(judet);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                LOG.error("actualLocalitati: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare la căutarea localităților din județ";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                        }
                }
                return localitati;
        }

        /**
         * Metodă folosită pentru a deschide dialogul pentru a încărca o nouă imagine
         * @param utilizat Utilizator
         */
        public void arataDialogulNouaImagine(final Utilizator utilizat) {
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlg').show();");
        }

        /**
         * Metodă folosită pentru a sterge filtrul de căutare si rezultatele căutărilor anterioare.
         */
        public void cautareCautare() {
                filtruUtilizator = new FiltruUtilizator();
                filtruEchipa = new FiltruEchipa();
                listUsersLocal = new ArrayList<>();
                listUsersCentral = new ArrayList<>();
                rowCountLocal = 0;
                this.model = new LazyDataUtilizatori(this.utilizatorService);
                model.setRowCount(0);
        }

        /**
         * Metodă folosită pentru a căuta utilizatori în funcție de filtrele introduse în formularul de căutare.
         */
        public void cautareUtilizator() {
                if (user.getRole().getDescription().equals("Administrator")) {
                        model.setFiltruUtilizator(filtruUtilizator);
                }
                else {
                        filtruUtilizator.setIdJudet(user.getCodJudet().getIndicator());
                        model.setFiltruUtilizator(filtruUtilizator);
                }
                model.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
        }

        /**
         * Metodă folosită pentru a căuta utilizatori în funcție de filtrele introduse în formularul de căutare.
         */
        public List<Utilizator> cautareUtilizatoriCentral() {
                List<Utilizator> sefi = new ArrayList<>();
                rowCountCentral = 0;
                listUsersCentral = new ArrayList<>();
                filtruEchipa = new FiltruEchipa();
                List<Functie> lista = new ArrayList<>();
                lista = incarcamToateFunctileCentrale();
                filtruEchipa.setListaFunctii(lista);
                sefi = utilizatorService.cautareUtilizatorCriteriaLocal(filtruEchipa);
                rowCountCentral = sefi.size();
                listUsersCentral = sefi;
                return listUsersCentral;
        }

        /**
         * Metodă folosită pentru a căuta utilizatori locali în funcție de filtrele introduse în formularul de căutare.
         */
        public void cautareUtilizatorLocal() {
                rowCountLocal = 0;
                if (filtruEchipa.getIdFunctia() == null) {
                        List<Functie> lista = new ArrayList<>();
                        lista = incarcamToateFunctileLocale();
                        filtruEchipa.setListaFunctii(lista);
                }
                try {
                        listUsersLocal = utilizatorService.cautareUtilizatorCriteriaLocal(filtruEchipa);
                        rowCountLocal = listUsersLocal.size();
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la căutarea utilizatorilor cu funcții locale"
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la căutarea utilizatorilor cu funcții locale";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a căuta un utilizator cu cnp-ul și returneaza adevărat sau fals.
         * @return resultat boolean
         */
        private boolean cautareUtilizatorPorNif() {
                Boolean resultat = true;
                final Utilizator use = this.utilizatorService.findByIdCard(this.utilizator.getIdCard());
                if (use != null && !use.getIdCard().equals(this.utilizator.getIdCard())) {
                        resultat = false;
                }
                return resultat;
        }

        /**
         * Metodă folosită pentru a valida unicitatea numelui de utilizator.
         * @return resultat boolean
         */
        private boolean cnpCorect() {
                boolean resultat = true;
                if (validaSex() && valideazaAn()) {
                        resultat = true;
                }
                else {
                        resultat = false;
                }
                return resultat;
        }

        /**
         * Metodă folosită pentru a deschide dialogul pentru pozitionarea membrilor.
         * @param lista List<Utilizator>
         * @param jude String
         */
        public void deschideDialogOrdenaMembru(final List<Utilizator> lista, final String jude) {

                if (jude.equals(Constante.SPATIU)) {
                        listUsersLocal = new ArrayList<>();
                        filtruEchipa = new FiltruEchipa();
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "Pentru a putea poziționa membrii din conducerea unei organizații locale, trebuie să alegeți una!");
                }
                else {
                        listUsersLocal = lista;
                        final RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dlgOrdena').show();");
                }
        }

        /**
         * Metodă folosită pentru a deschide dialogul pentru pozitionarea membrilor.
         * @param lista List<Utilizator>
         */
        public void deschideDialogOrdenaMembruCC(final List<Utilizator> lista) {
                listUsersCentral = lista;
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgOrdenaCC').show();");
        }

        /**
         * Metodă folosită pentru a elimina sau adauga un membru în lista de conducere.
         * @param usu Utilizator
         */
        private void eliminaAdaugaMembruListaConducere(final Utilizator usu) {
                if (functieIdUser != usu.getTeam().getId()) {
                        final Functie vecheFunctie = echipaService.findById(functieIdUser);
                        if (functieIdUser != NumarMagic.NUMBERTHIRTYL
                                        && vecheFunctie.getOrganizatie().equals(Constante.CONDUCERECENTRALA)) {
                                listUsersCentral = cautareUtilizatoriCentral();
                                listUsersCentral.remove(usu);
                                reordonareMembruCC();
                                usu.setRank(null);
                        }
                        if (functieIdUser != NumarMagic.NUMBERTHIRTYL
                                        && vecheFunctie.getOrganizatie().equals(Constante.CONDUCERELOCALA)) {
                                listUsersLocal.remove(usu);
                                reordonareMembru();
                                usu.setRank(null);
                        }
                        Functie nouaFunctie = new Functie();
                        try {
                                nouaFunctie = echipaService.findById(usu.getTeam().getId());
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ,
                                                "A apărut o eroare la căutarea utilizatorilor cu funcții locale"
                                                                .concat(Constante.DESCEROAREMESAJ));
                                final String descriere = "A apărut o eroare la căutarea funcților.";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                        }
                        if (vecheFunctie.getId() != NumarMagic.NUMBERTHIRTYL
                                        && nouaFunctie.getOrganizatie().equals(Constante.CONDUCERECENTRALA)) {
                                listUsersCentral.add(usu);
                                usu.setRank(Long.valueOf(listUsersCentral.size() + 1));
                        }
                        if (vecheFunctie.getId() != NumarMagic.NUMBERTHIRTYL
                                        && nouaFunctie.getOrganizatie().equals(Constante.CONDUCERELOCALA)) {
                                listUsersLocal.add(usu);
                                usu.setRank(Long.valueOf(listUsersLocal.size() + 1));
                        }
                }
        }

        /**
         * Metodă folosită pentru a elimina un usuario.
         * @param usu Utilizator utilizatora eliminar
         */
        public void eliminareUtilizator(final Utilizator usu) {
                try {
                        this.utilizator = usu;
                        utilizator.setDateDeleted(new Date());
                        utilizator.setValidat(false);
                        utilizatorService.save(utilizator);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.ELIMINAREMESAJ,
                                        Constante.OKELIMINAREMESAJ);
                        LOG.info("eliminareUtilizator: userul:".concat(utilizator.getNumeComplet())
                                        .concat(" a fost eliminat de: ")
                                        .concat(utilitati.getUtilizatorLogat().getUsername()));
                        final String descriere = "Utillizatorul: " + usu.getNumeComplet()
                                        + " a fost eliminat cu succes " + " de: " + user.getUsername();
                        this.regActividadService.inregistrareRegistruActivitate(descriere, Constante.ELIMINARE,
                                        SectiuniEnum.USERS.getDescriere(), user);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("eliminareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la eliminarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a ractiva un usuario.
         * @param usu Utilizator utilizator reactivat
         */
        public void activareUtilizator(final Utilizator usu) {
                try {
                        this.utilizator = usu;
                        utilizator.setDateDeleted(null);
                        utilizator.setValidat(true);
                        utilizatorService.save(utilizator);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.ELIMINAREMESAJ,
                                        Constante.OKELIMINAREMESAJ);
                        LOG.info("activareUtilizator: userul:".concat(utilizator.getNumeComplet())
                                        .concat(" a fost activat de: ")
                                        .concat(utilitati.getUtilizatorLogat().getUsername()));
                        final String descriere = "Utillizatorul: " + usu.getNumeComplet()
                                        + " a fost reactivat cu succes " + " de: " + user.getUsername();
                        this.regActividadService.inregistrareRegistruActivitate(descriere, Constante.ELIMINARE,
                                        SectiuniEnum.USERS.getDescriere(), user);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("eliminareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la reactivarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a verifica daca mai exista un presedinte de filiala
         * @param usu Utilizator
         * @return validaPresedinte boolean
         */
        private boolean existPresedinte(final Utilizator usu) {
                Boolean validaPresedinte = true;
                // Verificam ca persoana care se doreste a modifica nu este presedinte de filiala
                try {
                        if (usu.getTeam() == null) {
                                final Functie functia = echipaService.findById(NumarMagic.NUMBERTHIRTYL);
                                usu.setTeam(functia);
                        }
                        if (usu.getTeam().getId() == NumarMagic.NUMBERONELONG) {
                                final Functie functia = echipaService.findById(NumarMagic.NUMBERONELONG);
                                final Utilizator presedinte = utilizatorService.findByTeam(functia);
                                if (presedinte == usu && presedinte != null) {
                                        validaPresedinte = false;
                                        mesaj = "Există un președinte al partidului. Dacă doriți să înlocuiți președintele actual trebuie să modificați membrul "
                                                        + presedinte.getNumeComplet();
                                }
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("verificareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la verificarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                return validaPresedinte;
        }

        /**
         * Metodă folosită pentru a verifica daca mai exista un presedinte de filiala.
         * @param usu Utilizator
         * @param jude Judet
         * @return validaPresedinte Boolean
         */
        private boolean existPresedinteLocal(final Utilizator usu, final Judet jude) {
                Boolean validaPresedinte = true;
                // Verificam ca persoana care se doreste a modifica nu este presedinte de filiala
                try {
                        if (usu.getTeam() == null) {
                                final Functie functia = echipaService.findById(NumarMagic.NUMBERTHIRTYL);
                                usu.setTeam(functia);
                        }
                        if (usu.getTeam().getId() == NumarMagic.NUMBERTWENTYONELONG) {
                                final Functie functia = echipaService.findById(NumarMagic.NUMBERTWENTYONELONG);
                                final Utilizator presedinte = utilizatorService.findByTeamAndJudet(functia, jude);
                                if (presedinte != usu && presedinte != null) {
                                        validaPresedinte = false;
                                        mesaj = "Există un președinte al organizației "
                                                        + presedinte.getCodJudet().getNume()
                                                        + " . Dacă doriți să înlocuiți președintele actual trebuie să modificați membrul "
                                                        + presedinte.getNumeComplet();
                                }
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("verificareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la verificarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                return validaPresedinte;
        }

        /**
         * Metodă folosită pentru a obține localitatile dupa un judet
         */
        private void extractLocalitati() {
                if (this.filtruUtilizator.getJudetSelectat() != null) {
                        try {
                                localitati = localitateService.findByJudet(grupLocalitatiSelectate);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ,
                                                "A apărut o eroare în căutatrea localităților care aparțin județului."
                                                                .concat(Constante.DESCEROAREMESAJ));
                                LOG.info("extractLocalitati: ".concat(
                                                "A apărut o eroare în căutatrea localităților care aparțin județului."));
                                final String descriere = "A apărut o eroare în căutatrea localităților care aparțin județului.";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                        }
                }
        }

        /**
         * Metodă folosită pentru a dechide formularul de înregistrare al utilizatorilor noi, inițializând tot ceea ce
         * este necesar pentru afișarea corectă a paginii (enums, utilizator nou,..etc).
         * @return url-ul páginii de inregistrare utilizator
         */
        public String getFormInregistrareUtilizator() {
                this.utilizator = new Utilizator();
                this.imagineSelectata = null;
                judetSelect = new Judet();
                localitati = new ArrayList<>();
                this.idLocalidad = null;
                this.idJudet = null;
                listaFunctii = new ArrayList<>();
                listaFunctii = echipaService.fiindAll();
                try {
                        setJudete(judetService.fiindAll());
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("getFormInregistrareUtilizator: setjudete: ".concat(String.valueOf(e)));
                }
                // Minor de varsta
                final Calendar date = Calendar.getInstance();
                date.add(Calendar.YEAR, -NumarMagic.NUMBEREIGHTEEN);
                this.currentDate = date.getTime();
                return "/users/saveUser.xhtml?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a transmite datele utilizatorului pentru a le modifica.
         * @param usua Utilizator recuperat din formularul de căutare al utilizatorului
         * @return URL-ul paginii de modificare a utilizatorului
         */
        public String getFormModificareUser(final Utilizator usua) {
                functieIdUser = 0L;
                this.utilizatorModificat = new Utilizator();
                String redireccion = Constante.SPATIU;
                try {
                        final Utilizator usu = utilizatorService.fiindOne(usua.getUsername());
                        this.utilizatorModificat = usu;
                        listaFunctii = new ArrayList<>();
                        listaFunctii = echipaService.fiindAll();
                        if (usu != null) {
                                functieIdUser = usu.getTeam().getId();
                                this.utilizator = usua;
                                judetSelect = utilizator.getCodJudet();
                                setLocalitati(localitateService.findByJudet(utilizator.getCodJudet()));
                                if (utilizator.getLocalitate() == null) {
                                        for (final Localitate lacal : localitati) {
                                                if (lacal.getResedinta()) {
                                                        utilizator.setLocalitate(lacal);
                                                        break;
                                                }
                                        }
                                }
                                redireccion = "/users/modifyUser?faces-redirect=true";
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.MODIFICAREMESAJ,
                                                "A apărut o eroare la accesarea membrului. Membrul nu există.");
                                LOG.info("getFormModificareUser: "
                                                .concat("A apărut o eroare la accesarea membrului. Membrul nu există"));
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("getFormInregistrareUtilizator: setjudete: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la accesarea membrului. Membrul nu există.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                return redireccion;
        }

        /**
         * Metodă folosită pentru a obține imaginea pentru a previzualiza în cazul în care documentul este de tip
         * imagine..
         * @return StreamedContent
         */
        public StreamedContent getImageUserSelected() {
                return new DefaultStreamedContent(new ByteArrayInputStream(this.imagineSelectata));
        }

        /**
         * Metodă folosită pentru returna formularul de căutare utilizator în starea sa inițială și șterge rezultatele
         * căutărilor anterioare dacă este navigat din meniu sau dintr-o altă secțiune.
         * @return pagina de căutare a utilizatorilor
         */
        public String getSearchFormUsers() {
                cautareCautare();
                return "/users/users.xhtml?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a afișa profilul utilizatorului
         * @return URL-ul paginii unde se vede profilul utilizatorului.
         */
        public String getUserProfil() {
                final String username = SecurityContextHolder.getContext().getAuthentication().getName();
                try {
                        user = utilizatorService.fiindOne(username);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroar în căutatrea membrului.".concat(Constante.DESCEROAREMESAJ));
                        LOG.error("getUserProfil: ".concat("A apărut o eroar în căutatrea membrului.")
                                        .concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la accesarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                return "/principal/miPerfil?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a încarca toate functiile centrale
         * @return lista List<Functie> lista cu toate functiile
         */
        private List<Functie> incarcamToateFunctileCentrale() {
                return echipaService.findByOrganization(Constante.CONDUCERECENTRALA);
        }

        /**
         * Metodă folosită pentru a încarca toate functiile locale
         * @return lista List<Functie> lista cu toate functiile
         */
        private List<Functie> incarcamToateFunctileLocale() {
                return echipaService.findByOrganization(Constante.CONDUCERELOCALA);
        }

        /**
         * Metodă folosită pentru a încarca datele personale ale utilizatorului
         * @param judet Judet
         * @param nuevaLocalidad Localitate
         * @param utilizat Utilizator
         */
        private void incarcareDatePersonaleUser(final Judet judet, final Localitate nuevaLocalidad,
                        final Utilizator utilizat) {
                utilizator.setLocalitate(nuevaLocalidad);
                utilizator.setCodJudet(judet);

        }

        /**
         * Metodă folosită pentru a încarca document primit printr-un event FileUploadEvent. Se verifică dacă tipul de
         * document corespunde.
         * @param event FileUploadEvent event care este lansat în încărcarea documentului.
         * @throws IOException
         */
        public void incarcareImagine(final FileUploadEvent event) throws IOException {
                final UploadedFile uFile = event.getFile();
                this.utilizator = utilizatorService
                                .incarcareImaginaFaraStocare(IOUtils.toByteArray(uFile.getInputstream()), utilizator);
                numeDoc = uFile.getFileName();
        }

        /**
         * Metodă folosită pentru a inițializa UtilizatorBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                this.tipLocalitateSelectat = null;
                utilizator = new Utilizator();
                utilizatorModificat = new Utilizator();
                eliminat = false;
                judete = new ArrayList<>();
                user = utilizatorService.fiindOne(SecurityContextHolder.getContext().getAuthentication().getName());
                if (user.getRole().getDescription().equals("Administrator")) {
                        this.judete = judetService.fiindAll();
                }
                else {
                        judete.add(user.getCodJudet());
                }
                listUsersLocal = new ArrayList<>();
                localitati = new ArrayList<>();
                judet = new Judet();
                judetSelect = new Judet();
                filtruUtilizator = new FiltruUtilizator();
                filtruEchipa = new FiltruEchipa();
                rowCountLocal = 0;
                cautareCautare();
                list = new ArrayList<>();
                for (int i = 0; i <= NUMARTCOLOANELISTAUTILIZATORI; i++) {
                        list.add(Boolean.TRUE);
                }
                this.model = new LazyDataUtilizatori(utilizatorService);

                extractLocalitati();
                listaFunctii = new ArrayList<>();
                listaFunctii = echipaService.fiindAll();
                listaFunctiiLocal = new ArrayList<>();
                listaFunctiiLocal = echipaService.fiindAllByParam();
                listUsersCentral = new ArrayList<>();
                Utilitati.cautareSesiune("userBean");
        }

        /**
         * Metodă folosită pentru a înregistra un utilizator.
         * @param usu User
         */
        public void inregistrareUtilizator(final Utilizator usu) {
                try {
                        this.utilizator = new Utilizator();
                        this.utilizator = usu;
                        final String valida = Constante.INREGISTRAREMESAJ;
                        // Validam noul utilizator
                        if (validar(valida)) {
                                utilizator.setLocalitate(localitateService.findById(idLocalidad));
                                utilizator.setEmail(utilizator.getUsername());
                                utilizator.setValidat(true);
                                utilizator.setCodJudet(judetService.findById(idJudet));
                                utilizator.setCanalCorespondenta(CanalAlertaEnum.EMAIL);
                                utilizator.setPassword("$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
                                utilizatorService.save(utilizator);
                                final String mesaj = "A fost întregistrat utilizatorul :" + utilizator.getNumeComplet();
                                regActividadService.salveazaRegistruInregistrareModificare(null,
                                                SectiuniEnum.USERS.getDescriere(), Constante.INREGISTRAREMESAJ, mesaj);
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                Constante.SCHIMBDATE, Constante.OKMODIFICAREMESAJ);
                                final String descriere = "Noul utilizator a fost înregistrat cu succes";
                                this.regActividadService.inregistrareRegistruActivitate(descriere,
                                                Constante.INREGISTRARE, SectiuniEnum.USERS.getDescriere(), user);
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ, this.mesajEroare);
                                LOG.info("inregistrareUtilizator: membrul nou: "
                                                .concat(utilizator.getNume().concat(Constante.SPATIUMARE))
                                                .concat(utilizator.getPrenume()).concat(" nu a fost validat"));

                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("înregistrareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la înregistrarea utilizatorului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a verifica dacă utilizatorul apaține conducerii locale.
         * @param usu Utilizator
         * @return isuserLocal Boolean
         */
        public Boolean isLocal(final Utilizator usu) {
                Boolean isuserLocal = false;
                try {
                        final Functie functie = echipaService.findByIdAndOrganization(usu.getTeam().getId(),
                                        Constante.CONDUCERELOCALA);
                        if (functie != null) {
                                isuserLocal = true;
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("verificareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la verificarea utilizatorului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                return isuserLocal;
        }

        /**
         * Metodă folosită pentru a salva modificările utilizatorului
         * @param usu Utilizator
         * @param jude String
         * @param local String
         */
        public void modificareUtilizator(final Utilizator usu, final String jude, final String local) {

                eliminaAdaugaMembruListaConducere(usu);
                Boolean validamLocal = true;
                Boolean validamCentral = true;
                String mesajModificare = mesajModificareUtilizator(usu);

                mesaj = Constante.SPATIU;
                if (usu.getTeam().getId() == NumarMagic.NUMBERTWENTYONELONG) {
                        validamLocal = existPresedinteLocal(usu, judet);
                }
                if (usu.getTeam().getId() == NumarMagic.NUMBERONELONG) {
                        validamCentral = existPresedinte(usu);
                }

                final String valida = Constante.MODIFICAREMESAJ;
                // verificam daca a fost modificat judetul
                if (!utilizatorModificat.getCodJudet().getNume().equals(jude)) {
                        obtinemJudetul(jude);
                }

                else {
                        // daca nu a fost modificat ramanem cu cel al utilizatorului
                        judet = utilizatorModificat.getCodJudet();
                }
                // verificam daca a fost modificata localitatea
                if (utilizatorModificat.getLocalitate() == null) {
                        List<Localitate> lista = localitateService.findByJudet(judet);
                        // Daca avem rezultate ..alegem proma localitate din lista
                        if (!lista.isEmpty()) {
                                localitateSelectata = lista.get(0);
                                utilizatorModificat.setLocalitate(localitateSelectata);
                        }
                }

                if (!utilizatorModificat.getLocalitate().getNume().equals(local)) {
                        // In cazul in care nu vine informata recupram prima localitate din judet
                        if (Constante.SPATIU.equals(local) && local == null) {
                                List<Localitate> lista = localitateService.findByJudet(judet);
                                // Daca avem rezultate ..alegem proma localitate din lista
                                if (!lista.isEmpty()) {
                                        localitateSelectata = lista.get(0);
                                }
                        }
                        else {
                                // Localitatea a fost modificata si o cautam in baza de date
                                localitateSelectata = localitateService.localidadByNumeIgnoreCaseAndJudet(local, judet);
                        }
                }
                else {
                        // Daca nu a fost modificata ..ramanem cu cea a utilizatorului
                        localitateSelectata = utilizatorModificat.getLocalitate();
                }
                try {
                        this.utilizator = usu;
                        if (validamLocal && validamCentral) {
                                if (validar(valida)) {
                                        if (eliminat == false) {
                                                utilizator.setDateDeleted(null);
                                        }
                                        else {

                                                utilizator.setDateDeleted(new Date());
                                        }
                                        utilizator.setLocalitate(localitateSelectata);
                                        utilizator.setCodJudet(judet);
                                        final Boolean esteLocal = isLocal(utilizator);
                                        if (utilizator.getRank() == null
                                                        && utilizator.getTeam().getId() != NumarMagic.NUMBERTHIRTYL) {
                                                if (esteLocal) {
                                                        List<Functie> lista = new ArrayList<>();
                                                        lista = incarcamToateFunctileLocale();
                                                        filtruEchipa.setListaFunctii(lista);
                                                        listUsersLocal = utilizatorService.findByJudetSiEchipa(judet,
                                                                        lista);
                                                        utilizator.setRank(Long.valueOf(listUsersLocal.size() + 1));
                                                }
                                                else {
                                                        listUsersCentral = cautareUtilizatoriCentral();
                                                        utilizator.setRank(Long.valueOf(listUsersCentral.size() + 1));
                                                }

                                        }
                                        utilizatorService.save(utilizator);
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                        Constante.SCHIMBDATE, Constante.REGMODOK);
                                        LOG.info("modificareUtilizator: user: ".concat(utilizator.getNumeComplet()));
                                        final String descriere = "Noul utilizator a fost modificat cu succes. Datele sunt următoarele: "
                                                        .concat(mesajModificare).concat(" modificate cu succes");
                                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                                        Constante.MODIFICAREMESAJ, SectiuniEnum.USERS.getDescriere(),
                                                        user);
                                }
                                else {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        Constante.SCHIMBDATE, this.mesajEroare);
                                        LOG.info("modificareUtilizator: Eroare-Nu validează utilizator");
                                }
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                "Eroare în modificarea registrului", mesaj);
                                LOG.info("modificareUtilizator: Eroare-Nu validează. validam local si validam central");
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.SCHIMBDATE, "");
                        LOG.error("modificareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la modificarea utilizatorului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a înregistra o nouă localitate
         *
         * @param nume String numele localitatii noi
         * @param jude String judet carui ii apartine localitatea
         * @param tipLocalitate TipLocalitateEnum
         * @param utiliza Utilizator
         */
        public void nouaLocalitate(final String nume, final String jude, final TipLocalitateEnum tipLocalitate,
                        final Utilizator utiliza) {
                Boolean existeLocalidad = false;
                try {
                        this.judet = judetService.findByName(jude);
                        if (judet == null) {
                                this.judet = judetService.findById(jude);
                        }

                        existeLocalidad = localitateService.existeByNumeIgnoreCaseAndJudet(nume.trim(), judet);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                        "S-a produs o erroare în căutarea localitații. "
                                                        .concat(Constante.DESCEROAREMESAJ),
                                        null, "inputNume");
                        LOG.error("nouaLocalitate: S-a produs o erroare în căutarea localitații "
                                        .concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în căutarea localitații.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                this.tipLocalitateSelectat = null;
                tipLocalitateSelectat = tipLocalitate;
                if (existeLocalidad) {
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                        "Acțiunea nu este permisă. Există deja o localitate care aparține aceluiași județ cu același nume.",
                                        null, "inputNume");
                        LOG.info("nouaLocalitate: Acțiunea nu este permisă. Există deja o localitate care aparține aceluiași județ cu același nume");
                }
                else {
                        Localitate nuevaLocalidad;
                        try {
                                nuevaLocalidad = localitateService.crearLocalidad(nume, judet, tipLocalitateSelectat);
                                setLocalitati(localitateService.findByJudet(judet));
                                // Incarcam si salvam noua localitate in datele utilizatorului
                                incarcareDatePersonaleUser(judet, nuevaLocalidad, utiliza);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                "Eroare în salvarea localității. ".concat(Constante.DESCEROAREMESAJ),
                                                null, "inputNume");
                                LOG.error("nouaLocalitate: nuevaLocalidad: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare în salvarea localității.";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                        }
                }
        }

        /**
         * Metodă folosită pentru a obține județul
         * @param jude String
         */
        private void obtinemJudetul(final String jude) {
                if (jude.equals(Constante.SPATIU)) {
                        judet = judetSelect;
                }
                else {
                        judet = judetService.findByName(jude);
                }
        }

        /**
         * Metodă folosită pentru a repozitionarea.
         * @param event SelectEvent
         */
        public void onReorderCC() {
                try {
                        reordonareMembruCC();
                        cautareCautare();
                        FacesContext.getCurrentInstance();
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.OKMODIFICAREMESAJ,
                                        "Modificarea ordinii în listă a fost realizată cu succes!");
                        LOG.info("onReorderCC: Modificarea ordinii în listă a fost realizată cu succes!");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("onReorderCC: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repozitionarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a repozitionarea.
         * @param event SelectEvent
         */
        public void onReorderCL() {
                try {
                        reordonareMembru();
                        cautareCautare();
                        FacesContext.getCurrentInstance();
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.OKMODIFICAREMESAJ,
                                        "Modificarea ordinii în listă a fost realizată cu succes!");
                        LOG.info("onReorderCL: Modificarea ordinii în listă a fost realizată cu succes!");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("onReorderCL: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repozitionarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru selectare.
         * @param event SelectEvent
         */
        public void onSelect(final SelectEvent event) {
                utilizator = (Utilizator) event.getObject();
        }

        /**
         * Metodă folosită pentru a Activa /Dezactiva vizibilitatea coloanelor din tabelul cu rezultate.
         * @param e ToggleEvent checkbox al coloanei selectate
         */
        public void onToggle(final ToggleEvent e) {
                list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metodă folosită pentru a repozitiona un membru
         */
        private void reordonareMembru() {
                Utilizator user = new Utilizator();
                try {
                        for (int i = 0; i < this.listUsersLocal.size(); i++) {
                                user = listUsersLocal.get(i);
                                user.setRank(i + NumarMagic.NUMBERONELONG);
                                utilizatorService.save(user);
                                final RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dlgOrdena').hide();");
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("repozitionareaMembru: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repozitionarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a repozitiona un membru
         */
        private void reordonareMembruCC() {
                Utilizator user = new Utilizator();
                try {
                        for (int i = 0; i < this.listUsersCentral.size(); i++) {
                                user = listUsersCentral.get(i);
                                user.setRank(i + NumarMagic.NUMBERONELONG);
                                utilizatorService.save(user);
                                final RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dlgOrdenaCC').hide();");
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        LOG.error("reordonareMembruCC: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repozitionarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a genera o nouă parolă și a fi trimisă prin poștă către utilizator.
         * @return URL-ul paginii
         */
        public String restabilireParola() {
                try {
                        final String password = Utilitati.getPassword();
                        this.utilizator.setPassword(this.passwordEncoder.encode(password));
                        // final String cuerpoCorreo = "Noua dvs. parolă este: " + password;
                        this.utilizatorService.save(this.utilizator);
                        // this.correoService.trimitereEmail(this.usuario.getUsername(), "Restauración de la
                        // contraseña",
                        // cuerpoCorreo);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.PAROLA,
                                        "Un e-mail a fost trimis utilizatorului cu noua parolă");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.PAROLA,
                                        "A apărut o eroare în regenerarea sau trimiterea parolei. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        LOG.error("restabilireParola: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în regenerarea sau trimiterea parolei.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                return "/users/modifyUser?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru controlul modificării filei grupului de date (Utilizatori, Conducere locala sau
         * Conducere centrala).
         * @param event TabChangeEvent
         */
        public void schimbTipMembri(final TabChangeEvent event) {
                if ("membriSimpatizanti".equals(event.getTab().getId())) {
                        filtruUtilizator = new FiltruUtilizator();
                        filaActiva = Constante.TABMEMBRI;
                        cautareCautare();
                }
                else if ("conducereaLocala".equals(event.getTab().getId())) {
                        filtruUtilizator = new FiltruUtilizator();
                        filaActiva = Constante.TABLOCAL;
                        cautareCautare();
                }
                else {
                        filtruUtilizator = new FiltruUtilizator();
                        filaActiva = Constante.TABCONDUCERE;
                        cautareCautare();
                        listUsersCentral = cautareUtilizatoriCentral();
                }
        }

        /**
         * Metodă folosită pentru a valida datelor unui utilizatorla inregistrare 1. Numele de utilizator nu se repetă
         * 2. CNP nu se repetă 3. CNP valabil
         * @return boolean
         */
        private boolean validar(final String valida) {
                boolean validat = true;
                if (!valideazaUsername()) {
                        LOG.info("validar valideazaUsername: Membrul există deja în sistem");
                        this.mesajEroare = "Membrul există deja în sistem";
                        validat = false;
                }
                if (!valideazaCnpUnic()) {
                        if (valida.equals(Constante.INREGISTRAREMESAJ)) {
                                this.mesajEroare = "CNP-ul există deja în sistem";
                                LOG.info("validar valideazaCnpUnic: CNP-ul există deja în sistem");
                        }
                        else {
                                this.mesajEroare = "CNP-ul nu este corect.";
                                LOG.info("validar valideazaCnpUnic: CNP-ul nu este corect");
                        }
                        validat = false;
                }
                return validat;
        }

        /**
         * Metodă de validare a unicității CNP.
         * @return resultat boolean
         */
        private boolean valideazaCnpUnic() {
                boolean resultat = true;
                if (!StringUtils.isEmpty(this.utilizator.getIdCard()) && this.utilizator.getIdCard() != null) {
                        try {
                                if (cnpCorect()) {
                                        resultat = cautareUtilizatorPorNif();
                                }
                                else {
                                        resultat = false;
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        Constante.EROAREMESAJ,
                                                        " Datele introduse pentru validarea cnp-ului nu sunt corecte. Verificați aceste date și încercați din nou.");
                                        LOG.info("valideazaCnpUnic: Datele introduse pentru validarea cnp-ului nu sunt corecte. Verificați aceste date și încercați din nou.");
                                }
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ,
                                                "A apărut o eroare la validarea CNP-ului membrului, încercați din nou mai târziu");
                                LOG.error("valideazaCnpUnic: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare în validarea cnp-ului.";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                        }
                }
                return resultat;
        }

        /**
         * Metoda de validare a cnp-ului valideaza sexul din cnp.
         * @return resultat boolean
         */
        private boolean validaSex() {
                boolean resultat = true;
                final String cnp = this.utilizator.getIdCard().substring(0, 1);
                final String sex = this.utilizator.getSex().getName();
                if (sex.equals("MAN") && cnp.equals("1") || sex.equals("WOMAN") && cnp.equals("2")) {
                        resultat = true;
                }
                else {
                        resultat = false;
                }
                return resultat;
        }

        /**
         * Metoda de validare a cnp-ului valideaza data nasterii din cnp.
         * @return resultat boolean
         */
        private boolean valideazaAn() {
                boolean resultat = true;
                if (this.utilizator.getIdCard().length() > NumarMagic.NUMBERSEVEN) {
                        final String an = this.utilizator.getIdCard().substring(1, NumarMagic.NUMBERTHREE);
                        final String luna = this.utilizator.getIdCard().substring(NumarMagic.NUMBERTHREE,
                                        NumarMagic.NUMBERFIVE);
                        final String zi = this.utilizator.getIdCard().substring(NumarMagic.NUMBERFIVE,
                                        NumarMagic.NUMBERSEVEN);
                        final Date fecha = this.utilizator.getDataNasterii();
                        final SimpleDateFormat sdf = new SimpleDateFormat("yy");
                        final SimpleDateFormat lsdf = new SimpleDateFormat(Constante.MM);
                        final SimpleDateFormat zsdf = new SimpleDateFormat("dd");
                        final String anString = sdf.format(fecha);
                        final String lunaString = lsdf.format(fecha);
                        final String ziString = zsdf.format(fecha);
                        if (an.equals(anString) && luna.equals(lunaString) && zi.equals(ziString)) {
                                resultat = true;
                        }
                        else {
                                resultat = false;
                        }
                }
                else {
                        resultat = false;
                }
                return resultat;
        }

        /**
         * Metodă de validare a unicității numelui de utilizator.
         * @return resultat boolean
         */
        private boolean valideazaUsername() {
                boolean resultat = true;
                try {
                        final Utilizator use = this.utilizatorService.fiindOne(this.utilizator.getUsername());
                        if (use != null && !use.getUsername().equals(this.utilizator.getUsername())) {
                                resultat = false;
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la validarea unicității numelui de utilizator, încercați din nou mai târziu");
                        LOG.error("valideazaUsername: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în validarea unicității numelui de utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                }
                return resultat;
        }

        /**
         * Metodă care foloseste la completarea mesajului pentru un utilizator modificat
         * @param usu
         */
        @SuppressWarnings("unlikely-arg-type")
        private String mesajModificareUtilizator(final Utilizator usu) {
                String mesajModificare = Constante.SPATIU;
                if (!utilizatorModificat.getNume().equals(usu.getNume())) {
                        mesajModificare = "Numele anterior : "
                                        .concat(utilizatorModificat.getNume().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getPrenume().equals(usu.getPrenume())) {
                        mesajModificare = mesajModificare + " Prenumele anterior : "
                                        .concat(utilizatorModificat.getPrenume().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getIdCard().equals(usu.getIdCard())) {
                        mesajModificare = mesajModificare + " CNP-ul anterior : "
                                        .concat(utilizatorModificat.getIdCard().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getTeam().equals(usu.getTeam())) {
                        mesajModificare = mesajModificare + " Funcția anterioară : "
                                        .concat(utilizatorModificat.getTeam().getDescriere().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getRole().equals(usu.getRole())) {
                        mesajModificare = mesajModificare + " Rolul anterior : ".concat(
                                        utilizatorModificat.getRole().getDescription().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getPhone().equals(usu.getPhone())) {
                        mesajModificare = mesajModificare + " Telefonul anterior : "
                                        .concat(utilizatorModificat.getPhone().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getEmail().equals(usu.getEmail())) {
                        mesajModificare = mesajModificare + " Email-ul anterior : "
                                        .concat(utilizatorModificat.getEmail().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getAdresa().equals(usu.getAdresa())
                                && !utilizatorModificat.getAdresa().equals(Constante.SPATIU)
                                && utilizatorModificat.getAdresa() != null) {
                        mesajModificare = mesajModificare + " Adresa anterioară : "
                                        .concat(utilizatorModificat.getAdresa().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getNumarCard().equals(usu.getNumarCard())
                                && !utilizatorModificat.getNumarCard().equals(Constante.SPATIU)
                                && utilizatorModificat.getNumarCard() != null) {
                        mesajModificare = mesajModificare + " Numărul documentului de identitate anterior : "
                                        .concat(utilizatorModificat.getNumarCard().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getDataNasterii().equals(usu.getDataNasterii())) {

                        final SimpleDateFormat data = new SimpleDateFormat(Constante.FORMATDATE);
                        final String dataString = data.format(utilizatorModificat.getDataNasterii());
                        mesajModificare = mesajModificare
                                        + " Data nașterii anterioară : ".concat(dataString.concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getEducatie().equals(usu.getEducatie())
                                && !utilizatorModificat.getEducatie().equals(Constante.SPATIU)
                                && utilizatorModificat.getEducatie() != null) {
                        mesajModificare = mesajModificare + " Educație anterioară : ".concat(
                                        utilizatorModificat.getEducatie().getDescription().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getLocMunca().equals(usu.getLocMunca())) {
                        mesajModificare = mesajModificare + " Loculul de muncă anterior : "
                                        .concat(utilizatorModificat.getLocMunca().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getSex().equals(usu.getSex()) && utilizatorModificat.getSex() != null) {
                        mesajModificare = mesajModificare + " Sexul anterior : ".concat(
                                        utilizatorModificat.getSex().getDescription().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getStatutCivil().equals(usu.getStatutCivil())
                                && utilizatorModificat.getStatutCivil() != null) {
                        mesajModificare = mesajModificare + " Starea civilă anterioară : ".concat(utilizatorModificat
                                        .getStatutCivil().getDescription().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getValidat().equals(usu.getValidat())) {
                        String valida = Constante.SPATIU;
                        if (utilizatorModificat.getValidat()) {
                                valida = "ACTIV";
                        }
                        else {
                                valida = "BLOCAT";
                        }
                        mesajModificare = mesajModificare
                                        + " Starea anterioară : ".concat(valida.concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getCodJudet().equals(usu.getCodJudet())
                                && utilizatorModificat.getCodJudet() != null) {
                        mesajModificare = mesajModificare + " Județul/Organizația anterioară : "
                                        .concat(utilizatorModificat.getCodJudet().getNume().concat(Constante.VIRGULA));
                }
                if (utilizatorModificat.getLocalitate() != null
                                && !utilizatorModificat.getLocalitate().equals(usu.getLocalitate())) {
                        mesajModificare = mesajModificare + " Localitatea/Sectorul anterior : "
                                        .concat(utilizatorModificat.getLocalitate().getNume());
                }

                return mesajModificare;
        }
}

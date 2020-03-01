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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataUtilizatori;
import ro.stad.online.gesint.model.filters.FiltruEchipa;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.CanalAlertaEnum;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
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
@Slf4j
public class UtilizatorBean implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = NumarMagic.NUMBERELEVENLONG;

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
        private transient UtilizatorService utilizatorService;

        /**
         * Variabila utilizata pentru a injecta serviciul provinciei.
         *
         */
        @Autowired
        private transient JudetService judetService;

        /**
         * Variabila utilizata pentru a injecta serviciul localitatilor.
         *
         */
        @Autowired
        private transient LocalitateService localitateService;

        /**
         * Variabila utilizata pentru a injecta serviciul functilor
         *
         */
        @Autowired
        private transient ParamEchipaService echipaService;

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
        private transient Utilitati utilitati;

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
                                log.info("S-a obținut cu succes lista de localități ");
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                log.error("actualizareLocalitati: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare la căutarea localităților din județ";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                                log.error(descriere);
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
                this.localitati = new ArrayList<>();
                this.judet = this.judetService.findByName(jude);
                if (this.judet != null) {
                        try {
                                this.localitati = this.localitateService.findByJudet(this.judet);
                                log.info("S-a obținut cu succes lista de localități care aparțin județului  "
                                                .concat(judet.getNume()));
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                log.error("actualLocalitati: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare la căutarea localităților din județ";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                                log.error(descriere);
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
                this.filtruUtilizator = new FiltruUtilizator();
                this.filtruEchipa = new FiltruEchipa();
                this.listUsersLocal = new ArrayList<>();
                this.listUsersCentral = new ArrayList<>();
                this.rowCountLocal = 0;
                this.model = new LazyDataUtilizatori(this.utilizatorService);
                this.model.setRowCount(0);
        }

        /**
         * Metodă folosită pentru a căuta utilizatori în funcție de filtrele introduse în formularul de căutare.
         */
        public void cautareUtilizator() {
                if (this.user.getRole().getDescription().equals("Administrator")) {
                        this.model.setFiltruUtilizator(this.filtruUtilizator);
                }
                else {
                        this.filtruUtilizator.setIdJudet(this.user.getCodJudet().getIndicator());
                        this.model.setFiltruUtilizator(this.filtruUtilizator);
                }
                this.model.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
                final String descriere = Constante.UTILIZATORUL.concat(user.getNumeComplet())
                                .concat(" a folosit filtrul de căutare utilizatori cu următorii parametrii ");
                String mesajModificare = mesajCautareUtilizator(filtruUtilizator);
                // Daca a fost o cautare cu parametrii o inregistram pentru auditorie
                if (!Constante.SPATIU.equals(mesajModificare)) {
                        this.regActividadService.inregistrareRegistruActivitate(descriere.concat(mesajModificare),
                                        RegistruEnum.CAUTARE.getName(), SectiuniEnum.USERS.getName(), user);
                }
        }

        /**
         * Metodă folosită pentru a căuta utilizatori în funcție de filtrele introduse în formularul de căutare.
         * @return listUsersCentral List<Utilizator>
         */
        public List<Utilizator> cautareUtilizatoriCentral() {
                List<Utilizator> sefi = new ArrayList<>();
                this.rowCountCentral = 0;
                this.listUsersCentral = new ArrayList<>();
                this.filtruEchipa = new FiltruEchipa();
                List<Functie> lista = new ArrayList<>();
                lista = incarcamToateFunctileCentrale();
                this.filtruEchipa.setListaFunctii(lista);
                sefi = utilizatorService.cautareUtilizatorCriteriaLocal(this.filtruEchipa);
                this.rowCountCentral = sefi.size();
                this.listUsersCentral = sefi;
                final String descriere = Constante.UTILIZATORUL.concat(this.user.getNumeComplet())
                                .concat(" a căutat utilizatorii cu funcții generale. ");
                this.regActividadService.inregistrareRegistruActivitate(descriere, RegistruEnum.CAUTARE.getName(),
                                SectiuniEnum.USERS.getName(), user);

                return listUsersCentral;
        }

        /**
         * Metodă folosită pentru a căuta utilizatori locali în funcție de filtrele introduse în formularul de căutare.
         */
        public void cautareUtilizatorLocal() {
                this.rowCountLocal = 0;
                if (this.filtruEchipa.getIdFunctia() == null) {
                        List<Functie> lista = incarcamToateFunctileLocale();
                        this.filtruEchipa.setListaFunctii(lista);
                }
                try {
                        this.listUsersLocal = this.utilizatorService.cautareUtilizatorCriteriaLocal(this.filtruEchipa);
                        this.rowCountLocal = this.listUsersLocal.size();
                        final String descriere = Constante.UTILIZATORUL.concat(user.getNumeComplet()).concat(
                                        " a folosit filtrul de căutare utilizatori cu funcții locale folosind următorii parametrii ");
                        String mesajModificare = mesajCautareUtilizator(filtruUtilizator);
                        // Daca a fost o cautare cu parametrii o inregistram pentru auditorie
                        if (!Constante.SPATIU.equals(mesajModificare)) {
                                this.regActividadService.inregistrareRegistruActivitate(
                                                descriere.concat(mesajModificare), RegistruEnum.CAUTARE.getName(),
                                                SectiuniEnum.USERS.getName(), user);
                        }
                        log.info(descriere.concat(mesajModificare));
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la căutarea utilizatorilor cu funcții locale";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                        this.listUsersLocal = new ArrayList<>();
                        this.filtruEchipa = new FiltruEchipa();
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        "Pentru a putea poziționa membrii din conducerea unei organizații locale, trebuie să alegeți una!");
                }
                else {
                        this.listUsersLocal = lista;
                        final RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dlgOrdena').show();");
                }
        }

        /**
         * Metodă folosită pentru a deschide dialogul pentru pozitionarea membrilor.
         * @param lista List<Utilizator>
         */
        public void deschideDialogOrdenaMembruCC(final List<Utilizator> lista) {
                this.listUsersCentral = lista;
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgOrdenaCC').show();");
        }

        /**
         * Metodă folosită pentru a elimina sau adauga un membru în lista de conducere.
         * @param usu Utilizator
         */
        private void eliminaAdaugaMembruListaConducere(final Utilizator usu) {
                if (this.functieIdUser != usu.getTeam().getId()) {
                        final Functie vecheFunctie = this.echipaService.findById(this.functieIdUser);
                        extractFunctieUserTrei(usu, vecheFunctie);
                        extractFunctieMembru(usu, vecheFunctie);
                        Functie nouaFunctie = new Functie();
                        try {
                                nouaFunctie = this.echipaService.findById(usu.getTeam().getId());
                                final String descriere = "Utillizatorului: ".concat(usu.getNumeComplet())
                                                .concat(" ia fost modificată cu succes funcția ")
                                                .concat(nouaFunctie.getNume()).concat(" de: ")
                                                .concat(this.user.getUsername());
                                this.regActividadService.inregistrareRegistruActivitate(descriere,
                                                RegistruEnum.ELIMINARE.getName(), SectiuniEnum.USERS.getName(), user);
                                log.info(descriere);
                        }
                        catch (final DataAccessException e) {
                                final String descriere = "A apărut o eroare la căutarea funcților.";
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(),
                                                descriere.concat(Constante.DESCEROAREMESAJ));
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                                log.error(descriere);
                        }
                        if (vecheFunctie.getId() != NumarMagic.NUMBERTHIRTYL
                                        && nouaFunctie.getOrganizatie().equals(Constante.CONDUCERECENTRALA)) {
                                this.listUsersCentral.add(usu);
                                usu.setRank(Long.valueOf(this.listUsersCentral.size() + 1L));
                        }
                        if (vecheFunctie.getId() != NumarMagic.NUMBERTHIRTYL
                                        && nouaFunctie.getOrganizatie().equals(Constante.CONDUCERELOCALA)) {
                                this.listUsersLocal.add(usu);
                                usu.setRank(Long.valueOf(this.listUsersLocal.size() + 1L));
                        }
                }
        }

        /**
         * @param usu
         * @param vecheFunctie
         */
        private void extractFunctieMembru(final Utilizator usu, final Functie vecheFunctie) {
                if (this.functieIdUser != NumarMagic.NUMBERTHIRTYL
                                && vecheFunctie.getOrganizatie().equals(Constante.CONDUCERELOCALA)) {
                        this.listUsersLocal.remove(usu);
                        reordonareMembru();
                        usu.setRank(null);
                }
        }

        /**
         * @param usu
         * @param vecheFunctie
         */
        private void extractFunctieUserTrei(final Utilizator usu, final Functie vecheFunctie) {
                if (this.functieIdUser != NumarMagic.NUMBERTHIRTYL
                                && vecheFunctie.getOrganizatie().equals(Constante.CONDUCERECENTRALA)) {
                        this.listUsersCentral = cautareUtilizatoriCentral();
                        this.listUsersCentral.remove(usu);
                        reordonareMembruCC();
                        usu.setRank(null);
                }
        }

        /**
         * Metodă folosită pentru a elimina un usuario.
         * @param usu Utilizator utilizatora eliminar
         */
        public void eliminareUtilizator(final Utilizator usu) {
                try {
                        this.utilizator = usu;
                        this.utilizator.setDateDeleted(new Date());
                        this.utilizator.setValidat(false);
                        this.utilizatorService.save(this.utilizator);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.ELIMINARE.getDescriere(), Constante.OKELIMINAREMESAJ);
                        log.info("eliminareUtilizator: userul:".concat(utilizator.getNumeComplet())
                                        .concat(" a fost eliminat de: ")
                                        .concat(utilitati.getUtilizatorLogat().getUsername()));
                        final String descriere = Constante.UTILIZATORUL.concat(usu.getNumeComplet())
                                        .concat(" a fost eliminat cu succes  de: ").concat(user.getUsername());
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.ELIMINARE.getName(), SectiuniEnum.USERS.getName(), user);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("eliminareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la eliminarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru a ractiva un usuario.
         * @param usu Utilizator utilizator reactivat
         */
        public void activareUtilizator(final Utilizator usu) {
                try {
                        this.utilizator = usu;
                        this.utilizator.setDateDeleted(null);
                        this.utilizator.setValidat(true);
                        this.utilizatorService.save(this.utilizator);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.MODIFICARE.getDescriere(), Constante.OKELIMINAREMESAJ);
                        log.info("activareUtilizator: userul:".concat(utilizator.getNumeComplet())
                                        .concat(" a fost activat de: ")
                                        .concat(utilitati.getUtilizatorLogat().getUsername()));
                        final String descriere = Constante.UTILIZATORUL.concat(usu.getNumeComplet())
                                        .concat(" a fost reactivat cu succes de: ").concat(user.getUsername());
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.ACTIVARE.getName(), SectiuniEnum.USERS.getName(), user);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("activareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la reactivarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                                final Functie functia = this.echipaService.findById(NumarMagic.NUMBERTHIRTYL);
                                usu.setTeam(functia);
                        }
                        if (usu.getTeam().getId() == NumarMagic.NUMBERONELONG) {
                                Utilizator presedinte = new Utilizator();
                                final Functie functia = this.echipaService.findById(NumarMagic.NUMBERONELONG);
                                presedinte = this.utilizatorService.findByTeam(functia);
                                if (presedinte == usu) {
                                        validaPresedinte = false;
                                        this.mesaj = "Există un președinte al partidului. Dacă doriți să înlocuiți președintele actual trebuie să modificați membrul "
                                                        .concat(presedinte.getNumeComplet());
                                }
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("existPresedinte: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la verificarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                                final Functie functia = this.echipaService.findById(NumarMagic.NUMBERTHIRTYL);
                                usu.setTeam(functia);
                        }
                        if (usu.getTeam().getId() == NumarMagic.NUMBERTWENTYONELONG) {
                                final Functie functia = this.echipaService.findById(NumarMagic.NUMBERTWENTYONELONG);
                                final Utilizator presedinte = this.utilizatorService.findByTeamAndJudet(functia, jude);
                                if (presedinte != usu && presedinte != null) {
                                        validaPresedinte = false;
                                        this.mesaj = "Există un președinte al organizației "
                                                        .concat(presedinte.getCodJudet().getNume())
                                                        .concat(". Dacă doriți să înlocuiți președintele actual trebuie să modificați membrul ")
                                                        .concat(presedinte.getNumeComplet());
                                }
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("existPresedinteLocal: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la verificarea unui utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                return validaPresedinte;
        }

        /**
         * Metodă folosită pentru a obține localitatile dupa un judet
         */
        private void extractLocalitati() {
                if (this.filtruUtilizator.getJudetSelectat() != null) {
                        try {
                                this.localitati = localitateService.findByJudet(grupLocalitatiSelectate);
                                log.info("Obținem lista localitatile unui județ");
                        }
                        catch (final DataAccessException e) {
                                final String descriere = "A apărut o eroare în căutatrea localităților care aparțin județului.";
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(),
                                                descriere.concat(Constante.DESCEROAREMESAJ));
                                log.info("extractLocalitati: ".concat(descriere));

                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                                log.error(descriere);
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
                this.judetSelect = new Judet();
                this.localitati = new ArrayList<>();
                this.idLocalidad = null;
                this.idJudet = null;
                this.listaFunctii = new ArrayList<>();
                this.listaFunctii = echipaService.fiindAll();
                try {
                        setJudete(this.judetService.fiindAll());
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("getFormInregistrareUtilizator: setjudete: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în căutatrea județelor.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                this.functieIdUser = NumarMagic.NUMBERZEROLONG;
                this.utilizatorModificat = new Utilizator();
                String redireccion = Constante.SPATIU;
                try {
                        final Utilizator usu = this.utilizatorService.fiindOne(usua.getUsername());
                        this.utilizatorModificat = usu;
                        this.listaFunctii = new ArrayList<>(this.echipaService.fiindAll());
                        if (usu != null) {
                                this.functieIdUser = usu.getTeam().getId();
                                this.utilizator = usua;
                                this.judetSelect = this.utilizator.getCodJudet();
                                setLocalitati(localitateService.findByJudet(this.utilizator.getCodJudet()));
                                if (this.utilizator.getLocalitate() == null) {
                                        for (final Localitate lacal : this.localitati) {
                                                if (lacal.getResedinta()) {
                                                        this.utilizator.setLocalitate(lacal);
                                                        break;
                                                }
                                        }
                                }
                                redireccion = "/users/modifyUser?faces-redirect=true";
                        }
                        else {
                                final String descriere = "A apărut o eroare la accesarea membrului. Membrul nu există.";
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.MODIFICARE.getDescriere(), descriere);
                                log.info("getFormModificareUser: ".concat(descriere));
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("getFormInregistrareUtilizator: setjudete: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la accesarea membrului. Membrul nu există.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
         * Metodă folosită pentru a încarca toate functiile centrale
         * @return lista List<Functie> lista cu toate functiile
         */
        private List<Functie> incarcamToateFunctileCentrale() {
                return this.echipaService.findByOrganization(Constante.CONDUCERECENTRALA);
        }

        /**
         * Metodă folosită pentru a încarca toate functiile locale
         * @return lista List<Functie> lista cu toate functiile
         */
        private List<Functie> incarcamToateFunctileLocale() {
                return this.echipaService.findByOrganization(Constante.CONDUCERELOCALA);
        }

        /**
         * Metodă folosită pentru a încarca datele personale ale utilizatorului
         * @param judet Judet
         * @param nuevaLocalidad Localitate
         * @param utilizat Utilizator
         */
        private void incarcareDatePersonaleUser(final Judet judet, final Localitate nuevaLocalidad) {
                this.utilizator.setLocalitate(nuevaLocalidad);
                this.utilizator.setCodJudet(judet);

        }

        /**
         * Metodă folosită pentru a încarca document primit printr-un event FileUploadEvent. Se verifică dacă tipul de
         * document corespunde.
         * @param event FileUploadEvent event care este lansat în încărcarea documentului.
         * @throws IOException
         */
        public void incarcareImagine(final FileUploadEvent event) throws IOException {
                final UploadedFile uFile = event.getFile();
                this.utilizator = this.utilizatorService.incarcareImaginaFaraStocare(
                                IOUtils.toByteArray(uFile.getInputstream()), this.utilizator);
                this.numeDoc = uFile.getFileName();
        }

        /**
         * Metodă folosită pentru a inițializa UtilizatorBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                this.tipLocalitateSelectat = null;
                this.utilizator = new Utilizator();
                this.utilizatorModificat = new Utilizator();
                this.eliminat = false;
                this.judete = new ArrayList<>();
                this.user = this.utilitati.getUtilizatorLogat();
                if (this.user.getRole().getDescription().equals("Administrator")) {
                        this.judete = this.judetService.fiindAll();
                }
                else {
                        this.judete.add(this.user.getCodJudet());
                }
                this.listUsersLocal = new ArrayList<>();
                this.localitati = new ArrayList<>();
                this.judet = new Judet();
                this.judetSelect = new Judet();
                this.filtruUtilizator = new FiltruUtilizator();
                this.filtruEchipa = new FiltruEchipa();
                this.rowCountLocal = 0;
                cautareCautare();
                this.list = new ArrayList<>();
                for (int i = 0; i <= NUMARTCOLOANELISTAUTILIZATORI; i++) {
                        this.list.add(Boolean.TRUE);
                }
                this.model = new LazyDataUtilizatori(this.utilizatorService);

                extractLocalitati();
                this.listaFunctii = new ArrayList<>();
                this.listaFunctii = echipaService.fiindAll();
                this.listaFunctiiLocal = new ArrayList<>();
                this.listaFunctiiLocal = this.echipaService.fiindAllByParam();
                this.listUsersCentral = new ArrayList<>();
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
                        final String valida = RegistruEnum.INREGISTRARE.getDescriere();
                        // Validam noul utilizator
                        if (validar(valida)) {
                                this.utilizator.setLocalitate(this.localitateService.findById(this.idLocalidad));
                                this.utilizator.setEmail(this.utilizator.getUsername());
                                this.utilizator.setValidat(true);
                                this.utilizator.setCodJudet(this.judetService.findById(this.idJudet));
                                this.utilizator.setCanalCorespondenta(CanalAlertaEnum.EMAIL);
                                this.utilizator.setPassword(
                                                "$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve");
                                this.utilizatorService.save(this.utilizator);

                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                Constante.SCHIMBDATE, Constante.OKMODIFICAREMESAJ);
                                final String descriere = "Noul utilizator a fost înregistrat cu succes";
                                this.regActividadService.inregistrareRegistruActivitate(descriere,
                                                RegistruEnum.INREGISTRARE.getName(), SectiuniEnum.USERS.getName(),
                                                this.user);
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(), this.mesajEroare);
                                log.info("inregistrareUtilizator: membrul nou: "
                                                .concat(utilizator.getNume().concat(Constante.SPATIUMARE))
                                                .concat(utilizator.getPrenume()).concat(" nu a fost validat"));

                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("înregistrareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la înregistrarea utilizatorului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                        final Functie functie = this.echipaService.findByIdAndOrganization(usu.getTeam().getId(),
                                        Constante.CONDUCERELOCALA);
                        if (functie != null) {
                                isuserLocal = true;
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("verificareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la verificarea utilizatorului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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

                this.mesaj = Constante.SPATIU;
                if (usu.getTeam().getId() == NumarMagic.NUMBERTWENTYONELONG) {
                        validamLocal = existPresedinteLocal(usu, judet);
                        log.info("Validăm dacă există președinte local");
                }
                if (usu.getTeam().getId() == NumarMagic.NUMBERONELONG) {
                        validamCentral = existPresedinte(usu);
                        log.info("Validăm dacă există președinte");
                }

                final String valida = extractValidaJudet(jude);
                // verificam daca a fost modificata localitatea
                extractValidaLocalitate();

                extractRecuperaPrimaLocalitate(local);
                try {
                        this.utilizator = usu;
                        if (validamLocal && validamCentral) {
                                extractUserValida(mesajModificare, valida);
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                "Eroare în modificarea registrului", mesaj);
                                log.error("modificareUtilizator: Eroare-Nu validează. validam local si validam central");
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.SCHIMBDATE,
                                        Constante.SPATIU);
                        log.error("modificareUtilizator: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare la modificarea utilizatorului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * @param mesajModificare
         * @param valida
         */
        private void extractUserValida(String mesajModificare, final String valida) {
                if (validar(valida)) {
                        if (!this.eliminat) {
                                this.utilizator.setDateDeleted(null);
                        }
                        else {
                                this.utilizator.setDateDeleted(new Date());
                        }
                        this.utilizator.setLocalitate(localitateSelectata);
                        this.utilizator.setCodJudet(judet);
                        final Boolean esteLocal = isLocal(this.utilizator);
                        if (this.utilizator.getRank() == null
                                        && this.utilizator.getTeam().getId() != NumarMagic.NUMBERTHIRTYL) {
                                if (esteLocal) {
                                        List<Functie> lista = new ArrayList<>();
                                        lista = incarcamToateFunctileLocale();
                                        this.filtruEchipa.setListaFunctii(lista);
                                        this.listUsersLocal = this.utilizatorService.findByJudetSiEchipa(this.judet,
                                                        lista);
                                        this.utilizator.setRank(Long.valueOf(listUsersLocal.size() + 1L));
                                }
                                else {
                                        this.listUsersCentral = cautareUtilizatoriCentral();
                                        this.utilizator.setRank(Long.valueOf(this.listUsersCentral.size() + 1L));
                                }

                        }
                        this.utilizatorService.save(this.utilizator);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.SCHIMBDATE,
                                        Constante.OKMODIFICAREMESAJ);
                        log.info("modificareUtilizator: user: ".concat(utilizator.getNumeComplet()));
                        final String descriere = "Noul utilizator a fost modificat cu succes. Datele sunt următoarele: "
                                        .concat(mesajModificare).concat(" modificate cu succes");
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.MODIFICARE.getName(), SectiuniEnum.USERS.getName(), user);
                }
                else {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.SCHIMBDATE,
                                        this.mesajEroare);
                        log.error("modificareUtilizator: Eroare-Nu validează utilizator");
                }
        }

        /**
         * @param local
         */
        private void extractRecuperaPrimaLocalitate(final String local) {
                if (!this.utilizatorModificat.getLocalitate().getNume().equals(local)) {
                        // In cazul in care nu vine informata recupram prima localitate din judet
                        if (Constante.SPATIU.equals(local) && local == null) {
                                List<Localitate> lista = this.localitateService.findByJudet(this.judet);
                                // Daca avem rezultate ..alegem proma localitate din lista
                                if (!lista.isEmpty()) {
                                        this.localitateSelectata = lista.get(0);
                                }
                        }
                        else {
                                // Localitatea a fost modificata si o cautam in baza de date
                                this.localitateSelectata = this.localitateService
                                                .localidadByNumeIgnoreCaseAndJudet(local, this.judet);
                        }
                }
                else {
                        // Daca nu a fost modificata ..ramanem cu cea a utilizatorului
                        this.localitateSelectata = this.utilizatorModificat.getLocalitate();
                }
        }

        /**
         * 
         */
        private void extractValidaLocalitate() {
                if (this.utilizatorModificat.getLocalitate() == null) {
                        final List<Localitate> lista = this.localitateService.findByJudet(this.judet);
                        // Daca avem rezultate ..alegem proma localitate din lista
                        if (!lista.isEmpty()) {
                                this.localitateSelectata = lista.get(0);
                                this.utilizatorModificat.setLocalitate(this.localitateSelectata);
                        }
                }
        }

        /**
         * @param jude
         * @return
         */
        private String extractValidaJudet(final String jude) {
                final String valida = RegistruEnum.MODIFICARE.getDescriere();
                // verificam daca a fost modificat judetul
                if (!this.utilizatorModificat.getCodJudet().getNume().equals(jude)) {
                        obtinemJudetul(jude);
                        log.info("Validăm dacă a fost modificat județul");
                }

                else {
                        // daca nu a fost modificat ramanem cu cel al utilizatorului
                        this.judet = this.utilizatorModificat.getCodJudet();
                }
                return valida;
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
                        this.judet = this.judetService.findByName(jude);
                        if (this.judet == null) {
                                this.judet = this.judetService.findById(jude);
                                log.info("Obținem județul ".concat(this.judet.getNume()));
                        }

                        existeLocalidad = this.localitateService.existeByNumeIgnoreCaseAndJudet(nume.trim(),
                                        this.judet);
                }
                catch (final DataAccessException e) {
                        final String descriere = "S-a produs o erroare în căutarea localitații.";
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                        descriere.concat(Constante.DESCEROAREMESAJ), null, "inputNume");
                        log.error("nouaLocalitate: S-a produs o erroare în căutarea localitații "
                                        .concat(String.valueOf(e)));

                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                this.tipLocalitateSelectat = null;
                this.tipLocalitateSelectat = tipLocalitate;
                if (existeLocalidad) {
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                        "Acțiunea nu este permisă. Există deja o localitate care aparține aceluiași județ cu același nume.",
                                        null, "inputNume");
                        log.info("nouaLocalitate: Acțiunea nu este permisă. Există deja o localitate care aparține aceluiași județ cu același nume");
                }
                else {
                        Localitate nouaLocalitate;
                        try {
                                nouaLocalitate = this.localitateService.inregistrareLocalitate(nume, this.judet,
                                                this.tipLocalitateSelectat);
                                log.info(" Înregistrăm noua localitate ".concat(nouaLocalitate.getNume()));
                                setLocalitati(this.localitateService.findByJudet(this.judet));
                                // Incarcam si salvam noua localitate in datele utilizatorului
                                incarcareDatePersonaleUser(this.judet, nouaLocalitate);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                "Eroare în salvarea localității. ".concat(Constante.DESCEROAREMESAJ),
                                                null, "inputNume");
                                log.error("nouaLocalitate: nuevaLocalidad: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare în salvarea localității.";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                                log.error(descriere);
                        }
                }
        }

        /**
         * Metodă folosită pentru a obține județul
         * @param jude String
         */
        private void obtinemJudetul(final String jude) {
                if (jude.equals(Constante.SPATIU)) {
                        this.judet = this.judetSelect;
                }
                else {
                        this.judet = this.judetService.findByName(jude);
                        log.info(" Obținem județul ".concat(judet.getNume()));
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
                        log.info("onReorderCC: Modificarea ordinii în listă a fost realizată cu succes!");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("onReorderCC: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repoziționarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                        log.info("onReorderCL: Modificarea ordinii în listă a fost realizată cu succes!");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("onReorderCL: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repoziționarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru selectare.
         * @param event SelectEvent
         */
        public void onSelect(final SelectEvent event) {
                this.utilizator = (Utilizator) event.getObject();
        }

        /**
         * Metodă folosită pentru a Activa /Dezactiva vizibilitatea coloanelor din tabelul cu rezultate.
         * @param e ToggleEvent checkbox al coloanei selectate
         */
        public void onToggle(final ToggleEvent e) {
                this.list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metodă folosită pentru a repozitiona un membru
         */
        private void reordonareMembru() {
                Utilizator user = new Utilizator();
                try {
                        for (int i = 0; i < this.listUsersLocal.size(); i++) {
                                user = this.listUsersLocal.get(i);
                                user.setRank(i + NumarMagic.NUMBERONELONG);
                                this.utilizatorService.save(user);

                                final RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dlgOrdena').hide();");
                        }
                        log.info(" Salvăm noile poziții ale utilizatorilor ");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("repozitionareaMembru: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repoziționarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                        log.info(" Salvăm noile poziții ale utilizatorilor");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("reordonareMembruCC: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în repoziționarea membrului.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                        // cuerpoCorreo
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.PAR,
                                        "Un e-mail a fost trimis utilizatorului cu noua parolă");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.PAR,
                                        "A apărut o eroare în regenerarea sau trimiterea parolei. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        log.error("restabilireParola: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în regenerarea sau trimiterea parolei.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
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
                        this.filtruUtilizator = new FiltruUtilizator();
                        this.filaActiva = Constante.TABMEMBRI;
                        cautareCautare();
                }
                else if ("conducereaLocala".equals(event.getTab().getId())) {
                        this.filtruUtilizator = new FiltruUtilizator();
                        this.filaActiva = Constante.TABLOCAL;
                        cautareCautare();
                }
                else {
                        this.filtruUtilizator = new FiltruUtilizator();
                        this.filaActiva = Constante.TABCONDUCERE;
                        cautareCautare();
                        this.listUsersCentral = cautareUtilizatoriCentral();
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
                        log.info("validar valideazaUsername: Membrul există deja în sistem");
                        this.mesajEroare = "Membrul există deja în sistem";
                        validat = false;
                }
                if (!valideazaCnpUnic()) {
                        if (valida.equals(RegistruEnum.INREGISTRARE.getDescriere())) {
                                this.mesajEroare = "CNP-ul există deja în sistem";
                                log.info("validar valideazaCnpUnic: CNP-ul există deja în sistem");
                        }
                        else {
                                this.mesajEroare = "CNP-ul nu este corect.";
                                log.info("validar valideazaCnpUnic: CNP-ul nu este corect");
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
                                                        RegistruEnum.EROARE.getDescriere(),
                                                        " Datele introduse pentru validarea cnp-ului nu sunt corecte. Verificați aceste date și încercați din nou.");
                                        log.info("valideazaCnpUnic: Datele introduse pentru validarea cnp-ului nu sunt corecte. Verificați aceste date și încercați din nou.");
                                }
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(),
                                                "A apărut o eroare la validarea CNP-ului membrului, încercați din nou mai târziu");
                                log.error("valideazaCnpUnic: ".concat(String.valueOf(e)));
                                final String descriere = "A apărut o eroare în validarea cnp-ului.";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.USERS.getDescriere(), e);
                                log.error(descriere);
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
                if (sex.equals(Constante.MAN) && cnp.equals(Constante.UNU)
                                || sex.equals(Constante.WOMAN) && cnp.equals(Constante.DOI)) {
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
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        "A apărut o eroare la validarea unicității numelui de utilizator, încercați din nou mai târziu");
                        log.error("valideazaUsername: ".concat(String.valueOf(e)));
                        final String descriere = "A apărut o eroare în validarea unicității numelui de utilizator.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.USERS.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                return resultat;
        }

        /**
         * Metodă care foloseste la completarea mesajului pentru un utilizator modificat
         * @param usu Utilizator
         * @return mesajModificare String
         */
        private String mesajModificareUtilizator(final Utilizator usu) {
                String mesajModificare = Constante.SPATIU;
                if (!this.utilizatorModificat.getNume().equals(usu.getNume())) {
                        mesajModificare = "Numele anterior : "
                                        .concat(this.utilizatorModificat.getNume().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getPrenume().equals(usu.getPrenume())) {
                        mesajModificare = mesajModificare + " Prenumele anterior : "
                                        .concat(this.utilizatorModificat.getPrenume().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getIdCard().equals(usu.getIdCard())) {
                        mesajModificare = mesajModificare + " CNP-ul anterior : "
                                        .concat(this.utilizatorModificat.getIdCard().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getTeam().equals(usu.getTeam())) {
                        mesajModificare = mesajModificare + " Funcția anterioară : ".concat(
                                        this.utilizatorModificat.getTeam().getDescriere().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getRole().equals(usu.getRole())) {
                        mesajModificare = mesajModificare + " Rolul anterior : ".concat(
                                        this.utilizatorModificat.getRole().getDescription().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getPhone().equals(usu.getPhone())) {
                        mesajModificare = mesajModificare + " Telefonul anterior : "
                                        .concat(this.utilizatorModificat.getPhone().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getEmail().equals(usu.getEmail())) {
                        mesajModificare = mesajModificare + " Email-ul anterior : "
                                        .concat(this.utilizatorModificat.getEmail().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getAdresa().equals(usu.getAdresa())
                                && !this.utilizatorModificat.getAdresa().equals(Constante.SPATIU)
                                && this.utilizatorModificat.getAdresa() != null) {
                        mesajModificare = mesajModificare + " Adresa anterioară : "
                                        .concat(this.utilizatorModificat.getAdresa().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getNumarCard().equals(usu.getNumarCard())
                                && !this.utilizatorModificat.getNumarCard().equals(Constante.SPATIU)
                                && this.utilizatorModificat.getNumarCard() != null) {
                        mesajModificare = mesajModificare + " Numărul documentului de identitate anterior : "
                                        .concat(this.utilizatorModificat.getNumarCard().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getDataNasterii().equals(usu.getDataNasterii())) {

                        final SimpleDateFormat data = new SimpleDateFormat(Constante.FORMATDATE);
                        final String dataString = data.format(this.utilizatorModificat.getDataNasterii());
                        mesajModificare = mesajModificare
                                        + " Data nașterii anterioară : ".concat(dataString.concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getEducatie().equals(usu.getEducatie())

                                && this.utilizatorModificat.getEducatie() != null) {
                        mesajModificare = mesajModificare + " Educație anterioară : ".concat(this.utilizatorModificat
                                        .getEducatie().getDescription().concat(Constante.VIRGULA));
                }
                if (!utilizatorModificat.getLocMunca().equals(usu.getLocMunca())) {
                        mesajModificare = mesajModificare + " Loculul de muncă anterior : "
                                        .concat(this.utilizatorModificat.getLocMunca().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getSex().equals(usu.getSex())
                                && this.utilizatorModificat.getSex() != null) {
                        mesajModificare = mesajModificare + " Sexul anterior : ".concat(
                                        this.utilizatorModificat.getSex().getDescription().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getStatutCivil().equals(usu.getStatutCivil())
                                && this.utilizatorModificat.getStatutCivil() != null) {
                        mesajModificare = mesajModificare
                                        + " Starea civilă anterioară : ".concat(this.utilizatorModificat
                                                        .getStatutCivil().getDescription().concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getValidat().equals(usu.getValidat())) {
                        String valida = Constante.SPATIU;
                        if (this.utilizatorModificat.getValidat()) {
                                valida = "ACTIV";
                        }
                        else {
                                valida = "BLOCAT";
                        }
                        mesajModificare = mesajModificare
                                        + " Starea anterioară : ".concat(valida.concat(Constante.VIRGULA));
                }
                if (!this.utilizatorModificat.getCodJudet().equals(usu.getCodJudet())
                                && this.utilizatorModificat.getCodJudet() != null) {
                        mesajModificare = mesajModificare + " Județul/Organizația anterioară : ".concat(
                                        this.utilizatorModificat.getCodJudet().getNume().concat(Constante.VIRGULA));
                }
                if (this.utilizatorModificat.getLocalitate() != null
                                && !this.utilizatorModificat.getLocalitate().equals(usu.getLocalitate())) {
                        mesajModificare = mesajModificare + " Localitatea/Sectorul anterior : "
                                        .concat(this.utilizatorModificat.getLocalitate().getNume());
                }

                return mesajModificare;
        }

        /**
         * Metodă care foloseste la completarea mesajului pentru cautarea unui utilizator
         * @param filUtil FiltruUtilizator
         * @return mesajMCautare String
         */
        private String mesajCautareUtilizator(final FiltruUtilizator filUtil) {
                String mesajMCautare = Constante.SPATIU;
                if (filUtil.getEducatie() != null) {
                        mesajMCautare = "Nivel educație:  "
                                        .concat(filUtil.getEducatie().getDescription().concat(Constante.VIRGULA));
                }
                if (!Constante.SPATIU.equals(filUtil.getNume())) {
                        mesajMCautare = "Nume:  ".concat(filUtil.getNume().concat(Constante.VIRGULA));
                }
                if (!Constante.SPATIU.equals(filUtil.getPrenume())) {
                        mesajMCautare = "Prenume:  ".concat(filUtil.getPrenume().concat(Constante.VIRGULA));
                }
                if (!Constante.SPATIU.equals(filUtil.getEmail())) {
                        mesajMCautare = "Email:  ".concat(filUtil.getEmail().concat(Constante.VIRGULA));
                }
                if (filUtil.getRole() != null) {
                        mesajMCautare = "Rol:  ".concat(filUtil.getRole().getDescription().concat(Constante.VIRGULA));
                }
                if (filUtil.getSex() != null) {
                        mesajMCautare = "Sex:  ".concat(filUtil.getSex().getDescription().concat(Constante.VIRGULA));
                }
                if (filUtil.getStatutCivil() != null) {
                        mesajMCautare = "Stare civilă:  "
                                        .concat(filUtil.getStatutCivil().getDescription().concat(Constante.VIRGULA));
                }
                if (filUtil.getTipLocalitate() != null) {
                        mesajMCautare = "Tipul localității:  "
                                        .concat(filUtil.getTipLocalitate().getDescription().concat(Constante.VIRGULA));
                }
                return mesajMCautare;
        }
}

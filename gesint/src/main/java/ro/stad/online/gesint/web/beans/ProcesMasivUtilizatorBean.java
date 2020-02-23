package ro.stad.online.gesint.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionException;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataUtilizatori;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.OperatieMasivaFisierService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.services.impl.RegistruActivitateServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Controller pentru prelucrarea masivă a utilizatorilor.
 * @author STAD
 */

@Getter
@Setter
@Controller("procesoMasivoBean")
@Scope(Constante.SESSION)
public class ProcesMasivUtilizatorBean implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 7449854572833321412L;

        /**
         * Clasă pentru căutarea de utilizatori.
         */
        private FiltruUtilizator filtruUtilizator;

        /**
         * Serviciu de utilizatori.
         */
        @Autowired
        private transient UtilizatorService utilizatorService;

        /**
         * Serviciul de operații masiv.
         */
        @Autowired
        private transient OperatieMasivaFisierService operatieMasivaFisierService;

        /**
         * Clasă de utilități pentru mesajes.
         */
        @Autowired
        private transient FacesUtilities facesUtilities;

        /**
         * Component de utilități.
         */
        @Autowired
        private transient Utilitati utilitati;

        /**
         * Numărul maxim de coloane vizibile în pagină.
         */
        private int numarColoaneListaUtilizatori = NumarMagic.NUMBERSEVENTEEN;

        /**
         * LazyModel pentru paginarea în server al datelor.
         */
        private LazyDataUtilizatori model;

        /**
         * Lista Booleans pentru controlul afișării coloanelor din pagină.
         */
        private List<Boolean> list;

        /**
         * Variabilă utilizată pentru a afișa tabla cu rezultatele căutării sau nu.
         */
        private boolean afisareTabla;

        /**
         * Context actual.
         */
        private transient ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        /**
         * Indică dacă se elimină masiv.
         */
        private String esteEliminareMasiva;

        /**
         * Indică dacă se blochează masiv.
         */
        private String esteBlocareMasiva;

        /**
         * Indică titlul paginii.
         */
        private String titlu;

        /**
         * Indică numele șablonului pentru descarcar.
         */
        private String plansaDescarcareInregistrare;

        /**
         * Obiect care va conține fișierul de descărcat.
         */
        private transient StreamedContent file;

        /**
         * Lista utilizatorilor selectați pentru procesare (setată astfel încât să nu existe utilizatori repetiți).
         */
        private Set<Utilizator> listautilizatoriSelectionati;

        /**
         * Tip de operatie masiva.
         */
        private String tipInregistrareMasivaUtilizator;

        /**
         * Tip string resultat
         */
        private String resultat;

        /**
         * Variala utilizata pentru injectarea serviciului înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateServiceImpl registruActivitateService;

        /**
         * Metodă folosită pentru a adaugă utilizatori noi la lista de utilizatori selectați.
         */
        public void adaugareUtilizatoriSchimbPagina() {
                if (filtruUtilizator.getUtilizatoriSelectionati() != null
                                && !filtruUtilizator.getUtilizatoriSelectionati().isEmpty()) {
                        listautilizatoriSelectionati.addAll(filtruUtilizator.getUtilizatoriSelectionati());
                        filtruUtilizator.setUtilizatoriSelectionati(new ArrayList<>(listautilizatoriSelectionati));
                }
        }

        /**
         * Metodă folosită pentru a elimina logic utilizatorii indicați în listă.
         */
        private void eliminareLogicaMasiva() {
                try {
                        final List<String> listaSeleccionados = validareListaSelectionati(listautilizatoriSelectionati);
                        if (!listaSeleccionados.isEmpty()) {
                                utilizatorService.bajaLogica(listaSeleccionados);
                                final String mensaje = "Membrii prezenți în listă au fost eliminați cu succes.";
                                utilitati.procesareResultateOperatiune(Constante.UTILIZATORIMASIV, "ELIMINARE", mensaje,
                                                Constante.PROCESMASIV, SectiuniEnum.ALTELE.getDescriere(),
                                                facesUtilities);
                        }
                }
                catch (final TransactionException te) {
                        utilitati.procesareEceptie(te, SectiuniEnum.ALTELE.getDescriere(),
                                        "eliminare masivă a membrilor", facesUtilities);
                        final String descriere = "A apărut o eroare la eliminarea logică masivă a utilizatorului";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), te);
                }
        }

        /**
         * Metodă folosită pentru a bloca accesul la utilizatorii care apar în fișierul Excel încărcat în aplicație.
         * @param event FileUploadEvent
         */
        public void blocareFisierUtilizatori(final FileUploadEvent event) {
                try {
                        operatieMasivaFisierService.procesareOperatieMasivaFisier(event, Constante.BLOCARE,
                                        "executând blocarea în masă a utilizatorilor.");
                }
                catch (final TransactionException te) {
                        utilitati.procesareEceptie(te, SectiuniEnum.ALTELE.getDescriere(),
                                        "eliminare masivă a membrilor", facesUtilities);
                        final String descriere = "A apărut o eroare executând blocarea în masă a utilizatorilor";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), te);
                }
        }

        /**
         * Metodă folosită pentru a bloca utilizatorii indicați în listă.
         */
        private void blocareMasiva() {
                try {
                        final List<String> listaSeleccionados = validareListaSelectionati(listautilizatoriSelectionati);
                        if (!listaSeleccionados.isEmpty()) {
                                utilizatorService.dezactivare(listaSeleccionados);
                                final String mensaje = "Membrii prezenți în listă au fost blocați cu succes.";
                                utilitati.procesareResultateOperatiune(Constante.UTILIZATORIMASIV, "DEZACTIVARE",
                                                mensaje, Constante.PROCESMASIV,
                                                SectiuniEnum.ADMINISTRARE.getDescriere(), facesUtilities);
                        }
                }
                catch (final TransactionException te) {
                        utilitati.procesareEceptie(te, SectiuniEnum.ALTELE.getDescriere(),
                                        "blochează utilizatorii masiv", facesUtilities);
                        final String descriere = "A apărut o eroare executând blocarea în masă a utilizatorilor";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), te);
                }
        }

        /**
         * Metodă folosită pentru a sterge logic utilizatorii care apar în fișierul Excel încărcat în aplicație..
         * @param event FileUploadEvent
         */
        public void eliminareUtilizatoriFisier(final FileUploadEvent event) {
                try {
                        operatieMasivaFisierService.procesareOperatieMasivaFisier(event, Constante.ELIMINARE,
                                        "executând eliminarea logică în masă a utilizatorilor.");
                }
                catch (final TransactionException te) {
                        utilitati.procesareEceptie(te, SectiuniEnum.ALTELE.getDescriere(),
                                        "blochează utilizatorii masiv", facesUtilities);
                        final String descriere = "A apărut o eroare executând eliminarea logică în masă a utilizatorilor.";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), te);
                }
        }

        /**
         * Metodă folosită pentru a căuta utilizatorii prin datele introduse în filtru.
         */
        public void cautareUtilizatori() {
                model.setFiltruUtilizator(filtruUtilizator);
                afisareTabla = true;
        }

        /**
         * Metodă folosită pentru a salva utilizatorii care apar în fișierul Excel încărcat în aplicație, atât timp cât
         * sunt corecte.
         * @param event FileUploadEvent
         */
        public void incarcareUtilizatoriFisier(final FileUploadEvent event) {
                try {
                        operatieMasivaFisierService.procesareOperatieMasivaFisier(event, Constante.INREGISTRARE,
                                        "executând înregistrarea în masă a utilizatorilor.");
                }
                catch (final TransactionException te) {
                        utilitati.procesareEceptie(te, SectiuniEnum.ALTELE.getDescriere(),
                                        "blochează utilizatorii masiv", facesUtilities);
                        final String descriere = "A apărut o eroare executând înregistrarea în masă a utilizatorilor.";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), te);
                }
        }

        /**
         * Metodă folosită pentru a șterge utilizatorul nemarcat din lista utilizatorilor selectați.
         * @param event UnselectEvent lansat atunci când deselectați un utilizator din tabel
         */
        public void checkDeselectionat(final UnselectEvent event) {
                final Utilizator usu = (Utilizator) event.getObject();
                listautilizatoriSelectionati.remove(usu);
                model.setDataSource(listautilizatoriSelectionati);
        }

        /**
         * Metodă folosită pentru a adăuga un utilizator la lista de utilizatori selectați..
         * @param event SelectEvent lansat atunci când selectați un utilizator din tabel
         */
        public void checkSelectionat(final SelectEvent event) {
                final Utilizator usu = (Utilizator) event.getObject();
                listautilizatoriSelectionati.add(usu);
                model.setDataSource(listautilizatoriSelectionati);
        }

        /**
         * Metodă folosită pentru a capta evenimentul „Selectează tot” sau „Deselectează tot” în pagina de procesare
         * masiva.
         * @param toogleEvent ToggleSelectEvent care este lansat prin bifarea / debifarea opțiunii „Selectează tot”.
         */
        public void checkSelectionatToate(final ToggleSelectEvent toogleEvent) {
                try {
                        if (toogleEvent.isSelected()) {
                                listautilizatoriSelectionati = new HashSet<>(
                                                utilizatorService.cautareUtilizator(filtruUtilizator));
                        }
                        else {
                                listautilizatoriSelectionati = new HashSet<>();
                        }
                        model.setDataSource(listautilizatoriSelectionati);
                        filtruUtilizator.setUtilizatoriSelectionati(new ArrayList<>(listautilizatoriSelectionati));
                }
                catch (final TransactionException te) {
                        utilitati.procesareEceptie(te, SectiuniEnum.ALTELE.getDescriere(),
                                        "blochează utilizatorii masiv", facesUtilities);
                        final String descriere = "A apărut o eroare executând blocarea utilizatorii masiv.";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), te);
                }
        }

        /**
         * Metodă folosită pentru a descărca un șablon descărcare Excel pentru încărcarea în masă a utilizatorului.
         * @return sablon
         */
        public void descarcareSablonUtilizatoriMasiv() {
                final String sablon = Constante.SABLONINREGISTRARE;
                try {
                        setFile(utilitati.descarcareFisier("/static/ficheros/" + sablon,
                                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", sablon));
                }
                catch (final IOException e) {
                        facesUtilities.setmesajEroare("A apărut o eroare la descărcarea fișierului.",
                                        Constante.IDMESAJGLOBAL);
                        final String descriere = "A apărut o eroare la descărcarea fișierului.";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), e);
                }
        }

        /**
         * Metodă folosită pentru a transmite numele care dorim sa-l folosim in formular, astfel încât acestea să-si
         * poată schimba valorile.
         * @param tip String
         * @return URL-ul paginii
         */
        public String getFormOperaMasiv(final String tip) {
                resultat = null;
                this.tipInregistrareMasivaUtilizator = null;
                this.esteEliminareMasiva = null;
                this.esteBlocareMasiva = null;
                this.titlu = Constante.SPATIU;
                if (tip.equals(Constante.INREGISTRARE)) {
                        this.tipInregistrareMasivaUtilizator = tip;
                        this.titlu = "Înregistrare masivă a membrilor prin fișier";
                        plansaDescarcareInregistrare = "fisier_inregistrare_masiva_membri.xlsx";
                        resultat = "/users/reg_masiva_file?faces-redirect=true";

                }
                else if (tip.equals(Constante.ESTEELIMINARE)) {
                        this.esteEliminareMasiva = tip;
                        this.titlu = "Eliminarea masivă a membrilor";
                        resultat = "/users/del_masiva_file?faces-redirect=true";
                }
                else {
                        this.esteBlocareMasiva = tip;
                        filtruUtilizator.setValidat(true);
                        this.titlu = "Blocarea masivă a membrilor";
                        resultat = "/users/bloq_masiva_file?faces-redirect=true";
                }
                return resultat;
        }

        /**
         * Metodă folosită pentru a inițializa ProcesMasivUtilizatorBean
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                final HttpServletRequest req = (HttpServletRequest) context.getRequest();
                tipInregistrareMasivaUtilizator = Constante.INREGISTRARE;
                esteEliminareMasiva = Constante.ESTEELIMINARE;
                esteBlocareMasiva = Constante.ESTEBLOCAJ;
                plansaDescarcareInregistrare = String.valueOf(req.getParameter("plantilla"));
                filtruUtilizator = new FiltruUtilizator();
                filtruUtilizator.setUtilizatoriSelectionati(new ArrayList<>());
                listautilizatoriSelectionati = new HashSet<>();
                model = new LazyDataUtilizatori(utilizatorService);
                setList(utilitati.listaTrue(numarColoaneListaUtilizatori));
        }

        /**
         * Metodă folosită pentru a sterge rezultatele căutărilor anterioare.
         */
        public void cautareCautare() {
                filtruUtilizator = new FiltruUtilizator();
                afisareTabla = false;
        }

        /**
         * Metoda care executa operația apăsând butonul. Un lucru sau altul va fi executat în funcție de operația
         * selectată.
         */
        public void procesareUtilizatori() {
                if (Boolean.valueOf(esteEliminareMasiva)) {
                        eliminareLogicaMasiva();
                }
                else {
                        blocareMasiva();
                }
        }

        /**
         * Metodă folosită pentru a valida lista utilizatorilor selectați, astfel încât o listă goală să nu fie
         * procesată.
         * @param selectionati utilizatori selectați
         * @return lista de utilizatori selectați
         */
        private List<String> validareListaSelectionati(final Set<Utilizator> selectionati) {
                if (listautilizatoriSelectionati == null || listautilizatoriSelectionati.isEmpty()) {
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR, "Membri selectați",
                                        "Trebuie să selectați cel puțin un membru din listă pentru a procesa operația masivă.",
                                        Constante.IDMESAJGLOBAL);
                }
                return new ArrayList<>(selectionati.stream().map(Utilizator::getUsername)
                                .collect(Collectors.toCollection(ArrayList::new)));
        }
}

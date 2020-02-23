package ro.stad.online.gesint.web.beans;

import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.imageio.ImageIO;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.Visibility;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.lazydata.LazyDataSondaje;
import ro.stad.online.gesint.model.filters.FiltruSondaj;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Intrebare;
import ro.stad.online.gesint.persistence.entities.RaspunsSuport;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipRegistruEnum;
import ro.stad.online.gesint.services.IntrebareService;
import ro.stad.online.gesint.services.RaspunsSuportService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.SondajService;
import ro.stad.online.gesint.services.StatisticaService;
import ro.stad.online.gesint.services.impl.DocumentServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Controlorul operațiunilor legate de gestionarea sondajelor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("sondajBean")
@Scope(Constante.SESSION)
public class SondajBean implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = NumarMagic.NUMBERONELONG;

        /**
         * Numărul de coloane din tabelul de sondaje.
         */
        private static final int NUMBERCOLUMNTABLA = NumarMagic.NUMBERSIX;

        /**
         * Sondaj nou.
         */
        private transient Sondaj sondaj;

        /**
         * Sondaj activ.
         */
        private transient Sondaj sondajActiv;

        /**
         * Variala utilizata pentru injectarea serviciului de sondale.
         */
        @Autowired
        private transient SondajService sondajService;

        /**
         * Lazy model pentru sondje.
         */
        private transient LazyDataSondaje model;

        /**
         * Lazy model pentru sondaje active.
         */
        private transient LazyDataSondaje modelActiv;

        /**
         * Clasa de căutare a sondajelor.
         */
        private FiltruSondaj filtruSondaj;

        /**
         * Listă de sondaje.
         */
        private List<Sondaj> listSondaje;

        /**
         * Sondajul actual.
         */
        private Sondaj sondajActual;

        /**
         * Indicați ce colomne apar în listă.
         */
        private List<Boolean> list;

        /**
         * Lista intrebaruilor.
         */
        private List<Intrebare> intrebari;

        /**
         * Data actuala
         */
        private Date currentDate;

        /**
         * Data inceperi sondajului
         */
        private String incepeSondajul;

        /**
         * Data finalizarii sondajului
         */
        private String terminaSondajul;

        /**
         * Variabila pentru chart de tipul pie
         */
        private PieChartModel graficaVoturi;

        /**
         * Fișier pentru descărcarea raportului statistic.
         */
        private transient StreamedContent file;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService registruActivitateService;

        /**
         * Serviciul de statistică.
         */
        @Autowired
        private transient StatisticaService statisticaService;

        /**
         * Serviciul de intrebari suport.
         */
        @Autowired
        private transient IntrebareService intrebareService;

        /**
         * Serviciul de intrebari suport.
         */
        @Autowired
        private transient RaspunsSuportService raspunsSuportService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Serviciu de documente.
         */
        @Autowired
        private transient DocumentServiceImpl documentService;

        /**
         * Id intrebare
         */
        private Long idIntrebare;

        /**
         * Raspuns suport
         */
        private RaspunsSuport raspuns;

        /**
         * Raspuns suport
         */
        private Intrebare intrebare;

        /**
         * Obiectul de tip Document pentru înregistrarea de noi documente.
         */
        private Documentul document;

        /**
         * Raspuns vot sondaj
         */
        private String votSondaj;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private Utilitati utilitati;

        /**
         * Metodă care returnează un raspuns cautat cu id-ul.
         * @param id Long
         * @return raspuns
         */
        public RaspunsSuport actualizeazaRaspuns(final Long id) {
                this.idIntrebare = id;
                if (this.idIntrebare != null) {
                        try {
                                this.intrebare = intrebareService.findById(id);
                                this.raspuns = raspunsSuportService.findById(intrebare);
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                final String descriere = "A apărut o eroare la căutarea raspunsurilor";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.SONDAJ.getDescriere(), e);

                        }
                }
                return raspuns;
        }

        /**
         * Metodă care caută sondaje pe baza filtrului de căutare.
         */
        public void cautareSondaje() {
                this.model.setCautare(this.filtruSondaj);
                this.model.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
        }

        /**
         * Metodă care caută sondaje pe baza filtrului de căutare.
         * @param user Utilizator
         * @param activ Boolean
         * @return modelActiv
         */
        public void cautareSondajeActive() {
                filtruSondaj.setActiv(true);
                this.modelActiv.setCautare(this.filtruSondaj);
                this.modelActiv.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
        }

        /**
         * Metodă care generează un gráfic.
         */
        public void createGrafica() {
                graficaVoturi = new PieChartModel();
                graficaVoturi.setShowDataLabels(true);
                graficaVoturi.setShowDatatip(true);
                graficaVoturi.setLegendPosition("w");
                graficaVoturi.setSeriesColors(
                                "008000,00FFFF,008080,0000FF,800080,f6546a,084D6E,FFFFFF,C0C0C0,808080,d0b38e,FF0000,ec9931,FFFF00,00FF00");

        }

        /**
         * Metodă folosită pentru a incarca datele in modelul pie
         * @param sond Sondaj.
         */
        private void createPieModel(final Sondaj sond) {
                graficaVoturi = new PieChartModel();
                graficaVoturi.set("DA : " + sond.getTotalVoturiDa(), sond.getTotalVoturiDa());
                graficaVoturi.set("NU: " + sond.getTotalVoturiNu(), sond.getTotalVoturiNu());
                graficaVoturi.set("ABȚINERI: " + sond.getTotalVoturiAbt(), sond.getTotalVoturiAbt());
                graficaVoturi.setLegendPosition(Constante.E);
                graficaVoturi.setFill(false);
                graficaVoturi.setShowDataLabels(true);
                graficaVoturi.setDiameter(200);
                graficaVoturi.setShadow(false);
        }

        /**
         * Metodă folosită pentru a curăța filtrele de căutarea.
         */
        public void curatareCautare() {
                this.filtruSondaj = new FiltruSondaj();
                this.model = new LazyDataSondaje(this.sondajService);
        }

        /**
         * Metodă folosită pentru a curăța filtrele de căutarea.
         */
        public void curatareCautareSondajActiv() {
                this.filtruSondaj = new FiltruSondaj();
                this.modelActiv = new LazyDataSondaje(this.sondajService);
        }

        /**
         * Metodă folosită pentru a prezenta detaliul unui sondajului.
         * @param sondaj Sondaj
         * @return pagina detaliiSondaj
         */
        public String detaliiSondaj(final Sondaj sond) {
                this.document = new Documentul();
                this.sondaj = sond;
                List<Documentul> listaDoc = documentService.cautaDocumenteSondaj(sond);
                if (!listaDoc.isEmpty()) {
                        this.document = listaDoc.get(0);
                }
                createPieModel(sondaj);
                final String pattern = "dd/MM/yyyy HH:mm:ss";
                final DateFormat df = new SimpleDateFormat(pattern);
                incepeSondajul = df.format(sondaj.getDataIncepere());
                final String pattern2 = Constante.FORMATDATE;
                final DateFormat df2 = new SimpleDateFormat(pattern2);
                terminaSondajul = df2.format(sondaj.getDataFinalizare());
                terminaSondajul = terminaSondajul.concat(" 23:59:59");
                return "/sondaj/detaliiSondaj?faces-redirect=true";
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
         * Metodă folosită pentru a exporta un sondaj în format pdf.
         * @param sond Sondaj.
         * @param imagine String Imagine generată în pagina și ce dorim să o exportăm.
         */
        public void filtreazaPDF(final Sondaj sond, final String imagine) {
                File fileImg = null;
                this.sondaj = sond;
                if (imagine.split(Constante.VIRGULA).length > 1) {
                        final String encoded = imagine.split(Constante.VIRGULA)[1];
                        final byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(encoded);

                        try {
                                final RenderedImage renderedImage = ImageIO.read(new ByteArrayInputStream(decoded));
                                fileImg = File.createTempFile("out", ".png");
                                ImageIO.write(renderedImage, Constante.PNG, fileImg);
                        }
                        catch (final IOException e) {
                                registruActivitateService.salveazaRegistruInregistrareModificare(null,
                                                TipRegistruEnum.EROARE.name(), SectiuniEnum.SONDAJ.getDescriere(),
                                                e.toString());
                                final String descriere = "A apărut o eroare în exportul unui sondaj în format PDF";
                                this.regActividadService.salveazaRegistruEroare(descriere,
                                                SectiuniEnum.SONDAJ.getDescriere(), e);
                        }
                }
                obtieneInformePDF(fileImg);
        }

        /**
         * Metodă folosită pentru a încarca utilizatorului pe care dorim să le modificăm în formular.
         * @param sondajModifca Sondaj recuperat din formularul de căutare
         * @throws IOException posibila exceptie
         * @return pagina modificareSondaj
         */
        public String getFormModificaSondaj(final Sondaj sondajModifca) throws IOException {
                String redireccion = Constante.SPATIU;
                Sondaj scomun = new Sondaj();
                scomun = sondajService.fiindOne(sondajModifca);
                if (scomun != null) {
                        this.sondaj = scomun;
                        redireccion = "/sondaj/modificareSondaj?faces-redirect=true";
                }
                else {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.MODIFICAREMESAJ,
                                        "A apărut o eroare la accesarea sondajului. Sondajul nu există.");
                }

                return redireccion;
        }

        /**
         * Metoda Init a lui SondajBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                this.intrebari = intrebareService.findAll();
                this.incepeSondajul = Constante.SPATIU;
                this.terminaSondajul = Constante.SPATIU;
                this.sondaj = new Sondaj();
                this.sondajActiv = new Sondaj();
                this.filtruSondaj = new FiltruSondaj();
                this.list = new ArrayList<>();
                for (int i = 0; i < NUMBERCOLUMNTABLA; i++) {
                        this.list.add(Boolean.TRUE);
                }
                curatareCautareSondajActiv();
                this.model = new LazyDataSondaje(this.sondajService);
                this.modelActiv = new LazyDataSondaje(this.sondajService);
                raspuns = new RaspunsSuport();
                graficaVoturi = new PieChartModel();
                Utilitati.cautareSesiune("sondajBean");
                cautareSondajeActive();
        }

        /**
         * Metodă folosită pentru a genera un PDF cu raportul.
         * @param fileImg Fișier cu imaginea de exportat
         */
        private void obtieneInformePDF(final File fileImg) {
                try {
                        setFile(statisticaService.exportar(sondaj, fileImg));
                }
                catch (final GesintException e) {
                        registruActivitateService.salveazaRegistruInregistrareModificare(null,
                                        TipRegistruEnum.EROARE.name(), SectiuniEnum.SONDAJ.getDescriere(),
                                        e.toString());
                        final String descriere = "A apărut o eroare în obținerea unui sondaj";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a controla coloanele vizibile în lista rezultatelor motorului de căutare.
         * @param toggle ToggleEvent
         */
        public void onToggle(final ToggleEvent toggle) {
                this.list.set((Integer) toggle.getData(), toggle.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metodă folosită pentru a salva sondajul în baza de date.
         * @param sond Sondaj
         * @return pagina rezultate
         */
        public String salvatiSondajul(final Sondaj sond) {
                try {
                        this.sondaj = sond;
                        sondaj.setActiv(true);
                        sondaj.setProcentajAbt((float) 0.00);
                        sondaj.setProcentajDa((float) 0.00);
                        sondaj.setProcentajNu((float) 0.00);
                        sondaj.setTotalVoturi(0);
                        sondaj.setTotalVoturiAbt(0);
                        sondaj.setTotalVoturiDa(0);
                        sondaj.setTotalVoturiNu(0);
                        sondajService.save(sondaj);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.INREGISTRARE,
                                        "Sondajul a fost salvat cu succes.");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la salvarea Sondajului ".concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare în înregistrarea sondajului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(),
                                        e);
                }
                return "/sondaj/rezultate?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a salva votul sondajului în baza de date.
         * @param vot String
         * @return pagina rezultate /sondaj/rezultate
         */
        public String voteaza(final String vot) {
                try {
                        this.sondaj = sondajActiv;
                        selectVotSondaj(vot);
                        List<Utilizator> useri = sondaj.getUtilizatori();
                        Utilizator user = utilitati.getUtilizatorLogat();
                        useri.add(user);
                        sondaj.setUtilizatori(useri);
                        sondajService.save(sondaj);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.INREGISTRARE,
                                        "Votul dumneavoastră a fost înregistrat cu succes. Vă mulțumim!");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la salvarea Sondajului ".concat(Constante.DESCEROAREMESAJ));
                        this.registruActivitateService.salveazaRegistruEroare(SectiuniEnum.CORESPONDENTA.name(),
                                        Constante.ALERTA, e);
                        final String descriere = "A apărut o eroare în înregistrarea sondajului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(),
                                        e);
                }
                return "/sondaj/rezultate?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a selecta tipul de vot si al seta in sondaj
         * @param vot
         */
        private void selectVotSondaj(final String vot) {
                if ("da".equals(vot)) {
                        sondaj.setTotalVoturiDa(sondaj.getTotalVoturiDa() + 1);
                }
                else if ("nu".equals(vot)) {
                        sondaj.setTotalVoturiNu(sondaj.getTotalVoturiNu() + 1);
                }
                else {
                        sondaj.setTotalVoturiAbt(sondaj.getTotalVoturiAbt() + 1);
                }
                sondaj.setTotalVoturi(sondaj.getTotalVoturi() + 1);
        }

        /**
         * Metodă folosită pentru a deschide pagina pentru a înregistra un nou sondaj.
         * @return pagina creazaSondaj
         */
        public String sondajNou() {
                sondaj = new Sondaj();
                return "/sondaj/creazaSondaj?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a recupera obiectul gráfica pentru a fi aratat in pagina.
         * @return graficaVoturi
         */
        public PieChartModel getGraficaVoturi() {
                return graficaVoturi;
        }

        /**
         * Metoda care deschide dialogul pentru votarea sondajului.
         * @param sond Sondaj
         */
        public void getFormVoteazaSondaj(Sondaj sond) {
                final RequestContext context = RequestContext.getCurrentInstance();
                this.sondajActiv = sond;
                votSondaj = "abtinere";
                context.execute("PF('dialogVoteazaSondaj').show();");

        }

        /**
         * Metoda care valideaza daca utilizatorul logat poate vota sau nu.
         * @param sond Sondaj
         * @return potiVota Boolean
         */
        public Boolean valideazaVot(final Sondaj sond) {
                Boolean potiVota = true;
                final List<Utilizator> useri = sond.getUtilizatori();
                final Utilizator user = utilitati.getUtilizatorLogat();
                if (useri.isEmpty()) {
                        potiVota = true;
                }
                else {
                        for (final Utilizator utilizat : useri) {
                                // Daca utilizatorul logat a votat si se regaseste pe lista celor care au votat se
                                // ascunde iconul care permite votul
                                if (utilizat.getUsername().equals(user.getUsername())) {
                                        potiVota = false;
                                }
                        }
                }

                return potiVota;

        }

}

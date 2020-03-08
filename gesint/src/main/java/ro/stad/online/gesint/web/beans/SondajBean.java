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
import lombok.extern.slf4j.Slf4j;
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
import ro.stad.online.gesint.persistence.entities.UtilizatorSondaj;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.SituatieSondajEnum;
import ro.stad.online.gesint.services.IntrebareService;
import ro.stad.online.gesint.services.RaspunsSuportService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.SondajService;
import ro.stad.online.gesint.services.SondajVotService;
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
@Slf4j
public class SondajBean implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = NumarMagic.NUMBERONELONG;

	/**
	 * Numărul de coloane din tabelul de sondaje.
	 */
	private static final int NUMBERCOLUMNTABLA = NumarMagic.NUMBERSEVEN;

	/**
	 * Sondaj nou.
	 */
	private transient Sondaj sondaj;

	/**
	 * Sondaj activ.
	 */
	private transient Sondaj sondajActiv;

	/**
	 * Variala utilizata pentru injectarea serviciului de sondaje.
	 */
	@Autowired
	private transient SondajService sondajService;

	/**
	 * Variala utilizata pentru injectarea serviciului de votanti de sondaj.
	 */
	@Autowired
	private transient SondajVotService sondajVotService;

	/**
	 * Lazy model pentru sondaje.
	 */
	private transient LazyDataSondaje model;

	/**
	 * Lazy model pentru sondaje active .
	 */
	private transient LazyDataSondaje modelSondajeActive;

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
	private transient Utilitati utilitati;

	/**
	 * Metodă care returnează un raspuns cautat cu id-ul.
	 * @param id Long
	 * @return raspuns RaspunsSuport
	 */
	public RaspunsSuport actualizeazaRaspuns(final Long id) {
		this.idIntrebare = id;
		if (this.idIntrebare != null) {
			try {
				this.intrebare = this.intrebareService.findById(id);
				log.info("S-a obținut întrebarea");
				this.raspuns = this.raspunsSuportService.findById(intrebare);
				log.info("S-a obținut răspunsul cu id-ul întrebării ");
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, RegistruEnum.EROARE.getDescriere(),
						Constante.DESCEROAREMESAJ);
				final String descriere = "A apărut o eroare la căutarea raspunsurilor";
				this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(), e);
				log.error(descriere);

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
		this.filtruSondaj = new FiltruSondaj();
		this.filtruSondaj.setActiv(SituatieSondajEnum.ACTIV);
		this.modelSondajeActive.setCautare(this.filtruSondaj);
		this.modelSondajeActive.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
	}

	/**
	 * Metodă care generează un gráfic.
	 */
	public void createGrafica() {
		this.graficaVoturi = new PieChartModel();
		this.graficaVoturi.setShowDataLabels(true);
		this.graficaVoturi.setShowDatatip(true);
		this.graficaVoturi.setLegendPosition("w");
		this.graficaVoturi.setSeriesColors(
				"008000,00FFFF,008080,0000FF,800080,f6546a,084D6E,FFFFFF,C0C0C0,808080,d0b38e,FF0000,ec9931,FFFF00,00FF00");

	}

	/**
	 * Metodă folosită pentru a incarca datele in modelul pie
	 * @param sond Sondaj.
	 */
	private void createPieModel(final Sondaj sond) {
		this.graficaVoturi = new PieChartModel();
		this.graficaVoturi.set("DA : " + sond.getTotalVoturiDa(), sond.getTotalVoturiDa());
		this.graficaVoturi.set("NU: " + sond.getTotalVoturiNu(), sond.getTotalVoturiNu());
		this.graficaVoturi.set("ABȚINERI: " + sond.getTotalVoturiAbt(), sond.getTotalVoturiAbt());
		this.graficaVoturi.setLegendPosition(Constante.E);
		this.graficaVoturi.setFill(false);
		this.graficaVoturi.setShowDataLabels(true);
		this.graficaVoturi.setDiameter(NumarMagic.NUMBERTWOHUNDRED);
		this.graficaVoturi.setShadow(false);
	}

	/**
	 * Metodă folosită pentru a curăța filtrele de căutarea.
	 */
	public void curatareCautare() {
		this.filtruSondaj = new FiltruSondaj();
		this.model = new LazyDataSondaje(this.sondajService);
	}

	/**
	 * Metoda care descarcă un document încărcat de utilizator.
	 * @param documentul documentul selectat
	 */
	public void descarcareFisier(final Documentul documentul) {
		setFile(null);
		try {
			setFile(this.documentService.descarcareDocument(documentul));
			log.info("S-a descărcat corect fișierul  ");
		}
		catch (final GesintException e) {
			final String descriere = "A apărut o eroare la descărcarea fișierului";
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, RegistruEnum.EROARE.getDescriere(),
					descriere);
			this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.MANAGERDOCUMENTE.getDescriere(), e);
		}
	}

	/**
	 * Metodă folosită pentru a prezenta detaliul unui sondajului.
	 * @param sondaj Sondaj
	 * @return pagina detaliiSondaj
	 */
	public String detaliiSondaj(final Sondaj sond) {
		this.document = new Documentul();
		this.sondaj = sond;
		final List<Documentul> listaDoc = this.documentService.cautaDocumenteSondaj(sond);
		if (!listaDoc.isEmpty()) {
			this.document = listaDoc.get(0);
		}
		createPieModel(sondaj);
		final String pattern = "dd/MM/yyyy HH:mm:ss";
		final DateFormat df = new SimpleDateFormat(pattern);
		this.incepeSondajul = df.format(this.sondaj.getDataIncepere());
		final String pattern2 = Constante.FORMATDATE;
		final DateFormat df2 = new SimpleDateFormat(pattern2);
		this.terminaSondajul = df2.format(this.sondaj.getDataFinalizare());
		this.terminaSondajul = terminaSondajul.concat(" 23:59:59");
		return "/sondaj/detaliiSondaj?faces-redirect=true";
	}

	/**
	 * Metodă care verifică dacă data de începere a sondajului este acum sau posterioară
	 */
	private void extractValidareSondaj() {
		// Verificam daca data de incepere a sondajului este acum sau posterioara
		Boolean activar = false;
		final Date dataActuala = new Date();
		final Date dataForm = this.sondaj.getDataIncepere();
		if (dataForm.after(dataActuala) || dataForm.equals(dataActuala)) {
			activar = true;
		}
		// Daca nu este ..il punem inactiv
		if (activar) {
			this.sondaj.setActiv(SituatieSondajEnum.NEINCEPUT);
		}
		else {
			this.sondaj.setActiv(SituatieSondajEnum.ACTIV);
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
		if (imagine.split(Constante.VIRGULA).length > NumarMagic.NUMBERONE) {
			final String encoded = imagine.split(Constante.VIRGULA)[1];
			final byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(encoded);

			try {
				final RenderedImage renderedImage = ImageIO.read(new ByteArrayInputStream(decoded));
				fileImg = File.createTempFile("out", ".png");
				ImageIO.write(renderedImage, Constante.PNG, fileImg);
			}
			catch (final IOException e) {

				final String descriere = "A apărut o eroare în exportul unui sondaj în format PDF";
				this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(), e);
				log.error(descriere);
			}
		}
		obtieneInformePDF(fileImg);
	}

	/**
	 * Metodă folosită pentru a încarca datele sondajului pe care dorim să le modificăm.
	 * @param sondajModifca Sondaj recuperat din formularul de căutare
	 * @throws IOException posibila exceptie
	 * @return pagina modificareSondaj
	 */
	public String getFormModificaSondaj(final Sondaj sondajModifca) {
		String redireccion = Constante.SPATIU;
		Sondaj scomun = new Sondaj();
		scomun = this.sondajService.fiindOne(sondajModifca);
		if (scomun != null) {
			this.sondaj = scomun;
			redireccion = "/sondaj/modificareSondaj?faces-redirect=true";
		}
		else {
			final String descriere = "A apărut o eroare la accesarea sondajului. Sondajul nu există";
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, RegistruEnum.MODIFICARE.getDescriere(),
					descriere);
			log.error(descriere);
		}
		return redireccion;
	}

	/**
	 * Metoda care deschide dialogul pentru votarea sondajului.
	 * @param sond Sondaj
	 */
	public void getFormVoteazaSondaj(final Sondaj sond) {
		final RequestContext context = RequestContext.getCurrentInstance();
		this.sondajActiv = sond;
		this.votSondaj = "abtinere";
		context.execute("PF('dialogVoteazaSondaj').show();");

	}

	/**
	 * Metodă folosită pentru a recupera obiectul gráfica pentru a fi aratat in pagina.
	 * @return graficaVoturi
	 */
	public PieChartModel getGraficaVoturi() {
		return this.graficaVoturi;
	}

	/**
	 * Metoda Init a lui SondajBean.
	 * @PostConstruct
	 */
	@PostConstruct
	public void init() {
		this.intrebari = this.intrebareService.findAll();
		this.incepeSondajul = Constante.SPATIU;
		this.terminaSondajul = Constante.SPATIU;
		this.sondaj = new Sondaj();
		this.sondajActiv = new Sondaj();
		this.filtruSondaj = new FiltruSondaj();
		this.list = new ArrayList<>();
		for (int i = 0; i < NUMBERCOLUMNTABLA; i++) {
			this.list.add(Boolean.TRUE);
		}
		this.model = new LazyDataSondaje(this.sondajService);
		this.modelSondajeActive = new LazyDataSondaje(this.sondajService);
		this.raspuns = new RaspunsSuport();
		this.graficaVoturi = new PieChartModel();
		cautareSondajeActive();
		Utilitati.cautareSesiune("sondajBean");

	}

	/**
	 * Metodă folosită pentru a genera un PDF cu raportul.
	 * @param fileImg Fișier cu imaginea de exportat
	 */
	private void obtieneInformePDF(final File fileImg) {
		try {
			setFile(this.statisticaService.exportar(this.sondaj, fileImg));
		}
		catch (final GesintException e) {
			final String descriere = "A apărut o eroare în obținerea unui sondaj";
			this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(), e);
			log.error(descriere);
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
			extractValidareSondaj();

			this.sondaj.setProcentajAbt((float) NumarMagic.ZEROZERO);
			this.sondaj.setProcentajDa((float) NumarMagic.ZEROZERO);
			this.sondaj.setProcentajNu((float) NumarMagic.ZEROZERO);
			this.sondaj.setTotalVoturi(NumarMagic.NUMBERZERO);
			this.sondaj.setTotalVoturiAbt(NumarMagic.NUMBERZERO);
			this.sondaj.setTotalVoturiDa(NumarMagic.NUMBERZERO);
			this.sondaj.setTotalVoturiNu(NumarMagic.NUMBERZERO);
			this.sondajService.save(this.sondaj);
			final String descriere = "Sondajul a fost salvat cu succes: ";
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
					RegistruEnum.INREGISTRARE.getDescriere(), descriere);

			this.regActividadService.inregistrareRegistruActivitate(descriere, RegistruEnum.INREGISTRARE.getName(),
					SectiuniEnum.SONDAJ.getName(), utilitati.getUtilizatorLogat());
			log.info(descriere);
		}
		catch (final DataAccessException e) {
			final String descriere = "A apărut o eroare în înregistrarea sondajului ";
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, RegistruEnum.EROARE.getDescriere(),
					descriere.concat(Constante.DESCEROAREMESAJ));

			this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(), e);
			log.error(descriere);
		}
		return "/sondaj/rezultate?faces-redirect=true";
	}

	/**
	 * Metodă folosită pentru a selecta tipul de vot și al seta în sondaj
	 * @param vot
	 */
	private void selectVotSondaj(final String vot) {
		if ("da".equals(vot)) {
			this.sondaj.setTotalVoturiDa(this.sondaj.getTotalVoturiDa() + NumarMagic.NUMBERONE);
		}
		else if ("nu".equals(vot)) {
			this.sondaj.setTotalVoturiNu(this.sondaj.getTotalVoturiNu() + NumarMagic.NUMBERONE);
		}
		else {
			this.sondaj.setTotalVoturiAbt(this.sondaj.getTotalVoturiAbt() + NumarMagic.NUMBERONE);
		}
		this.sondaj.setTotalVoturi(this.sondaj.getTotalVoturi() + NumarMagic.NUMBERONE);
	}

	/**
	 * Metodă folosită pentru a dechide formularul de înregistrare al sondajelor noi, inițializând tot ceea ce este
	 * necesar pentru afișarea corectă a paginii (enums, sondaj nou,..etc).
	 * @return pagina creazaSondaj
	 */
	public String sondajNou() {
		this.sondaj = new Sondaj();
		return "/sondaj/creazaSondaj?faces-redirect=true";
	}

	/**
	 * Metoda care valideaza daca utilizatorul logat poate vota sau nu.
	 * @param sond Sondaj
	 * @return potiVota Boolean
	 */
	public Boolean valideazaVot(final Sondaj sond) {
		Boolean potiVota = true;
		final List<UtilizatorSondaj> useriSondaj = sondajVotService.findAllBySondaj(sond);
		final Utilizator user = this.utilitati.getUtilizatorLogat();
		if (!useriSondaj.isEmpty()) {
			for (final UtilizatorSondaj utilizat : useriSondaj) {
				// Daca utilizatorul logat a votat si se regaseste pe lista celor care au votat se
				// ascunde iconul care permite votul
				if (utilizat.getUsername().getUsername().equals(user.getUsername())) {
					potiVota = false;
				}
			}
		}

		return potiVota;

	}

	/**
	 * Metodă folosită pentru a salva votul sondajului în baza de date.
	 * @param vot String
	 * @return pagina rezultate /sondaj/rezultate
	 */
	public String voteaza(final String vot) {
		try {
			this.sondaj = this.sondajActiv;
			selectVotSondaj(vot);
			final Utilizator user = this.utilitati.getUtilizatorLogat();
			final UtilizatorSondaj userSondaj = new UtilizatorSondaj();
			userSondaj.setSondaj(this.sondaj);
			userSondaj.setUsername(user);
			this.sondajVotService.save(userSondaj);
			this.sondajService.save(this.sondaj);
			final String descriere = "Votul dumneavoastră a fost înregistrat cu succes. Vă mulțumim! ";
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
					RegistruEnum.INREGISTRARE.getDescriere(), descriere);
			log.info(descriere);
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, RegistruEnum.EROARE.getDescriere(),
					"A apărut o eroare la salvarea Sondajului ".concat(Constante.DESCEROAREMESAJ));
			final String descriere = "A apărut o eroare în înregistrarea sondajului";
			this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(), e);
			log.error(descriere);
		}
		return "/sondaj/rezultate?faces-redirect=true";
	}

}

package ro.per.online.web.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.per.online.constantes.Constantes;
import ro.per.online.modelo.dao.StatisticaDAO;
import ro.per.online.modelo.dao.StatisticaJudetDAO;
import ro.per.online.modelo.dto.estadisticas.StatisticaDTO;
import ro.per.online.modelo.dto.estadisticas.StatisticaJudetDTO;
import ro.per.online.modelo.filters.StatisticaBusqueda;
import ro.per.online.modelo.filters.StatisticaJudeteBusqueda;
import ro.per.online.persistence.entities.pojo.PersoaneAn;
import ro.per.online.util.Utilities;

/**
 * Bean para la página de Home .
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("homeBean")
@Scope(Constantes.SESSION)
@Slf4j
public class HomeBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constante para las trazas de login
	 */
	private static final Logger LOG = LoggerFactory.getLogger(HomeBean.class.getSimpleName());

	/**
	 * Variabila pentru datele de cautare ale statisticii.
	 */
	private StatisticaBusqueda statisticaBusqueda;

	/**
	 * Variabila pentru datele de cautare ale statisticii.
	 */
	private StatisticaJudeteBusqueda filterStatisticaJudet;

	/**
	 * Variabila pentru datele de cautare ale statisticii.
	 */
	private StatisticaJudeteBusqueda statisticaJudeteBusqueda;

	/**
	 * Variabila pentru List<StatisticaDTO>.
	 */
	private List<StatisticaDTO> statisticaDTO;

	/**
	 * Variabila pentru serviciul de statistica.
	 */
	@Autowired
	private transient StatisticaDAO statisticaService;

	/**
	 * Variabila pentru serviciul de statistica.
	 */
	@Autowired
	private transient StatisticaJudetDAO statisticaJudetService;

	/**
	 * Variabila pentru statisticaDTO.
	 */
	private StatisticaDTO statistica;

	/**
	 * Variabila pentru chart de tipul pie
	 */
	private PieChartModel graficaUserUltimMembru;

	/**
	 * Variabila pentru chart de tipul pie
	 */
	private PieChartModel graficaUserVarsta;

	/**
	 * Variabila pentru chart de tipul pie
	 */
	private PieChartModel graficaUserEducatie;

	/**
	 * Variabila pentru chart de tipul pie
	 */
	private PieChartModel graficaUserSex;

	/**
	 * Variabila pentru chart de tipul pie
	 */
	private PieChartModel graficaUserZona;

	/**
	 * Variabila pentru chart de tipul orizontal
	 */
	private HorizontalBarChartModel horizontalBarModel;

	/**
	 * Variabila pentru numarul maxim
	 */
	private Integer numarMaxim;

	/**
	 * Variabila pentru a incarca datele membrilor
	 */
	private Map<String, Integer> listaUsuarios;

	/**
	 *
	 */
	private BarChartModel barModel;

	/**
	 * String
	 */
	private String current_date;

	/**
	 * Procentaj total membrii
	 */
	private Float procentajTotalMembrii;

	/**
	 * Procentaj total membrii ultimul an
	 */
	private Float procentajTotalMembriiUltimAn;

	/**
	 * Variabila de definitie a procentajului
	 */
	private String valoare;

	/**
	 * Variabila de text
	 */
	private String textMaiMare;

	/**
	 * Variabila de text
	 */
	private String textMaiMareMediu;

	/**
	 * Variabila de text
	 */
	private String textValorarProcentaj;

	/**
	 * Variabila de text
	 */
	private List<PersoaneAn> listaUsuariosAn;

	/**
	 * Variabila procentaj
	 */
	private Float procentaj;

	/**
	 * Variabila media procentaj anual
	 */
	private Float mediaProcentaj;

	/**
	 * Variabila listaJudeteSuperior
	 */
	private List<StatisticaJudetDTO> listaJudeteSuperior;

	/**
	 * Variabila listaJudeteSuperior
	 */
	private List<StatisticaJudetDTO> listaJudeteInferior;

	/**
	 * Variabila listaJudeteSuperior
	 */
	private List<StatisticaJudetDTO> listaJudeteSuperiorProcentaj;

	/**
	 * Variabila listaJudeteSuperior
	 */
	private List<StatisticaJudetDTO> listaJudeteInferiorProcentaj;

	/**
	 * Método inicializador del bean.
	 */
	@PostConstruct
	public void init() {
		crearStatisticaGeneral();

	}

	/**
	 *
	 */
	private void crearStatisticaGeneral() {
		statisticaBusqueda = new StatisticaBusqueda();
		statisticaJudeteBusqueda = new StatisticaJudeteBusqueda();
		initListas();
		statistica = new StatisticaDTO();
		cautareDateFiltru();
		obtinemDate();
		obtenerProcentajTotal();
		dataString();
		obtenerText();
		obtenerTextMediu();
		cargaLista(statistica);
		obtenemosValoareaProcentajului();
		obtenerProcentajTotalUltimulAn();
		createBarModel();
		createPieModels();
		createHorizontalBarModel();
		cargaDatosListaAnual();
		calcularMediaProcentaj();
		obtenerTextProcentaj();
		obtenerStatisticaSupInf();
	}

	/**
	 *
	 */
	private void initListas() {
		statisticaDTO = new ArrayList<>();
		listaJudeteSuperior = new ArrayList<>();
		listaJudeteInferior = new ArrayList<>();
		listaJudeteSuperiorProcentaj = new ArrayList<>();
		listaJudeteInferiorProcentaj = new ArrayList<>();
	}

	/**
	 * Metoda care obtine cele mai bune si slabe judete
	 */
	private void obtenerStatisticaSupInf() {
		obtenerJudetSuperior();
		obtenerJudetInferior();
		obtenerJudetSuperiorProcentaj();
		obtenerJudetInferiorProcentaj();
	}

	/**
	 * Metoda care obtine cele mai bune judete
	 */
	private void obtenerJudetSuperior() {
		statisticaJudeteBusqueda.setDescendent("DESC");
		listaJudeteSuperior = statisticaJudetService.filterStatisticaJudet(statisticaJudeteBusqueda);
	}

	/**
	 * Metoda care obtine cele mai slabe judete
	 */
	private void obtenerJudetInferior() {
		statisticaJudeteBusqueda.setDescendent("ASC");
		listaJudeteInferior = statisticaJudetService.filterStatisticaJudet(statisticaJudeteBusqueda);
	}

	/**
	 * Metoda care obtine cele mai bune judete
	 */
	private void obtenerJudetSuperiorProcentaj() {
		statisticaJudeteBusqueda.setDescendent("DESC");
		statisticaJudeteBusqueda.setGeneralJudetProcentaj("NO");
		listaJudeteSuperiorProcentaj = statisticaJudetService.filterStatisticaJudetProcentaj(statisticaJudeteBusqueda);
	}

	/**
	 * Metoda care obtine cele mai slabe judete
	 */
	private void obtenerJudetInferiorProcentaj() {
		statisticaJudeteBusqueda.setDescendent("ASC");
		statisticaJudeteBusqueda.setGeneralJudetProcentaj("NO");
		listaJudeteInferiorProcentaj = statisticaJudetService.filterStatisticaJudetProcentaj(statisticaJudeteBusqueda);
	}

	/**
	 *
	 * Metoda care selecteaza textul
	 */
	private void obtenerText() {
		textMaiMare = Constantes.ESPACIO;
		if (statistica.getTotalBarbati() > statistica.getTotalFemei()) {
			textMaiMare = "este mai mare";
		}
		else {
			textMaiMare = "este mai mic";
		}
	}

	/**
	 *
	 * Metoda care selecteaza textul
	 */
	private void obtenerTextMediu() {
		textMaiMareMediu = Constantes.ESPACIO;
		if (statistica.getMediuRural() > statistica.getMediuUrban()) {
			textMaiMareMediu = "este mai mare";
		}
		else {
			textMaiMareMediu = "este mai mic";
		}
	}

	/**
	 *
	 *
	 */
	private void obtenemosValoareaProcentajului() {
		valoare = Constantes.ESPACIO;
		if (procentajTotalMembrii >= 0.40) {
			valoare = "EXCELENT";
		}
		else if (procentajTotalMembrii < 0.40 && procentajTotalMembrii >= 0.25) {
			valoare = "BUN";
		}
		else if (procentajTotalMembrii < 0.25 && procentajTotalMembrii >= 0.10) {
			valoare = "ACCEPTABIL";
		}
		else {
			valoare = "NECONVINGATOR";
		}
	}

	/**
	 *
	 * Metoda care calculeaza procentajul total de membrii
	 */
	private void obtenerProcentajTotal() {
		final int num = statistica.getNumarTotal() * 100;
		final float div = ((float) num / statistica.getTotalVot());
		final float divFinal = Math.round(div * 100) / 100f;
		procentajTotalMembrii = divFinal;
	}

	/**
	 *
	 * Metoda care calculeaza procentajul total de membrii ultimul an
	 */
	private void obtenerProcentajTotalUltimulAn() {
		final int num = statistica.getTotalUltimAn() * 100;
		final float div = ((float) num / statistica.getNumarTotal());
		final float divFinal = Math.round(div * 100) / 100f;
		procentajTotalMembriiUltimAn = divFinal;
	}

	/**
	 * Transformar date in String
	 *
	 */
	private void dataString() {
		final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		current_date = df.format(statisticaBusqueda.getFechaDesde());
	}

	/**
	 *
	 */
	private void obtinemDate() {
		statisticaDTO = statisticaService.filterGeneraleStatistica(statisticaBusqueda);
		if (!statisticaDTO.isEmpty()) {
			statistica = statisticaDTO.get(0);
		}
	}

	/**
	 * Metoda de incarcare de date in filtru
	 */
	private void cautareDateFiltru() {
		statisticaBusqueda.setFechaDesde(new Date());
		statisticaBusqueda.setFechaUltimAn(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 1));
		statisticaBusqueda.setFechaUltimiDoiAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 2));
		statisticaBusqueda.setFechaUltimiTreiAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 3));
		statisticaBusqueda.setFechaUltimiPatruAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 4));
		statisticaBusqueda.setFechaUltimiCinciAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 5));
		statisticaBusqueda.setFechaUltimaLuna(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 1));
		statisticaBusqueda.setFechaUltimDouaLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 2));
		statisticaBusqueda.setFechaUltimTreiLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 3));
		statisticaBusqueda.setFechaUltimPatruLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 4));
		statisticaBusqueda.setFechaUltimCinciLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 5));
		statisticaBusqueda.setFechaUltimSaseLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 6));
		statisticaBusqueda.setFechaUltimSapteLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 7));
		statisticaBusqueda.setFechaUltimOptLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 8));
		statisticaBusqueda.setFechaUltimNouaLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 9));
		statisticaBusqueda.setFechaUltimZeceLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 10));
		statisticaBusqueda.setFechaUltimUnspeLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 11));

		statisticaBusqueda.setFechaUltimaLunaAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 1));
		statisticaBusqueda
				.setFechaUltimDouaLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 2));
		statisticaBusqueda
				.setFechaUltimTreiLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 3));
		statisticaBusqueda
				.setFechaUltimPatruLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 4));
		statisticaBusqueda
				.setFechaUltimCinciLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 5));
		statisticaBusqueda
				.setFechaUltimSaseLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 6));
		statisticaBusqueda
				.setFechaUltimSapteLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 7));
		statisticaBusqueda
				.setFechaUltimOptLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 8));
		statisticaBusqueda
				.setFechaUltimNouaLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 9));
		statisticaBusqueda
				.setFechaUltimZeceLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 10));
		statisticaBusqueda
				.setFechaUltimUnspeLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 11));
		statisticaBusqueda.setFechaPana25(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 25));
		statisticaBusqueda.setFechaPana40(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 40));
		statisticaBusqueda.setFechaPana60(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 60));
	}

	/**
	 * Cargar datos estadísticos.
	 */
	private Date calculaRestarFechaAn(final Date fecha, final int numarAn) {
		final Date newDate = fecha;
		final Calendar calDesde = Calendar.getInstance();
		calDesde.setTime(newDate);
		final Calendar calHasta = Calendar.getInstance();
		final int anulProv = calDesde.get(Calendar.YEAR);
		final int luna = calDesde.get(Calendar.MONTH);
		final int zi = calDesde.get(Calendar.DAY_OF_MONTH);
		final int anFinal = anulProv - numarAn;
		calHasta.set(anFinal, luna, zi);
		final Date fechaHasta = calHasta.getTime();
		return fechaHasta;
	}

	/**
	 * Cargar datos estadísticos.
	 */
	private Date calculaRestarFechaLuna(final Date fecha, final int numarLuna) {
		final Date newDate = fecha;
		final Calendar calDesde = Calendar.getInstance();
		calDesde.setTime(newDate);
		final Calendar calHasta = Calendar.getInstance();
		final int anFinal = calDesde.get(Calendar.YEAR);
		final int lunaProv = calDesde.get(Calendar.MONTH);
		final int zi = calDesde.get(Calendar.DAY_OF_MONTH);
		final int luna = lunaProv - numarLuna;
		calHasta.set(anFinal, luna, zi);
		final Date fechaHasta = calHasta.getTime();
		return fechaHasta;
	}

	/**
	 *
	 *
	 *
	 */
	private void createBarModel() {
		barModel = initBarModel();
		barModel.setTitle("Comparativă Prezent/Anul trecut");
		barModel.setLegendPosition("w");
		numarMaxim = 0;
		final Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Perioada");

		final Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Membrii");
		yAxis.setMin(0);
		if (statistica.getTotalUltimiDoiAni() > statistica.getTotalUltimAn()) {
			numarMaxim = statistica.getTotalUltimiDoiAni();
		}
		else {
			numarMaxim = statistica.getTotalUltimAn();
		}
		calculaNumMax();
		yAxis.setMax(numarMaxim);
	}

	/**
	 * Metoda care calculeaza numarul maxim
	 *
	 */
	private void calculaNumMax() {
		if (numarMaxim < 100) {
			numarMaxim = 50 + numarMaxim;
		}
		else if (numarMaxim >= 100 && numarMaxim < 500) {
			numarMaxim = 300 + numarMaxim;
		}
		else if (numarMaxim >= 500 && numarMaxim < 3000) {
			numarMaxim = 800 + numarMaxim;
		}
		else {
			numarMaxim = 2500 + numarMaxim;
		}
	}

	/**
	 * Model de chart statistica
	 * @return
	 *
	 */
	private BarChartModel initBarModel() {
		final BarChartModel model = new BarChartModel();
		final ChartSeries boys = new ChartSeries();
		boys.setLabel("Membri anul în curs");
		boys.set("Ultima lună", statistica.getTotalUltimaLuna());
		boys.set("Ultimele trei luni", statistica.getTotalUltimTreiLuni());
		boys.set("Ultimele șase luni", statistica.getTotalUltimSaseLuni());
		boys.set("Ultimul an", statistica.getTotalUltimAn());
		final ChartSeries girls = new ChartSeries();
		girls.setLabel("Membri anul trecut");
		girls.set("Luna corespondiente a anului trecut", statistica.getTotalUltimaLunaAnAtras());
		girls.set("Ultimele trei luni ale anului trecut", statistica.getTotalUltimTreiLuniAnAtras());
		girls.set("Ultimele șase luni ale anului trecut", statistica.getTotalUltimSaseLuniAnAtras());
		girls.set("Anul trecut", statistica.getTotalUltimiDoiAni());
		model.addSeries(boys);
		model.addSeries(girls);
		return model;
	}

	/**
	 * Metoda de incarcare date in chart de tipul pie
	 *
	 *
	 */
	private void createPieModels() {
		createPieModelSex();
		createPieModelZona();
		createPieModel2();
		createPieModel3();
		createPieModel4();
	}

	/**
	 * Incarcam datele in modelul pie
	 *
	 *
	 */
	private void createPieModel2() {
		graficaUserUltimMembru = new PieChartModel();
		graficaUserUltimMembru.set("Înregistrați în ultima lună:  " + statistica.getTotalUltimaLuna(),
				statistica.getTotalUltimaLuna());
		graficaUserUltimMembru.set("Înregistrați în ultimele trei luni:  " + statistica.getTotalUltimTreiLuni(),
				statistica.getTotalUltimTreiLuni() - statistica.getTotalUltimaLuna());
		graficaUserUltimMembru.set("Înregistrați în ultimele sase luni:  " + statistica.getTotalUltimSaseLuni(),
				statistica.getTotalUltimSaseLuni() - statistica.getTotalUltimTreiLuni());
		graficaUserUltimMembru.set("Înregistrați în ultimul an: " + statistica.getTotalUltimAn(),
				statistica.getTotalUltimAn() - statistica.getTotalUltimSaseLuni());
		graficaUserUltimMembru.setTitle("Membrii noi înregistrați");
		graficaUserUltimMembru.setLegendPosition("e");
		graficaUserUltimMembru.setFill(false);
		graficaUserUltimMembru.setShowDataLabels(true);
		graficaUserUltimMembru.setDiameter(150);
		graficaUserUltimMembru.setShadow(false);
	}

	/**
	 * Incarcam datele in modelul pie
	 *
	 *
	 */
	private void createPieModel3() {
		graficaUserVarsta = new PieChartModel();
		graficaUserVarsta.set("Până în 25 de ani: ", statistica.getTotalPana25());
		graficaUserVarsta.set("Între 25 și 40 de ani: ", statistica.getTotalPana40());
		graficaUserVarsta.set("Între 40 și 60 de ani: ", statistica.getTotalPana60());
		graficaUserVarsta.set("Peste 60 de ani: ", statistica.getTotalPanaMayor60());
		graficaUserVarsta.setLegendPosition("ne");
		graficaUserVarsta.setFill(false);
		graficaUserVarsta.setShowDataLabels(true);
		graficaUserVarsta.setDiameter(150);
		graficaUserVarsta.setShadow(false);
	}

	/**
	 * Incarcam datele in modelul pie
	 *
	 *
	 */
	private void createPieModel4() {
		graficaUserEducatie = new PieChartModel();
		graficaUserEducatie.set("Studii bazice: ", statistica.getTotalBazice());
		graficaUserEducatie.set("Studii medii: ", statistica.getTotalcuLiceu());
		graficaUserEducatie.set("Studii superioare: ", statistica.getTotalStudiiSup());
		graficaUserEducatie.setLegendPosition("ne");
		graficaUserEducatie.setFill(false);
		graficaUserEducatie.setShowDataLabels(true);
		graficaUserEducatie.setDiameter(150);
		graficaUserEducatie.setShadow(false);
	}

	/**
	 * Incarcam datele in modelul pie
	 *
	 *
	 */
	private void createPieModelSex() {
		graficaUserSex = new PieChartModel();
		graficaUserSex.set("Femei:  " + statistica.getTotalFemei(), statistica.getTotalFemei());
		graficaUserSex.set("Bărbați:  " + statistica.getTotalBarbati(), statistica.getTotalBarbati());
		graficaUserSex.setLegendPosition("ne");
		graficaUserSex.setFill(false);
		graficaUserSex.setShowDataLabels(true);
		graficaUserSex.setDiameter(150);
		graficaUserSex.setShadow(false);
	}

	/**
	 * Incarcam datele in modelul pie
	 *
	 *
	 */
	private void createPieModelZona() {
		graficaUserZona = new PieChartModel();
		graficaUserZona.set("Rural:  " + statistica.getMediuRural(), statistica.getMediuRural());
		graficaUserZona.set("Urban:  " + statistica.getMediuUrban(), statistica.getMediuUrban());
		graficaUserZona.setLegendPosition("ne");
		graficaUserZona.setFill(false);
		graficaUserZona.setShowDataLabels(true);
		graficaUserZona.setDiameter(150);
		graficaUserZona.setShadow(false);
	}

	/**
	 * Metoda care incarca datele in orizontal mar model de chart
	 */
	private void createHorizontalBarModel() {
		horizontalBarModel = new HorizontalBarChartModel();
		numarMaxim = 0;
		final ChartSeries boys = new ChartSeries();
		boys.setLabel("Membrii noi");
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaDesde())), statistica.getTotalUltimaLuna());
		numarMaxim = statistica.getTotalUltimaLuna();
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimaLuna())), statistica.getTotalUltimDouaLuni());
		if (statistica.getTotalUltimDouaLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimDouaLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimDouaLuni())),
				statistica.getTotalUltimTreiLuni());
		if (statistica.getTotalUltimTreiLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimTreiLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimTreiLuni())),
				statistica.getTotalUltimPatruLuni());
		;
		if (statistica.getTotalUltimPatruLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimPatruLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimPatruLuni())),
				statistica.getTotalUltimCinciLuni());
		if (statistica.getTotalUltimCinciLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimCinciLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimCinciLuni())),
				statistica.getTotalUltimSaseLuni());
		if (statistica.getTotalUltimSaseLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimSaseLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimSaseLuni())),
				statistica.getTotalUltimSapteLuni());
		if (statistica.getTotalUltimSapteLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimSapteLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimSapteLuni())),
				statistica.getTotalUltimOptLuni());
		if (statistica.getTotalUltimOptLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimOptLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimOptLuni())),
				statistica.getTotalUltimNouaLuni());
		if (statistica.getTotalUltimNouaLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimNouaLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimNouaLuni())),
				statistica.getTotalUltimZeceLuni());
		if (statistica.getTotalUltimZeceLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimZeceLuni();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimZeceLuni())),
				statistica.getTotalUltimUnspeLuni());
		if (statistica.getTotalUltimUnspeLuni() > numarMaxim) {
			numarMaxim = statistica.getTotalUltimAn();
		}
		boys.set(Utilities.luna(getFecha(statisticaBusqueda.getFechaUltimUnspeLuni())), statistica.getTotalLuna12());
		horizontalBarModel.addSeries(boys);
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		final Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Membrii");
		xAxis.setMin(0);
		calculaNumMax();

		xAxis.setMax(numarMaxim);

		final Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Lună");
		log.debug("Orixontal bar: " + boys);
		LOG.info("Orixontal bar: " + String.valueOf(boys));
	}

	public static String getFecha(Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		final SimpleDateFormat df = new SimpleDateFormat("MMMMM");
		date = cal.getTime();
		return df.format(date);
	}

	/**
	 *
	 * Incarcam datele.
	 *
	 */
	private void cargaLista(final StatisticaDTO statistica) {
		listaUsuarios = new HashMap<String, Integer>();
		listaUsuarios.put("Înregistrați în ultima lună:", statistica.getTotalUltimaLuna());
		listaUsuarios.put("Înregistrați în ultimele trei luni:", statistica.getTotalUltimTreiLuni());
		listaUsuarios.put("Înregistrați în ultimele sase luni:", statistica.getTotalUltimSaseLuni());
		listaUsuarios.put("Înregistrați în ultimul an:", statistica.getTotalUltimAn());
	}

	/**
	 *
	 *
	 */
	private void cargaDatosListaAnual() {
		listaUsuariosAn = new ArrayList<>();
		final Calendar calHasta = Calendar.getInstance();
		int anul = calHasta.get(Calendar.YEAR);
		Date data = new Date();
		String numeLuna = (Utilities.obtinemNumeLuna(data)).substring(0, 3);
		PersoaneAn persoane = new PersoaneAn();
		persoane.setAn(numeLuna + " " + String.valueOf(anul) + " --> " + numeLuna + " " + String.valueOf(anul - 1));
		persoane.setNumar(statistica.getTotalUltimAn());
		persoane.setProcentaj(procentajTotalMembriiUltimAn);
		listaUsuariosAn.add(persoane);
		PersoaneAn persoane2 = new PersoaneAn();
		persoane2
				.setAn(numeLuna + " " + String.valueOf(anul - 1) + " --> " + numeLuna + " " + String.valueOf(anul - 2));
		persoane2.setNumar(statistica.getTotalUltimiDoiAni());
		persoane2.setProcentaj(obtenerProcentajTotalAn(statistica.getTotalUltimiDoiAni()));
		listaUsuariosAn.add(persoane2);
		PersoaneAn persoane3 = new PersoaneAn();
		persoane3
				.setAn(numeLuna + " " + String.valueOf(anul - 2) + " --> " + numeLuna + " " + String.valueOf(anul - 3));
		persoane3.setNumar(statistica.getTotalUltimiiTreiAni());
		persoane3.setProcentaj(obtenerProcentajTotalAn(statistica.getTotalUltimiiTreiAni()));
		listaUsuariosAn.add(persoane3);
		PersoaneAn persoane4 = new PersoaneAn();
		persoane4
				.setAn(numeLuna + " " + String.valueOf(anul - 3) + " --> " + numeLuna + " " + String.valueOf(anul - 4));
		persoane4.setNumar(statistica.getTotalUltimiiPatruAni());
		persoane4.setProcentaj(obtenerProcentajTotalAn(statistica.getTotalUltimiiPatruAni()));
		listaUsuariosAn.add(persoane4);
		PersoaneAn persoane5 = new PersoaneAn();
		persoane5
				.setAn(numeLuna + " " + String.valueOf(anul - 4) + " --> " + numeLuna + " " + String.valueOf(anul - 5));
		persoane5.setNumar(statistica.getTotalUltimiiCinciAni());
		persoane5.setProcentaj(obtenerProcentajTotalAn(statistica.getTotalUltimiiCinciAni()));
		listaUsuariosAn.add(persoane5);
		PersoaneAn persoane6 = new PersoaneAn();
		persoane6.setAn("Anterior " + (anul - 5));
		persoane6.setNumar(statistica.getTotalAntCinciAni());
		persoane6.setProcentaj(obtenerProcentajTotalAn(statistica.getTotalAntCinciAni()));
		listaUsuariosAn.add(persoane6);
	}

	/**
	 *
	 * Metoda care calculeaza procentajul total de membrii ultimul an
	 */
	private Float obtenerProcentajTotalAn(int an) {
		final int num = an * 100;
		final float div = ((float) num / statistica.getNumarTotal());
		final float divFinal = Math.round(div * 100) / 100f;
		return divFinal;
	}

	private Float calcularMediaProcentaj() {
		mediaProcentaj = (listaUsuariosAn.get(1).getProcentaj() + listaUsuariosAn.get(2).getProcentaj()
				+ listaUsuariosAn.get(3).getProcentaj() + listaUsuariosAn.get(4).getProcentaj()
				+ listaUsuariosAn.get(5).getProcentaj()) / 5;
		return mediaProcentaj;

	}

	private void obtenerTextProcentaj() {
		if (mediaProcentaj > procentajTotalMembriiUltimAn) {
			textValorarProcentaj = "SCADERE";
			if ((mediaProcentaj - procentajTotalMembriiUltimAn) > 3) {
				textValorarProcentaj = "SCADERE IMPORTANTĂ";
			}
		}
		else {
			textValorarProcentaj = "CREȘTERE";
			if ((procentajTotalMembriiUltimAn - mediaProcentaj) > 3) {
				textValorarProcentaj = "CREȘTERE IMPORTANTĂ";
			}
		}
	}
}

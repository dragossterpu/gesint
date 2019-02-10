package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Mapa;
import ro.per.online.persistence.entities.Statistica;
import ro.per.online.persistence.entities.enums.SexEnum;
import ro.per.online.persistence.entities.enums.TipStatisticaEnum;
import ro.per.online.persistence.entities.pojo.AnNumarPojo;
import ro.per.online.services.MapaService;
import ro.per.online.services.StatisticaService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;

/**
 * Clase utilizada pentru a incarca statistica
 *
 * @author STAD
 *
 */
@Component("statisticaBean")
@Setter
@Getter
@NoArgsConstructor
@Scope(Constantes.SESSION)
public class StatisticaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Variala utilizata pentru injectarea serviciului de mapa.
	 *
	 */
	@Autowired
	private transient MapaService mapaService;

	/**
	 * Variabila pentru mapa.
	 */
	private transient Mapa selectedMap;

	/**
	 * Lista registrelor din mapa.
	 */
	private List<Mapa> listaMapa;

	/**
	 * Lista registrelor din mapa.
	 */
	private List<Statistica> listaJudete;

	/**
	 * Service de Statistica.
	 */
	@Autowired
	private transient StatisticaService statisticaService;

	private String mapCode;

	/**
	 * Variabila pentru numarul total de membrii
	 */
	private Long rowCount;

	/**
	 * Servicio de usuarios.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Objeto de búsqueda de usuario.
	 */
	private UsuarioBusqueda userBusqueda;

	/**
	 * Lista de booleanos para el control de la visualización de columnas en la vista.
	 */
	private List<Boolean> list;

	/**
	 * Variaqbila pentrub a indica perioada statisticii
	 */
	private String luna;

	/**
	 * Model de prezentare total membrii anual
	 */
	private BarChartModel totalMembriiModel;

	/**
	 * Variabila pentru numarul maxim
	 */
	private Integer numarMaxim;

	/**
	 * Variabila pentru modelul de procentaj ales
	 */
	PieChartModel pieModel;

	/**
	 * Inițializarea datelor.
	 */
	@PostConstruct
	public void init() {
		luna = Constantes.ESPACIO;
		createAnimatedModels();
		this.selectedMap = new Mapa();
		this.listaMapa = new ArrayList<>();
		this.listaJudete = new ArrayList<>();
		final String marca = Utilities.obtinemMarca();
		listaJudete = statisticaService.findByTipStatisticaAndMarcaAndIsjudet(TipStatisticaEnum.LUNAR, marca, true);
		if (!listaJudete.isEmpty()) {
			luna = listaJudete.get(0).getMarca();
		}
		rowCount = userService.findCount();
		cautareMapas();
		createPieModel();
	}

	/**
	 *
	 *
	 */
	private void cautareMapas() {
		listaMapa = mapaService.fiindAll();
		System.out.println(listaMapa.size());
	}

	/**
	 * Limpia la lista de solicitudes y la solicitud.
	 */
	public void detalleMapa(final Mapa mapa) {
		FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
				"EIntram un detalle mapa.");
		final RequestContext context = RequestContext.getCurrentInstance();
		System.out.println("suntem aici");
	}

	/**
	 * Evento para el control de cambio de pestaña de grupo de datos(Membrii noi, Organizatia sau Rezultate).
	 * @param event TabChangeEvent
	 */
	public void cambioTipStatistica(final TabChangeEvent event) {
		FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
				"Evento para el control de cambio de pestaña de grupo de datos.");

	}

	/**
	 * Activați / dezactivați vizibilitatea coloanelor din tabelul cu rezultate.
	 *
	 * @param e checkbox al coloanei selectate
	 */
	public void onToggle(final ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	/**
	 *
	 * Modelul de prezentare para statistica totala
	 *
	 */
	private void createAnimatedModels() {
		totalMembriiModel = initBarModel();
		totalMembriiModel.setTitle("Membrii înregistraţi anual");
		totalMembriiModel.setAnimate(true);
		totalMembriiModel.setLegendPosition("ne");
		Axis yAxis = totalMembriiModel.getAxis(AxisType.Y);
		yAxis = totalMembriiModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
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
		yAxis.setMax(numarMaxim);
	}

	private BarChartModel initBarModel() {
		final BarChartModel model = new BarChartModel();
		final Long numero = null;

		final List<SexEnum> listaSex = Arrays.stream(SexEnum.values()).collect(Collectors.toList());
		final Calendar calDesde = Calendar.getInstance();
		final Calendar calHasta = Calendar.getInstance();
		final ChartSeries boys = new ChartSeries();
		final ChartSeries girls = new ChartSeries();
		numarMaxim = 100;

		for (final SexEnum sex : listaSex) {
			final Calendar calendar = Calendar.getInstance();
			int anulFinal = calendar.get(Calendar.YEAR);
			anulFinal = anulFinal + 1;
			for (int i = 0; i <= 6; i++) {
				anulFinal = anulFinal - 1;
				calDesde.set(anulFinal, 0, 1);
				calHasta.set(anulFinal, 11, 31);
				final Date fechaDesde = calDesde.getTime();
				final Date fechaHasta = calHasta.getTime();
				final AnNumarPojo membru = new AnNumarPojo();
				membru.setDesde(fechaDesde);
				membru.setHasta(fechaHasta);
				membru.setSex(sex);
				final Integer numar = userService.findUsersBySex(membru);

				if (sex.getName().equals("MAN")) {
					boys.setLabel("Bărbaţi");
					boys.set(String.valueOf(anulFinal), numar);
					if (numar > numarMaxim) {
						numarMaxim = 100 + numar;
					}
				}
				else {
					girls.setLabel("Femei");
					girls.set(String.valueOf(anulFinal), numar);
					if (numar > numarMaxim) {
						numarMaxim = 100 + numar;
					}
				}
			}

		}
		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	private void createPieModel() {
		pieModel = new PieChartModel();
		for (final Statistica stat : listaJudete) {
			pieModel.set(stat.getNume(), stat.getMembrii());
		}
		pieModel.setTitle("Situaţie membrii judeţe");
		pieModel.setLegendPosition("e");
		pieModel.setFill(false);
		pieModel.setShowDataLabels(true);
		pieModel.setDiameter(250);
		pieModel.setShadow(false);
	}

}

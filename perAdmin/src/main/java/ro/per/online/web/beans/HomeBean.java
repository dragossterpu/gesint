package ro.per.online.web.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Users;
import ro.per.online.services.PropriedadService;
import ro.per.online.services.UserService;

/**
 * Bean para la página de Home .
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("homeBean")
@Scope(Constantes.SESSION)
public class HomeBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Dashboard de la home.
	 */
	private transient DashboardModel model;

	/**
	 * Gráfico de evolución de datos de autoprevent y evaluat.
	 */
	private LineChartModel graficoDatosEvolucion;

	/**
	 * Cadena formatead de fecha inicio de estadísticas.
	 */
	private String fechaInicio;

	/**
	 * Fecha de inicio de estadísticas.
	 */
	private Date fechaDesde;

	/**
	 * Fecha de fin de estadísticas.
	 */
	private Date fechaHasta;

	/**
	 * Service de solicitudes.
	 */
	@Autowired
	private transient PropriedadService propriedadService;

	private Integer utilizatoriUltimulAn;

	private Integer userUltimaLuna;

	private Integer userUltimaTres;

	private Integer userUltimaLunaComp;

	private Integer userUltimaTresComp;

	private Integer userUltimaSeis;

	private Integer userUltimaDoceComp;

	private Integer userUltimaSeisComp;

	private Integer userUltimaDoce;

	private Integer userTotaliOrganizatii;

	private Integer userTotaliFemei;

	private Integer userTotaliBarbati;

	private TemporalUnit unidadTemporal;

	private PieChartModel graficaUserUltimMembru;

	private HorizontalBarChartModel horizontalBarModel;

	private String content;

	private String secondContent;

	private String color = "#33fc14";

	/**
	 * Servicio de usuarios.
	 */
	@Autowired
	private UserService userService;

	/**
	 * @param usuarioBusqueda
	 * @param numar
	 * @return
	 */
	private int calcularFecha(final UsuarioBusqueda usuarioBusqueda, int numar) {
		List<Users> userList = new ArrayList();
		final Date desde = RestarFechaMes(numar, "MONTHS");
		if (numar != 1) {
			final Date hasta = RestarFechaMes(numar - 1, "MONTHS");
			usuarioBusqueda.setDateUntil(hasta);
		}
		else {
			usuarioBusqueda.setDateUntil(null);
		}
		usuarioBusqueda.setDateFrom(desde);
		userList = userService.buscarUsuarioCriteria(usuarioBusqueda);
		numar = userList.size();
		return numar;
	}

	/**
	 * Calcula las fechas de referencia sobre las que se va a filtrar y van a servir como filtro base.
	 */
	private void calculoFechasFiltro() {
		// Inicio descomentar al poner en producción
		final Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 1);
		final Calendar inicio = Calendar.getInstance();
		inicio.add(Calendar.DATE, -30);
		fechaDesde = inicio.getTime();
		fechaHasta = today.getTime();

		final SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMFECHA);
		fechaInicio = sdf.format(fechaDesde);
	}

	/**
	 * Carga los datos de la evolución de registro de usuarios.
	 */
	private Integer cargarUserUltimo(final Integer dias, Integer user, Date desde) {
		final UsuarioBusqueda usuarioBusqueda = new UsuarioBusqueda();
		desde = RestarFechaMes(dias, "DAYS");
		List<Users> userList = new ArrayList();
		usuarioBusqueda.setDateFrom(desde);
		userList = userService.buscarUsuarioCriteria(usuarioBusqueda);
		user = userList.size();
		return user;
	}

	/**
	 * Carga los datos de la evolución de registro de usuarios.
	 */
	private Integer cargarUserUltimoAño(final Integer dias, Integer user, Date desde, Date hasta, final Integer meses) {
		final UsuarioBusqueda usuarioBusqueda = new UsuarioBusqueda();
		desde = RestarFechaAn(dias, "YEARS");
		hasta = SumarFechaMes(meses, "MONTHS");
		List<Users> userList = new ArrayList();
		usuarioBusqueda.setDateFrom(desde);
		usuarioBusqueda.setDateUntil(hasta);
		userList = userService.buscarUsuarioCriteria(usuarioBusqueda);
		user = userList.size();
		return user;
	}

	private void createHorizontalBarModel() {
		final UsuarioBusqueda usuarioBusqueda = new UsuarioBusqueda();
		horizontalBarModel = new HorizontalBarChartModel();
		final ChartSeries boys = new ChartSeries();
		boys.setLabel("Membrii noi");
		Integer numar = 1;
		if (numar == 1) {
			usuarioBusqueda.setDateUntil(null);
			numar = calcularFecha(usuarioBusqueda, numar);
			boys.set("Ianuarie", numar);
		}
		boys.set("Februarie", calcularFecha(usuarioBusqueda, 2));
		boys.set("Martie", calcularFecha(usuarioBusqueda, 3));
		boys.set("Aprilie", calcularFecha(usuarioBusqueda, 4));
		boys.set("Mai", calcularFecha(usuarioBusqueda, 5));
		boys.set("Iunie", calcularFecha(usuarioBusqueda, 6));
		boys.set("Iulie", calcularFecha(usuarioBusqueda, 7));
		boys.set("August", calcularFecha(usuarioBusqueda, 8));
		boys.set("Septembrie", calcularFecha(usuarioBusqueda, 9));
		boys.set("Octombrie", calcularFecha(usuarioBusqueda, 10));
		boys.set("Noiembrie", calcularFecha(usuarioBusqueda, 11));
		boys.set("Decembrie", calcularFecha(usuarioBusqueda, 12));

		horizontalBarModel.addSeries(boys);
		horizontalBarModel.setTitle("Membrii noi înregistrați lunar");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		final Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Număr");
		xAxis.setMin(0);
		xAxis.setMax(200);

		final Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Membrii");
	}

	private void createPieModel2() {
		graficaUserUltimMembru = new PieChartModel();

		graficaUserUltimMembru.set("Înregistrați în ultima lună:  " + userUltimaLuna, userUltimaLuna);
		graficaUserUltimMembru.set("Înregistrați în ultimele trei luni:  " + userUltimaTres,
				userUltimaTres - userUltimaLuna);
		graficaUserUltimMembru.set("Înregistrați în ultimele sase luni:  " + userUltimaSeis,
				userUltimaSeis - userUltimaTres);
		graficaUserUltimMembru.set("Înregistrați în ultimul an: " + userUltimaDoce, userUltimaDoce - userUltimaSeis);

		graficaUserUltimMembru.setTitle("Membrii noi înregistrați ");
		graficaUserUltimMembru.setLegendPosition("e");
		graficaUserUltimMembru.setFill(false);
		graficaUserUltimMembru.setShowDataLabels(true);
		graficaUserUltimMembru.setDiameter(150);
		graficaUserUltimMembru.setShadow(false);
	}

	private void createPieModels() {
		createPieModel2();
	}

	/**
	 * Método inicializador del bean.
	 */
	@PostConstruct
	public void init() {

		model = new DefaultDashboardModel();
		final DashboardColumn column1 = new DefaultDashboardColumn();
		column1.addWidget("estadisticas");
		column1.addWidget("actividad");
		model.addColumn(column1);
		loadDatosMembriiNoi();
		createPieModels();
		createHorizontalBarModel();
		loadDatosMembriiNoiComp();
		calculoFechasFiltro();

	}

	/**
	 * Cargar datos estadísticos.
	 */
	private void loadDatosMembriiNoi() {
		userUltimaLuna = 0;
		userUltimaLuna = cargarUserUltimo(30, userUltimaLuna, null);
		userUltimaTres = 0;
		userUltimaTres = cargarUserUltimo(91, userUltimaTres, null);
		userUltimaSeis = 0;
		userUltimaSeis = cargarUserUltimo(182, userUltimaTres, null);
		userUltimaDoce = 0;
		userUltimaDoce = cargarUserUltimo(365, userUltimaTres, null);
	}

	/**
	 * Cargar datos estadísticos.
	 */
	private void loadDatosMembriiNoiComp() {
		userUltimaLunaComp = 0;
		userUltimaLunaComp = cargarUserUltimoAño(30, userUltimaLunaComp, null, null, 1);
		userUltimaTresComp = 0;
		userUltimaTresComp = cargarUserUltimoAño(61, userUltimaTresComp, null, null, 3);
		userUltimaSeisComp = 0;
		userUltimaSeisComp = cargarUserUltimoAño(182, userUltimaSeisComp, null, null, 6);
		userUltimaDoceComp = 0;
		userUltimaDoceComp = cargarUserUltimoAño(365, userUltimaDoceComp, null, null, 12);

	}

	public Date RestarFechaAn(final int sumaresta, final String opcion) {
		final LocalDate date = unidadTemoporalFechas(opcion);
		final LocalDate dateResultado = date.minus(sumaresta, unidadTemporal);
		return Date.from(dateResultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Date RestarFechaMes(final int sumaresta, final String opcion) {
		final LocalDate date = unidadTemoporalFechas(opcion);
		final LocalDate dateResultado = date.minus(sumaresta, unidadTemporal);
		return Date.from(dateResultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public void saveListener() {
		content = content.replaceAll("\\r|\\n", "");

		final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Content",
				content.length() > 150 ? content.substring(0, 100) : content);

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void secondSaveListener() {
		secondContent = secondContent.replaceAll("\\r|\\n", "");

		final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Second Content",
				secondContent.length() > 150 ? secondContent.substring(0, 100) : secondContent);

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Date SumarFechaMes(final int suma, final String opcion) {
		final LocalDate date = unidadTemoporalFechas(opcion);
		final LocalDate dateResultado = date.plus(suma, unidadTemporal);
		return Date.from(dateResultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * @param opcion
	 * @return
	 */
	private LocalDate unidadTemoporalFechas(final String opcion) {
		final Date fecha = new Date();
		final LocalDate date = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		switch (opcion) {
		case "DAYS":
			unidadTemporal = ChronoUnit.DAYS;
			break;
		case "MONTHS":
			unidadTemporal = ChronoUnit.MONTHS;
			break;
		case "YEARS":
			unidadTemporal = ChronoUnit.YEARS;
			break;
		default:
			// Controlar error
		}
		return date;
	}
}

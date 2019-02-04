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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.ModelStats;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.Users;
import ro.per.online.services.PropriedadService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.StatsService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;

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

	private Map<String, Integer> listaUsuarios;

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

	private HorizontalBarChartModel horizontalBarModelProvince;

	private String content;

	private String secondContent;

	private String color = "#33fc14";

	/**
	 * Cadena que identifica el grupo de datos activo del formulario de estadísticas.
	 */
	private String grupoDatosActivo;

	/**
	 * Mapa que contendrá los parámetros de la aplicación.
	 */
	private List<ModelStats> mapaUserProvince;

	/**
	 * Mapa que contendrá los parámetros de la aplicación.
	 */
	private List<ModelStats> mapaUserByProvince;

	/**
	 * Servicio de usuarios.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Servicio de statistica.
	 */
	@Autowired
	private StatsService statService;

	private BarChartModel barModel;

	/**
	 * Cadena que identifica la pestaña activa del formulario de estadísticas.
	 */
	private String pestaniaActiva;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private ProvinceService provinceService;

	/**
	 * Hace la búsqueda de un grupo de datos en función de la pestaña activa.
	 */
	private void buscarDatos() {
		if (grupoDatosActivo.equals(Constantes.TABREZULTATE)) {
			buscarDatosRezultate();
		}
		else if (grupoDatosActivo.equals(Constantes.TABORGANIZATII)) {
			buscarDatosOrganizatii();
		}
		else {
			buscarDatosUsuarios();
		}

	}

	private void buscarDatosJudet() {

	}

	/**
	 * Busca los datos de la pestaña de usuarios.
	 */
	private void buscarDatosOrganizatii() {
		paramProvince();
	}

	/**
	 * Busca los datos de la pestaña de usuarios.
	 */
	private void buscarDatosRezultate() {
		FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_INFO, Constantes.ENVIOALERTA,
				"Totul ok intram.");

	}

	/**
	 * Busca los datos de la pestaña de usuarios.
	 */
	private void buscarDatosUsuarios() {
		loadDatosMembriiNoi(null);
		createPieModels();
		cargaLista();
		createHorizontalBarModel();
		loadDatosMembriiNoiComp();
		calculoFechasFiltro();
		createBarModels();
	}

	/**
	 * @param usuarioBusqueda
	 * @param numar
	 * @return
	 */
	private int calcularFecha(final UsuarioBusqueda usuarioBusqueda, int numar) {
		List<Users> userList = new ArrayList<>();
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
	 * Evento para el control de cambio de grupo de datos.
	 * @param event TabChangeEvent
	 */
	public void cambioGrupoDatos(final TabChangeEvent event) {
		pestaniaActiva = event.getTab().getId();
		buscarDatos();
	}

	/**
	 * Evento para el control de cambio de pestaña de grupo de datos(Membrii noi, Organizatia sau Rezultate).
	 * @param event TabChangeEvent
	 */
	public void cambioTipoEvaluacion(final TabChangeEvent event) {
		if ("membrii_noi".equals(event.getTab().getId())) {
			grupoDatosActivo = Constantes.TABMIEMBROSNUEVOS;
			pestaniaActiva = Constantes.TOTALEMIEMBROSNUEVOS;
		}
		else if ("totales_organizatii".equals(event.getTab().getId())) {
			grupoDatosActivo = Constantes.TABORGANIZATII;
			pestaniaActiva = Constantes.TOTALESORGANIZATII;
		}
		else {
			grupoDatosActivo = Constantes.TABREZULTATE;
			pestaniaActiva = Constantes.TABREZULTATE;
		}
		buscarDatos();
	}

	private void cargaLista() {
		listaUsuarios.put("Înregistrați în ultima lună:", userUltimaLuna);
		listaUsuarios.put("Înregistrați în ultimele trei luni:", userUltimaTres);
		listaUsuarios.put("Înregistrați în ultimele sase luni:", userUltimaSeis);
		listaUsuarios.put("Înregistrați în ultimul an:", userUltimaDoce);
	}

	/**
	 * Carga los datos de la evolución de registro de usuarios.
	 */
	private Integer cargarUserUltimo(final Integer dias, Integer user, Date desde, final PProvince judetul) {
		final UsuarioBusqueda usuarioBusqueda = new UsuarioBusqueda();
		if (judetul != null) {
			usuarioBusqueda.setIdProvincia(judetul.getIndicator());
		}
		final LocalDate date = unidadTemoporalFechas("DAYS");
		desde = RestarFechaMes(dias, "DAYS");
		List<Users> userList = new ArrayList<>();
		usuarioBusqueda.setDateFrom(desde);
		userList = userService.buscarUsuarioCriteria(usuarioBusqueda);
		user = userList.size();
		return user;
	}

	/**
	 * Carga los datos de la evolución de registro de usuarios.
	 */
	private Integer cargarUserUltimoAño(final Integer mesesDesde, final Integer mesesHasta) {
		final UsuarioBusqueda usuarioBusqueda = new UsuarioBusqueda();
		Integer numerUser = 0;
		List<Users> userList;
		fechasDesdeHastaResta(mesesDesde, mesesHasta, usuarioBusqueda);
		userList = userService.buscarUsuarioCriteria(usuarioBusqueda);
		numerUser = userList.size();
		return numerUser;
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Comparativă Prezent/Anul trecut");
		barModel.setLegendPosition("w");

		final Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Periada");

		final Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Membrii");
		yAxis.setMin(0);
		if (userUltimaDoceComp > userUltimaDoce) {
			yAxis.setMax(userUltimaDoceComp + 20);
		}
		else {
			yAxis.setMax(userUltimaDoce + 20);
		}
	}

	private void createBarModels() {
		createBarModel();
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

	private void createHorizontalBarModel(final List<ModelStats> mapaUserProvince) {
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

	private void createHorizontalBarModelProvince(final List<ModelStats> mapaUserProvince) {
		final ChartSeries boys = new ChartSeries();
		horizontalBarModelProvince = new HorizontalBarChartModel();
		boys.setLabel("Membrii noi");
		final Long numarmaxim = mapaUserProvince.get(0).getCantidad() + 20;
		final Integer numero = numarmaxim.intValue();
		for (final ModelStats model : mapaUserProvince) {
			boys.set(model.getDescripcion(), model.getCantidad().intValue());
		}
		horizontalBarModelProvince.addSeries(boys);
		horizontalBarModelProvince.setTitle("Membrii noi înregistrați în organizații în ultimul an");
		horizontalBarModelProvince.setLegendPosition("e");
		horizontalBarModelProvince.setStacked(true);
		final Axis xAxis = horizontalBarModelProvince.getAxis(AxisType.X);
		xAxis.setLabel("Număr");
		xAxis.setMin(0);
		xAxis.setMax(numero);

		final Axis yAxis = horizontalBarModelProvince.getAxis(AxisType.Y);
		yAxis.setLabel("Organizația/Județ");
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
	 * @param mesesDesde
	 * @param mesesHasta
	 * @param usuarioBusqueda
	 *
	 */
	private void fechasDesdeHastaResta(final Integer mesesDesde, final Integer mesesHasta,
			final UsuarioBusqueda usuarioBusqueda) {
		final Date desde = RestarFechaMes(mesesDesde, "MONTHS");
		final Date hasta = RestarFechaMes(mesesHasta, "MONTHS");
		final List<Users> userList = new ArrayList<>();
		usuarioBusqueda.setDateFrom(desde);
		usuarioBusqueda.setDateUntil(hasta);
	}

	/**
	 * Método inicializador del bean.
	 */
	@PostConstruct
	public void init() {
		listaUsuarios = new HashMap<>();
		model = new DefaultDashboardModel();
		final DashboardColumn column1 = new DefaultDashboardColumn();
		column1.addWidget("estadisticas");
		column1.addWidget("actividad");
		model.addColumn(column1);
		buscarDatosUsuarios();
		buscarDatosOrganizatii();
		pestaniaActiva = Constantes.TOTALEMIEMBROSNUEVOS;
		grupoDatosActivo = Constantes.TOTALEMIEMBROSNUEVOS;
	}

	private BarChartModel initBarModel() {
		final BarChartModel model = new BarChartModel();
		final UsuarioBusqueda usuarioBusqueda = new UsuarioBusqueda();
		final ChartSeries boys = new ChartSeries();
		boys.setLabel("Membri anul în curs");
		boys.set("Ultima lună", userUltimaLuna);
		boys.set("Ultimele trei luni", userUltimaTres);
		boys.set("Ultimele șase luni", userUltimaSeis);
		boys.set("Ultimul an", userUltimaDoce);
		final ChartSeries girls = new ChartSeries();
		girls.setLabel("Membri anul trecut");
		girls.set("Luna corespondiente a anului trecut", userUltimaLunaComp);
		girls.set("Ultimele trei luni ale anului trecut", userUltimaTresComp);
		girls.set("Ultimele șase luni ale anului trecut", userUltimaSeisComp);
		girls.set("Anul trecut", userUltimaDoceComp);
		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	/**
	 * Cargar datos estadísticos.
	 */
	private void loadDatosMembriiNoi(final PProvince id) {
		userUltimaLuna = 0;
		userUltimaLuna = cargarUserUltimo(30, userUltimaLuna, null, id);
		userUltimaTres = 0;
		userUltimaTres = cargarUserUltimo(91, userUltimaTres, null, id);
		userUltimaSeis = 0;
		userUltimaSeis = cargarUserUltimo(182, userUltimaTres, null, id);
		userUltimaDoce = 0;
		userUltimaDoce = cargarUserUltimo(365, userUltimaTres, null, id);
	}

	/**
	 * Cargar datos estadísticos.
	 */
	private void loadDatosMembriiNoiComp() {
		userUltimaLunaComp = cargarUserUltimoAño(13, 12);
		userUltimaTresComp = cargarUserUltimoAño(15, 12);
		userUltimaSeisComp = cargarUserUltimoAño(18, 12);
		userUltimaDoceComp = cargarUserUltimoAño(24, 12);

	}

	/**
	 * Cargar datos estadísticos.
	 */
	private void paramProvince() {
		mapaUserProvince = statService.getUserProvince();
		createHorizontalBarModelProvince(mapaUserProvince);
	}

	public Date RestarFechaAn(final int sumaresta, final String opcion) {
		final LocalDate date = unidadTemoporalFechas(opcion);
		final LocalDate dateResultado = date.minus(sumaresta, unidadTemporal);
		return Date.from(dateResultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Date RestarFechaMes(final int suma, final String opcion) {
		final LocalDate date = unidadTemoporalFechas(opcion);
		final LocalDate dateResultado = date.minus(suma, unidadTemporal);
		return Date.from(dateResultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public void saveListener() {
		content = content.replaceAll("|", "");

		final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Content",
				content.length() > 150 ? content.substring(0, 100) : content);

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void secondSaveListener() {
		secondContent = secondContent.replaceAll("|", "");

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

	/**
	 * Método para visualizar la relación.
	 *
	 * @param item ActividadFuenteDanioIcono
	 * @return String
	 */
	public String visualizar(final String descripcion) {
		try {
			final PProvince provincia = provinceService.findByName(descripcion);
			loadDatosMembriiNoi(provincia);
			mapaUserByProvince = statService.getUserByProvince(provincia.getIndicator());
		}
		catch (final DataAccessException e) {
			FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
					"A apărut o eroare la preluarea elementului, încercați din nou mai târziu");
		}
		return "/actividadFuenteIcono/nuevoActividadFuenteIcono?faces-redirect=true";
	}
}

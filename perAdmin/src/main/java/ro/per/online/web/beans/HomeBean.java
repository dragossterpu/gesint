package ro.per.online.web.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;

/**
 * Bean para la página de Home .
 *
 * @author EZENTIS
 */
@Setter
@Getter
@Controller("homeBean")
@Scope("view")
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
	 * Método inicializador del bean.
	 */
	@PostConstruct
	public void init() {
		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		column1.addWidget("estadisticas");
		column1.addWidget("actividad");
		model.addColumn(column1);
	}

	/**
	 * Calcula las fechas de referencia sobre las que se va a filtrar y van a servir como filtro base.
	 */
	private void calculoFechasFiltro() {
		// Inicio descomentar al poner en producción
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 1);
		Calendar inicio = Calendar.getInstance();
		fechaDesde = inicio.getTime();
		fechaHasta = today.getTime();

		final SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMFECHA);
		fechaInicio = sdf.format(fechaDesde);
	}

	/**
	 * Carga el gráfico de evolución de las evaluaciones.
	 */
	private void loadGraficoEvolucion() {
		graficoDatosEvolucion = new LineChartModel();

		final LineChartSeries series1 = new LineChartSeries();

		graficoDatosEvolucion.addSeries(series1);
		final LineChartSeries series2 = new LineChartSeries();
		graficoDatosEvolucion.addSeries(series2);

		graficoDatosEvolucion.setAnimate(true);
		graficoDatosEvolucion.setLegendPosition("w");
		graficoDatosEvolucion.setShowPointLabels(false);
		graficoDatosEvolucion.setTitle("Evaluaciones Usuarios");

		graficoDatosEvolucion.getAxis(AxisType.Y).setMin(0);
		graficoDatosEvolucion.getAxes().put(AxisType.X, new DateAxis());
		graficoDatosEvolucion.getAxis(AxisType.X).setTickFormat("%#d/%m");

		graficoDatosEvolucion.setExtender("format");

	}

}

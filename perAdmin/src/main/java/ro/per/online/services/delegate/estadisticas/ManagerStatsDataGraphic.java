package ro.per.online.services.delegate.estadisticas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;

import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.ModelStats;
import ro.per.online.web.beans.StatsBusqueda;

/**
 * 
 * Clase para la gestión de los gráficos.
 * @author Ezentis
 *
 */
public class ManagerStatsDataGraphic {

	/**
	 * Estadísticas de búsqueda.
	 */
	private final StatsBusqueda statsBusqueda;

	/**
	 * Constructor del gestor de estadísticas.
	 * @param statsBusq StatsBusqueda
	 */
	public ManagerStatsDataGraphic(StatsBusqueda statsBusq) {
		this.statsBusqueda = statsBusq;
	}

	/**
	 * Obtiene la máxima cantidad de una lista de modelo de datos.
	 * @param listaModelo List<ModelStats>
	 * @return Long
	 */
	private Long getMaximo(List<ModelStats> listaModelo) {
		Long maximo = 0L;

		for (ModelStats modelo : listaModelo) {
			if (modelo.getCantidad() > maximo) {
				maximo = modelo.getCantidad();
			}
		}

		return maximo;
	}

	/**
	 * Rellena el gráfico de evaluaciones totales.
	 * 
	 * @param modeloDatosEvaluacionesTotales ModelStats
	 * @param graficoEvaluacionesTotales MeterGaugeChartModel
	 * @param maximoNumeroEvaluaciones Integer
	 */
	public void rellenarGraficoEvaluacionesTotales(ModelStats modeloDatosEvaluacionesTotales,
			MeterGaugeChartModel graficoEvaluacionesTotales, Integer maximoNumeroEvaluaciones) {

		Integer maximo = maximoNumeroEvaluaciones;
		if (modeloDatosEvaluacionesTotales.getCantidad() > maximo) {
			maximo = Integer.parseInt(modeloDatosEvaluacionesTotales.getCantidad().toString());
		}

		List<Number> intervals = new ArrayList<>();
		intervals.add(maximo + 1);

		graficoEvaluacionesTotales.setIntervals(intervals);
		graficoEvaluacionesTotales.setValue(modeloDatosEvaluacionesTotales.getCantidad());
		graficoEvaluacionesTotales.setLabelHeightAdjust(Constantes.ALTURAGRAFICOTOTALES);
		graficoEvaluacionesTotales.setIntervalOuterRadius(Constantes.INTERVALORADIOGRAFICOTOTALES);
		graficoEvaluacionesTotales.setSeriesColors("66cc66,93b75f,E7E658,cc6666");
	}

	/**
	 * Rellena el gráfico de distribución de evaluaciones totales.
	 * 
	 * @param modeloDatosDistribucionEvaluacionesTotales List<ModelStats>
	 * @param graficoDistribucionEvaluacionesTotales BarChartModel
	 */
	public void rellenarGraficoDistribucionEvaluacionesTotales(
			List<ModelStats> modeloDatosDistribucionEvaluacionesTotales,
			BarChartModel graficoDistribucionEvaluacionesTotales) {

		graficoDistribucionEvaluacionesTotales.setAnimate(true);
		Axis yAxis = graficoDistribucionEvaluacionesTotales.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(getMaximo(modeloDatosDistribucionEvaluacionesTotales));

		ChartSeries datos = new ChartSeries();
		for (ModelStats modelo : modeloDatosDistribucionEvaluacionesTotales) {
			datos.set(modelo.getDescripcion(), modelo.getCantidad());
		}

		graficoDistribucionEvaluacionesTotales.addSeries(datos);
	}

	/**
	 * Carga con el modelo de datos el gráfico de usuarios.
	 * 
	 * @param modeloDatosTipoUsuarios List<ModelStats>
	 * @param graficoTipoUsuarios PieChartModel
	 */
	public void rellenarGraficoUsuarios(List<ModelStats> modeloDatosTipoUsuarios, PieChartModel graficoTipoUsuarios) {

		for (ModelStats modelo : modeloDatosTipoUsuarios) {
			graficoTipoUsuarios.set(modelo.getDescripcion(), modelo.getCantidad());
		}

		graficoTipoUsuarios.setLegendPosition(Constantes.W);
		graficoTipoUsuarios.setLegendPosition(Constantes.W);
		graficoTipoUsuarios.setShowDataLabels(true);
		graficoTipoUsuarios.setFill(true);
		graficoTipoUsuarios.setShadow(true);
		graficoTipoUsuarios.setShowDatatip(true);
	}

	/**
	 * Carga el gráfico de evolución.
	 * 
	 * @param graficoDatosEvolucion LineChartModel
	 * @param modeloDatosEvolucion List<ModelStats>
	 */
	public void rellenarGraficoEvolucion(List<ModelStats> modeloDatosEvolucion, LineChartModel graficoDatosEvolucion) {

		final LineChartSeries series1 = new LineChartSeries();
		for (ModelStats modelo : modeloDatosEvolucion) {
			series1.set(modelo.getDescripcion(), modelo.getCantidad());
		}

		graficoDatosEvolucion.addSeries(series1);
		graficoDatosEvolucion.setAnimate(true);
		final Axis yAxis = graficoDatosEvolucion.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(getMaximo(modeloDatosEvolucion));

		graficoDatosEvolucion.getAxes().put(AxisType.X, new CategoryAxis(Constantes.ESPACIO));
	}

	/**
	 * Rellena el gráfico de modalidad de prevención.
	 * 
	 * @param modeloDatosModalidadPrevencion List<ModelStats>
	 * @param graficoModalidadPrevencion PieChartModel
	 */
	public void rellenarGraficoModalidadPrevencion(List<ModelStats> modeloDatosModalidadPrevencion,
			PieChartModel graficoModalidadPrevencion) {
		for (ModelStats modelo : modeloDatosModalidadPrevencion) {
			graficoModalidadPrevencion.set(modelo.getDescripcion(), modelo.getCantidad());
		}

		graficoModalidadPrevencion.setLegendPosition(Constantes.W);
		graficoModalidadPrevencion.setShowDataLabels(true);
		graficoModalidadPrevencion.setFill(true);
		graficoModalidadPrevencion.setShadow(true);
		graficoModalidadPrevencion.setShowDatatip(true);
	}

	/**
	 * Rellena el gráfico de numero de trabajadores.
	 * 
	 * @param modeloDatosNumeroTrabajadores List<ModelStats>
	 * @param graficoDatosNumeroTrabajadores BarChartModel
	 */
	public void rellenarGraficoNumeroTrabajadores(List<ModelStats> modeloDatosNumeroTrabajadores,
			BarChartModel graficoDatosNumeroTrabajadores) {
		graficoDatosNumeroTrabajadores.setAnimate(true);

		ChartSeries datos = new ChartSeries();
		for (int i = modeloDatosNumeroTrabajadores.size() - 1; i >= 0; i--) {
			datos.set(modeloDatosNumeroTrabajadores.get(i).getDescripcion(),
					modeloDatosNumeroTrabajadores.get(i).getCantidad());
		}

		Axis xAxis = graficoDatosNumeroTrabajadores.getAxis(AxisType.X);
		xAxis.setMin(0);
		xAxis.setMax(getMaximo(modeloDatosNumeroTrabajadores));
		graficoDatosNumeroTrabajadores.setShadow(true);
		graficoDatosNumeroTrabajadores.setShowDatatip(true);

		graficoDatosNumeroTrabajadores.addSeries(datos);
	}

	/**
	 * Rellena el gráfico de estados de evaluación.
	 * 
	 * @param modeloDatosEstados List<ModelStats>
	 * @param graficoDatosEstados HorizontalBarChartModel
	 */
	public void rellenarGraficoEstadosEvaluacion(List<ModelStats> modeloDatosEstados,
			HorizontalBarChartModel graficoDatosEstados) {
		graficoDatosEstados.setAnimate(true);

		ChartSeries datos = new ChartSeries();
		for (int i = modeloDatosEstados.size() - 1; i >= 0; i--) {
			datos.set(modeloDatosEstados.get(i).getDescripcion(), modeloDatosEstados.get(i).getCantidad());
		}

		Axis xAxis = graficoDatosEstados.getAxis(AxisType.X);
		xAxis.setMin(0);
		xAxis.setMax(getMaximo(modeloDatosEstados));
		graficoDatosEstados.setShadow(true);
		graficoDatosEstados.setShowDatatip(true);

		graficoDatosEstados.addSeries(datos);
	}

	/**
	 * Rellena el gráfico de sectores de evaluación.
	 * 
	 * @param modeloDatosSectores List<ModelStats>
	 * @param graficoDatosSectores HorizontalBarChartModel
	 */
	public void rellenarGraficoSectoresEvaluacion(List<ModelStats> modeloDatosSectores,
			HorizontalBarChartModel graficoDatosSectores) {
		graficoDatosSectores.setAnimate(true);

		ChartSeries datos = new ChartSeries();
		for (int i = modeloDatosSectores.size() - 1; i >= 0; i--) {
			int length = modeloDatosSectores.get(i).getDescripcion().length();
			if (length > 60) {
				length = 60;
			}
			datos.set(modeloDatosSectores.get(i).getDescripcion().substring(0, length),
					modeloDatosSectores.get(i).getCantidad());
		}

		Axis xAxis = graficoDatosSectores.getAxis(AxisType.X);
		xAxis.setMin(0);
		xAxis.setMax(getMaximo(modeloDatosSectores));
		xAxis.setTickInterval("5");

		graficoDatosSectores.addSeries(datos);

	}

	/**
	 * Formatea un gráfico cartesiano.
	 * 
	 * @param grafico CartesianChartModel
	 */
	private void formatearGraficoCartesiano(CartesianChartModel grafico) {
		grafico.setAnimate(true);
		grafico.setLegendPosition("ne");
		grafico.setSeriesColors("4b7cc5,fda91a,b5b5b5");
	}

	/**
	 * Obtiene la mascara con la que formatear una fecha dependiendo de la agrupación.
	 * 
	 * @return String
	 */
	private String getTickFormatDate() {
		String tickFormat = "%Y";

		if (statsBusqueda.getTipoAgrupacion().equals("anio")) {
			tickFormat = "%Y";
		}
		else if (statsBusqueda.getTipoAgrupacion().equals("mes")) {
			tickFormat = "%m/%Y";
		}
		else if (statsBusqueda.getTipoAgrupacion().equals("dia")) {
			tickFormat = "%d/%m/%Y";
		}

		return tickFormat;
	}

	/**
	 * Formatea un eje estableciendole el máximo.
	 * 
	 * @param eje Axis
	 * @param maximo Long
	 */
	private void formatearEje(Axis eje, Long maximo) {
		eje.setTickFormat("%i");
		eje.setMin(0);
		eje.setMax(maximo);
	}

	/**
	 * Obtiene el valor máximo de ambos modelos de datos.
	 * @param modeloDatos List<ModelStats>
	 * @param modeloDatosInvitados List<ModelStats>
	 * @return Long
	 */
	private Long getMaximoValorModeloDatos(List<ModelStats> modeloDatos, List<ModelStats> modeloDatosInvitados) {
		Long maximo = getMaximo(modeloDatos);
		Long maximoInvitados = getMaximo(modeloDatosInvitados);
		if (maximoInvitados > maximo) {
			maximo = maximoInvitados;
		}
		return maximo;
	}

	/**
	 * Formatea el eje x de tipo fecha.
	 * 
	 * @param grafico CartesianChartModel
	 */
	private void formatearEjeTipoFecha(final CartesianChartModel grafico) {
		Axis xAxis = new DateAxis();
		xAxis.setTickFormat(getTickFormatDate());
		grafico.getAxes().put(AxisType.X, xAxis);
	}

	/**
	 * Crea una serie de datos a partir de un mapa.
	 * 
	 * @param nombreSerie String
	 * @param mapaDatos Map<Object, Number>
	 * @return ChartSeries
	 */
	private ChartSeries crearSerieDatos(String nombreSerie, Map<Object, Number> mapaDatos) {
		ChartSeries serieDatos = new ChartSeries(nombreSerie);

		serieDatos.setData(mapaDatos);

		return serieDatos;
	}

	/**
	 * Normaliza un mapa de datos incorporandole aquellos elementos que no tenga poniendole la cantidad a 0.
	 * 
	 * @param mD List<ModelStats>
	 * @param mapa Map<Object, Number>
	 */
	private void normalizarMapaDatos(List<ModelStats> mD, Map<Object, Number> mapa) {
		for (ModelStats modelo : mD) {
			if (!mapa.containsKey(modelo.getDescripcion())) {
				mapa.put(modelo.getDescripcion(), 0);
			}
		}
	}

	/**
	 * Obtiene un mapa a partir de un modelo de datos.
	 * @param mD List<ModelStats>
	 * @return Map<Object, Number>
	 */
	private Map<Object, Number> getMapaModeloDatos(List<ModelStats> mD) {
		Map<Object, Number> mapa = new HashMap<Object, Number>();

		for (ModelStats modelo : mD) {
			mapa.put(modelo.getDescripcion(), modelo.getCantidad());
		}

		return mapa;
	}

	/**
	 * Normaliza un gráfico de tipo de sectores.
	 * 
	 * @param grafico PieChartModel
	 * @param modeloDatos List<ModelStats>
	 */
	public void normalizarGraficoSectorial(PieChartModel grafico, List<ModelStats> modeloDatos) {
		formatearGraficoSectorial(grafico);

		for (ModelStats modelo : modeloDatos) {
			grafico.set(modelo.getDescripcion(), modelo.getCantidad());
		}
	}

	/**
	 * Formatea un gráfico sectorial con los elementos comunes.
	 * @param grafico PieChartModel
	 */
	private void formatearGraficoSectorial(PieChartModel grafico) {
		grafico.setLegendPosition("ne");
		grafico.setSeriesColors("4b7cc5,fda91a,b5b5b5");
		grafico.setShowDataLabels(true);
		grafico.setFill(true);
		grafico.setShadow(true);
		grafico.setShowDatatip(true);
	}

	/**
	 * Normaliza un gráfico de tipo contador.
	 * 
	 * @param grafico MeterGaugeChartModel
	 * @param modelo ModelStats
	 * @param maximo Integer
	 */
	public void normalizarGraficoContador(MeterGaugeChartModel grafico, ModelStats modelo, Integer maximo) {
		List<Number> intervals = new ArrayList<Number>();
		intervals.add(maximo);

		grafico.setValue(modelo.getCantidad());
		grafico.setIntervals(intervals);
		grafico.setLabelHeightAdjust(Constantes.ALTURAGRAFICOTOTALES);
		grafico.setIntervalOuterRadius(Constantes.INTERVALORADIOGRAFICOTOTALES);
		grafico.setSeriesColors("66cc66,93b75f,E7E658,cc6666");

	}

	/**
	 * Normaliza un gráfico cartesiano con multiples series.
	 * 
	 * @param grafico CartesianChartModel
	 * @param modeloDatos List<ModelStats>
	 * @param modeloDatosInvitados List<ModelStats>
	 * @param vertical boolean
	 * @param ejeXTipoFecha boolean
	 * @param incluirSerieCompleta boolean
	 */
	public void nomalizarGraficoCartesianoMultiplesSeries(final CartesianChartModel grafico,
			List<ModelStats> modeloDatos, List<ModelStats> modeloDatosInvitados, boolean vertical,
			boolean ejeXTipoFecha, boolean incluirSerieCompleta) {
		formatearGraficoCartesiano(grafico);

		Long maximo = getMaximoValorModeloDatos(modeloDatos, modeloDatosInvitados);
		if (vertical) {
			formatearEje(grafico.getAxis(AxisType.Y), maximo);
		}
		else {
			formatearEje(grafico.getAxis(AxisType.X), maximo);
		}

		if (ejeXTipoFecha) {
			formatearEjeTipoFecha(grafico);
		}

		Map<Object, Number> mapaDatosRegistrados = getMapaModeloDatos(modeloDatos);
		Map<Object, Number> mapaDatosInvitados = getMapaModeloDatos(modeloDatosInvitados);

		if (incluirSerieCompleta) {// Tenemos que incluir la serie completa con valor 0
			normalizarMapaDatos(modeloDatos, mapaDatosInvitados);
			normalizarMapaDatos(modeloDatosInvitados, mapaDatosRegistrados);
		}

		grafico.addSeries(crearSerieDatos("Usuarios", mapaDatosRegistrados));
		grafico.addSeries(crearSerieDatos("Invitados", mapaDatosInvitados));
	}

	/**
	 * Normaliza un gráfico cartesiano con una única serie de valores.
	 * 
	 * @param grafico CartesianChartModel
	 * @param modeloDatos List<ModelStats>
	 * @param vertical boolean
	 * @param ejeXTipoFecha boolean
	 */
	public void nomalizarGraficoCartesianoSerieUnica(final CartesianChartModel grafico, List<ModelStats> modeloDatos,
			boolean vertical, boolean ejeXTipoFecha) {
		formatearGraficoCartesiano(grafico);

		Long maximo = getMaximo(modeloDatos);
		if (vertical) {
			formatearEje(grafico.getAxis(AxisType.Y), maximo);
		}
		else {
			formatearEje(grafico.getAxis(AxisType.X), maximo);
		}

		if (ejeXTipoFecha) {
			formatearEjeTipoFecha(grafico);
		}

		ChartSeries datos = new ChartSeries("Inscripciones Instruye-t");
		for (ModelStats modelo : modeloDatos) {
			datos.set(modelo.getDescripcion(), modelo.getCantidad());
		}

		grafico.addSeries(datos);
	}
}

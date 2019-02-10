package ro.per.online.util;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Component;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import lombok.Setter;
import ro.per.online.exceptions.PerException;
import ro.per.online.persistence.entities.Statistica;
import ro.per.online.persistence.entities.enums.TipStatisticaEnum;

/**
 * Clase para generar el PDF de la pantalla de estadísticas.
 *
 * @author STAD
 *
 */
@Setter
@Component("pdfGeneratorEstadisticas")
public class PdfGeneratorEstadisticas extends PdfAbstractGenerator {

	/**
	 * Nombre del pdf de estadisticas.
	 */
	private static final String NOMBREPDFESTADISTICAS = "Estadisticas.pdf";

	/**
	 * Estados seleccionados para la generación del informe en PDF.
	 */
	private Map<TipStatisticaEnum, List<Statistica>> mapaEstados;

	/**
	 * Filtro de búsqueda para seleccionar las estadísticas a mostrar.
	 */
	private Statistica filtro;

	/**
	 * Fichero con la imagen a exportar.
	 */
	private File fileImg;

	/**
	 * Genera un documento PDF con las estadísticas por estado de las inspecciones.
	 *
	 * @return pdf con el contenido del cuestionario
	 * @throws ProgesinException excepción que puede lanzar
	 */
	@Override
	public StreamedContent exportarPdf() throws PerException {
		return crearPdf(NOMBREPDFESTADISTICAS, false, true);
	}

	/**
	 * Genera el contenido que se mostrará en el PDF.
	 *
	 * @param documento Documento pdf al que se adjuntará el contenido
	 * @throws ProgesinException excepción que puede lanzar
	 */
	@Override
	public void crearCuerpoPdf(final Document documento) throws PerException {
		// Título
		final Paragraph titulo = new Paragraph("Informe estadístico");
		titulo.setBold();
		titulo.setFontSize(16);
		titulo.setTextAlignment(TextAlignment.CENTER);
		titulo.setPadding(5);
		documento.add(titulo);
		// Fecha
		final Paragraph fecha = new Paragraph(
				"Fecha emisión documento : " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
		fecha.setTextAlignment(TextAlignment.RIGHT);
		fecha.setPadding(5);
		documento.add(fecha);
		// Datos del informe
		documento.add(creaTitulo("Parámetros del informe"));
		// Filtros usados
		documento.add(creaSubtitulo("Filtros aplicados"));
		creaInfoFiltros(documento);
		final List<TipStatisticaEnum> listaEstadosSeleccionados = new ArrayList<>(mapaEstados.keySet());
		documento.add(creaSubtitulo("Estados seleccionados"));
		creaInfoSeleccion(documento, listaEstadosSeleccionados);
		documento.add(new AreaBreak()); // Salto de página

		// Datos
		documento.add(creaSubtitulo("Desglose"));
		for (final TipStatisticaEnum estado : listaEstadosSeleccionados) {
			final List<Statistica> listaInspecciones = mapaEstados.get(estado);

			// genera tabla de inspecciones
			creaTablaDesglose(documento, listaInspecciones, estado);

		}
		// Gráfica
		documento.add(new AreaBreak()); // Salto de página
		documento.add(creaSubtitulo("Gráfica"));
		try {
			documento.add(new Image(ImageDataFactory.create(fileImg.getPath())));
			if (fileImg.exists()) {
				fileImg.delete();
			}
		}
		catch (final MalformedURLException e) {
			throw new PerException(e);
		}
	}

	/**
	 * Crea un párrafo formateado para servir como título.
	 *
	 * @param texto Texto del título a generar
	 * @return Párrafo formateado como título.
	 */
	private Paragraph creaTitulo(final String texto) {
		final Paragraph titulo = new Paragraph(texto);
		titulo.setBold();
		titulo.setFontSize(12);
		titulo.setTextAlignment(TextAlignment.CENTER);
		titulo.setPadding(10);
		return titulo;
	}

	/**
	 * Crea un párrafo formateado para servir como título secundario.
	 *
	 * @param texto Texto del subtítulo a generar
	 * @return Párrafo formateado como título secundario.
	 */
	private Paragraph creaSubtitulo(final String texto) {
		final Paragraph subTitulo = new Paragraph(texto);
		subTitulo.setFontSize(12);
		subTitulo.setBackgroundColor(Color.convertRgbToCmyk(new DeviceRgb(153, 201, 255)));
		subTitulo.setMarginTop(20);
		subTitulo.setMarginBottom(10);
		return subTitulo;
	}

	/**
	 * Inserta en el informe de estadísticas la información relativa a los filtros empleados para generar la
	 * información.
	 *
	 * @param doc Documento al que se adjunta la información
	 */
	private void creaInfoFiltros(final Document doc) {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		final float[] columnas = { 2, 1 };
		final Table tabla;
		final Cell celdaFiltro;
		final Paragraph texto = new Paragraph("No se han aplicado filtros");
		texto.setFontSize(9);
		texto.setPadding(5);
		doc.add(texto);

	}

	/**
	 * Inserta en el informe de estadísticas los estados seleccionados para la generación del informe.
	 *
	 * @param doc Documento al que se adjunta la información
	 * @param listado Listado de los estados seleccionados
	 */
	private void creaInfoSeleccion(final Document doc, final List<TipStatisticaEnum> listado) {
		for (final TipStatisticaEnum estado : listado) {
			final Paragraph texto = new Paragraph();
			texto.setFontSize(9);
			doc.add(texto);
		}
	}

	/**
	 * Inserta en el informe una tabla con el desglose de inspecciones en un estado dado.
	 *
	 * @param doc Documento en el que se insertará la tabla
	 * @param listaInspecciones Lista de las inspecciones
	 * @param estado Estado de las inspecciones
	 */
	private void creaTablaDesglose(final Document doc, final List<Statistica> listaInspecciones,
			final TipStatisticaEnum estado) {
		final float[] columnWidths = { 1, 2, 1, 1, 1, 1 }; // 6 columnas
		final Table tabla = new Table(columnWidths);
		if (!listaInspecciones.isEmpty()) {
			final Paragraph descripcionEstado = new Paragraph();
			descripcionEstado.setBackgroundColor(Color.convertRgbToCmyk(new DeviceRgb(153, 201, 255)));
			descripcionEstado.setMarginTop(20);
			descripcionEstado.setFontSize(10);
			doc.add(descripcionEstado);
			tabla.setWidthPercent(100);
			tabla.addHeaderCell("EXPEDIENTE");
			tabla.addHeaderCell("TIPO DE INSPECCION");
			tabla.addHeaderCell("EQUIPO");
			tabla.addHeaderCell("CUERPO");
			tabla.addHeaderCell("UNIDAD");
			tabla.addHeaderCell("PROVINCIA");
			tabla.getHeader().setBackgroundColor(new DeviceRgb(204, 228, 255));
			tabla.getHeader().setPaddingTop(20);
			tabla.getHeader().setHorizontalAlignment(HorizontalAlignment.CENTER);
			tabla.getHeader().setFontSize(9);
		}
		Cell celda;

		for (final Statistica ins : listaInspecciones) {
			celda = new Cell();
			celda.setFontSize(9);
			// celda.add(ins.getNumero());
			tabla.addCell(celda);
			celda = new Cell();
			celda.setFontSize(9);
			// celda.add(ins.getTipoInspeccion().getDescripcion());
			tabla.addCell(celda);
			celda = new Cell();
			celda.setFontSize(9);
			// celda.add(ins.getEquipo().getNombreEquipo());
			tabla.addCell(celda);
			celda = new Cell();
			celda.setFontSize(9);
			// celda.add(ins.getAmbito().getDescripcion());
			tabla.addCell(celda);
			celda = new Cell();
			celda.setFontSize(9);
			// celda.add(ins.getNombreUnidad());
			tabla.addCell(celda);
			celda = new Cell();
			celda.setFontSize(9);
			// celda.add(ins.getMunicipio().getProvincia().getNombre());
			tabla.addCell(celda);
		}
		doc.add(tabla);
	}
}

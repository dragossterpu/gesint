package ro.per.online.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import ro.per.online.constantes.Constantes;
import ro.per.online.exceptions.PerException;
import ro.per.online.persistence.entities.enums.ContentTypeEnum;

/**
 * Clasa pentru generarea documentelor PDF ale aplicației.
 *
 * @author STAD
 *
 */
public abstract class PdfAbstractGenerator {

	/**
	 * Creați antetul și finalul documentului
	 *
	 * @param document Unde se creaza antetul și finalul documentului
	 * @param insertarFooter Indică dacă se pune un footer în document sau se introduce doar un antet
	 * @throws IOException excepție pe care o poate avea
	 */
	protected void crearCabeceraFooter(final Document document, final boolean insertarFooter) throws IOException {
		// Footer
		String footer = null;
		if (insertarFooter) {
			footer = Constantes.LOGO;
		}
		final HeaderFooterPdf handler = new HeaderFooterPdf(document, Constantes.LOGOPER, Constantes.LOGOIPSS,
				Constantes.HEADERSOLDOCPAG1, footer);
		document.getPdfDocument().addEventHandler(PdfDocumentEvent.END_PAGE, handler);
	}

	/**
	 * Metodă care trebuie pusă în aplicare de clasele care o moștenesc. El va fi responsabil pentru crearea
	 * conținutului PDF.
	 *
	 * @return StreamedContent necesario para el componente p:fileDownload de primefaces
	 * @throws ProgesinException excepción que lanzará si se produce algún error
	 */
	public abstract StreamedContent exportarPdf() throws PerException;

	/**
	 * Crea el documento pdf.
	 *
	 * @param nombrePdf Nombre del pdf.
	 * @param footer Indica si hay que hay añadir un footer con imagen (el logo de calidad)
	 * @param insertarPagina Inserta el número de página (incompatible con el otro footer)
	 * @return StreamedContent streamcontent para usar el fileDownload de primefaces
	 * @throws ProgesinException posible excepción
	 */
	protected StreamedContent crearPdf(final String nombrePdf, final boolean footer, final boolean insertarPagina)
			throws PerException {
		StreamedContent pdfStream = null;

		try (ByteArrayOutputStream outputStreamOr = new ByteArrayOutputStream();
				PdfWriter writer = new PdfWriter(outputStreamOr);
				PdfDocument pdf = new PdfDocument(writer)) {

			// Initialize document
			final Document document = new Document(pdf, PageSize.A4);
			document.setMargins(70, 36, 70, 36);

			crearCabeceraFooter(document, footer);

			crearCuerpoPdf(document);

			document.close();

			final ByteArrayInputStream inputStreamOr = new ByteArrayInputStream(outputStreamOr.toByteArray());
			if (insertarPagina && !footer) {
				final ByteArrayOutputStream outputStreamPagina = insertarNumeroPagina(inputStreamOr);
				final InputStream inputStreamPagina = new ByteArrayInputStream(outputStreamPagina.toByteArray());
				pdfStream = new DefaultStreamedContent(inputStreamPagina, ContentTypeEnum.PDF.getContentType(),
						nombrePdf);
				inputStreamPagina.close();
			}
			else {
				pdfStream = new DefaultStreamedContent(inputStreamOr, ContentTypeEnum.PDF.getContentType(), nombrePdf);
			}
			inputStreamOr.close();
		}
		catch (final IOException e) {
			throw new PerException(e);
		}

		return pdfStream;
	}

	/**
	 * Genera el contenido que se mostrará en el PDF.
	 *
	 * @param documento Documento pdf al que se adjuntará el contenido
	 * @throws ProgesinException excepción que puede lanzar
	 */
	public abstract void crearCuerpoPdf(Document documento) throws PerException;

	/**
	 * Inserta el número de página del documento (Página i de n).
	 *
	 * @param inputOrigen InputStream que lee para calcular el número total de páginas
	 * @return OutputStream generado en la información de la página.
	 * @throws IOException posible excepción
	 */
	protected ByteArrayOutputStream insertarNumeroPagina(final InputStream inputOrigen) throws IOException {
		final PdfReader reader = new PdfReader(inputOrigen);
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		final PdfWriter writer = new PdfWriter(outputStream);
		final PdfDocument pdfDoc = new PdfDocument(reader, writer);
		final Document doc = new Document(pdfDoc);
		final int numPaginas = pdfDoc.getNumberOfPages();
		for (int i = 1; i <= numPaginas; i++) {
			doc.showTextAligned(new Paragraph(String.format("Página %s de %s", i, numPaginas)),
					(pdfDoc.getDefaultPageSize().getRight() - doc.getRightMargin()
							- (pdfDoc.getDefaultPageSize().getLeft() + doc.getLeftMargin())) / 2 + doc.getLeftMargin(),
					pdfDoc.getDefaultPageSize().getBottom() + 20, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
		}
		doc.close();
		return outputStream;
	}
}

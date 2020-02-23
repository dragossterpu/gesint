package ro.stad.online.gesint.util;

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

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.persistence.entities.enums.TipContinutEnum;

/**
 * Clasa pentru generarea documentelor PDF ale aplicației.
 *
 * @author STAD
 *
 */
public abstract class PdfAbstractGenerator {

        /**
         * Creați antetul și finalul documentului
         * @param document Unde se creaza antetul și finalul documentului
         * @param adaugaFooter Indică dacă se pune un footer în document sau se introduce doar un antet
         * @throws IOException excepție pe care o poate avea
         */
        protected void crearCabeceraFooter(final Document document, final boolean adaugaFooter) throws IOException {
                // Footer
                String footer = null;
                if (adaugaFooter) {
                        footer = Constante.LOGO;
                }
                final HeaderFooterPdf handler = new HeaderFooterPdf(document, Constante.LOGOPER,
                                "static/images/logo_gesint.PNG", "static/images/logo_gesintNew.png", footer);
                document.getPdfDocument().addEventHandler(PdfDocumentEvent.END_PAGE, handler);
        }

        /**
         * Generați conținutul care va fi afișat în PDF
         * @param document Document pdf la care va fi atașat conținutul
         * @throws GesintException excepție care se poate lansa
         */
        public abstract void creareCorpPdf(Document document) throws GesintException;

        /**
         * Genereaza numele documentului
         * @param numeDocument Numele final al documentului
         * @param numePdf Numele static al documentului
         */
        public abstract String creareNumeDocument(String numePdf);

        /**
         * Inregistram documentul cu statistica documentului
         * @param numeDocument Numele final al documentului
         * @param outputStreamOr ByteArrayOutputStream
         */
        public abstract void inregistrareDocumentStatistica(String numeDocument, ByteArrayOutputStream outputStreamOr);

        /**
         * Creaza documentul pdf.
         * @param numePdf Nombre del pdf.
         * @param footer Indica si hay que hay añadir un footer con imagen (el logo de calidad)
         * @param adaugaPagina Inserta el número de página (incompatible con el otro footer)
         * @return StreamedContent streamcontent para usar el fileDownload de primefaces
         * @throws ProgesinException posible excepción
         */
        protected StreamedContent crearPdf(final String numePdf, final boolean footer, final boolean adaugaPagina)
                        throws GesintException {
                StreamedContent pdfStream = null;
                String numeDocument = Constante.SPATIU;
                try (ByteArrayOutputStream outputStreamOr = new ByteArrayOutputStream();
                                PdfWriter writer = new PdfWriter(outputStreamOr);
                                PdfDocument pdf = new PdfDocument(writer)) {

                        // Initializam documentul
                        final Document document = new Document(pdf, PageSize.A4);
                        document.setMargins(NumarMagic.NUMBERSEVENTY, NumarMagic.NUMBERTHIRTYSIX,
                                        NumarMagic.NUMBERSEVENTY, NumarMagic.NUMBERTHIRTYSIX);
                        crearCabeceraFooter(document, footer);
                        creareCorpPdf(document);
                        numeDocument = creareNumeDocument(numePdf);
                        document.close();
                        final ByteArrayInputStream inputStreamOr = new ByteArrayInputStream(
                                        outputStreamOr.toByteArray());
                        if (adaugaPagina && !footer) {
                                final ByteArrayOutputStream outputStreamPagina = insertarNumeroPagina(inputStreamOr);
                                InputStream inputStreamPagina = new ByteArrayInputStream(
                                                outputStreamPagina.toByteArray());
                                pdfStream = new DefaultStreamedContent(inputStreamPagina,
                                                TipContinutEnum.PDF.getContentType(), numeDocument);
                                inputStreamPagina.close();
                        }
                        else {
                                pdfStream = new DefaultStreamedContent(inputStreamOr,
                                                TipContinutEnum.PDF.getContentType(), numeDocument);
                        }
                        inputStreamOr.close();
                        inregistrareDocumentStatistica(numeDocument, outputStreamOr);

                }
                catch (final IOException e) {
                        throw new GesintException(e);
                }

                return pdfStream;
        }

        /**
         * Metodă care trebuie pusă în aplicare de clasele care o moștenesc. El va fi responsabil pentru crearea
         * conținutului PDF.
         *
         * @return StreamedContent necesară pentru componenta p:fileDownload de primefaces
         * @throws GesintException excepție care trebuie lanzată dacă apare o eroare
         */
        public abstract StreamedContent exportarPdf() throws GesintException;

        /**
         * Introduceți numărul paginii din document (Pagina i din n).
         * @param inputOrigen InputStream care citește si calculeaza numărul total de pagini
         * @return OutputStream generate în informațiile paginii.
         * @throws IOException posibla excepție
         */
        protected ByteArrayOutputStream insertarNumeroPagina(final InputStream inputOrigen) throws IOException {
                final PdfReader reader = new PdfReader(inputOrigen);
                final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                final PdfWriter writer = new PdfWriter(outputStream);
                final PdfDocument pdfDoc = new PdfDocument(reader, writer);
                final Document doc = new Document(pdfDoc);
                final int numPagini = pdfDoc.getNumberOfPages();
                for (int i = 1; i <= numPagini; i++) {
                        doc.showTextAligned(new Paragraph(String.format("Pagina %s de %s", i, numPagini)),
                                        (pdfDoc.getDefaultPageSize().getRight() - doc.getRightMargin()
                                                        - (pdfDoc.getDefaultPageSize().getLeft() + doc.getLeftMargin()))
                                                        / 2 + doc.getLeftMargin(),
                                        pdfDoc.getDefaultPageSize().getBottom() + NumarMagic.NUMBERTWENTY, i,
                                        TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
                }
                doc.close();
                return outputStream;
        }
}

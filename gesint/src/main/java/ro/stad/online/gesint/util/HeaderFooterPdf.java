package ro.stad.online.gesint.util;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;

/**
 * Generator de Antet și footer pentru PDF.
 *
 * @author STAD
 *
 */
@Getter
@Setter
public class HeaderFooterPdf implements IEventHandler {

        /**
         * Dcoument.
         */
        private Document doc;

        /**
         * Imaginea antetului.
         */
        private Image headerRepetat;

        /**
         * Imaginea antetului..
         */
        private Image header1;

        /**
         * Imaginea antetului.
         */
        private Image header2;

        /**
         * Imagine FOOTER.
         */
        private Image footer1;

        /**
         * 
         * @param document la care doriți să adăugați antetul / subsolul
         * @param imagineUnu url-ul imaginii în a prima poziție a antetului
         * @param imagineDoi url-ul imaginii în a doua poziție a antetului
         * @param antetRepetat url-ul imaginii care se repetă pe toate paginile antet(cu excepția primului)
         * @param footer url-ul imaginii footer
         * @throws IOException excepție poate fi lanzată atunci când se creează imagini
         */
        public HeaderFooterPdf(final Document document, final String imagineUnu, final String imagineDoi,
                        final String antetRepetat, final String footer) throws IOException {
                this.doc = document;
                this.headerRepetat = creareImagine(antetRepetat);
                this.header1 = creareImagine(imagineUnu);
                this.header2 = creareImagine(imagineDoi);
                this.footer1 = creareImagine(footer);
        }

        /**
         * Creaza un antet și un footer documentului
         * @param event Event care declanșează generația
         */
        @Override
        public void handleEvent(final Event event) {
                crearHeader(event);
                if (this.footer1 != null) {
                        crearFooter(event);
                }
        }

        /**
         * Creaza un antet de un document.
         * @param event Event care declanșează generația
         */
        private void crearHeader(final Event event) {
                final PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
                final PdfDocument pdfDoc = docEvent.getDocument();
                final PdfPage page = docEvent.getPage();
                final Rectangle pageSize = docEvent.getPage().getPageSize();

                final PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);

                if (pdfDoc.getPageNumber(page) == NumarMagic.NUMBERONE) {
                        final Rectangle rect = new Rectangle(pdfDoc.getDefaultPageSize().getX() + doc.getLeftMargin(),
                                        pdfDoc.getDefaultPageSize().getTop() - doc.getTopMargin(),
                                        NumarMagic.NUMBERFIVEHUNDREDTWENTYTHREE, header1.getImageHeight());
                        header1.setFixedPosition(pageSize.getLeft() + doc.getLeftMargin(),
                                        pageSize.getTop() - doc.getTopMargin());
                        header2.setFixedPosition(
                                        pageSize.getRight() - doc.getRightMargin() - header2.getImageScaledWidth(),
                                        pageSize.getTop() - doc.getTopMargin());
                        final Canvas c = new Canvas(canvas, pdfDoc, rect);
                        c.add(header1);
                        c.add(header2);
                        c.close();
                }
                else {
                        final Rectangle rect = new Rectangle(pdfDoc.getDefaultPageSize().getX() + doc.getLeftMargin(),
                                        pdfDoc.getDefaultPageSize().getTop() - doc.getTopMargin(),
                                        NumarMagic.NUMBERFIVEHUNDREDTWENTYTHREE, headerRepetat.getImageHeight());
                        headerRepetat.setFixedPosition(
                                        pageSize.getRight() - doc.getRightMargin()
                                                        - headerRepetat.getImageScaledWidth(),
                                        pageSize.getTop() - doc.getTopMargin() + NumarMagic.NUMBERTEN);
                        final Canvas c = new Canvas(canvas, pdfDoc, rect);
                        c.add(headerRepetat);
                        c.close();
                }
        }

        /**
         * Creaza un footer de un document.
         * @param event Event care declanșează generația
         */
        private void crearFooter(final Event event) {
                final PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
                final PdfDocument pdfDoc = docEvent.getDocument();
                final PdfPage page = docEvent.getPage();
                final Rectangle pageSize = docEvent.getPage().getPageSize();

                footer1.setFixedPosition((pageSize.getRight() - doc.getRightMargin()
                                - (pageSize.getLeft() + doc.getLeftMargin())) / NumarMagic.NUMBERTWO
                                + doc.getLeftMargin(), pageSize.getBottom() + NumarMagic.NUMBERTEN);

                final PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);
                final Rectangle rectFooter = new Rectangle(pdfDoc.getDefaultPageSize().getX() + doc.getLeftMargin(),
                                pdfDoc.getDefaultPageSize().getBottom(), 523, footer1.getImageHeight());

                final Canvas canvas = new Canvas(pdfCanvas, pdfDoc, rectFooter);
                canvas.add(footer1);
                canvas.close();
        }

        /**
         * Creaza o imagine dupa un url.
         * @param path url-ul imaginii
         * @return Imagine de itext
         * @throws IOException Excepție care poate fi lansată la crearea imaginii
         */
        private Image creareImagine(final String path) throws IOException {
                Image imagine = null;
                if (path != null) {
                        final File file = new ClassPathResource(path).getFile();
                        imagine = new Image(ImageDataFactory.create(file.getPath()));
                        imagine.scaleAbsolute(imagine.getImageWidth() * Constante.ESCALA,
                                        imagine.getImageHeight() * Constante.ESCALA);
                }
                return imagine;
        }
}
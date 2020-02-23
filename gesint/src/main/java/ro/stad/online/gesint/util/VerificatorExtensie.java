package ro.stad.online.gesint.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;
import org.apache.tika.sax.BodyContentHandler;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import ro.stad.online.gesint.constante.Constante;

/**
 * Utilitate pentru a verifica extensia documentelor.
 * 
 * @author STAD
 *
 */
@Component("verificadorExtensie")
public class VerificatorExtensie {

        /**
         * Metida care primește un obiect de tipul UploadedFile și verifică faptul că tipul de conținut dat de JSF
         * (bazat pe extensia sa) corespunde tipului real de conținut obținut prin Tika (pe baza conținutului
         * antetului).
         * 
         * 
         * @param file fișier pentru care doriți să verificați validitatea extensiei
         * @return boolean
         *
         */

        public boolean extensionCorrecta(UploadedFile file) {
                final String extensie = file.getFileName().substring(file.getFileName().lastIndexOf('.') + 1);
                final List<String> extensieNeVerificate = Arrays.asList("mid", "7z", "zip", "csv", "wav", "htm", "html",
                                "txt", "wmv", "avi", Constante.PNG, "bmp", "jpeg", "mp3", "msg", "jpg");
                boolean raspuns = extensieNeVerificate.contains(extensie);
                if (!raspuns) {
                        String tip = Constante.SPATIU;
                        final ContentHandler handler = new BodyContentHandler(-1);
                        final Metadata metadata = new Metadata();
                        final ParseContext pcontext = new ParseContext();
                        final Parser parser;

                        if (file.getContentType().contains("openxmlformats")) {
                                parser = new OOXMLParser();
                        }
                        else {
                                parser = new AutoDetectParser();
                        }

                        try {
                                parser.parse(file.getInputstream(), handler, metadata, pcontext);
                                tip = metadata.get("Content-Type");
                        }
                        catch (IOException | SAXException | TikaException e) {
                                tip = "error";
                        }

                        raspuns = tip.equalsIgnoreCase(file.getContentType());
                }
                return raspuns;
        }

}

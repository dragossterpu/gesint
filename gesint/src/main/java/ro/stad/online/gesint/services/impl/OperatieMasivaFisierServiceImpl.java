package ro.stad.online.gesint.services.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.faces.application.FacesMessage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.util.StringUtils;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.CanalAlertaEnum;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.RolEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.entities.enums.SexEnum;
import ro.stad.online.gesint.persistence.entities.enums.StatutCivilEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.LocalitateService;
import ro.stad.online.gesint.services.OperatieMasivaFisierService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Implementarea interfeței unde logica este definită pentru operațiunile in masă ale utilizatorilor..
 * @author STAD
 */
@Service
public class OperatieMasivaFisierServiceImpl implements OperatieMasivaFisierService {

        /**
         * Variabila utilizata pentru a injecta serviciul de utilizator.
         */
        @Autowired
        private UtilizatorService utilizatorService;

        /**
         * Variabila utilizata pentru a injecta serviciul provinciei.
         *
         */
        @Autowired
        private JudetService judetService;

        /**
         * Variabila utilizata pentru el encriptor de parola.
         */
        @Autowired
        private PasswordEncoder passwordEncoder;

        /**
         * Componente de utilitati.
         */
        @Autowired
        private Utilitati utilitati;

        /**
         * Variala utilizata pentru injectarea serviciului înregistrare a activității.
         */
        @Autowired
        private RegistruActivitateServiceImpl registruActivitateService;

        /**
         * Variabila utilizata pentru a injecta serviciul localitatilor.
         *
         */
        @Autowired
        private LocalitateService localitateService;

        /**
         * Localitate aleasa.
         */
        private Localitate localidad;

        /**
         * Variabila pentru cnp
         */
        private String cnp;

        /**
         * Variabila pentru data nasterii
         */
        private Date data;

        /**
         * Metoda care proceseaza operarea masivă a unui fișier.
         * @param event evento de donde se obtendrá el fichero
         * @param tipoRegistro tipo de operación
         * @param mensajeExcepcion mensaje en caso de que ocurra un fallo
         */
        @Override
        public void procesareOperatieMasivaFisier(final FileUploadEvent event, final String tipRegistru,
                        final String mesajExceptie) {
                try {
                        final String mesaj = incarcareFisierOperareMasiva(event.getFile(), tipRegistru);
                        if (StringUtils.isEmpty(mesaj)) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                RegistruEnum.INREGISTRARE.getDescriere(),
                                                "Toți utilizatorii au fost procesați cu succes.");
                        }
                        else {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(),
                                                Constante.EXISTERORI.concat(mesajExceptie) + mesaj);
                        }
                }
                catch (final TransactionException | IOException | NoSuchElementException te) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.EXISTERORI.concat(mesajExceptie));
                }
        }

        /**
         * Metodă care incarcă un excel de utilizatori valabili.
         * @param uFile UploadedFile
         * @param operare tip de operare realizata
         * @return lista de utilizatori
         * @throws IOException exceptie lansata de intrare/iesire.
         */
        private String incarcareFisierOperareMasiva(final UploadedFile uFile, final String operare) throws IOException {
                final List<String> listaUtilizatoriExistentiBD = utilizatorService
                                .cautareListaNumeUtilizator(obtinemUsernemeDinFisier(returIteratorNou(uFile)));
                return citesteFisierSalveaza(listaUtilizatoriExistentiBD, returIteratorNou(uFile), operare);

        }

        /**
         * Metodă care returnează un nou iterator de rând pentru fișier.
         * @param uFile UploadedFile
         * @return iterator de file
         * @throws IOException exceptie lansata de intrare/iesire.
         */
        @SuppressWarnings("resource")
        private Iterator<Row> returIteratorNou(final UploadedFile uFile) throws IOException {
                final Workbook workbook = new XSSFWorkbook(uFile.getInputstream());
                final Sheet sheet = workbook.getSheetAt(0);
                return sheet.iterator();
        }

        /**
         * Metodă care obține lista cu numele de utilizator din fișier.
         * @param rowIterator iterator de file din fisier
         * @return lista List<String> lista de nume de utilizatori
         */
        private List<String> obtinemUsernemeDinFisier(final Iterator<Row> rowIterator) {
                final List<String> listaUsernames = new ArrayList<>();
                final DataFormatter dataFormatter = new DataFormatter();
                rowIterator.next();
                while (rowIterator.hasNext()) {
                        final String username = dataFormatter.formatCellValue(rowIterator.next().cellIterator().next());
                        if (!StringUtils.isEmpty(username.trim())) {
                                listaUsernames.add(username);
                        }
                }
                return listaUsernames;
        }

        /**
         * Metodă care citeste fișierul rând pe rând și efectueaza operațiunile relevante.
         * @param listaBazeDate lista de utilizatori care se regasesc in baza de date.
         * @param iteratorFile iterator de file
         * @param operare operatie care se va a realiza
         * @throws ParseException exceptie lansata
         * @return mesaj Ieșire cu utilizatorii corecți și în starea de eroare
         */
        private String citesteFisierSalveaza(final List<String> listaBazeDate, final Iterator<Row> iteratorFile,
                        final String operare) {
                final DataFormatter dataFormatter = new DataFormatter();
                final List<Utilizator> listaUtilizatoriSalvare = new ArrayList<>();
                final StringBuilder mesaj = new StringBuilder();
                Row row;
                iteratorFile.next();
                while (iteratorFile.hasNext()) {
                        row = iteratorFile.next();
                        final String username = dataFormatter.formatCellValue(row.cellIterator().next());
                        if (!StringUtils.isEmpty(username.trim())) {
                                final String resultatObtinut = obtinereListaSalvare(listaBazeDate, operare,
                                                listaUtilizatoriSalvare, row, username);
                                if (!StringUtils.isEmpty(resultatObtinut)) {
                                        mesaj.append(resultatObtinut);
                                }
                        }
                }
                String suntErori = "Rezolvați-le și încercați din nou.";
                if (!listaUtilizatoriSalvare.isEmpty() && operare.equals(RegistruEnum.INREGISTRARE.getDescriere())) {
                        utilizatorService.salvat(listaUtilizatoriSalvare);
                        suntErori = suntErori.concat(" Restul membrilor au fost salvați cu succes.");
                }
                else if (operare.equals(RegistruEnum.ELIMINARE.getDescriere())) {
                        utilizatorService.bajaLogica(listaBazeDate);
                        suntErori = suntErori.concat(" Restul membrilor s-au eliminat cu succes.");
                }
                else if (operare.equals(RegistruEnum.BLOCARE.getDescriere())) {
                        utilizatorService.dezactivare(listaBazeDate);
                        suntErori = suntErori.concat(" Restul membrilor s-au blocat cu succes.");
                }
                if (!StringUtils.isEmpty(mesaj.toString())) {
                        mesaj.append(suntErori);
                }
                return mesaj.toString();
        }

        /**
         * Metodă care completeaza lista cu utilizatorii pentru ai salva în baza de date.
         * @param listaBazeDate lista de utilizatori care exista in baza de date
         * @param operare operatie care se va a realiza
         * @param listaUtilizatoriSalvare lista de utilizatori care va fi salvata in baza de date
         * @param row fila fisierului
         * @param username numele utilizatorului
         * @return mesaj cu rezultatul operatiunii
         * @throws ParseException exceptie lansata
         */
        private String obtinereListaSalvare(final List<String> listaBazeDate, final String operare,
                        final List<Utilizator> listaUtilizatoriSalvare, final Row row, final String username) {
                final DataFormatter dataFormatter = new DataFormatter();
                final StringBuilder mesaj = new StringBuilder();
                if (operare.equals(RegistruEnum.INREGISTRARE.getDescriere())) {
                        if (!listaBazeDate.contains(username)) {
                                final Utilizator utilizator = new Utilizator();
                                utilizator.setUsername(username);
                                try {
                                        obtinemDateUtilizatorInregistrare(utilizator, row.cellIterator(), dataFormatter,
                                                        mesaj);
                                        listaUtilizatoriSalvare.add(utilizator);
                                }
                                catch (final GesintException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                }
                        }
                        else {
                                adaugareRegistruEroare(mesaj, row,
                                                (Constante.MEMBRUL + username + "' există deja în baza de date."));
                        }
                }
                else {
                        if (!listaBazeDate.contains(username)
                                        && operare.equals(RegistruEnum.INREGISTRARE.getDescriere())) {
                                adaugareRegistruEroare(mesaj, row,
                                                (Constante.MEMBRUL + username + "' nu este găsit în baza de date."));
                        }
                }
                return mesaj.toString();
        }

        /**
         * Metoda care obține datele utilizatorului din fișierul excel pentru a fi creat în baza de date.
         * @param utilizator utilizatorul caruia i se vor adauga datele din fisier
         * @param colIterator iterator de coloane
         * @param dataFormatter formateador de columnas
         * @param mesaj String mesajul rezultatului
         * @throws GesintException exceptie lansata
         */
        private void obtinemDateUtilizatorInregistrare(final Utilizator utilizator, final Iterator<Cell> colIterator,
                        final DataFormatter dataFormatter, final StringBuilder mesaj) throws GesintException {
                String cellValue;
                colIterator.next();
                // Nume
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setNume(cellValue);
                // Prenume
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setPrenume(cellValue);
                // CNP
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setIdCard(cellValue);
                cnp = utilizator.getIdCard();
                // Utilizator
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setUsername(cellValue);
                // Email
                utilizator.setEmail(cellValue);
                // Email personal
                utilizator.setPersonalEmail(cellValue);
                // Rol
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilitati.existeRol(RolEnum.valueOf(cellValue));
                utilizator.setRole(RolEnum.valueOf(cellValue));
                // TELEFON
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setPhone(cellValue);
                // NUMAR SI SERIA CARD DE IDENTITATE
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setNumarCard(cellValue);
                // ADRESA
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setAdresa(cellValue);
                // DATA NASTERII
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                final SimpleDateFormat formatulDatei = new SimpleDateFormat(Constante.FORMATDATE);
                try {

                        utilizator.setDataNasterii(formatulDatei.parse(cellValue));
                        data = utilizator.getDataNasterii();
                }
                catch (final ParseException e1) {
                        mesaj.append("Eroare apărută la procesarea datei de naștere");
                        final String descriere = "A apărut o eroare la procesarea datei de naștere";
                        this.registruActivitateService.salveazaRegistruEroare(descriere,
                                        SectiuniEnum.PROCESMASIV.getDescriere(), e1);
                }
                // NIVEL DE EDUCATIE
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilitati.existeEducatie(EducatieEnum.valueOf(cellValue));
                utilizator.setEducatie(EducatieEnum.valueOf(cellValue));
                // LOC DE MUNCA
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilizator.setLocMunca(cellValue);
                // SEX
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilitati.existeSex(SexEnum.valueOf(cellValue));
                final String sex = cellValue;
                if (valideazaCnp(sex, data, cnp)) {
                        utilizator.setSex(SexEnum.valueOf(cellValue));
                }
                else {
                        mesaj.append("Datele introduse în registru nu sunt corecte. Verificați , data nașterii, sexul sau cnp-ul membrului.");
                }
                // STARE CIVILA
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilitati.existeCivilStatus(StatutCivilEnum.valueOf(cellValue));
                utilizator.setStatutCivil(StatutCivilEnum.valueOf(cellValue));
                // PROVINCIA
                cellValue = obtinetiIdCelulaFisier(dataFormatter.formatCellValue(colIterator.next()).trim());
                utilitati.esteIntreg(cellValue);
                Judet judet = new Judet();
                try {
                        judet.setIndicator(String.valueOf(cellValue));
                }
                catch (final NumberFormatException e) {
                        mesaj.append(" Codul judeţului trebuie să fie numeric.");
                        throw new GesintException("Codul judeţului trebuie să fie numeric.");
                }
                judet = judetService.findById(judet.getIndicator());
                if (judet != null) {
                        utilizator.setCodJudet(judet);
                }
                else {
                        mesaj.append(" Judeţul nu este prezent în baza de date.");
                        throw new GesintException("Judeţul nu este prezent în baza de date.");
                }
                // TIPUL LOCALITATII
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                utilitati.existeTypeLocality(TipLocalitateEnum.valueOf(cellValue));
                final TipLocalitateEnum tipulLocalitatii = TipLocalitateEnum.valueOf(cellValue);
                // LOCALITATEA
                cellValue = dataFormatter.formatCellValue(colIterator.next());
                // Cautam localitatea dupa nume
                this.localidad = localitateService.localidadByNumeIgnoreCaseAndJudet(cellValue, judet);
                // Daca nu exista o cream
                if (localidad == null) {
                        utilizator.setLocalitate(
                                        localitateService.inregistrareLocalitate(cellValue, judet, tipulLocalitatii));
                }
                else {
                        utilizator.setLocalitate(localidad);
                }
                utilizator.setPassword(passwordEncoder.encode(Constante.UNU));
                // MEMBRU ACTIV
                utilizator.setValidat(true);
                // SCANAL DE COMUNICARE
                utilizator.setCanalCorespondenta(CanalAlertaEnum.EMAIL);
        }

        /**
         * Metoda de validare a unicității numelui de utilizator.
         * @param sex String
         * @param dataFisier Date
         * @param cnp String
         * @return boolean
         */
        private boolean valideazaCnp(final String sex, final Date dataFisier, final String cnp) {
                boolean resultat = true;
                if (cnp.length() == NumarMagic.NUMBERELEVEN) {
                        final String an = cnp.substring(1, NumarMagic.NUMBERTHREE);
                        final String luna = cnp.substring(NumarMagic.NUMBERTHREE, NumarMagic.NUMBERFIVE);
                        final String zi = cnp.substring(NumarMagic.NUMBERFIVE, NumarMagic.NUMBERSEVEN);
                        final String cnpul = cnp.substring(0, 1);
                        final Date dataCnp = dataFisier;
                        final SimpleDateFormat sdf = new SimpleDateFormat("yy");
                        final SimpleDateFormat lsdf = new SimpleDateFormat(Constante.MM);
                        final SimpleDateFormat zsdf = new SimpleDateFormat("dd");
                        final String anString = sdf.format(dataCnp);
                        final String lunaString = lsdf.format(dataCnp);
                        final String ziString = zsdf.format(dataCnp);
                        if (an.equals(anString) && luna.equals(lunaString) && zi.equals(ziString)
                                        && (Constante.MAN.equals(sex) && Constante.UNU.equals(cnpul)
                                                        || Constante.WOMAN.equals(sex) && Constante.DOI.equals(cnpul))) {
                                resultat = true;
                        }
                        else {
                                resultat = false;
                        }
                }
                else {
                        resultat = false;
                }
                return resultat;
        }

        /**
         * Metodă care adăugă un text de erorare la StringBuilder.
         * @param mesaj mesaj la care se va adăuga înregistrarea eronată
         * @param row rândul în care s-a produs eroarea
         * @param eroare eroarea care a cauzat problema
         */
        private void adaugareRegistruEroare(final StringBuilder mesaj, final Row row, final String eroare) {
                if (StringUtils.isEmpty(mesaj)) {
                        mesaj.append("Următoarele înregistrări conțin un tip de eroare și nu au fost salvate:");
                }
                mesaj.append("înregistrarea membrului de pe rândul ").append(row.getRowNum())
                                .append(":  al fișierului de proces masiv").append(eroare);
        }

        /**
         * Obține ID-ul unui corp sau al unei celule din excel.
         * @param celula valoarea celulei din fisier
         * @return id obtenido
         */
        private String obtinetiIdCelulaFisier(final String celula) {
                return celula.substring(0, celula.indexOf(Constante.LINIE)).trim();
        }
}


package ro.stad.online.gesint.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.joda.time.ReadableInstant;
import org.joda.time.Years;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.RolEnum;
import ro.stad.online.gesint.persistence.entities.enums.SexEnum;
import ro.stad.online.gesint.persistence.entities.enums.StatutCivilEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;
import ro.stad.online.gesint.services.RegistruActivitateService;

/**
 * Metode de utilitate
 * @author STAD
 */
@Component
public class Utilitati {

        /**
         * Service de jurnal de activitate.
         */
        @Autowired
        private RegistruActivitateService registro;

        /**
         * Elimină din sesiune bean-ul, care conține acel nume.
         * @param listaBeans Numele bean-ului care nu trebuie scoase din sesiune.
         */
        public static void cleanSession(final List<String> listaBeans) {
                final Map<String, Object> mapaSesion = FacesContext.getCurrentInstance().getExternalContext()
                                .getSessionMap();
                for (final String cabecera : mapaSesion.keySet()) {
                        final String ubicacion = mapaSesion.get(cabecera).getClass().getPackage().toString()
                                        .toLowerCase();
                        if (ubicacion.contains(Constante.BEAN)
                                        && Constante.NAVIGAREBEAN.equals(cabecera) == Boolean.FALSE
                                        && listaBeans.contains(cabecera) == Boolean.FALSE) {
                                mapaSesion.remove(cabecera);
                        }
                }
        }

        /**
         * Elimină din sesiune bean-ul, care conține acel nume.
         * @param numeBeanActual Numele bean-ului care nu trebuie scoase din sesiune.
         */
        public static void cleanSession(final String numeBeanActual) {
                final Map<String, Object> mapaSesion = FacesContext.getCurrentInstance().getExternalContext()
                                .getSessionMap();
                for (final String antet : mapaSesion.keySet()) {
                        final String ubicacion = mapaSesion.get(antet).getClass().getPackage().toString().toLowerCase();
                        if (ubicacion.contains(Constante.BEAN) && Constante.NAVIGAREBEAN.equals(antet) == Boolean.FALSE
                                        && antet.equals(numeBeanActual) == Boolean.FALSE) {
                                mapaSesion.remove(antet);
                        }
                }
        }

        /**
         * Schimbamnumele partidului
         * @param numele
         * @return String
         *
         */
        public static String convertNumePartid(final String numele) {
                final String nume = numele.toLowerCase();
                final char[] caractere = nume.toCharArray();
                caractere[0] = Character.toUpperCase(caractere[0]);
                for (int i = 0; i < nume.length() - NumarMagic.NUMBERTWO; i++) {
                        // Este 'text'
                        if (caractere[i] == ' ' || caractere[i] == '.' || caractere[i] == ',') {
                                // schimbam
                                caractere[i + 1] = Character.toUpperCase(caractere[i + 1]);
                        }
                }

                return new String(caractere);
        }

        /**
         * Încărcați șablonul și generați textul final cu parametrii furnizați.
         * @param sablon sablon String(txt,html,etc.)
         * @param parametrii Map<String, Object>
         * @return textCompilat String
         * @throws PebbleException eroare de compilare
         * @throws IOException eroare de încărcare a șablonului
         */
        public static String generarTextoConPlantilla(final String sablon, final Map<String, Object> parametrii)
                        throws PebbleException, IOException {

                final PebbleEngine engine = new PebbleEngine.Builder().autoEscaping(false).build();
                final PebbleTemplate compiledTemplate = engine.getTemplate(sablon);

                final Writer writer = new StringWriter();
                compiledTemplate.evaluate(writer, parametrii);

                final String textCompilat = writer.toString();

                return textCompilat;
        }

        /**
         * Returnează numărul de zile care au trecut de la o dată introdusă prin parametru până astăzi.
         * @param data Date
         * @return zile int
         */
        public static Long getDiasHastaHoy(final Date data) {
                final LocalDate azi = LocalDate.now();
                long zile = 0;
                LocalDate dataIncepand = null;
                if (data != null) {
                        dataIncepand = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        zile = ChronoUnit.DAYS.between(dataIncepand, azi);
                }
                return zile;
        }

        /**
         * Formatează o dată în conformitate cu un model primit ca parametru.
         * @param date data pentru a o formata
         * @param pattern patron de data
         * @return data formatata
         */

        public static String getFechaFormateada(final Date date, final String pattern) {
                final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                return sdf.format(date);
        }

        // ************* Generating new password ********************//
        /**
         * Returnează o parolă bazată pe o combinație de litere și numere.
         * @return contraseña
         */
        public static String getPassword() {
                return getPinLetters() + getPinNumber();
        }

        // ************* Generating new password END ********************//

        /**
         * Returnează un șir de patru litere aleatorii.
         * @return llitere
         */
        public static String getPinLetters() {
                return getRandomChars("ABCDEFGHIJKLMNOPRSTUVXYZWQ", NumarMagic.NUMBERFOUR);
        }

        /**
         * Returnează un șir de patru numere aleatorii.
         * @return números
         */
        public static String getPinNumber() {
                return getRandomChars("0123456789", NumarMagic.NUMBERFOUR);
        }

        /**
         * Returnează un șir de caractere aleatorii dintr-un set de caractere și o anumită lungime.
         * @param key șir de caractere posibile
         * @param length numărul de caractere dorit
         * @return pswd String șir de caractere alese
         */
        public static String getRandomChars(final String key, final int length) {
                final StringBuilder pswd = new StringBuilder();
                final Random r = new Random();

                for (int i = 0; i < length; i++) {
                        pswd.append(key.charAt(r.nextInt(key.length())));
                }

                return pswd.toString();
        }

        /**
         * Verificați dacă un obiect este nul sau alb.
         * @param obj Obiectul de verificat.
         * @return true, Dacă obiectul este nul sau valoarea sa în String este "".
         */
        public static boolean isNullOrBlank(final Object obj) {
                if (obj == null) {
                        return true;
                }
                if (Constante.SPATIU.equals(obj.toString())) {
                        return true;
                }
                return false;
        }

        /**
         * Elimina bean din șesiunecare nu conține acest nume.
         * @param numeBeanActual
         */
        public static void cautareSesiune(final String numeBeanActual) {
                final Map<String, Object> mapaSesion = FacesContext.getCurrentInstance().getExternalContext()
                                .getSessionMap();
                for (final String antet : mapaSesion.keySet()) {
                        final String url = mapaSesion.get(antet).getClass().getPackage().toString().toLowerCase();
                        if (url.contains(Constante.BEAN) && Constante.NAVIGAREBEAN.equals(antet) == Boolean.FALSE
                                        && antet.equals(numeBeanActual) == Boolean.FALSE) {
                                mapaSesion.remove(antet);
                        }
                }
        }

        /**
         * Metoda pentru a obtine luna
         * @param param
         * @return String luna
         */
        public static String luna(final String param) {
                String luna = Constante.SPATIU;
                if (param.equals("January") || param.equals("enero")) {
                        luna = "Ianuarie";
                }
                else if (param.equals("February") || param.equals("febrero")) {
                        luna = "Februarie";
                }
                else if (param.equals("March") || param.equals("marzo")) {
                        luna = "Martie";
                }
                else if (param.equals("April") || param.equals("mayo")) {
                        luna = "Aprilie";
                }
                else if (param.equals("May") || param.equals("abril")) {
                        luna = "Mai";
                }
                else if (param.equals("June") || param.equals("junio")) {
                        luna = "Iunie";
                }
                else if (param.equals("July") || param.equals("julio")) {
                        luna = "Iulie";
                }
                else if (param.equals("August") || param.equals("agosto")) {
                        luna = "August";
                }
                else if (param.equals("September") || param.equals("septiembre")) {
                        luna = "Septembrie";
                }
                else if (param.equals("October") || param.equals("octubre")) {
                        luna = "Octombrie";
                }
                else if (param.equals("November") || param.equals("noviembre")) {
                        luna = "Noiembrie";
                }
                else {
                        luna = "Decembrie";
                }
                return luna;

        }

        /**
         * Converts a Map to a List filled with its entries. This is needed since very few if any JSF iteration
         * components are able to iterate over a map.
         */
        public static <T, S> List<Map.Entry<T, S>> mapToList(final Map<T, S> map) {

                if (map == null) {
                        return null;
                }

                final List<Map.Entry<T, S>> list = new ArrayList<>();
                list.addAll(map.entrySet());

                return list;
        }

        /**
         * Generează un mesaj de eroare dintr-o excepție.
         * @param e Exception
         * @return Mesaj
         */
        public static String messageError(final Exception e) {
                String message = Arrays.toString(e.getStackTrace());
                if (message.length() > 2000) {
                        message = message.substring(message.length() - NumarMagic.NUMBERTWOTHOUSAND);
                }
                return message;
        }

        /**
         * Metoda pentru a evita nulurile în text.
         * @param text String
         * @return tex de iesire
         */
        public static String nullToBlank(final String text) {
                String tex = text;
                if (tex == null) {
                        tex = Constante.SPATIU;
                }
                return tex;
        }

        /**
         *
         * Metoda pentru a obtine marca
         * @return marca
         *
         */
        public static String obtinemMarca() {
                final Month luna = LocalDate.now().getMonth();
                final String nume = luna.getDisplayName(TextStyle.FULL, new Locale("ro", "RO"));
                final String primaLitera = nume.substring(0, 1);
                final String majuscula = primaLitera.toUpperCase();
                final String restulLitere = nume.substring(1, nume.length());
                final Calendar cal = Calendar.getInstance();
                final int year = cal.get(Calendar.YEAR);
                return majuscula.concat(restulLitere.concat(Constante.SPATIUMARE).concat(String.valueOf(year)));

        }

        /**
         *
         * Metoda care obtine numele lunii
         * @param data data
         * @return marca
         *
         */
        public static String obtinemNumeLuna(final Date data) {
                data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                final Month luna = LocalDate.now().getMonth();
                final String nume = luna.getDisplayName(TextStyle.FULL, new Locale("ro", "RO"));
                final String primaLitera = nume.substring(0, 1);
                final String majuscula = primaLitera.toUpperCase();
                final String restulLitere = nume.substring(1, nume.length());
                Calendar.getInstance();
                return majuscula.concat(restulLitere);

        }

        /**
         * Indică ce tip de operație va fi salvată în registru.
         * @param idObiect Long
         * @param eliminat boolean
         * @return tipRegistru RegistruEnum
         */
        public static RegistruEnum procesarOperacion(final Long idObiect, final boolean eliminat) {
                final RegistruEnum tipRegistru;
                if (idObiect != null) {
                        if (eliminat) {
                                tipRegistru = RegistruEnum.ELIMINARE;
                        }
                        else {
                                tipRegistru = RegistruEnum.MODIFICARE;
                        }
                }
                else {
                        tipRegistru = RegistruEnum.INREGISTRARE;
                }
                return tipRegistru;
        }

        /**
         * Clasele de utilitate nu trebuie să aibă un constructor public
         *
         */
        private Utilitati() {
        }

        /**
         * Obțineți numărul de ani între 2 date.
         * @param start data de inceput
         * @param end data de sfarsit
         * @return int numar de ani
         */
        public int calcularYearsBetween(final ReadableInstant start, final ReadableInstant end) {
                return Years.yearsBetween(start, end).getYears();
        }

        /**
         * Metoda de descărcare a unui fișier din folderul resurse.
         * @param rutaResource url fisier
         * @param contenType tip de document
         * @param nume numele fisierului
         * @return continutul fluxului
         * @throws IOException exceptie intrare/iesiore
         */
        public StreamedContent descarcareFisier(final String rutaResource, final String contenType, final String nume)
                        throws IOException {
                final InputStream inputStream = new ClassPathResource(rutaResource).getInputStream();
                // Nu închideți fluxul. Eroare la descărcare dacă este închis
                return new DefaultStreamedContent(inputStream, contenType, nume);
        }

        /**
         * Verificați dacă un șir introdus de parametru este un număr.
         * @param numar număr i
         * @throws GesintException exceptie
         */
        public void esteIntreg(final String numar) throws GesintException {
                final String regex = "\\d+";
                if (!numar.matches(regex)) {
                        throw new GesintException("Valoarea trebuie să fie un număr întreg.");
                }
        }

        /**
         * Verificați dacă există un camp valabil pentru stare civila trecut ca parametru.
         * @param descriere StatutCivilEnum
         * @throws GesintException exceptie
         */
        public void existeCivilStatus(final StatutCivilEnum descriere) throws GesintException {
                if (!StatutCivilEnum.getStatus().contains(descriere)) {
                        throw new GesintException("Câmpul stare civila nu este un valid.");
                }
        }

        /**
         * Verificați dacă există un camp valabil pentru educatie trecut ca parametru.
         * @param descriere EducatieEnum
         * @throws GesintException exceptie
         */
        public void existeEducatie(final EducatieEnum descriere) throws GesintException {
                if (!EducatieEnum.getEducatie().contains(descriere)) {
                        throw new GesintException("Câmpul educație nu este un valid.");
                }
        }

        /**
         * Verificați dacă există un rol trecut prin parametru.
         * @param descriere RolEnum
         * @throws GesintException exceptie
         */
        public void existeRol(final RolEnum descriere) throws GesintException {
                if (!RolEnum.getRoles().contains(descriere)) {
                        throw new GesintException("Câmpul rol nu este un valid.");
                }
        }

        /**
         * Verificați dacă există un rol trecut prin parametru.
         * @param descriere String
         * @throws GesintException exceptie
         */
        @SuppressWarnings("unlikely-arg-type")
        public void existeRol(final String descriere) throws GesintException {
                if (!RolEnum.getRoles().contains(descriere)) {
                        throw new GesintException("Câmpul rol nu este un valid.");
                }
        }

        /**
         * Verificați dacă există un camp valabil pentru sex trecut ca parametru.
         * @param descriere SexEnum
         * @throws GesintException exceptie
         */
        public void existeSex(final SexEnum descriere) throws GesintException {
                if (!SexEnum.getSex().contains(descriere)) {
                        throw new GesintException("Câmpul sex nu este un valid.");
                }
        }

        /**
         * Verificați dacă există un camp valabil pentru stare civila trecut ca parametru.
         * @param descriere TipLocalitateEnum
         * @throws GesintException exceptie
         */
        public void existeTypeLocality(final TipLocalitateEnum descriere) throws GesintException {
                if (!TipLocalitateEnum.getTypeLocality().contains(descriere)) {
                        throw new GesintException("Câmpul tipul localității nu este un valid.");
                }
        }

        /**
         * Obțineți datele utilizatorului înregistrate.
         * @return utilizator logat
         */
        public Utilizator getUtilizatorLogat() {
                return (Utilizator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }

        /**
         * Returnează o listă reîncărcată cu TRUE de dimensiunea indicată de parametru.
         * @param dimensiune tamaño de la lista
         * @return lista con valores true
         */
        public List<Boolean> listaTrue(final int dimensiune) {
                final List<Boolean> list = new ArrayList<>();
                for (int i = 0; i <= dimensiune; i++) {
                        list.add(Boolean.TRUE);
                }
                return list;
        }

        /**
         * Metoda care procesează excepția pentru a arunca un mesaj de eroare și a salva înregistrarea.
         * @param exceptie Exceptie capturata.
         * @param accion actiune care a lansat exceptia.
         * @param facesUtilities pentru a seta mesajul care va fi afișat
         * @param seccion Secțiunea în care apare excepția
         */
        public void procesareEceptie(final Exception exceptie, final String seccion, final String accion,
                        final FacesUtilities facesUtilities) {
                facesUtilities.setmesajEroare("A apărut o eroare ".concat(accion), Constante.IDMESAJGLOBAL);
                registro.inregistrareEroare(seccion, exceptie);
        }

        /**
         * Metoda care procesează rezultatul unei operații de bază de date pentru a afișa mesajul și a salva
         * înregistrarea. Mesajul este cu confirmare pentru a reveni la ecranul anterior sau a reîmprospăta.
         * @param descriere Descrierea obiectului modificat
         * @param operatie tipul de operatie(inregitrare, eliminare...)
         * @param mesaj mesaj care va fi afisat utilizatorului
         * @param sectiune unde apare rezultatul
         * @param paragraf din meniul în care apare
         * @param facesUtilities pentru a seta mesajul care va fi afișat.
         */
        public void procesareResultateOperatiune(final String descriere, final String operatie, final String mesaj,
                        final String paragraf, final String sectiune, final FacesUtilities facesUtilities) {
                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, operatie, mesaj);
                registro.inregistrareActivitate(sectiune, operatie, paragraf.concat(Constante.OPERATION.concat(operatie)
                                .concat(Constante.DE).concat(descriere).concat(Constante.SEHAREALEXIT)));
        }
}
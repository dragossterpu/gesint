package ro.per.online.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Métodos de utilidades.
 * @author STAD
 */
public class Generador {
	/**
	 * Números.
	 */
	public static final String NUMBERS = "0123456789";

	/**
	 * Números de cuerpos.
	 */
	public static final String CUERPONUMBERS = "12789";

	/**
	 * Tipo de denuncia.
	 */
	public static final String TIPODENUNCIA = "456";

	/**
	 * Subtipos de denuncia.
	 */
	public static final String[] SUBTIPOS = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

	/**
	 * Números 2.
	 */
	public static final String NUMBERS2 = "12";

	/**
	 * Letras.
	 */
	public static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Obtiene un apellido final de la lista.
	 * @return apellido al azar
	 */
	public static String apellidoFinal() {
		final String[] apellidos = { "Niță", "Pop", "Popa", "Popescu", "Ionescu", "Nemeș", "Stan", "Dumitrescu", "Dima",
				"Gheorghiu", "Ioniță", "Marin", "Tudor", "Dobre", "Barbu", "Nistor", "Florea", "Ene", "Dinu",
				"Georgescu", "Stoica", "Diaconu", "Diaconescu", "Mazilescu", "Ababei", "Aanei", "Nistor", "Mocanu",
				"Oprea", "Voinea", "Dochioiu", "Albu", "Tabacu", "Manole", "Cristea", "Toma", "Stănescu", "Pușcașu",
				"Tomescu", "Meceanu", "Ionescu", "Marinescu", "Georgescu", "Vasilescu", "Stoican", "Maican",
				"Gheorghiu", "Vasiliu", "Pâclea", "Pecaru", "Stoicescu", "Tomescu", "Reaboiu", "Rîciu", "Roateș",
				"Scafariu", "Sebeșanu", "Șdirea", "Șabac", "Theodorescu" };
		String apellido = apellidos[1 + new Random().nextInt(59)];
		return apellido.toUpperCase();
	}

	/**
	 * Obtiene el código postal.
	 * @return codigo postal aleatorio
	 */
	public static String getCodigoPostal() {
		return getRandomChars(NUMBERS, 5);
	}

	/**
	 * Obtiene el número de cuerpo.
	 * @return numero cuerpo
	 */
	public static String getCuerpoNumber() {
		return getRandomChars(CUERPONUMBERS, 1);
	}

	/**
	 * Obtener DNI.
	 * @return dni + letra
	 */
	public static String getDni() {
		return getPinLetters() + " " + getPinNumber();
	}

	/**
	 * Obtiene número de identidad.
	 * @return número aleatorio
	 */
	public static String getIdentidad() {
		return getRandomChars(NUMBERS2, 1);
	}

	/**
	 * Obtiene numero id schengen.
	 * @return número aleatorio
	 */
	public static String getNumberIdShen() {
		return getRandomChars(NUMBERS, 10);
	}

	/**
	 * Obtiene número de alias.
	 * @return numero aleatorio
	 */
	public static String getNumeroAlias() {
		return getRandomChars(NUMBERS, 4);
	}

	/**
	 * Obtiene el número de calle.
	 * @return número de calle
	 */
	public static String getNumeroCalle() {
		return getRandomChars(NUMBERS, 2);
	}

	/**
	 * Obtiene orden de búsqueda.
	 * @return numero aleatorio
	 */
	public static String getOrdenBus() {
		return getRandomChars(NUMBERS, 3);
	}

	/**
	 * Obtener letra de pin.
	 * @return letra aleatoria.
	 */
	public static String getPinLetters() {
		return getRandomChars(LETTERS, 2);
	}

	/**
	 * Obtiene el número pin.
	 * @return número aleatorio
	 */
	public static String getPinNumber() {
		return getRandomChars(NUMBERS, 4);
	}

	/**
	 * Obtiene letras aleatorias.
	 * @param key clave
	 * @param length tamaño
	 * @return Cadena de caracteres
	 */
	public static String getRandomChars(final String key, final int length) {
		final StringBuilder numeroCalle = new StringBuilder();
		final Random r = new Random();

		for (int i = 0; i < length; i++) {
			numeroCalle.append(key.charAt(r.nextInt(key.length())));
		}
		return numeroCalle.toString();
	}

	/**
	 * Obtiene un subtipo de denuncia al azar.
	 * @return subtipo de denuncia
	 */
	public static String getSubtipoDenunciaNumber() {
		return SUBTIPOS[1 + new Random().nextInt(9)];
	}

	/**
	 * Obtiene el número de cuerpo.
	 * @return numero cuerpo
	 */
	public static String getTelefon() {
		return getRandomChars(NUMBERS, 9);
	}

	/**
	 * Obtiene tipo de denuncia.
	 * @return tipo de denuncia aleatoria.
	 */
	public static String getTipoDenunciaNumber() {
		return getRandomChars(TIPODENUNCIA, 1);
	}

	/**
	 * Obtener unidad.
	 * @return unidad + SIAD1
	 */
	public static String getUnidad() {
		return getUnidadNumber() + "SIAD1";
	}

	/**
	 * Obtener número de unidad.
	 * @return número unidad aleatorio
	 */
	public static String getUnidadNumber() {
		return getRandomChars(NUMBERS, 13);
	}

	/**
	 * Obtiene un nombre final de la lista.
	 * @return nombre al azar
	 */
	public static String meserii() {
		final String[] nombres = { "Mecanic auto", "Inginer", "Medic", "Ospătar", "Avocat", "Şofer", "Poliţist",
				"Specialist IT", "Bucătar", "Comerciant-vânzător", "Tinichigiu-vopsitor auto", "Brutar-patisier",
				"Profesor", "Economist", "Manager", "Contabil", "Profesor", "Arhitect", "Funcţionar bancar",
				"Lucrător comercial", "Asistent medical", "Agent de securitate", "Manipulant mărfuri", "Constructor",
				"Șomer", "Agricultură", "Apicultură", "Zootecnie", "Apicultura", "Liber profesioneist", "Muzician",
				"Tâmplar", "Hotelărie", "Comerț", "Operatori de instalații", "Pompier", "Industria prelucrătoare",
				"Industria miniera", "Industria chimică", "Stomatolog", "Măcelar", "Tehnician", "Ajutor in producţie",
				"Brutar", "Bucătar", "Casier", "Chelner", "Coafeză/Frizer", "Croitor", "Electrician", "Grădinar" };
		return nombres[1 + new Random().nextInt(50)];

	}

	/**
	 * Obtiene un nombre final de la lista.
	 * @return nombre al azar
	 */
	public static String nombreFinal() {
		final String[] nombres = { "Andreea", "Elena", "Alexandra", "Denisa", "Ioana", "Gabriela", "Stefania", "Daria",
				"Mihaela", "Gabriela", "Eugenia", "Cristina", "Bianca", "Georgiana", "Nicleta", "Teodora", "Diana",
				"Alexia", "Ionela", "Maria", "Cristina", "Viorica", "Iulia", "Ileana", "Tudora", "Ana", "Florentina",
				"Larisa", "Sara", "Miruna", "Olga", "Olga Maria", "Adela", "Maria Adela", "Roxana", "Rebeca", "Raluca",
				"Gina", "Georgeta", "Sofia", "Natalia", "Irina", "Antonia", "Daciana", "Manuela", "Adelina",
				"Dana Maria", "Andra", "Alina", "Delia", "Maria Isabel" };
		return nombres[1 + new Random().nextInt(50)];

	}

	/**
	 * Obtiene un nombre final de la lista.
	 * @return nombre al azar
	 */
	public static String nombreFinalHombre() {
		final String[] nombres = { "Mihai", "Ion", "Vasile", "Marius Andrei", "Grigore", "Adrian", "Iulian", "Marian",
				"Nicolae", "Gabriel", "Eugen", "Cristi", "Cristian", "Tudor", "Bogdan", "Ionel", "Claudiu", "Ovidiu",
				"Dan", "Marin", "Cristian", "Viorel", "Iulian", "David", "Tudorel", "Darius", "Cornel", "Marius",
				"Dan Andrei", "Tudor Cristial", "Denis", "Robert", "Sebastian", "Luca", "Luis", "David", "Ioan David",
				"Rares", "Anghel", "Nicusor", "Tudor Adrian", "Cosmin" };
		return nombres[1 + new Random().nextInt(50)];

	}

	/**
	 * Obtiene un nombre de calle final de la lista.
	 * @return nombre de calle al azar
	 */
	public static String nombresCalleFinal() {
		final String[] nombresCalle = { "Strada 1 Mai nr 34", "Aleea Barajul Dunarii nr 32", "Aleea Barbatesti nr 121",
				"Intrarea Baritonului", "Soseaua Bucuresti Ploiesti", "Strada Bachus", "Strada Baia Sprie",
				"Aleea Codrii Neamtului", "Bulevardul Camil Ressu", "Bulevardul Corneliu Coposu",
				"Intrarea Caramidariei", "Strada C A Rosetti", "Bulevardul Dimitrie Pompeiu",
				"Bulevardul Dimitrie Cantemir", "Bulevardul Dinicu Golescu", "Aleea Giurgeni", "Drumul Gazarului",
				"Bulevardul Ghica Tei", "Strada Galautas", "Strada Gazelei", "Bulevardul Ion Mihalache",
				"Strada Iacob Andrei", "Strada Iezeru", "Strada Ilioara", "Aleea Piatra Mare", "Bulevardul Poligrafiei",
				"Bulevardul Protopopescu Pache", "Bulevardul Schitu Magureanu", "Aleea Stanciu George Cristian",
				"Intrarea Scorusului", "Intrarea Securii" };
		final String nombreCalle = nombresCalle[1 + new Random().nextInt(29)];
		return nombreCalle.toUpperCase();
	}

	/**
	 * Obtiene un nombre final de la lista.
	 * @return nombre al azar
	 */
	public static String nombreSex() {
		final String[] nombres = { "MAN", "WOMAN", "OTHER", "UNSPECIFIED" };
		return nombres[1 + new Random().nextInt(3)];

	}

	/**
	 * Subtipos de denuncia.
	 */
	public static String nombresMail() {
		final String[] mails = { "@gmail.com", "@hotmail.com", "@yahoo.com" };
		final String mail = mails[1 + new Random().nextInt(2)];
		return mail;

	}

	/**
	 * Obtiene una fecha aleatoria.
	 * @return fecha
	 */
	public static Date obtenerFechaNastere() {
		Calendar fecha;
		Random aleatorio;
		aleatorio = new Random();
		fecha = Calendar.getInstance();
		fecha.set(aleatorio.nextInt(10) + 1969, aleatorio.nextInt(12) + 1, aleatorio.nextInt(30) + 1);
		new SimpleDateFormat("dd/MM/yyyy");
		return fecha.getTime();
	}

	/**
	 * Obtiene una fecha aleatoria.
	 * @return fecha
	 */
	public static Date obtenerFechaRegistru() {
		Calendar fecha;
		Random aleatorio;
		aleatorio = new Random();
		fecha = Calendar.getInstance();
		fecha.set(aleatorio.nextInt(5) + 2014, aleatorio.nextInt(11) + 1, aleatorio.nextInt(30) + 1);
		new SimpleDateFormat("dd/MM/yyyy");
		return fecha.getTime();
	}

	/**
	 * Obtiene una hora aleatoria.
	 * @return hora
	 */
	public static Date obtenerHoraNastere() {
		Calendar hora;
		Random aleatorio;
		aleatorio = new Random();
		hora = Calendar.getInstance();
		hora.set(aleatorio.nextInt(10) + 1969, aleatorio.nextInt(12) + 1, aleatorio.nextInt(30) + 1);
		new SimpleDateFormat("hh/mm");
		return hora.getTime();
	}

	/**
	 * Obtiene una hora aleatoria.
	 * @return hora
	 */
	public static Date obtenerHoraRegistru() {
		Calendar hora;
		Random aleatorio;
		aleatorio = new Random();
		hora = Calendar.getInstance();
		hora.set(aleatorio.nextInt(5) + 2014, aleatorio.nextInt(11) + 1, aleatorio.nextInt(30) + 1);
		new SimpleDateFormat("hh/mm");
		return hora.getTime();
	}

	/**
	 * Obtiene un pais final de la lista.
	 * @return pais al azar
	 */
	public static String paisFinal() {
		final String[] paises = { "ESPAÑA", "ALEMANIA", "RUSIA", "INGLATERA", "ESPAÑA", "ESPAÑA", "INGLATERA", "RUSIA",
				"ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA",
				"ESPAÑA", "ALEMANIA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA", "ESPAÑA" };

		return paises[1 + new Random().nextInt(25)];
	}

	/**
	 * Obtiene una provincia final de la lista.
	 * @return provincia al azar
	 */
	public static Long provinciasFinal() {
		final Long[] provincias = { 10L, 2L, 17L, 3L, 10L, 8L, 10L, 11L, 3L, 6L, 7L, 10L, 10L, 11L, 8L, 5L, 8L, 6L, 9L,
				10L, 1L, 4L, 4L, 1L, 12L, 2L, 13L, 5L, 14L, 15L, 10L, 33L, 34L, 10L, 35L, 36L, 37L, 19L, 38L, 39L, 10L,
				16L, 17L, 18L, 10L, 19L, 20L, 10L, 21L, 22L, 23L, 24L, 10L, 25L, 26L, 27L, 10L, 28L, 29L, 30L, 10L, 32L,
				31L };
		final Long provincia = provincias[1 + new Random().nextInt(59)];
		return provincia;
	}

	/**
	 * Evitamos que se pueda instanciar la clase.
	 */
	private Generador() {
		throw new IllegalAccessError("Generador class");
	}

}
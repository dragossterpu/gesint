package ro.stad.online.gesint.constante;

/**
 * Clase de constantes.
 * @author STAD
 *
 */
public final class Constante {

        /**
         * Pagina Acces.
         */
        public static final String ACCES = "/acces/**";

        /**
         * Pagina index.
         */
        public static final String INDEX = "/index.xhtml";

        /**
         * Constante final text de:.
         */
        public static final String DE = " de: ";

        /**
         * Constante final text operatie.
         */
        public static final String OPERATION = "Operația ";

        /**
         * Constante final text se a realizat cu éxit.
         */
        public static final String SEHAREALEXIT = " a fost făcută cu succes.";

        /**
         * Cuvant "login" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String LOGIN = "login";

        /**
         * Cuvant "nume" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String NUME = "nume";

        /**
         * Cuvant "MAN" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String MAN = "MAN";

        /**
         * Cuvant "WOMAN" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String WOMAN = "WOMAN";

        /**
         * Cuvant "1" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String UNU = "1";

        /**
         * Cuvant "2" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String DOI = "2";

        /**
         * Cuvant "prenume" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String PRENUME = "prenume";

        /**
         * Cuvant "team" pentru a nu-l repeta de n ori în cadrul unei clase.
         */
        public static final String TEAM = "team";

        /**
         * Procesare masiva membrii.
         */
        public static final String PROCESMASIV = "PROCES_MASIV_MEMBRI/ ";

        /**
         * Cuvant (SELECT COUNT(*) FROM utilizator WHERE educatie=.
         */
        public static final String SQLCOUNTEDUCATIE = "(SELECT COUNT(*) FROM utilizator WHERE educatie=";

        /**
         * Cuvant "(SELECT COUNT(*) FROM utilizator WHERE sex="
         */
        public static final String SQLCOUNTSEX = "(SELECT COUNT(*) FROM utilizator WHERE sex=";

        /**
         * Cuvant "(SELECT SUM(locuitori) FROM localitate WHERE nivel"
         */
        public static final String SQLCOUNTNIVEL = "(SELECT SUM(locuitori) FROM localitate WHERE nivel ";

        /**
         * Cuvant "(SELECT COUNT(*) FROM utilizator u, localitate l WHERE u.localitate_id = l.id AND l.nivel "
         */
        public static final String SQLCOUNTNIVELLOC = "(SELECT COUNT(*) FROM utilizator u, localitate l WHERE  u.localitate_id = l.id AND l.nivel ";

        /**
         * Cuvant "(SELECT DISTINCT ROUND((SELECT SUM(populatie)FROM judet)- ((SELECT SUM(populatie)FROM judet)*0.2)) AS
         * locuitori FROM judet ) AS totalVot,"
         */
        public static final String SQLSELECT = "(SELECT DISTINCT ROUND((SELECT SUM(populatie)FROM judet)- ((SELECT SUM(populatie)FROM judet)*0.2)) AS locuitori FROM judet ) AS totalVot,";

        /**
         * Cuvant "' and sex= 'MAN') AS "
         */
        public static final String SQLANDMAN = "' AND sex= 'MAN') AS ";

        /**
         * Cuvant "') AS "
         */
        public static final String SQLAS = "') AS ";

        /**
         * Cuvant SQLSELECTREZULTAT
         */
        public static final String SQLSELECTREZULTAT = " SELECT distinct p.nume,p.sigla,p.id,  SUM(rpj.total_voturi_partid) AS voturiPartid ,SUM(rpj.numar_mandate) AS mandatePartid ,(SELECT sum(total_voturi_partid) FROM partid_rezultat_judet WHERE an_alegeri= ";

        /**
         * Cuvant SQLSUBSELECTREZULTAT
         */
        public static final String SQLSUBSELECTREZULTAT = " )AS totalVoturi, (SELECT sum(numar_mandate) FROM partid_rezultat_judet  WHERE an_alegeri= ";

        /**
         * Url "/login" pentru a nu-l repeta de n ori în cadrul unei clase..
         */
        public static final String LOGINROUTE = "/login";

        /**
         * Cuvantul "dataInregistrari"
         */
        public static final String DATAINREGISTRARII = "dataInregistrari";

        /**
         * utilizator masiv.
         */
        public static final String UTILIZATORIMASIV = "membrii masiv";

        /**
         * Url "/logout" pentru a nu-l repeta de n ori în cadrul unei clase..
         */
        public static final String LOGOUTROUTE = "/logout";

        /**
         * Cuvantul "Căutare" pentru a nu-l repeta de n ori în cadrul unei clase..
         */
        public static final String CAUTAREMENSAJE = "Căutare";

        /**
         * Cuvantul "Încărcarea fișiere" pentru a nu-l repeta de n ori în cadrul unei clase..
         */
        public static final String INCARCAREFISIER = "Încărcarea fișiere";

        /**
         * Fraza "Registrul a fost înregistrat corect" pentru a nu-o repeta de n ori.
         */
        public static final String OKINREGISTRAREMESAJ = "Registrul a fost înregistrat corect.";

        /**
         * Fraza "Registrul a fost eliminat corect." pentru a nu-o repeta de n ori.
         */
        public static final String OKELIMINAREMESAJ = "Registrul a fost eliminat corect.";

        /**
         * Fraza "Registrul a fost modificat corect." pentru a nu-o repeta de n ori.
         */
        public static final String OKMODIFICAREMESAJ = "Registrul a fost modificat corect.";

        /**
         * Identificatorul mesajului global din aplicatie.
         */
        public static final String IDMESAJGLOBAL = "messages";

        /**
         * Cuvantul Judet.
         */
        public static final String JUDETUL = "judetul";

        /**
         * Constante pentru textul session.
         */
        public static final String SESSION = "session";

        /**
         * Constante final false.
         */
        public static final String FALSE = "false";

        /**
         * Constante pentru textul view
         */
        public static final String VIEW = "view";

        /**
         * Șablon pentru încărcare masivă a utilizatorului.
         */
        public static final String SABLONINREGISTRARE = "fisier_inregistrare_masiva_membri.xlsx";

        /**
         * Constante pentru șablonul de resursă de cale constantă (html) cu etichete de pietricele pentru a genera
         * e-mailuri cu imagini.
         */
        public static final String TEMPLATEEMAILBASE = "./static/templates/templateCorreoBase.html";

        /**
         */
        public static final String PROCENTAJ = " %";

        /**
         * Constante ruta recurso imagen firma de comunicaciones del sistema. De schimbat !!!!!
         */
        public static final String IMGSISTEM = "./static/images/escudo_ipss.png";

        /**
         * Constante pentru textul reservat 'and' de sql.De verificat !!!!
         */
        public static final String AND = " and ";

        /**
         * Constante pentru textul reservat 'select' de sql.
         */
        public static final String SELECT = "select ";

        /**
         * Constante pentru identificatorul de utilizator!!!!
         */
        public static final String IDUTILIZATOR = "idUtilizator";

        /**
         * The Constant SMTP.
         */
        public static final String SMTP = "smtp.gmail.com";

        /**
         * The Constant DATECREATE.
         */
        public static final String DATECREATE = "dateCreate";

        /**
         * The Constant PAROLA.
         */
        public static final String PAR = "Parolă";

        /**
         * The Constant SCHIMBDATE.
         */
        public static final String SCHIMBDATE = "Modificare date registru";

        /**
         * The Constant RAWTYPES.
         */
        public static final String RAWTYPES = "rawtypes";

        /**
         * The Constant UNCHECKED.
         */
        public static final String UNCHECKED = "unchecked";

        /**
         * The Constant .
         */
        public static final int TAMPAGINA6 = 6;

        /**
         * The Constant NUMERIC postgresql.
         */
        public static final String NUMERIC = "NUMERIC";

        /**
         * The Constant ROLE_ADMIN.
         */
        public static final String ROLEADMIN = "ROLE_ADMIN";

        /***************************
         * Literales de variables.
         *
         ***************************/

        /**
         * The Constant id.
         */
        public static final String ID = "id";

        /**
         * The Constant DATEDELETED.
         */
        public static final String DATEDELETED = "dateDeleted";

        /**
         * The Constant SPATIU.
         */
        public static final String SPATIU = "";

        /**
         * The Constant Utillizatorul.
         */
        public static final String UTILIZATORUL = "Utillizatorul: ";

        /**
         * The Constant apărut o eroare, încercați din nou mai târziu.
         */
        public static final String DESCEROAREMESAJ = "A apărut o eroare, încercați din nou mai târziu";

        /**
         * The Constant true.
         */
        public static final String TRUE = "true";

        /**
         * The Constant mail.
         */
        public static final String MAIL = "MAIL";

        /**
         * The Constant extensie.
         */
        public static final String EXT = "extensie";

        /**
         * The Constant NUMESECTIUNE.
         */
        public static final String NUMESECTIUNE = "numeSectiune";

        /**
         * The Constant tipRegActivitate.
         */
        public static final String TIPREGACTIVITATE = "tipRegActivitate";

        /**
         * The Constant userCreate.
         */
        public static final String USERCREATE = "userCreate";

        /**
         * The Constant name.
         */
        public static final String NAME = "name";

        /**
         * The Constant username.
         */
        public static final String USERNAME = "username";

        /**
         * The Constant destinatar.
         */
        public static final String DESTINATAR = "destinatar";

        /**
         * The Constant titlu.
         */
        public static final String TITLU = "titlu";

        /**
         * The Constant porcentaje. Totul ok!!!
         */
        public static final String PORCENTAJ = "%";

        /**
         * The Constant dd/MM/yyyy. Totul ok!!!
         */
        public static final String FORMATDATE = "dd/MM/yyyy";

        /**
         * The Constant UNDERSCORE.
         */
        public static final String UNDERSCORE = "_";

        /**
         * The Constant c.
         */
        public static final String CPUNCT = "c.";

        /**
         * The Constant DATEFROM.
         */
        public static final String DATEFROM = "fechadesde";

        /**
         * The Constant DATEUNTIL.
         */
        public static final String DATEUNTIL = "fechahasta";

        /**
         * The Constant deprecation.
         */
        public static final String DEPRECATION = "deprecation";

        /**
         * The Constant PUNCT.
         */
        public static final String PUNCT = ".";

        /**
         * The Constant SYSTEM.
         */
        public static final String SYSTEM = "SYSTEM";

        /**
         * The Constant w.
         */
        public static final String W = "w";

        /**
         * The Constant VIRGULA.
         */
        public static final String VIRGULA = ",";

        /**
         * The Constant localitate.
         */
        public static final String LOCALITATE = "localitate";

        /**
         * The Constant SENDDATE Alerte.
         */
        public static final String SENDDATE = "dataTrimiteri";

        /**
         * The Constant TRIMITEREALERTA.
         */
        public static final String TRIMITEREALERTA = "Trimitere mesaj";

        /**
         * Envío alerta.
         */
        public static final String SPATIUMARE = " ";

        /**
         * Identificador de esteEliminare.
         */
        public static final String ESTEELIMINARE = "esteEliminare";

        /**
         * Constanta pentru cuvantul esteBlocaj.
         */
        public static final String ESTEBLOCAJ = "esteBlocaj";

        /**
         * Constanta pentru o linie.
         */
        public static final String LINIE = "-";

        /**
         * Constanta pentru cuvantul membru.
         */
        public static final String MEMBRUL = "membrul '";

        /**
         * Constanta pentru cuvantul membru.
         */
        public static final String EXISTERORI = "Au existat erori ";

        /**
         * Constanta pentru cuvantul proiecte.
         */
        public static final String PROIECTE = "proiecte";

        /**
         * Constanta pentru cuvantul validat.
         */
        public static final String VALIDAT = "validat";

        /**
         * Constanta pentru cuvantul msgs
         */
        public static final String MSGS = "msgs";

        /**
         * Constanta pentru cuvantul DESTINATAR
         */
        public static final String DESTINATAR_EXTERN = "DESTINATAR EXTERN";

        /**
         * Constanta pentru cuvantul DIALOGCORESPONDENTA
         */
        public static final String DIALOGCORESPONDENTA = "PF('dialogCorespondenta').show();";

        /**
         * Constanta pentru cuvantul DIALOGMESGHIDE
         */
        public static final String DIALOGMESGHIDE = "PF('dialogMessage').hide()";

        /**
         * Constanta pentru cuvantul DIALOGCAUTARE
         */
        public static final String DIALOGCAUTARE = "PF('dialogCautare').show();";

        /**
         * Ruta del logo de calidad.
         */
        public static final String LOGO = "static/images/footer_solicitud_1.png";

        /**
         * Logo del Ministerio del Interior para los documentos generados por la aplicación.
         */
        public static final String LOGOPER = "static/images/logo_per.png";

        /**
         * Logo de IPSS para los documentos generados por la aplicación.
         */
        public static final String LOGOIPSS = "static/images/logo_ipss.png";

        /**
         * Ruta de la imagen que aparece en el header de la solicitud en la página 1 del pdf generado.
         */
        public static final String HEADERSOLDOCPAG1 = "static/images/header_sol_doc_pag_1.png";

        /**
         * Factor de escala para las imágenes de cabecera de los documentos Word y PDF.
         */
        public static final float ESCALA = 0.6f;

        /**
         * Constante para el grupo de datos evaluat de estadísticas.
         */
        public static final String TABMEMBRI = "membriSimpatizanti";

        /**
         * Constante para el grupo de datos evaluat de estadísticas.
         */
        public static final String TABLOCAL = "conducereaLocala";

        /**
         * Constante para el grupo de datos evaluat de estadísticas.
         */
        public static final String TABCONDUCERE = "conducereaCentrala";

        /**
         * Constanta pentru numele organizatiei.
         */
        public static final String CONDUCERELOCALA = "Conducerea Locală";

        /**
         * Constanta pentru numele organizatiei.
         */
        public static final String CONDUCERECENTRALA = "Conducerea Centrală";

        /**
         * Constante ruta recurso plantilla (html) con etiquetas pebble para generar correos electrónicos de
         * recuperación de contraseña.
         */
        public static final String TEMPLATECORREORESTABLECERPAS = "/static/templates/templateRestablecerAcceso.html";

        /**
         * Constanta pentru cuvantul "DESC"
         */

        public static final String DESC = "DESC";

        /**
         * Constanta pentru cuvantul "NO"
         */

        public static final String NO = "NO";

        /**
         * Constanta pentru cuvantul "ASC"
         */

        public static final String ASC = "ASC";

        /**
         * Constanta pentru cuvantul "este mai mare"
         */

        public static final String ESTEMARE = "este mai mare";

        /**
         * Constanta pentru cuvantul "este mai mic"
         */

        public static final String ESTEMIC = "este mai mic";

        /**
         * Constanta pentru cuvantul " --> "
         */

        public static final String SAGEATADREAPTA = " --> ";

        /**
         * Constanta pentru cuvantul ". "
         */

        public static final String PUNCTSPATIU = ". ";

        /**
         * Constanta pentru cuvantul "fill:white;"
         */

        public static final String FILLWHITE = "fill:white;";

        /**
         * Constanta pentru cuvantul "AB"
         */

        public static final String AB = "AB";

        /**
         * Constanta pentru cuvantul "AG"
         */

        public static final String AG = "AG";

        /**
         * Constanta pentru cuvantul "B"
         */

        public static final String B = "B";

        /**
         * Constanta pentru cuvantul "BT"
         */

        public static final String BT = "BT";

        /**
         * Constanta pentru cuvantul "verde"
         */

        public static final String VERDE = "verde";

        /**
         * Constanta pentru cuvantul "galben"
         */

        public static final String GALBEN = "galben";

        /**
         * Constanta pentru cuvantul "fill:red;"
         */

        public static final String FILLRED = "fill:red;";

        /**
         * Constanta pentru cuvantul "fill:yellow;"
         */

        public static final String FILLYELLOW = "fill:yellow;";

        /**
         * Constanta pentru cuvantul "fill:green;"
         */

        public static final String FILLGREEN = "fill:green;";

        /**
         * Constanta pentru cuvantul "rosu"
         */

        public static final String ROSU = "rosu";

        /**
         * Constanta pentru cuvantul "BUN"
         */

        public static final String BUN = "BUN";

        /**
         * Constanta pentru cuvantul "ACCEPTABIL"
         */

        public static final String ACCEPTABIL = "ACCEPTABIL";

        /**
         * Constanta pentru cuvantul "IF"
         */

        public static final String IF = "IF";

        /**
         * Constanta pentru cuvantul "AR"
         */

        public static final String AR = "AR";

        /**
         * Constanta pentru cuvantul "BC"
         */

        public static final String BC = "BC";

        /**
         * Constanta pentru cuvantul "BH"
         */

        public static final String BH = "BH";

        /**
         * Constanta pentru cuvantul "BN"
         */

        public static final String BN = "BN";

        /**
         * Constanta pentru cuvantul "NECONVINGATOR"
         */

        public static final String NECONVINGATOR = "NECONVINGATOR";

        /**
         * Constanta pentru cuvantul "NU"
         */

        public static final String NU = "NU";

        /**
         * Constanta pentru cuvantul "VS"
         */

        public static final String VS = "VS";

        /**
         * Constanta pentru cuvantul "VN"
         */

        public static final String VN = "VN";

        /**
         * Constanta pentru cuvantul "VL"
         */

        public static final String VL = "VL";

        /**
         * Constanta pentru cuvantul "TR"
         */

        public static final String TR = "TR";

        /**
         * Constanta pentru cuvantul "TM"
         */

        public static final String TM = "TM";

        /**
         * Constanta pentru cuvantul Constante.TL
         */

        public static final String TL = "TL";

        /**
         * Constanta pentru cuvantul SV
         */

        public static final String SV = "SV";

        /**
         * Constanta pentru cuvantul SM
         */

        public static final String SM = "SM";

        /**
         * Constanta pentru cuvantul SJ
         */

        public static final String SJ = "SJ";

        /**
         * Constanta pentru cuvantul SB
         */

        public static final String SB = "SB";

        /**
         * Constanta pentru cuvantul PH
         */

        public static final String PH = "PH";

        /**
         * Constanta pentru cuvantul OT
         */

        public static final String OT = "OT";

        /**
         * Constanta pentru cuvantul NT
         */

        public static final String NT = "NT";

        /**
         * Constanta pentru cuvantul MS
         */

        public static final String MS = "MS";

        /**
         * Constanta pentru cuvantul MM
         */

        public static final String MM = "MM";

        /**
         * Constanta pentru cuvantul MH
         */

        public static final String MH = "MH";

        /**
         * Constanta pentru cuvantul IS
         */

        public static final String IS = "IS";

        /**
         * Constanta pentru cuvantul IL
         */

        public static final String IL = "IL";

        /**
         * Constanta pentru cuvantul HR
         */

        public static final String HR = "HR";

        /**
         * Constanta pentru cuvantul HD
         */

        public static final String HD = "HD";

        /**
         * Constanta pentru cuvantul GR
         */

        public static final String GR = "GR";

        /**
         * Constanta pentru cuvantul GL
         */

        public static final String GL = "GL";

        /**
         * Constanta pentru cuvantul GJ
         */

        public static final String GJ = "GJ";

        /**
         * Constanta pentru cuvantul DJ
         */

        public static final String DJ = "DJ";

        /**
         * Constanta pentru cuvantul DB
         */

        public static final String DB = "DB";

        /**
         * Constanta pentru cuvantul CV
         */

        public static final String CV = "CV";

        /**
         * Constanta pentru cuvantul CT
         */

        public static final String CT = "CT";

        /**
         * Constanta pentru cuvantul CS
         */

        public static final String CS = "CS";

        /**
         * Constanta pentru cuvantul CL
         */

        public static final String CL = "CL";

        /**
         * Constanta pentru cuvantul CJ
         */

        public static final String CJ = "CJ";

        /**
         * Constanta pentru cuvantul BV
         */

        public static final String BV = "BV";

        /**
         * Constanta pentru cuvantul BZ
         */

        public static final String BZ = "BZ";

        /**
         * Constanta pentru cuvantul BR
         */

        public static final String BR = "BR";

        /**
         * Constanta pentru cuvantul "/"
         */

        public static final String BARAOBLICADREAPTA = "/";

        /**
         * Constanta pentru cuvantul "dataIncepere"
         */

        public static final String DATAINCEPERE = "dataIncepere";

        /**
         * Constanta pentru cuvantul " AND partid = "
         */

        public static final String ANDPARTIDSQL = " AND partid = ";

        /**
         * Constanta pentru cuvantul " AND id_judet = '"
         */

        public static final String ANDJUDETSQL = " AND id_judet = '";

        /**
         * Constanta pentru cuvantul "'"
         */

        public static final String SPATIUVIRGULASUS = "'";

        /**
         * Constanta pentru cuvantul "' AND DATE '"
         */

        public static final String ANDDATE = "' AND DATE '";

        /**
         * Constanta pentru cuvantul "text sql"
         */

        public static final String SELECTCOUNTUSERBETWENN = "(SELECT COUNT(*)  FROM utilizator WHERE DATE_create BETWEEN DATE '";

        /**
         * Constanta pentru cuvantul "text sql"
         */

        public static final String SELECTCOUNTUSERBIRTDATE = "(SELECT COUNT(*)  FROM utilizator WHERE  data_nasterii BETWEEN DATE '";

        /**
         * Constanta pentru cuvantul "SQLASMANDATE"
         */

        public static final String SQLASMANDATE = " )AS totalMandate  FROM partid_rezultat_judet rpj , partid p WHERE rpj.partid= p.id  AND rpj.an_alegeri= ";

        /**
         * Constanta pentru cuvantul "SQLSELECTSTATJUD"
         */

        public static final String SQLSELECTSTATJUD = " SELECT ss.nume, ss.numero,ss.membrii_minim, ss.populatie,ss.cod_judet, ROUND((ss.numero*100.0)/(ss.membrii_minim),2) AS procentaj , (select ROUND(ss.populatie-(ss.populatie*0.21)) as locuitori) as locuitoriVot FROM ( SELECT COUNT(*) as numero, p.nume, P.cod_judet,p.populatie,p.membrii_minim  FROM utilizator U, judet P WHERE u.cod_judet = p.cod_judet group by u.cod_judet,p.nume,p.populatie ,p.cod_judet,p.membrii_minim  ORDER BY numero ";

        /**
         * Constanta pentru cuvantul "SQLSELECTSTATJUDPRO"
         */

        public static final String SQLSELECTSTATJUDPRO = "SELECT nume,membrii_minim,voturi_minim, numero, populatie, procentaj, cod_judet,locuitoriVot from (SELECT ss.nume,ss.membrii_minim,ss.voturi_minim, ss.cod_judet,ss.numero,ss.populatie,ROUND((ss.numero*100.0)/(ss.membrii_minim),2) AS procentaj, (select ROUND(ss.populatie-(ss.populatie*0.21)) as locuitori) as locuitoriVot FROM ( SELECT COUNT(*) as numero, p.nume, p.populatie,p.cod_judet ,p.membrii_minim,p.voturi_minim FROM utilizator U, judet P WHERE u.cod_judet = p.cod_judet  group by u.cod_judet,p.nume,p.populatie,p.cod_judet,p.membrii_minim,p.voturi_minim  ORDER BY numero ";

        /**
         * Constanta pentru cuvantul "SQLSELECTSTATLOC"
         */

        public static final String SQLSELECTSTATLOC = "SELECT  totalMembrii,numeprovincie, cod_judet,nume,id, sector,  locuitori,membrii_minim,voturi_minim,numero, locuitoriVot,procentaj FROM (select fff.totalMembrii,fff.numeprovincie,fff.cod_judet,fff.nume,fff.id,fff.sector,fff.locuitori,fff.membrii_minim,fff.voturi_minim, fff.numero,fff.locuitoriVot,ROUND((fff.numero*100.0)/(fff.membrii_minim),2) AS procentaj FROM (  SELECT  totalMembrii,numeprovincie, cod_judet,nume,id, sector,  locuitori,membrii_minim,voturi_minim,numero, locuitoriVot FROM ( SELECT (select count(*) from utilizator where cod_judet='";

        /**
         * Constanta pentru cuvantul "SQLSELECTSTATLOCTOTMEM"
         */

        public static final String SQLSELECTSTATLOCTOTMEM = "') as totalMembrii, (select nume from judet where cod_judet='";

        /**
         * Constanta pentru cuvantul "SQLSELECTSTATLOCCODJ"
         */

        public static final String SQLSELECTSTATLOCCODJ = "' as cod_judet,  ss.nume, ss.id, ss.sector, ss.locuitori,ss.membrii_minim,ss.voturi_minim, (select count(*) from utilizator where cod_judet='";

        /**
         * Constanta pentru cuvantul "SQLSELECTSTATLOCNUM"
         */

        public static final String SQLSELECTSTATLOCNUM = "' and localitate_id = ss.id) as numero, ( select ROUND(ss.locuitori-(ss.locuitori*0.21)) as locuitori) as locuitoriVot FROM ( SELECT l.nume,l.id,l.locuitori,l.sector, l.membrii_minim, l.voturi_minim FROM utilizator U, localitate l  WHERE l.cod_judet='";

        /**
         * Constanta pentru cuvantul "SQLSELECTSTATGROUP"
         */

        public static final String SQLSELECTSTATGROUP = " GROUP BY l.id, l.nume, l.locuitori,l.sector , l.membrii_minim, l.voturi_minim ORDER BY voturi_minim desc) as SS) as dd ORDER BY dd.voturi_minim DESC) as fff ) as pp ORDER BY pp.procentaj DESC";

        /**
         * Constanta pentru cuvantul "limit 7 offset 0 "
         */

        public static final String LIMITOFFSET = " limit 7 offset 0 ";

        /**
         * Constanta pentru cuvantul "e"
         */

        public static final String E = "e";

        /**
         * Constanta pentru cuvantul "ne"
         */

        public static final String NE = "ne";

        /**
         * Constanta pentru cuvantul "png"
         */

        public static final String PNG = "png";

        /**
         * Constanta pentru cuvantul "UTF-8"
         */

        public static final String UTF8 = "UTF-8";

        /**
         * Constanta pentru cuvantul "UTF-8"
         */

        public static final String ENCONDING = "encoding";

        /**
         * Constanta pentru cuvantul ".xhtml"
         */

        public static final String XHTML = ".xhtml";

        /**
         * Constanta pentru cuvantul "dd/MM/yyyy HH:mm"
         */

        public static final String FORMATDATAPDF = "dd/MM/yyyy HH:mm";

        /**
         * Constanta pentru cuvantul " ce reprezinta un procentaj de : "
         */

        public static final String TEXTPROCENTAJ = " ce reprezinta un procentaj de : ";

        /**
         * Constanta pentru cuvantul "bean"
         */

        public static final String BEAN = "bean";

        /**
         * Constanta pentru cuvantul "navigareBean"
         */

        public static final String NAVIGAREBEAN = "navigareBean";

        /***********************
         * Anotaciones
         ***********************/

        /**
         * The Constant.
         */
        private Constante() {
                throw new IllegalAccessError("Constante class");
        }
}

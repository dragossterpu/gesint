package ro.per.online.constantes;

/**
 * Clase de constantes.
 * @author STAD
 *
 */
public final class Constantes {

	/**
	 * Constante con valor Administrator
	 */
	public static final String ADMIN = "Administrator";

	/**
	 * Pagina Acceso.
	 */
	public static final String ACCESO = "/acceso/**";

	/**
	 * Pagina index.
	 */
	public static final String INDEX = "/index.xhtml";

	/**
	 * Palabra "login" para no repetirla n veces dentro de una clase.
	 */
	public static final String LOGIN = "login";

	/**
	 * Ruta "/login" para no repetirla n veces dentro de una clase.
	 */
	public static final String RUTALOGIN = "/login";

	/**
	 * Ruta "/logout" para no repetirla n veces dentro de una clase.
	 */
	public static final String RUTALOGOUT = "/logout";

	/**
	 * Palabra "Error" para no repetirla n veces dentro de una clase.
	 */
	public static final String ERRORMENSAJE = "Eroare";

	/**
	 * Constantes para el texto session.
	 */
	public static final String SESSION = "session";

	/**
	 * Constantes para la variable view
	 */
	public static final String VIEW = "view";

	/**
	 * Constante ruta recurso plantilla (html) base con etiquetas pebble para generar correos electrónicos con imágenes.
	 */
	public static final String TEMPLATECORREOBASE = "./static/templates/templateCorreoBase.html";

	/**
	 * Constante ruta recurso imagen firma de comunicaciones del sistema.
	 */
	public static final String IMGSISTEM = "./static/images/escudo_ipss.png";

	/**
	 * Para buscar en bbdd sin tener en cuenta las tildes.
	 */
	public static final String COMPARADORSINACENTOS = "upper(convert(replace(%1$s, \' \', \'\'), \'US7ASCII\')) LIKE upper(convert(\'%%\' || replace(\'%2$s\', \' \', \'\') || \'%%\', \'US7ASCII\'))";

	/**
	 * Altura del gráfico estadístico de totales.
	 */
	public static final Integer ALTURAGRAFICOTOTALES = 110;

	/**
	 * Radio del gráfico estadístico de totales.
	 */
	public static final Integer INTERVALORADIOGRAFICOTOTALES = 100;

	/**
	 * Constante para las estadisticas totales de evaluat.
	 */
	public static final String TOTALEMIEMBROSNUEVOS = "membrii_noi";

	/**
	 * Constante para las estadisticas de usuarios de evaluat.
	 */
	public static final String USUARIOSEVALUAT = "usuarios_evaluat";

	/**
	 * Constante para las estadisticas de evolución de evaluat.
	 */
	public static final String EVOLUCIONEVALUAT = "evolucion_evaluat";

	/**
	 * Constante para las estadísticas de sectores de evaluat.
	 */
	public static final String SECTORESEVALUAT = "sectores_evaluat";

	/**
	 * Constante para las estadísticas de número de trabajadores.
	 */
	public static final String NUMEROTRABAJADORES = "numero_trabajadores_evaluat";

	/**
	 * Constante para las estadísticas de estados de evaluat.
	 */
	public static final String ESTADOSEVALUAT = "estados_evaluat";

	/**
	 * Constante para las estadísticas de la modalidad de prevención de evaluat.
	 */
	public static final String MODALIDADPREVENCIONEVALUAT = "modalidad_prevencion_evaluat";

	/**
	 * Constante para las estadisticas totales de autoprevent.
	 */
	public static final String TOTALESORGANIZATII = "totales_organizatii";

	/**
	 * Constante para las estadisticas de usuarios de autoprevent.
	 */
	public static final String USUARIOSAUTOPREVENT = "usuarios_autoprevent";

	/**
	 * Constante para las estadisticas de evolución de autoprevent.
	 */
	public static final String EVOLUCIONAUTOPREVENT = "evolucion_autoprevent";

	/**
	 * Constante para las estadisticas de usuarios.
	 */
	public static final String TABMIEMBROSNUEVOS = "membrii_noi";

	/**
	 * Constante para las estadísticas de sectores de autoprevent.
	 */
	public static final String SECTORESAUTOPREVENT = "sectores_autoprevent";

	/**
	 * Constante para la palabra reservada 'and' de sql.
	 */
	public static final String AND = " and ";

	/**
	 * Constante para la palabra reservada 'select' de sql.
	 */
	public static final String SELECT = "select ";

	/**
	 * Constante para el grupo de datos evaluat de estadísticas.
	 */
	public static final String TABEVALUAT = "agrupacion_evaluat";

	/**
	 * Constante para el grupo de datos autoprevent de estadísticas.
	 */
	public static final String TABORGANIZATII = "organizatii";

	/**
	 * Limita el número de registros de actividad del usuario en la Home.
	 */
	public static final Integer LIMITEREGISTROSACTIVIDADUSUARIO = 30;

	/**
	 * Constante para el identificador de usuario en tablas que apuntan a la tabla de usuarios.
	 */
	public static final String IDUSUARIO = "idUsuario";

	/**
	 * Constante para el alias usuario.alertChannel.
	 */
	public static final String USUARIOALERTCHANEL = "usuario.alertChannel";

	/**
	 * Constante para el alias alerta.usuario.
	 */
	public static final String ALERTAUSUARIO = "alerta.usuario";

	/**
	 * The Constant STATECREATED.
	 */
	public static final int STATECREATED = 0;

	/**
	 * The Constant SMTP.
	 */
	public static final String SMTP = "smtp.gmail.com";

	/**
	 * The Constant Long uno.
	 */
	public static final Long UNO = 1L;

	/**
	 * The Constant CERTTRUSTOPATH.
	 */
	public static final String CERTTRUSTOPATH = "<JAVA HOME>/jre/lib/security/cacerts";

	/**
	 * The Constant FECHACREACION.
	 */
	public static final String FECHACREACION = "dateCreate";

	/**
	 * The Constant TR.
	 */
	public static final String TR = "</tr>";

	/**
	 * The Constant AROBA.
	 */
	public static final String AROBA = "@";

	/**
	 * The Constant CLAVE.
	 */
	public static final String CLAVE = "Clave";

	/**
	 * The Constant CAMBIODATOS.
	 */
	public static final String CAMBIODATOS = "Cambio datos usuario";

	/**
	 * The Constant ALTA.
	 */
	public static final String ALTA = "Alta";

	/**
	 * The Constant BAJA.
	 */
	public static final String BAJA = "Baja";

	/**
	 * The Constant MODIFICAR.
	 */
	public static final String MODIFICAR = "Modificar";

	/**
	 * The Constant FORMULARIO.
	 */
	public static final String FORMULARIO = "formulario";

	/**
	 * The Constant DISPONIBLES.
	 */
	public static final String DISPONIBLES = "disponibles";

	/**
	 * The Constant ALTADOCUMENTO.
	 */
	public static final String ALTADOCUMENTO = "Alta de documento";

	/**
	 * The Constant ALTADOCUMENTO.
	 */
	public static final String GUARDADOACTIVIDAD = "Guardado de actividad";

	/**
	 * The Constant PREFIFO.
	 */
	public static final String PREFIFO = "+34";

	/**
	 * The Constant PREFIFOCON.
	 */
	public static final String PREFIFOCON = "+0034";

	/**
	 * The Constant RAWTYPES.
	 */
	public static final String RAWTYPES = "rawtypes";

	/**
	 * The Constant UNCHECKED.
	 */
	public static final String UNCHECKED = "unchecked";

	/**
	 * Tamaño de página para los listados.
	 */
	public static final int TAMPAGINA = 15;

	/**
	 * Tamaño de página para los listados.
	 */
	public static final int TAMPAGINA6 = 6;

	/**
	 * Para variables de tipo Numérico en postgresql.
	 */
	public static final String NUMERIC = "NUMERIC";

	/***************************
	 * Literales de variables.
	 *
	 ***************************/

	/**
	 * ID trabajo.
	 */
	public static final String IDTRABAJO = "idTrabajo";

	/**
	 * ID actividad.
	 */
	public static final String IDACTIVIDAD = "idActividad";

	/**
	 * ID tarea.
	 */
	public static final String IDTAREA = "idTarea";

	/**
	 * ID fuente daño.
	 */
	public static final String IDFUENTEDANIO = "idFuenteDanio";

	/**
	 * ID riesgo.
	 */
	public static final String IDRIESGO = "idRiesgo";

	/**
	 * ID medida.
	 */
	public static final String IDMEDIDA = "idMedida";

	/**
	 * Fecha alta.
	 */
	public static final String FECHAALTA = "fechaAlta";

	/**
	 * CATEGORIA.
	 */
	public static final String CATEGORIA = "categoria";

	/**
	 * nifStringAsocia.
	 */
	public static final String NIFASOCIADO = "TRWAGMYFPDXBNJZSQVHLCKET";

	/**
	 * pasarelasmsURL.
	 */
	public static final String PASARELASMSURL = "https://www.prevencion10.es/pasarelasms/sendsmsService";

	/**
	 * logoP10.
	 */
	public static final String LOGOP10 = "https://prevencion10.es/filerepository/fla/scenes/logo.jpg";

	/**
	 * Ruta para el envío de emails.
	 */
	public static final String RUTA = "C:/Users/Admin/Desktop/adrian/SpringMail/src/main/java/com/concretepage/AppConfig.java";

	/**
	 * SECCION.
	 */
	public static final String SECCION = "seccion";

	/**
	 * validado.
	 */
	public static final String VALIDADO = "validado";

	/**
	 * ruta.
	 */
	public static final String RUTAIMG = "https://prevencion10.es/site-web/tformas/cursos_offline/img/fondos/";

	/**
	 * id.
	 */
	public static final String ID = "id";

	/**
	 * nombre.
	 */
	public static final String NOMBRE = "nombre";

	/**
	 * fechaBaja.
	 */
	public static final String FECHABAJA = "fechaBaja";

	/**
	 * tipo.
	 */
	public static final String TIPO = "tipo";

	/**
	 * Espacio.
	 */
	public static final String ESPACIO = "";

	/**
	 * Descripción error mensaje.
	 */
	public static final String DESCERRORMENSAJE = "Se ha producido un error , inténtelo de nuevo más tarde";

	/**
	 * documento.
	 */
	public static final String DOCUMENTO = "documento";

	/**
	 * descripcion.
	 */
	public static final String DESCRIPCION = "descripcion";

	/**
	 * titulo.
	 */
	public static final String TITULO = "titulo";

	/**
	 * prioridad.
	 */
	public static final String PRIORIDAD = "prioridad";

	/**
	 * numorder.
	 */
	public static final String NUMORDER = "numorder";

	/**
	 * apellidos.
	 */
	public static final String APELLIDOS = "apellidos";

	/**
	 * fechaExamen.
	 */
	public static final String FECHAEXAMEN = "fechaExamen";

	/**
	 * dni.
	 */
	public static final String DNI = "dni";

	/**
	 * actividad.
	 */
	public static final String ACTIVIDADDB = "actividaddb";

	/**
	 * actividad base de datos.
	 */
	public static final String ACTIVIDAD = "actividad";

	/**
	 * estado.
	 */
	public static final String ESTADO = "estado";

	/**
	 * workplace.
	 */
	public static final String WORKPLACE = "workplace";

	/**
	 * url.
	 */
	public static final String URL = "url";

	/**
	 * true.
	 */
	public static final String TRUE = "true";

	/**
	 * nombreSeccion.
	 */
	public static final String NOMBRESECCION = "nombreSeccion";

	/**
	 * tipoRegActividad.
	 */
	public static final String TIPOREGACTIVIDAD = "tipoRegActividad";

	/**
	 * usernameRegActividad.
	 */
	public static final String USUREGACTIVIDAD = "usernameRegActividad";

	/**
	 * procesada.
	 */
	public static final String PROCESADA = "procesada";

	/**
	 * name.
	 */
	public static final String NAME = "name";

	/**
	 * username.
	 */
	public static final String USERNAME = "username";

	/**
	 * nif.
	 */
	public static final String NIF = "nif";

	/**
	 * role.
	 */
	public static final String ROLE = "role";

	/**
	 * usuarioasignado.
	 */
	public static final String USUSRIOASIGNADO = "usuarioasignado";

	/**
	 * codigo.
	 */
	public static final String CODIGO = "codigo";

	/**
	 * categoria.id.
	 */
	public static final String CATEGORIAID = "categoria.id";

	/**
	 * link.
	 */
	public static final String LINK = "link";

	/**
	 * Parametro.
	 */
	public static final String PARAMETRO = "parametro";

	/**
	 * destinatario.
	 */
	public static final String DESTINATARIO = "destinatario";

	/**
	 * asunto.
	 */
	public static final String ASUNTO = "asunto";

	/**
	 * newmeasureid.
	 */
	public static final String NEWMEDIDAID = "p_newmeasureid";

	/**
	 * oldmeasureid.
	 */
	public static final String OLDMEDIDAID = "p_oldmeasureid";

	/**
	 * medida.
	 */
	public static final String MEDIDA = "medida";

	/**
	 * prueba.
	 */
	public static final String PRUEBA = "prueba";

	/**
	 * user_test.
	 */
	public static final String USERTEST = "user_test";

	/**
	 * alerta.
	 */
	public static final String ALERTA = "alerta";

	/**
	 * usuario.
	 */
	public static final String USUARIO = "usuario";

	/**
	 * archivo.
	 */
	public static final String ARCHIVO = "archivo";

	/**
	 * info.
	 */
	public static final String INFO = "info";

	/**
	 * actividad.id.
	 */
	public static final String ACTIVIDADID = "actividad.id";

	/**
	 * expediente.
	 */
	public static final String EXPEDIENTE = "expediente";

	/**
	 * empresa.
	 */
	public static final String EMPRESA = "empresa";

	/**
	 * provincia.
	 */
	public static final String PROVICIA = "provincia";

	/**
	 * provincia.id.
	 */
	public static final String PROVICIAID = "provincia.id";

	/**
	 * porcentaje.
	 */
	public static final String PORCENTAJE = "%";

	/**
	 * Borrado.
	 */
	public static final String BORRADO = "Borrado";

	/**
	 * logout.
	 */
	public static final String URLLOGOUT = "/prevencion10_back/logout";

	/**
	 * url base.
	 */
	public static final String URLBASE = "/p10_back_admin";

	/**
	 * dd/MM/yyyy.
	 */
	public static final String FORMFECHA = "dd/MM/yyyy";

	/**
	 * Evaluat.
	 */
	public static final String EVALUAT = "Evaluat";

	/**
	 * Autoprevent.
	 */
	public static final String AUTOPREVENT = "Autoprevent";

	/**
	 * Guardado.
	 */
	public static final String GUARDADO = "Guardado";

	/**
	 * usuarioId.
	 */
	public static final String USUARIOID = "usuarioId";

	/**
	 * guionbajo.
	 */
	public static final String GUIONBAJO = "_";

	/**
	 * Correcta.
	 */
	public static final String CORRECTA = "Correcta";

	/**
	 * video.
	 */
	public static final String VIDEO = "video";

	/**
	 * videosBusqueda.
	 */
	public static final String VIDEOBUS = "videosBusqueda";

	/**
	 * solicitud.
	 */
	public static final String SOLICITUD = "solicitud";

	/**
	 * alerta_test1.
	 */
	public static final String ALERTATEST1 = "alerta_test1";

	/**
	 * alerta_test2.
	 */
	public static final String ALERTATEST2 = "alerta_test2";

	/**
	 * descripcion_test.
	 */
	public static final String DESCRIPCIONTEST = "descripcion_test";

	/**
	 * exception_test.
	 */
	public static final String EXCEPTIONTEST = "exception_test";

	/**
	 * grave error.
	 */
	public static final String ERRORGRAVE = "grave error";

	/**
	 * user.
	 */
	public static final String USER = "user";

	/**
	 * c.
	 */
	public static final String CPUNTO = "c.";

	/**
	 * c.
	 */
	public static final String FPUNTO = "f.";

	/**
	 * fechadesde.
	 */
	public static final String FECHADESDE = "fechadesde";

	/**
	 * fechahasta.
	 */
	public static final String FECHAHASTA = "fechahasta";

	/**
	 * NIE incorrecto.
	 */
	public static final String NIEINCORRECTO = "NIE incorrecto";

	/**
	 * deprecation.
	 */
	public static final String DEPRECATION = "deprecation";

	/**
	 * punto.
	 */
	public static final String PUNTO = ".";

	/**
	 * ID de categoría de Mutuas.
	 */
	public static final Long MUTUAS = 30000240L;

	/**
	 * ID de categoría de Comunidades.
	 */
	public static final Long COMUNIDADES = 30000241L;

	/**
	 * Constante cadena Actividad.
	 */
	public static final String CADENAACTIVIDAD = "ACTIVIDAD";

	/**
	 * Constante cadena Puesto.
	 */
	public static final String CADENAPUESTO = "PUESTO";

	/**
	 * Constante cadena Tarea.
	 */
	public static final String CADENATAREA = "TAREA";

	/**
	 * Constante cadena Fuente de daño.
	 */
	public static final String CADENAFUENTEDANIO = "FUENTEDANIO";

	/**
	 * Constante cadena Riesgo.
	 */
	public static final String CADENARIESGO = "RIESGO";

	/**
	 * Constante cadena Medida.
	 */
	public static final String CADENAMEDIDA = "MEDIDA";

	/**
	 * Simbolo mayor que.
	 */
	public static final String SIMBOLOMAYOR = " > ";

	/**
	 * riesgo.
	 */
	public static final String RIESGO = "riesgo";

	/**
	 * fuente.
	 */
	public static final String FUENTE = "fuente";

	/**
	 * tarea.
	 */
	public static final String TAREA = "tarea";

	/**
	 * puesto.
	 */
	public static final String PUESTO = "puesto";

	/**
	 * SYSTEM.
	 */
	public static final String SYSTEM = "SYSTEM";

	/**
	 * Para la categoria.
	 */
	public static final String PARALACATEGORIA = " para la categoria ";

	/**
	 * Etiqueta de documentos.
	 */
	public static final String ETIQUETADOCUMENTO = "Etiqueta de documentos";

	/**
	 * Categoría de documentos.
	 */
	public static final String CATEGORIADOCUMENTO = "Categoría de documentos";

	/**
	 * Pregunta frecuente.
	 */
	public static final String PREGUNTAFRECUENTE = "Pregunta frecuente";

	/**
	 * Evaluación de examen.
	 */
	public static final String EVALUACIONEXAMEN = "Evaluación de examen";

	/**
	 * Evaluación de examen.
	 */
	public static final String SOLICITUDEXAMEN = "Solicitud de examen";

	/**
	 * Categoría de examen.
	 */
	public static final String CATEGORIAEXAMEN = "Categoría de examen";

	/**
	 * Respuesta de examen.
	 */
	public static final String RESPUESTAEXAMEN = "Respuesta de examen";

	/**
	 * Pregunta de examen.
	 */
	public static final String PREGUNTAEXAMEN = "Pregunta de examen";

	/**
	 * Estadísticas de Instruyet.
	 */
	public static final String ESTADISTICASINSTRUYET = "Estadíticas de Instruyet";

	/**
	 * Estadísticas de Instruyet.
	 */
	public static final String ESTADISTICASEVALUACION = "Estadíticas de evaluaciones";

	/**
	 * DELAPREGUNTAEXAMEN.
	 */
	public static final String DELAPREGUNTAEXAMEN = " de la pregunta de examen ";

	/**
	 * DELARESPUESTAEXAMEN.
	 */
	public static final String DELARESPUESTAEXAMEN = " de la respuesta de examen ";

	/**
	 * DECATEGORIAEXAMEN.
	 */
	public static final String DECATEGORIAEXAMEN = " de categoría de examen ";

	/**
	 * DEGENERACIONEXAMEN.
	 */
	public static final String DEGENERACIONEXAMEN = " de generación de examen ";

	/**
	 * MSGS.
	 */
	public static final String MSGS = "msgs";

	/**
	 * Respuesta modificada.
	 */
	public static final String RESPMODIF = "Respuesta modificada";

	/**
	 * de la pregunta.
	 */
	public static final String DELAPREGUNTA = " de la pregunta ";

	/**
	 * evalua-t.
	 */
	public static final String EVALUATGUION = "evalua-t";

	/**
	 * autoprevent-t.
	 */
	public static final String AUTOPREVENTGUION = "autopreven-t";

	/**
	 * instruye-t.
	 */
	public static final String INSTRUYETGUION = "instruye-t";

	/**
	 * prevencion10.es.
	 */
	public static final String PREVENCION10ES = "Prevencion10.es";

	/**
	 * nombreFichero.
	 */
	public static final String NOMBREFICHERO = "nombreFichero";

	/**
	 * empresa.actividades.
	 */
	public static final String EMPRESAACTIVIDADES = "empresa.actividades";

	/**
	 * workplace.empresa.
	 */
	public static final String WORKPLACEEMPRESA = "workplace.empresa";

	/**
	 * empresa.tipoAplicacion.
	 */
	public static final String EMPRESATIPOAPP = "empresa.tipoAplicacion";

	/**
	 * empresa.usuario.
	 */
	public static final String EMPRESAUSUARIO = "empresa.usuario";

	/**
	 * usuario.nif.
	 */
	public static final String USUARIONIF = "usuario.nif";

	/**
	 * usuario.username.
	 */
	public static final String USUARIOUSERNAME = "usuario.username";

	/**
	 * usuario.provincia.
	 */
	public static final String USUARIOPROVINCIA = "usuario.provincia";

	/**
	 * Eliminar expediente.
	 */
	public static final String ELIMINAREXPEDIENTE = "Eliminar expediente";

	/**
	 * Eliminar puesto.
	 */
	public static final String ELIMINARPUESTO = "Eliminar puesto";

	/**
	 * Eliminar tarea.
	 */
	public static final String ELIMINARTAREA = "Eliminar tarea";

	/**
	 * Eliminar fuente.
	 */
	public static final String ELIMINARFUENTE = "Eliminar fuente";

	/**
	 * Eliminar riesgo.
	 */
	public static final String ELIMINARRIESGO = "Eliminar riesgo";

	/**
	 * Eliminar medida.
	 */
	public static final String ELIMINARMEDIDA = "Eliminar medida";

	/**
	 * Importar subir.
	 */
	public static final String IMPORTARSUBIR = "subir";

	/**
	 * Importar visualizar.
	 */
	public static final String IMPORTARVISUALIZAR = "visualizar";

	/**
	 * Importar Procesar.
	 */
	public static final String IMPORTARPROCESAR = "procesar";

	/**
	 * Importar Confirmación.
	 */
	public static final String IMPORTARPCONFIRMAR = "confirmacion";

	/**
	 * Utilidades.
	 */
	public static final String UTILIDADES = "Utilidades";

	/**
	 * Del parámetro.
	 */
	public static final String DELPARAMETRO = " del parametro ";

	/**
	 * Dossier.
	 */
	public static final String DOSSIER = "dossier";

	/**
	 * Evaluacion.
	 */
	public static final String EVALUACION = "evaluacion";

	/**
	 * Evaluación - workplace.
	 */
	public static final String EVALUACIONWORKPLACE = "evaluacion.workplace";

	/**
	 * application/pdf.
	 */
	public static final String APPPDF = "application/pdf";

	/**
	 * Medidas.
	 */
	public static final String MEDIDAS = "Medidas";

	/**
	 * %s.pdf.
	 */
	public static final String PDF = "%s.pdf";

	/**
	 * Test_.
	 */
	public static final String TEST = "Test_";

	/**
	 * .PDF.
	 */
	public static final String PPDF = ".PDF";

	/**
	 * Puestos.
	 */
	public static final String PUESTOS = "Puestos";

	/**
	 * Riesgos.
	 */
	public static final String RIESGOS = "Riesgos";

	/**
	 * Tareas.
	 */
	public static final String TAREAS = "Tareas";

	/**
	 * InformesEstadisticas.
	 */
	public static final String INFORMEESTADISTICA = "InformesEstadisticas";

	/**
	 * Fuentes de daño.
	 */
	public static final String FUENTES = "Fuentes de daño";

	/**
	 * w.
	 */
	public static final String W = "w";

	/**
	 * GENERALES_.
	 */
	public static final String GENERALES = "GENERALES_";

	/**
	 * code.
	 */
	public static final String CODE = "code";

	/**
	 * contenido.
	 */
	public static final String CONTENIDO = "contenido";

	/**
	 * basededatos.
	 */
	public static final String BASEDATOS = "basededatos";

	/**
	 * generico.
	 */
	public static final String GENERICO = "generico";

	/**
	 * comentarios.
	 */
	public static final String COMENTARIOS = "comentarios";

	/**
	 * soluciones.
	 */
	public static final String SOLUCIONES = "soluciones";

	/**
	 * notas.
	 */
	public static final String NOTAS = "notas";

	/**
	 * notasPlaniticacion.
	 */
	public static final String NOTASPLANIFICACION = "notasPlaniticacion";

	/**
	 * problemas.
	 */
	public static final String PROBLEMAS = "problemas";

	/**
	 * fuentededanio.
	 */
	public static final String FUENTEDANIO = "fuentededanio";

	/**
	 * tipoAplicacion.
	 */
	public static final String TIPOAPP = "tipoAplicacion";

	/**
	 * medidas.
	 */
	public static final String CADMEDIDAS = "medidas";

	/**
	 * riesgos.
	 */
	public static final String CADRIESGOS = "riesgos";

	/**
	 * puestos.
	 */
	public static final String CADPUESTOS = "puestos";

	/**
	 * tareas.
	 */
	public static final String CADTAREAS = "tareas";

	/**
	 * fuentesdedanios.
	 */
	public static final String CADFUENTESDANIO = "fuentesdedanios";

	/**
	 * Descripcion.
	 */
	public static final String CADFDESCRIPCION = "Descripcion";

	/**
	 * Cantidad.
	 */
	public static final String CANTIDAD = "Cantidad";

	/**
	 * goma.
	 */
	public static final String COMA = ",";

	/**
	 * PF('dlg').hide();.
	 */
	public static final String CADENAPFHIDE = "PF('dlg').hide();";

	/**
	 * PF('dlg').show();.
	 */
	public static final String CADENAPFSHOW = "PF('dlg').show();";

	/**
	 * system.
	 */
	public static final String USERSYSTEM = "system";

	/**
	 * Puesto de base de dastos.
	 */
	public static final String PUESTODB = "puestodb";

	/**
	 * Tarea de base de datos.
	 */
	public static final String TAREADB = "tareadb";

	/**
	 * Fuente de daño de base de datos.
	 */
	public static final String FUENTEDANIODB = "fuentededaniodb";

	/**
	 * Riesgo de base de datos.
	 */
	public static final String RIESGODB = "riesgodb";

	/**
	 * Medida de base de datos.
	 */
	public static final String MEDIDADB = "medidadb";

	/**
	 * Fecha envio Alertas.
	 */
	public static final String FECHAENVIO = "fechaEnvio";

	/**
	 * Termino.
	 */
	public static final String TERMINO = "termino";

	/**
	 * Tipo de temrino.
	 */
	public static final String TIPOTERMINO = "type";

	/**
	 * Url de estadistica.
	 */
	public static final String URLESTADISTICA = "/estadisticas/informeEvaluacionesStats?faces-redirect=true";

	/**
	 * Datos evaluate.
	 */
	public static final String DATOSUSUARIOS = "DATOS USUARIOS";

	/**
	 * Datos evaluate.
	 */
	public static final String DATOSINSTRUYET = "DATOS INSTRUYET";

	/**
	 * Datos evaluate.
	 */
	public static final String DATOSEVALUAT = "DATOS EVALUAT";

	/**
	 * Datos autoprevent.
	 */
	public static final String DATOSAUTOPREVENT = "DATOS AUTOPREVENT";

	/**
	 * logo Instituto Examen.
	 */
	public static final String LOGOINSSBT = "/static/images/logoInstitutoExamen.jpg";

	/**
	 * INFORME ESTADÍSTICO PORTAL PREVENCIÓN10.
	 */
	public static final String INFORMEESTAD = "INFORME ESTADÍSTICO PORTAL PREVENCIÓN10";

	/**
	 * de la alerta.
	 */
	public static final String DELAALERTA = " de la alerta ";

	/**
	 * Envío alerta.
	 */
	public static final String ENVIOALERTA = "Envío alerta";

	/**
	 * Envío alerta.
	 */
	public static final String ESPACIOGRANDE = " ";

	/**
	 * Copiar formulario.
	 */
	public static final String COPIARFORM = "Copiar formulario";

	/**
	 * Literal importacion xml.
	 */
	public static final String IMPORTACIONXML = "Importacion xml";

	/**
	 * Pestaña de Instruye-t.
	 */
	public static final String TABREZULTATE = "totales_rezultate";

	/**
	 * incidencia.
	 */
	public static final String INCIDENCIA = "incidencia";

	/**
	 * Usuarios.
	 */
	public static final String USUARIOS = "Usuarios";

	/**
	 * Registrados.
	 */
	public static final String REGISTRADO = "REGISTRADO";

	/**
	 * Invitados.
	 */
	public static final String INVITADO = "INVITADO";

	/**
	 * Nivel uno de categorías de incidencia.
	 */
	public static final Integer CATEGORIAINCIDENCIAPRIMERNIVEL = 1;

	/**
	 * Nivel dos de categorías de incidencia.
	 */
	public static final Integer CATEGORIAINCIDENCIASEGUNDONIVEL = 2;

	/**
	 * Nivel tres de categorías de incidencia.
	 */
	public static final Integer CATEGORIAINCIDENCIATERCERNIVEL = 3;

	/**
	 * Nivel cuatro de categorías de incidencia.
	 */
	public static final Integer CATEGORIAINCIDENCIACUARTONIVEL = 4;

	/**
	 * Identificador de actividad en estadisticas.
	 */
	public static final String CAACTIVIDADID = "ca.actividad_id";

	/**
	 * Identificador de formulario en estadisticas.
	 */
	public static final String SFORMID = "s.form_id";

	/***********************
	 * Anotaciones
	 ***********************/

	/**
	 * The Constant.
	 */
	private Constantes() {
		throw new IllegalAccessError("Constantes class");
	}
}

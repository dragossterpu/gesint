package ro.per.online.services.delegate.estadisticas;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.ModelStats;
import ro.per.online.web.beans.StatsBusqueda;

/**
 * Proveedor de querys para datos de estadísticas.
 * @author STAD
 *
 */
public class QueryDataStatsProvider implements DataStatsProvider {

	/**
	 * Entity manager.
	 */
	private final EntityManager entityManager;

	/**
	 * Constructor de la clase.
	 * @param em EntityManager
	 */
	public QueryDataStatsProvider(final EntityManager em) {
		this.entityManager = em;
	}

	/**
	 * Obtiene el modelo de datos de usuarios.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosUsuarios(final StatsBusqueda statsBusqueda) {
		final List<ModelStats> listaModelo = new ArrayList<>();
		final String queryUsuariosRegistrados = getQueryModeloDatosUsuariosRegistrados(statsBusqueda);
		listaModelo.addAll(getModeloDatosFromQuery(statsBusqueda, queryUsuariosRegistrados));
		return listaModelo;
	}

	/**
	 * Obtiene el modelo de datos de distribución.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDistribucionDatosTotales(final StatsBusqueda statsBusqueda) {
		final String query;

		if (Constantes.REGISTRADO.equals(statsBusqueda.getTipoUsuario()))
			query = getQueryModeloDistribucionDatosTotalesRegistrados(statsBusqueda);
		else
			query = getQueryModeloDistribucionDatosTotalesInvitados(statsBusqueda);

		return getModeloDatosFromQuery(statsBusqueda, query);
	}

	/**
	 * Obtiene el modelo de datos de evolución.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosEvolucion(final StatsBusqueda statsBusqueda) {
		final String query;

		if (Constantes.REGISTRADO.equals(statsBusqueda.getTipoUsuario())) {
			query = getQueryModeloDatosEvolucionRegistrados(statsBusqueda);
		}
		else {
			query = getQueryModeloDatosEvolucionInvitados(statsBusqueda);
		}

		return getModeloDatosFromQuery(statsBusqueda, query);
	}

	/**
	 * Obtiene el modelo de datos de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosSectores(final StatsBusqueda statsBusqueda) {
		String query;
		query = getQueryModeloDatosSectores(statsBusqueda);
		return getModeloDatosFromQuery(statsBusqueda, query);
	}

	/**
	 * Obtiene el modelo de datos de estados.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosEstados(final StatsBusqueda statsBusqueda) {
		String query;

		if (Constantes.REGISTRADO.equals(statsBusqueda.getTipoUsuario())) {
			query = getQueryModeloDatosEstados(statsBusqueda);
		}
		else {
			query = getQueryModeloDatosEstadosInvitados(statsBusqueda);
		}

		return getModeloDatosFromQuery(statsBusqueda, query);
	}

	/**
	 * Obtiene el modelo de datos del número de trabajadores de los formularios de evaluat.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosNumeroTrabajadores(final StatsBusqueda statsBusqueda) {
		String query;

		if ("REGISTRADO".equals(statsBusqueda.getTipoUsuario())) {
			query = getQueryModeloDatosNumeroTrabajadores(statsBusqueda);
		}
		else {
			query = getQueryModeloDatosNumeroTrabajadoresInvitados(statsBusqueda);
		}

		return getModeloDatosFromQuery(statsBusqueda, query);
	}

	/**
	 * Obtiene el modelo de datos de modalidad de prevención.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosModalidadPrevencion(final StatsBusqueda statsBusqueda) {
		final String query = getQueryModeloDatosModalidadPrevencion(statsBusqueda);

		return getModeloDatosFromQuery(statsBusqueda, query);
	}

	/**
	 * Obtiene el modelo de datos de las inscripciones al curso instruyet.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDistribucionInscripciones(final StatsBusqueda statsBusqueda) {
		final String query = getQueryModeloDatosDistribucionInscripciones(statsBusqueda);

		return getModeloDatosFromQuery(statsBusqueda, query);
	}

	/**
	 * Método para establecer sobre una query las condiciones de fecha.
	 * 
	 * @param statsBusqueda StatsBusqueda
	 * @param query StringBuilder
	 * @param alias String
	 */
	private void setQueryCondicionesFecha(final StatsBusqueda statsBusqueda, final StringBuilder query,
			final String alias) {

		if (statsBusqueda.getFechaDesde() != null) {
			query.append(Constantes.AND).append(" date(").append(alias).append("created_on) >= :fechadesde");
		}
		if (statsBusqueda.getFechaHasta() != null) {
			query.append(Constantes.AND).append(" date(").append(alias).append("created_on) <= :fechahasta");
		}
	}

	/**
	 * Obtiene la mascara de la fecha dependiendo de la agrupación.
	 * 
	 * @param statsBusqueda StatsBusqueda
	 * @param alias String
	 * @return String
	 */
	private String getMascaraFecha(final StatsBusqueda statsBusqueda, String alias) {
		String agrupacionFecha = "cast(extract(year from " + alias + "created_on) as integer)";

		if (statsBusqueda.getTipoAgrupacion().equals("mes")) {
			agrupacionFecha = "to_char(" + alias + "created_on, 'YYYY/MM')";
		}
		if (statsBusqueda.getTipoAgrupacion().equals("dia")) {
			agrupacionFecha = "date(" + alias + "created_on)";
		}

		return agrupacionFecha;
	}

	/**
	 * Obtiene el modelo de datos a partir de una query y los criterios de búsqueda.
	 * 
	 * @param statsBusqueda StatsBusqueda
	 * @param query String
	 * @return List<ModelStats>
	 */
	private List<ModelStats> getModeloDatosFromQuery(final StatsBusqueda statsBusqueda, final String query) {
		List<ModelStats> listaModelo = new ArrayList<>();
		final Query queryObject = this.entityManager.createNativeQuery(query);
		introducirParametros(queryObject, statsBusqueda);

		@SuppressWarnings(Constantes.UNCHECKED)
		final List<Object[]> listaResultado = queryObject.getResultList();
		ModelStats modelo;
		for (final Object[] fila : listaResultado) {
			modelo = new ModelStats();
			modelo.setDescripcion(fila[0].toString());
			modelo.setCantidad(Long.parseLong(fila[1].toString()));

			listaModelo.add(modelo);
		}

		return listaModelo;
	}

	/**
	 * Introduce los parámetros sobre un objeto de tipo Query.
	 * @param queryObject Query
	 * @param statsBusqueda StatsBusqueda
	 */
	private void introducirParametros(final Query queryObject, final StatsBusqueda statsBusqueda) {
		if (statsBusqueda.getFechaDesde() != null) {
			queryObject.setParameter(Constantes.FECHADESDE, statsBusqueda.getFechaDesde(), TemporalType.DATE);
		}
		if (statsBusqueda.getFechaHasta() != null) {
			queryObject.setParameter(Constantes.FECHAHASTA, statsBusqueda.getFechaHasta(), TemporalType.DATE);
		}
	}

	/**
	 * Obtiene el modelo de datos totales.
	 * @param statsBusqueda StatsBusqueda
	 * @return ModelStats
	 */
	@Override
	public ModelStats getModeloDatosTotales(final StatsBusqueda statsBusqueda) {
		final ModelStats modelo = new ModelStats();
		final Long totalRegistrados = getModeloDatosTotalesUsuariosRegistrados(statsBusqueda);

		modelo.setCantidad(totalRegistrados);
		modelo.setDescripcion("Expedientes");

		return modelo;
	}

	/**
	 * Obtiene el modelo de datos totales de usuarios registrados.
	 * @param statsBusqueda StatsBusqueda
	 * @return Long
	 */
	private Long getModeloDatosTotalesUsuariosRegistrados(final StatsBusqueda statsBusqueda) {
		Long total;

		final String query = getQueryModeloDatosTotales(statsBusqueda);

		final Query queryObject = entityManager.createNativeQuery(query);
		introducirParametros(queryObject, statsBusqueda);

		@SuppressWarnings(Constantes.UNCHECKED)
		final List<BigInteger> resultado = queryObject.getResultList();

		total = Long.parseLong(resultado.get(0).toString());

		return total;
	}

	/**
	 * Obtiene la consulta de la distribución de invitados totales.
	 * 
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDistribucionDatosTotalesInvitados(StatsBusqueda statsBusqueda) {
		String agrupacionFecha = getMascaraFecha(statsBusqueda, "s.");

		final StringBuilder query = new StringBuilder(Constantes.SELECT);
		query.append(agrupacionFecha).append(" as fecha, count(*) as total from st_stats s where s.deleted_on is null");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.ESPACIO);
		query.append(" group by 1 order by 1");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de distribución de datos totales.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDistribucionDatosTotalesRegistrados(final StatsBusqueda statsBusqueda) {
		String agrupacionFecha = getMascaraFecha(statsBusqueda, "c.");

		final StringBuilder query = new StringBuilder(Constantes.SELECT);
		query.append(agrupacionFecha)
				.append(" as fecha, count(*) as total from st_company c where c.deleted_on is null");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.ESPACIO);
		query.append(" group by 1 order by 1");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de datos totales.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosTotales(final StatsBusqueda statsBusqueda) {
		StringBuilder query = new StringBuilder(
				"select count(distinct c.id) as total from st_company c, company_actividad ca where c.id = ca.company_id and c.deleted_on is null");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.ESPACIO);
		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de distribución de datos de usuarios registrados.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosUsuariosRegistrados(final StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder(
				"select cast('Usuarios' as text), count(*) from users where deleted_on is null");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.ESPACIO);

		return query.toString();
	}

	/**
	 * Obtiene el modelo de datos de la evolución de las estadísticas.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosEvolucionRegistrados(final StatsBusqueda statsBusqueda) {
		StringBuilder query = new StringBuilder(Constantes.SELECT);

		String mascaraFecha = getMascaraFecha(statsBusqueda, "c.");

		final StringBuilder agrupacionFecha = new StringBuilder(Constantes.ESPACIO);
		agrupacionFecha.append(mascaraFecha).append(", cast(sum(count(*)) OVER (ORDER BY ").append(mascaraFecha)
				.append(") as Integer) ");

		query.append(agrupacionFecha)
				.append(" from st_company c, company_actividad ca where c.id = ca.company_id and deleted_on is null ");
		setQueryCondicionesFecha(statsBusqueda, query, Constantes.ESPACIO);

		query.append(" group by 1");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de datos de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosSectores(final StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder(
				"select name_text as descripcion,count(*) as cantidad from st_form f, (select distinct c.id, fi.evaluationform_id from st_company c, company_actividad ca, st_workplace w, st_evaluation e, st_forminstance fi  where c.id = ca.company_id and c.id = w.company_id and w.id = workplace_id and e.id = fi.evaluation_id and c.deleted_on is null ");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.CPUNTO);
		query.append(")a where f.id = a.evaluationform_id ");
		query.append("group by name_text order by 2 desc");
		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de datos de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosCategoriasSectores(final StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder(
				"select category_text as descripcion,count(*) as cantidad from st_form f, (select distinct c.id, fi.evaluationform_id from st_company c, company_actividad ca, st_workplace w, st_evaluation e, st_forminstance fi  where c.id = ca.company_id and c.id = w.company_id and w.id = workplace_id and e.id = fi.evaluation_id and c.deleted_on is null ");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.CPUNTO);
		query.append(")a where f.id = a.evaluationform_id and f.category_text is not null ");
		query.append("group by category_text order by 2 desc");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de datos de modalidad de prevención.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosModalidadPrevencion(final StatsBusqueda statsBusqueda) {
		StringBuilder query = new StringBuilder(
				"select case when metodo_prevencion = 'ASUMIDA' then 'Asumida por el empresario' "
						+ "when metodo_prevencion = 'TRADESIGNADO' then 'Trabajador designado' else 'Desconocido' END, cantidad "
						+ "FROM (select metodo_prevencion, count(*) as cantidad "
						+ "from st_company c, company_actividad ca, users u where "
						+ "u.id = c.user_id and c.id = ca.company_id and u.usuarioinvitado = false and c.deleted_on is null ");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.CPUNTO);
		query.append(" group by metodo_prevencion) a");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de datos de estados.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosNumeroTrabajadores(final StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder(
				"select workernumber numeroTrabajadores, count(*) Expedientes from st_company c, company_actividad ca "
						+ "where c.id = ca.company_id and app_type = 10 and deleted_on is null and workernumber < 26 and workernumber > 0 ");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.CPUNTO);
		query.append(" group by workernumber order by 1 asc");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de datos de distribución de inscripciones.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosDistribucionInscripciones(final StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder(Constantes.SELECT);

		String mascaraFecha = " to_char(created_on, 'YYYY') ";
		if (statsBusqueda.getTipoAgrupacion().equals("mes")) {
			mascaraFecha = " to_char(created_on, 'YYYY/MM') ";
		}
		else if (statsBusqueda.getTipoAgrupacion().equals("dia")) {
			mascaraFecha = " date(created_on) ";
		}

		final StringBuilder agrupacionFecha = new StringBuilder(Constantes.ESPACIO);
		agrupacionFecha.append(mascaraFecha).append(", count(*) as total ");

		query.append(agrupacionFecha).append(" from st_course_enrol c where deleted_on is null ");
		setQueryCondicionesFecha(statsBusqueda, query, Constantes.ESPACIO);
		query.append(" group by 1 order by 1");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del modelo de datos de estados.
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosEstados(final StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder("select CASE WHEN estado = 0 THEN 'CREADO' "
				+ " WHEN estado = 1 THEN 'PENDIENTE EVALUACION' " + " WHEN estado = 2 THEN 'PLANIFICADO' "
				+ " WHEN estado = 3 THEN 'SEGUIMIENTO' " + " WHEN estado = 4 THEN 'FINALIZADO' "
				+ " WHEN estado = 5 THEN 'CANCELADO'      " + " WHEN estado = 6 THEN 'ARCHIVADO'      "
				+ " WHEN estado = 10 THEN 'EVALUADO'      " + " WHEN estado = 11 THEN 'NO EVALUADO'      "
				+ " WHEN estado = 12 THEN 'CON RIESGOS'      " + " WHEN estado = 13 THEN 'SIN RIESGOS'      "
				+ " WHEN estado = 14 THEN 'BORRADO'              " + " END, "
				+ " count(*), estado from (select distinct c.id, max(e.state) estado "
				+ " from users u, st_company c, company_actividad ca, st_workplace w, st_evaluation e "
				+ " where u.ID = C.user_id and c.id = ca.company_id and c.id = w.company_id "
				+ " and w.id = e.workplace_id and c.deleted_on is null   " + " and u.usuarioinvitado = false ");

		setQueryCondicionesFecha(statsBusqueda, query, Constantes.CPUNTO);
		query.append(" group by c.id)a group by 1,3 order by 2 desc");

		return query.toString();
	}

	/**
	 * Obtiene la consulta de estados de los usuarios invitados.
	 * 
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosEstadosInvitados(StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder("select CASE WHEN estado = 0 THEN 'CREADO' "
				+ " WHEN estado = 1 THEN 'PENDIENTE EVALUACION' " + " WHEN estado = 2 THEN 'PLANIFICADO' "
				+ " WHEN estado = 3 THEN 'SEGUIMIENTO' " + " WHEN estado = 4 THEN 'FINALIZADO' "
				+ " WHEN estado = 5 THEN 'CANCELADO'      " + " WHEN estado = 6 THEN 'ARCHIVADO'      "
				+ " WHEN estado = 10 THEN 'EVALUADO'      " + " WHEN estado = 11 THEN 'NO EVALUADO'      "
				+ " WHEN estado = 12 THEN 'CON RIESGOS'      " + " WHEN estado = 13 THEN 'SIN RIESGOS'      "
				+ " WHEN estado = 14 THEN 'BORRADO'              " + " END, "
				+ " count(*), estado from (select estado_evaluacion estado "
				+ " from st_stats s where estado_evaluacion is not null ");

		setQueryCondicionesFecha(statsBusqueda, query, "s.");
		query.append(" )a group by 1,3 order by 2 desc");

		return query.toString();
	}

	/**
	 * Obtiene la consulta del número de trabajadores de las evaluaciones de los usuarios invitados.
	 * 
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosNumeroTrabajadoresInvitados(StatsBusqueda statsBusqueda) {
		final StringBuilder query = new StringBuilder(
				"select numero_trabajadores numeroTrabajadores, count(*) Expedientes from st_stats s where deleted_on is null and numero_trabajadores is not null and numero_trabajadores < 26 and numero_trabajadores > 0 ");

		setQueryCondicionesFecha(statsBusqueda, query, "s.");
		query.append(" group by numero_trabajadores order by 1 asc");

		return query.toString();
	}

	/**
	 * Obtiene la consulta de la evolución de usuarios invitados.
	 * 
	 * @param statsBusqueda StatsBusqueda
	 * @return String
	 */
	private String getQueryModeloDatosEvolucionInvitados(StatsBusqueda statsBusqueda) {
		String mascaraFecha = getMascaraFecha(statsBusqueda, "s.");

		StringBuilder query = new StringBuilder(Constantes.SELECT);
		final StringBuilder agrupacionFecha = new StringBuilder(Constantes.ESPACIO);
		agrupacionFecha.append(mascaraFecha).append(", cast(sum(count(*)) OVER (ORDER BY ").append(mascaraFecha)
				.append(") as Integer) ");

		query.append(agrupacionFecha)
				.append(" from st_stats s, st_form f where s.form_id = f.id and s.deleted_on is null ");
		setQueryCondicionesFecha(statsBusqueda, query, "s.");
		query.append(" group by 1");

		return query.toString();
	}

	/**
	 * Obtiene el modelo de datos de las distintas categorias de sectores.
	 * @param statsBusqueda StatsBusqueda
	 * @return List<ModelStats>
	 */
	@Override
	public List<ModelStats> getModeloDatosCategoriasSectores(StatsBusqueda statsBusqueda) {
		String query;
		query = getQueryModeloDatosCategoriasSectores(statsBusqueda);
		return getModeloDatosFromQuery(statsBusqueda, query);
	}

}

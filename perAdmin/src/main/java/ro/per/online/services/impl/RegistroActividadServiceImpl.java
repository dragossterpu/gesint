package ro.per.online.services.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;

import lombok.NoArgsConstructor;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.RegistroActividad;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.RegistroEnum;
import ro.per.online.persistence.entities.enums.SeccionesEnum;
import ro.per.online.persistence.repositories.RegistroActividadRepository;
import ro.per.online.services.RegistroActividadService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.Utilities;
import ro.per.online.util.UtilitiesCriteria;
import ro.per.online.web.beans.RegistroBusqueda;

/**
 * Implementarea serviciului de înregistrare a activității.
 * @author STAD
 */

@NoArgsConstructor
@Service("registroActividadService")
public class RegistroActividadServiceImpl implements RegistroActividadService, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Session.
	 */
	private Session session;

	/**
	 * Repositorio de registro de actividad.
	 */
	@Autowired
	private transient RegistroActividadRepository regActividadRepository;

	/**
	 * Factoría de sesiones.
	 */
	@Autowired
	private transient SessionFactory sessionFactory;

	/**
	 * Constructor usado para el test.
	 *
	 * @param sessionFact Factoría de sesiones
	 */
	public RegistroActividadServiceImpl(final SessionFactory sessionFact) {
		sessionFactory = sessionFact;
	}

	/**
	 * Metodo que da de alta un registro de actividad.
	 * @param seccion String
	 * @param tipoReg String
	 * @param descripcion String
	 * @param usuario User
	 */
	private void altaRegActividad(final String descripcion, final String tipoReg, final String seccion,
			final Users usuario) {
		try {
			final RegistroActividad registroActividad = new RegistroActividad();
			registroActividad.setTipoRegActividad(Enum.valueOf(RegistroEnum.class, tipoReg));
			establecerUsuarioRegistro(registroActividad, usuario);
			registroActividad.setFechaAlta(new Date());
			registroActividad.setNombreSeccion(Enum.valueOf(SeccionesEnum.class, seccion));
			registroActividad.setDescripcion(descripcion);
			regActividadRepository.save(registroActividad);
		}
		catch (final DataAccessException e) {
			guardarRegistroError(seccion, "RegistroActividadServiceImpl", e);
		}

	}

	/**
	 * Busca registros por usuario.
	 * @param infoUsuario String
	 * @return List<String>
	 */
	@Override
	public List<String> buscarPorUsuarioRegistro(final String infoUsuario) {
		return regActividadRepository.buscarPorUsuarioRegistro("%" + infoUsuario + "%");
	}

	/**
	 * Busca registro de actividad por criteria.
	 * @param first int
	 * @param pageSize int
	 * @param sortField String
	 * @param sortOrder SortOrder
	 * @param regBusqueda RegistroBusqueda
	 * @return List<RegistroActividad>
	 */
	@Override
	public List<RegistroActividad> buscarRegActividadCriteria(final int first, final int pageSize,
			final String sortField, final SortOrder sortOrder, final RegistroBusqueda regBusqueda) {
		try {
			session = sessionFactory.openSession();
			final Criteria criteria = session.createCriteria(RegistroActividad.class);
			creaCriteria(regBusqueda, criteria);

			criteria.setFirstResult(first);
			criteria.setMaxResults(pageSize);

			if ((sortField != null) && sortOrder.equals(SortOrder.ASCENDING)) {
				criteria.addOrder(Order.asc(sortField));
			}
			else if ((sortField != null) && sortOrder.equals(SortOrder.DESCENDING)) {
				criteria.addOrder(Order.desc(sortField));
			}
			else if (sortField == null) {
				criteria.addOrder(Order.asc(Constantes.FECHAALTA));
			}

			@SuppressWarnings(Constantes.UNCHECKED)
			final List<RegistroActividad> listaRegistros = criteria.list();

			return listaRegistros;
		}
		finally {
			if (session != null) {
				try {
					session.close();
				}
				catch (final DataAccessException e) {
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
							Constantes.DESCERRORMENSAJE);
				}
			}
		}

	}

	/**
	 * Consulta criteria para la búsqueda del registro de actividad.
	 *
	 * @param criteria consulta criteria
	 * @param registroBusqueda Objeto que contiene los parámetros de búsqueda
	 */
	private void creaCriteria(final RegistroBusqueda registroBusqueda, final Criteria criteria) {

		UtilitiesCriteria.setCondicionCriteriaFechaMayor(registroBusqueda.getFechaDesde(), criteria,
				Constantes.FECHAALTA);
		UtilitiesCriteria.setCondicionCriteriaFechaMenorIgual(registroBusqueda.getFechaHasta(), criteria,
				Constantes.FECHAALTA);
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(registroBusqueda.getNombreSeccion(), criteria,
				Constantes.NOMBRESECCION);
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(registroBusqueda.getTipoRegActividad(), criteria,
				Constantes.TIPOREGACTIVIDAD);
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(registroBusqueda.getUsernameRegActividad(), criteria,
				Constantes.USUREGACTIVIDAD);
		UtilitiesCriteria.setCondicionCriteriaIgualdadLong(registroBusqueda.getIdUsuario(), criteria,
				Constantes.IDUSUARIO);
	}

	/**
	 * Establece el usuario de un registro de actividad.
	 * @param registroActividad RegistroActividad
	 * @param usuarioRegistro User
	 */
	private void establecerUsuarioRegistro(final RegistroActividad registroActividad, final Users usuarioRegistro) {

		if (usuarioRegistro == null) {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				final Users usuario = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				registroActividad.setUsernameRegActividad(usuario.getUsername());
				registroActividad.setUsername(usuario.getUsername());
			}
			else {
				registroActividad.setUsernameRegActividad(Constantes.USERSYSTEM);
			}
		}
		else {
			registroActividad.setUsernameRegActividad(usuarioRegistro.getUsername());
			registroActividad.setUsername(usuarioRegistro.getUsername());
		}

	}

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda RegistroBusqueda
	 * @return int
	 */
	@Override
	public int getCounCriteria(final RegistroBusqueda busqueda) {
		try {
			session = sessionFactory.openSession();
			final Criteria criteria = session.createCriteria(RegistroActividad.class);
			creaCriteria(busqueda, criteria);
			criteria.setProjection(Projections.rowCount());
			final Long cnt = (Long) criteria.uniqueResult();

			return Math.toIntExact(cnt);
		}
		finally {
			if (session != null) {
				try {
					session.close();
				}
				catch (final DataAccessException e) {
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
							Constantes.DESCERRORMENSAJE);
				}
			}
		}

	}

	/**
	 * Guarda un registro de actividad de tipo alta o modificación.
	 * @param idObjeto Long
	 * @param descripcion String
	 * @param ambito String
	 * @param objeto String
	 * @param borrado boolean
	 */

	private void guardarRegistro(final Long idObjeto, final String descripcion, final String ambito,
			final String objeto, final boolean borrado) {
		final RegistroEnum operacion = Utilities.procesarOperacion(idObjeto, borrado);

		final StringBuilder descripcionReg = new StringBuilder(operacion.toString());
		descripcionReg.append(objeto);
		if (!operacion.equals(RegistroEnum.ALTA)) {
			descripcionReg.append(idObjeto);
		}
		descripcionReg.append(" (" + descripcion + ") ha terminado con éxito.");
		altaRegActividad(descripcionReg.toString(), operacion.name(), ambito, null);
	}

	/**
	 * Guarda un registro de borrado del objeto.
	 * @param idObjeto Long
	 * @param descripcion String
	 * @param ambito String
	 * @param objeto String
	 */
	@Override
	public void guardarRegistroAltaModificacion(final Long idObjeto, final String descripcion, final String ambito,
			final String objeto) {
		guardarRegistro(idObjeto, descripcion, ambito, objeto, false);
	}

	/**
	 * Guarda un registro de borrado del objeto.
	 * @param idObjeto Long
	 * @param descripcion String
	 * @param ambito String
	 * @param objeto String
	 */
	@Override
	public void guardarRegistroBorrado(final Long idObjeto, final String descripcion, final String ambito,
			final String objeto) {
		guardarRegistro(idObjeto, descripcion, ambito, objeto, true);
	}

	/**
	 * Guarda un registro de actividad de tipo error.
	 * @param ambito String
	 * @param objeto String
	 * @param e Exception
	 */
	@Override
	public void guardarRegistroError(final String ambito, final String objeto, final Exception e) {
		altaRegActividad(Throwables.getStackTraceAsString(e) + "/" + objeto, RegistroEnum.ERROR.name(), ambito, null);
	}

	/**
	 * Guarda en base de datos un registro de login del usuario indicado.
	 * @param usuario User
	 */
	@Override
	public void guardarRegistroLoginCorrecto(final Users usuario) {
		altaRegActividad("Login del usuario: " + usuario.getUsername(), RegistroEnum.ALTA.name(),
				SeccionesEnum.LOGIN.name(), usuario);
	}

	/**
	 * Guarda en base de datos un registro de login erroneo del usuario indicado.
	 * @param usuario String
	 */
	@Override
	public void guardarRegistroLoginErroneo(final String usuario) {
		altaRegActividad("Login del usuario erroneo: " + usuario, RegistroEnum.ERROR.name(), "LOGIN", null);
	}

	/**
	 * Guarda un registro de actividad.
	 * @param entity RegistroActividad
	 */
	@Override
	public void save(final RegistroActividad entity) {
		regActividadRepository.save(entity);
	}

}

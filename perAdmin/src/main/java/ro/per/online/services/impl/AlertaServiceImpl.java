package ro.per.online.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.primefaces.model.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.AlertChannelEnum;
import ro.per.online.persistence.repositories.AlertaRepository;
import ro.per.online.services.AlertaService;
import ro.per.online.util.CorreoElectronico;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.UtilitiesCriteria;
import ro.per.online.web.beans.AlertaBusqueda;

/**
 * Implementarea metodelor definite în interfața AlertaService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
public class AlertaServiceImpl implements AlertaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Session de criteria.
	 */
	@Autowired
	private transient SessionFactory sessionFactory;

	/**
	 * Repository de alertas.
	 */
	@Autowired
	private transient AlertaRepository alertaRepository;

	/**
	 * Clase para el envío de mails.
	 */
	@Autowired
	private transient CorreoElectronico mailAlertaSender;

	/**
	 * Session.
	 */
	private Session session;

	/**
	 * Constructor usado para el test.
	 *
	 * @param sessionFact Factoría de sesiones
	 */
	public AlertaServiceImpl(final SessionFactory sessionFact) {
		sessionFactory = sessionFact;
	}

	/**
	 * Busca alertas con los parametros de búsqueda.
	 * @param alertaBusqueda AlertaBusqueda
	 * @param sortOrder SortOrder
	 * @param sortField String
	 * @param pageSize int
	 * @param first int
	 * @return List<Alerta>
	 */
	@Override
	public List<Alerta> buscarAlertaCriteria(final int first, final int pageSize, final String sortField,
			final SortOrder sortOrder, final AlertaBusqueda alertaBusqueda) {
		try {
			session = sessionFactory.openSession();
			final Criteria criteria = session.createCriteria(Alerta.class, Constantes.ALERTA);
			creaCriteria(alertaBusqueda, criteria);
			criteria.setFirstResult(first);
			criteria.setMaxResults(pageSize);
			if (sortField != null) {
				if (sortOrder.equals(SortOrder.ASCENDING)) {
					criteria.addOrder(Order.asc(sortField));
				}
				else if (sortOrder.equals(SortOrder.DESCENDING)) {
					criteria.addOrder(Order.desc(sortField));
				}
			}
			else {
				criteria.addOrder(Order.desc(Constantes.FECHACREACION));
			}
			@SuppressWarnings(Constantes.UNCHECKED)
			final List<Alerta> alertasList = criteria.list();

			return alertasList;
		}
		finally {
			if ((session != null) && session.isOpen()) {
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
	 * Devuelve el listado de alertas de un usuario en concreto.
	 * @param usuarioModificando User
	 * @return List<Alerta>
	 */
	@Override
	public List<Alerta> buscarAlertasPorUsuario(final Users usuarioModificando) {
		return alertaRepository.findAllByDestinatarioOrUsuario(usuarioModificando.getUsername(), usuarioModificando);
	}

	/**
	 * Consulta criteria para la búsqueda de alertas.
	 *
	 * @param criteria consulta criteria
	 * @param alertaBusqueda Objeto que contiene los parámetros de búsqueda
	 */
	private void creaCriteria(final AlertaBusqueda alertaBusqueda, final Criteria criteria) {
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(alertaBusqueda.getDestinatario(), criteria,
				Constantes.DESTINATARIO);

		UtilitiesCriteria.setCondicionCriteriaCadenaLike(alertaBusqueda.getAsunto(), criteria, Constantes.ASUNTO);

		UtilitiesCriteria.setCondicionCriteriaIgualdadLong(alertaBusqueda.getId(), criteria, Constantes.ID);

		UtilitiesCriteria.setCondicionCriteriaFechaMayor(alertaBusqueda.getFechaDesdeEnvio(), criteria,
				Constantes.FECHAENVIO);

		UtilitiesCriteria.setCondicionCriteriaFechaMenorIgual(alertaBusqueda.getFechaHastaEnvio(), criteria,
				Constantes.FECHAENVIO);

	}

	/**
	 * Envia alerta individualmente.
	 * @param alerta Alerta
	 * @param usuario User
	 */
	private void enviarAlertaUsuarioIndividual(final Alerta alerta, final Users usuario) {
		Alerta alertaLocal;
		alertaLocal = new Alerta();
		BeanUtils.copyProperties(alerta, alertaLocal);
		alertaLocal.setUsuario(usuario);
		// ENVIAMOS MAIL SI PROCEDE

		if (usuario.getPersonalData().getAlertChannel().equals(AlertChannelEnum.EMAIL)) {
			alertaLocal.setDestinatario(usuario.getUsername());
			mailAlertaSender.send(alertaLocal, usuario);
		}

		// ENVIAMOS SMS SI PROCEDE
		if (usuario.getPersonalData().getAlertChannel().equals(AlertChannelEnum.EMAIL_SMS)
				|| usuario.getPersonalData().getAlertChannel().equals(AlertChannelEnum.SMS)) {
			alertaLocal.setDestinatario(usuario.getPersonalData().getPhone());
		}

		if (usuario.getUsername() == null) {
			alertaLocal.setUsuario(null);
		}
		else {
			alertaLocal.setUsuario(usuario);
		}
		alertaRepository.save(alertaLocal);
	}

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda RegistroBusqueda
	 * @return int
	 */
	@Override
	public int getCounCriteria(final AlertaBusqueda busqueda) {
		try {
			session = sessionFactory.openSession();
			final Criteria crit = session.createCriteria(Alerta.class);
			creaCriteria(busqueda, crit);
			crit.setProjection(Projections.rowCount());
			final Long cnt = (Long) crit.uniqueResult();

			return Math.toIntExact(cnt);
		}
		finally {
			if ((session != null) && session.isOpen()) {
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
	 * Guarda una alerta.
	 * @param alerta Alerta
	 * @return Alerta
	 */
	@Override
	@Transactional(readOnly = false)
	public Alerta save(final Alerta alerta) {
		return alertaRepository.save(alerta);
	}

	/**
	 * Envía una alerta a los usuarios que contenga la lista adjuntada.
	 * @param alerta Alerta
	 * @param usuariosSeleccionados List<User>
	 */
	@Override
	public void sendAlert(final Alerta alerta, final List<Users> usuariosSeleccionados) {
		for (final Users usuario : usuariosSeleccionados) {
			enviarAlertaUsuarioIndividual(alerta, usuario);
		}
	}

	/**
	 * envia una alerta a un usuario determinado.
	 * @param alerta Alerta
	 * @param usuario User
	 */
	@Override
	public void sendAlertUsuario(final Alerta alerta, final Users usuario) {
		enviarAlertaUsuarioIndividual(alerta, usuario);
	}

}

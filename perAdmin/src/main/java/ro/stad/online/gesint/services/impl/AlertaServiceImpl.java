package ro.per.online.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

import com.mitchellbosecke.pebble.error.PebbleException;

import lombok.NoArgsConstructor;
import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.Users;
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
@Transactional
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
	 * Căutați alerte cu parametrii de căutare.
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
	 * Verificați criteriile pentru căutarea alertelor.
	 *
	 * @param criteria consulta criteria
	 * @param alertaBusqueda Obiect care conține parametrii de căutare
	 */
	private void creaCriteria(final AlertaBusqueda alertaBusqueda, final Criteria criteria) {
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(alertaBusqueda.getDestinatario(), criteria, "destinatarios");
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(alertaBusqueda.getAsunto(), criteria, Constantes.ASUNTO);
		UtilitiesCriteria.setCondicionCriteriaIgualdadLong(alertaBusqueda.getId(), criteria, Constantes.ID);
		UtilitiesCriteria.setCondicionCriteriaFechaMayor(alertaBusqueda.getFechaDesdeEnvio(), criteria,
				Constantes.FECHAENVIO);
		UtilitiesCriteria.setCondicionCriteriaFechaMenorIgual(alertaBusqueda.getFechaHastaEnvio(), criteria,
				Constantes.FECHAENVIO);
		UtilitiesCriteria.setCondicionCriteriaFechaMayor(alertaBusqueda.getFechaDesdeCreate(), criteria,
				Constantes.FECHACREACION);
		UtilitiesCriteria.setCondicionCriteriaFechaMenorIgual(alertaBusqueda.getFechaHastaCreate(), criteria,
				Constantes.FECHACREACION);
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(alertaBusqueda.getTipAlerta(), criteria, "tipAlerta");

	}

	/**
	 * Trimiteți alertă sau comunicare în mod individual.
	 * @param alerta Alerta
	 * @param usuario User
	 * @throws PebbleException
	 */
	@Override
	public void sendAlert(Alerta alerta, List<Users> usuariosSeleccionados, List<Documento> documentosCargados,
			String plantilla, Map<String, String> paramPlantilla) throws PebbleException {
		Alerta alertaLocal;
		alertaLocal = new Alerta();
		BeanUtils.copyProperties(alerta, alertaLocal);
		mailAlertaSender.send(alertaLocal, usuariosSeleccionados, documentosCargados, plantilla, paramPlantilla);
	}

	/**
	 * Obțineți numărul
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
	 * Salvați o alertă sau o comunicare
	 * @param alerta Alerta
	 * @return Alerta
	 */
	@Override
	@Transactional(readOnly = false)
	public Alerta save(final Alerta alerta) {
		return alertaRepository.save(alerta);
	}

	/**
	 * Eliminarea unei alerte
	 * @param alerta
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(final Long id) {
		this.alertaRepository.delete(id);
	}

	/**
	 * Cauta o alerta
	 * @param alerta Alerta
	 * @return alerta Alerta
	 */
	@Override
	public Alerta fiindOne(final Alerta alerta) {
		alertaRepository.findOne(alerta.getId());
		return alerta;
	}

}

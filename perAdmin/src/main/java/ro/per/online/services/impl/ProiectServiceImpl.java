package ro.per.online.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Proiecte;
import ro.per.online.persistence.repositories.ProiectRepository;
import ro.per.online.services.ProiectService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.UtilitiesCriteria;
import ro.per.online.web.beans.ProiectBusqueda;

/**
 * Implementación del servicio de centros.
 *
 * @author STAD
 */

@Service
@Transactional
public class ProiectServiceImpl implements ProiectService {

	/**
	 * Variable utilizada para inyectar el repositorio de propriedades.
	 */
	@Autowired
	private ProiectRepository proiectRepository;

	/**
	 * SessionFactory.
	 */
	@Autowired
	private transient SessionFactory sessionFactory;

	/**
	 * Session.
	 */

	private Session session;

	/**
	 * Busca usuarios con los parametros de búsqueda.
	 * @param usuarioBusqueda AnNumarPojo
	 * @param sortOrder SortOrder
	 * @param sortField String
	 * @param pageSize int
	 * @param first int
	 *
	 * @return List<User>
	 *
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Proiecte> buscarProiecteCriteria(final int first, final int pageSize, final String sortField,
			final SortOrder sortOrder, final ProiectBusqueda proiectBusqueda) {
		try {
			session = sessionFactory.openSession();
			final Criteria criteria = session.createCriteria(Proiecte.class, Constantes.PROIECTE);
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
				criteria.addOrder(Order.asc("rank"));
			}
			List<Proiecte> proiecteList;
			creaCriteria(proiectBusqueda, criteria);

			proiecteList = criteria.list();
			session.close();
			return proiecteList;
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Manejo y cierre de la sesión.
	 */
	private void closeSession() {
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

	/**
	 * @param proiectBusqueda
	 * @param criteria
	 */
	private void creaCriteria(final ProiectBusqueda proiectBusqueda, final Criteria criteria) {
		UtilitiesCriteria.setCondicionCriteriaFechaMayor(proiectBusqueda.getDateFrom(), criteria,
				Constantes.FECHACREACION);
		UtilitiesCriteria.setCondicionCriteriaFechaMenorIgual(proiectBusqueda.getDateUntil(), criteria,
				Constantes.FECHACREACION);
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(proiectBusqueda.getNume(), criteria, "titlu");
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(proiectBusqueda.getUsername(), criteria, "usuario");
		criteriaMateriaIndexada(criteria, proiectBusqueda.getMateriaIndexata());
		UtilitiesCriteria.setCondicionCriteriaIgualdadBoolean(proiectBusqueda.getValidated(), criteria,
				Constantes.VALIDAT);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	}

	/**
	 * Añade al criteria el filtro de la materia indexada introducida en el formulario.
	 *
	 * @param criteria Criteria al que se añadirán los parámetros.
	 * @param materiaIndexada materia indexada introducida en el filtro (separada por comas)
	 */
	private void criteriaMateriaIndexada(final Criteria criteria, final String materiaIndexada) {
		if (materiaIndexada != null) {
			final String[] claves = materiaIndexada.split(Constantes.COMA);
			final Criterion[] clavesOr = new Criterion[claves.length];
			for (int i = 0; i < claves.length; i++) {
				clavesOr[i] = Restrictions.ilike("materiaIndexata", claves[i].trim(), MatchMode.ANYWHERE);
			}
			criteria.add(Restrictions.or(clavesOr));
		}
	}

	/**
	 * Elimina un proiect
	 *
	 * @param proiect Proiecte
	 */
	@Override
	public void delete(final Proiecte proiect) {
		proiectRepository.delete(proiect);
	}

	/**
	 * Devuelve todos los parametros de conexión al servidor de correo.
	 * @return List<Propriedades>
	 * @see net.atos.mira.elypse.bean.ApplicationBean.init(String)
	 */
	@Override
	public List<Proiecte> findAll() {
		return (List<Proiecte>) proiectRepository.findAll();
	}

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda ProiectBusqueda
	 * @return int
	 */
	@Override
	public int getCounCriteria(final ProiectBusqueda busqueda) {
		try {
			session = sessionFactory.openSession();
			final Criteria teria = session.createCriteria(Proiecte.class, Constantes.PROIECTE);
			creaCriteria(busqueda, teria);
			teria.setProjection(Projections.rowCount());
			final Long cnt = (Long) teria.uniqueResult();

			return Math.toIntExact(cnt);
		}
		finally {
			closeSession();
		}

	}

	/**
	 * Salvați sau actualizați un proiect.
	 * @param proiect
	 * @return Proiect actualizat
	 */
	@Override
	public Proiecte save(final Proiecte proiect) {
		final Proiecte proiectActualizado = proiectRepository.save(proiect);
		return proiectActualizado;

	}

	/**
	 * Cauta ultima pozitie din lista
	 */
	@Override
	public List<Proiecte> findAllByOrderByRankDesc() {
		return (ArrayList<Proiecte>) proiectRepository.findAllByOrderByRankAsc();
	}

	/**
	 * Prepara el criteria pasado como parámetro para la paginación de Primefaces.
	 *
	 * @param criteria criteria a configurar
	 * @param first primer elemento
	 * @param pageSize tamaño de cada página de resultados
	 * @param sortField campo por el que se ordenan los resultados
	 * @param sortOrder sentido de la ordenacion (ascendente/descendente)
	 * @param defaultField campo de ordenación por defecto
	 */
	@Override
	public void prepararPaginacionOrdenCriteria(final Criteria criteria, final int first, final int pageSize,
			final String sortField, final SortOrder sortOrder, final String defaultField) {
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);

		if (sortField != null && sortOrder.equals(SortOrder.ASCENDING)) {
			criteria.addOrder(Order.asc(sortField));
		}
		else if (sortField != null && sortOrder.equals(SortOrder.DESCENDING)) {
			criteria.addOrder(Order.desc(sortField));
		}
		else if (sortField == null) {
			criteria.addOrder(Order.asc(defaultField));
		}
	}
}

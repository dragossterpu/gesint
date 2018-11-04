package ro.per.online.services.impl;

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
	 * Devuelve todos los parametros de conexión al servidor de correo.
	 * @return List<Propriedades>
	 * @see net.atos.mira.elypse.bean.ApplicationBean.init(String)
	 */
	@Override
	public List<Proiecte> findAll() {
		return (List<Proiecte>) this.proiectRepository.findAll();
	}

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda ProiectBusqueda
	 * @return int
	 */
	@Override
	public int getCounCriteria(final ProiectBusqueda busqueda) {
		try {
			this.session = this.sessionFactory.openSession();
			final Criteria teria = this.session.createCriteria(Proiecte.class, "proiecte");
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
	 * Busca usuarios con los parametros de búsqueda.
	 * @param usuarioBusqueda UsuarioBusqueda
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
			this.session = this.sessionFactory.openSession();
			final Criteria criteria = this.session.createCriteria(Proiecte.class, "proiecte");
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
				criteria.addOrder(Order.asc("orden"));
			}
			List<Proiecte> proiecteList;
			creaCriteria(proiectBusqueda, criteria);

			proiecteList = criteria.list();
			this.session.close();
			return proiecteList;
		}
		finally {
			closeSession();
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
		UtilitiesCriteria.setCondicionCriteriaIgualdadBoolean(proiectBusqueda.getValidated(), criteria, "validated");
	}

	/**
	 * Añade al criteria el filtro de la materia indexada introducida en el formulario.
	 * 
	 * @param criteria Criteria al que se añadirán los parámetros.
	 * @param materiaIndexada materia indexada introducida en el filtro (separada por comas)
	 */
	private void criteriaMateriaIndexada(Criteria criteria, String materiaIndexada) {
		if (materiaIndexada != null) {
			String[] claves = materiaIndexada.split(",");
			Criterion[] clavesOr = new Criterion[claves.length];
			for (int i = 0; i < claves.length; i++) {
				clavesOr[i] = Restrictions.ilike("materiaIndexada", claves[i].trim(), MatchMode.ANYWHERE);
			}
			criteria.add(Restrictions.or(clavesOr));
		}
	}

	/**
	 * Manejo y cierre de la sesión.
	 */
	private void closeSession() {
		if (this.session != null && this.session.isOpen()) {
			try {
				this.session.close();
			}
			catch (final DataAccessException e) {
				FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
						"Error mesaj");
			}
		}
	}

	/**
	 * Elimina un proiect
	 * 
	 * @param proiect Proiecte
	 */
	@Override
	public void delete(final Proiecte proiect) {
		this.proiectRepository.delete(proiect);
	}

	/**
	 * Salvați sau actualizați un proiect.
	 * @param proiect
	 * @return Proiect actualizat
	 */
	@Override
	public Proiecte save(final Proiecte proiect) {
		Proiecte proiectActualizado = proiectRepository.save(proiect);
		return proiectActualizado;

	}

}

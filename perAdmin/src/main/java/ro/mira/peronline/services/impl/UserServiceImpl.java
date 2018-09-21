package ro.mira.peronline.services.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.mira.peronline.constantes.Constantes;
import ro.mira.peronline.persistence.entities.Users;
import ro.mira.peronline.persistence.repositories.UserRepository;
import ro.mira.peronline.services.UserService;
import ro.mira.peronline.util.FacesUtilities;
import ro.mira.peronline.util.UtilitiesCriteria;
import ro.mira.peronline.web.beans.SearchUser;

/**
 * Implementación del servicio de unidades.
 *
 * @author STAD
 *
 */

@Transactional
@Service
public class UserServiceImpl implements UserService {

	/**
	 * Repositoriu de Users.
	 */
	@Autowired
	private UserRepository userRepository;

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
	 * Devuelve toti utilizatorii inregistrati in baza de date.
	 * @return lista de unidades
	 */
	@Override
	public List<Users> fiindAll() {
		final Iterable<Users> users = userRepository.findAll();
		return (List<Users>) users;
	}

	/**
	 * Devuelve utilizatorul inregistrat in baza de date.
	 * @return Users user
	 * @see
	 */
	@Override
	public Users fiindOne(String id) {
		final Users user = userRepository.findOne(id);
		return user;
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
	@Override
	public List<Users> buscarUsuarioCriteria(final int first, final int pageSize, final String sortField,
			final SortOrder sortOrder, final SearchUser usuarioBusqueda) {
		try {
			this.session = this.sessionFactory.openSession();
			final Criteria criteria = this.session.createCriteria(Users.class);

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

			final List<Users> usuariosList = gestionarCriteriaUsuarios(usuarioBusqueda, criteria);

			return usuariosList;
		}
		finally {
			closeSession();
		}

	}

	/**
	 * Obitne el listado de usuario en base a las condiciones de Criteria.
	 * 
	 * @param usuarioBusqueda UsuarioBusqueda
	 * @param criteria Criteria
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	private List<Users> gestionarCriteriaUsuarios(final SearchUser usuarioBusqueda, final Criteria criteria) {
		creaCriteria(usuarioBusqueda, criteria);

		final List<Users> usuariosList = criteria.list();
		this.session.close();
		return usuariosList;
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
	 * @param usuarioBusqueda UsuarioBusqueda
	 * @param criteria Criteria
	 */
	private void creaCriteria(final SearchUser searchUser, final Criteria criteria) {
		UtilitiesCriteria.setCondicionCriteriaFechaMayor(searchUser.getDateFrom(), criteria, Constantes.FECHACREACION);
		UtilitiesCriteria.setCondicionCriteriaFechaMenorIgual(searchUser.getDateUntil(), criteria,
				Constantes.FECHACREACION);

		UtilitiesCriteria.setCondicionCriteriaCadenaLike(searchUser.getName(), criteria, "name");

		UtilitiesCriteria.setCondicionCriteriaCadenaLike(searchUser.getUsername(), criteria, "username");

		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(searchUser.getRole(), criteria, "role");

	}

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda UsuarioBusqueda
	 * @return int
	 */
	@Override
	public int getCounCriteria(final SearchUser busqueda) {
		try {
			this.session = this.sessionFactory.openSession();
			final Criteria teria = this.session.createCriteria(Users.class);
			creaCriteria(busqueda, teria);
			teria.setProjection(Projections.rowCount());
			final Long cnt = (Long) teria.uniqueResult();

			return Math.toIntExact(cnt);
		}
		finally {
			closeSession();
		}

	}

}

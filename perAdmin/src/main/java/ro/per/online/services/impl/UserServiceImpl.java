package ro.per.online.services.impl;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.PersonalData;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.repositories.UserRepository;
import ro.per.online.services.LocalityService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.UserService;
import ro.per.online.util.FacesUtilities;
import ro.per.online.util.UtilitiesCriteria;
import ro.per.online.web.beans.UsuarioBusqueda;

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
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 * 
	 */
	@Autowired
	private ProvinceService provinceService;

	/**
	 * Variabila utilizata pentru a injecta serviciul localitatilor.
	 * 
	 */
	@Autowired
	private LocalityService localityService;

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
	public List<Users> buscarUsuarioCriteria(final int first, final int pageSize, final String sortField,
			final SortOrder sortOrder, final UsuarioBusqueda usuarioBusqueda) {
		try {
			this.session = this.sessionFactory.openSession();
			final Criteria criteria = this.session.createCriteria(Users.class, "user");
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
				criteria.addOrder(Order.desc("dateCreate"));
			}
			List<Users> usuariosList;
			creaCriteria(usuarioBusqueda, criteria);

			usuariosList = criteria.list();
			this.session.close();
			return usuariosList;
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Busca usuarios utilizando criteria.
	 * 
	 * @param usuarioBusqueda UsuarioBusqueda
	 * @return List<User>
	 */
	@Override
	public List<Users> buscarUsuarioCriteria(final UsuarioBusqueda usuarioBusqueda) {
		try {
			this.session = this.sessionFactory.openSession();
			final Criteria criteria = this.session.createCriteria(Users.class);
			@SuppressWarnings(Constantes.UNCHECKED)
			final List<Users> usuariosList = gestionarCriteriaUsuarios(usuarioBusqueda, criteria);
			return usuariosList;
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Recibe un archivo UploadedFile y los datos necesarios para general un Documento pero no lo almacena en base de
	 * datos. Sólo deja el objeto preparado para guardarlo.
	 * 
	 * @param file fichero a cargar en BDD
	 * @param tipo tipo de documentp
	 * @param inspeccion inspección asociada al documento
	 * @return documento cargado en base de datos
	 * @throws IOException
	 * @throws ProgesinException excepción lanzada
	 */
	@Override
	public Users cargaImagenSinGuardar(byte[] file, Users user) throws IOException {
		return crearImagen(file, user);
	}

	/**
	 * Incarcam datele personale ale utilizatorului
	 * @param provincia
	 * @param nuevaLocalidad
	 * @param usuario
	 * @return usuario
	 */
	private void cargarDatosPersonaleUser(byte[] fileBlob, final Users usuario) {
		final PersonalData pd = new PersonalData();
		pd.setAddress(usuario.getPersonalData().getAddress());
		pd.setBirthDate(usuario.getPersonalData().getBirthDate());
		pd.setCivilStatus(usuario.getPersonalData().getCivilStatus());
		pd.setEducation(usuario.getPersonalData().getEducation());
		pd.setIdCard(usuario.getPersonalData().getIdCard());
		pd.setLocality(usuario.getPersonalData().getLocality());
		pd.setNumberCard(usuario.getPersonalData().getNumberCard());
		pd.setPersonalEmail(usuario.getPersonalData().getPersonalEmail());
		pd.setPhone(usuario.getPersonalData().getPhone());
		pd.setPhoto(fileBlob);
		pd.setProvince(usuario.getPersonalData().getProvince());
		pd.setSex(usuario.getPersonalData().getSex());
		pd.setValidated(usuario.getPersonalData().getValidated());
		pd.setWorkplace(usuario.getPersonalData().getWorkplace());
		usuario.setPersonalData(pd);
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
	 * @param usuarioBusqueda
	 * @param criteria
	 */
	private void creaCriteria(final UsuarioBusqueda usuarioBusqueda, final Criteria criteria) {
		UtilitiesCriteria.setCondicionCriteriaFechaMayor(usuarioBusqueda.getDateFrom(), criteria,
				Constantes.FECHACREACION);
		UtilitiesCriteria.setCondicionCriteriaFechaMenorIgual(usuarioBusqueda.getDateUntil(), criteria,
				Constantes.FECHACREACION);
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(usuarioBusqueda.getName(), criteria, "name");
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(usuarioBusqueda.getLastName(), criteria, "lastName");
		UtilitiesCriteria.setCondicionCriteriaIgualdadLong(usuarioBusqueda.getId(), criteria,
				"personalData.province.id");
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(usuarioBusqueda.getIdCard(), criteria, "personalData.idCard");
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(usuarioBusqueda.getEmail(), criteria, "email");
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(usuarioBusqueda.getRole(), criteria, "role");
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(usuarioBusqueda.getSex(), criteria, "personalData.sex");
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(usuarioBusqueda.getCivilStatus(), criteria,
				"personalData.civilStatus");
		if (usuarioBusqueda.getTypeLocality() != null) {
			criteria.createAlias("personalData.locality", "locality");

			UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(usuarioBusqueda.getTypeLocality(), criteria,
					"locality.typelocality");
		}

		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(usuarioBusqueda.getEducation(), criteria,
				"personalData.education");
		if (usuarioBusqueda.getIdProvincia() != null) {
			criteria.add(Restrictions.eq("personalData.province",
					provinceService.findById(usuarioBusqueda.getIdProvincia())));
			// UtilitiesCriteria.setCondicionCriteriaIgualdadLong(
			// provinceService.findById(usuarioBusqueda.getIdProvincia()), criteria, "personalData.province");
		}
		if (usuarioBusqueda.getIdLocalidad() != null) {
			criteria.add(Restrictions.eq("personalData.locality",
					localityService.findById(usuarioBusqueda.getIdLocalidad())));
			// UtilitiesCriteria.setCondicionCriteriaIgualdadLong(
			// localityService.findById(usuarioBusqueda.getIdLocalidad()), criteria, "personalData.locality");
		}
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(usuarioBusqueda.getEducation(), criteria,
				"personalData.education");
	}

	/**
	 * Crea el documento.
	 * 
	 * @param file Fichero subido por el usuario.
	 * @param user a la que se asocia.
	 * @return user generado
	 * @throws DataAccessException Excepción SQL
	 * @throws IOException Excepción entrada/salida
	 */
	private Users crearImagen(byte[] file, Users user) throws IOException {
		cargarDatosPersonaleUser(file, user);
		userRepository.save(user);
		return user;
	}

	/**
	 * Borrado de usuario por username.
	 * @param username Users
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(final Users username) {
		this.userRepository.delete(username);
	}

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
	 * Căutați un utilizator cu CNP.
	 * @param cnp String - cnp-ul utilizatorului
	 * @return User
	 */
	@Override
	public Users findByIdCard(final String cnp) {
		return this.userRepository.findByPersonalDataIdCard(cnp);
	}

	/**
	 * Obitne el listado de usuario en base a las condiciones de Criteria.
	 * @param usuarioBusqueda UsuarioBusqueda
	 * @param criteria Criteria
	 * @return List<User>
	 */
	private List<Users> gestionarCriteriaUsuarios(final UsuarioBusqueda usuarioBusqueda, final Criteria criteria) {
		creaCriteria(usuarioBusqueda, criteria);
		@SuppressWarnings(Constantes.UNCHECKED)
		final List<Users> usuariosList = criteria.list();
		this.session.close();
		return usuariosList;
	}

	/**
	 * Obtiene el conteo de criteria.
	 * @param busqueda UsuarioBusqueda
	 * @return int
	 */
	@Override
	public int getCounCriteria(final UsuarioBusqueda busqueda) {
		try {
			this.session = this.sessionFactory.openSession();
			final Criteria teria = this.session.createCriteria(Users.class, "user");
			creaCriteria(busqueda, teria);
			teria.setProjection(Projections.rowCount());
			final Long cnt = (Long) teria.uniqueResult();

			return Math.toIntExact(cnt);
		}
		finally {
			closeSession();
		}

	}

	/*
	 * Metoda care genereaza automat 100 de utilizatori
	 * 
	 * @see ro.per.online.services.UserService#save(ro.per.online.persistence.entities.Users)
	 */
	@Override
	@Transactional(readOnly = false)
	public Users save(Users entity) {
		return userRepository.save(entity);
	}
}

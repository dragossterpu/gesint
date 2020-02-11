package ro.per.online.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;
import ro.per.online.persistence.repositories.LocalityRepository;
import ro.per.online.services.CriteriaService;
import ro.per.online.services.LocalityService;
import ro.per.online.services.ProvinceService;
import ro.per.online.util.UtilitiesCriteria;
import ro.per.online.web.beans.admin.LocalitateBusqueda;

/**
 * Implementación del servicio de localitati.
 *
 * @author STAD
 *
 */
@Service
public class LocalityServiceImpl implements LocalityService {

	/**
	 * Repositoriu de PLocality.
	 */
	@Autowired
	private LocalityRepository localityRepository;

	/**
	 * Session.
	 */
	private Session session;

	/**
	 * Corrección de fallos, checkstyle y limpieza de clases sin usar Session de link service.
	 */
	@Autowired
	private transient SessionFactory sessionFactory;

	/**
	 * Servicio para usar los métodos usados junto con criteria.
	 */
	@Autowired
	private transient CriteriaService criteriaService;

	/**
	 * Variabila utilizata pentru injectarea serviciului de judete
	 */
	@Autowired
	private transient ProvinceService provinceService;

	/**
	 * Busca las localidades pertenecientes a una provincia.
	 * @param idProvincia Provincia que queremos consultar.
	 * @return lista Lista de localidades por provincia.
	 */
	@Override
	public List<PLocality> buscaByProvincia(final Long idProvincia) {
		return localityRepository.findByProvinceOrderByName(idProvincia);
	}

	/**
	 * Guarda un nuevo municipio.
	 * @param nombre del municipio
	 * @param provincia a la que pertenece el municipio
	 * @return municipio creado (true si es guardado correctamente)
	 */
	@Override
	@Transactional(readOnly = false)
	public PLocality crearLocalidad(final String nombre, final PProvince provincia,
			final TypeLocalityEnum tipLoclalitate) {
		final PLocality nuevaLocalidad = new PLocality();
		nuevaLocalidad.setName(nombre);
		nuevaLocalidad.setProvince(provincia);
		nuevaLocalidad.setResidence(false);
		nuevaLocalidad.setSector(null);
		nuevaLocalidad.setTypelocality(tipLoclalitate);
		localityRepository.save(nuevaLocalidad);
		return nuevaLocalidad;

	}

	/**
	 * Comprueba si existe un municipio conociendo su nombre.
	 *
	 * @param name nombre del municipio
	 * @param provincia a la que pertenece el municipio
	 * @return valor booleano
	 */
	@Override
	public boolean existeByNameIgnoreCaseAndProvincia(final String name, final PProvince provincia) {
		return localityRepository.existsByNameIgnoreCaseAndProvince(name, provincia);
	}

	/**
	 * Comprueba si existe un municipio conociendo su nombre.
	 *
	 * @param name nombre del municipio
	 * @param provincia a la que pertenece el municipio
	 * @return valor booleano
	 */
	@Override
	public PLocality localidadByNameIgnoreCaseAndProvincia(final String name, final PProvince provincia) {
		return localityRepository.findByNameIgnoreCaseAndProvince(name, provincia);
	}

	/**
	 * Devuelve toate judetele inregistrate in baza de date.
	 * @return lista de judete
	 */
	@Override
	public List<PLocality> fiindAll() {
		return (ArrayList<PLocality>) localityRepository.findAll();
	}

	/**
	 * Cauta o localitate dupa id acestuia
	 * @param descripcion
	 * @return PLocality
	 *
	 */
	@Override
	public PLocality findById(final Long localidadId) {
		return localityRepository.findOne(localidadId);
	}

	/**
	 * Cauta o localitate dupa numele acestuia
	 * @param descripcion
	 * @return PLocality
	 *
	 */
	@Override
	public PLocality findByName(final String local) {
		return localityRepository.findByName(local);
	}

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	@Override
	public List<PLocality> findByProvince(final PProvince province) {
		return localityRepository.findAllByProvince(province);
	}

	/**
	 * Cauta toate localitatile unei provincii
	 * @param Long id identificator de judet
	 * @return lista de localitati.
	 * @see ro.mira.per.controller.AdminController.users(HttpServletRequest, Integer) (potential match)
	 */
	@Override
	public List<PLocality> findByProvinceAndNivel(final PProvince province, final Long nivel) {
		return localityRepository.findAllByProvinceAndNivel(province, nivel);
	}

	/**
	 * Salvați o localitate
	 * @param localitate PLocality
	 * @return localitate actualizata
	 */
	@Override
	@Transactional(readOnly = false)
	public PLocality save(final PLocality localitate) {
		return localityRepository.save(localitate);
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
	public PLocality cargaImagenSinGuardar(final byte[] file, final PLocality localitate) throws IOException {
		return crearImagen(file, localitate);
	}

	/**
	 * Incarcam imaginea provinciei.
	 *
	 * @param file Fichero subido por el usuario.
	 * @param judetul caruia se asociaza imaginea.
	 * @return judet
	 * @throws DataAccessException Excepción SQL
	 * @throws IOException Excepción entrada/salida
	 */
	private PLocality crearImagen(final byte[] file, final PLocality localitate) throws IOException {
		cargarDatosPersonaleUser(file, localitate);
		localityRepository.save(localitate);
		return localitate;
	}

	/**
	 * Incarcam fotografia judetului
	 * @param provincia
	 * @return PProvince judet
	 */
	private void cargarDatosPersonaleUser(final byte[] fileBlob, final PLocality localitate) {
		localitate.setPhoto(fileBlob);
	}

	/**
	 * Método que devuelve el número de links en una consulta basada en criteria.
	 *
	 * @param busqueda objeto con parámetros de búsqueda
	 * @return devuelve el número de registros de una consulta criteria.
	 */
	@Override
	public int getCounCriteria(final LocalitateBusqueda busqueda) {
		this.session = this.sessionFactory.openSession();
		final Criteria criteria = this.session.createCriteria(PLocality.class, "localitate");
		buscarCriteria(busqueda, criteria);
		criteria.setProjection(Projections.rowCount());
		final Long cnt = (Long) criteria.uniqueResult();
		this.session.close();
		return Math.toIntExact(cnt);
	}

	/**
	 * Busca todos los links que cumplan las condiciones insertadas en la clase linksBusqueda.
	 * @param linksBusqueda LinksBusqueda
	 * @param criteria Criteria
	 */
	private void buscarCriteria(final LocalitateBusqueda busqueda, final Criteria criteria) {
		UtilitiesCriteria.setCondicionCriteriaCadenaLike(busqueda.getNume(), criteria, "name");
		UtilitiesCriteria.setCondicionCriteriaIgualdadEnum(busqueda.getTip(), criteria, "typelocality");
		if (busqueda.getIdProvincia() != null && !busqueda.getIdProvincia().equals("")) {
			criteria.add(Restrictions.eq("province", provinceService.findById(busqueda.getIdProvincia())));
		}
	}

	/**
	 * Método que devuelve la lista de links en una consulta basada en criteria.
	 *
	 * @param linkBusqueda objeto con los criterios de búsqueda
	 * @param first primer elemento
	 * @param pageSize tamaño de cada página de resultados
	 * @param sortField campo por el que se ordenan los resultados
	 * @param sortOrder sentido de la ordenacion (ascendente/descendente)
	 * @return la lista de links.
	 */
	@Override
	public List<PLocality> buscarLocalitateCriteria(final int first, final int pageSize, final String sortField,
			final SortOrder sortOrder, final LocalitateBusqueda busqueda) {
		this.session = this.sessionFactory.openSession();
		final Criteria criteria = this.session.createCriteria(PLocality.class, "localitate");
		buscarCriteria(busqueda, criteria);

		this.criteriaService.prepararPaginacionOrdenCriteria(criteria, first, pageSize, sortField, sortOrder,
				Constantes.ID);

		@SuppressWarnings(Constantes.UNCHECKED)
		final List<PLocality> listado = criteria.list();
		this.session.close();

		return listado;
	}

	/**
	 * Elimina o localitate
	 * 
	 * @param id identicatorul localitatii
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(PLocality localitate) {
		localityRepository.delete(localitate.getId());
	}
}

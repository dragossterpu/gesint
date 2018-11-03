package ro.per.online.services.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import ro.per.online.constantes.Constantes;
import ro.per.online.exceptions.PerException;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.DocumentoBlob;
import ro.per.online.persistence.entities.TipoDocumento;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.repositories.IDocumentoRepository;
import ro.per.online.persistence.repositories.ITipoDocumentoRepository;
import ro.per.online.services.DocumentoService;
import ro.per.online.web.beans.gd.DocumentoBusqueda;

/**
 * 
 * Implementarea serviciului de documente.
 * 
 * @author STAD
 *
 */

@Service("documentoService")
public class DocumentoServiceImpl implements DocumentoService {

	/**
	 * SessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Repository de documente.
	 */
	@Autowired
	private IDocumentoRepository documentoRepository;

	/**
	 * Repositorio de tipo de documento.
	 */
	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;

	/**
	 * Ștergeți o serie de documente din baza de date. Documentul care trebuie șters este trecut ca parametru.
	 * @param entity Documentul care trebuie șters
	 * 
	 */
	@Override
	public void delete(final Documento entity) {
		documentoRepository.delete(entity);
	}

	/**
	 * Căutați toate documentele care nu au eliminare logică.
	 * @return Lista documentelor selectate
	 */
	@Override
	public List<Documento> findByFechaBajaIsNull() {
		return documentoRepository.findByDateDeletedIsNull();
	}

	/**
	 * Căutați toate documentele care au fost eliminate logic.
	 * @return Lista documentelor selectate
	 */
	@Override
	public List<Documento> findByFechaBajaIsNotNull() {
		return documentoRepository.findByDateDeletedIsNotNull();
	}

	/**
	 * Returnează un document localizat după id-ul său.
	 * @param id Identificatorul documentului
	 * @return Documento
	 */
	@Override
	public Documento findOne(final Long id) {
		return documentoRepository.findOne(id);
	}

	/**
	 * Salvați o serie de documente în baza de date. Ca parametru, primește documentele care trebuie salvate și
	 * returnează documentele salvate.
	 * @param entities Documente de salvat
	 * @return lista documentelor salvate
	 * 
	 */
	@Override
	public Iterable<Documento> save(final Iterable<Documento> entities) {
		return documentoRepository.save(entities);
	}

	/**
	 * Salvați un document în baza de date. Ca parametru, primește documentul care trebuie salvat și returnează
	 * documentul salvat.
	 * @param entity Documento Document pentru salvare
	 * @return documento documentul salvat
	 */
	@Override
	@Transactional(readOnly = false)
	public Documento save(final Documento entity) {
		return documentoRepository.save(entity);
	}

	/**
	 * Recibe un documento como parámetro y devuelve un stream para realizar la descarga. Primiți un document ca
	 * parametru și returnați un stream(flux) pentru a efectua descărcarea.
	 * @param entity Document pentru descărcare.
	 * @return DefaultStreamedContent Descărcați fluxul
	 * @throws PerException Excepție posibilă
	 */
	@Override
	public DefaultStreamedContent descargaDocumento(final Documento entity) throws PerException {
		final Documento docu = documentoRepository.findById(entity.getId());
		DefaultStreamedContent streamDocumento;
		if (docu != null) {
			final DocumentoBlob doc = docu.getFichero();
			final InputStream stream = new ByteArrayInputStream(doc.getFichero());
			streamDocumento = new DefaultStreamedContent(stream, entity.getTipoContenido(), doc.getNombreFichero());
		}
		else {
			throw new PerException(new Exception("A apărut o eroare la descărcarea documentului"));
		}
		return streamDocumento;
	}

	/**
	 * Primește id-ul unui document ca parametru și returnează un flux pentru efectuarea descărcării.
	 * @param id Document pentru descărcare.
	 * @return DefaultStreamedContent Descărcați fluxul
	 * @throws PerException Excepție posibilă
	 */
	@Override
	public DefaultStreamedContent descargaDocumento(final Long id) throws PerException {
		final Documento entity = documentoRepository.findById(id);
		DefaultStreamedContent streamDocumento;
		if (entity != null) {
			final DocumentoBlob doc = entity.getFichero();
			final InputStream stream = new ByteArrayInputStream(entity.getFichero().getFichero());
			streamDocumento = new DefaultStreamedContent(stream, entity.getTipoContenido(), doc.getNombreFichero());
		}
		else {
			throw new PerException(new Exception("A apărut o eroare la descărcarea documentului"));
		}
		return streamDocumento;

	}

	/**
	 * Recibe un archivo UploadedFile del que recupera los datos para generar un Documento que se almacenará en base de
	 * datos. Devuelve el documento almacenado.
	 * @param file fichero a cargar en BDD
	 * @param tipo tipo de documentp
	 * @param inspeccion inspección asociada al documento
	 * @return Documento documento cargado en base de datos
	 * @throws PerException Excepție posibilă
	 * 
	 */
	@Override
	public Documento cargaDocumento(final UploadedFile file, final TipoDocumento tipo, final Users usuario)
			throws PerException {
		try {
			final Documento documento = documentoRepository.save(crearDocumento(file, tipo, usuario));
			final String mensaje = "Documentul a fost încărcat " + documento.getNombre() + " de utilizatorul"
					+ usuario.getUsername();
			return documento;
		}
		catch (DataAccessException | IOException ex) {
			throw new PerException(ex);
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
	 * @throws ProgesinException excepción lanzada
	 */
	@Override
	public Documento cargaDocumentoSinGuardar(final UploadedFile file, final TipoDocumento tipo, final Users usuario)
			throws PerException {
		try {
			return crearDocumento(file, tipo, usuario);
		}
		catch (IOException ex) {
			throw new PerException(ex);
		}
	}

	/**
	 * Crea el documento.
	 * @param file Fichero subido por el usuario.
	 * @param tipo Tipo de documento.
	 * @param inspeccion Inspección a la que se asocia.
	 * @return Documento generado
	 * @throws DataAccessException Excepción SQL
	 * @throws IOException Excepción entrada/salida
	 */
	private Documento crearDocumento(final UploadedFile file, final TipoDocumento tipo, final Users usuario)
			throws IOException {
		final Documento docu = new Documento();
		docu.setNombre(file.getFileName());
		docu.setTipoDocumento(tipo);
		if (usuario != null) {
			docu.setUsuario(usuario);
		}
		byte[] fileBlob = StreamUtils.copyToByteArray(file.getInputstream());
		final DocumentoBlob blob = new DocumentoBlob();
		blob.setFichero(fileBlob);
		blob.setNombreFichero(file.getFileName());
		docu.setFichero(blob);
		docu.setTipoContenido(file.getContentType());
		return docu;
	}

	/**
	 * Consulta el número de registros en base de datos que corresponden a los criterios de búsqueda.
	 * @param busqueda Objeto que contiene los criterios de búsqueda
	 * @return número de registros correspondientes a la búsqueda
	 */
	@Override
	public int getCounCriteria(final DocumentoBusqueda busqueda) {
		final Session session = sessionFactory.openSession();
		final Criteria criteria = session.createCriteria(Documento.class, "documento");
		creaCriteria(busqueda, criteria);
		criteria.setProjection(Projections.rowCount());
		final Long cnt = (Long) criteria.uniqueResult();
		session.close();
		return Math.toIntExact(cnt);
	}

	/**
	 * Consulta en base de datos en base a los parámetros recibidos. La consulta se hace paginada.
	 * 
	 * @param first Primer elemento a devolver de la búsqueda
	 * @param pageSize Número máximo de registros a mostrar
	 * @param sortField Campo por el cual se ordena la búsqueda
	 * @param sortOrder Sentido de la ordenación
	 * @param busquedaDocumento Objeto que contiene los criterios de búsqueda
	 * @return Lista de los documentos que corresponden a los criterios recibidos
	 * 
	 */
	@Override
	public List<Documento> buscarDocumentoPorCriteria(final int first, final int pageSize, final String sortField,
			final SortOrder sortOrder, final DocumentoBusqueda busquedaDocumento) {
		final Session session = sessionFactory.openSession();
		final Criteria criteriaDocumento = session.createCriteria(Documento.class, "documento");
		creaCriteria(busquedaDocumento, criteriaDocumento);
		Users usuario = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (busquedaDocumento.getUsuario() != null) {
			criteriaDocumento.createAlias("inspeccion", "inspecciones");
			criteriaDocumento.add(Restrictions.eq("inspecciones.id", busquedaDocumento.getUsuario().getUsername()));
		}
		prepararPaginacionOrdenCriteria(criteriaDocumento, first, pageSize, sortField, sortOrder, "id");
		@SuppressWarnings("unchecked")
		final List<Documento> listado = criteriaDocumento.list();
		session.close();
		return listado;
	}

	/**
	 * Añade al criteria los parámetros de búsqueda.
	 * @param busquedaDocumento Objeto que contiene los parámetros de búsqueda
	 * @param criteria Criteria al que se añadirán los parámetros.
	 */
	private void creaCriteria(final DocumentoBusqueda busquedaDocumento, final Criteria criteria) {

		if (busquedaDocumento.getFechaDesde() != null) {
			criteria.add(Restrictions.ge(Constantes.FECHAALTA, busquedaDocumento.getFechaDesde()));
		}
		if (busquedaDocumento.getFechaHasta() != null) {
			Date fechaHasta = new Date(busquedaDocumento.getFechaHasta().getTime() + TimeUnit.DAYS.toMillis(1));
			criteria.add(Restrictions.le(Constantes.FECHAALTA, fechaHasta));
		}
		if (busquedaDocumento.getNombre() != null) {
			criteria.add(Restrictions.ilike("nombre", busquedaDocumento.getNombre(), MatchMode.ANYWHERE));
		}
		if (busquedaDocumento.getTipoDocumento() != null) {
			criteria.add(Restrictions.eq("tipoDocumento", busquedaDocumento.getTipoDocumento()));
		}
		if (busquedaDocumento.isEliminado()) {
			criteria.add(Restrictions.isNotNull("fechaBaja"));
		}
		else {
			criteria.add(Restrictions.isNull("fechaBaja"));
		}
		if (busquedaDocumento.getDescripcion() != null) {
			criteria.add(Restrictions.ilike("descripcion", busquedaDocumento.getDescripcion(), MatchMode.ANYWHERE));
		}
		criteriaMateriaIndexada(criteria, busquedaDocumento.getMateriaIndexada());
	}

	/**
	 * Añade al criteria el filtro de la materia indexada introducida en el formulario.
	 * @param criteria Criteria al que se añadirán los parámetros.
	 * @param materiaIndexada materia indexada introducida en el filtro (separada por comas)
	 */
	private void criteriaMateriaIndexada(final Criteria criteria, final String materiaIndexada) {
		if (materiaIndexada != null) {
			final String[] claves = materiaIndexada.split(",");
			final Criterion[] clavesOr = new Criterion[claves.length];
			for (int i = 0; i < claves.length; i++) {
				clavesOr[i] = Restrictions.ilike("materiaIndexada", claves[i].trim(), MatchMode.ANYWHERE);
			}
			criteria.add(Restrictions.or(clavesOr));
		}
	}

	/**
	 * Devuelve el nombre del fichero contenido en el objeto Documento.
	 * @param documento del cual quiere extraerse el nombre del fichero contenido
	 * @return nombre del fichero
	 */
	@Override
	public String obtieneNombreFichero(final Documento documento) {
		final Documento docu = documentoRepository.findById(documento.getId());
		final DocumentoBlob doc = docu.getFichero();
		return doc.getNombreFichero();
	}

	/**
	 * Devuelve la lista de tipos de documentos.
	 * @return lista de tipos de documentos
	 */
	@Override
	public List<TipoDocumento> listaTiposDocumento() {
		return (List<TipoDocumento>) tipoDocumentoRepository.findAll();
	}

	/**
	 * Recupera un documento de la papelera.
	 * @param documento Es el documento a recuperar de la papelera
	 */
	@Override
	public void recuperarDocumento(final Documento documento) {
		documento.setDateDeleted(null);
		documento.setUserDeleted(null);
		save(documento);
	}

	/**
	 * Elimina todos los documentos almacenados en la papelera.
	 */
	@Override
	public List<Documento> vaciarPapelera() {
		final List<Documento> listaEliminar = documentoRepository.findByDateDeletedIsNotNull();
		documentoRepository.delete(listaEliminar);
		return listaEliminar;
	}

	/**
	 * Recupera un tipo de documento a partir de su nombre.
	 * @param nombre nombre del tipo
	 * @return tipo de documento
	 */
	@Override
	public TipoDocumento buscaTipoDocumentoPorNombre(final String nombre) {
		return tipoDocumentoRepository.findByNombre(nombre);
	}

	/**
	 * Devuelve los documentos que corresponden a un tipo de documento.
	 * @param tipoDocumento Nombre del tipo de documento
	 * @return Listado de documentos
	 */
	@Override
	public List<Documento> buscaNombreTipoDocumento(final String tipoDocumento) {
		return documentoRepository.buscaNombreTipoDocumento(tipoDocumento);
	}

	/**
	 * Prepara el criteria pasado como parámetro para la paginación de Primefaces.
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
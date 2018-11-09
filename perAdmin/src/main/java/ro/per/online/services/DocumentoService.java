package ro.per.online.services;

import java.util.List;

import org.hibernate.Criteria;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;

import ro.per.online.exceptions.PerException;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.TipoDocumento;
import ro.per.online.persistence.entities.Users;
import ro.per.online.web.beans.gd.DocumentoBusqueda;

/**
 * Interfața serviciului Documente.
 * 
 * @author STAD
 *
 */
public interface DocumentoService {

	/**
	 * Returnează documentele care corespund tipului de document.
	 * @param tipoDocumento Numele tipului de document
	 * @return Lista documentelor
	 */
	List<Documento> buscaNombreTipoDocumento(String tipoDocumento);

	/**
	 * Consulta en base de datos en base a los parámetros recibidos. La consulta se hace paginada. Cautare în baza de
	 * date pe baza parametrilor primiți. Rezultatul este paginat.
	 * @param first Primul element din căutare
	 * @param pageSize Numărul maxim de rezultate de afișat
	 * @param sortField Câmpul prin care se ordonează căutarea
	 * @param sortOrder ordine de sortare
	 * @param busqueda Obiect care conține criteriile de căutare
	 * @return Lista documentelor care corespund criteriilor primite
	 * 
	 */
	List<Documento> buscarDocumentoPorCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			DocumentoBusqueda busqueda);

	/**
	 * Recupereaza un tip de document după numele său.
	 * @param nombre numele tipului
	 * @return tipul documentului
	 */
	TipoDocumento buscaTipoDocumentoPorNombre(String nombre);

	/**
	 * Primește un fișier UploadedFile din care preia datele pentru a genera un document care va fi stocat în baza de
	 * date. Returnează documentul stocat
	 * @param file fișier pentru a încărca în DB
	 * @param tipo tipul de document
	 * @param usuario utilizator asociat cu documentul
	 * @return Documento documentul încărcat în baza de date
	 * @throws PerException Excepție posibilă
	 * 
	 */

	Documento cargaDocumento(UploadedFile file, TipoDocumento tipo, Users usuario) throws PerException;

	/**
	 * Primeste un fisier UploadedFile si datele necesare unui document general, dar nu-l stocheaza in baza de date.
	 * Doar lăsați obiectul gata să îl salveze.
	 * @param file fișier pentru a încărca în DB
	 * @param tipo tipul de document
	 * @param usuario utilizator asociat cu documentul
	 * @return documento documentul încărcat în baza de date
	 * @throws PerException Excepție posibilă
	 */
	Documento cargaDocumentoSinGuardar(UploadedFile file, TipoDocumento tipo, Users usuario) throws PerException;

	/**
	 * Eliminare de documente din baza de date. Documentul care trebuie eliminat este primit ca parametru.
	 * @param entity Documento pentru eliminare
	 * 
	 */

	void delete(Documento entity);

	/**
	 * Primiți un document ca parametru și returnați un stream(flux) pentru a efectua descărcarea.
	 * @param entity Document pentru descărcare
	 * @return DefaultStreamed Content Descărcați fluxul
	 * @throws PerException Excepție posibilă
	 */

	DefaultStreamedContent descargaDocumento(Documento entity) throws PerException;

	/**
	 * Primește id-ul unui document ca parametru și returnează un flux pentru efectuarea descărcării.
	 * @param id Id document pentru descărcare
	 * @return DefaultStreamedContent Descărcați fluxul
	 * @throws PerException Excepție posibilă
	 */

	DefaultStreamedContent descargaDocumento(Long id) throws PerException;

	/**
	 * Căutați toate documentele care au fost eliminate logic.
	 * @return Lista documentelor selectate
	 */

	List<Documento> findByFechaBajaIsNotNull();

	/**
	 * Căutați toate documentele care nu au fost eliminate logic.
	 * @return Lista documentelor selectate
	 */

	List<Documento> findByFechaBajaIsNull();

	/**
	 * Returnează un document localizat după id-ul său.
	 * @param id Identificatorul documentului
	 * @return Documento
	 */
	Documento findOne(Long id);

	/**
	 * Verificați numărul de înregistrări din baza de date care corespund criteriilor de căutare.
	 * @param busqueda Obiect care conține criteriile de căutare
	 * @return numărul de înregistrări corespunzătoare căutării
	 */
	int getCounCriteria(DocumentoBusqueda busqueda);

	/**
	 * Returnează lista tipurilor de documente.
	 * @return lista tipurilor de documente.
	 */
	List<TipoDocumento> listaTiposDocumento();

	/**
	 * Returnează numele fișierului conținut în obiectul Document.
	 * @param documentul din care doriți să extrageți numele fișierului conținut
	 * @return nume de fișier
	 */
	String obtieneNombreFichero(Documento documento);

	/**
	 * 
	 * @param criteria
	 * @param first
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @param defaultField
	 */
	void prepararPaginacionOrdenCriteria(Criteria criteria, int first, int pageSize, String sortField,
			SortOrder sortOrder, String defaultField);

	/**
	 * Preluați un document din coșul de gunoi
	 * @param documento Documentul care trebuie recuperat din coșul de gunoi
	 */
	void recuperarDocumento(Documento documento);

	/**
	 * Salvați un document în baza de date. Ca parametru, primește documentul care trebuie salvat și returnează
	 * documentul salvat.
	 * @param entity Documento Document pentru salvare
	 * @return Documento Document salvat
	 */

	Documento save(Documento entity);

	/**
	 * Salvează documente în baza de date. Ca parametru, primește documentele care trebuie salvate și returnează
	 * documentele salvate.
	 * @param entities Documente de salvat
	 * @return Lista documentelor salvate
	 * 
	 */

	Iterable<Documento> save(Iterable<Documento> entities);

	/**
	 * Ștergeți toate documentele stocate în coșul de gunoi.
	 * @return Lista documentelor eliminate
	 */
	List<Documento> vaciarPapelera();

}

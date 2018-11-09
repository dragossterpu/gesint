package ro.per.online.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ro.per.online.persistence.entities.Documento;

/**
 * Repository de operațiuni de bază de date pentru entitatea documentului.
 * 
 * @author STAD
 *
 */
public interface IDocumentoRepository extends CrudRepository<Documento, Long> {

	/**
	 * Returnează documentele care corespund tipului de document.
	 * @param tipo Numele tipului de document
	 * @return Lista documentelor
	 */
	@Query("select a from Documento a, TipoDocumento b where a.tipoDocumento=b.id and b.nombre=?1")
	List<Documento> buscaNombreTipoDocumento(String tipo);

	/**
	 * Eliminați toate înregistrările a căror dată de eliminare nu este nulă.
	 */
	@Transactional(readOnly = false)
	void deleteByDateDeletedIsNotNull();

	/**
	 * Căutați toate documentele care nu au fost eliminate logic.
	 * @return Lista documentelor selectate
	 */
	List<Documento> findByDateDeletedIsNotNull();

	/**
	 * Căutați toate documentele care au fost eliminate logic.
	 * @return Lista documentelor selectate
	 */
	List<Documento> findByDateDeletedIsNull();

	/**
	 * Returnează un document localizat după id-ul său.
	 * @param id Long Identificatorul documentului
	 * @return Documentul Documento
	 */
	@EntityGraph(value = "Documento.fichero", type = EntityGraph.EntityGraphType.LOAD)
	Documento findById(Long id);

}

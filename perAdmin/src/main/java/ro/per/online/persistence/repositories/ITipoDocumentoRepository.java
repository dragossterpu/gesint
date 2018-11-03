package ro.per.online.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.per.online.persistence.entities.TipoDocumento;

/**
 * 
 * Repository cu operațiunile BDD pentru documentul de entitate TypeDocument.
 * 
 * @author STAD
 *
 */
public interface ITipoDocumentoRepository extends CrudRepository<TipoDocumento, Long> {

	/**
	 * Returnează de la BDD un obiect TypeDocument identificat prin numele său.
	 * @param nombre Numele tipului de document
	 * @return Obiectul stocat în baza de date
	 */
	TipoDocumento findByNombre(String nombre);

}

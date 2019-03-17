package ro.per.online.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.per.online.persistence.entities.Partid;
import ro.per.online.persistence.repositories.PartidRepository;
import ro.per.online.services.PartidService;

/**
 * Implementarea metodelor definite în interfața PartidService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class PartidServiceImpl implements PartidService, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Repository de Partid.
	 */
	@Autowired
	private transient PartidRepository partidRepository;

	/**
	 * Eliminarea unui partid
	 * @param partid
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(final Partid partid) {
		this.partidRepository.delete(partid);
	}

	/**
	 * Cauta toate partidele inregistrate
	 */
	@Override
	public List<Partid> fiindAll() {
		return (List<Partid>) partidRepository.findAll();
	}

	/**
	 * Salveaza o functie
	 * @param functie PTeam
	 * @return functie
	 */
	@Override
	@Transactional(readOnly = false)
	public Partid save(final Partid partid) {
		return partidRepository.save(partid);
	}

}

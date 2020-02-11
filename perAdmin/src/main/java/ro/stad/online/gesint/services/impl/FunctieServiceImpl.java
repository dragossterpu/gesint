package ro.per.online.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.per.online.persistence.entities.PTeam;
import ro.per.online.persistence.repositories.FunctieRepository;
import ro.per.online.services.FunctieService;

/**
 * Implementarea metodelor definite în interfața FunctieService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class FunctieServiceImpl implements FunctieService, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Repository de pteam.
	 */
	@Autowired
	private transient FunctieRepository functieRepository;

	/**
	 * Eliminarea unei functii
	 * @param functie
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(final PTeam functie) {
		this.functieRepository.delete(functie);
	}

	/**
	 * Cauta toate functiile inregistrate
	 */
	@Override
	public List<PTeam> fiindAll() {
		return (List<PTeam>) functieRepository.findAll();
	}

	/**
	 * Salveaza o functie
	 * @param functie PTeam
	 * @return functie
	 */
	@Override
	@Transactional(readOnly = false)
	public PTeam save(final PTeam functie) {
		return functieRepository.save(functie);
	}

}

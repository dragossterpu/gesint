package ro.per.online.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.per.online.persistence.entities.Optiune;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.repositories.OptiuneRepository;
import ro.per.online.services.OptiuneService;

/**
 * Implementarea metodelor definite în interfața OptiuneService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class OptiuneServiceImpl implements OptiuneService, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Repository de Optiune.
	 */
	@Autowired
	private transient OptiuneRepository optiuneRepository;

	/**
	 * Eliminarea unei optiuni
	 * @param optiune
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(final Optiune optiune) {
		this.optiuneRepository.delete(optiune);
	}

	/**
	 * Cauta toate optiunile inregistrate
	 * @return List<Optiune>)
	 */
	@Override
	public List<Optiune> fiindAll() {
		return (List<Optiune>) optiuneRepository.findAll();
	}

	/**
	 * Cauta toate optiunile inregistrate ale unui judet
	 * @return List<Optiune>)
	 */
	@Override
	public List<Optiune> findByCodeProvince(final PProvince code) {
		return (List<Optiune>) optiuneRepository.findByProvince(code);
	}

	/**
	 * Salveaza o optiune
	 * @param optiune PTeam
	 * @return optiune
	 */
	@Override
	@Transactional(readOnly = false)
	public Optiune save(final Optiune optiune) {
		return optiuneRepository.save(optiune);
	}
}

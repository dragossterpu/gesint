package ro.per.online.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.repositories.ProvinceRepository;
import ro.per.online.services.ProvinceService;

/**
 * Implementación del servicio de judete.
 *
 * @author STAD
 *
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

	/**
	 * Repositoriu de PProvince.
	 */
	@Autowired
	private ProvinceRepository provinceRepository;

	/**
	 * Devuelve toate judetele inregistrate in baza de date.
	 * @return lista de judete
	 */
	@Override
	public List<PProvince> fiindAll() {
		return (ArrayList<PProvince>) provinceRepository.findAll();
	}

	@Override
	public PProvince fiindOne(PProvince province) {
		this.provinceRepository.findOne(province.getId());
		return province;
	}

	@Override
	public PProvince findById(Long province) {
		return provinceRepository.findOne(province);
	}

}

package ro.per.online.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	/**
	 * Cauta un judet
	 * @param province Judetul
	 * @return PProvince province
	 */
	@Override
	public PProvince fiindOne(final PProvince province) {
		provinceRepository.findOne(province.getIndicator());
		return province;
	}

	/**
	 * Cauta un judet dupa id
	 * @param province Judetul
	 * @return PProvince province
	 */
	@Override
	public PProvince findById(final String province) {
		return provinceRepository.findOne(province);
	}

	/**
	 * @param descripción
	 * @see ro.per.online.services.ProvinceService#findByName(java.lang.String)
	 * @retur provincia
	 */
	@Override
	public PProvince findByName(final String descripcion) {
		return provinceRepository.findByName(descripcion);
	}

	/**
	 * Salvați un judet
	 * @param judet PProvince
	 * @return judetul actualizat
	 */
	@Override
	@Transactional(readOnly = false)
	public PProvince save(final PProvince judet) {
		return provinceRepository.save(judet);
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
	public PProvince cargaImagenSinGuardar(final byte[] file, final PProvince judet) throws IOException {
		return crearImagen(file, judet);
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
	private PProvince crearImagen(final byte[] file, final PProvince judet) throws IOException {
		cargarDatosPersonaleUser(file, judet);
		provinceRepository.save(judet);
		return judet;
	}

	/**
	 * Incarcam fotografia judetului
	 * @param provincia
	 * @return PProvince judet
	 */
	private void cargarDatosPersonaleUser(final byte[] fileBlob, final PProvince judet) {
		judet.setPhoto(fileBlob);
	}
}

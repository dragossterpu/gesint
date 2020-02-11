package ro.per.online.services;

import java.io.IOException;
import java.util.List;

import ro.per.online.persistence.entities.PProvince;

/**
 * Interfață pentru serviciul de PProvince.
 *
 * @author STAD
 *
 */
public interface ProvinceService {

	/**
	 * Cauta toate judetele
	 *
	 * @return lista de judete.
	 */
	List<PProvince> fiindAll();

	/**
	 * Cauta un judet
	 * @param province Judetul
	 * @return PProvince province
	 */
	PProvince fiindOne(PProvince province);

	/**
	 * Cauta un judet
	 * @param string Judetul
	 * @return PProvince province
	 */
	PProvince findById(String string);

	/**
	 * @param descripción
	 * @return PProvince provincia
	 *
	 */
	PProvince findByName(String descripcion);

	/**
	 * Inregistreaza un judet.
	 * @param judetul PProvince
	 * @return judetulul actualizat
	 */
	PProvince save(PProvince judetul);

	/**
	 * Incarcam fotografia unui judet.
	 * @param PProvince judetul
	 * @throws IOException
	 */

	PProvince cargaImagenSinGuardar(byte[] bs, PProvince judetul) throws IOException;
}

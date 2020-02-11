package ro.per.online.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.per.online.constantes.Constantes;
import ro.per.online.persistence.entities.Propriedades;
import ro.per.online.persistence.repositories.PropriedadRepository;
import ro.per.online.services.PropriedadService;

/**
 * Implementación del servicio de centros.
 * 
 * @author STAD
 */

@Service
public class PropriedadServiceImpl implements PropriedadService {

	/**
	 * Variable utilizada para inyectar el repositorio de propriedades.
	 */
	@Autowired
	private PropriedadRepository propriedadesRepository;

	/**
	 * Devuelve todos los parametros de conexión al servidor de correo.
	 * @return List<Propriedades>
	 * @see net.atos.mira.elypse.bean.ApplicationBean.init(String)
	 */
	@Override
	public List<Propriedades> findByFilename(final String filename) {
		return propriedadesRepository.findByFilename(filename);
	}

	/**
	 * Devuelve el parametro que tenga el nombre proporcionado.
	 * @param nombreParametro String
	 * @return String
	 */
	@Override
	public String findOneByName(final String nombreParametro) {
		String valor = Constantes.ESPACIO;
		if (propriedadesRepository.findOneByName(nombreParametro) != null) {
			valor = propriedadesRepository.findOneByName(nombreParametro).getValue();
		}

		return valor;
	}
}

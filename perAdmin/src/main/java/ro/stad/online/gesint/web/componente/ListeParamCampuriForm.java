package ro.per.online.web.componentes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.services.LocalityService;
import ro.per.online.services.ProvinceService;

/**
 * Listas que se usarán como parámetros en combos.
 * @author STAD
 */
@Component
public class ListasParamCamposForm {

	/**
	 * Servicio de provincias.
	 */
	@Autowired
	private ProvinceService provinciaService;

	/**
	 * Servicio de localidades.
	 */
	@Autowired
	private LocalityService localidadService;

	/**
	 * Lista de localidades para una provincia.
	 * @param idProvincia Long provincia
	 * @return lista de localidades
	 */
	public List<PLocality> obtenerListaLocalidades(final Long idProvincia) {
		return localidadService.buscaByProvincia(idProvincia);
	}

	/**
	 * Lista de provincias.
	 * @return lista de provincias
	 */
	public List<PProvince> obtenerListaProvincias() {
		return provinciaService.fiindAll();
	}

}
package ro.per.online.web.componentes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.per.online.persistence.entities.PLocality;
import ro.per.online.persistence.entities.PProvince;

/**
 * Listas que se usarán como parámetros en combos.
 * @author Ezentis
 */
@Component
public class ListasParametros {

	/**
	 * Clase con listas paramétricas combos que contengan campos de formulario (sexo,unidades,acentos..).
	 */
	@Autowired
	private ListasParamCamposForm listasCamposForm;

	/**
	 * Lista de provincias.
	 * @return lista de provincias
	 */
	public List<PProvince> getListaProvincias() {
		return listasCamposForm.obtenerListaProvincias();
	}

	/**
	 * Lista de localidades para una provincia.
	 * @param idProvincia Long
	 * @return lista de localidades
	 */
	public List<PLocality> getListaLocalidades(final Long idProvincia) {
		List<PLocality> listaLocalidades;
		if (idProvincia != null) {
			listaLocalidades = listasCamposForm.obtenerListaLocalidades(idProvincia);
		}
		else {
			listaLocalidades = null;
		}
		return listaLocalidades;
	}

	// /**
	// * Lista de localidades para varias provincias.
	// * @param listaProvincias List<>
	// * @return lista de localidades
	// */
	// public List<PLocality> getListaLocalidadesMultiProv(final List<PLocality> listaProvincias) {
	// return listasCamposForm.obtenerListaLocalidadesMultiProv(listaProvincias);
	// }

	// /**
	// * Lista de países.
	// * @return lista de paises
	// */
	// public List<PCity> getListaPaises() {
	// return listasCamposForm.obtenerListaPaises();
	// }
	//
	// /**
	// * Lista de sexos.
	// * @return lista de sexos
	// */
	// public List<Sexo> getListaSexos() {
	// return listasCamposForm.obtenerListaSexos();
	// }

}
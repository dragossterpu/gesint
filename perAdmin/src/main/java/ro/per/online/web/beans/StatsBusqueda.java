package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;

/**
 * Controlador de las operaciones relacionadas con la búsqueda de estadísticas. Reseteo de valores de búsqueda.
 *
 * @author EZENTIS
 */
@Setter
@Getter
public class StatsBusqueda implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Campo de búsqueda tipo de usuario.
	 */
	private String tipoUsuario;

	/**
	 * Campo de búsqueda fecha desde.
	 */
	private Date fechaDesde;

	/**
	 * Campo de búsqueda fecha hasta.
	 */
	private Date fechaHasta;

	/**
	 * Tipo de agrupación: año, mes, día.
	 */
	private String tipoAgrupacion;

	/**
	 * Constructor de la búsqueda de estadísticas.
	 */
	public StatsBusqueda() {
		tipoAgrupacion = Constantes.ESPACIO;
	}

	/**
	 * Resetea los valores del formulario de búsqueda de estadísticas.
	 */
	public void resetValues() {
		setTipoUsuario(null);
		setFechaDesde(null);
		setFechaHasta(null);
		setTipoAgrupacion(null);
	}
}
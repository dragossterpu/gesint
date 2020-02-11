package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.enums.RegistroEnum;
import ro.per.online.persistence.entities.enums.SeccionesEnum;

/**
 * 
 * Bean para almacenar los criterios de búsqueda en el registro de actividad de la aplicación.
 * 
 * @author STAD
 * 
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistroBusqueda implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	/**
	 * Fecha desde la que se desea hacer la búsqueda.
	 */
	private Date fechaDesde;

	/**
	 * Fecha hasta la que se desea hacer la búsqueda.
	 */
	private Date fechaHasta;

	/**
	 * Sección para la que se desea hacer la búsqueda.
	 */
	private SeccionesEnum nombreSeccion;

	/**
	 * Username del usuario para el que se desea hacer la búsqueda.
	 */

	private String usernameRegActividad;

	/**
	 * Tipo de registro de la que se desea hacer la búsqueda.
	 */
	private RegistroEnum tipoRegActividad;

	/**
	 * Id del usuario que introdujo el registro de actividad.
	 */
	private String idUsuario;
}

package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.constantes.Constantes;

/**
 * Controlador de las operaciones relacionadas con la búsqueda de alertas. Reseteo de valores de búsqueda.
 *
 * @author STAD
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Controller("alertaBusquedaBean")
@Scope(Constantes.SESSION)
public class AlertaBusqueda implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID de alerta.
	 */
	private String id;

	/**
	 * Asunto de la alerta.
	 */
	private String asunto;

	/**
	 * Destinatario de la alerta.
	 */
	private String destinatario;

	/**
	 * Fecha desde envio de la alerta.
	 */
	private Date fechaDesdeEnvio;

	/**
	 * Fecha hasta envio de la alerta.
	 */
	private Date fechaHastaEnvio;

}

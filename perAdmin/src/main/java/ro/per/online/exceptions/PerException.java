package ro.per.online.exceptions;

/**
 * Excepción personalizada.
 * 
 * @author STAD
 *
 */
public class PerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje de la excepción.
	 */
	String mensaje;

	/**
	 * Excepción general.
	 * 
	 * @param e Excepción
	 */
	public PerException(final Exception e) {
		super(e);
		mensaje = e.getMessage();
	}

	/**
	 * Excepción general sin parámetros.
	 */

	public PerException() {
		super();
	}

	/**
	 * Sobreescritura del método getMessage() para mostrar el mensaje personalizado.
	 */
	@Override
	public String getMessage() {
		return mensaje;
	}

}

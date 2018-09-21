package ro.per.online.exceptions;

/**
 * Excepción personalizada.
 * 
 * @author STAD
 *
 */
public class ExcepcionRollback extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Excepción general.
	 * 
	 * @param e Excepción
	 */
	public ExcepcionRollback(Exception e) {
		super(e);
	}

	/**
	 * Excepción general sin parámetros.
	 */

	public ExcepcionRollback() {
		super();
	}

	/**
	 * Excepción con mensaje.
	 * 
	 * @param mensaje Mensaje que se mostrará al lanzar la excepción.
	 */
	public ExcepcionRollback(String mensaje) {
		super(mensaje);
	}

}

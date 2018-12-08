package ro.per.online.services;

import java.util.List;

import org.primefaces.model.SortOrder;

import ro.per.online.persistence.entities.RegistroActividad;
import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.SeccionesEnum;
import ro.per.online.web.beans.RegistroBusqueda;

/**
 * Interfață pentru serviciul de înregistrare a activităților.
 * @author STAD
 **/
public interface RegistroActividadService {

	/**
	 * Busca los registros realizados por un usuario.
	 *
	 * @param infoUsuario Usuario para el que se hace la consulta
	 * @return Listado de los registros resultantes
	 */
	List<String> buscarPorUsuarioRegistro(String infoUsuario);

	/**
	 * Busca registros de actividad según unos parámetros de forma paginada.
	 *
	 * @param first Primer elemento a mostrar
	 * @param pageSize Número máximo de registros recuperados
	 * @param sortField Campo de ordenación
	 * @param sortOrder Sentido de la ordenación
	 * @param regBusqueda Objeto que contiene los parámetros de búsqueda
	 * @return Listado de los registros que responden a la búsqueda
	 */

	List<RegistroActividad> buscarRegActividadCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			RegistroBusqueda regBusqueda);

	/**
	 * Devuelve el número total de registros de una búsqueda.
	 *
	 * @param busqueda Objeto que contiene los criterios de búsqueda
	 * @return Número de registros que responden a la búsqueda
	 */
	int getCounCriteria(RegistroBusqueda busqueda);

	/**
	 * Guarda un registro de alta/modificación del objeto.
	 * @param idObjeto Long
	 * @param descripcion String
	 * @param ambito String
	 * @param objeto String
	 */
	void guardarRegistroAltaModificacion(Long idObjeto, String descripcion, String ambito, String objeto);

	/**
	 * Guarda un registro de borrado del objeto.
	 * @param idObjeto Long
	 * @param descripcion String
	 * @param ambito String
	 * @param objeto String
	 */
	void guardarRegistroBorrado(Long idObjeto, String descripcion, String ambito, String objeto);

	/**
	 * Guarda un registro de actividad de tipo error.
	 * @param ambito String
	 * @param objeto String
	 * @param e Exception
	 */
	void guardarRegistroError(String ambito, String objeto, Exception e);

	/**
	 * Guarda en base de datos un registro de login del usuario indicado.
	 * @param usuario User
	 */
	void guardarRegistroLoginCorrecto(Users usuario);

	/**
	 * Guarda en base de datos un registro de login erroneo del usuario indicado.
	 * @param usuario String
	 */
	void guardarRegistroLoginErroneo(String usuario);

	/**
	 * Guarda en base de datos un registro de actividad.
	 *
	 * @param entity Registro a guardar en base de datos
	 */
	void save(RegistroActividad entity);

	/**
	 * Guarda en el registro de actividad el error que se ha producido.
	 * @param seccion Dónde se produce el error
	 * @param exception Excepción generada
	 */
	void registrarError(SeccionesEnum seccion, Exception exception);

	/**
	 * Guarda en base de datos un registro de actividad.
	 * @param seccion Sección en la que se produce la actividad
	 * @param tipo Tipo de actividad a registrar
	 * @param descripcion Descripción de la actividad
	 */
	void registrarActividad(SeccionesEnum seccion, String tipo, String descripcion);

}

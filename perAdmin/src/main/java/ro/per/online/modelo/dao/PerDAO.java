package ro.per.online.modelo.dao;

import javax.sql.DataSource;

/**
 * Interfață parentală care conține metodele comune de acces la date.
 *
 * @author STAD
 *
 */
public interface PerDAO {

	/**
	 * Metoda de atribuire a sursei de date.
	 *
	 * @param ds sursei de date
	 */
	public void setDataSource(DataSource ds);

}

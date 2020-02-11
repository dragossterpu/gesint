package ro.per.online.modelo.filters;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto de búsqueda de estadísticas de denuncias por provincia.
 *
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticaBusqueda implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7637962187780804682L;

	/**
	 * Fecha mínima de los resultados.
	 */
	private Date fechaDesde;

	/**
	 * Fecha fechaUltimAn.
	 */
	private Date fechaUltimAn;

	/**
	 * Fecha fechaUltimiDoiAni.
	 */
	private Date fechaUltimiDoiAni;

	/**
	 * Fecha fechaUltimiTreiAni.
	 */
	private Date fechaUltimiTreiAni;

	/**
	 * Fecha fechaUltimiPatruAni.
	 */
	private Date fechaUltimiPatruAni;

	/**
	 * Fecha fechaUltimiCinciAni.
	 */
	private Date fechaUltimiCinciAni;

	/**
	 * Fecha fechaUltimaLuna.
	 */
	private Date fechaUltimaLuna;

	/**
	 * Fecha fechaUltimDouaLuni.
	 */
	private Date fechaUltimDouaLuni;

	/**
	 * Fecha fechaUltimTreiLuni.
	 */
	private Date fechaUltimTreiLuni;

	/**
	 * Fecha fechaUltimPatruLuni.
	 */
	private Date fechaUltimPatruLuni;

	/**
	 * Fecha fechaUltimCinciLuni.
	 */
	private Date fechaUltimCinciLuni;

	/**
	 * Fecha fechaUltimSaseLuni.
	 */
	private Date fechaUltimSaseLuni;

	/**
	 * Fecha fechaUltimSapteLuni.
	 */
	private Date fechaUltimSapteLuni;

	/**
	 * Fecha fechaUltimOptLuni.
	 */
	private Date fechaUltimOptLuni;

	/**
	 * Fecha fechaUltimNouaLuni.
	 */
	private Date fechaUltimNouaLuni;

	/**
	 * Fecha fechaUltimZeceLuni.
	 */
	private Date fechaUltimZeceLuni;

	/**
	 * Fecha fechaUltimUnspeLuni.
	 */
	private Date fechaUltimUnspeLuni;

	/**
	 * Fecha fechaUltimaLunaAnTrecut.
	 */
	private Date fechaUltimaLunaAnTrecut;

	/**
	 * Fecha fechaUltimDouaLuniAnTrecut.
	 */
	private Date fechaUltimDouaLuniAnTrecut;

	/**
	 * Fecha fechaUltimTreiLuniAnTrecut.
	 */
	private Date fechaUltimTreiLuniAnTrecut;

	/**
	 * Fecha fechaUltimPatruLuniAnTrecut.
	 */
	private Date fechaUltimPatruLuniAnTrecut;

	/**
	 * Fecha fechaUltimCinciLuniAnTrecut.
	 */
	private Date fechaUltimCinciLuniAnTrecut;

	/**
	 * Fecha fechaUltimSaseLuniAnTrecut.
	 */
	private Date fechaUltimSaseLuniAnTrecut;

	/**
	 * Fecha fechaUltimSapteLuniAnTrecut.
	 */
	private Date fechaUltimSapteLuniAnTrecut;

	/**
	 * Fecha fechaUltimOptLuniAnTrecut.
	 */
	private Date fechaUltimOptLuniAnTrecut;

	/**
	 * Fecha fechaUltimNouaLuniAnTrecut.
	 */
	private Date fechaUltimNouaLuniAnTrecut;

	/**
	 * Fecha fechaUltimZeceLuniAnTrecut.
	 */
	private Date fechaUltimZeceLuniAnTrecut;

	/**
	 * Fecha fechaUltimUnspeLuniAnTrecut.
	 */
	private Date fechaUltimUnspeLuniAnTrecut;

	/**
	 * Fecha fechaPana25.
	 */
	private Date fechaPana25;

	/**
	 * Fecha fechaPana40.
	 */
	private Date fechaPana40;

	/**
	 * Fecha fechaPana60.
	 */
	private Date fechaPana60;
}

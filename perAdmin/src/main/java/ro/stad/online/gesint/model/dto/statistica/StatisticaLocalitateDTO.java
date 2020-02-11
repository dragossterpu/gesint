package ro.per.online.modelo.dto.estadisticas;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase DTO que contiene el resultado de una fila perteneciente a estadisticas de denuncias por provincia.
 *
 * @author EZENTIS
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StatisticaLocalitateDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5468840743886693413L;

	/**
	 * nume.
	 */
	private String numeProvincie;

	/**
	 * code.
	 */
	private String codeProvincie;

	/**
	 * nume.
	 */
	private String numeLocalitate;

	/**
	 * sector.
	 */
	private String sector;

	/**
	 * totalLocuitori.
	 */
	private Integer totalLocuitori;

	/**
	 * totalMembrii.
	 */
	private Integer totalMembrii;

	/**
	 * totalLocuitori.
	 */
	private Integer locuitoriVot;

	/**
	 * numarMembrii.
	 */
	private Integer numarMembrii;

	/**
	 * procentaj.
	 */
	private Float procentaj;

	/**
	 * nume.
	 */
	private String valoare;

	/**
	 * eticheta.
	 */
	private String eticheta;

	/**
	 * membriiMinim.
	 */
	private Integer membriiMinim;

	/**
	 * voturiMinim.
	 */
	private Integer voturiMinim;
}

package ro.mira.peronline.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * Entitate parametrica para el almacenamiento de o functie.
 *
 * @author STAD
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")
@Builder
@Getter
@Setter
@Entity
@Table(name = "TEAM")
public class Team implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8133415273601486902L;

	/**
	 * Id.
	 */
	@Id
	@Column(name = "ID")
	private Long id;

	/**
	 * Utilizator.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	private Users user;

	/**
	 * Echipa.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	private PTeam team;

	/**
	 * Ordinea de aparitie.
	 */
	@Column(name = "RANK", length = 2, nullable = false)
	private Long rank;

}

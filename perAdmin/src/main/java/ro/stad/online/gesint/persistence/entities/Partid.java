package ro.per.online.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.enums.DaNuEnum;

/**
 *
 * Entitate parametrica pentru partide.
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
@Table(name = "PARTID")
public class Partid implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8133415273601486902L;

	/**
	 * ID TEAM.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_partid")
	@SequenceGenerator(name = "seq_partid", sequenceName = "seq_partid", allocationSize = 1)
	@Column(name = "ID", length = 5)
	private Long id;

	/**
	 * Sigla formatiunii politice.
	 */
	@Column(name = "SIGLA", length = 7)
	private String sigla;

	/**
	 * Numele formatiunii politice.
	 */
	@Column(name = "NUME", length = 100)
	private String name;

	/**
	 * Numele vechi al formatiunii politice.
	 */
	@Column(name = "OLD_NUME", length = 100)
	private String oldName;

	/**
	 * Independent.
	 */
	@Column(name = "INDEPENDENT")
	@Enumerated(EnumType.STRING)
	private DaNuEnum independent;

	/**
	 * Rezultatele alegerilor.
	 */
	@ManyToOne
	@JoinColumn(name = "rezultate")
	private RezultateAlegeri rezultate;

	/**
	 * Lista de judete rezultate la alegeri
	 */
	@OneToMany(mappedBy = "partid", fetch = FetchType.LAZY)
	private List<PartidRezultateJudete> rezultatJudeteList;

	/**
	 * Utilizator care elimina un registru
	 */
	@Column(name = "user_deleted", length = 250)
	private String userDeleted;

	/**
	 * Data eliminarii.
	 */
	@Column(name = "date_deleted")
	private Date dateDeleted;
}

package ro.per.online.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.enums.TipAlegeriEnum;

/**
 *
 * Entitate pentru rezultate alegeri pe judet ale partidelor.
 *
 * @author STAD
 *
 */
@TypeDefs({ @TypeDef(name = "double precision", typeClass = java.lang.Float.class) })
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")
@Builder
@Getter
@Setter
@Entity
@Table(name = "PARTID_REZULTAT_JUDET")
public class PartidRezultateJudete implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8133415273601486902L;

	/**
	 * ID TEAM.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_partid_judet")
	@SequenceGenerator(name = "seq_partid_judet", sequenceName = "seq_partid_judet", allocationSize = 1)
	@Column(name = "ID", length = 5)
	private Long id;

	/**
	 * Tipul de alegeri.
	 */
	@Column(name = "tipAlegeri")
	@Enumerated(EnumType.STRING)
	private TipAlegeriEnum tipAlegeri;

	/**
	 * Data alegerilor.
	 */
	@Column(name = "dataAlegerilor")
	private Date dataAlegerilor;

	/**
	 * Numarul total de voturi.
	 */
	@Column(name = "TOTALVOTURI")
	private Long totalVoturi;

	/**
	 * Procentaj total de voturi.
	 */
	@Column(name = "PROCENTAJTOTALVOTURI")
	private Float procentajTotal;

	/**
	 * Procentaj total de voturi.
	 */
	@OneToOne
	@JoinColumn(name = "PARTID", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_U_PARTID"))
	private Partid partid;

	/**
	 * Judetul.
	 */
	@OneToOne
	@JoinColumn(name = "ID_JUDET", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_U_PROVINCE"))
	private PProvince judetul;

}

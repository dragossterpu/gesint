package ro.per.online.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.persistence.entities.enums.TypeLocalityEnum;

/**
 *
 * Entitate parametrica pentru localitatile unui judet.
 *
 * @author STAD
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
@Getter
@Setter
@Entity
@Table(name = "PLOCALITY")
public class PLocality implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8133415273601486902L;

	/**
	 * ID.
	 */
	@Id
	@SequenceGenerator(name = "seq_locality", sequenceName = "seq_locality", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locality")
	@Column(name = "id")
	private Long id;

	/**
	 * Numele localitatii.
	 */
	@Column(name = "NAME", length = 100, nullable = false)
	private String name;

	/**
	 * Tipul localitatii.
	 */
	@Column(name = "typelocality", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeLocalityEnum typelocality;

	/**
	 * Indicator.
	 */
	@Column(name = "RESIDENCE")
	private Boolean residence;

	/**
	 * Judetul localitatii.
	 */
	@ManyToOne
	@JoinColumn(name = "id_province", foreignKey = @ForeignKey(name = "FK_PROVINCE"), nullable = false)
	private PProvince province;

	/**
	 * Sectorul localitatii.
	 */
	@Column(name = "SECTOR", length = 10)
	private String sector;
}

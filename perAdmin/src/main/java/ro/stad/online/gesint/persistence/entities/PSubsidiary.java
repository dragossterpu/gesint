package ro.per.online.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * Entitate parametrica pentru filiale.
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
@Table(name = "PSUBSIDIARY")
public class PSubsidiary implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8133415273601486902L;

	/**
	 * ID.
	 */
	@Id
	@SequenceGenerator(name = "seq_subsidiary", sequenceName = "seq_subsidiary", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_subsidiary")
	@Column(name = "id")
	private Long id;

	/**
	 * Presedintele filialei.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	private Users user;

	/**
	 * Numele presedintelui de filiala.
	 */
	@Column(name = "NAME", length = 200)
	private String name;

	/**
	 * Judetul filialei.
	 */
	@ManyToOne
	@JoinColumn(name = "id_province", foreignKey = @ForeignKey(name = "FK_PROVINCE"), nullable = false)
	private PProvince province;

	/**
	 * Telefonul filialei.
	 */
	@Column(name = "MOBIL", length = 15)
	private String mobil;

	/**
	 * E-mailul filialei.
	 */
	@Column(name = "EMAIL", length = 50)
	private String email;

	/**
	 * Adresa filialei.
	 */
	@Column(name = "ADDRESS", length = 50)
	private String address;

	/**
	 * Telefonul filialei.
	 */
	@Column(name = "PHONEFAX", length = 40)
	private String phoneFax;
}

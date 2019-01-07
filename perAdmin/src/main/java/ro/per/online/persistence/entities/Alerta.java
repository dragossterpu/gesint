package ro.per.online.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.per.online.constantes.Constantes;

import ro.per.online.persistence.entities.enums.AlertChannelEnum;



/**
 * Entitate pentru alerte.
 * @author STAD
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")
@Builder
@ToString
@Getter
@Setter
@Entity@EntityListeners(AuditingEntityListener.class)
@Table(name = "ALERT")
public class Alerta extends AbstractEntity implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/** Identificator. */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "SEQ_ALERT", sequenceName = "SEQ_ALERT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ALERT")
	@Column(name = "ID", nullable = false, columnDefinition = Constantes.NUMERIC, length = 10)
	private Long id;

	/** Titlu. */
	@Column(name = "TITLU", nullable = false, length = 256)
	private String asunto;

	/** The body. */
	@Column(name = "BODY", nullable = false, length = 1024)
	private String descripcion;

	/**
	 * /** The channel. 
	 */
	@Column(name = "CHANNEL")
	@Enumerated(EnumType.STRING)
	private AlertChannelEnum channel;
	
	/** The body. */
	@Column(name = "TO_", nullable = false, length = 100)
	private String destinatario;

	/** The sended on. */
	@Column(name = "SENDED_ON", length = 19)
	private Date fechaEnvio;

	/** The businessman. */
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = true, unique = false)
	private Users usuario;

	/**
	 * Lista con los documentos asociados a la solicitud.
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "alerta_docs", joinColumns = @JoinColumn(name = "id_alerta"), inverseJoinColumns = @JoinColumn(name = "id_documento"))
	private List<Documento> documentos;
	
	/**
	 * Trimitere automatica.
	 */
	@Column(name = "auto")
	private Boolean automatic;

}

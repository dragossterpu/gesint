package ro.per.online.persistence.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitatea documentului. Orice fișier încărcat în aplicație este stocata în acesta tabla.
 *
 * @author STAD
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DOCUMENTOS")
public class Documento extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Identificatorul entității, generat prin secvență.
	 */
	@Id
	@SequenceGenerator(name = "SEQ_DOCUMENTOS", sequenceName = "SEQ_DOCUMENTOS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOCUMENTOS")
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * ContentType din fișierul atașat.
	 */
	@Column(name = "tipoContenido", nullable = false)
	private String tipoContenido;

	/**
	 * Numele documentului
	 */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Descriere.
	 */
	@Column(name = "descripcion", length = 2000)
	private String descripcion;

	/**
	 * Cuvinte cheie ale documentului.
	 */
	@Column(name = "materia_indexada", length = 2000)
	private String materiaIndexada;

	/**
	 * Tipul documentului
	 */
	@ManyToOne
	@JoinColumn(name = "tipoDocumento")
	private TipoDocumento tipoDocumento;

	/**
	 * Utilizatorul care publica proiectul
	 */
	@ManyToOne
	@JoinColumn(name = "username")
	private Users usuario;

	/**
	 * Document validat sau nu.
	 */
	@Column(name = "validated")
	private Boolean validated;

	/**
	 * Proiectul la care este atribuit documentul.
	 */
	@ManyToMany
	@JoinTable(name = "documentos_proiect", joinColumns = { @JoinColumn(name = "id_documento") }, inverseJoinColumns = {
			@JoinColumn(name = "id_proiect") })
	private List<Proiecte> proiect;

	/** The job instance. */
	@ManyToOne
	@JoinColumn(name = "alerta", nullable = true, unique = false)
	private Alerta alerta;

	/**
	 * Array de byte cu conținutul fișierului.
	 */
	@Lob
	@Column(name = "fichero")
	private byte[] fichero;

	/**
	 * Metoda care obține imaginea pentru previzualizare în cazul în care documentul este un tip de imagine..
	 * @return StreamedContent
	 */
	public StreamedContent getFile() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.fichero));
	}

}

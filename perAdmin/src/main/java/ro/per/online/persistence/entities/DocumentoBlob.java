package ro.per.online.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entitate pentru stocarea în baza de date a documentelor în format blob.
 * @author STAD
 */

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "documentosBlob")
public class DocumentoBlob implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificatorul entității, generat prin secvență.
	 */
	@Id
	@SequenceGenerator(name = "seq_documentosblob", sequenceName = "seq_documentosblob", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_documentosblob")
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * Nume fișier.
	 */
	@Column(name = "nombreFichero")
	private String nombreFichero;

	/**
	 * Array de byte cu conținutul fișierului.
	 */
	@Column(name = "fichero")
	@Lob
	private byte[] fichero;

}

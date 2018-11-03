package ro.per.online.persistence.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Entitate pentru proiecte.
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
@Table(name = "PROICTE")
public class Proiecte implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID .
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROICTE")
	@SequenceGenerator(name = "SEQ_PROICTE", sequenceName = "SEQ_PROICTE", allocationSize = 1)
	@Column(name = "id", length = 5)
	private Long id;

	/**
	 * String cu numele proiectului.
	 */
	@Column(name = "TITLU")
	private String titlu;

	/**
	 * Nombre.
	 */
	@Column(name = "TEXT", length = 4000)
	private String text;

	/**
	 * Validat
	 */
	@Column(name = "VALIDATED")
	private Boolean validated;

	/**
	 * Utilizatorul care publica proiectul
	 */
	@ManyToOne
	@JoinColumn(name = "username")
	private Users usuario;

	/**
	 * Fotoografia publicatie.
	 */
	@Column(name = "IMAGE")
	private byte[] image;

	/**
	 * Metoda care obține imaginea pentru previzualizare în cazul în care documentul este un tip de imagine.
	 * @return StreamedContent
	 */
	public StreamedContent getImageProject() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.image));
	}
}

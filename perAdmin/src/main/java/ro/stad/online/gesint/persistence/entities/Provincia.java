package ro.per.online.persistence.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Entitate parametrica pentru judete.
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
@Table(name = "PPROVINCE")
public class PProvince implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8133415273601486902L;

	/**
	 * Id.
	 */
	@Id
	@Column(name = "code_province")
	private String indicator;

	/**
	 * Numele judetului.
	 */
	@Column(name = "NAME", length = 100)
	private String name;

	/**
	 * Resedinta.
	 */
	@Column(name = "RESIDENCE", length = 100)
	private String residence;

	/**
	 * Populatie.
	 */
	@Column(name = "POPULATION")
	private Long population;

	/**
	 * Voturi minim.
	 */
	@Column(name = "voturi_minim")
	private Long voturiMinim;

	/**
	 * Membrii minim.
	 */
	@Column(name = "membrii_minim")
	private Long membriiMinim;

	/**
	 * Tari.
	 */
	@ManyToOne
	@JoinColumn(name = "code", foreignKey = @ForeignKey(name = "FK_COUNTRY"), nullable = false)
	private PCountry code;

	/**
	 * Fotoografia judet.
	 */
	private byte[] photo;

	/**
	 * Metoda care obține imaginea pentru previzualizare în cazul în care documentul este un tip de imagine..
	 * @return StreamedContent
	 */
	public StreamedContent getImageJudet() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.photo));
	}
}

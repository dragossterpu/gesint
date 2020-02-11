package ro.per.online.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * Entity para las propiedades de la aplicación.
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
@Table(name = "PROPERTIES")
public class Propriedades implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID Favorito.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROPERTIES")
	@SequenceGenerator(name = "SEQ_PROPERTIES", sequenceName = "SEQ_PROPERTIES", allocationSize = 1)
	@Column(name = "id", length = 5)
	private Long id;

	/**
	 * String con el nombre del grupo de propiedades.
	 */
	@Column(name = "FILENAME")
	private String filename;

	/**
	 * Nombre de la propiedad.
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * Valor de la propiedad.
	 */
	@Column(name = "VALUE")
	private String value;

	/**
	 * Breve descripción del registro de propriedad.
	 */
	@Column(name = "DESCRIPTION")
	private String descripcion;
}

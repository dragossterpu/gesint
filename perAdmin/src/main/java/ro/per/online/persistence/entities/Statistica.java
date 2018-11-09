package ro.per.online.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.per.online.persistence.entities.enums.RegistroEnum;
import ro.per.online.persistence.entities.enums.SeccionesEnum;

/**
 * Entitate pentru stocarea înregistrărilor de statistica în baza de date.
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
@Table(name = "STATISTICA")
public class Statistica implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador del registro, se genera por medio de una secuencia.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATISTICA")
	@SequenceGenerator(name = "SEQ_STATISTICA", sequenceName = "SEQ_STATISTICA", allocationSize = 1)
	@Column(name = "id", length = 10, columnDefinition = "NUMERIC")
	private Long idRegActividad;

	/**
	 * Nombre de la sección para la que se registra actividad.
	 */
	@Column(name = "NOMBRE_SECCION", length = 20)
	@Enumerated(EnumType.STRING)
	private SeccionesEnum nombreSeccion;

	/**
	 * Descripción del registro que se almacena.
	 */
	@Column(name = "DESCRIPCION")
	private String descripcion;

	/**
	 * Fecha en la que se da de alta el registro.
	 */
	@CreatedDate
	@Column(name = "FECHA_ALTA", nullable = false)
	private Date fechaAlta;

	/**
	 * Tipo del registro.
	 */
	@Column(name = "TIPO_REG_ACTIVIDAD", length = 10)
	@Enumerated(EnumType.STRING)
	private RegistroEnum tipoRegActividad;

}

package ro.per.online.persistence.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import lombok.ToString;
import ro.per.online.persistence.entities.enums.AlertChannelEnum;
import ro.per.online.persistence.entities.enums.CivilStatusEnum;
import ro.per.online.persistence.entities.enums.EducationEnum;
import ro.per.online.persistence.entities.enums.RoleEnum;
import ro.per.online.persistence.entities.enums.SexEnum;

/**
 *
 * Entidad para el almacenamiento de un Users.
 *
 * @author STAD
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "username")
@Builder
@ToString
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USERS")
public class Users extends AbstractEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7888266252869220306L;

	/**
	 * Login (ID).
	 */
	@Id
	@Column(name = "username", length = 150, nullable = false)
	private String username;

	/**
	 * Parola utilizatorlui.
	 */
	@Column(name = "password", length = 100, nullable = false)
	private String password;

	/**
	 * Rolul utilizatorlui.
	 */
	@Column(name = "role", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleEnum role;

	/**
	 * Numele utilizatorlui.
	 */
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	/**
	 * Prenumele utilizatorlui.
	 */
	@Column(name = "last_name", length = 100, nullable = false)
	private String lastName;

	/**
	 * Email.
	 */
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	/**
	 * Devuelve el nombre completo del usuario.
	 *
	 * @return Cadena formada por la concatenación de nombre y apellidos del usuario
	 */
	public String getNombreCompleto() {
		final StringBuilder nombreCompleto = new StringBuilder();
		nombreCompleto.append(name);
		nombreCompleto.append(' ');
		nombreCompleto.append(lastName);
		return nombreCompleto.toString();
	}

	/**
	 * Email personal.
	 */
	private String personalEmail;

	/**
	 * Cuerpo al que pertenece el usuario.
	 */
	@ManyToOne
	@JoinColumn(name = "code_province")
	private PProvince province;

	/**
	 * Localitatea.
	 */
	@ManyToOne
	@JoinColumn(name = "LOCALITY_ID", foreignKey = @ForeignKey(name = "FK_U_LOCALITY"))
	private PLocality locality;

	/**
	 * Telefonul.
	 */
	private String phone;

	/**
	 * Adresa.
	 */
	private String address;

	/**
	 * CNP utilizator.
	 */
	private String idCard;

	/**
	 * Numar buletin de identitate utilizator.
	 */
	private String numberCard;

	/**
	 * Data nasterii utilizator.
	 */
	private Date birthDate;

	/**
	 * Educatie utilizator.
	 */
	@Column(name = "education")
	@Enumerated(EnumType.STRING)
	private EducationEnum education;

	/**
	 * Canal de alertas del usuario.
	 */
	@Column(name = "alert_channel", length = 10)
	@Enumerated(EnumType.STRING)
	private AlertChannelEnum alertChannel;

	/**
	 * Loc de munca utilizator.
	 */
	private String workplace;

	/**
	 * Sex utilizator.
	 */
	@Column(name = "sex")
	@Enumerated(EnumType.STRING)
	private SexEnum sex;

	/**
	 * Stare civila utilizator.
	 */
	@Column(name = "civilStatus")
	@Enumerated(EnumType.STRING)
	private CivilStatusEnum civilStatus;

	/**
	 * Fotoografia utilizator.
	 */
	private byte[] photo;

	/**
	 * Utilizator validat.
	 */
	private Boolean validated;

	/**
	 * Destinatar Extern.
	 */
	private Boolean destinatarExtern;

	/**
	 * Metoda care obține imaginea pentru previzualizare în cazul în care documentul este un tip de imagine..
	 * @return StreamedContent
	 */
	public StreamedContent getImageUser() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.photo));
	}
}

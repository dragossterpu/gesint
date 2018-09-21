package ro.mira.peronline.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * Clasa abstracta para a evita duplicitatea in cod si in restulo de entity.
 *
 * @author STAD
 *
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5041785485043966367L;

	/**
	 * Utilizator de creatie.
	 */
	@Column(name = "user_create", length = 250)
	private String userCreate;

	/**
	 * Data de creatie.
	 */
	@Column(name = "date_create", nullable = false)
	private Date dateCreate;

	/**
	 * Utilizator care elimina un registru
	 */
	@Column(name = "user_deleted", length = 250)
	private String userDeleted;

	/**
	 * Data eliminarii.
	 */
	@Column(name = "date_deleted")
	private Date dateDeleted;

	/**
	 * Utilizator care modifica un registru
	 */
	@Column(name = "user_updated", length = 50)
	private String userUpdated;

	/**
	 * Data ultimei modificari
	 */
	@Column(name = "date_updated")
	private Date dateUpdated;

}

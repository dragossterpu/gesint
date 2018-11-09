package ro.per.online.persistence.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Alerte care pot fi selectate de utilizator pentru a primi notificări din diferite surse.
 * @author STAD
 *
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AlertChannelEnum {

	/**
	 * Tip de notificări care pot fi selectate de utilizator.
	 */
	EMAIL_SMS("EmailSms"),
	/**
	 * Email
	 */
	EMAIL("Email"),
	/**
	 * Sms
	 */
	SMS("Sms"),
	/**
	 * Fara canal de comunicare
	 */
	NO("No");

	/**
	 * Descrierea enumeratorului.
	 */
	private String descripcion;

}

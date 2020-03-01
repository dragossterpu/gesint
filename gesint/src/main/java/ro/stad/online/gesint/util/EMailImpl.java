package ro.stad.online.gesint.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.mitchellbosecke.pebble.error.PebbleException;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.EMailException;
import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.RegistruActivitateService;

/**
 * Implementarea clasei EMail.
 *
 * @author STAD
 *
 */
@Component("correoElectronico")
@Getter
@Slf4j
public class EMailImpl implements EMail {

	/**
	 * Serviciul de înregistrare a activității.
	 */
	@Autowired
	private RegistruActivitateService regActividadService;

	/**
	 * Session.
	 */
	private Session session;

	/**
	 * Metodă folosită pentru trimiterea corespondenței
	 * @param corespondenta Corespondenta
	 * @param utilizatoriSelectionati Utilizator
	 * @return dataTrimiteri Date
	 */
	@Override
	public Date send(final Corespondenta corespondenta, final List<Utilizator> utilizatoriSelectionati,
			final List<Documentul> documenteIncarcate, final String sablon, final Map<String, String> paramSablon)
			throws PebbleException {
		final Date dataTrimiteri = null;
		final String titlu = corespondenta.getTipCorespondenta().getDescription().concat(Constante.PUNCTSPATIU)
				.concat(corespondenta.getTitlu());
		final String body = corespondenta.getDescriere();
		String destinatar = Constante.SPATIU;
		if (!utilizatoriSelectionati.isEmpty()) {
			for (final Utilizator usu : utilizatoriSelectionati) {
				destinatar = usu.getUsername();
				try {
					trimitereMail(destinatar, titlu, body, documenteIncarcate, sablon, paramSablon);
				}
				catch (final IOException e) {
					FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
							RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
					final String descriere = "A apărut o eroare la trimiterea corespondenței";
					this.regActividadService.salveazaRegistruEroare(descriere,
							SectiuniEnum.CORESPONDENTA.getDescriere(), e);
				}

			}
		}

		return dataTrimiteri;
	}

	/**
	 * Metodă folosită pentru trimiterea corespondenței
	 * @param paramDestinnatar String
	 * @param paramtitlu String
	 * @param sablonEmailParola String
	 * @param paramSablon String
	 */
	@Override
	public void trimitereEmail(final String paramDestinatar, final String paramtitlu, final String sablonEmailParola,
			final Map<String, String> paramSablon) {
		try {
			trimitereMail(paramDestinatar, "Restabilire utilizator sau parola", null, null, sablonEmailParola,
					paramSablon);
		}
		catch (IOException | PebbleException e) {

		}

	}

	/**
	 * Metodă folosită pentru trimiterea de e-mailuri către unul sau mai mulți destinatari în format HTML cu sau fără
	 * atașamente.
	 * @param destinatar Lista de destinatari destinatar
	 * @param paramSablon Lista de destinatari in copie
	 * @param titlutitlu titlul email-ului
	 * @param body Descrierea corespondentei
	 * @param fisiereIncarcate List<Documentul>
	 * @param sablon String url-ul unde este sablonul pebble
	 * @throws IOException
	 * @throws PebbleException
	 */
	private void trimitereMail(final String destinatar, final String titlu, final String body,
			final List<Documentul> fisiereIncarcate, final String sablon, final Map<String, String> paramSablon)
			throws IOException, PebbleException {
		try {

			final Properties props = new Properties();
			// trimitere gmail
			props.setProperty("mail.smtp.host", "mail.gmail.com");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", NumarMagic.NUMBERTWENTYFIVE);
			props.put("mail.smtp.mail.sender", "dragossterpu@gmail.com");
			props.put("mail.smtp.user", "dragossterpu@gmail.com");
			props.put("mail.smtp.auth", "true");
			// server propriu
			// props.setProperty("mail.smtp.host", "mail.per.ro");
			// props.setProperty("mail.smtp.starttls.enable", "false");
			// props.setProperty("mail.transport.protocol", "smtp");
			// props.setProperty("mail.smtp.port", "26");
			// props.setProperty("mail.smtp.user", "dragos.sterpu@per.ro");
			// props.setProperty("mail.smtp.auth", "true");
			// props.put("mail.smtp.debug", "true");
			final Session session = Session.getDefaultInstance(props);
			// final Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			// server propriu
			// @Override
			// protected PasswordAuthentication getPasswordAuthentication() {
			// return new PasswordAuthentication("dragos.sterpu@per.ro", "xxxxxxx");
			// }
			// });
			final Map<String, Object> parametros = new HashMap<>();
			if (paramSablon != null) {
				parametros.putAll(paramSablon);
			}
			final MimeMessage message = new MimeMessage(session);
			final MimeMessageHelper helper = new MimeMessageHelper(message, true, Constante.UTF8);
			final String htmlContent = Utilitati.generarTextoConPlantilla(sablon, parametros);
			helper.setText(htmlContent, true);
			final List<File> listfila = new ArrayList<>();
			File tempFile = null;
			if (!fisiereIncarcate.isEmpty()) {
				for (final Documentul doc : fisiereIncarcate) {
					tempFile = File.createTempFile(doc.getNume(), null);
					listfila.add(tempFile);
				}

				for (final File adj : listfila) {
					helper.addAttachment(adj.getName(), adj);
				}
			}
			helper.setFrom(new InternetAddress("dragossterpu@gmail.com"));
			// message.setFrom(new InternetAddress("secretariat@per.ro"));
			message.addRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(destinatar) });
			message.setSubject(titlu);
			message.setFrom(new InternetAddress("dragossterpu@gmail.com"));
			// message.setText("blabla");
			final BodyPart texto = new MimeBodyPart();
			texto.setContent("text", "text/html");
			final Transport t = session.getTransport("smtp");
			t.connect((String) props.get("dragossterpu@gmail.com"), "xxxxxx");
			t.sendMessage(message, message.getAllRecipients());
			t.close();

			// final Transport t = session.getTransport("smtp");
			// t.connect("dragos.sterpu@per.ro", "Per20182018");
			// t.sendMessage(message, message.getAllRecipients());
			// t.close();
			if (!fisiereIncarcate.isEmpty() && tempFile != null) {
				tempFile.deleteOnExit();
			}
		}
		catch (MailException | MessagingException e) {
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, RegistruEnum.EROARE.getDescriere(),
					Constante.DESCEROAREMESAJ);
			log.error(RegistruEnum.EROARE.getDescriere().concat(" a aparut o eroare la trimiterea e-mailului"));
			throw new EMailException(e);
		}

	}
}

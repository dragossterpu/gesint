package ro.per.online.util;

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
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.mitchellbosecke.pebble.error.PebbleException;

import lombok.Getter;
import ro.per.online.constantes.Constantes;
import ro.per.online.exceptions.CorreoException;
import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Documento;
import ro.per.online.persistence.entities.Users;

/**
 * Implementación de la clase CorreoElectronico.
 *
 * @author STAD
 *
 */
@Component("correoElectronico")
@Getter
public class CorreoElectronicoImpl implements CorreoElectronico {

	/**
	 * Session.
	 */
	private transient Session session;

	/**
	 * Envío de correos a uno o varios destinatarios en formato html con o sin archivos adjuntos.
	 * @param destino Lista de destinatarios destinatario
	 * @param paramPlantilla Lista de destinatario en copia
	 * @param asunto Asunto del correo
	 * @param cuerpo Cuerpo del correo
	 * @param adjuntos Lista de ficheros adjuntos
	 * @param plantilla ruta del archivo de la plantilla pebble
	 * @param parametrosExtra parametros que se usan en la plantilla
	 * @throws IOException
	 * @throws PebbleException
	 * @throws CorreoException excepción al enviar el correo
	 */
	private void enviarCorreo(final String destino, final String asunto, final String cuerpo,
			final List<Documento> adjuntos, final String plantilla, final Map<String, String> paramPlantilla)
			throws IOException, PebbleException {
		try {

			final Properties props = new Properties();
			props.setProperty("mail.smtp.host", "mail.per.ro");
			props.setProperty("mail.smtp.starttls.enable", "false");
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.port", "26");
			props.setProperty("mail.smtp.user", "dragos.sterpu@per.ro");
			props.setProperty("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("dragos.sterpu@per.ro", "Per20182018");
				}
			});
			final Map<String, Object> parametros = new HashMap<>();
			if (paramPlantilla != null) {
				parametros.putAll(paramPlantilla);
			}
			final MimeMessage message = new MimeMessage(session);
			final MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			final String htmlContent = Utilities.generarTextoConPlantilla(plantilla, parametros);
			helper.setText(htmlContent, true);
			final List<File> listfila = new ArrayList<File>();
			File tempFile = null;
			if (!adjuntos.isEmpty()) {
				for (final Documento doc : adjuntos) {
					tempFile = File.createTempFile(doc.getNombre(), null);
					listfila.add(tempFile);
				}

				for (final File adj : listfila) {
					helper.addAttachment(adj.getName(), adj);
				}
			}
			helper.setFrom(new InternetAddress("secretariat@per.ro"));
			// message.setFrom(new InternetAddress("secretariat@per.ro"));
			message.addRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(destino) });
			message.setSubject(asunto);
			message.setFrom(new InternetAddress("secretariat@per.ro"));
			// message.setText("blabla");
			final BodyPart texto = new MimeBodyPart();
			texto.setContent("text", "text/html");
			final Transport t = session.getTransport("smtp");
			t.connect("dragos.sterpu@per.ro", "Per20182018");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			if (!adjuntos.isEmpty()) {
				tempFile.deleteOnExit();
			}
		}
		catch (MailException | MessagingException e) {
			throw new CorreoException(e);
		}

	}

	/**
	 * Envío de alerta.
	 * @param alerta Alerta
	 * @param usuario Users
	 * @return Date
	 * @throws PebbleException
	 */
	@Override
	public Date send(final Alerta alerta, final List<Users> usuariosSeleccionados,
			final List<Documento> documentosCargados, final String plantilla, final Map<String, String> paramPlantilla)
			throws PebbleException {
		final Date fechaEnvio = null;
		final String asunto = alerta.getTipAlerta().getDescription().concat(". ").concat(alerta.getAsunto());
		final String cuerpo = alerta.getDescripcion();
		String destino = Constantes.ESPACIO;
		if (!usuariosSeleccionados.isEmpty()) {
			for (final Users usu : usuariosSeleccionados) {
				destino = usu.getUsername();
				try {
					enviarCorreo(destino, asunto, cuerpo, documentosCargados, plantilla, paramPlantilla);
				}
				catch (final IOException e) {
					FacesUtilities.setMensajeConfirmacionDialog(FacesMessage.SEVERITY_ERROR, Constantes.ERRORMENSAJE,
							Constantes.DESCERRORMENSAJE);
				}

			}
		}

		return fechaEnvio;
	}
}

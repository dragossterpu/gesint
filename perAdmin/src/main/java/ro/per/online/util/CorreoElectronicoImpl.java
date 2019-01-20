package ro.per.online.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.Getter;
import ro.per.online.constantes.Constantes;
import ro.per.online.exceptions.CorreoException;
import ro.per.online.persistence.entities.Alerta;
import ro.per.online.persistence.entities.Users;
import ro.per.online.web.beans.ApplicationBean;

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
	 * Bean de configuración de la aplicación.
	 */
	@Autowired
	private ApplicationBean applicationBean;

	/**
	 * Servicio de envío de correo.
	 */
	@Autowired
	private JavaMailSenderImpl mailSender;

	/**
	 * Session.
	 */
	private transient Session session;

	/**
	 * Configura la conexión con el servidor de correo.
	 */
	@PostConstruct
	public void conexionServidor() {

		final Map<String, String> parametrosMail = applicationBean.getMapaParametrosMail();
		final Properties mailProperties = new Properties();
		final Iterator<Entry<String, String>> it = parametrosMail.entrySet().iterator();
		while (it.hasNext()) {
			final Map.Entry<String, String> param = it.next();
			mailProperties.put(param.getKey(), param.getValue());
		}
		mailSender.setJavaMailProperties(mailProperties);
	}

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
	 * @throws CorreoException excepción al enviar el correo
	 */
	private Date enviarCorreo(final String destino, final String conCopia, final String asunto, final String cuerpo,
			final List<File> adjuntos, final String plantilla, final Map<String, String> paramPlantilla)
			throws IOException {
		Date fechaEnvio = null;
		try {

			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "mail.per.ro");
			props.setProperty("mail.smtp.starttls.enable", "false");
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.port", "26");
			props.setProperty("mail.smtp.user", "dragos.sterpu@per.ro");
			props.setProperty("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("dragos.sterpu@per.ro", "Per20182018");
				}
			});

			MimeMessage message = new MimeMessage(session);
			final MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			message.setFrom(new InternetAddress("secretariat@per.ro"));
			message.addRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress("dragossterpu@gmail.com") });
			message.setSubject(asunto);
			message.setText("blabla");
			BodyPart texto = new MimeBodyPart();
			texto.setContent("text", "text/html");
			Transport t = session.getTransport("smtp");
			t.connect("dragos.sterpu@per.ro", "Per20182018");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			fechaEnvio = new Date();
		}
		catch (MailException | MessagingException e) {
			throw new CorreoException(e);
		}
		return fechaEnvio;
	}

	/**
	 * Envío de correos electrónico. Destinatarios, asunto, cuerpo del mensaje y los documentos adjuntos se reciben como
	 * parámetros
	 * @param paramDestino Destinatarios separados por ','
	 * @param paramAsunto Asunto del correo
	 * @param paramCuerpo Cuerpo del correo
	 * @param paramAdjunto Lista de ficheros adjuntos
	 * 
	 */
	@Override
	public Date envioCorreo(final String paramDestino, final Map<String, String> paramPlantilla,
			final String paramAsunto, final String paramCuerpo, final List<File> paramAdjunto) {
		final Date fechaEnvio = null;
		try {
			enviarCorreo(paramDestino, null, paramAsunto, paramCuerpo, paramAdjunto, Constantes.TEMPLATECORREOBASE,
					paramPlantilla);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaEnvio;
	}

	/**
	 * Envío de correos electrónico sin adjuntos. Destinatarios, asunto y cuerpo del mensaje se reciben como parámetros
	 * @param paramDestino Destinatarios separados por ','
	 * @param paramAsunto del correo
	 * @param paramCuerpo Cuerpo del correo
	 * 
	 */
	@Override
	public Date envioCorreo(final String paramDestino, final String paramAsunto, final String paramCuerpo) {
		final Date fechaEnvio = null;
		try {
			enviarCorreo(paramDestino, null, paramAsunto, paramCuerpo, null, Constantes.TEMPLATECORREOBASE, null);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaEnvio;
	}

	/**
	 * 
	 * Envío de correos electrónico sin adjuntos con plantilla personalizada. Destinatarios, asunto, datos del cuerpo
	 * del mensaje y ruta de la plantilla se reciben como parámetros
	 * @param paramDestino Destinatarios separados por ','
	 * @param paramAsunto del correo
	 * @param plantilla ruta del archivo de la plantilla pebble
	 * @param paramPlantilla parametros del cuerpo del correo que se usan en la plantilla
	 * 
	 */
	@Override
	public Date envioCorreo(final String paramDestino, final String paramAsunto, final String plantilla,
			final Map<String, String> paramPlantilla) {
		final Date fechaEnvio = null;
		try {
			enviarCorreo(paramDestino, null, paramAsunto, null, null, plantilla, paramPlantilla);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaEnvio;
	}

	/**
	 * 
	 * Envío de correos electrónico. Destinatarios, destinatarios en copia, asunto, cuerpo del mensaje y los documentos
	 * adjuntos se reciben como parámetros.
	 * 
	 * @param paramDestino Destinatarios separados por ','
	 * @param paramCC Destinatario en copia
	 * @param paramAsunto Asunto del correo
	 * @param paramCuerpo Cuerpo del correo
	 * @param paramAdjunto Lista de ficheros adjuntos
	 * 
	 */
	@Override
	public Date envioCorreo(final String paramDestino, final String paramCC, final String paramAsunto,
			final String paramCuerpo, final List<File> paramAdjunto) {
		final Date fechaEnvio = null;
		try {
			enviarCorreo(paramDestino, paramCC, paramAsunto, paramCuerpo, paramAdjunto, Constantes.TEMPLATECORREOBASE,
					null);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaEnvio;
	}

	/**
	 * Envío de alerta.
	 * @param alerta Alerta
	 * @param usuario Users
	 * @return Date
	 */
	@Override
	public Date send(final Alerta alerta, final Users usuario) {
		final String destino = usuario.getEmail();
		final String asunto = alerta.getAsunto();
		final String cuerpo = alerta.getDescripcion();
		final Date fechaEnvio = null;
		try {
			enviarCorreo(destino, null, asunto, cuerpo, null, null, null);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaEnvio;
	}
}

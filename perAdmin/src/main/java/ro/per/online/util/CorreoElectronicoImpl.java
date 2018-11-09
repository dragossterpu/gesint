package ro.per.online.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.mitchellbosecke.pebble.error.PebbleException;

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
	 * @throws CorreoException excepción al enviar el correo
	 */
	private Date enviarCorreo(final String destino, final String conCopia, final String asunto, final String cuerpo,
			final List<File> adjuntos, final String plantilla, final Map<String, String> paramPlantilla) {
		Date fechaEnvio = null;
		try {

			// Prepare message using a Spring helper
			final MimeMessage message = mailSender.createMimeMessage();
			final MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setTo("dragossterpu@gmail.com");
			// helper.setTo(destino.split(","));
			if (conCopia != null) {
				helper.setCc(conCopia.split(","));
			}
			helper.setSubject(asunto);

			final Map<String, Object> parametros = new HashMap<>();
			parametros.put("cuerpo", cuerpo);
			if (paramPlantilla != null) {
				parametros.putAll(paramPlantilla);
			}
			if ((plantilla != null) && (parametros != null)) {
				final String htmlContent = Utilities.generarTextoConPlantilla(plantilla, parametros);
				helper.setText(htmlContent, true);
			}
			final ClassPathResource imagen = new ClassPathResource(Constantes.IMGSISTEM);
			helper.addInline("imagenfirma", imagen.getFile());

			if (adjuntos != null) {
				for (final File adj : adjuntos) {
					helper.addAttachment(adj.getName(), adj);
				}
			}
			mailSender.setUsername("elypseinfo@gmail.com");
			// Set gmail email password
			mailSender.setPassword("elypse18");
			final Properties prop = mailSender.getJavaMailProperties();
			prop.put("mail.smtp.auth", true);
			prop.put("mail.smtp.ssl.trust", Constantes.SMTP);
			prop.put("mail.smtp.starttls.enable", true);
			prop.put("mail.smtp.host", Constantes.SMTP);
			prop.put("mail.smtp.port", "587");
			mailSender.send(message);
			fechaEnvio = new Date();
		}
		catch (MailException | MessagingException | IOException | PebbleException e) {
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
		enviarCorreo(paramDestino, null, paramAsunto, paramCuerpo, paramAdjunto, Constantes.TEMPLATECORREOBASE,
				paramPlantilla);
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
		enviarCorreo(paramDestino, null, paramAsunto, paramCuerpo, null, Constantes.TEMPLATECORREOBASE, null);
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
		enviarCorreo(paramDestino, null, paramAsunto, null, null, plantilla, paramPlantilla);
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
		enviarCorreo(paramDestino, paramCC, paramAsunto, paramCuerpo, paramAdjunto, Constantes.TEMPLATECORREOBASE,
				null);
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
		enviarCorreo(destino, null, asunto, cuerpo, null, null, null);
		return fechaEnvio;
	}
}

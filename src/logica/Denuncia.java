package logica;

import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Denuncia extends Correo {
	private static String usuario = "";
	private static String contrasenia = "";
	private String mensaje = "";
	private String destinatario = "";
	private String asunto = "";
	private String[] imagenes;
	
	public Denuncia(String usuario, String contrasenia, String mensaje, String[] imagenes, String destinatario, String asunto) {
		super(usuario, contrasenia, mensaje, destinatario, asunto);
		
		for (int i = 0; i < imagenes.length; i++) {
			this.imagenes[i] = imagenes[i];
		}
	}
	
	public boolean enviarCorreo() {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.starttls.enable", "true");
		
		Session sesion = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, contrasenia);
			}
		});

		try {
			Message message = new MimeMessage(sesion);
			BodyPart texto = new MimeBodyPart();
			BodyPart[] adjunto = new BodyPart[this.imagenes.length];
			MimeMultipart multiParte = new MimeMultipart();
			
			texto.setText(mensaje);
			multiParte.addBodyPart(texto);
			
			for (int i = 0; i < adjunto.length; i++) {
				adjunto[i].setDataHandler(new DataHandler(new FileDataSource(this.imagenes[i])));
				adjunto[i].setFileName("imagen_" + i);
				multiParte.addBodyPart(adjunto[i]);
			}

			message.setFrom(new InternetAddress(usuario));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject(asunto);
			message.setContent(multiParte);
			
			Transport.send(message);
			
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
}

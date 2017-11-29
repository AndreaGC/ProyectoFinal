package logica;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Correo {
	private static String usuario = "";
	private static String contrasenia = "";
	private String mensaje = "";
	private String destinatario = "";
	private String asunto = "";
	
	public Correo(String usuario, String contrasenia, String mensaje, String destinatario, String asunto) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.mensaje = mensaje;
		this.destinatario = destinatario;
		this.asunto = asunto;
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

			message.setFrom(new InternetAddress(usuario));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject(asunto);
			message.setText(mensaje);
			
			Transport.send(message);
			
			
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
}

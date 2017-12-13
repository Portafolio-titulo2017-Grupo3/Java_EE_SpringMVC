package com.orion.portafolio2017.component;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;


public class EnviarEmail {

	
	public static void enviarEmail(String emailDestino, int id_resolucion, String NombreFuncionario) {
		// TODO code application logic here
				String username = "munvista.hermosa@gmail.com";
				String password = "holamundo";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {
					// Creamos un nuevo mensaje, y le pasamos nuestra sesión
					// iniciada en el paso anterior.
					Message message = new MimeMessage(session);
					// Seteamos la dirección desde la cual enviaremos el mensaje
					message.setFrom(new InternetAddress("orantes19@gmail.com"));
					// Seteamos el destino de nuestro mensaje
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));
					// Seteamos el asunto
					message.setSubject("Resolución Solicitud de permiso");
					// Y por ultimo el texto.
					message.setText("Estimado/a "+NombreFuncionario+" , \n A través de este correo notificamos de que su solicitud de permiso N° "+String.valueOf(id_resolucion)+" ya fue resuelta. \n \n"
							+ "<a href='ec2-54-233-174-238.sa-east-1.compute.amazonaws.com:8081/orion'>Revisa en la web Oficial tu Resolución</a> ");
					// Esta orden envía el mensaje
					Transport.send(message);
					// Con esta imprimimos en consola que el mensaje fue enviado
					System.out.println("Mensaje Enviado");
				} catch (MessagingException e) {
					// Si existiera un error en el envío lo hacemos saber al cliente y lanzamos una
					// excepcion.
					System.out.println("Hubo un error al enviar el mensaje.");
					throw new RuntimeException(e);
				}
	}
	
	

	public static void main(String[] args) {
		
		EnviarEmail enviar= new EnviarEmail();
		String email="matias.sotomayor@gmail.com";
		enviar.enviarEmail(email,175,"El Feo, el Malo y el bueno");
		

	}
	
}

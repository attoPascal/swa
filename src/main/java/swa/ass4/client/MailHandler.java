package swa.ass4.client;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MailHandler {
	private static final String DEFAULT_HOSTNAME = "studentsmtp.swa.univie.ac.at";
	private static final String DEFAULT_USERNAME = "swa2014";
	private static final String DEFAULT_PASSWORD = "f9lHEQ62b2BfxeT";
	private static final String DEFAULT_FROM_ADDRESS = "grading@swa.univie.ac.at";

	private Session session;

	public MailHandler() {
		this(DEFAULT_HOSTNAME, DEFAULT_USERNAME, DEFAULT_PASSWORD, DEFAULT_FROM_ADDRESS);
	}

	public MailHandler(String hostname, final String username, final String password, String fromAddress) {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", hostname);
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.tls", "true");
		props.put("mail.smtp.user", username);
		props.put("mail.password", password);
		props.put("mail.from", fromAddress);

		Authenticator auth = new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};

		session = Session.getDefaultInstance(props, auth);
	}

	public void sendMessage(String recipient, String subject, String text) throws MessagingException {
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom();
		msg.setRecipients(Message.RecipientType.TO, recipient);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(text);
		Transport.send(msg);
	}
}

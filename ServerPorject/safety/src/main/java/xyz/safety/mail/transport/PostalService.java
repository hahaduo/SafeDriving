package xyz.safety.mail.transport;

import com.sun.mail.smtp.SMTPTransport;
import xyz.safety.mail.Email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Calendar;
import java.util.Properties;

public class PostalService {

	private static EmailTransportConfiguration emailTransportConfig = new EmailTransportConfiguration();
	private static Session session;

	public void send(Email email) throws AddressException, MessagingException {
		Message message = createMessage(email);
		send(message);
	}

	protected Session getSession() {
		if (session == null) {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", emailTransportConfig
					.getSmtpServer());
			properties.put("mail.smtp.auth", emailTransportConfig
					.isAuthenticationRequired());

			session = Session.getInstance(properties);
		}

		return session;
	}

	protected Message createMessage(Email email) throws MessagingException {
		Multipart multipart = new MimeMultipart();
		
		MimeBodyPart mimeText = new MimeBodyPart();
        if (email.getMailType() == 1) {
            mimeText.setText(email.getBody());
        }else if (email.getMailType() == 2) {
            mimeText.setContent(email.getBody(),"text/html;charset=utf-8");
        }
		multipart.addBodyPart(mimeText);

		Message message = new MimeMessage(getSession());
		message.setFrom(new InternetAddress(email.getFromAddress()));

		for (String to : email.getToAddresses()) {
			message.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(to));
		}

		for (String cc : email.getCcAddresses()) {
			message.setRecipients(Message.RecipientType.CC, InternetAddress
					.parse(cc));
		}

		for (String bcc : email.getBccAddresses()) {
			message.setRecipients(Message.RecipientType.BCC, InternetAddress
					.parse(bcc));
		}

		for (String attachment : email.getAttachments()) {
			MimeBodyPart mimeAttachment = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(attachment);
			mimeAttachment.setDataHandler(new DataHandler(fds));
			mimeAttachment.setFileName(fds.getName());
			multipart.addBodyPart(mimeAttachment);
		}

		message.setContent(multipart);
		message.setSubject(email.getSubject());
		message.setHeader("X-Mailer", "Fluent Mail API");
		message.setSentDate(Calendar.getInstance().getTime());

		return message;
	}

	protected void send(Message message) throws NoSuchProviderException,
			MessagingException {
		SMTPTransport smtpTransport = (SMTPTransport) getSession()
				.getTransport(getProtocol());
		if (emailTransportConfig.isAuthenticationRequired()) {
			smtpTransport.connect(emailTransportConfig.getSmtpServer(),
					emailTransportConfig.getUsername(), emailTransportConfig
							.getPassword());
		} else {
			smtpTransport.connect();
		}
		smtpTransport.sendMessage(message, message.getAllRecipients());
		smtpTransport.close();
	}

	protected String getProtocol() {
		String protocol = "smtp";
		if (emailTransportConfig.useSecureSmtp()) {
			protocol = "smtps";
		}
		return protocol;
	}
}

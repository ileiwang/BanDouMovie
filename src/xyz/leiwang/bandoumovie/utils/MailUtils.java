package xyz.leiwang.bandoumovie.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:49:12
*/
public class MailUtils {
	
	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@leiwang.xyz", "111");
			}
		};
		Session session = Session.getInstance(props, auth);
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress("service@leiwang.xyz"));

		message.setRecipient(RecipientType.TO, new InternetAddress(email));

		message.setSubject("”√ªßº§ªÓ");
		message.setContent(emailMsg, "text/html;charset=utf-8");
		Transport.send(message);
	}

}

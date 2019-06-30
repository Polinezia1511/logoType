package by.bsuir.logotype.service.impl;

import by.bsuir.logotype.entity.User;
import by.bsuir.logotype.service.MailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class DefaultMailService implements MailService {
    private static final String senderEmail = "p.z_1995@mail.ru";
    private static final String senderPassword = "HiDoggi95";
    private static final String REGISTRATION_MESSAGE = "<h2>LogoType</h2><div>Sign up successfully, password=%s</div>";
    private static final String SIGN_UP_TITLE = "Logo type sign up";

    @Override
    public void sendRegistrationMessage(User user) {
        try {
            String message = String.format(REGISTRATION_MESSAGE, user.getPassword());
            sendAsHtml(user.getEmail(), SIGN_UP_TITLE, message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void sendAsHtml(String to, String title, String html) throws MessagingException {
        System.out.println("Sending email to " + to);

        Session session = createSession();

        //create message using session
        MimeMessage message = new MimeMessage(session);
        prepareEmailMessage(message, to, title, html);

        //sending message
        Transport.send(message);
        System.out.println("Done");
    }

    private void prepareEmailMessage(MimeMessage message, String to, String title, String html)
            throws MessagingException {
        message.setContent(html, "text/html; charset=utf-8");
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(title);
    }

    private Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");//Outgoing server requires authentication
        props.put("mail.smtp.starttls.enable", "true");//TLS must be activated
        props.put("mail.smtp.host", "smtp.mail.ru"); //Outgoing server (SMTP)
        props.put("mail.smtp.port", "587");//Outgoing port

        return Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
    }
}

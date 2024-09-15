
package mailSender;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import mailConfig.MailConfig;

/**
 *
 * @author Sebastian
 */

public class MailSenderJava extends MailSenderStrategy {

    public MailSenderJava(MailConfig configuracion) {
        this.configuracion=configuracion;

    }

    @Override
    public boolean sendEmail(String remitente, String asunto, String mensaje, String emisor) {

        
        String puerto=String.valueOf(configuracion.getPort());
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put(configuracion.getEncryption(), "true");
        properties.put("mail.smtp.host", configuracion.getHost());
        properties.put("mail.smtp.port", puerto);

        // Crea una sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emisor, configuracion.getPassword());
            }
        });

        try {
            // Crea un mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emisor));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(remitente));
            message.setSubject(asunto);
            message.setText(mensaje);

            // Envía el correo
            Transport.send(message);

        } catch (MessagingException e) {
            return false;
        }
        return true;

    }
}

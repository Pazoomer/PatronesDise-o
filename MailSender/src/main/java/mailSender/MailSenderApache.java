
package mailSender;

import mailConfig.MailConfig;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author t1pas
 */
public class MailSenderApache extends MailSenderStrategy {

    public MailSenderApache(MailConfig configuracion) {
        this.configuracion = configuracion;

    }

    @Override
    public boolean sendEmail(String remitente, String asunto, String mensaje, String emisor) {
        org.apache.commons.mail.Email email = new HtmlEmail();
        try {
            
            //Si usa el host gmail u outlook
            email.setHostName(configuracion.getHost());
            //Si usa el cifrado STARTTLS o TLS
            email.setSmtpPort(configuracion.getPort());
            email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator(emisor, configuracion.getPassword()));

            if (configuracion.getPort() == 465) {
                email.setSSLOnConnect(true);
            } else if (configuracion.getPort() == 587) {
                email.setStartTLSRequired(true);
            }

            email.setFrom(emisor);
            email.setSubject(asunto);
            email.setMsg(mensaje);
            email.addTo(remitente);
            email.send();
        } catch (EmailException e) {
            return false;
        }
        return true;
    }

}


package mailSender;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.objects.Content;
import java.io.IOException;
import mailConfig.MailConfig;

/**
 *
 * @author t1pas
 */
public class MailSenderSengrid extends MailSenderStrategy {

    public MailSenderSengrid(MailConfig configuracion) {
        this.configuracion=configuracion;

    }

    @Override
    public boolean sendEmail(String remitente, String asunto, String mensaje, String emisor) {

        com.sendgrid.helpers.mail.objects.Email from = new com.sendgrid.helpers.mail.objects.Email(emisor);
        com.sendgrid.helpers.mail.objects.Email to = new com.sendgrid.helpers.mail.objects.Email(remitente);
        Content content = new Content("text/plain", mensaje);
        com.sendgrid.helpers.mail.Mail mail = new com.sendgrid.helpers.mail.Mail(from, asunto, to, content);

        SendGrid sg = new SendGrid(configuracion.getPassword());
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
}

package mailSender;

import mailConfig.MailConfig;

/**
 *
 * @author t1pas
 */
public abstract class MailSenderStrategy {

    protected MailConfig configuracion;

    public abstract boolean sendEmail(String remitente, String asunto, String mensaje, String emisor);
}

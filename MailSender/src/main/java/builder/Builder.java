
package builder;

import mailConfig.MailConfig;
import mailSender.MailSenderStrategy;

/**
 *
 * @author t1pas
 */
public abstract class Builder {
    protected MailSenderStrategy mailSender;
    
    public abstract boolean buildMailSenderStrategy(MailConfig configuracion);
    
    public abstract MailSenderStrategy getResult();
}

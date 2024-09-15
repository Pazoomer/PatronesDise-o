
package builder;

import mailConfig.MailConfig;
import mailSender.MailSenderApache;
import mailSender.MailSenderJava;
import mailSender.MailSenderSengrid;
import mailSender.MailSenderStrategy;

/**
 *
 * @author t1pas
 */
public class ConcreteBuilder extends Builder {

    @Override
    public boolean buildMailSenderStrategy(MailConfig configuracion) {
        // Construir una instancia de la estrategia de correo utilizando la configuración proporcionada
        if (configuracion.getProtocol().equalsIgnoreCase("Sengrid")) {
            this.mailSender = new MailSenderSengrid(configuracion);
        } else if (configuracion.getProtocol().equalsIgnoreCase("Java")) {
            this.mailSender = new MailSenderJava(configuracion);
        } else if (configuracion.getProtocol().equalsIgnoreCase("Apache")) {
            this.mailSender = new MailSenderApache(configuracion);
        }
        // Retornar true si la estrategia fue creada correctamente
        return this.mailSender != null;
    }

    @Override
    public MailSenderStrategy getResult() {
        return this.mailSender;
    }
    
}

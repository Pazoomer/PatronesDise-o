
package subsistema;

import builder.ConcreteBuilder;
import mailConfig.MailConfig;
import mailSender.MailSender;

/**
 *
 * @author t1pas
 */
public class ConectorMailSender implements SubsistemaMailSender {

    @Override
    public boolean enviarCorreo(String emisor, String remitente, String asunto, String mensaje,
            String protocol, String server, String host, String encryption, String password, int port) {

        // Crear mailConfig usando su builder
        MailConfig mailConfig = new MailConfig.MailConfigBuilder()
                .setProtocol(protocol)
                .setServer(server)
                .setHost(host)
                .setPort(port)
                .setEncryption(encryption)
                .setPassword(password)
                .build();

        // Crear MailSender usando su builder
        MailSender mailSender = new MailSender.MailSenderBuilder()
                .setBuilder(new ConcreteBuilder())
                .setMailConfig(mailConfig)
                .setEmisor(emisor)
                .setRemitente(remitente)
                .setAsunto(asunto)
                .setMensaje(mensaje)
                .build();

        // Enviar el correo y retornar el resultado
        return mailSender.sendEmail();
    }    
    
}

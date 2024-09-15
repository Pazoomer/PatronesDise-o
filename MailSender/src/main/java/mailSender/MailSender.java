
package mailSender;

import builder.Builder;
import mailConfig.MailConfig;

/**
 *
 * @author Sebastian
 */
public class MailSender {

    private final MailSenderStrategy mecanismo;
    private final String emisor;
    private final String remitente;
    private final String asunto;
    private final String mensaje;
    public MailSenderBuilder builder;
    
    public boolean sendEmail() {

        if (mecanismo != null && remitente != null && asunto != null && mensaje != null && emisor != null) {
            // Llamar al método sendEmail de la estrategia
            return mecanismo.sendEmail(remitente, asunto, mensaje, emisor);
        }
        return false; // Devuelve false si falta algún dato

    }

    private MailSender(MailSenderBuilder builder) {
        System.out.println(builder.mecanismo);
        this.mecanismo = builder.mecanismo;
        this.emisor = builder.emisor;
        this.remitente = builder.remitente;
        this.asunto = builder.asunto;
        this.mensaje = builder.mensaje;
        
    }
    
    public MailSenderStrategy getMailSenderStrategy(){
        return this.mecanismo;
    }
    
    public static class MailSenderBuilder {
        
        private Builder builder; 
        private MailSenderStrategy mecanismo;
        private String emisor;
        private String remitente;
        private String asunto;
        private String mensaje;
       
        public MailSenderBuilder setBuilder(Builder builder) {
            this.builder = builder;
            return this;
        }
        
        public MailSenderBuilder setMailConfig(MailConfig config) {
            // Usar el builder para construir el mecanismo
            if (this.builder != null) {
                this.builder.buildMailSenderStrategy(config);
                this.mecanismo = this.builder.getResult();
            }
            return this;
        }

        public MailSenderBuilder setEmisor(String emisor) {
            this.emisor = emisor;
            return this;
        }

        public MailSenderBuilder setRemitente(String remitente) {
            this.remitente = remitente;
            return this;
        }

        public MailSenderBuilder setAsunto(String asunto) {
            this.asunto = asunto;
            return this;
        }

        public MailSenderBuilder setMensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public MailSender build() {

            return new MailSender(this);
        }

    }

}

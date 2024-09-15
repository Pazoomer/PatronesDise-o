
package mailConfig;

/**
 *
 * @author t1pas
 */
public class MailConfig {
    // Metodo de envio
    private final String encryption;
    private final String host;
    private final int port;
    private final String password;
    private final String protocol;
    private final String server;
    
            
    public MailConfigBuilder builder;
    
     // Constructor privado para que solo el Builder pueda crear instancias
    private MailConfig(MailConfigBuilder builder) {
        this.encryption = builder.encryption;
        this.host = builder.host;
        this.port = builder.port;
        this.password = builder.password;
        this.protocol=builder.protocol;
        this.server=builder.server;
        
    }
    
    public String getServer(){
        return server;
    }
    
    public String getEncryption() {
        return encryption;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }
    
    public String getProtocol(){
        return protocol;
    }

    // Clase interna 'MailConfigBuilder'
    public static class MailConfigBuilder {

        private String encryption;
        private String host;
        private int port;
        private String password;
        private String protocol;
        private String server;

        public MailConfigBuilder setEncryption(String encryption) {
            this.encryption = encryption;
            return this;
        }
        
        public MailConfigBuilder setServer(String server) {
            this.server = server;
            return this;
        }

        public MailConfigBuilder setHost(String host) {
            this.host = host;
            return this;
        }

        public MailConfigBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public MailConfigBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        
        public MailConfigBuilder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        // Método para construir la instancia de MailConfig
        public MailConfig build() {
            return new MailConfig(this);
        }
    }
}

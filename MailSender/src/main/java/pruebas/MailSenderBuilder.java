/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

/**
 *
 * @author Sebastian
 */
public class MailSenderBuilder {

    private String protocolo;
    private String asunto;
    private String mensaje;
    private String remitente;
    private String destinatario;
    private String host;
    private String puerto;
    private String username;
    private String password;
    private String apiKey;

    public MailSenderBuilder setProtocolo(String protocolo) {
        this.protocolo = protocolo;
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

    public MailSenderBuilder setRemitente(String remitente) {
        this.remitente = remitente;
        return this;
    }

    public MailSenderBuilder setDestinatario(String destinatario) {
        this.destinatario = destinatario;
        return this;
    }

    public MailSenderBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public MailSenderBuilder setPuerto(String puerto) {
        this.puerto = puerto;
        return this;
    }

    public MailSenderBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public MailSenderBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public MailSenderBuilder setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public MailSender build() {
        switch (protocolo) {
            case "SMTP":
                return new MailSenderJava(asunto, mensaje, remitente, destinatario, host, puerto, username, password);
            default:
                throw new IllegalArgumentException("No soportado");
        }
    }
}

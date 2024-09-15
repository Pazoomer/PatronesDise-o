
package subsistema;

/**
 *
 * @author t1pas
 */
public interface SubsistemaMailSender {
    public boolean enviarCorreo(String emisor, String remitente, String asunto, String mensaje, 
                                String protocol, String server, String host, String encryption, String password, int port);
}

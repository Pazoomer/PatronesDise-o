package pruebas;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.objects.Content;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author t1pas
 */
public class MailSender {

    public static void main(String[] args) {
    
        //Email
        final String asunto="Testeo";
        final String mensaje="Ando testeando";
        //Cuenta
        final String username = "pruebapatrones@gmail.com";
        final String remitente= "pruebapatrones@gmail.com";
        //AQUI VA LA APIKEY, NO ME DEJA MANDARLA POR GITHUB POR QUE ES UN SECRETO
        final String apiKey="";
        //Protocolo
        String protocolo = "SMTP"; // SMTP O Sendgrid
        //Servidor
        String host = "smtp.office365.com"; // smtp.gmail.com O smtp.office365.com
        
        //Mecanismo Interno
        String mecanismoInterno = "java.mail.Api"; // java.mail.Api O Apache.Commnos.Mail
        //Metodo Cifrado
        Integer puertoN = 465; // 587 O 465
        String puerto = puertoN.toString();
        String cifrado = "mail.smtp.ssl.enable";
        switch (puerto) {
            case "587" ->
                cifrado = "mail.smtp.starttls.enable"; // STARTTLS
            case "465" ->
                cifrado = "mail.smtp.ssl.enable"; // SSL/TLS
        }
        String pass;
        if (host.equals("smtp.gmail.com")) {
            pass = "suft yhxw bxoz pjgd"; //suft yhxw bxoz pjgd O ssqarybljlnyugai
        } else {
            pass = "ssqarybljlnyugai"; //suft yhxw bxoz pjgd O ssqarybljlnyugai
        }
        final String password = pass;


        //Si usa el protocolo SMTP
        if (protocolo.equals("SMTP")) {
            
            //Si usa el mecanismo java.mail
            if (mecanismoInterno.equals("java.mail.Api")) {

                System.out.println("Usando java.mail.api");
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put(cifrado, "true");
                properties.put("mail.smtp.host", host); 
                properties.put("mail.smtp.port", puerto);

                // Crea una sesión con autenticación
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {
                    // Crea un mensaje
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(remitente));
                    message.setSubject(asunto);
                    message.setText(mensaje);

                    // Envía el correo
                    Transport.send(message);
                    System.out.println("Correo enviado exitosamente.");

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                
                
            } else {
                
                //Si usa el mecanismo apache.commnos
                System.out.println("Usando apache.commnos.mail");
                org.apache.commons.mail.Email email = new HtmlEmail();
                try {
                    
                    //Si usa el host gmail u outlook
                    email.setHostName(host);
                    //Si usa el cifrado STARTTLS o TLS
                    email.setSmtpPort(puertoN);
                    email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator(username, password));

                    if (puertoN == 465) {
                        email.setSSLOnConnect(true);
                    } else if (puertoN == 587) {
                        email.setStartTLSRequired(true);
                    }

                    email.setFrom(username);
                    email.setSubject(asunto);
                    email.setMsg(mensaje);
                    email.addTo(remitente); 
                    email.send();
                    System.out.println("Correo enviado exitosamente.");
                } catch (EmailException e) {
                    e.printStackTrace();
                }
            }
            
            
        } else {
            //si el protocolo sengrid
            com.sendgrid.helpers.mail.objects.Email from = new com.sendgrid.helpers.mail.objects.Email(username);
            com.sendgrid.helpers.mail.objects.Email to = new com.sendgrid.helpers.mail.objects.Email(remitente);
            Content content = new Content("text/plain", mensaje);
            com.sendgrid.helpers.mail.Mail mail = new com.sendgrid.helpers.mail.Mail(from, asunto, to, content);

            SendGrid sg = new SendGrid(apiKey);
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
                ex.printStackTrace();
            }
        }

    }
}

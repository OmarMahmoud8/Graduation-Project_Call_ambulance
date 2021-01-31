
package AnotherPackage;

import javax.ejb.Stateless;
import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.jms.Session;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;


@Stateless
public class MailSenderBean {

    public void  sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String message){
        
        try {
            String host ="smtp.gmail.com" ;
            //String user = "call.ambulance.app@gmail.com";
           // String pass = "01092665711";
            //String to = "mohamed.65527@yahoo.com";
           // String from = "call.ambulance.app@gmail.com";
            //String subject = "Application Test";
            //String messageText = "Hello from the other Side";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            javax.mail.Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(fromEmail));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(message);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, username, password);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
       
        
      
    }
    
}

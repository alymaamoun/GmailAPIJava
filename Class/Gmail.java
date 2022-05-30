/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gmail;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.activation.*;
import javax.mail.internet.MimeMessage;






public class Gmail {
    
    
    
        /*********************************put the used email and password here********************************************************/
        static String myAccoutEmail="xxxxxxxxxxxxxxxx";
        static String password="xxxxxxxxxxxxxxxxx";
        /****************************************************************************************************************************/
     public static void sendMail(String recepient,String subject,String content) throws Exception {
        System.out.println("processing sending");
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        

        
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(myAccoutEmail,password); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        Message message = prepareMessage(session,myAccoutEmail,recepient,subject,content);
         Transport.send(message);
         System.out.println("Message is send");
         }
         private static Message prepareMessage(Session session,String myAccoutEmail, String recepient,String subject,String content) {
             try
             {
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(myAccoutEmail));
             message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
             message.setSubject(subject);
             message.setText(content);
             return message;
             } catch (Exception ex) {
             java.util.logging.Logger.getLogger(Gmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }

             return null;
    }
    public static void main(String[] args) throws Exception {
        sendMail("aly.mammoun18@gmail.com","USEFUL API!","i used the API successfuly");
    }


    
}

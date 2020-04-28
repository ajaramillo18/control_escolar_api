/**
 * 
 */
package com.jama.api.service;

/**
 * @author ajara
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

 
@Service("emailService")
public class EmailService 
{
    @Autowired
    private JavaMailSender mailSender;
      
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
    
    @Value("${email.bcc}")
    String bcc;
    
  
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to, String subject, String body) 
    {
    	
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setBcc(bcc);
        mailSender.send(message);
    }
  
    /**
     * This method will send a pre-configured message
     * */
    public void sendPreConfiguredMail(String message) 
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
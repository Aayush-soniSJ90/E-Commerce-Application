package dev.ayush.EmailService.Consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ayush.EmailService.DTOs.SendMessageDTO;
import dev.ayush.EmailService.Utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

@Service
public class SendEmailConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void handleSendEmail(String message){
        try {
            SendMessageDTO sendMessageDTO=objectMapper.readValue(message, SendMessageDTO.class);


            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable
            props.put("mail.smtp.starttls.enable", "true");

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("rutwij0507.rg@gmail.com", "wleammatwkfglqog");
                }
            };

            Session session = Session.getInstance(props, auth);

            EmailUtil.sendEmail(session, sendMessageDTO.getTo(), sendMessageDTO.getSubject(), sendMessageDTO.getBody());


        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

    }


}

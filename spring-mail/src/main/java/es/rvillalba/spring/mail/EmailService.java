package es.rvillalba.spring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "spring.mail.host")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        if (to.contains(",")) {
            message.setTo(to.split(","));
        } else {
            message.setTo(to);
        }
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}

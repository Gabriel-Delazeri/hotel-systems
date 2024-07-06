package com.delazeri.notificationservice.consumer;

import com.delazeri.notificationservice.entities.Email;
import com.delazeri.notificationservice.enums.StatusEmail;
import com.delazeri.notificationservice.repositories.EmailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationConsumer {
    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = {"email-request-queue"})
    public void sendEmail(String payload) throws IOException {
        Email email = objectMapper.readValue(payload, Email.class);

        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            emailRepository.save(email);
        }
    }
}

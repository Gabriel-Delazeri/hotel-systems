package com.delazeri.notificationservice.producer;

import com.delazeri.notificationservice.entities.Email;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducer {
    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper;

    public void produceEmail(Email email) throws JsonProcessingException {
        String emailJson = objectMapper.writeValueAsString(email);
        amqpTemplate.convertAndSend("email-request-exchange", "email-request-rout-key", emailJson);
    }
}

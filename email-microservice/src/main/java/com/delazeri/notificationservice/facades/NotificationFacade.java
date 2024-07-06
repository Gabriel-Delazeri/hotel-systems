package com.delazeri.notificationservice.facades;

import com.delazeri.notificationservice.entities.Email;
import com.delazeri.notificationservice.producer.NotificationProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationFacade {
    private final NotificationProducer notificationProducer;

    public String sendEmail(Email email) {
        try {
            notificationProducer.produceEmail(email);
        } catch (JsonProcessingException e) {
            return "Error while sending email";
        }

        return "Processing email";
    }
}

package com.delazeri.reserveservice.services;

import com.delazeri.reserveservice.clients.NotificationClient;
import com.delazeri.reserveservice.dtos.requests.EmailRequestDto;
import com.delazeri.reserveservice.entities.Reserve;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationClient client;
    @Value("${notification.email.from}")
    private String emailFrom;

    @Async
    public void sentNotification(Reserve reserve) {
        String text = """
                Your reservation for %s has been successfully confirmed!
                We look forward to your arrival. For more information, please contact us.
                """.formatted(reserve.getDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        EmailRequestDto emailRequestDto = new EmailRequestDto(
                "Reservation of Hotel",
                "gbldelazeri@gmail.com",
                reserve.getGuest().getEmail(),
                "Reservation Confirmed",
                text
        );

        client.sendEmail(emailRequestDto);
    }
}

package com.delazeri.reserveservice.clients;

import com.delazeri.reserveservice.dtos.requests.EmailRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service-client", url = "${notification.api.url}")
public interface NotificationClient {
    @PostMapping("/send")
    void sendEmail(@RequestBody EmailRequestDto email);
}
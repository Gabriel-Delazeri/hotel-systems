package com.delazeri.notificationservice.controllers;

import com.delazeri.notificationservice.dtos.EmailDTO;
import com.delazeri.notificationservice.entities.Email;
import com.delazeri.notificationservice.facades.NotificationFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/emails")
public class EmailController {
    private final NotificationFacade facade;

    @PostMapping(value = "/send")
    public ResponseEntity<String> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);

        String message = this.facade.sendEmail(email);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}

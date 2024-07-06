package com.delazeri.notificationservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {

    @NotBlank(message = "required")
    private String ownerRef;
    @NotBlank(message = "required")
    @Email(message = "must be a valid email")
    private String emailFrom;
    @NotBlank(message = "required")
    @Email(message = "must be a valid email")
    private String emailTo;
    @NotBlank(message = "required")
    private String subject;
    @NotBlank(message = "required")
    private String text;
}

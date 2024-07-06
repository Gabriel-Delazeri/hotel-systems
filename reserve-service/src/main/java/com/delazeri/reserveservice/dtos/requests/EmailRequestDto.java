package com.delazeri.reserveservice.dtos.requests;

public record EmailRequestDto(
        String ownerRef,
        String emailFrom,
        String emailTo,
        String subject,
        String text
) {
}

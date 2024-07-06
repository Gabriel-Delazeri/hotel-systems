package com.delazeri.reserveservice.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ReserveRequestDto(
        String hotelId,
        LocalDate date,
        @JsonProperty(value = "guest") GuestRequestDto guestDto,
        @JsonProperty(value = "payment") PaymentRequestDto paymentDto
) {
}

package com.delazeri.reserveservice.dtos.requests;

import com.delazeri.reserveservice.enums.TypePayment;

public record PaymentRequestDto(
        double amount,
        TypePayment type
) {
}

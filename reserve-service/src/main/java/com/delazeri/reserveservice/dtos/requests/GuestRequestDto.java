package com.delazeri.reserveservice.dtos.requests;

public record GuestRequestDto(
        String document,
        String name,
        String email
) {
}

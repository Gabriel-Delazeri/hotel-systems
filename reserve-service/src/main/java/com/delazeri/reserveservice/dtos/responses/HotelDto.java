package com.delazeri.reserveservice.dtos.responses;

import java.util.List;

public record HotelDto(
        String id,
        String name,
        double price,
        int numberOfRooms,
        int capacities,
        List<String> amenities,
        double rating
) {
}

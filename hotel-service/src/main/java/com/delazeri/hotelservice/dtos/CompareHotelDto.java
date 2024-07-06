package com.delazeri.hotelservice.dtos;

import com.delazeri.hotelservice.enums.HotelCriterion;

import java.util.List;

public record CompareHotelDto(
        List<String> hotelIds,
        List<HotelCriterion> criteria,
        List<String> amenities
) {
}

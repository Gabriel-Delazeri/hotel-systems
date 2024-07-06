package com.delazeri.hotelservice.services;

import com.delazeri.hotelservice.entities.Hotel;
import com.delazeri.hotelservice.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public Page<Hotel> findAllFiltered(
            int numberOfRooms,
            int capacity,
            Pageable pageable
    ) {
        return this.hotelRepository
                .findAllByNumberOfRoomsGreaterThanAndCapacityGreaterThan(numberOfRooms, capacity, pageable);
    }

    public Hotel findById(String id) {
        return this.hotelRepository.findById(id).orElse(null);
    }
}

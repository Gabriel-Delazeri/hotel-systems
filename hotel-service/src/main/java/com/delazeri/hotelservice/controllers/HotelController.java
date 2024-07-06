package com.delazeri.hotelservice.controllers;

import com.delazeri.hotelservice.dtos.CompareHotelDto;
import com.delazeri.hotelservice.entities.Hotel;
import com.delazeri.hotelservice.services.HotelComparisonService;
import com.delazeri.hotelservice.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final HotelComparisonService hotelComparisonService;

    @GetMapping
    public ResponseEntity<Page<Hotel>> findAll(
            @RequestParam(name = "rooms", required = false, defaultValue = "1") int numberOfRooms,
            @RequestParam(name = "capacity", required = false, defaultValue = "1") int capacity,
            Pageable pageable
    ) {
        Page<Hotel> hotelsPageable = this.hotelService
                .findAllFiltered(numberOfRooms, capacity, pageable);

        return ResponseEntity.ok(hotelsPageable);
    }

    @PostMapping (value ="compare")
    ResponseEntity<Hotel> compare(@RequestBody CompareHotelDto request) {
        return ResponseEntity.ok(this.hotelComparisonService.compareHotels(request));
    }

    @GetMapping(value = "{id}")
    ResponseEntity<Hotel> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.hotelService.findById(id));
    }
}

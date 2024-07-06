package com.delazeri.reserveservice.controllers;

import com.delazeri.reserveservice.dtos.requests.ReserveRequestDto;
import com.delazeri.reserveservice.entities.Reserve;
import com.delazeri.reserveservice.services.ReserveService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/reserves")
@AllArgsConstructor
public class ReserveController {
    private final ReserveService reserveService;

    @PostMapping
    public ResponseEntity<Reserve> createReserve(@RequestBody ReserveRequestDto requestDto) {
        return ResponseEntity.ok(this.reserveService.createReserve(requestDto));
    }
}

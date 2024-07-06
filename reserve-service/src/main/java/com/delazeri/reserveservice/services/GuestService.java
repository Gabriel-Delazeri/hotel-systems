package com.delazeri.reserveservice.services;

import com.delazeri.reserveservice.dtos.requests.GuestRequestDto;
import com.delazeri.reserveservice.entities.Guest;
import com.delazeri.reserveservice.repositories.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public Guest createOrFindGuest(GuestRequestDto guestRequestDto) {
        Optional<Guest> existentGuest = this.guestRepository.findGuestByDocument(guestRequestDto.document());

        if (existentGuest.isPresent()) {
            return existentGuest.get();
        }

        Guest guest = new Guest();
        BeanUtils.copyProperties(guestRequestDto, guest);

        return this.guestRepository.save(guest);
    }
}

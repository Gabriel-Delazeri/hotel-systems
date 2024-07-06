package com.delazeri.reserveservice.repositories;

import com.delazeri.reserveservice.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findGuestByDocument(String document);
}

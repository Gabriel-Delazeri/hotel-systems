package com.delazeri.reserveservice.repositories;

import com.delazeri.reserveservice.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReserveRepository extends JpaRepository<Reserve, UUID> {
}

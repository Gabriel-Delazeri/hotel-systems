package com.delazeri.reserveservice.repositories;

import com.delazeri.reserveservice.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}

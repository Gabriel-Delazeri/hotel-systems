package com.delazeri.notificationservice.repositories;

import com.delazeri.notificationservice.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}

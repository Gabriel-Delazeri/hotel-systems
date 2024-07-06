package com.delazeri.reserveservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String hotelId;
    private LocalDate date;
    @ManyToOne
    private Guest guest;
    @OneToOne
    private Payment payment;
}

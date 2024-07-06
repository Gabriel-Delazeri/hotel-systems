package com.delazeri.reserveservice.entities;

import com.delazeri.reserveservice.enums.TypePayment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private double amount;
    @Enumerated(EnumType.STRING)
    private TypePayment type;
}

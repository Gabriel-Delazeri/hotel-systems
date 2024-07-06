package com.delazeri.reserveservice.services;

import com.delazeri.reserveservice.dtos.requests.PaymentRequestDto;
import com.delazeri.reserveservice.entities.Payment;
import com.delazeri.reserveservice.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment save(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentRequestDto, payment);

        return this.paymentRepository.save(payment);
    }
}

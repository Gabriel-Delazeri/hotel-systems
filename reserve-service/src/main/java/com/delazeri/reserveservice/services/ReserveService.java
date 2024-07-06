package com.delazeri.reserveservice.services;

import com.delazeri.reserveservice.dtos.requests.ReserveRequestDto;
import com.delazeri.reserveservice.entities.Reserve;
import com.delazeri.reserveservice.repositories.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReserveService {
    private final ReserveRepository reserveRepository;
    private final GuestService guestService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public Reserve createReserve(ReserveRequestDto requestDto) {
        Reserve reserve = new Reserve();
        BeanUtils.copyProperties(requestDto, reserve);
        reserve.setGuest(this.guestService.createOrFindGuest(requestDto.guestDto()));
        reserve.setPayment(this.paymentService.save(requestDto.paymentDto()));

        reserve = this.reserveRepository.save(reserve);

        this.notificationService.sentNotification(reserve);

        return reserve;
    }
}

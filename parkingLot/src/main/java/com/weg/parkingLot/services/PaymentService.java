package com.weg.parkingLot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weg.parkingLot.dto.PaymentDto.PaymentRequest;
import com.weg.parkingLot.dto.PaymentDto.PaymentResponse;
import com.weg.parkingLot.mapper.PaymentMapper;
import com.weg.parkingLot.model.Payment;
import com.weg.parkingLot.model.ParkingSession;
import com.weg.parkingLot.repository.ParkingSessionRepository;
import com.weg.parkingLot.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final ParkingSessionRepository parkingSessionRepository;

    @Transactional
    public PaymentResponse create(PaymentRequest request) {
        ParkingSession parkingSession = parkingSessionRepository.findById(request.parkingSession())
                .orElseThrow(() -> new RuntimeException("Parking session not found"));
        Payment payment = paymentMapper.toEntity(request);
        payment.setParkingSession(parkingSession);
        paymentRepository.save(payment);
        return paymentMapper.toResponse(payment);
    }

    @Transactional(readOnly = true)
    public List<PaymentResponse> readAll() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public PaymentResponse readById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return paymentMapper.toResponse(payment);
    }

    @Transactional
    public PaymentResponse update(PaymentRequest request, Long id) {
        Payment current = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        ParkingSession parkingSession = parkingSessionRepository.findById(request.parkingSession())
                .orElseThrow(() -> new RuntimeException("Parking session not found"));
        Payment updated = paymentMapper.toEntity(request);
        updated.setId(current.getId());
        updated.setParkingSession(parkingSession);
        paymentRepository.save(updated);
        return paymentMapper.toResponse(updated);
    }

    @Transactional
    public void delete(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        paymentRepository.delete(payment);
    }
}

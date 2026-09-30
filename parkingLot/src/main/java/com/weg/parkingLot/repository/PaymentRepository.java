package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weg.parkingLot.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

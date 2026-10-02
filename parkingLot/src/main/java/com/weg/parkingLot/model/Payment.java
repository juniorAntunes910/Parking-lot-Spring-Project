package com.weg.parkingLot.model;

import java.time.LocalDateTime;

import com.weg.parkingLot.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parking_session_id", nullable = false)
    private ParkingSession parkingSession;

    private Double amount;

    private String paymentMethod;

    private LocalDateTime paidAt;

    private PaymentStatus paymentStatus;
    

}

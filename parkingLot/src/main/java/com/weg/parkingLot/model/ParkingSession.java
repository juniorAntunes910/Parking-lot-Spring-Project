package com.weg.parkingLot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.weg.parkingLot.enums.ParkingSessionStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "parking_spot_id", nullable = false)
    private ParkingSpot parkingSpot;

    @Column(name = "parking_session_entry_time", nullable = false)
    private LocalDateTime entryTime;

    @Column(name = "parking_session_exit_time")
    private LocalDateTime exitTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_session_status", nullable = false)
    private ParkingSessionStatus parkingSessionStatus;

    @Column(name = "parking_session_amount")
    private BigDecimal amount;
}
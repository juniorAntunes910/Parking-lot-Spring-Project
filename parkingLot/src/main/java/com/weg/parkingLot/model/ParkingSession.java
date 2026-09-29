package com.weg.parkingLot.model;

import java.time.LocalDateTime;

import com.weg.parkingLot.enums.ParkingSessionStatus;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class ParkingSession {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "parking_session_amount_vehicle")
    private Vehicle vehicle;

    @Column (name = "parking_session_parking_spot")
    private ParkingSpot parkingSpot;

    @Column (name = "parking_session_entry_time")
    private LocalDateTime entryTime;

    @Column (name = "parking_session_exit_time")
    private LocalDateTime exitTime;

    @Column (name = "parking_session_status")
    private ParkingSessionStatus parkingSessionStatus;

    @Column (name = "parking_session_amount")
    private Double amount;

}

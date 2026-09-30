package com.weg.parkingLot.model;

import com.weg.parkingLot.enums.ParkingSpotStatus;
import com.weg.parkingLot.enums.ParkingSpotType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parking_spot_code", unique = true, nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_spot_type", nullable = false)
    private ParkingSpotType parkingSpotType;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_spot_status", nullable = false)
    private ParkingSpotStatus parkingSpotStatus;

    @Column(name = "parking_spot_enabled", nullable = false)
    private Boolean enabled;

    @OneToOne
    @JoinColumn(name = "vehicle_id", unique = true)
    private Vehicle vehicle;
}

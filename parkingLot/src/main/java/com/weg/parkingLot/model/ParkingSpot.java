package com.weg.parkingLot.model;

import com.weg.parkingLot.enums.ParkingSpotStatus;
import com.weg.parkingLot.enums.ParkingSpotType;

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
public class ParkingSpot {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "parking_spot_code")
    private String code;

    @Column (name = "parking_spot_type")
    private ParkingSpotType parkingSpotType;

    @Column (name = "parking_spot_status")
    private ParkingSpotStatus parkingSpotStatus;

    @Column (name = "parking_spot_enabled")
    private Boolean enabled;

}

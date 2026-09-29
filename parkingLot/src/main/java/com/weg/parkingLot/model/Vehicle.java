package com.weg.parkingLot.model;

import com.weg.parkingLot.enums.VehicleType;

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
public class Vehicle {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "vehicle_plate")
    private String plate;

    @Column (name = "vehicle_model")
    private String model;

    @Column (name = "vehicle_color")
    private String  color;

    @Column (name = "vehicle_type")
    private VehicleType vehicleType;

    @Column (name = "vehicle_customer")
    private Customer customer;
    

}

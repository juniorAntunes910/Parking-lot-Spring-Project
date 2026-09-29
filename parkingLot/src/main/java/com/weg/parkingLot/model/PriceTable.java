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
public class PriceTable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "price_table_vehicle_type")
    private VehicleType vehicleType;

    @Column(name = "price_table_first_hour_price")
    private Double firstHourPrice;

    @Column(name = "price_table_additional_hour_price")
    private Double additionalHourPrice;

    @Column(name = "price_table_daily_limit")
    private Double dailyLimit;

    @Column(name = "price_table_active")
    private Boolean active;

}

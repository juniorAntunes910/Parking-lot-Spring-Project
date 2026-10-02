package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weg.parkingLot.model.ParkingSpot;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long>{
    boolean existsByCode(String code);
}

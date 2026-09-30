package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.parkingLot.model.ParkingSpot;

@Repository 
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long>{
    boolean existsByCode(String code);
}

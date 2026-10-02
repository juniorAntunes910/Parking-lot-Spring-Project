package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weg.parkingLot.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    boolean existsByPlate(String plate);
}

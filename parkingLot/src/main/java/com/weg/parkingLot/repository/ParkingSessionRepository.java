package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weg.parkingLot.model.ParkingSession;
import com.weg.parkingLot.model.Vehicle;

public interface ParkingSessionRepository extends JpaRepository<ParkingSession, Long> {
        boolean existsByVehicle(Vehicle vehicle);
}

package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.parkingLot.model.ParkingSession;

@Repository 
public interface ParkingSessionRepository extends JpaRepository<ParkingSession, Long> {

}

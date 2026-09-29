package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ParkingSessionRepository extends JpaRepository<ParkingSessionRepository, Long> {

}

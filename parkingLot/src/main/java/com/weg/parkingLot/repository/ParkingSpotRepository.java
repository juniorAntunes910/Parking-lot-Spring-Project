package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ParkingSpotRepository extends JpaRepository<ParkingSessionRepository, Long>{

}

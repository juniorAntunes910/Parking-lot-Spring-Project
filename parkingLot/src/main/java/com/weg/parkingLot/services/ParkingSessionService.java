package com.weg.parkingLot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weg.parkingLot.dto.ParkingSession.ParkingSessionRequest;
import com.weg.parkingLot.dto.ParkingSession.ParkingSessionResponse;
import com.weg.parkingLot.mapper.ParkingSessionMapper;
import com.weg.parkingLot.model.ParkingSession;
import com.weg.parkingLot.model.ParkingSpot;
import com.weg.parkingLot.model.Vehicle;
import com.weg.parkingLot.repository.ParkingSessionRepository;
import com.weg.parkingLot.repository.ParkingSpotRepository;
import com.weg.parkingLot.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingSessionService {
    private final ParkingSessionRepository parkingSessionRepository;
    private final ParkingSessionMapper parkingSessionMapper;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSessionResponse create(ParkingSessionRequest parkingSessionRequest) {
        Vehicle vehicle = vehicleRepository.findById(parkingSessionRequest.vehicle())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        ParkingSpot parkingSpot = parkingSpotRepository.findById(parkingSessionRequest.parkingSpot())
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));
        if (parkingSessionRepository.existsByVehicle(vehicle)) {
            throw new RuntimeException("Vehicle already exist in the parking session!");
        }
        ParkingSession parkingSession = parkingSessionMapper.toEntity(parkingSessionRequest);
        parkingSession.setVehicle(vehicle);
        parkingSession.setParkingSpot(parkingSpot);
        parkingSessionRepository.save(parkingSession);
        return parkingSessionMapper.toResponse(parkingSession);
    }

    @Transactional(readOnly = true)
    public List<ParkingSessionResponse> readAll() {
        List<ParkingSession> allParkingSessions = parkingSessionRepository.findAll();
        return allParkingSessions.stream().map(parkingSessionMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public ParkingSessionResponse readById(Long id) {
        ParkingSession parkingSession = parkingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking Session not found"));
        return parkingSessionMapper.toResponse(parkingSession);
    }

    @Transactional
    public ParkingSessionResponse update(ParkingSessionRequest parkingSessionRequest, Long id) {
        ParkingSession parkingSession = parkingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking Session not found"));
        parkingSessionMapper.updateParkingSession(parkingSessionRequest, parkingSession);
        Vehicle vehicle = vehicleRepository.findById(parkingSessionRequest.vehicle())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        ParkingSpot parkingSpot = parkingSpotRepository.findById(parkingSessionRequest.parkingSpot())
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));
        parkingSession.setVehicle(vehicle);
        parkingSession.setParkingSpot(parkingSpot);
        parkingSessionRepository.save(parkingSession);
        return parkingSessionMapper.toResponse(parkingSession);
    }

    @Transactional
    public void delete(Long id) {
        ParkingSession parkingSession = parkingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking Session not found"));
        parkingSessionRepository.delete(parkingSession);
    }

}

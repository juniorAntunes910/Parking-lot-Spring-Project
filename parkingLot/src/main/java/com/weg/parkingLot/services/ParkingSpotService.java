package com.weg.parkingLot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weg.parkingLot.dto.ParkingSpotDto.ParkingSpotRequest;
import com.weg.parkingLot.dto.ParkingSpotDto.ParkingSpotResponse;
import com.weg.parkingLot.mapper.ParkingSpotMapper;
import com.weg.parkingLot.model.ParkingSpot;
import com.weg.parkingLot.repository.ParkingSpotRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingSpotMapper parkingSpotMapper;

    @Transactional
    public ParkingSpotResponse create(ParkingSpotRequest request) {
        if (parkingSpotRepository.existsByCode(request.code())) {
            throw new RuntimeException("Parking spot code already registered");
        }
        ParkingSpot parkingSpot = parkingSpotMapper.toEntity(request);
        parkingSpotRepository.save(parkingSpot);
        return parkingSpotMapper.toResponse(parkingSpot);
    }

    @Transactional(readOnly = true)
    public List<ParkingSpotResponse> readAll() {
        return parkingSpotRepository.findAll().stream()
                .map(parkingSpotMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ParkingSpotResponse readById(Long id) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));
        return parkingSpotMapper.toResponse(parkingSpot);
    }

    @Transactional
    public ParkingSpotResponse update(ParkingSpotRequest request, Long id) {
        ParkingSpot current = parkingSpotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));
        if (parkingSpotRepository.existsByCode(request.code()) && !current.getCode().equals(request.code())) {
            throw new RuntimeException("Parking spot code already registered");
        }
        ParkingSpot updated = parkingSpotMapper.toEntity(request);
        updated.setId(current.getId());
        parkingSpotRepository.save(updated);
        return parkingSpotMapper.toResponse(updated);
    }

    @Transactional
    public void delete(Long id) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));
        parkingSpotRepository.delete(parkingSpot);
    }
}

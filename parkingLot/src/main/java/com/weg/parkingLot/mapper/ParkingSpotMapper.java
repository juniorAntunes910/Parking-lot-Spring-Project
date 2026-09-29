package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weg.parkingLot.dto.ParkingSpotDto.ParkingSpotRequest;
import com.weg.parkingLot.dto.ParkingSpotDto.ParkingSpotResponse;
import com.weg.parkingLot.model.ParkingSpot;

@Mapper (componentModel = "spring")
public interface ParkingSpotMapper {

    @Mapping (target = "id", ignore = true)
    ParkingSpot toEntity(ParkingSpotRequest parkingSpotRequest);

    ParkingSpotResponse toResponse(ParkingSpot parkingSpot);
}

package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.weg.parkingLot.dto.ParkingSession.ParkingSessionRequest;
import com.weg.parkingLot.dto.ParkingSession.ParkingSessionResponse;
import com.weg.parkingLot.model.ParkingSession;

@Mapper(componentModel = "spring")
public interface ParkingSessionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vehicle.id", source = "vehicle")
    @Mapping(target = "parkingSpot.id", source = "parkingSpot")
    ParkingSession toEntity(ParkingSessionRequest parkingSessionRequest);

    @Mapping(target = "vehicle", source = "vehicle.id")
    @Mapping(target = "parkingSpot", source = "parkingSpot.id")
    ParkingSessionResponse toResponse(ParkingSession parkingSession);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vehicle.id", source = "vehicle")
    @Mapping(target = "parkingSpot.id", source = "parkingSpot")
    void updateParkingSession(ParkingSessionRequest parkingSessionRequest,
            @MappingTarget ParkingSession parkingSession);
}

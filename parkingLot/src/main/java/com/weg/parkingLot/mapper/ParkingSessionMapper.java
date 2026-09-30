package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.weg.parkingLot.dto.ParkingSession.ParkingSessionRequest;
import com.weg.parkingLot.dto.ParkingSession.ParkingSessionResponse;
import com.weg.parkingLot.model.ParkingSession;

@Mapper (componentModel = "spring")
public interface ParkingSessionMapper {

    @Mapping (target = "id", ignore = true)
    ParkingSession toEntity(ParkingSessionRequest parkingSessionRequest);

    ParkingSessionResponse toResponse(ParkingSession parkingSession);

    void updateParkingSession(ParkingSessionRequest parkingSessionRequest, @MappingTarget ParkingSession parkingSession);
}

package com.weg.parkingLot.dto.ParkingSpotDto;

public record ParkingSpotResponse(
    Long id,
    String code,
    String parkingSpotType,
    String parkingSpotStatus,
    Boolean enabled
) {
}

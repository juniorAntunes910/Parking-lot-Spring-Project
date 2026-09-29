package com.weg.parkingLot.dto.ParkingSpotDto;

public record ParkingSpotRequest(
    String code,
    String parkingSpotType,
    String parkingSpotStatus,
    Boolean enabled
) {
}

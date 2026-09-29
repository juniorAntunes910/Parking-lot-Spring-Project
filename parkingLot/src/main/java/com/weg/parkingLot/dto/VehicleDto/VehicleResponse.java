package com.weg.parkingLot.dto.VehicleDto;

public record VehicleResponse(
    Long id,
    String plate,
    String model,
    String color,
    String vehicleType,
    Long customer,
    Long parkingSpot
) {
}

package com.weg.parkingLot.dto.VehicleDto;

public record VehicleRequest(
    String plate,
    String model,
    String color,
    String vehicleType,
    Long customer,
    Long parkingSpot
) {
}

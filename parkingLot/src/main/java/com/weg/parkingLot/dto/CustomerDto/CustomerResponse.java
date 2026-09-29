package com.weg.parkingLot.dto.CustomerDto;

import java.time.LocalDateTime;
import java.util.List;

import com.weg.parkingLot.dto.VehicleDto.VehicleResponse;

public record CustomerResponse(
    Long id,
    String name,
    String document,
    String phone,
    List<VehicleResponse> vehicles,
    LocalDateTime createdAt
) {

}

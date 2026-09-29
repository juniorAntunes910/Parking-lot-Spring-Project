package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weg.parkingLot.dto.VehicleDto.VehicleRequest;
import com.weg.parkingLot.dto.VehicleDto.VehicleResponse;
import com.weg.parkingLot.model.Vehicle;

@Mapper (componentModel = "spring")
public interface VehicleMapper {

    @Mapping (target = "id", ignore = true)
    Vehicle toEntity(VehicleRequest vehicleRequest);

    VehicleResponse toResponse(Vehicle vehicle);

}

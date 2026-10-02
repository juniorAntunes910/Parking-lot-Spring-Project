package com.weg.parkingLot.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.weg.parkingLot.dto.VehicleDto.VehicleRequest;
import com.weg.parkingLot.dto.VehicleDto.VehicleResponse;
import com.weg.parkingLot.model.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "parkingSpot", ignore = true)
    Vehicle toEntity(VehicleRequest vehicleRequest);

    @Mapping(target = "customer", source = "customer.id")
    @Mapping(target = "parkingSpot", source = "parkingSpot.id")
    VehicleResponse toResponse(Vehicle vehicle);

    @BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "parkingSpot", ignore = true)
    void updateVehicle(
        VehicleRequest vehicleRequest,
        @MappingTarget Vehicle vehicle
    );
}
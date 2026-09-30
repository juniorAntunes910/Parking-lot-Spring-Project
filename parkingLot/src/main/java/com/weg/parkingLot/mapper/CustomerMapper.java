package com.weg.parkingLot.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.weg.parkingLot.dto.CustomerDto.CustomerRequest;
import com.weg.parkingLot.dto.CustomerDto.CustomerResponse;
import com.weg.parkingLot.model.Customer;

@Mapper (componentModel = "spring")
public interface CustomerMapper {

    @Mapping (target = "id", ignore = true)
    @Mapping (target = "vehicles", ignore = true)
    @Mapping (target = "createdAt", ignore = true)
    Customer toEntity(CustomerRequest customerRequest);

    CustomerResponse toResponse(Customer customer);

    @BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping (target = "id", ignore = true)
    @Mapping (target = "vehicles", ignore = true)
    @Mapping (target = "createdAt", ignore = true)
    void updateEntity(CustomerRequest customerRequest, @MappingTarget Customer customer);

}

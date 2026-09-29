package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weg.parkingLot.dto.PriceTableDto.PriceTableRequest;
import com.weg.parkingLot.dto.PriceTableDto.PriceTableResponse;

@Mapper (componentModel = "spring")
public interface PriceTable {

    @Mapping (target = "id", ignore = true)
    PriceTable toEntity(PriceTableRequest priceTableRequest);

    PriceTableResponse toResponse(PriceTable priceTable);

}

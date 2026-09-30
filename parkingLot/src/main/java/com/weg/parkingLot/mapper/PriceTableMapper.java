package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weg.parkingLot.dto.PriceTableDto.PriceTableRequest;
import com.weg.parkingLot.dto.PriceTableDto.PriceTableResponse;
import com.weg.parkingLot.model.PriceTable;

@Mapper (componentModel = "spring")
public interface PriceTableMapper {

    @Mapping (target = "id", ignore = true)
    PriceTable toEntity(PriceTableRequest priceTableRequest);

    PriceTableResponse toResponse(PriceTable priceTable);

}

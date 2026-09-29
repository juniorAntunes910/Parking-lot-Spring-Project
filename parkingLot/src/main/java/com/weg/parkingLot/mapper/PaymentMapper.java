package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weg.parkingLot.dto.PaymentDto.PaymentRequest;
import com.weg.parkingLot.dto.PaymentDto.PaymentResponse;
import com.weg.parkingLot.model.Payment;

@Mapper (componentModel = "spring")
public interface PaymentMapper {

    @Mapping (target = "id", ignore = true)
    Payment toEntity(PaymentRequest paymentRequest);

    PaymentResponse toResponse(Payment payment);

}

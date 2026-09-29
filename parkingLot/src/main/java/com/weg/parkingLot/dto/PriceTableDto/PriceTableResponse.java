package com.weg.parkingLot.dto.PriceTableDto;

public record PriceTableResponse(
    Long id,
    String vehicleType,
    Double firstHourPrice,
    Double additionalHourPrice,
    Double dailyLimit,
    Boolean active
) {
}

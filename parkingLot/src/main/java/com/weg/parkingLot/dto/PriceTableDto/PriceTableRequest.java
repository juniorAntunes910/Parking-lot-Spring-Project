package com.weg.parkingLot.dto.PriceTableDto;

public record PriceTableRequest(
    String vehicleType,
    Double firstHourPrice,
    Double additionalHourPrice,
    Double dailyLimit,
    Boolean active
) {
}

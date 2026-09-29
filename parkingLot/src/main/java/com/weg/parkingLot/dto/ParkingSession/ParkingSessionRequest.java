package com.weg.parkingLot.dto.ParkingSession;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ParkingSessionRequest(
    Long vehicle,
    Long parkingSpot,
    LocalDateTime entryTime,
    LocalDateTime exitTime,
    String parkingSessionStatus,
    BigDecimal amount
) {

}

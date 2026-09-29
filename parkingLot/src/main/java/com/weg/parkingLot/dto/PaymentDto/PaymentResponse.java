package com.weg.parkingLot.dto.PaymentDto;

import java.time.LocalDateTime;

public record PaymentResponse(
    Long id,
    Long parkingSession,
    Double amount,
    String paymentMethod,
    LocalDateTime paidAt,
    String paymentStatus
) {
}

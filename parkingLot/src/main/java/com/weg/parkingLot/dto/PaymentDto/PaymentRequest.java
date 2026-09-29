package com.weg.parkingLot.dto.PaymentDto;

import java.time.LocalDateTime;

public record PaymentRequest(
    Long parkingSession,
    Double amount,
    String paymentMethod,
    LocalDateTime paidAt,
    String paymentStatus
) {
}

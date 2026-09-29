package com.weg.parkingLot.dto.customerDto;

import java.time.LocalDateTime;

public record UserResponse(
    Long id,
    String name,
    String email,
    String role,
    Boolean enabled,
    LocalDateTime createdAt
) {

}

package com.weg.parkingLot.dto.customerDto;

public record UserRequest(
    String name,
    String email,
    String password,
    String role
) {

}

package com.weg.parkingLot.dto.UserDto;

public record UserRequest(
    String name,
    String email,
    String password,
    String role
) {

}

package com.weg.parkingLot.dto.CustomerDto;


public record CustomerRequest(
    String name,
    String document,
    String phone
) {

}

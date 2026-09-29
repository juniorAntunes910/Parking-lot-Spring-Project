package com.weg.parkingLot.dto.CustomerDto;

import java.util.List;

public record CustomerRequest(
    String name,
    String document,
    String phone
) {

}

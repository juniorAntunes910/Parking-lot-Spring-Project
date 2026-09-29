package com.weg.parkingLot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weg.parkingLot.dto.UserDto.UserRequest;
import com.weg.parkingLot.dto.UserDto.UserResponse;
import com.weg.parkingLot.model.User;

@Mapper (componentModel = "spring")
public interface UserMapper {

    @Mapping (target = "id", ignore = true)
    @Mapping (target = "enabled", ignore = true)
    @Mapping (target = "createdAt", ignore = true)
    User toEntity(UserRequest userRequest);

    UserResponse userResponse(User user);

}

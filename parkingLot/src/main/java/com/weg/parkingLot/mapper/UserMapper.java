package com.weg.parkingLot.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

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

    @BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping (target = "id", ignore = true)
    @Mapping (target = "createdAt", ignore = true)
    @Mapping (target = "enabled", ignore = true)
    void updateUser(UserRequest userRequest, @MappingTarget User user);

}

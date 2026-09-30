package com.weg.parkingLot.services;

import java.util.List;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weg.parkingLot.dto.UserDto.UserRequest;
import com.weg.parkingLot.dto.UserDto.UserResponse;
import com.weg.parkingLot.mapper.UserMapper;
import com.weg.parkingLot.model.User;
import com.weg.parkingLot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;

    @Transactional
    public UserResponse create(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new RuntimeException("Email já cadastrado");
        }
        User user = userMapper.toEntity(userRequest);
        userRepository.save(user);
        return userMapper.userResponse(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> readAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::userResponse).toList();
    }


    @Transactional (readOnly = true)
    public UserResponse readById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return userMapper.userResponse(user);
    }

    @Transactional 
    public UserResponse update(UserRequest userRequest, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        userMapper.updateUser(userRequest, user);
        userRepository.save(user);
        return userMapper.userResponse(user);
    }

    @Transactional 
    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        userRepository.delete(user);
    }

}

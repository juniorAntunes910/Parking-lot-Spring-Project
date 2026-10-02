package com.weg.parkingLot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.parkingLot.dto.UserDto.UserRequest;
import com.weg.parkingLot.dto.UserDto.UserResponse;
import com.weg.parkingLot.services.UserService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {

    private UserService userService;

    @PostMapping("/{id}")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest entity) {
        return new ResponseEntity<>(userService.create(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> readById(@PathParam(value = "id") Long id) {
        return new ResponseEntity<>(userService.readById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> readAll() {
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathParam(value = "id") Long id, @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.update(userRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathParam(value = "id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package com.weg.parkingLot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.parkingLot.dto.UserDto.UserRequest;
import com.weg.parkingLot.dto.UserDto.UserResponse;
import com.weg.parkingLot.dto.VehicleDto.VehicleRequest;
import com.weg.parkingLot.dto.VehicleDto.VehicleResponse;
import com.weg.parkingLot.services.UserService;
import com.weg.parkingLot.services.VehicleService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @PostMapping("/{id}")
    public ResponseEntity<VehicleResponse> create(@RequestBody VehicleRequest entity) {
        return new ResponseEntity<>(vehicleService.create(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> readById(@PathParam(value = "id") Long id) {
        return new ResponseEntity<>(vehicleService.readById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> readAll() {
        return new ResponseEntity<>(vehicleService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponse> update(@PathParam(value = "id") Long id, @RequestBody VehicleRequest vehicleRequest) {
        return new ResponseEntity<>(vehicleService.update(vehicleRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathParam(value = "id") Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

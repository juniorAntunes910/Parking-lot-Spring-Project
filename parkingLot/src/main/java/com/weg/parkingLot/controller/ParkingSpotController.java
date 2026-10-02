package com.weg.parkingLot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.parkingLot.dto.ParkingSpotDto.ParkingSpotRequest;
import com.weg.parkingLot.dto.ParkingSpotDto.ParkingSpotResponse;
import com.weg.parkingLot.services.ParkingSpotService;

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

@RequestMapping("/parkingSpots")
@RestController
@RequiredArgsConstructor
public class ParkingSpotController {
    private final ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpotResponse> create(@RequestBody ParkingSpotRequest parkingSpotRequest) {
        return new ResponseEntity<>(parkingSpotService.create(parkingSpotRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotResponse> readById(@PathParam(value = "id") Long id) {
        return new ResponseEntity<>(parkingSpotService.readById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotResponse>> readAll() {
        return new ResponseEntity<>(parkingSpotService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpotResponse> update (@PathParam (value = "id") Long id, @RequestBody ParkingSpotRequest entity){
        return new ResponseEntity<>(parkingSpotService.update(entity, id), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathParam (value = "id") Long id){
        parkingSpotService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

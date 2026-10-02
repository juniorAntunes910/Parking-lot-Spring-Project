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

import com.weg.parkingLot.dto.ParkingSession.ParkingSessionRequest;
import com.weg.parkingLot.dto.ParkingSession.ParkingSessionResponse;
import com.weg.parkingLot.services.ParkingSessionService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parkingSessions")
public class ParkingSessionController {
    private ParkingSessionService parkingSessionService;

    @PostMapping
    public ResponseEntity<ParkingSessionResponse> create(@RequestBody ParkingSessionRequest parkingSessionRequest) {
        return new ResponseEntity<>(parkingSessionService.create(parkingSessionRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSessionResponse> readById(@PathParam(value = "id") Long id) {
        return new ResponseEntity<>(parkingSessionService.readById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ParkingSessionResponse>> readAll() {
        return new ResponseEntity<>(parkingSessionService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSessionResponse> update(@RequestBody ParkingSessionRequest parkingSessionRequest,
            @PathParam(value = "id") Long id) {
        return new ResponseEntity<>(parkingSessionService.update(parkingSessionRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathParam(value = "id") Long id) {
        parkingSessionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package com.weg.parkingLot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.parkingLot.dto.PaymentDto.PaymentRequest;
import com.weg.parkingLot.dto.PaymentDto.PaymentResponse;
import com.weg.parkingLot.services.PaymentService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<PaymentResponse> create(@RequestBody PaymentRequest entity) {
        return new ResponseEntity<>(paymentService.create(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> readById(@PathParam(value = "id") Long id) {
        return new ResponseEntity<>(paymentService.readById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PaymentResponse>> readAll() {
        return new ResponseEntity<>(paymentService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponse> update(@PathParam(value = "id") Long id,
            @RequestBody PaymentRequest entity) {
        return new ResponseEntity<>(paymentService.update(entity, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathParam(value = "id") Long id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

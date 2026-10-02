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

import com.weg.parkingLot.dto.PriceTableDto.PriceTableRequest;
import com.weg.parkingLot.dto.PriceTableDto.PriceTableResponse;
import com.weg.parkingLot.services.PriceTableService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/priceTables")
@RequiredArgsConstructor
public class PriceTableController {

    private final PriceTableService priceTableService;

    @PostMapping()
    public ResponseEntity<PriceTableResponse> create(@RequestBody PriceTableRequest entity) {
        return new ResponseEntity<>(priceTableService.create(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceTableResponse> readById(@PathParam(value = "id") Long id) {
        return new ResponseEntity<>(priceTableService.readById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PriceTableResponse>> readAll() {
        return new ResponseEntity<>(priceTableService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceTableResponse> update(@PathParam(value = "id") Long id,
            @RequestBody PriceTableRequest entity) {
        return new ResponseEntity<>(priceTableService.update(entity, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathParam(value = "id") Long id) {
        priceTableService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

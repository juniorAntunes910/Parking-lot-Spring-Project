package com.weg.parkingLot.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.parkingLot.dto.CustomerDto.CustomerRequest;
import com.weg.parkingLot.dto.CustomerDto.CustomerResponse;
import com.weg.parkingLot.services.CustomerService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequestMapping ("/customers")
@RequiredArgsConstructor 
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody  CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.create(customerRequest), HttpStatus.CREATED);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<CustomerResponse> readById(@PathParam(value = "id") Long id){
        return new ResponseEntity<>(customerService.readById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> readAll(){
        return new ResponseEntity<>(customerService.readAll(), HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathParam(value = "id") Long id, @RequestBody CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.update(customerRequest, id),HttpStatus.OK);
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathParam (value = "id") Long id){
            customerService.delete(id);
            return ResponseEntity.noContent().build();
    }

}

package com.weg.parkingLot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weg.parkingLot.dto.CustomerDto.CustomerRequest;
import com.weg.parkingLot.dto.CustomerDto.CustomerResponse;
import com.weg.parkingLot.mapper.CustomerMapper;
import com.weg.parkingLot.model.Customer;
import com.weg.parkingLot.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerResponse create(CustomerRequest customerRequest) {

        if (customerRepository.existsByDocument(customerRequest.document())) {
            throw new RuntimeException("Customer already registered");
        }

        Customer customer = customerMapper.toEntity(customerRequest);
        customerRepository.save(customer);
        return customerMapper.toResponse(customer);
    }

    @Transactional(readOnly = true)
    public List<CustomerResponse> readAll() {
        List<Customer> allCustomers = customerRepository.findAll();

        return allCustomers.stream().map(customerMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public CustomerResponse readById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toResponse(customer);
    }

    @Transactional
    public CustomerResponse update(CustomerRequest customerRequest, Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerMapper.updateEntity(customerRequest, customer);
        return customerMapper.toResponse(customer);
    }

    @Transactional 
    public void delete(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
    }

}

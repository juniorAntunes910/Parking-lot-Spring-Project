package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weg.parkingLot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    boolean existsByDocument(String document);
}

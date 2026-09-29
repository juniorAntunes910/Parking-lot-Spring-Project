package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.parkingLot.model.Customer;

@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

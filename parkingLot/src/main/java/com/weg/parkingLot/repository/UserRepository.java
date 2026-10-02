package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weg.parkingLot.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);
}

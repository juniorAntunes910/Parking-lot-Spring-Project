package com.weg.parkingLot.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_document")
    private String document;

    @Column(name = "customer_phone")
    private String phone;

    @Column (name = "customer_vehicles")
    @OneToMany (mappedBy = "customer")
    private List<Vehicle> vehicles = new ArrayList<>();

    @Column(name = "customer_created_at")
    LocalDateTime createdAt = LocalDateTime.now();
}

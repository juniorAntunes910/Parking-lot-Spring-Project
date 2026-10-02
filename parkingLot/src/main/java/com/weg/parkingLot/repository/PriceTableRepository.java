package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weg.parkingLot.model.PriceTable;

public interface PriceTableRepository extends JpaRepository<PriceTable, Long>{

}

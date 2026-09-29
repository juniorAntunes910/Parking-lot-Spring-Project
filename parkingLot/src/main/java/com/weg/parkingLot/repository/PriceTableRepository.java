package com.weg.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.parkingLot.model.PriceTable;

@Repository 
public interface PriceTableRepository extends JpaRepository<PriceTable, Long>{

}

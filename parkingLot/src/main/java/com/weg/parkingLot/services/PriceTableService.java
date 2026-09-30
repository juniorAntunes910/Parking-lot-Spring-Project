package com.weg.parkingLot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weg.parkingLot.dto.PriceTableDto.PriceTableRequest;
import com.weg.parkingLot.dto.PriceTableDto.PriceTableResponse;
import com.weg.parkingLot.mapper.PriceTableMapper;
import com.weg.parkingLot.model.PriceTable;
import com.weg.parkingLot.repository.PriceTableRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class PriceTableService {

    private final PriceTableRepository priceTableRepository;
    private final PriceTableMapper priceTableMapper;

    @Transactional 
    public PriceTableResponse create(PriceTableRequest priceTableRequest){
        PriceTable priceTable = priceTableMapper.toEntity(priceTableRequest);
        priceTableRepository.save(priceTable);
        return priceTableMapper.toResponse(priceTable);
    }

    @Transactional (readOnly = true)
    public List<PriceTableResponse> readAll(){
        List<PriceTable> allPriceTableResponses = priceTableRepository.findAll();
        return allPriceTableResponses.stream().map(priceTableMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public PriceTableResponse readById(Long id) {
        PriceTable priceTable = priceTableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price table not found"));
        return priceTableMapper.toResponse(priceTable);
    }

    @Transactional
    public PriceTableResponse update(PriceTableRequest request, Long id) {
        PriceTable current = priceTableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price table not found"));
        PriceTable updated = priceTableMapper.toEntity(request);
        updated.setId(current.getId());
        priceTableRepository.save(updated);
        return priceTableMapper.toResponse(updated);
    }

    @Transactional
    public void delete(Long id) {
        PriceTable priceTable = priceTableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price table not found"));
        priceTableRepository.delete(priceTable);
    }
}

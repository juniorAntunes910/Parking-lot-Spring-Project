package com.weg.parkingLot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weg.parkingLot.dto.VehicleDto.VehicleRequest;
import com.weg.parkingLot.dto.VehicleDto.VehicleResponse;
import com.weg.parkingLot.mapper.VehicleMapper;
import com.weg.parkingLot.model.Customer;
import com.weg.parkingLot.model.Vehicle;
import com.weg.parkingLot.repository.CustomerRepository;
import com.weg.parkingLot.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
    private VehicleMapper vehicleMapper;
    private CustomerRepository customerRepository;

    @Transactional
    public VehicleResponse create(VehicleRequest vehicleRequest) {
        if (vehicleRepository.existsByPlate(vehicleRequest.plate())) {
            throw new RuntimeException("Veiculo já cadastrado");
        }
        Customer customer = customerRepository.findById(vehicleRequest.customer()).orElseThrow(() -> new RuntimeException("C"));
        Vehicle vehicle = vehicleMapper.toEntity(vehicleRequest);
        vehicleRepository.save(vehicle);
        return vehicleMapper.toResponse(vehicle);
    }

    @Transactional(readOnly = true)
    public List<VehicleResponse> readAll() {
        List<Vehicle> allVehicles = vehicleRepository.findAll();
        return allVehicles.stream().map(vehicleMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public VehicleResponse readById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        return vehicleMapper.toResponse(vehicle);
    }

    @Transactional 
    public VehicleResponse update(VehicleRequest vehicleRequest, Long id){
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        vehicleMapper.updateVehicle(vehicleRequest, vehicle);
        vehicleRepository.save(vehicle);
        return vehicleMapper.toResponse(vehicle);
    }

    @Transactional 
    public void delete(Long id){
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        vehicleRepository.delete(vehicle);
    }
    

}

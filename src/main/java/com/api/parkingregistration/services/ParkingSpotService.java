package com.api.parkingregistration.services;

import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final
    ParkingSpotRepository repository;


    public ParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return repository.save(parkingSpotModel);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id){
        return repository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel){
        repository.delete(parkingSpotModel);
    }





    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return repository.existsByLicensePlateCar(licensePlateCar);

    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return repository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return repository.existsByApartmentAndBlock(apartment,block);
    }
}

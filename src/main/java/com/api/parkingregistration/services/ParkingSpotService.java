package com.api.parkingregistration.services;

import com.api.parkingregistration.models.CarModel;
import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ParkingSpotRepository;
import com.api.parkingregistration.services.exceptions.DataBaseException;
import com.api.parkingregistration.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository repository;


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
    public void delete(UUID id){
        try{
            Optional<ParkingSpotModel> parkingSpotModelOptional = repository.findById(id);
            if (parkingSpotModelOptional.get().getCar() != null){
                throw new DataBaseException("The parking spot could not be deleted because there is an existing car associated with it");
            }
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }









}

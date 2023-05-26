package com.api.parkingregistration.services;

import com.api.parkingregistration.models.ApartmentModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ApartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ApartmentService {

    final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Transactional
    public ApartmentModel save(ApartmentModel apartmentModel){
       return apartmentRepository.save(apartmentModel);
    }

    public Page<ApartmentModel> findAll(Pageable pageable) {
        return apartmentRepository.findAll(pageable);
    }

    public Optional<ApartmentModel> findApartmentById(UUID id){
        return apartmentRepository.findById(id);
    }




}

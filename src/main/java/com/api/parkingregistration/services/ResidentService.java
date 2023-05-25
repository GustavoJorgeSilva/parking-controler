package com.api.parkingregistration.services;

import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ResidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResidentService {

    final ResidentRepository residentRepository;

    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }


    public ResidentModel save (ResidentModel residentModel){
        return residentRepository.save(residentModel);
    }

    public Page<ResidentModel> findAll(Pageable pageable){
        return residentRepository.findAll(pageable);
    }
















    public boolean existsById(UUID residentModel){
        return residentRepository.existsById(residentModel);
    }

}

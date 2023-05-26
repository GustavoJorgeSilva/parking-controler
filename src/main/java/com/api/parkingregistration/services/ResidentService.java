package com.api.parkingregistration.services;

import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ResidentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResidentService {

    final ResidentRepository residentRepository;

    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    public ResidentModel save(ResidentModel residentModel) {
        return residentRepository.save(residentModel);
    }

    public Page<ResidentModel> findAll(Pageable pageable) {
        return residentRepository.findAll(pageable);
    }

    public Optional<ResidentModel> findById(UUID id) {
        return residentRepository.findById(id);
    }


    @Transactional
    public void delete(ResidentModel residentModel) {
        residentRepository.delete(residentModel);
    }





//    public ResidentModel update(UUID id, ResidentModel obj) {
//        ResidentModel residentModel = residentRepository.getReferenceById(id);
//        updateData(residentModel, obj);
//        return residentRepository.save(residentModel);
//    }
//
//
//    private void updateData(ResidentModel residentToUpdate, ResidentModel newData) {
//
//        residentToUpdate.setApartment(newData.getApartment());
//        residentToUpdate.setResponsibleName(newData.getResponsibleName());
//        residentToUpdate.setBlock(newData.getBlock());
//
//
//
//    }

    public boolean existsById(UUID residentModel) {
        return residentRepository.existsById(residentModel);
    }
}

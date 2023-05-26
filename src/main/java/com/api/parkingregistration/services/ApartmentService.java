package com.api.parkingregistration.services;

import com.api.parkingregistration.models.ApartmentModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ApartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Transactional
    public void delete(UUID id) {
        try {

            Optional<ApartmentModel> apartmentModel = apartmentRepository.findById(id);

            if(apartmentModel.get().getResident() != null){
                throw new IllegalArgumentException("It is not possible to delete the apartment due to the association with a resident.");
            }

            apartmentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
    }


    public boolean existsByNumberApartmentAndBlock(String numberApartment, String block){
        return apartmentRepository.existsByNumberApartmentAndBlock(numberApartment,block);
    }


    public ApartmentModel update(UUID id, ApartmentModel obj) {

        ApartmentModel apartmentModel = apartmentRepository.getReferenceById(id);
        updateData(apartmentModel,obj);
        return apartmentRepository.save(apartmentModel);

    }

    public void updateData(ApartmentModel apartmentToUpdate, ApartmentModel newData){
        apartmentToUpdate.setNumberApartment(newData.getNumberApartment());
        apartmentToUpdate.setBlock(newData.getBlock());
    }
}

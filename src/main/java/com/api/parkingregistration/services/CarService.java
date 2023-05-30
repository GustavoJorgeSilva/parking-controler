package com.api.parkingregistration.services;

import com.api.parkingregistration.models.CarModel;
import com.api.parkingregistration.repositories.CarRepository;
import com.api.parkingregistration.repositories.ParkingSpotRepository;
import com.api.parkingregistration.services.exceptions.DataBaseException;
import com.api.parkingregistration.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    private CarRepository carRepository;
    private ParkingSpotRepository parkingSpotRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public CarModel save(CarModel carModel) {
        return carRepository.save(carModel);
    }

    public Page<CarModel> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    public Optional<CarModel> findCarById(UUID id) {
        return carRepository.findById(id);}

    @Transactional
    public void delete(UUID id){
        carRepository.deleteById(id);
          }


    public CarModel update(UUID id, CarModel obj) {

        CarModel carModel = carRepository.getReferenceById(id);
        updateData(carModel,obj);
        return carRepository.save(carModel);

    }

    public void updateData(CarModel carToUpdate, CarModel newData){
        carToUpdate.setBrandCar(newData.getBrandCar());
        carToUpdate.setModelCar(newData.getModelCar());
        carToUpdate.setColorCar(newData.getColorCar());
    }

    public boolean existsByLicensePlateCar(String licensePlateCar){
        return carRepository.existsByLicensePlateCar(licensePlateCar);
    }

}

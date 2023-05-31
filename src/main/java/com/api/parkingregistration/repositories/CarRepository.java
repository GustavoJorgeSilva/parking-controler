package com.api.parkingregistration.repositories;

import com.api.parkingregistration.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<CarModel, UUID> {
    public boolean existsByLicensePlateCar(String licensePlateCar);
}

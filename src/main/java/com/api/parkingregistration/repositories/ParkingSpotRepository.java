package com.api.parkingregistration.repositories;

import com.api.parkingregistration.models.ParkingSpotModel;

import com.api.parkingregistration.models.ResidentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {


    public boolean existsByLicensePlateCar(String licensePlateCar);
    public boolean existsByParkingSpotNumber(String parkSpotNumber);


}

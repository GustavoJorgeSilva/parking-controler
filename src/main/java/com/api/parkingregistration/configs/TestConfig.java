package com.api.parkingregistration.configs;

import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ParkingSpotRepository;
import com.api.parkingregistration.repositories.ResidentRepository;
import com.api.parkingregistration.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {



    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private ResidentRepository residentRepository;




    @Override
    public void run(String... args) throws Exception {



        ParkingSpotModel ps1 = new ParkingSpotModel("157a","dmy2146","Chevrolet","corsa","plate",
                LocalDateTime.now());

        ResidentModel r1 = new ResidentModel("Gustavo Jorge","157","A",ps1);



        parkingSpotRepository.save(ps1);
        residentRepository.save(r1);

    }
}

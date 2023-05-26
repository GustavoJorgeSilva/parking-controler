package com.api.parkingregistration.configs;

import com.api.parkingregistration.models.ApartmentModel;
import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ApartmentRepository;
import com.api.parkingregistration.repositories.ParkingSpotRepository;
import com.api.parkingregistration.repositories.ResidentRepository;
import com.api.parkingregistration.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {



    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;




    @Override
    public void run(String... args) throws Exception {







        ParkingSpotModel ps1 = new ParkingSpotModel("157a","dmy2146","Chevrolet","corsa","plate",
                LocalDateTime.now());
        ApartmentModel ap1 = new ApartmentModel("145","A",ps1);

        ResidentModel r1 = new ResidentModel("Gustavo","765777767", LocalDate.now(),"gusgusagu");


        ap1.setResident(r1);
        parkingSpotRepository.save(ps1);
        residentRepository.save(r1);
        apartmentRepository.save(ap1);




        ParkingSpotModel ps2 = new ParkingSpotModel("156a","fgt5676","bmw","x1","black",
                LocalDateTime.now());
        ParkingSpotModel ps3 = new ParkingSpotModel("155b","das4233","Honda","civic","white",
                LocalDateTime.now());
        ParkingSpotModel ps4 = new ParkingSpotModel("154b","oil7654","Fiat","mobi","grey",
                LocalDateTime.now());

        ParkingSpotModel ps5 = new ParkingSpotModel("153c","ggg8981","Cherry","QQ","Yellow",LocalDateTime.now());













    }
}

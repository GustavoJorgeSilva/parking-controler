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
import java.util.Arrays;

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
        ParkingSpotModel ps2 = new ParkingSpotModel("156a","fgt5676","bmw","x1","black",
                LocalDateTime.now());
        ParkingSpotModel ps3 = new ParkingSpotModel("155b","das4233","Honda","civic","white",
                LocalDateTime.now());
        ParkingSpotModel ps4 = new ParkingSpotModel("154b","oil7654","Fiat","mobi","grey",
                LocalDateTime.now());

        ParkingSpotModel ps5 = new ParkingSpotModel("153c","ggg8981","Cherry","QQ","Yellow",LocalDateTime.now());


        ResidentModel r1 = new ResidentModel("Gustavo Jorge","157","a",ps1);
        ResidentModel r2 = new ResidentModel("Joao mendez","156","a",ps2);
        ResidentModel r3 = new ResidentModel("Marcela soares","155","b",ps3);
        ResidentModel r4 = new ResidentModel("Guilherme Jorge","154","b",ps4);




        parkingSpotRepository.saveAll(Arrays.asList(ps1,ps2,ps3,ps4,ps5));
        residentRepository.saveAll(Arrays.asList(r1,r2,r3,r4));

    }
}

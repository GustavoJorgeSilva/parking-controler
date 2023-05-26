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


        ResidentModel r1 = new ResidentModel("Gustavo","765777767", LocalDate.now(),"gustavo.jorge@hotmail.com");
        ResidentModel r2 = new ResidentModel("Joao da silva","875875784",LocalDate.now(),"joao@gmail");
        ResidentModel r3 = new ResidentModel("Marcela soares","875875784",LocalDate.now(),"marcela@gmail");
        ResidentModel r4 = new ResidentModel("Guilherme Jorge","123213132",LocalDate.now(),"guilherme@gmail");
        ResidentModel r5 = new ResidentModel("Antonio Roberto","67675654",LocalDate.now(),"antonio@gmail");


        ParkingSpotModel ps2 = new ParkingSpotModel("156a","fgt5676","bmw","x1","black",
                LocalDateTime.now());
        ParkingSpotModel ps3 = new ParkingSpotModel("155b","das4233","Honda","civic","white",
                LocalDateTime.now());
        ParkingSpotModel ps4 = new ParkingSpotModel("154b","oil7654","Fiat","mobi","grey",
                LocalDateTime.now());

        ParkingSpotModel ps5 = new ParkingSpotModel("153c","ggg8981","Cherry","QQ","Yellow",LocalDateTime.now());

        ApartmentModel ap1 = new ApartmentModel("145","A",ps1);
        ApartmentModel ap2 = new ApartmentModel("145","A",ps2);
        ApartmentModel ap3 = new ApartmentModel("145","A",ps3);
        ApartmentModel ap4 = new ApartmentModel("145","A",ps4);
        ApartmentModel ap5 = new ApartmentModel("145","A",ps5);
        ApartmentModel ap6 = new ApartmentModel("000","A",null);

        ap1.setResident(r1);
        ap2.setResident(r2);
        ap3.setResident(r3);
        ap4.setResident(r4);
        ap5.setResident(r5);
        parkingSpotRepository.saveAll(Arrays.asList(ps1,ps2,ps3,ps4,ps5));
        residentRepository.saveAll(Arrays.asList(r1,r2,r3,r4,r5));
        apartmentRepository.saveAll(Arrays.asList(ap1,ap2,ap3,ap4,ap5,ap6));

















    }
}

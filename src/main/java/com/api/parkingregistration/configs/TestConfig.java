package com.api.parkingregistration.configs;

import com.api.parkingregistration.models.ApartmentModel;
import com.api.parkingregistration.models.CarModel;
import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.repositories.ApartmentRepository;
import com.api.parkingregistration.repositories.CarRepository;
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

    @Autowired
    private CarRepository carRepository;




    @Override
    public void run(String... args) throws Exception {





        ParkingSpotModel parkingSpot1 = new ParkingSpotModel("111",LocalDateTime.now());


        ResidentModel resident1 = new ResidentModel("Gustavo","765777767", LocalDate.now(),"gustavo.jorge@hotmail.com");
        ResidentModel resident2 = new ResidentModel("Joao da silva","875875784",LocalDate.now(),"joao@gmail");
        ResidentModel resident3 = new ResidentModel("Marcela soares","875875784",LocalDate.now(),"marcela@gmail");
        ResidentModel resident4 = new ResidentModel("Guilherme Jorge","123213132",LocalDate.now(),"guilherme@gmail");
        ResidentModel resident5 = new ResidentModel("Antonio Roberto","67675654",LocalDate.now(),"antonio@gmail");

        residentRepository.saveAll(Arrays.asList(resident1,resident2,resident3,resident4,resident5));

        CarModel car1 = new CarModel("trr6543","BMW","x5","Black",resident1);
        CarModel car2= new CarModel("abc1234","BMW","x1","White",resident2);
        CarModel car3 = new CarModel("ujm4321","Chevrolet","Corsa","Plate",resident3);
        CarModel car4 = new CarModel("kli8752","Fiat","Toro","Blue",resident4);
        CarModel car5 = new CarModel("nbz9087","Hyundai","hb20s","White",resident5);
//        CarModel car6 = new CarModel("zdg1237","BMW","x5","Brown");



        ParkingSpotModel parkingSpot2 = new ParkingSpotModel("222",
                LocalDateTime.now());
        ParkingSpotModel parkingSpot3 = new ParkingSpotModel("333",
                LocalDateTime.now());
        ParkingSpotModel parkingSpot4 = new ParkingSpotModel("444",
                LocalDateTime.now());

        ParkingSpotModel parkingSpot5 = new ParkingSpotModel("555",LocalDateTime.now());

        parkingSpotRepository.saveAll(Arrays.asList(parkingSpot1,parkingSpot2,parkingSpot3,parkingSpot4,parkingSpot5));

        ApartmentModel apartment1 = new ApartmentModel("145","A",parkingSpot1);
        ApartmentModel apartment2 = new ApartmentModel("146","A",parkingSpot2);
        ApartmentModel apartment3 = new ApartmentModel("147","A",parkingSpot3);
        ApartmentModel apartment4 = new ApartmentModel("145","B",parkingSpot4);
        ApartmentModel apartment5 = new ApartmentModel("146","B",parkingSpot5);
        ApartmentModel apartment6 = new ApartmentModel("147","B",null);


        carRepository.saveAll(Arrays.asList(car1,car2,car3,car4,car5));

        apartment1.setResident(resident1);
        apartment2.setResident(resident2);
        apartment3.setResident(resident3);
        apartment4.setResident(resident4);
        apartment5.setResident(resident5);

        resident1.setCar(car1);
        resident2.setCar(car2);
        resident3.setCar(car3);
        resident4.setCar(car4);
        resident5.setCar(car5);
        residentRepository.saveAll(Arrays.asList(resident1,resident2,resident3,resident4,resident5));

        parkingSpot1.setCarModel(resident1.getCar());
        parkingSpot1.setApartmentModel(apartment1);
        parkingSpot2.setCarModel(resident2.getCar());
        parkingSpot2.setApartmentModel(apartment2);
        parkingSpot3.setCarModel(resident3.getCar());
        parkingSpot3.setApartmentModel(apartment3);
        parkingSpot4.setCarModel(resident4.getCar());
        parkingSpot4.setApartmentModel(apartment4);
        parkingSpot5.setCarModel(resident5.getCar());
        parkingSpot5.setApartmentModel(apartment5);



        apartmentRepository.saveAll(Arrays.asList(apartment1,apartment2,apartment3,apartment4,apartment1,apartment6,apartment5));
        parkingSpotRepository.saveAll(Arrays.asList(parkingSpot1,parkingSpot2,parkingSpot3,parkingSpot4,parkingSpot5));
















    }
}

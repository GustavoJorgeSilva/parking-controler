package com.api.parkingregistration.controllers;

import com.api.parkingregistration.dtos.ParkingSpotDTO;
import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("parking-spot")
public class ParkingSpotController {

    final ParkingSpotService parkingSpotService;


    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody ParkingSpotModel parkingSpotModel1) {

        if (parkingSpotService.existsByLicensePlateCar(parkingSpotModel1.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: License plate car is alredy in use!");
        }

        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotModel1.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: Parking spot is alredy in use!");
        }




        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotModel1, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(@PageableDefault(page = 0,size = 10,sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id")UUID id){


        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
            if(!parkingSpotModelOptional.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found.");
            }
            return  ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable (value= "id") UUID id ){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Park spot deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSPot(@PathVariable(value = "id") UUID id,@RequestBody
                                                    ParkingSpotModel parkingSpotModel){

        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found.");
            }

        var parkingSpotModelCopy = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotModel,parkingSpotModelCopy);
        parkingSpotModelCopy.setId(parkingSpotModelOptional.get().getId());
        parkingSpotModelCopy.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModelCopy));
        }

    }





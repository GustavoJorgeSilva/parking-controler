package com.api.parkingregistration.controllers;

import com.api.parkingregistration.models.ApartmentModel;
import com.api.parkingregistration.models.CarModel;
import com.api.parkingregistration.services.CarService;
import com.api.parkingregistration.services.exceptions.ConflictException;
import com.api.parkingregistration.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CarModel carModel){
        carModel = carService.save(carModel);
        return ResponseEntity.ok().body(carModel);
    }

    @GetMapping
    public ResponseEntity<Page<CarModel>> getAllCars (@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findCarById(@PathVariable(value = "id") UUID id) {

        Optional<CarModel> carModel = carService.findCarById(id);
        if (!carModel.isPresent()) {
            throw new ResourceNotFoundException(id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(carModel.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
       Optional<CarModel> carModelOptional = carService.findCarById(id);
       if (!carModelOptional.isPresent()){
           throw new ResourceNotFoundException(id);
       }
       carService.delete(carModelOptional.get());
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody CarModel obj) {
        if (carService.existsByLicensePlateCar(obj.getLicensePlateCar())) {
            throw new ConflictException("Conflict license plate car number: " + obj.getLicensePlateCar() + " is already exists in dataBase");
        }

        obj = carService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}

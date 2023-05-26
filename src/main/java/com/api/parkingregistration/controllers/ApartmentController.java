package com.api.parkingregistration.controllers;

import com.api.parkingregistration.models.ApartmentModel;
import com.api.parkingregistration.services.ApartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("apartments")
public class ApartmentController {

    final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ApartmentModel apartmentModel){
        apartmentModel = apartmentService.save(apartmentModel);
        return ResponseEntity.ok().body(apartmentModel);
    }

    @GetMapping
    public ResponseEntity<Page<ApartmentModel>> getAllApartments(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(apartmentService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findApartmentById(@PathVariable(value = "id") UUID id){

        Optional<ApartmentModel> apartmentModelOptional = apartmentService.findApartmentById(id);
        if(!apartmentModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Apartment id not found ");
        }

        return ResponseEntity.status(HttpStatus.OK).body(apartmentModelOptional.get());
    }

    
}

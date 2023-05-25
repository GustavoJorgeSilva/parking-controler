package com.api.parkingregistration.controllers;

import com.api.parkingregistration.dtos.ParkingSpotDTO;
import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.services.ResidentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("residents")
public class ResidentController {

    final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }


    @PostMapping
    public ResponseEntity<ResidentModel> save(@RequestBody ResidentModel resident){
        resident = residentService.save(resident);
        return ResponseEntity.status(HttpStatus.CREATED).body(resident);

    }


    @GetMapping
    public ResponseEntity<Page<ResidentModel>> getAllresidents(@PageableDefault(page = 0,size = 10,sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(residentService.findAll(pageable));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getOneResident(@PathVariable(value = "id")UUID id){


        Optional<ResidentModel> residentModelOptional = residentService.findById(id);
        if(!residentModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resident not found.");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(residentModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteResidentByID(@PathVariable (value = "id") UUID id){
        Optional<ResidentModel> residentModelOptional = residentService.findById(id);
        if(!residentModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resident not found.");
        }

        residentService.delete(residentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Resident deleted successfully.");
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ResidentModel> update(@PathVariable UUID id, @RequestBody ResidentModel obj) {
        obj = residentService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }



}

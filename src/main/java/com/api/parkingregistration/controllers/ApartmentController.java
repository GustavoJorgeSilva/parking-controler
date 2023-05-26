package com.api.parkingregistration.controllers;

import com.api.parkingregistration.repositories.ApartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apartments")
public class ApartmentController {

    final ApartmentRepository apartmentRepository;


    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }








}

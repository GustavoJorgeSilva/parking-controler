package com.api.parkingregistration.controllers;

import com.api.parkingregistration.models.ParkingSpotModel;
import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.services.ResidentService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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


}

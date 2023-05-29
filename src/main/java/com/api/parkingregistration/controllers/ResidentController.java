package com.api.parkingregistration.controllers;

import com.api.parkingregistration.models.ResidentModel;
import com.api.parkingregistration.services.ResidentService;
import com.api.parkingregistration.services.exceptions.ConflictException;
import com.api.parkingregistration.services.exceptions.ResourceNotFoundException;
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
@RequestMapping("residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ResidentModel resident) {
        if (residentService.existsByCpf(resident.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: cpf is already registered");
        }

        resident = residentService.save(resident);
        return ResponseEntity.status(HttpStatus.CREATED).body(resident);

    }


    @GetMapping
    public ResponseEntity<Page<ResidentModel>> getAllresidents(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(residentService.findAll(pageable));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getOneResident(@PathVariable(value = "id") UUID id) {


        Optional<ResidentModel> residentModelOptional = residentService.findById(id);
        if (!residentModelOptional.isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(residentModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteResidentByID(@PathVariable(value = "id") UUID id) {
        Optional<ResidentModel> residentModelOptional = residentService.findById(id);
        if (!residentModelOptional.isPresent()) {
            throw new ResourceNotFoundException(id);
        }

        residentService.delete(residentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Resident deleted successfully.");
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody ResidentModel obj) {
        if (residentService.existsByCpf(obj.getCpf())) {
            throw new ConflictException("Conflict: Cpf: " +obj.getCpf() +  " already existing in the database");
        }
        
        obj = residentService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
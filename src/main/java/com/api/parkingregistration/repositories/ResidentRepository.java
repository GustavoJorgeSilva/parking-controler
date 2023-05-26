package com.api.parkingregistration.repositories;

import com.api.parkingregistration.models.ResidentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResidentRepository extends JpaRepository<ResidentModel, UUID> {


    public boolean existsById(UUID residentModel);
    public boolean existsByCpf(String cpf);


}

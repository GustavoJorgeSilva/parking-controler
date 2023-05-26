package com.api.parkingregistration.repositories;

import com.api.parkingregistration.models.ApartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApartmentRepository extends JpaRepository<ApartmentModel, UUID> {
}

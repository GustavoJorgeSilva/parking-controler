package com.api.parkingregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_RESIDENT")
public class ResidentModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 130)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;

    @OneToOne
    @JoinColumn(name = "parking_spot_id")
    private ParkingSpotModel parkingSpot;

    public ParkingSpotModel getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpotModel parkingSpot) {
        this.parkingSpot = parkingSpot;
    }


    public ResidentModel() {
    }

    public ResidentModel(String responsibleName, String apartment, String block, ParkingSpotModel parkingSpot) {
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
        this.parkingSpot = parkingSpot;
    }



    public UUID getUUID(){
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResidentModel residentModel)) return false;
        return Objects.equals(getUUID(), residentModel.getUUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID());
    }
}

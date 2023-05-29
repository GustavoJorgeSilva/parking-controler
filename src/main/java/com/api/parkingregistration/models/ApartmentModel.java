package com.api.parkingregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_APARTMENT")
public class ApartmentModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String numberApartment;
    @Column(nullable = false, length = 10)
    private String block;


    @OneToOne
    private ResidentModel resident;


    @OneToOne
    private ParkingSpotModel parkingSpotModel;


    public ApartmentModel() {
    }

    public ApartmentModel(String numberApartment, String block, ParkingSpotModel parkingSpotModel) {
        this.numberApartment = numberApartment;
        this.block = block;
        this.parkingSpotModel = parkingSpotModel;
        this.resident = getResident();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumberApartment() {
        return numberApartment;
    }

    public void setNumberApartment(String numberApartment) {
        this.numberApartment = numberApartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public ResidentModel getResident() {
        return resident;
    }

    public void setResident(ResidentModel resident) {
        this.resident = resident;
    }

    public ParkingSpotModel getParkingSpotModel() {
        return parkingSpotModel;
    }

    public void setParkingSpotModel(ParkingSpotModel parkingSpotModel) {
        this.parkingSpotModel = parkingSpotModel;
    }

    public void addResident(ResidentModel resident){
        this.resident = resident;
        resident.setApartmentModel(this);
    }


}

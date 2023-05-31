package com.api.parkingregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @OneToOne(mappedBy = "parkingSpotModel", cascade = CascadeType.REMOVE)
    private CarModel car;

    @JsonIgnore
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ApartmentModel apartmentModel;


    public ParkingSpotModel() {
    }

    public ParkingSpotModel(String parkingSpotNumber, LocalDateTime registrationDate) {


        this.parkingSpotNumber = parkingSpotNumber;
        this.registrationDate = registrationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }


    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public ApartmentModel getApartmentModel() {
        return apartmentModel;
    }

    public void setApartmentModel(ApartmentModel apartmentModel) {
        this.apartmentModel = apartmentModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpotModel that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

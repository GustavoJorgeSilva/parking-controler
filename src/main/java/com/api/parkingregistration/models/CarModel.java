package com.api.parkingregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_CAR")
public class CarModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false, length = 70)
    private String brandCar;
    @Column(nullable = false, length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String colorCar;

    @JsonIgnore
    @OneToOne(mappedBy = "car")
    @JoinColumn(name = "resident_id")
    private ResidentModel resident;





    public CarModel() {
    }

    public CarModel(String licensePlateCar, String brandCar, String modelCar, String colorCar,ResidentModel resident) {
        this.licensePlateCar = licensePlateCar;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.resident = resident;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public ResidentModel getResident() {
        return resident;
    }

    public void setResident(ResidentModel resident) {
        this.resident = resident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarModel carModel)) return false;
        return Objects.equals(getId(), carModel.getId()) && Objects.equals(getLicensePlateCar(), carModel.getLicensePlateCar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLicensePlateCar());
    }
}

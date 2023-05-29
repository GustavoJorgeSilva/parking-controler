package com.api.parkingregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
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
    @Column(nullable = false, length = 12)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false,name = "birthday_date")
    private LocalDate birthday;

    @Column(nullable = false, length = 130)
    private String email;

    private boolean haveAcar;

    @JsonIgnore
    @OneToOne(mappedBy = "resident")
    private ApartmentModel apartmentModel;

    @OneToOne
    @JoinColumn(name = "car_id")
    private CarModel car;




    public ResidentModel() {
    }

    public ResidentModel(String responsibleName, String cpf, LocalDate birthday, String email) {
        this.responsibleName = responsibleName;
        this.cpf = cpf;
        this.birthday = birthday;
        this.email = email;
        this.haveAcar = false;
    }

    public UUID getId() {
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


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ApartmentModel getApartmentModel() {
        return apartmentModel;
    }

    public void setApartmentModel(ApartmentModel apartmentModel) {
        this.apartmentModel = apartmentModel;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {

        this.car = car;
        haveAcar = true;
    }

    public boolean isHaveAcar() {
        return haveAcar;
    }

    public void setHaveAcar(boolean haveAcar) {
        this.haveAcar = haveAcar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResidentModel residentModel)) return false;
        return Objects.equals(getId(), residentModel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void sellCar(){
        this.haveAcar = false;
    }
}

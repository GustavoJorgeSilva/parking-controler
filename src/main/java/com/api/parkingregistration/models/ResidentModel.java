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




    @OneToOne(mappedBy = "resident")
    private ApartmentModel apartmentModel;



    public ResidentModel() {
    }

    public ResidentModel(String responsibleName, String cpf, LocalDate birthday, String email) {
        this.responsibleName = responsibleName;
        this.cpf = cpf;
        this.birthday = birthday;
        this.email = email;
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
}

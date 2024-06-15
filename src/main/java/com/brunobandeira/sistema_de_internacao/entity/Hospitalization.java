package com.brunobandeira.sistema_de_internacao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "hospitalizations")
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "medic_id", nullable = false)
    private Medic medic;
    @PastOrPresent
    private LocalDateTime hospitalizationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public LocalDateTime getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(LocalDateTime hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
    }
}

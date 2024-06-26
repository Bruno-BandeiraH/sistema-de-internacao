package com.brunobandeira.sistema_de_internacao.repository;

import com.brunobandeira.sistema_de_internacao.entity.Medic;
import com.brunobandeira.sistema_de_internacao.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface MedicRepository extends JpaRepository<Medic, UUID> {

    List<Medic> findBySpeciality(String speciality);
    List<Medic> findByFullName(String fullName);
    Medic findByMedicalId(int medicalId);
}

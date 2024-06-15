package com.brunobandeira.sistema_de_internacao.repository;

import com.brunobandeira.sistema_de_internacao.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    List<Patient> findByCpf(String cpf);
    List<Patient> findByBirthDate(LocalDate birthDate);
    List<Patient> findByFullName(String fullName);
}

package com.brunobandeira.sistema_de_internacao.repository;

import com.brunobandeira.sistema_de_internacao.entity.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, UUID> {

    List<Hospitalization> findByPatientFullName(String fullName);
    List<Hospitalization> findByPatientBirthDate(LocalDate birthDate);
    List<Hospitalization> findByPatientCpf(String cpf);
}

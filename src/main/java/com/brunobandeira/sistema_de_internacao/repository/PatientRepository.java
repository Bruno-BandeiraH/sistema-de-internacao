package com.brunobandeira.sistema_de_internacao.repository;

import com.brunobandeira.sistema_de_internacao.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}

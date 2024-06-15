package com.brunobandeira.sistema_de_internacao.repository;

import com.brunobandeira.sistema_de_internacao.entity.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, UUID> {
}

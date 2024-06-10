package com.brunobandeira.sistema_de_internacao.repository;

import com.brunobandeira.sistema_de_internacao.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicRepository extends JpaRepository<Medic, UUID> {
}

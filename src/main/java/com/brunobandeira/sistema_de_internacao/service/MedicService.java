package com.brunobandeira.sistema_de_internacao.service;

import com.brunobandeira.sistema_de_internacao.entity.Medic;
import com.brunobandeira.sistema_de_internacao.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicService {

    private final MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    public List<Medic> getAll() {
        return medicRepository.findAll();
    }

    public Medic create(Medic patient) {
        return medicRepository.save(patient);
    }

    public Medic update(Medic patient) {
        return medicRepository.save(patient);
    }

    public void deleteById(UUID id){
        medicRepository.deleteById(id);
    }
}

package com.brunobandeira.sistema_de_internacao.service;

import com.brunobandeira.sistema_de_internacao.entity.Medic;
import com.brunobandeira.sistema_de_internacao.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Medic createOrUpdate(Medic patient) {
        return medicRepository.save(patient);
    }

    public boolean deleteById(UUID id){
        Optional<Medic> medic = medicRepository.findById(id);
        if(medic.isPresent()){
            medicRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

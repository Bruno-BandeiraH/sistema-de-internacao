package com.brunobandeira.sistema_de_internacao.service;

import com.brunobandeira.sistema_de_internacao.entity.Hospitalization;
import com.brunobandeira.sistema_de_internacao.repository.HospitalizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalizationService {

    private final HospitalizationRepository hospitalizationRepository;

    public HospitalizationService(HospitalizationRepository hospitalizationRepository) {
        this.hospitalizationRepository = hospitalizationRepository;
    }

    public List<Hospitalization> getAll() {
        return hospitalizationRepository.findAll();
    }

    public Hospitalization createOrUpdate(Hospitalization hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }

    public boolean deleteById(UUID id) {
        Optional<Hospitalization> hospitalization = hospitalizationRepository.findById(id);
        if(hospitalization.isPresent()){
            hospitalizationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

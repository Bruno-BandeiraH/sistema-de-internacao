package com.brunobandeira.sistema_de_internacao.service;

import com.brunobandeira.sistema_de_internacao.entity.Hospitalization;
import com.brunobandeira.sistema_de_internacao.repository.HospitalizationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Optional<Hospitalization> findById(UUID id) {
        return hospitalizationRepository.findById(id);
    }

    public List<Hospitalization> findByPatientFullName(String fullName) {
        return hospitalizationRepository.findByPatientFullName(fullName);
    }

    public List<Hospitalization> findByPatientBirthDate(LocalDate birthDate) {
        return  hospitalizationRepository.findByPatientBirthDate(birthDate);
    }

    public List<Hospitalization> findByPatientCpf(String cpf) {
        return hospitalizationRepository.findByPatientCpf(cpf);
    }

    public Hospitalization createOrUpdate(Hospitalization hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }

    public boolean deleteById(UUID id) {
        if(hospitalizationRepository.existsById(id)){
            hospitalizationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

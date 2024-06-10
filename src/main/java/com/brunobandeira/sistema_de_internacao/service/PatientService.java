package com.brunobandeira.sistema_de_internacao.service;

import com.brunobandeira.sistema_de_internacao.entity.Patient;
import com.brunobandeira.sistema_de_internacao.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deleteById(UUID id){
        patientRepository.deleteById(id);
    }
}

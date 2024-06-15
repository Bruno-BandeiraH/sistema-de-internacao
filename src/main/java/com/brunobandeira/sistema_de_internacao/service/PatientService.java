package com.brunobandeira.sistema_de_internacao.service;

import com.brunobandeira.sistema_de_internacao.entity.Patient;
import com.brunobandeira.sistema_de_internacao.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

    public List<Patient> findByCpf(String cpf) {
        return patientRepository.findByCpf(cpf);
    }

    public List<Patient> findByBirthDate(LocalDate birthDate) {
        return patientRepository.findByBirthDate(birthDate);
    }

    public List<Patient> findByFullName(String fullName) {
        return patientRepository.findByFullName(fullName);
    }

    public Patient createOrUpdate(Patient patient) {
        return patientRepository.save(patient);
    }

    public boolean deleteById(UUID id){
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            patientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

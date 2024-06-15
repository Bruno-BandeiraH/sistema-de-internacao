package com.brunobandeira.sistema_de_internacao.service;

import com.brunobandeira.sistema_de_internacao.entity.Medic;
import com.brunobandeira.sistema_de_internacao.entity.Patient;
import com.brunobandeira.sistema_de_internacao.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Medic> findBySpeciality(String speciality) {
        return medicRepository.findBySpeciality(speciality);
    }

    public  List<Medic> findByFullName(String fullName) {
        return medicRepository.findByFullName(fullName);
    }

    public Medic findByMedicalId(int medicalId) {
        return medicRepository.findByMedicalId(medicalId);
    }

    public Medic createOrUpdate(Medic patient) {
        return medicRepository.save(patient);
    }

    public boolean deleteById(UUID id){
        if(medicRepository.existsById(id)){
            medicRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

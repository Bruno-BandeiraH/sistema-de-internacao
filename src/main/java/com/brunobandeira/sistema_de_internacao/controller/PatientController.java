package com.brunobandeira.sistema_de_internacao.controller;

import com.brunobandeira.sistema_de_internacao.entity.Patient;
import com.brunobandeira.sistema_de_internacao.repository.PatientRepository;
import com.brunobandeira.sistema_de_internacao.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> findAll() {
        return patientService.getAll();
    }

    @GetMapping("/{cpf}")
    public List<Patient> findByCpf(@PathVariable String cpf) {
        return patientService.findByCpf(cpf);
    }

    @GetMapping("/birth/{birthDate}")
    public List<Patient> findByBirthDate(@PathVariable LocalDate birthDate) {
        return patientService.findByBirthDate(birthDate);
    }

    @GetMapping("/name/{fullName}")
    public List<Patient> findByFullName(String fullName) {
        return patientService.findByFullName(fullName);
    }

    @PostMapping
    public Patient create(@Valid @RequestBody Patient patient) {
        return patientService.createOrUpdate(patient);
    }

    @PutMapping
    public Patient update(@Valid @RequestBody Patient patient) {
        return patientService.createOrUpdate(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deleted = patientService.deleteById(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

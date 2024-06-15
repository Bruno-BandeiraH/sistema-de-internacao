package com.brunobandeira.sistema_de_internacao.controller;

import com.brunobandeira.sistema_de_internacao.entity.Hospitalization;
import com.brunobandeira.sistema_de_internacao.service.HospitalizationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/hospitalization")
public class HospitalizationController {

    private final HospitalizationService hospitalizationService;

    public HospitalizationController(HospitalizationService hospitalizationService) {
        this.hospitalizationService = hospitalizationService;
    }

    @GetMapping
    public List<Hospitalization> findAll() {
        return hospitalizationService.getAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Hospitalization> findById(@PathVariable  UUID id) {
        return hospitalizationService.findById(id);
    }

    @GetMapping("/name/{fullName}")
    public List<Hospitalization> findByPatientFullName(@PathVariable String fullName) {
        return hospitalizationService.findByPatientFullName(fullName);
    }

    @GetMapping("/birthDate/{birthDate}")
    public List<Hospitalization> findByPatientBirthDate(LocalDate birthDate) {
        return  hospitalizationService.findByPatientBirthDate(birthDate);
    }

    @GetMapping("/cpf/{cpf}")
    public List<Hospitalization> findByPatientCpf(@PathVariable  String cpf) {
        return hospitalizationService.findByPatientCpf(cpf);
    }

    @PostMapping
    public Hospitalization create(@Valid @RequestBody Hospitalization hospitalization) {
        return hospitalizationService.createOrUpdate(hospitalization);
    }

    @PutMapping
    public Hospitalization update(@Valid @RequestBody Hospitalization hospitalization) {
        return hospitalizationService.createOrUpdate(hospitalization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        boolean deleted = hospitalizationService.deleteById(id);
        if(deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.brunobandeira.sistema_de_internacao.controller;

import com.brunobandeira.sistema_de_internacao.entity.Hospitalization;
import com.brunobandeira.sistema_de_internacao.service.HospitalizationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

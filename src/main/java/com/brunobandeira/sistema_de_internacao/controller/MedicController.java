package com.brunobandeira.sistema_de_internacao.controller;

import com.brunobandeira.sistema_de_internacao.entity.Medic;
import com.brunobandeira.sistema_de_internacao.service.MedicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medic")
public class MedicController {

    private final MedicService medicService;

    public MedicController(MedicService medicService){
        this.medicService = medicService;
    }

    @GetMapping
    public List<Medic> getlAll(){
        return medicService.getAll();
    }

    @PostMapping
    public Medic create(@Valid @RequestBody Medic medic){
        return medicService.createOrUpdate(medic);
    }

    @PutMapping
    public Medic update(@Valid @RequestBody Medic medic) {
        return medicService.createOrUpdate(medic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(UUID id) {
        boolean deleted = medicService.deleteById(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

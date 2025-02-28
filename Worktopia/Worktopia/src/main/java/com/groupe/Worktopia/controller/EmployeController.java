package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.repository.EmployeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeController {
    private EmployeRepo employeRepo;

    public EmployeController(EmployeRepo employeRepo){
        this.employeRepo = employeRepo;
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmploye(){
        return ResponseEntity.status(200).body(this.employeRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> findEmployeById(@PathVariable Long id){
        Employe employe = this.employeRepo.findById(id).orElseThrow(()->new RuntimeException("employe non trouve"));

        return ResponseEntity.status(200).body(employe);
    }

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe){
        this.employeRepo.save(employe);

        return ResponseEntity.status(200).body(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe){
        this.employeRepo.findById(id).orElseThrow(()->new RuntimeException("employe non trouver !"));

        employe.setFirstname(employe.getFirstname());
        employe.setLastname(employe.getLastname());
        employe.setPoste(employe.getPoste());
        employe.setSalaireBase(employe.getSalaireBase());
        employe.setPoste(employe.getPoste());

        this.employeRepo.save(employe);

        return ResponseEntity.status(200).body(employe);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable Long id){
        Employe employe = this.employeRepo.findById(id).orElseThrow(()->new RuntimeException("employe non trouve !"));

        this.employeRepo.delete(employe);

        return ResponseEntity.status(200).body("employe supprimer avec succes !");

    }

    
}

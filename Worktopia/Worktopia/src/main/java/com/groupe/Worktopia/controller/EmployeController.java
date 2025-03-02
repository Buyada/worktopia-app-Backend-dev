package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.repository.EmployeRepo;
import com.groupe.Worktopia.service.Employe.EmployeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeController {
    private EmployeRepo employeRepo;
    private EmployeService employeService;

    public EmployeController(EmployeRepo employeRepo, EmployeService employeService){
        this.employeRepo = employeRepo;
        this.employeService = employeService;
    }

    @GetMapping(path = "/api/employe/get_All")
    public ResponseEntity<List<Employe>> getAllEmploye(){
        return ResponseEntity.status(200).body(this.employeRepo.findAll());
    }

    @GetMapping(path = "/api/employe/find_by_Id/{id}")
    public ResponseEntity<Employe> findEmployeById(@PathVariable Long id){
       Employe employe =  this.employeService.getEmploye(id);
        return ResponseEntity.status(200).body(employe);
    }

    @PostMapping(path = "/api/employe/create_employe")
    public ResponseEntity<String> createEmploye(@RequestBody Employe employe){
        this.employeService.addEmploye(employe);
        return ResponseEntity.status(200).body("employe creer avec succes !");
    }

    @PutMapping(path = "/api/employe/update_by_Id/{id}")
    public ResponseEntity<String> updateEmploye(@PathVariable Long id, @RequestBody Employe employe){
        this.employeService.getEmploye(id);
        return ResponseEntity.status(200).body("Employe modifier avec success !");
    }


    @DeleteMapping(path = "/api/employe/delete_by_Id/{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable Long id){
        Employe employe = this.employeService.getEmploye(id);
        return ResponseEntity.status(200).body("employe supprimer avec succes !");
    }

    
}

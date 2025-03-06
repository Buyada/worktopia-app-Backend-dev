package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.dto.EmployeDto.EmployeDtoRq;
import com.groupe.Worktopia.dto.EmployeDto.EmployeDtoRs;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.mapper.EmployeMapper;
import com.groupe.Worktopia.repository.EmployeRepo;
import com.groupe.Worktopia.service.Employe.EmployeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeController {
    private EmployeRepo employeRepo;
    private EmployeService employeService;
    private EmployeMapper employeMapper;

    public EmployeController(EmployeRepo employeRepo, EmployeService employeService, EmployeMapper employeMapper){
        this.employeRepo = employeRepo;
        this.employeService = employeService;
        this.employeMapper = employeMapper;
    }

    @GetMapping(path = "/api/employe/get_All")
    public ResponseEntity<List<EmployeDtoRs>> getAllEmploye(){
        
        return ResponseEntity.status(200).body(this.employeRepo.findAll());
    }

    @GetMapping(path = "/api/employe/find_by_Id/{idEmploye}")
    public ResponseEntity<EmployeDtoRs> findEmployeById(@PathVariable Long idEmploye){
        return ResponseEntity.status(200).body(this.employeService.getEmployeById(idEmploye));
    }

    @PostMapping(path = "/api/employe/create_employe")
    public ResponseEntity<String> createEmploye(@RequestBody EmployeDtoRs employe){
        this.employeService.addEmploye(employe);
        return ResponseEntity.status(200).body("employe creer avec succes !");
    }

    @PutMapping(path = "/api/employe/update_by_Id/{idEmploye}")
    public ResponseEntity<String> updateEmploye(@PathVariable Long idEmploye, @RequestBody Employe employe){
        this.employeService.updateEmploye(idEmploye, employe);
        return ResponseEntity.status(200).body("Employe modifier avec success !");
    }


    @DeleteMapping(path = "/api/employe/delete_by_Id/{idEmploye}")
    public ResponseEntity<String> deleteEmploye(@PathVariable Long idEmploye){
        this.employeService.deleteEmploye(idEmploye);
        return ResponseEntity.status(200).body("employe supprimer avec succes !");
    }

    
}

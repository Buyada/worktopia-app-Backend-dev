package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import com.groupe.Worktopia.repository.EmployeRepo;
import com.groupe.Worktopia.service.Employe.EmployeService;
import com.groupe.Worktopia.service.Employe.EmployeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeController {
    private EmployeRepo employeRepo;
    private EmployeService employeService;
    private EmployeServiceImpl employeServiceImpl;

    public EmployeController(EmployeRepo employeRepo, EmployeService employeService, EmployeServiceImpl employeServiceImpl){
        this.employeRepo = employeRepo;
        this.employeService = employeService;
        this.employeServiceImpl = employeServiceImpl;
    }

    @GetMapping(path = "/api/employe/get_All")
    public ResponseEntity<List<EmployeDto>> getAllEmploye(){
        List<EmployeDto> employes = this.employeService.getAll();
        return ResponseEntity.status(200).body(employes);
    }

    @GetMapping(path = "/api/employe/find_by_Id/{idEmploye}")
    public ResponseEntity<EmployeDto> findEmployeById(@PathVariable Long idEmploye){
        return ResponseEntity.status(200).body(this.employeService.getEmployeById(idEmploye));
    }

    @PostMapping(path = "/api/employe/create_employe")
    public ResponseEntity<String> createEmploye(@Valid @RequestBody EmployeDto employe){
        this.employeServiceImpl.addEmploye(employe);
        return ResponseEntity.status(200).body("employe creer avec succes !");
    }

    @PutMapping(path = "/api/employe/update_by_Id/{idEmploye}")
    public ResponseEntity<String> updateEmploye(@PathVariable Long idEmploye, @RequestBody EmployeDto employe){
        this.employeService.updateEmployeById(idEmploye, employe);
        return ResponseEntity.status(200).body("Employe modifier avec success !");
    }


    @DeleteMapping(path = "/api/employe/delete_by_Id/{idEmploye}")
    public ResponseEntity<String> deleteEmploye(@PathVariable Long idEmploye){
        this.employeServiceImpl.deleteEmploye(idEmploye);
        return ResponseEntity.status(200).body("employe supprimer avec succes !");
    }

    
}

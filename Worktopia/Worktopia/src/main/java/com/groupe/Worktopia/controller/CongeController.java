package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.entities.Conge;
import com.groupe.Worktopia.service.Conge.CongeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CongeController {

    private final CongeService congeService;

    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }

    @Operation(summary = "add new Conge ", description = "Allow to add new Conge")
    @PostMapping("api/p1/Conge/add")
    public ResponseEntity<Conge> addConge(@RequestBody @Valid Conge conge){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.congeService.addConge(conge));
    }

    @GetMapping(path = "api/p1/conge/get_all_conge")
    public  ResponseEntity<List<Conge>> getAllConge(){
        return ResponseEntity.status(200).body(this.congeService.getAllConge());

    }


    @GetMapping(path = "api/p1/conge/get_by_id/{idConge}")
    public ResponseEntity<Conge> getCongeById(@PathVariable Long idConge){
        return ResponseEntity
                .status(200)
                .body(this.congeService.getCongeById(idConge));
    }


    @PutMapping(path = "api/p1/conge/update_by_id/{idConge}")
    public ResponseEntity<Conge> updateConge(@PathVariable Long idConge,
                                                 @RequestBody Conge conge){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.congeService.updateConge(conge,idConge));
    }

    @DeleteMapping("api/p1/conge/delete_by_id/{idConge}")
    public ResponseEntity<String> deleteAbsenceById(@PathVariable Long idConge){
        this.congeService.deleteConge(idConge);
        return ResponseEntity
                .status(202)
                .body("This conge has been deleted successfully ! ");
    }
}

package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.Formation;
import com.groupe.Worktopia.service.formation.FormationServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormationController {

    public  final FormationServer formationServer;
    public FormationController(FormationServer formationServer){
        this.formationServer = formationServer;
    }

    @PostMapping(path = "api/formation/add")
    public ResponseEntity<String> addFormation(@RequestBody Formation formation){
        this.formationServer.addFormation(formation);
        return ResponseEntity
                .status(200)
                .body("Formation added successfully!");
    }

    @GetMapping(path = "api/formation/get_by_id/{formationId}")
    public ResponseEntity<Formation> getFormationById(Integer formationId){
        return  ResponseEntity
                .status(202)
                .body(this.formationServer.getFormationById(formationId));
    }

    @GetMapping(path = "api/formation/get_all")
    public ResponseEntity<List<Formation>> getFormations(){

        return  ResponseEntity
                .status(202)
                .body(this.formationServer.getFormations());
    }

    @PutMapping(path = "api/formation/update_by_id/{formationId}")

    public ResponseEntity<String> updateFormation( Integer formationId,  @RequestBody Formation formation){
        this.formationServer.updateFormationById(formationId, formation);
        return ResponseEntity
                .status(202)
                .body("Formation updated successfully !");
    }

    @PutMapping(path = "api/formation/delete_by_id")
    public ResponseEntity<String> deleteById(Integer formationId){
        this.formationServer.deleteFormationById(formationId);
      return ResponseEntity
              .status(202)
              .body("Formation deleted succssfully !");
    }
}

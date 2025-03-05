package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.Demandeformation;
import com.groupe.Worktopia.service.demandeformation.DemanformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemandeformationController {
    public final DemanformationService demanformationService;
    public DemandeformationController(DemanformationService demanformationService){
        this.demanformationService = demanformationService;
    }

    @PostMapping(path = "api/demandeformation/add")
    public ResponseEntity<String> addDemandeformation(@RequestBody Demandeformation demandeformation){
        this.demanformationService.addDemande(demandeformation);

        return  ResponseEntity
                .status(200)
                .body("Demande created successfully !");

    }

    @GetMapping(path = "api/demandeformation/get_by_id/{demandeformationId}")
    public ResponseEntity<Demandeformation>  getDemandeById(Integer demandeformationId){
        return ResponseEntity
                .status(202)
                .body(this.demanformationService.getDemandeById(demandeformationId));
    }

    @GetMapping(path = "api/demandeformation/get_all")
    public ResponseEntity<List<Demandeformation>> getAllDemande(){

        return ResponseEntity
                .status(202)
                .body(this.demanformationService.getDemandes());
    }

    @PutMapping(path = "api/demandeformation/update_by_id/{demandeformationId}")
    public ResponseEntity<String> updateDemande(Integer demandeformationId, @RequestBody Demandeformation demandeformation){
        this.demanformationService.updateDemande(demandeformationId, demandeformation);
        return ResponseEntity
                .status(202)
                .body("Demande updated successfully !");
    }


    @PutMapping(path = "api/demandeformation/delete_by_id/{demandeformationId}")
    public ResponseEntity<String> deleteDemande(Integer demandeformationId){
        this.demanformationService.deleteDemande(demandeformationId);

        return ResponseEntity
                .status(202)
                .body("Demande deleted successfully !");
    }

}

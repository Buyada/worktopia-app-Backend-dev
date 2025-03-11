package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.entities.Demandeformation;
import com.groupe.Worktopia.service.demandeformation.DemandeformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemandeformationController {
    public final DemandeformationService demandeformationService;
    public DemandeformationController(DemandeformationService demandeformationService){
        this.demandeformationService = demandeformationService;
    }

    @PostMapping(path = "api/demandeformation/add")
    public ResponseEntity<String> addDemandeformation(@RequestBody DemandeformationReqDTO demandeformationReqDTO){
        this.demandeformationService.addDemande(demandeformationReqDTO);

        return  ResponseEntity
                .status(200)
                .body("Demande created successfully !");

    }

    @GetMapping(path = "api/demandeformation/get_by_id/{demandeformationId}")
    public ResponseEntity<DemandeformationResDTO>  getDemandeById(Integer demandeformationId){
        return ResponseEntity
                .status(202)
                .body(this.demandeformationService.getDemandeById(demandeformationId));
    }

    @GetMapping(path = "api/demandeformation/get_all")
    public ResponseEntity<List<DemandeformationResDTO>> getAllDemande(){

        return ResponseEntity
                .status(202)
                .body(this.demandeformationService.getDemandes());
    }

    @PutMapping(path = "api/demandeformation/update_by_id/{demandeformationId}")
    public ResponseEntity<String> updateDemande(Integer demandeformationId, @RequestBody DemandeformationReqDTO demandeformationReqDTO){
        this.demandeformationService.updateDemande(demandeformationId, demandeformationReqDTO);
        return ResponseEntity
                .status(202)
                .body("Demande updated successfully !");
    }


    @PutMapping(path = "api/demandeformation/delete_by_id/{demandeformationId}")
    public ResponseEntity<String> deleteDemande(Integer demandeformationId){
        this.demandeformationService.deleteDemande(demandeformationId);

        return ResponseEntity
                .status(202)
                .body("Demande deleted successfully !");
    }

}

package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.dto.PageRequestDTO;
import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Categorie;
import com.groupe.Worktopia.entities.Formation;
import com.groupe.Worktopia.repository.FormationRepo;
import com.groupe.Worktopia.service.formation.FormationServer;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormationController {

    public  final FormationServer formationServer;
    public final FormationRepo formationRepo;
    public FormationController(FormationServer formationServer, FormationRepo formationRepo){
        this.formationServer = formationServer;
        this.formationRepo = formationRepo;
    }

    @PostMapping(path = "api/formation/add")
    public ResponseEntity<String> addFormation(@Valid @RequestBody FormationReqDTO formationReqDTO){
        this.formationServer.addFormation(formationReqDTO   );
        return ResponseEntity
                .status(201)
                .body("Formation added successfully!");
    }

    @GetMapping(path = "api/formation/get_by_id/{formationId}")
    public ResponseEntity<FormationResDTO> getFormationById(Integer formationId){
        return  ResponseEntity
                .status(202)
                .body(this.formationServer.getFormationById(formationId));
    }

    @GetMapping(path = "api/formation/get_all")
    public ResponseEntity<List<FormationResDTO>> getFormations(){

        return  ResponseEntity
                .status(202)
                .body(this.formationServer.getFormations());
    }

    @PutMapping(path = "api/formation/update_by_id/{formationId}")

    public ResponseEntity<String> updateFormation( Integer formationId,  @RequestBody FormationReqDTO                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          formationReqDTO){
        this.formationServer.updateFormationById(formationId, formationReqDTO);
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

//    @GetMapping(path = "api/formation/get_formation_by_category/{categorieId}")
//    public ResponseEntity<List<Formation>> gettestGetFormat(@PathVariable Integer  categorieId){
//        return ResponseEntity
//                .status(200)
//                .body(this.formationServer.testGetFormationByCategory(categorieId));
//    }

    @PostMapping(path = "api/formation/pagination")
    public Page<Formation> getAllFormationUsingPagination(@RequestBody PageRequestDTO pageRequestDTO){
        Pageable pageable = new PageRequestDTO().getPageable(pageRequestDTO);
        Page<Formation> formationPage = this.formationRepo.findAll(pageable);
        return  formationPage;
    }
}

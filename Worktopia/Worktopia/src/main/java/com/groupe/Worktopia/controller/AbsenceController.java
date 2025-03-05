package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.service.Absence.AbsenceService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @Operation(summary = "add new Absence ", description = "Allow to add new Absence")
    @PostMapping("api/p1/Absence/add")
    public ResponseEntity<Absence> addAbsence(@RequestBody @Valid Absence absence){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.absenceService.addAbsence(absence));

    }

    @GetMapping(path = "api/p1/absence/get_all_absence")
    public  ResponseEntity<List<Absence>> getAllAbsence(){
        return ResponseEntity.status(200).body(this.absenceService.getAllAbsence());

    }


    @GetMapping(path = "api/p1/absence/get_by_id/{idAbsence}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Long idAbsence){
        return ResponseEntity
                .status(200)
                .body(this.absenceService.getAbsenceById(idAbsence));
    }


    @PutMapping(path = "api/p1/absence/update_by_id/{idAbsence}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable Long idAbsence,
                                                 @RequestBody Absence absence){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.absenceService.updateAbsence(absence,idAbsence));
    }


    @DeleteMapping("api/p1/absence/delete_by_id/{idAbsence}")
    public ResponseEntity<String> deleteAbsenceById(@PathVariable Long idAbsence){
        this.absenceService.deleteAbsence(idAbsence);
        return ResponseEntity
                .status(202)
                .body("This absence was deleted successfully ! ");
    }
}

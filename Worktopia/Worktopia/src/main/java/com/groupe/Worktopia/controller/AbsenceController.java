package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.service.Absence.AbsenceService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @Operation(summary = "add new Absence ", description = "Allow to add new Absence")
    @PostMapping("api/p1/Absence/add")
    public ResponseEntity addAbsence(@RequestBody @Valid Absence absence){
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
        Optional<Absence> absence = absenceService.findById(idAbsence);
        return absence.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseThrow(() -> new ResourceNotFoundException("Absence not found"));


    }
@PutMapping(path = "api/p1/absence/update_by_id/{idAbsence}")
public ResponseEntity<Absence> updateAbsence(@PathVariable Long idAbsence,
                                             @RequestBody Absence updatedAbsence) {
    Optional<Absence> existingAbsenceOpt = absenceService.findById(idAbsence);

    if (existingAbsenceOpt.isPresent()) {
        Absence existingAbsence = existingAbsenceOpt.get();
        existingAbsence.setNombreAbsence(updatedAbsence.getNombreAbsence());

        Absence savedAbsence = absenceService.save(existingAbsence);
        return new ResponseEntity<>(savedAbsence, HttpStatus.OK);
    } else {
        throw new ResourceNotFoundException("Absence not found with id: " + idAbsence);
    }
}




@DeleteMapping("/api/p1/absence/delete_by_id/{idAbsence}")
public ResponseEntity<String> deleteAbsenceById(@PathVariable Long idAbsence) {
    absenceService.deleteAbsence(idAbsence);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body("This absence was deleted successfully!");
}
}
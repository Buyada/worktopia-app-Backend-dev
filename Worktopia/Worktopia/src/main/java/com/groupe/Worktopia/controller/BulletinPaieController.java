package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.repository.EmployeRepo;
import com.groupe.Worktopia.service.Employe.EmployeService;
import com.groupe.Worktopia.service.payement.PayementService;
import com.groupe.Worktopia.service.payement.PayementServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class BulletinPaieController {

    private EmployeRepo employeRepo;
    private BulletinPaieRepo bulletinPaieRepo;
    private PayementServiceImpl payementServiceImpl;
    private EmployeService employeService;

    public BulletinPaieController(
            BulletinPaieRepo bulletinPaieRepo,
            EmployeRepo employeRepo,
            PayementServiceImpl payementServiceImpl) {
        this.bulletinPaieRepo = bulletinPaieRepo;
        this.employeRepo = employeRepo;
        this.payementServiceImpl = payementServiceImpl;
        this.employeService = employeService;
    }

    @GetMapping(path = "/api/bulletinPaie/get_All")
    public ResponseEntity<List<BulletinPaie>> getAllBulletin() {
        return ResponseEntity.status(200).body(bulletinPaieRepo.findAll());
    }

    @GetMapping(path = "/api/bulletinPaie/get_by_Id/{bulletinId}")
    public ResponseEntity<BulletinPaie> getBulletinById(@PathVariable Long bulletinId){
        BulletinPaie bulletin = this.payementServiceImpl.getBulletinPaieById(bulletinId);
        return ResponseEntity.status(200).body(bulletin);
    }


    //generer un bulletin de paie pour un employe
    @PostMapping(path = "api/bulletinPaie/generate/{employeId}")
    public ResponseEntity<String> generateBulletin(@PathVariable Long employeId){
       BulletinPaie bulletinPaie = payementServiceImpl.genererBulletinPaie(employeId);
        return ResponseEntity.status(200).body("generer avec succes !");
    }


    @PutMapping(path = "api/bulletinPaie/update_by_id/{bulletinId}")
    public ResponseEntity<String> updateBulletin(@PathVariable Long bulletinId, @RequestBody BulletinPaie bulletinPaie){
        this.payementServiceImpl.updateBulletinPaie(bulletinId,bulletinPaie);
        return ResponseEntity.status(200).body("bulletin modifie avec succces !");
    }

    @DeleteMapping(path = "/api/bulletinPaie/delete_by_Id/{bulletinId}")
    public ResponseEntity<String> deleteBulletin(@PathVariable Long bulletinId){
        this.payementServiceImpl.deleteBulletinPaie(bulletinId);
        return ResponseEntity.status(200).body("supprimer avec succes !");
    }

}

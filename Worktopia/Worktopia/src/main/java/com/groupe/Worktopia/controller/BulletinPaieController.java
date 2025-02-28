package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.repository.EmployeRepo;
import com.groupe.Worktopia.service.payement.PayementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

public class BulletinPaieController {

    private EmployeRepo employeRepo;
    private BulletinPaieRepo bulletinPaieRepo;
    private PayementService payementService;

    public BulletinPaieController(
            BulletinPaieRepo bulletinPaieRepo,
            EmployeRepo employeeRepo,
            PayementService payementService) {
        this.bulletinPaieRepo = bulletinPaieRepo;
        this.employeRepo = employeRepo;
        this.payementService = payementService;
    }
    @GetMapping
    public ResponseEntity<List<BulletinPaie>> getAllBulletin() {
        return ResponseEntity.status(200).body(bulletinPaieRepo.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BulletinPaie> getBulletinById(@PathVariable Long id){
        BulletinPaie bulletin = this.bulletinPaieRepo.findById(id).orElseThrow(()->new RuntimeException("non trouve !"));
        return ResponseEntity.status(200).body(bulletin);
    }


    //generer un bulletin de paie pour un employe
    @PostMapping("/generate/{id}")
    public ResponseEntity<BulletinPaie> generateBulletin(@PathVariable Long id){
        Employe employe = this.employeRepo.findById(id).orElseThrow(()-> new RuntimeException("employe non trouve !"));

        BulletinPaie bulletin = payementService.genererBulletinPaie(employe);

        BulletinPaie bulletinEnregistre = bulletinPaieRepo.save(bulletin);

        return ResponseEntity.status(200).body(bulletinEnregistre);
    }


    @PutMapping("/id")
    public ResponseEntity<BulletinPaie> updateBulletin(@PathVariable Long id, @RequestBody BulletinPaie updatedBull){
        BulletinPaie bulletin = this.bulletinPaieRepo.findById(id).orElseThrow(()-> new RuntimeException("bulletin non trouver!"));

        bulletin.setSalaireBrut(updatedBull.getSalaireBrut());
        bulletin.setSalaireNet(updatedBull.getSalaireNet());
        bulletin.setCotisation(updatedBull.getCotisation());
        bulletin.setDateGeneration(updatedBull.getDateGeneration());

        BulletinPaie newBulletin = bulletinPaieRepo.save(bulletin);

        return ResponseEntity.status(200).body(newBulletin);
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteBulletin(@PathVariable Long id){
        BulletinPaie bulletin = this.bulletinPaieRepo.findById(id).orElseThrow(()-> new RuntimeException("bulletin non trouver!"));

        this.bulletinPaieRepo.delete(bulletin);

        return ResponseEntity.status(200).body("supprimer avec succes !");
    }

}

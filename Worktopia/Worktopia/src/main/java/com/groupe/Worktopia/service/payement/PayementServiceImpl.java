package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.repository.EmployeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PayementServiceImpl implements PayementService {

    private BulletinPaieRepo bulletinPaieRepo;
    private EmployeRepo employeRepo;

    public PayementServiceImpl(BulletinPaieRepo bulletinPaieRepo, EmployeRepo employeRepo){
          this.bulletinPaieRepo = bulletinPaieRepo;
          this.employeRepo = employeRepo;
    }

    @Override
    public BulletinPaie genererBulletinPaie(Long idEmploye) {

        Employe employe = employeRepo.findById(idEmploye).orElseThrow(()->new RessourceNotFoundException("bulletin non trouve !"));


                double salaireBrut = employe.getSalaireBase() + employe.getPrime();
                double salaireNet =  salaireBrut;

                BulletinPaie bulletin = new BulletinPaie();

                bulletin.setSalaireBrut(salaireBrut);
                bulletin.setSalaireNet(salaireNet);
                bulletin.setDateGeneration(LocalDateTime.now());
                bulletin.setEmploye(employe);

                return bulletinPaieRepo.save(bulletin);

            }

    @Override
    public void updateBulletinPaie(Long bulletinId, BulletinPaie bulletinPaie) {
        this.bulletinPaieRepo.findById(bulletinId).orElseThrow(()->new RessourceNotFoundException("bulletin non trouve !"));

        bulletinPaie.setSalaireBrut(bulletinPaie.getSalaireBrut());
        bulletinPaie.setSalaireNet(bulletinPaie.getSalaireNet());
        bulletinPaie.setDateModification(bulletinPaie.getDateModification());

        this.bulletinPaieRepo.saveAndFlush(bulletinPaie);

    }

    @Override
    public void deleteBulletinPaie(Long bulletinId) {
        BulletinPaie bulletinPaie = this.bulletinPaieRepo.findById(bulletinId).
                orElseThrow(()-> new RessourceNotFoundException("bulletin non trouve !"));
        this.bulletinPaieRepo.delete(bulletinPaie);
    }

    @Override
    public BulletinPaie getBulletinPaieById(Long bulletinId) {
        BulletinPaie bulletin = this.bulletinPaieRepo.findById(bulletinId)
                .orElseThrow(()->new RessourceNotFoundException("bulletin non trouve !"));
        return bulletin;
    }
}


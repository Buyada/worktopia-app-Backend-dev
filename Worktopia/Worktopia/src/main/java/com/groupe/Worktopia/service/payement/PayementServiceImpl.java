package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
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
    public BulletinPaie genererBulletinPaie(Long employeId) {

        Employe employe = employeRepo.findById(employeId).orElseThrow(()->new RuntimeException("employe non trouve !"));


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
    public void updateBulletinPaie(Long id, BulletinPaie bulletinPaie) {
        this.bulletinPaieRepo.findById(id).orElseThrow(()->new RuntimeException("bulletin non trouve !"));

        bulletinPaie.setSalaireBrut(bulletinPaie.getSalaireBrut());
        bulletinPaie.setSalaireNet(bulletinPaie.getSalaireNet());
        bulletinPaie.setDateGeneration(bulletinPaie.getDateGeneration());

        this.bulletinPaieRepo.saveAndFlush(bulletinPaie);

    }

    @Override
    public void deleteBulletinPaie(Long id) {
        BulletinPaie bulletinPaie = this.bulletinPaieRepo.findById(id).
                orElseThrow(()-> new RuntimeException("bulletin non trouve !"));
        this.bulletinPaieRepo.delete(bulletinPaie);
    }

    @Override
    public BulletinPaie getBulletinPaie(Long id) {
        BulletinPaie bulletin = this.bulletinPaieRepo.findById(id)
                .orElseThrow(()->new RuntimeException("bulletin non trouve !"));
        return bulletin;
    }
}


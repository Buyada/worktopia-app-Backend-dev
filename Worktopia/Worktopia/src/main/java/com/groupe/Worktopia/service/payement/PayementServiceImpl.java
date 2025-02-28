package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.repository.BulletinPaieRepo;

import java.time.LocalDate;

public class PayementServiceImpl implements PayementService {

    private BulletinPaieRepo bulletinPaieRepo;

    public PayementServiceImpl(BulletinPaieRepo bulletinPaieRepo){
          this.bulletinPaieRepo = bulletinPaieRepo;
    }


    @Override
    public BulletinPaie genererBulletinPaie(Employe employe) {
        double salaireBrut = employe.getSalaireBase() + (employe.getHeureSupplementaire() * 100) + employe.getPrime();
        double cotisation = salaireBrut * (employe.getCotisationSociale() / 100);
        double salaireNet = salaireBrut - cotisation ;

        BulletinPaie bulletin = new BulletinPaie();

        bulletin.setEmploye(employe);
        bulletin.setSalaireBrut(salaireBrut);
        bulletin.setCotisation(cotisation);
        bulletin.setSalaireNet(salaireNet);
        bulletin.setDateGeneration(LocalDate.now());

        return bulletin;

    }
}

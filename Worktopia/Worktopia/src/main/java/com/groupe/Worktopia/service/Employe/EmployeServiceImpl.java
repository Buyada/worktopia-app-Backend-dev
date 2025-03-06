package com.groupe.Worktopia.service.Employe;


import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.repository.EmployeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepo employeRepo;
    private BulletinPaieRepo bulletinPaieRepo;
    public EmployeServiceImpl(EmployeRepo employeRepo, BulletinPaieRepo bulletinPaieRepo){
        this.employeRepo = employeRepo;
        this.bulletinPaieRepo = bulletinPaieRepo;
    }


    @Override
    public Employe updateEmploye(Long idEmploye, Employe employe) {
       Employe employeExistant = this.employeRepo.findById(idEmploye).orElseThrow(()->new RessourceNotFoundException("employe non trouve !"));
        employeExistant.setFirstName(employe.getFirstName());
        employeExistant.setLastName(employe.getLastName());
        employeExistant.setPoste(employe.getPoste());
        employeExistant.setSalaireBase(employe.getSalaireBase());
        employeExistant.setPoste(employe.getPoste());
        employeExistant.setEmail(employe.getEmail());
        employeExistant.setUpdatedAt(LocalDateTime.now());

        List<BulletinPaie> bulletinsPais = bulletinPaieRepo.findByEmployeIdEmploye(idEmploye);
        for (BulletinPaie bulletin : bulletinsPais){
            double salaireBrut = employeExistant.getSalaireBase() + employeExistant.getPrime();
            double salaireNet = salaireBrut;

            bulletin.setSalaireBrut(salaireBrut);
            bulletin.setSalaireNet(salaireNet);

            bulletinPaieRepo.save(bulletin);


        }

        return employeRepo.save(employeExistant);

    }

    @Override
    public void deleteEmploye(Long idEmploye) {
        Employe employe = this.employeRepo.findById(idEmploye).orElseThrow(()->new RessourceNotFoundException("employe non trouve !"));
        employeRepo.delete(employe);

    }

    @Override
    public void addEmploye(Employe employe) {
        employe.setCreatedAt(LocalDateTime.now());
        this.employeRepo.save(employe);
    }

    @Override
    public Employe getEmployeById(Long idEmploye) {
        return this.employeRepo.findById(idEmploye).orElseThrow(()-> new RessourceNotFoundException("employe non trouve !"));
    }
}

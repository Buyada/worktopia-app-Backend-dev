package com.groupe.Worktopia.service.Employe;


import com.groupe.Worktopia.dto.EmployeDto.EmployeDtoRq;
import com.groupe.Worktopia.dto.EmployeDto.EmployeDtoRs;
import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.exception.RessourceExistException;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.mapper.EmployeMapper;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.repository.EmployeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepo employeRepo;
    private BulletinPaieRepo bulletinPaieRepo;
    private EmployeMapper employeMapper;
    public EmployeServiceImpl(EmployeRepo employeRepo, BulletinPaieRepo bulletinPaieRepo, EmployeMapper employeMapper){
        this.employeRepo = employeRepo;
        this.bulletinPaieRepo = bulletinPaieRepo;
        this.employeMapper = employeMapper;
    }


    @Override
    public EmployeDtoRs updateEmploye(Long idEmploye, EmployeDtoRs employeDtoRs) {
       Employe employeExistant = this.employeRepo.findById(idEmploye).orElseThrow(()->new RessourceNotFoundException("employe non trouve !"));
        employeExistant.setFirstName(employeDtoRs.getFirstName());
        employeExistant.setLastName(employeDtoRs.getLastName());
        employeExistant.setPoste(employeDtoRs.getPoste());
        employeExistant.setSalaireBase(employeDtoRs.getSalaireBase());
        employeExistant.setPoste(employeDtoRs.getPoste());
        employeExistant.setEmail(employeDtoRs.getEmail());
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
    public void addEmploye(EmployeDtoRq employeDtoRq) {
        List<Employe> nouvelEmploye = this.employeRepo.findByEmail(employeDtoRq.getEmail());

        if(!nouvelEmploye.isEmpty()){
            throw new RessourceExistException("l'employe existe deja !");
        }

        Employe employe = this.employeMapper.getEmployeFromEmployeDtoRq(employeDtoRq);

        employe.setCreatedAt(LocalDateTime.now());
        this.employeRepo.save(employe);
    }

    @Override
    public EmployeDtoRs getEmployeById(Long idEmploye) {
        Employe employe = this.employeRepo.findById(idEmploye).orElseThrow(()-> new RessourceNotFoundException("employe non trouve !"));
        return this.employeMapper.getEmployeDtoRsFromEmploye(employe);
    }
}

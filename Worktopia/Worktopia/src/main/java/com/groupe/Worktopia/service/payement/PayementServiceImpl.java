package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.mapper.BulletinPaieMapper;
import com.groupe.Worktopia.mapper.EmployeMapper;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.repository.EmployeRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayementServiceImpl implements PayementService {

    private BulletinPaieRepo bulletinPaieRepo;
    private EmployeRepo employeRepo;
    private BulletinPaieMapper bulletinPaieMapper;
    private EmployeMapper employeMapper;

    public PayementServiceImpl(BulletinPaieRepo bulletinPaieRepo, EmployeRepo employeRepo, BulletinPaieMapper bulletinPaieMapper, EmployeMapper employeMapper){
          this.bulletinPaieRepo = bulletinPaieRepo;
          this.employeRepo = employeRepo;
          this.bulletinPaieMapper = bulletinPaieMapper;
          this.employeMapper = employeMapper;
    }

    @Override
    public List<BulletinPaieDto> getAllBulletinPaie() {
        List<BulletinPaie> bulletin = this.bulletinPaieRepo.findAll();
        return this.bulletinPaieMapper.toDtoList(bulletin);
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
        bulletin.setDateModification(LocalDateTime.now());

        bulletin.setEmploye(employe);

                return bulletinPaieRepo.save(bulletin);

            }

    @Override
    @Transactional
    public BulletinPaie updateBulletinPaie(Long bulletinId, BulletinPaie bulletinPaie) {

       BulletinPaie bulletinExistant = this.bulletinPaieRepo.findById(bulletinId).orElseThrow(()->new RessourceNotFoundException("bulletin non trouve !"));

       Employe employeExistant = bulletinExistant.getEmploye();


        Employe nouvelEmploye = bulletinPaie.getEmploye();
        employeExistant.setFirstName(nouvelEmploye.getFirstName());
        employeExistant.setLastName(nouvelEmploye.getLastName());
        employeExistant.setEmail(nouvelEmploye.getEmail());
        employeExistant.setPrime(nouvelEmploye.getPrime());
        employeExistant.setPoste(nouvelEmploye.getPoste());
        employeExistant.setUpdatedAt(nouvelEmploye.getUpdatedAt());

        double salaireBrut = employeExistant.getSalaireBase() + employeExistant.getPrime();
        double salaireNet = salaireBrut;

        bulletinExistant.setSalaireBrut(salaireBrut);
        bulletinExistant.setSalaireNet(salaireNet);
        bulletinExistant.setDateGeneration(LocalDateTime.now());
        bulletinExistant.setDateModification(LocalDateTime.now());

        employeRepo.save(employeExistant);

        return bulletinPaieRepo.save(bulletinExistant);

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
        this.bulletinPaieMapper.toBulletinPaieDto(bulletin);
        return bulletin;
    }
}


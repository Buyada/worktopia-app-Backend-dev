package com.groupe.Worktopia.service.Employe;


import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.exception.RessourceExistException;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.mapper.BulletinPaieMapper;
import com.groupe.Worktopia.mapper.EmployeMapper;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.repository.EmployeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public EmployeDto updateEmployeById(Long idEmploye, EmployeDto employeDto) {

        Employe employeExistant = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new RessourceNotFoundException("Employé non trouvé !"));

        employeExistant.setFirstName(employeDto.getFirstName());
        employeExistant.setLastName(employeDto.getLastName());
        employeExistant.setPoste(employeDto.getPoste());
        employeExistant.setPrime(employeDto.getPrime());
        employeExistant.setSalaireBase(employeDto.getSalaireBase());
        employeExistant.setEmail(employeDto.getEmail());
        employeExistant.setUpdatedAt(LocalDateTime.now());

        List<BulletinPaie> bulletinsPaie = bulletinPaieRepo.findByEmployeIdEmploye(idEmploye);
        for (BulletinPaie bulletin : bulletinsPaie) {
            double salaireBrut = employeExistant.getSalaireBase() + employeExistant.getPrime();
            double salaireNet = salaireBrut;

            bulletin.setSalaireBrut(salaireBrut);
            bulletin.setSalaireNet(salaireNet);
            bulletin.setDateModification(LocalDateTime.now());
        }


        bulletinPaieRepo.saveAll(bulletinsPaie);

        Employe employeMisAJour = employeRepo.save(employeExistant);

        return employeMapper.toDto(employeMisAJour);
    }

    @Override
    public List<EmployeDto> getAll() {
        List<Employe> employes = this.employeRepo.findAll();
        return this.employeMapper.toDtoList(employes);
    }

    @Override
    public void deleteEmploye(Long idEmploye) {
        Employe employe = this.employeRepo.findById(idEmploye).orElseThrow(()->new RessourceNotFoundException("employe non trouve !"));
        employeRepo.delete(employe);

    }

    @Override
    public void addEmploye(EmployeDto employeDto) {

        List<Employe> EmployeExistant = this.employeRepo.findByEmail(employeDto.getEmail());

        if(!EmployeExistant.isEmpty()){
            throw new RessourceExistException("l'employe existe deja !");
        }

        Employe employe = this.employeMapper.toEmploye(employeDto);

        employe.setCreatedAt(LocalDateTime.now());

        this.employeRepo.save(employe);
    }

    @Override
    public EmployeDto getEmployeById(Long idEmploye) {
        Employe employe = this.employeRepo.findById(idEmploye).orElseThrow(()-> new RessourceNotFoundException("employe non trouve !"));
        return (this.employeMapper.toDto(employe));
    }
}

package com.groupe.Worktopia.service.Employe;


import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.repository.EmployeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepo employeRepo;
    public EmployeServiceImpl(EmployeRepo employeRepo){
        this.employeRepo = employeRepo;
    }


    @Override
    public void updateEmploye(Long idEmploye, Employe employe) {
       this.employeRepo.findById(idEmploye).orElseThrow(()->new RessourceNotFoundException("employe non trouve !"));
        employe.setFirstName(employe.getFirstName());
        employe.setLastName(employe.getLastName());
        employe.setPoste(employe.getPoste());
        employe.setSalaireBase(employe.getSalaireBase());
        employe.setPoste(employe.getPoste());
        employe.setEmail(employe.getEmail());
        employe.setUpdatedAt(LocalDateTime.now());

        this.employeRepo.saveAndFlush(employe);

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

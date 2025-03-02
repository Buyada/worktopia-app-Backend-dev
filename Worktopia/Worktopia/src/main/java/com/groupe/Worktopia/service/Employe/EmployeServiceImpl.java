package com.groupe.Worktopia.service.Employe;


import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.repository.EmployeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepo employeRepo;
    public EmployeServiceImpl(EmployeRepo employeRepo){
        this.employeRepo = employeRepo;
    }


    @Override
    public void updateEmploye(Long employeId, Employe employe) {
       this.employeRepo.findById(employeId).orElseThrow(()->new RuntimeException("employe non trouve !"));
        employe.setFirstName(employe.getFirstName());
        employe.setLastName(employe.getLastName());
        employe.setPoste(employe.getPoste());
        employe.setSalaireBase(employe.getSalaireBase());
        employe.setPoste(employe.getPoste());

        this.employeRepo.saveAndFlush(employe);

    }

    @Override
    public void deleteEmploye(Long employeId) {
        Employe employe = this.employeRepo.findById(employeId).orElseThrow(()->new RuntimeException("employe non trouve !"));
        employeRepo.delete(employe);

    }

    @Override
    public void addEmploye(Employe employe) {
        this.employeRepo.save(employe);
    }

    @Override
    public Employe getEmploye(Long id) {
        Employe employe = this.employeRepo.findById(id).orElseThrow(()-> new RuntimeException("employe non trouve !"));
        return employe;
    }
}

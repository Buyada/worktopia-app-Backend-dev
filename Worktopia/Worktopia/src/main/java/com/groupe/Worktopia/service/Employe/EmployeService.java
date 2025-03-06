package com.groupe.Worktopia.service.Employe;

import com.groupe.Worktopia.entities.Employe;

public interface EmployeService {
    public Employe updateEmploye(Long idEmploye, Employe employe);
    void deleteEmploye(Long idEmploye);
    void addEmploye(Employe employe);
    Employe getEmployeById(Long idEmploye);

}

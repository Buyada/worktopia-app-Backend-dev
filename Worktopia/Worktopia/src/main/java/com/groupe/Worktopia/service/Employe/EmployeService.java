package com.groupe.Worktopia.service.Employe;

import com.groupe.Worktopia.entities.Employe;

public interface EmployeService {
    void updateEmploye(Long employeId, Employe employe);
    void deleteEmploye(Long employeId);
    void addEmploye(Employe employe);
    Employe getEmploye(Long Id);

}

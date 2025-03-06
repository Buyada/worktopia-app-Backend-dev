package com.groupe.Worktopia.service.Employe;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDtoRs;
import com.groupe.Worktopia.entities.Employe;

public interface EmployeService {
    public EmployeDtoRs updateEmploye(Long idEmploye, Employe employe);
    void deleteEmploye(Long idEmploye);
    void addEmploye(EmployeDtoRs employeDtoRs);
    EmployeDtoRs getEmployeById(Long idEmploye);

}

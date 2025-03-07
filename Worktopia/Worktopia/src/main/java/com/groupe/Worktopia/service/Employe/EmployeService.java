package com.groupe.Worktopia.service.Employe;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;

import com.groupe.Worktopia.entities.Employe;

public interface EmployeService {
    public EmployeDto updateEmploye(Long idEmploye, Employe employe);
    void deleteEmploye(Long idEmploye);
    void addEmploye(EmployeDto employeDto);
    EmployeDto getEmployeById(Long idEmploye);

}

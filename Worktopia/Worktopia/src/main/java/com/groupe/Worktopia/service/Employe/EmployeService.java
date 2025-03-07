package com.groupe.Worktopia.service.Employe;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;

import com.groupe.Worktopia.entities.Employe;

import java.util.List;

public interface EmployeService {
    List<EmployeDto> getAll();
    public EmployeDto updateEmployeById(Long idEmploye, EmployeDto employeDto);
    void deleteEmploye(Long idEmploye);
    void addEmploye(EmployeDto employeDto);
    EmployeDto getEmployeById(Long idEmploye);

}

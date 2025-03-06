package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDtoRq;
import com.groupe.Worktopia.dto.EmployeDto.EmployeDtoRs;
import com.groupe.Worktopia.entities.Employe;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface EmployeMapper {
    Employe getEmployeFromEmployeDtoRq(EmployeDtoRq employeDtoRq);
    EmployeDtoRs getEmployeDtoRsFromEmploye(Employe employe);
}

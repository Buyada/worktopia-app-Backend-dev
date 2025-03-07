package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import com.groupe.Worktopia.entities.Employe;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
@Configuration
public interface EmployeMapper {
    Employe toEmploye(EmployeDto employeDto);
    EmployeDto toDto(Employe employe);
    List<EmployeDto> toDtoList(List<Employe> employes);
}

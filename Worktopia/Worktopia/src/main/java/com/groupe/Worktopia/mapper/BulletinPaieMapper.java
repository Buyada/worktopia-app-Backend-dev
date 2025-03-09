package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
@Configuration
public interface BulletinPaieMapper {

    //@Mapping(target = "employe", source = "employe")
    BulletinPaieDto toBulletinPaieDto(BulletinPaie bulletinPaie);

   // @Mapping(target = "employe", source = "employe")
    BulletinPaie toBulletinPaie(BulletinPaieDto bulletinPaieDto);

    List<BulletinPaieDto> toDtoList(List<BulletinPaie> bulletinPaieList);

    // Mapper pour Employe -> EmployeDto
    EmployeDto toEmployeDto(Employe employe);

    // Mapper pour EmployeDto -> Employe
    Employe toEmploye(EmployeDto employeDto);

}

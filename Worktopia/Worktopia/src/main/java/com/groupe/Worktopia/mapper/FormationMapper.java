package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Formation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
//@Component
public interface FormationMapper {
    Formation getFormationFromFormationReqDTO(FormationReqDTO formationReqDTO);
    FormationResDTO getFormationResDTOFromFormation(Formation formation);
    List<FormationResDTO> getAllFormationsFromAllFormation(List<Formation> formations);
}

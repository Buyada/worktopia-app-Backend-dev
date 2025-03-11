package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.entities.Formation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
//@Component
public interface FormationMapper {
    Formation getFormationFromFormationReqDTO(FormationReqDTO formationReqDTO);
}

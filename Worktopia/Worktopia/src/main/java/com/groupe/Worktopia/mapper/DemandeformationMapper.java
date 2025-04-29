package com.groupe.Worktopia.mapper;


import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.entities.Demandeformation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface DemandeformationMapper {
    Demandeformation getDemandeformationFromDemandeFormationReqDTO(DemandeformationReqDTO demandeformationReqDTO);
    DemandeformationResDTO getDemandeResDTOFromDemandeformation(Demandeformation demandeformation);
    List<DemandeformationResDTO> getDemandeResDTOAllFromAllDemandeformation(List<Demandeformation> demandeformations);
}

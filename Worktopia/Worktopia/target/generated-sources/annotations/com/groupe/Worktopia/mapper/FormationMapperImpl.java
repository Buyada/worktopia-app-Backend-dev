package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.entities.Formation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-11T15:17:12+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class FormationMapperImpl implements FormationMapper {

    @Override
    public Formation getFormationFromFormationReqDTO(FormationReqDTO formationReqDTO) {
        if ( formationReqDTO == null ) {
            return null;
        }

        Formation formation = new Formation();

        formation.setIntitule( formationReqDTO.getIntitule() );
        formation.setDescription( formationReqDTO.getDescription() );
        formation.setDuree( formationReqDTO.getDuree() );

        return formation;
    }
}

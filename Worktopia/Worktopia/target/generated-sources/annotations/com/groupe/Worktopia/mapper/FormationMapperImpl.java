package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Formation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T00:06:06+0100",
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

        return formation;
    }

    @Override
    public FormationResDTO getFormationResDTOFromFormation(Formation formation) {
        if ( formation == null ) {
            return null;
        }

        FormationResDTO formationResDTO = new FormationResDTO();

        return formationResDTO;
    }

    @Override
    public List<FormationResDTO> getAllFormationsFromAllFormation(List<Formation> formations) {
        if ( formations == null ) {
            return null;
        }

        List<FormationResDTO> list = new ArrayList<FormationResDTO>( formations.size() );
        for ( Formation formation : formations ) {
            list.add( getFormationResDTOFromFormation( formation ) );
        }

        return list;
    }
}

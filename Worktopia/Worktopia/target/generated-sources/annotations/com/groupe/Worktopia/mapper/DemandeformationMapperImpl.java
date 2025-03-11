package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.entities.Demandeformation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T00:06:06+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class DemandeformationMapperImpl implements DemandeformationMapper {

    @Override
    public Demandeformation getDemandeformationFromDemandeFormationReqDTO(DemandeformationReqDTO demandeformationReqDTO) {
        if ( demandeformationReqDTO == null ) {
            return null;
        }

        Demandeformation demandeformation = new Demandeformation();

        return demandeformation;
    }

    @Override
    public DemandeformationResDTO getDemandeResDTOFromDemandeformation(Demandeformation demandeformation) {
        if ( demandeformation == null ) {
            return null;
        }

        DemandeformationResDTO demandeformationResDTO = new DemandeformationResDTO();

        return demandeformationResDTO;
    }
}

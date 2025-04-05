package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.entities.Demandeformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-05T19:00:30+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
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

    @Override
    public List<DemandeformationResDTO> getDemandeResDTOAllFromAllDemandeformation(List<Demandeformation> demandeformations) {
        if ( demandeformations == null ) {
            return null;
        }

        List<DemandeformationResDTO> list = new ArrayList<DemandeformationResDTO>( demandeformations.size() );
        for ( Demandeformation demandeformation : demandeformations ) {
            list.add( getDemandeResDTOFromDemandeformation( demandeformation ) );
        }

        return list;
    }
}

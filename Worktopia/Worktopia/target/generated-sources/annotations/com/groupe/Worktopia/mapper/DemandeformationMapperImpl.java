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
    date = "2025-03-16T04:07:05+0100",
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

        demandeformation.setObjet( demandeformationReqDTO.getObjet() );
        demandeformation.setCommentaire( demandeformationReqDTO.getCommentaire() );

        return demandeformation;
    }

    @Override
    public DemandeformationResDTO getDemandeResDTOFromDemandeformation(Demandeformation demandeformation) {
        if ( demandeformation == null ) {
            return null;
        }

        DemandeformationResDTO demandeformationResDTO = new DemandeformationResDTO();

        demandeformationResDTO.setObjet( demandeformation.getObjet() );
        demandeformationResDTO.setCommentaire( demandeformation.getCommentaire() );
        demandeformationResDTO.setDemandeformationId( demandeformation.getDemandeformationId() );

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

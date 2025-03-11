package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.categorie.CategorieReqDTO;
import com.groupe.Worktopia.entities.Categorie;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-11T02:41:04+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class CategorieMapperImpl implements CategorieMapper {

    @Override
    public Categorie getCategorieFromCategorieReqDTO(CategorieReqDTO categorieReqDTO) {
        if ( categorieReqDTO == null ) {
            return null;
        }

        Categorie categorie = new Categorie();

        categorie.setIntitule( categorieReqDTO.getIntitule() );
        categorie.setDescription( categorieReqDTO.getDescription() );
        categorie.setTypeFormation( categorieReqDTO.getTypeFormation() );

        return categorie;
    }
}

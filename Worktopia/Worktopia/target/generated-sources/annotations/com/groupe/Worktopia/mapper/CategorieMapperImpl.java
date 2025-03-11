package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.categorie.CategorieReqDTO;
import com.groupe.Worktopia.dto.categorie.CategorieResDTO;
import com.groupe.Worktopia.entities.Categorie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T00:37:39+0100",
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

    @Override
    public CategorieResDTO getCategorieResDTOFromCategorie(Categorie categorie) {
        if ( categorie == null ) {
            return null;
        }

        CategorieResDTO categorieResDTO = new CategorieResDTO();

        categorieResDTO.setCategorieId( categorie.getCategorieId() );
        categorieResDTO.setIntitule( categorie.getIntitule() );
        categorieResDTO.setDescription( categorie.getDescription() );
        categorieResDTO.setTypeFormation( categorie.getTypeFormation() );

        return categorieResDTO;
    }

    @Override
    public List<CategorieResDTO> getAllCategoriesResDTOFromAllCategories(List<Categorie> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategorieResDTO> list = new ArrayList<CategorieResDTO>( categories.size() );
        for ( Categorie categorie : categories ) {
            list.add( getCategorieResDTOFromCategorie( categorie ) );
        }

        return list;
    }
}

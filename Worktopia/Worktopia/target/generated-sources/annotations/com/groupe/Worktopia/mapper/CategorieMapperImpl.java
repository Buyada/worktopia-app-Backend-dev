package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.categorie.CategorieReqDTO;
import com.groupe.Worktopia.dto.categorie.CategorieResDTO;
import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Categorie;
import com.groupe.Worktopia.entities.Formation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T02:34:16+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
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
        categorieResDTO.setFormations( formationListToFormationResDTOList( categorie.getFormations() ) );

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

    protected FormationResDTO formationToFormationResDTO(Formation formation) {
        if ( formation == null ) {
            return null;
        }

        FormationResDTO formationResDTO = new FormationResDTO();

        formationResDTO.setFormationId( formation.getFormationId() );
        formationResDTO.setIntitule( formation.getIntitule() );
        formationResDTO.setDescription( formation.getDescription() );
        formationResDTO.setDuree( formation.getDuree() );

        return formationResDTO;
    }

    protected List<FormationResDTO> formationListToFormationResDTOList(List<Formation> list) {
        if ( list == null ) {
            return null;
        }

        List<FormationResDTO> list1 = new ArrayList<FormationResDTO>( list.size() );
        for ( Formation formation : list ) {
            list1.add( formationToFormationResDTO( formation ) );
        }

        return list1;
    }
}

package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.categorie.CategorieReqDTO;
import com.groupe.Worktopia.dto.categorie.CategorieResDTO;
import com.groupe.Worktopia.entities.Categorie;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CategorieMapper {
    Categorie getCategorieFromCategorieReqDTO(CategorieReqDTO categorieReqDTO);
    CategorieResDTO getCategorieResDTOFromCategorie(Categorie categorie);
    List<CategorieResDTO> getAllCategoriesResDTOFromAllCategories(List<Categorie> categories);
}

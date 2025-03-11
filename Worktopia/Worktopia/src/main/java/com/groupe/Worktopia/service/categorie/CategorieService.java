package com.groupe.Worktopia.service.categorie;

import com.groupe.Worktopia.dto.categorie.CategorieReqDTO;
import com.groupe.Worktopia.dto.categorie.CategorieResDTO;
import com.groupe.Worktopia.entities.Categorie;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CategorieService {
    void addCategorie(CategorieReqDTO categorieReqDTO);
    CategorieResDTO getCategorieById(Integer CategorieId);
    List<CategorieResDTO> getCategories();
void updateCategorieById(Integer categorieId, CategorieResDTO categorieResDTO);
    void deleteById(Integer CategorieId);
}

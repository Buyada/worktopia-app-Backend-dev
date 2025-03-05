package com.groupe.Worktopia.service.categorie;

import com.groupe.Worktopia.entities.Categorie;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CategorieService {
    void addCategorie(Categorie categorie);
    Categorie getCategorieById(Integer CategorieId);
    List<Categorie> getCategories();
void updateCategorieById(Integer categorieId, Categorie categorie);
    void deleteById(Integer CategorieId);
}

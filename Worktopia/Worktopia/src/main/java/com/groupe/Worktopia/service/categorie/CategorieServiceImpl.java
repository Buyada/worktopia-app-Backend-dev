package com.groupe.Worktopia.service.categorie;


import com.groupe.Worktopia.entities.Categorie;
import com.groupe.Worktopia.repository.CategorieRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    public final CategorieRepo categorieRepo;
    public CategorieServiceImpl(CategorieRepo categorieRepo){

        this.categorieRepo = categorieRepo;
    }

    @Override
    public void addCategorie(Categorie categorie) {
        categorie.setCreatedAt(new Date());
        this.categorieRepo.save(categorie);
    }

    @Override
    public Categorie getCategorieById(Integer categorieId) {
        return this.categorieRepo.findById(categorieId).get();
    }

    @Override
    public List<Categorie> getCategories() {
        return this.categorieRepo.findAll();
    }

    @Override
    public void updateCategorieById(Integer categorieId, Categorie categorie) {
        Categorie categorieToUpdate = this.categorieRepo.findById(categorieId).get();
        categorieToUpdate.setIntitule(categorie.getIntitule());
        categorieToUpdate.setDescription(categorie.getDescription());
        categorieToUpdate.setTypeFormation(categorie.getTypeFormation());
        categorieToUpdate.setUpdatedAt(new Date());
        this.categorieRepo.saveAndFlush(categorieToUpdate);

    }

    @Override
    public void deleteById(Integer categorieId) {
        this.categorieRepo.deleteById(categorieId);
    }
}

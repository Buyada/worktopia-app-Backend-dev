package com.groupe.Worktopia.service.categorie;


import com.groupe.Worktopia.dto.categorie.CategorieReqDTO;
import com.groupe.Worktopia.dto.categorie.CategorieResDTO;
import com.groupe.Worktopia.entities.Categorie;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.mapper.CategorieMapper;
import com.groupe.Worktopia.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private final CategorieRepo categorieRepo;
    @Autowired
    private final CategorieMapper categorieMapper;

    public CategorieServiceImpl(CategorieRepo categorieRepo, CategorieMapper categorieMapper){

        this.categorieRepo = categorieRepo;

        this.categorieMapper = categorieMapper;
    }

    @Override
    public void addCategorie(CategorieReqDTO categorieReqDTO) {
        Optional<Categorie> CategorieAdd = this.categorieRepo.findByIntitule(categorieReqDTO.getIntitule());
        if(CategorieAdd.isPresent())
            throw new ResourceExistException("The record already exists !");

        Categorie categorie = this.categorieMapper.getCategorieFromCategorieReqDTO(categorieReqDTO);
            categorie.setCreatedAt(new Date());
        this.categorieRepo.save(categorie);
    }

    @Override
    public CategorieResDTO getCategorieById(Integer categorieId) {
        Categorie categorie = this.categorieRepo
                .findById(categorieId)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found !"));
        return this.categorieMapper.getCategorieResDTOFromCategorie(categorie);
    }

    @Override
    public List<Categorie> getCategories() {
        return this.categorieRepo.findAll();
    }

    @Override
    public void updateCategorieById(Integer categorieId, Categorie categorie) {

        Categorie categorieToUpdate = this.categorieRepo.findById(categorieId).orElseThrow(()-> new ResourceNotFoundException("Resource not Found"));
        categorieToUpdate.setIntitule(categorie.getIntitule());
        categorieToUpdate.setDescription(categorie.getDescription());
        categorieToUpdate.setTypeFormation(categorie.getTypeFormation());
        categorieToUpdate.setUpdatedAt(new Date());
        this.categorieRepo.saveAndFlush(categorieToUpdate);

    }

    @Override
    public void deleteById(Integer categorieId) {
        Categorie categoryToDelete = this.categorieRepo.findById(categorieId)
                .orElseThrow(()->new ResourceNotFoundException("Category not found !"));
        this.categorieRepo.delete(categoryToDelete);
    }
}

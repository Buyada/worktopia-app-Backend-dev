package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.Categorie;
import com.groupe.Worktopia.service.categorie.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    public final CategorieService categorieService;
     public CategorieController(CategorieService categorieService){
        this.categorieService = categorieService;
     }

     @PostMapping(path = "api/categorie/add")
     public ResponseEntity<String> addCategorie(@RequestBody Categorie categorie){
        this.categorieService.addCategorie(categorie);
        return ResponseEntity
            .status(200)
            .body("Category added successfully");
     }

     @GetMapping(path = "api/categorie/get_by_id/{categorieId}")
    public ResponseEntity<Categorie> getCategorieById(Integer categorieId){
         return ResponseEntity
                 .status(202).
                 body(this.categorieService.getCategorieById(categorieId));
     }

     @GetMapping(path = "api/categorie/get_all")
    public ResponseEntity<List<Categorie>> listeCategorie(){
         return ResponseEntity
                 .status(202)
                 .body(this.categorieService.getCategories());
     }

     @PutMapping(path = "api/categorie/update_by_id/{categorieId}")
     public ResponseEntity<String> updateEntityById(Integer categorieId, Categorie categorie){
         this.categorieService.updateCategorieById(categorieId, categorie);
         return ResponseEntity
                 .status(202)
                 .body("Category updated suceessfully");
     }

     @PutMapping(path = "api/categorie/delete_by_id/{categorieId}")
     public ResponseEntity<String> delete_categorie_by_id(Integer categorieId ){
         this.categorieService.deleteById(categorieId);
         return ResponseEntity
                 .status(202)
                 .body(" Category deleted successfully");
     }
}

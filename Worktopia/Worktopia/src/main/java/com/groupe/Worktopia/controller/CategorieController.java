package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.dto.PageRequestDTO;
import com.groupe.Worktopia.dto.categorie.CategorieReqDTO;
import com.groupe.Worktopia.dto.categorie.CategorieResDTO;
import com.groupe.Worktopia.entities.Categorie;
import com.groupe.Worktopia.mapper.CategorieMapper;
import com.groupe.Worktopia.repository.CategorieRepo;
import com.groupe.Worktopia.service.categorie.CategorieService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    public final CategorieService categorieService;
    public final CategorieRepo categorieRepo;
    public final CategorieMapper categorieMapper;
     public CategorieController(CategorieService categorieService, CategorieRepo categorieRepo, CategorieMapper categorieMapper){
        this.categorieService = categorieService;
         this.categorieRepo = categorieRepo;
         this.categorieMapper = categorieMapper;
     }

     @PostMapping(path = "api/categorie/add")
     public ResponseEntity<String> addCategorie(@Valid @RequestBody CategorieReqDTO categorieReqDTO){
        this.categorieService.addCategorie(categorieReqDTO);
        return ResponseEntity
            .status(200)
            .body("Category added successfully");
     }

     @GetMapping(path = "api/categorie/get_by_id/{categorieId}")
    public ResponseEntity<CategorieResDTO> getCategorieById(Integer categorieId){
         return ResponseEntity
                 .status(202).
                 body(this.categorieService.getCategorieById(categorieId));
     }

     @GetMapping(path = "api/categorie/get_all")
    public ResponseEntity<List<CategorieResDTO>> listeCategorie(){
         return ResponseEntity
                 .status(202)
                 .body(this.categorieService.getCategories());
     }

     @PutMapping(path = "api/categorie/update_by_id/{categorieId}")
     public ResponseEntity<String> updateEntityById(Integer categorieId, CategorieResDTO categorieResDTO){
         this.categorieService.updateCategorieById(categorieId, categorieResDTO);
         return ResponseEntity
                 .status(202)
                 .body("Category updated sucessfully");
     }
     @PostMapping(path = "api/categorie/pagination")
     public Page<CategorieResDTO> getAllCategorieUsingPagination(@RequestBody PageRequestDTO pageRequestDTO){
         Pageable pageable = new PageRequestDTO().getPageable(pageRequestDTO);
         Page<Categorie> categoriePage = this.categorieRepo.findAll(pageable);
         return  categoriePage.map(this.categorieMapper::getCategorieResDTOFromCategorie);
     }

     @PutMapping(path = "api/categorie/delete_by_id/{categorieId}")
     public ResponseEntity<String> delete_categorie_by_id(Integer categorieId ){
         this.categorieService.deleteById(categorieId);
         return ResponseEntity
                 .status(202)
                 .body(" Category deleted successfully");
     }
}

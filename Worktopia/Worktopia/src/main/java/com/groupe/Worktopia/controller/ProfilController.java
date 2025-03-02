package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.service.Profil.ProfilService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfilController {

    public final ProfilService profilService;

    public ProfilController(ProfilService profilService) {
        this.profilService = profilService;
    }

//    @PostMapping(path = "api/profile/add")
//    public ResponseEntity<String> addProfile(@Valid @RequestBody Profil profil){
//        this.profilService.addProfil(profil);
//
//        return ResponseEntity
//                .status(201)
//                .body("Profile added successfully !");
//    }

//    @GetMapping(path = "api/profile/get_by_id/{profileId}")
//    public ResponseEntity<Profil> getProfileById(@PathVariable Integer profileId){
//
//        return ResponseEntity
//                .status(200)
//                .body(this.profilService.getProfil(profileId));
//    }

//    @GetMapping(path = "api/prodfile/get_all")
//    public ResponseEntity<List<Profil>> getProfiles(){
//        return ResponseEntity
//                .status(201)
//                .body(this.profilService.getProfils());
//    }

    @PutMapping(path = "api/profil/updateProfileById/{profileId}")
    public ResponseEntity<String> updateProfile(Integer profileId, @Valid @RequestBody Profil profil){
        this.profilService.updateProfil(profileId, profil);

        return ResponseEntity
                .status(202)
                .body("Profile updated successfully !");
    }

    @PutMapping(path = "api/profil/deletebyid/{profileId}")
    public ResponseEntity<String> profileDel(@PathVariable Integer profileId){
        this.profilService.deleteProfil(profileId);
        return ResponseEntity
                .status(202)
                .body("Profile deleted successfully !");
    }
}

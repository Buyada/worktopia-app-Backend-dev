package com.groupe.Worktopia.service.Profil;


import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.repository.ProfilRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfilServiceImpl implements ProfilService {

    public final ProfilRepo profilRepo;

    public ProfilServiceImpl(ProfilRepo profilRepo) {
        this.profilRepo = profilRepo;
    }

    @Override
    public void addProfile(Profil profil) {
        this.profilRepo.save(profil);
    }

    @Override
    public Profil getProfilById(Integer profilId) {
        return this.profilRepo.findById(profilId).get();
    }

    @Override
    public List<Profil> getProfils() {
        return this.profilRepo.findAll();
    }

    @Override
    public void updateProfilById(Integer profilId, Profil profil) {
        Profil profileToUpdate = this.profilRepo.findById(profilId).get();
        profileToUpdate.setUsername(profil.getUsername());

        this.profilRepo.saveAndFlush(profileToUpdate);
    }

    @Override
    public void deleteById(Integer profilId) {
        Profil profileToDelete = this.profilRepo.findById(profilId).get();
        this.profilRepo.deleteById(profilId);
    }
}

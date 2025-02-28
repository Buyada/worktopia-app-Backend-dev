package com.groupe.Worktopia.service.Profil;

import com.groupe.Worktopia.entities.Profil;

import java.util.List;

public interface ProfilService {
    void addProfile(Profil profil);
    Profil getProfilById(Integer profilId);
    List<Profil> getProfils();
    void updateProfilById(Integer profilId, Profil profil);
    void deleteById(Integer profilId);
}

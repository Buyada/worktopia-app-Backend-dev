package com.groupe.Worktopia.service.Profil;

import com.groupe.Worktopia.entities.Profil;

import java.util.List;

public interface ProfilService {
    void addProfil(Profil profil);
    Profil getProfil(int id);
    List<Profil> getProfils();
    void updateProfil(Integer profilId, Profil profil);
    void deleteProfil(Integer profilId);

}

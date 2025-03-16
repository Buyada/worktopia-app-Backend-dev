package com.groupe.Worktopia.service.Profil;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.entities.Profil;

import java.util.List;

public interface ProfilService {
    void addProfil(ProfilReqDTO profilReqDTO);
    ProfilResDTO getProfil(int id);
    List<ProfilResDTO> getProfils();
    void updateProfil(Integer profilId, ProfilReqDTO profilReqDTO);
    void deleteProfil(Integer profilId);

}

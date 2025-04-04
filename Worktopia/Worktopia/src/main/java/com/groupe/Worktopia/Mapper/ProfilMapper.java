package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.entities.Profil;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
//@Component
public interface ProfilMapper {
    Profil getProfileFromProfilReqDTO(ProfilReqDTO profilReqDTO);
    ProfilResDTO getProfilResDTOFromProfil(Profil profil);
    List<ProfilResDTO> getProfilResDTOFromProfils(List<Profil> profil);
}

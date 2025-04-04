package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.entities.Profil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-04T23:14:58+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ProfilMapperImpl implements ProfilMapper {

    @Override
    public Profil getProfileFromProfilReqDTO(ProfilReqDTO profilReqDTO) {
        if ( profilReqDTO == null ) {
            return null;
        }

        Profil profil = new Profil();

        return profil;
    }

    @Override
    public ProfilResDTO getProfilResDTOFromProfil(Profil profil) {
        if ( profil == null ) {
            return null;
        }

        ProfilResDTO profilResDTO = new ProfilResDTO();

        return profilResDTO;
    }

    @Override
    public List<ProfilResDTO> getProfilResDTOFromProfils(List<Profil> profil) {
        if ( profil == null ) {
            return null;
        }

        List<ProfilResDTO> list = new ArrayList<ProfilResDTO>( profil.size() );
        for ( Profil profil1 : profil ) {
            list.add( getProfilResDTOFromProfil( profil1 ) );
        }

        return list;
    }
}

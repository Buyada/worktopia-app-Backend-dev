package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.entities.Profil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T16:17:35+0100",
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

        profil.setUsername( profilReqDTO.getUsername() );
        byte[] cv = profilReqDTO.getCv();
        if ( cv != null ) {
            profil.setCv( Arrays.copyOf( cv, cv.length ) );
        }

        return profil;
    }

    @Override
    public ProfilResDTO getProfilResDTOFromProfil(Profil profil) {
        if ( profil == null ) {
            return null;
        }

        ProfilResDTO profilResDTO = new ProfilResDTO();

        profilResDTO.setProfilId( profil.getProfilId() );
        profilResDTO.setUsername( profil.getUsername() );
        byte[] cv = profil.getCv();
        if ( cv != null ) {
            profilResDTO.setCv( Arrays.copyOf( cv, cv.length ) );
        }

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

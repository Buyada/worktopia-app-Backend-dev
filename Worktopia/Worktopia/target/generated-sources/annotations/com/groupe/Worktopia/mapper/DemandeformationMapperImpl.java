package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import com.groupe.Worktopia.dto.user.UserResDTO;
import com.groupe.Worktopia.entities.Demandeformation;
import com.groupe.Worktopia.entities.Formation;
import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.entities.Role;
import com.groupe.Worktopia.entities.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-30T02:44:19+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class DemandeformationMapperImpl implements DemandeformationMapper {

    @Override
    public Demandeformation getDemandeformationFromDemandeFormationReqDTO(DemandeformationReqDTO demandeformationReqDTO) {
        if ( demandeformationReqDTO == null ) {
            return null;
        }

        Demandeformation demandeformation = new Demandeformation();

        demandeformation.setObjet( demandeformationReqDTO.getObjet() );
        demandeformation.setCommentaire( demandeformationReqDTO.getCommentaire() );

        return demandeformation;
    }

    @Override
    public DemandeformationResDTO getDemandeResDTOFromDemandeformation(Demandeformation demandeformation) {
        if ( demandeformation == null ) {
            return null;
        }

        DemandeformationResDTO demandeformationResDTO = new DemandeformationResDTO();

        demandeformationResDTO.setUserResDTO( userToUserResDTO( demandeformation.getUser() ) );
        demandeformationResDTO.setFormationResDTO( formationToFormationResDTO( demandeformation.getFormation() ) );
        demandeformationResDTO.setDemandeformationId( demandeformation.getDemandeformationId() );
        demandeformationResDTO.setObjet( demandeformation.getObjet() );
        demandeformationResDTO.setCommentaire( demandeformation.getCommentaire() );

        return demandeformationResDTO;
    }

    @Override
    public List<DemandeformationResDTO> getDemandeResDTOAllFromAllDemandeformation(List<Demandeformation> demandeformations) {
        if ( demandeformations == null ) {
            return null;
        }

        List<DemandeformationResDTO> list = new ArrayList<DemandeformationResDTO>( demandeformations.size() );
        for ( Demandeformation demandeformation : demandeformations ) {
            list.add( getDemandeResDTOFromDemandeformation( demandeformation ) );
        }

        return list;
    }

    protected RoleResDTO roleToRoleResDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResDTO roleResDTO = new RoleResDTO();

        roleResDTO.setRoleId( role.getRoleId() );
        roleResDTO.setRolename( role.getRolename() );

        return roleResDTO;
    }

    protected ProfilResDTO profilToProfilResDTO(Profil profil) {
        if ( profil == null ) {
            return null;
        }

        ProfilResDTO profilResDTO = new ProfilResDTO();

        profilResDTO.setFirstname( profil.getFirstname() );
        profilResDTO.setLastname( profil.getLastname() );
        profilResDTO.setNumerotelephone( profil.getNumerotelephone() );
        profilResDTO.setAdresse( profil.getAdresse() );
        profilResDTO.setDatedenaissance( profil.getDatedenaissance() );
        profilResDTO.setGenre( profil.getGenre() );
        byte[] photodeprofil = profil.getPhotodeprofil();
        if ( photodeprofil != null ) {
            profilResDTO.setPhotodeprofil( Arrays.copyOf( photodeprofil, photodeprofil.length ) );
        }
        byte[] cv = profil.getCv();
        if ( cv != null ) {
            profilResDTO.setCv( Arrays.copyOf( cv, cv.length ) );
        }
        profilResDTO.setProfilId( profil.getProfilId() );

        return profilResDTO;
    }

    protected UserResDTO userToUserResDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResDTO userResDTO = new UserResDTO();

        userResDTO.setRoleResDTO( roleToRoleResDTO( user.getRole() ) );
        userResDTO.setProfilResDTO( profilToProfilResDTO( user.getProfil() ) );
        userResDTO.setUsername( user.getUsername() );
        userResDTO.setMotDePasse( user.getMotDePasse() );
        userResDTO.setEmail( user.getEmail() );

        return userResDTO;
    }

    protected FormationResDTO formationToFormationResDTO(Formation formation) {
        if ( formation == null ) {
            return null;
        }

        FormationResDTO formationResDTO = new FormationResDTO();

        formationResDTO.setFormationId( formation.getFormationId() );
        formationResDTO.setIntitule( formation.getIntitule() );
        formationResDTO.setDescription( formation.getDescription() );
        formationResDTO.setDuree( formation.getDuree() );

        return formationResDTO;
    }
}

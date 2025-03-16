package com.groupe.Worktopia.service.Profil;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.entities.User;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.mapper.ProfilMapper;
import com.groupe.Worktopia.repository.ProfilRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilServiceImpl implements ProfilService{
    public final ProfilRepo profilRepo;
    private  final ProfilMapper profilMapper;

    public ProfilServiceImpl(ProfilRepo profilRepo, ProfilMapper profilMapper) {

        this.profilRepo = profilRepo;
        this.profilMapper = profilMapper;
    }


    @Override
    public void addProfil(ProfilReqDTO profilReqDTO) {

        Optional<Profil> addProfil = this.profilRepo.findByusername(profilReqDTO.getUsername());
        if (addProfil.isPresent())
           throw new ResourceExistException("The profile already exist !");

        Profil profil = this.profilMapper.getProfileFromProfilReqDTO(profilReqDTO);
        profil.setCreatedAt(new Date());
        this.profilRepo.save(profil);
   }

    @Override
    public ProfilResDTO getProfil(int id) {
    Profil profil = this.profilRepo.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Resource not found !"));
        return this.profilMapper.getProfilResDTOFromProfil(profil);
    }

    @Override
    public List<ProfilResDTO> getProfils() {
        List<Profil> profils = this.profilRepo.findAll();
        return this.profilMapper.getProfilResDTOFromProfils(profils);
    }

    @Override
    public void updateProfil(Integer profilId, ProfilReqDTO profilReqDTO) {
        Profil updatePro = this.profilRepo.findById(profilId)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found !"));;

        updatePro.setUsername(profilReqDTO.getUsername());
        updatePro.setCv(profilReqDTO.getCv());
        updatePro.setUpdatedAt(new Date());
        this.profilRepo.saveAndFlush(updatePro);

    }

    @Override
    public void deleteProfil(Integer profilId) {

        Profil delProfile = this.profilRepo.findById(profilId)
                .orElseThrow(()->new ResourceNotFoundException("Record to delete not found !"));
        this.profilRepo.delete(delProfile);
    }
}

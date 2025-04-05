package com.groupe.Worktopia.service.Profil;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.entities.User;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.mapper.ProfilMapper;
import com.groupe.Worktopia.repository.ProfilRepo;
import com.groupe.Worktopia.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilServiceImpl implements ProfilService{
    public final ProfilRepo profilRepo;
    private  final ProfilMapper profilMapper;
    private final UserRepo userRepo;

    public ProfilServiceImpl(ProfilRepo profilRepo, ProfilMapper profilMapper, UserRepo userRepo) {

        this.profilRepo = profilRepo;
        this.profilMapper = profilMapper;
        this.userRepo = userRepo;
    }


    @Override
    public void addProfil(ProfilReqDTO profilReqDTO, Integer userId) {

        Optional<Profil> addProfil = this.profilRepo.findByfirstname(profilReqDTO.getFirstname());
        if (addProfil.isPresent())
           throw new ResourceExistException("The profile already exist !");

        Profil profil = this.profilMapper.getProfileFromProfilReqDTO(profilReqDTO);
        profil.setCreatedAt(new Date());

        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Resource not found !"));
        profil.setUser(user);
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

        updatePro.setLastname(profilReqDTO.getLastname());
        updatePro.setFirstname(profilReqDTO.getFirstname());
        updatePro.setNumerotelephone(profilReqDTO.getNumerotelephone());
        updatePro.setAdresse(profilReqDTO.getAdresse());
        updatePro.setDatedenaissance(profilReqDTO.getDatedenaissance());
        updatePro.setGenre(profilReqDTO.getGenre());
        updatePro.setPhotodeprofil(profilReqDTO.getPhotodeprofil());
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

package com.groupe.Worktopia.service.Profil;

import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.entities.User;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.ProfilRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilServiceImpl implements ProfilService{
    public final ProfilRepo profilRepo;

    public ProfilServiceImpl(ProfilRepo profilRepo) {

        this.profilRepo = profilRepo;
    }


    @Override
    public void addProfil(Profil profil) {

        Optional<Profil> addProfil = this.profilRepo.findByFirstname(profil.getFirstname());
        if (addProfil.isPresent())
            throw new ResourceExistException("The profile already exist !");
        profil.setCreatedAt(new Date());
        this.profilRepo.save(profil);
    }

    @Override
    public Profil getProfil(int id) {

        return this.profilRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found !"));
    }

    @Override
    public List<Profil> getProfils() {
        return this.profilRepo.findAll();
    }

    @Override
    public void updateProfil(Integer profilId, Profil profil) {
        Profil updatePro = this.profilRepo.findById(profilId)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found !"));;

        updatePro.setFirstname(profil.getFirstname());
        updatePro.setLastname(profil.getLastname());
        updatePro.setNumerotelephone(profil.getNumerotelephone());
        updatePro.setDatenaissance(profil.getDatenaissance());
        updatePro.setAddresse(profil.getAddresse());
        updatePro.setCv(profil.getCv());
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

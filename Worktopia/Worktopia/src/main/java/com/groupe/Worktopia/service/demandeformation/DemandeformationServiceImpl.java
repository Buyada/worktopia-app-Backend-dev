package com.groupe.Worktopia.service.demandeformation;

import com.groupe.Worktopia.entities.Demandeformation;
import com.groupe.Worktopia.repository.DemandeformationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DemandeformationServiceImpl  implements  DemanformationService{
    public final DemandeformationRepo demandeformationRepo;
    public DemandeformationServiceImpl(DemandeformationRepo demandeformationRepo){
        this.demandeformationRepo = demandeformationRepo;
    }
    @Override
    public void addDemande(Demandeformation demandeformation) {
        demandeformation.setCreatedAt(new Date());
        this.demandeformationRepo.save(demandeformation);
    }

    @Override
    public Demandeformation getDemandeById(Integer demandeformationId) {
        return this.demandeformationRepo.findById(demandeformationId).get();
    }

    @Override
    public List<Demandeformation> getDemandes() {
        return this.demandeformationRepo.findAll();
    }

    @Override
    public void updateDemande(Integer demandeformationId, Demandeformation demandeformation) {
        Demandeformation demandeToUpdate = this.demandeformationRepo.findById(demandeformationId).get();
        demandeToUpdate.setTitreFormation(demandeformation.getTitreFormation());
        demandeToUpdate.setObjet(demandeformation.getObjet());
        demandeToUpdate.setCommentaire(demandeformation.getCommentaire());
        demandeToUpdate.setUpdatedAt(new Date());
        this.demandeformationRepo.saveAndFlush(demandeToUpdate);
    }

    @Override
    public void deleteDemande(Integer demandeformationId) {
        this.demandeformationRepo.deleteById(demandeformationId);
    }
}

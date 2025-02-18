package com.groupe.Worktopia.service.formation;

import com.groupe.Worktopia.entities.Formation;
import com.groupe.Worktopia.repository.FormationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FormationServiceImpl implements FormationServer{
    public final FormationRepo formationRepo;
    public FormationServiceImpl(FormationRepo formationRepo){
        this.formationRepo = formationRepo;
    }


    @Override
    public void addFormation(Formation formation) {
        formation.setCreatedAt(new Date());
        this.formationRepo.save(formation);
    }

    @Override
    public Formation getFormationById(Integer formationId) {
        return this.formationRepo.findById(formationId).get();
    }

    @Override
    public List<Formation> getFormations() {
        return this.formationRepo.findAll();
    }

    @Override
    public void updateFormationById(Integer formationId, Formation formation) {
        Formation formationToUpdate = this.formationRepo.findById(formationId).get();
        formationToUpdate.setIntitule(formation.getIntitule());
        formationToUpdate.setDescription(formation.getDescription());
        formationToUpdate.setDuree(formation.getDuree());
        formationToUpdate.setUpdatedAt(new Date());

        this.formationRepo.saveAndFlush(formationToUpdate);
    }

    @Override
    public void deleteFormationById(Integer formationId) {
        this.formationRepo.deleteById(formationId);
    }


}

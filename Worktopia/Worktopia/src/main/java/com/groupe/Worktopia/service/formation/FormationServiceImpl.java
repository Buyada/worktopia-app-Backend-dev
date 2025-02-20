package com.groupe.Worktopia.service.formation;

import com.groupe.Worktopia.entities.Formation;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.FormationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FormationServiceImpl implements FormationServer{
    public final FormationRepo formationRepo;

    public FormationServiceImpl(FormationRepo formationRepo){
        this.formationRepo = formationRepo;
    }


    @Override
    public void addFormation(Formation formation) {

        Optional<Formation> formationToAdd = this.formationRepo.findByIntitule(formation.getIntitule());
        if(formationToAdd.isPresent())
            throw new ResourceExistException("Resource already exist!");
        formation.setCreatedAt(new Date());
        this.formationRepo.save(formation);
    }

    @Override
    public Formation getFormationById(Integer formationId) {
        return this.formationRepo.findById(formationId)
                .orElseThrow(()-> new ResourceNotFoundException("Record not found !"));
    }

    @Override
    public List<Formation> getFormations() {
        return this.formationRepo.findAll();
    }

    @Override
    public void updateFormationById(Integer formationId, Formation formation) {
        Formation formationToUpdate = this.formationRepo.findById(formationId)
                .orElseThrow(()-> new ResourceNotFoundException("Record to update not found !"));
        formationToUpdate.setIntitule(formation.getIntitule());
        formationToUpdate.setDescription(formation.getDescription());
        formationToUpdate.setDuree(formation.getDuree());
        formationToUpdate.setUpdatedAt(new Date());

        this.formationRepo.saveAndFlush(formationToUpdate);
    }

    @Override
    public void deleteFormationById(Integer formationId) {

        Formation formationToDelete = this.formationRepo.findById(formationId)
                .orElseThrow(()-> new ResourceNotFoundException("Record to delete not found !"));
        this.formationRepo.delete(formationToDelete);
    }


}

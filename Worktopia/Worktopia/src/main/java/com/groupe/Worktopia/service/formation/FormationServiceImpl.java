package com.groupe.Worktopia.service.formation;

import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Formation;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.mapper.FormationMapper;
import com.groupe.Worktopia.repository.FormationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FormationServiceImpl implements FormationServer{
    private final FormationRepo formationRepo;
    private final FormationMapper formationMapper;


    public FormationServiceImpl(FormationRepo formationRepo, FormationMapper formationMapper){
        this.formationRepo = formationRepo;
        this.formationMapper = formationMapper;
    }


    @Override
    public void addFormation(FormationReqDTO formationReqDTO) {

        Optional<Formation> formationToAdd = this.formationRepo.findByIntitule(formationReqDTO.getIntitule());
        if(formationToAdd.isPresent())
            throw new ResourceExistException("Resource already exist!");

        Formation formation = this.formationMapper.getFormationFromFormationReqDTO(formationReqDTO);
        formation.setCreatedAt(new Date());
        this.formationRepo.save(formation);
    }

    @Override
    public FormationResDTO getFormationById(Integer formationId) {
        Formation formation = this.formationRepo.findById(formationId)
                .orElseThrow(()-> new ResourceNotFoundException("Record not found !"));
        return this.formationMapper.getFormationResDTOFromFormation(formation);
    }

    @Override
    public List<FormationResDTO> getFormations() {
        List<Formation>  formations = this.formationRepo.findAll();
        return this.formationMapper.getAllFormationsFromAllFormation(formations);
    }

    @Override
    public void updateFormationById(Integer formationId, FormationReqDTO formationReqDTO) {
        Formation formationToUpdate = this.formationRepo.findById(formationId)
                .orElseThrow(()-> new ResourceNotFoundException("Record to update not found !"));
        formationToUpdate.setIntitule(formationReqDTO.getIntitule());
        formationToUpdate.setDescription(formationReqDTO.getDescription());
        formationToUpdate.setDuree(formationReqDTO.getDuree());
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

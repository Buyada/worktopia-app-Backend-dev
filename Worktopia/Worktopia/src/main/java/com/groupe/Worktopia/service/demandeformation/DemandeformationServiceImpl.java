package com.groupe.Worktopia.service.demandeformation;

import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.entities.Demandeformation;
import com.groupe.Worktopia.entities.Formation;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.mapper.DemandeformationMapper;
import com.groupe.Worktopia.repository.DemandeformationRepo;
import com.groupe.Worktopia.repository.FormationRepo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DemandeformationServiceImpl  implements DemandeformationService {
    public final DemandeformationRepo demandeformationRepo;
    private final DemandeformationMapper demandeformationMapper;
    private  final FormationRepo formationRepo;
    @Autowired


    public DemandeformationServiceImpl(DemandeformationRepo demandeformationRepo, DemandeformationMapper demandeformationMapper, FormationRepo formationRepo){
        this.demandeformationRepo = demandeformationRepo;
        this.demandeformationMapper = demandeformationMapper;
        this.formationRepo = formationRepo;

    }
    @Override
    public void addDemande(DemandeformationReqDTO demandeformationReqDTO) {

        Formation formatonToAdd = this.formationRepo.findById(demandeformationReqDTO.getFormationId())
                .orElseThrow(() -> new ResourceNotFoundException("Formation not found !"));

        Demandeformation demandeformation = this.demandeformationMapper
                .getDemandeformationFromDemandeFormationReqDTO(demandeformationReqDTO);
        demandeformation.setCreatedAt(new Date());
        demandeformation.setFormation(formatonToAdd);
        this.demandeformationRepo.save(demandeformation);


    }
    @Override
    public DemandeformationResDTO getDemandeById(Integer demandeformationId) {
        Demandeformation demandeformation = this.demandeformationRepo.findById(demandeformationId).get();
        return this.demandeformationMapper.getDemandeResDTOFromDemandeformation(demandeformation);
    }

    @Override
    public List<DemandeformationResDTO> getDemandes() {
        List<Demandeformation> demandeformations = this.demandeformationRepo.findAll();
        return this.demandeformationMapper.getDemandeResDTOAllFromAllDemandeformation(demandeformations);
    }

    @Override
    public void updateDemande(Integer demandeformationId, DemandeformationReqDTO demandeformationReqDTO) {
        Demandeformation demandeToUpdate = this.demandeformationRepo.findById(demandeformationId).get();
        //demandeToUpdate.setTitreFormation(demandeformationResDTO.getTitreFormation());
        demandeToUpdate.setObjet(demandeformationReqDTO.getObjet());
        demandeToUpdate.setCommentaire(demandeformationReqDTO.getCommentaire());
        demandeToUpdate.setUpdatedAt(new Date());
        this.demandeformationRepo.saveAndFlush(demandeToUpdate);
    }

    @Override
    public void deleteDemande(Integer demandeformationId) {
        this.demandeformationRepo.deleteById(demandeformationId);
    }
}

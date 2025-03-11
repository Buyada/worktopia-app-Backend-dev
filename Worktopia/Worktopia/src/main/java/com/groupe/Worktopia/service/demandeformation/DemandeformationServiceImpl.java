package com.groupe.Worktopia.service.demandeformation;

import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.entities.Demandeformation;
import com.groupe.Worktopia.mapper.DemandeformationMapper;
import com.groupe.Worktopia.repository.DemandeformationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DemandeformationServiceImpl  implements DemandeformationService {
    public final DemandeformationRepo demandeformationRepo;
    private final DemandeformationMapper demandeformationMapper;
    public DemandeformationServiceImpl(DemandeformationRepo demandeformationRepo, DemandeformationMapper demandeformationMapper){
        this.demandeformationRepo = demandeformationRepo;
        this.demandeformationMapper = demandeformationMapper;
    }
    @Override
    public void addDemande(DemandeformationReqDTO demandeformationReqDTO) {

        Demandeformation demandeformation = this.demandeformationMapper
                .getDemandeformationFromDemandeFormationReqDTO(demandeformationReqDTO);
        demandeformation.setCreatedAt(new Date());
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

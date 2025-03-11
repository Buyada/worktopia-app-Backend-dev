package com.groupe.Worktopia.service.demandeformation;

import com.groupe.Worktopia.dto.demandeformation.DemandeformationReqDTO;
import com.groupe.Worktopia.dto.demandeformation.DemandeformationResDTO;
import com.groupe.Worktopia.entities.Demandeformation;

import java.util.List;

public interface DemandeformationService {
    void addDemande(DemandeformationReqDTO demandeformationReqDTO);
    DemandeformationResDTO getDemandeById(Integer demandeformationId);
    List<DemandeformationResDTO> getDemandes();
    void updateDemande(Integer demandeformationId, DemandeformationReqDTO demandeformationReqDTO);
    void deleteDemande(Integer demandeformationId);
}

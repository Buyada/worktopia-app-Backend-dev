package com.groupe.Worktopia.service.formation;

import com.groupe.Worktopia.dto.formation.FormationReqDTO;
import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Formation;

import java.util.List;

public interface FormationServer {
    void addFormation(FormationReqDTO formationReqDTO);


//    List<Formation> testGetFormationByCategory(Integer categorieId);

    FormationResDTO getFormationById(Integer formationId);
    List<FormationResDTO> getFormations();
    void updateFormationById(Integer formationId, FormationReqDTO formationReqDTO);
    void deleteFormationById(Integer formationId);
}

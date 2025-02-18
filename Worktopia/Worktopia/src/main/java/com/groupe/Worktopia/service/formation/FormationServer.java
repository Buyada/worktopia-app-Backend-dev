package com.groupe.Worktopia.service.formation;

import com.groupe.Worktopia.entities.Formation;

import java.util.List;

public interface FormationServer {
    void addFormation(Formation formation);
    Formation getFormationById(Integer formationId);
    List<Formation> getFormations();
    void updateFormationById(Integer formationId, Formation formation);
    void deleteFormationById(Integer formationId);
}

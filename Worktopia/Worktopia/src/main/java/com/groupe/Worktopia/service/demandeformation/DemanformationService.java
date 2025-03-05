package com.groupe.Worktopia.service.demandeformation;

import com.groupe.Worktopia.entities.Demandeformation;

import java.util.List;

public interface DemanformationService {
    void addDemande(Demandeformation demandeformation);
    Demandeformation getDemandeById(Integer demandeformationId);
    List<Demandeformation> getDemandes();
    void updateDemande(Integer demandeformationId, Demandeformation demandeformation);
    void deleteDemande(Integer demandeformationId);
}

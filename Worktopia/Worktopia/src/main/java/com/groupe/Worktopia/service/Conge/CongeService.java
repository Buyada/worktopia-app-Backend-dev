package com.groupe.Worktopia.service.Conge;

import com.groupe.Worktopia.entities.Conge;

import java.util.List;

public interface CongeService {
    Conge addConge(Conge conge);
    List<Conge> getAllConge();
    Conge getCongeById(Long id);
    Conge updateConge(Conge newConge, Long id);
    void deleteConge(Long id);
}

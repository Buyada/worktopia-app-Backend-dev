package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormationRepo extends JpaRepository<Formation, Integer> {
    Optional<Formation> findByIntitule(String intitule);
}

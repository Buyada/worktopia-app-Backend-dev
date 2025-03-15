package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FormationRepo extends JpaRepository<Formation, Integer> {
    Optional<Formation> findByIntitule(String intitule);
//    @Query("SELECT f FROM Formation f WHERE f.categorieId = :categorieId")
//    List<Formation> getAllFormByCategoryId(Integer categorieId);
}

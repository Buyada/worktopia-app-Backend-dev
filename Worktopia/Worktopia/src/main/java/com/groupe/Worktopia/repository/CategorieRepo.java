package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepo extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findByIntitule(String intitule);
}

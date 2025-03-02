package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfilRepo extends JpaRepository<Profil, Integer> {
    Optional<Profil> findByFirstname(String firstname);
}

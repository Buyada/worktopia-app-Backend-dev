package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CongeRepo extends JpaRepository<Conge, Long> {
}

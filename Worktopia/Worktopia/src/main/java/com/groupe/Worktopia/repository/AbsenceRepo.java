package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {
}

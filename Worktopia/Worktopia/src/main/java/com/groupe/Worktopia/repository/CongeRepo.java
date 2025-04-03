package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface CongeRepo extends JpaRepository<Conge, Long> {
    List<Conge> findByRetourCongeAfter(Date date);
    Optional<Conge> findByAbsence(Absence absence);
}

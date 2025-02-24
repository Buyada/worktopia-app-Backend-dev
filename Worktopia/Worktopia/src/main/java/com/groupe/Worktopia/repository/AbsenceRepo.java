package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {
    Map<Object, Object> findAllById(Long id);
}

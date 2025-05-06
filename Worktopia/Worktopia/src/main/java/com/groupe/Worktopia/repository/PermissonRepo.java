package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PermissonRepo extends JpaRepository<Permission,Long> {
        List<Permission> findByRaison(String raison);
        List<Permission> findByDateDepermissionAfter(Date date);
        Optional<Permission> findByAbsence(Absence absence);

}

package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employe,Long> {
}

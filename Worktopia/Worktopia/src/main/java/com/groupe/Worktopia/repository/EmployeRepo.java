package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepo extends JpaRepository<Employe,Long> {
    List<Employe> findByEmail(String email);
}

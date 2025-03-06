package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.BulletinPaie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulletinPaieRepo extends JpaRepository<BulletinPaie,Long> {
    //List<BulletinPaie> findByEmployeId(Long idEmploye);
    List<BulletinPaie> findByEmployeIdEmploye(Long idEmploye);
}

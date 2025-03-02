package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.BulletinPaie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface payementRepo extends JpaRepository<BulletinPaie,Long> {
}

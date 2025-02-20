package com.groupe.Worktopia.repository;

import com.groupe.Worktopia.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissonRepo extends JpaRepository<Permission,Long> {
}

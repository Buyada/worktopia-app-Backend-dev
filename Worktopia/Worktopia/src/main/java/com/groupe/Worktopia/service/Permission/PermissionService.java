package com.groupe.Worktopia.service.Permission;

import com.groupe.Worktopia.entities.Conge;
import com.groupe.Worktopia.entities.Permission;

import java.util.List;

public interface PermissionService {
    Permission addPermission(Permission permission);
    List<Permission> getAllPermission();
    Permission getPermissionById(Long id);
    Permission updatePermission(Permission newPermission, Long id);
    void deletePermission(Long id);
}

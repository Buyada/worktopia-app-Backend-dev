package com.groupe.Worktopia.service.Permission;

import com.groupe.Worktopia.entities.Permission;
import com.groupe.Worktopia.repository.PermissonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    private final PermissonRepo permissionRepo;

    public PermissionServiceImpl(PermissonRepo permissionRepo) {
        this.permissionRepo = permissionRepo;
    }

    @Override
    public Permission addPermission(Permission permission) {
        return this.permissionRepo.save(permission);
    }

    @Override
    public List<Permission> getAllPermission() {
        return this.permissionRepo.findAll();
    }

    @Override
    public Permission getPermissionById(Long id) {
        return this.permissionRepo.findById(id).get();
    }

    @Override
    public Permission updatePermission(Permission newPermission, Long id) {
        Permission oldPermission = this.permissionRepo.findById(id).get();
        oldPermission.setDateDepermission(newPermission.getDateDepermission());
        oldPermission.setEnfantMalade(newPermission.getEnfantMalade());
        oldPermission.setMariage(newPermission.getMariage());

        return this.permissionRepo.saveAndFlush(oldPermission);
    }

    @Override
    public void deletePermission(Long id) {
        this.permissionRepo.deleteById(id);

    }
}

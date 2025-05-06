package com.groupe.Worktopia.service.Permission;

import com.groupe.Worktopia.entities.Permission;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.PermissonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService{

    private final PermissonRepo permissionRepo;

    public PermissionServiceImpl(PermissonRepo permissionRepo) {
        this.permissionRepo = permissionRepo;
    }

    @Override
    public Permission addPermission(Permission permission) {
        //avant d'ajouter une permission permission
        return this.permissionRepo.save(permission);
    }

    @Override
    public List<Permission> getAllPermission() {
        return this.permissionRepo.findAll();
    }

    @Override
    public Permission getPermissionById(Long id) {
            Optional<Permission> permission = this.permissionRepo.findById(id);
            if (permission.isEmpty())
                throw new ResourceNotFoundException("Permission not found");
            return permission.get();
        }


    @Override
    public Permission updatePermission(Permission newPermission, Long id) {
        Permission oldPermission = this.permissionRepo.findById(id).get();
        oldPermission.setDateDepermission(newPermission.getDateDepermission());
        oldPermission.setDateDeRetour(newPermission.getDateDeRetour());
        oldPermission.setRaison(newPermission.getRaison());

        return this.permissionRepo.saveAndFlush(oldPermission);
    }

    @Override
    public void deletePermission(Long id) {
        this.permissionRepo.deleteById(id);

    }
}

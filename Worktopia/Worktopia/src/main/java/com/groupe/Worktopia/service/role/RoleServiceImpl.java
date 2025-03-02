package com.groupe.Worktopia.service.role;

import com.groupe.Worktopia.entities.Role;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.groupe.Worktopia.repository.RoleRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    public final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void addRole(Role role) {
        Optional<Role> addRole = this.roleRepo.findByName(role.getName());
        if(addRole.isPresent())
            throw new ResourceExistException("The role already exist !");
        role.setCreatedAt(new Date());
        this.roleRepo.save(role);
    }

    @Override
    public Role getRoleById(Integer roleId) {
        return this.roleRepo.findById(roleId).orElseThrow(()->new ResourceNotFoundException("Resource not found !"));
    }

    @Override
    public List<Role> getRoles() {
        return List.of();
    }

    @Override
    public void updateRole(Integer roleId, Role role) {
        Role roleToUpdate = this.roleRepo.findById(roleId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Resource notfound !")
                );
        roleToUpdate.setName(role.getName());
        roleToUpdate.setUpdateAt(new Date());
        this.roleRepo.saveAndFlush(roleToUpdate);

    }

    @Override
    public void deleteRole(Integer roleId) {
        Role roleToDelete = this.roleRepo.findById(roleId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Resource notfound !")
                );

        this.roleRepo.delete(roleToDelete);
    }
}

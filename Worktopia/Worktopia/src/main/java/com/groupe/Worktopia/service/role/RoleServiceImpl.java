package com.groupe.Worktopia.service.role;

import com.groupe.Worktopia.dto.role.RoleReqDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import com.groupe.Worktopia.entities.Role;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import com.groupe.Worktopia.repository.RoleRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    public final RoleRepo roleRepo;
    public final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepo roleRepo, RoleMapper roleMapper) {
        this.roleRepo = roleRepo;
        this.roleMapper = roleMapper;
    }

    @Override
    public void addRole(RoleReqDTO roleReqDTO) {
        Optional<Role> addRole = this.roleRepo.findByRolename(roleReqDTO.getRolename());
        if(addRole.isPresent())
            throw new ResourceExistException("The role already exist !");

        Role role = this.roleMapper.getRoleFromRoleReqDTO(roleReqDTO);
        role.setCreatedAt(new Date());
        this.roleRepo.save(role);
    }

    @Override
    public RoleResDTO getRoleById(Integer roleId) {
        Role role = this.roleRepo.findById(roleId).orElseThrow(()->new ResourceNotFoundException("Resource not found !"));
        return this.roleMapper.getRoleResDTOFromRole(role);
    }

    @Override
    public List<RoleResDTO> getRoles() {
        List<Role> roles = this.roleRepo.findAll();
        return this.roleMapper.getRolesResDTOFromRoles(roles);
    }

    @Override
    public void updateRole(Integer roleId, RoleReqDTO roleReqDTO) {
        Role roleToUpdate = this.roleRepo.findById(roleId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Resource notfound !")
                );
        roleToUpdate.setRolename(roleReqDTO.getRolename());
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

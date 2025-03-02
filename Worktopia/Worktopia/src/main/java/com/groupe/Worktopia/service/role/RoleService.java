package com.groupe.Worktopia.service.role;

import com.groupe.Worktopia.entities.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);
    Role getRoleById(Integer RoleId);
    List<Role> getRoles();
    void updateRole(Integer roleId, Role role);
    void deleteRole(Integer roleId);

}

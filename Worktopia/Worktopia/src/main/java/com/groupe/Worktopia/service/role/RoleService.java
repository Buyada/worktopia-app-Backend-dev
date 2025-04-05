package com.groupe.Worktopia.service.role;

import com.groupe.Worktopia.dto.role.RoleReqDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import com.groupe.Worktopia.entities.Role;

import java.util.List;

public interface RoleService {
    void addRole(RoleReqDTO roleReqDTO);
    RoleResDTO getRoleById(Integer RoleId);
    List<RoleResDTO> getRoles();
    void updateRole(Integer roleId, RoleReqDTO roleReqDTO);
    void deleteRole(Integer roleId);

}

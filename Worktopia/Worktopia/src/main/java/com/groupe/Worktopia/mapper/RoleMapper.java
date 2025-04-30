package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.role.RoleReqDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import com.groupe.Worktopia.entities.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
//@Component
public interface RoleMapper {
    Role getRoleFromRoleReqDTO(RoleReqDTO roleReqDTO);
    RoleResDTO getRoleResDTOFromRole(Role role);
    List<RoleResDTO> getRolesResDTOFromRoles(List<Role> roles);
}

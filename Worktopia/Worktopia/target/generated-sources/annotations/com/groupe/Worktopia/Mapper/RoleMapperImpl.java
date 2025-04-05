package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.role.RoleReqDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import com.groupe.Worktopia.entities.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-05T18:21:34+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role getRoleFromRoleReqDTO(RoleReqDTO roleReqDTO) {
        if ( roleReqDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setRolename( roleReqDTO.getRolename() );

        return role;
    }

    @Override
    public RoleResDTO getRoleResDTOFromRole(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResDTO roleResDTO = new RoleResDTO();

        roleResDTO.setRoleId( role.getRoleId() );
        roleResDTO.setRolename( role.getRolename() );

        return roleResDTO;
    }

    @Override
    public List<RoleResDTO> getRolesResDTOFromRoles(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleResDTO> list = new ArrayList<RoleResDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( getRoleResDTOFromRole( role ) );
        }

        return list;
    }
}

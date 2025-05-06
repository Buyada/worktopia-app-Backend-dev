package com.groupe.Worktopia.dto.role;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class RoleReqDTO {
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String rolename;

    public RoleReqDTO() {
    }

    public RoleReqDTO(String rolename) {
        this.rolename = rolename;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}

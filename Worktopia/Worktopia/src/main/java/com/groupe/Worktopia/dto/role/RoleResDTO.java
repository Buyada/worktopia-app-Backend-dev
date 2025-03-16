package com.groupe.Worktopia.dto.role;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResDTO {
    private Integer roleId;
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String rolename;
}

package com.groupe.Worktopia.dto.user;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.entities.Role;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResDTO {
    private Integer userId;
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String firstname;
    @NotNull(message = "this field couldn't be null")
    private String lastname;
    @Email(message = "email is not correct !")
    private String email;
    private Integer numeroTelephone;
    private String dateNaissance;
    private String addresse;
    @Lob
    private String motDePasse;

    private ProfilResDTO profilResDTO;
    private RoleResDTO roleResDTO;



}

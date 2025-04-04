package com.groupe.Worktopia.dto.user;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserResDTO {
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String username;
    private String motDePasse;
    @Email(message = "email is not correct !")
    private String email;
//    private Integer roleId;
    private RoleResDTO roleResDTO;
    private ProfilResDTO profilResDTO;


    public UserResDTO() {
    }

    public UserResDTO(String username, String motDePasse, String email, RoleResDTO roleResDTO, ProfilResDTO profilResDTO) {
        this.username = username;
        this.motDePasse = motDePasse;
        this.email = email;
        this.roleResDTO = roleResDTO;
        this.profilResDTO = profilResDTO;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public ProfilResDTO getProfilResDTO() {
        return profilResDTO;
    }

    public void setProfilResDTO(ProfilResDTO profilResDTO) {
        this.profilResDTO = profilResDTO;
    }

    public RoleResDTO getRoleResDTO() {
        return roleResDTO;
    }

    public void setRoleResDTO(RoleResDTO roleResDTO) {
        this.roleResDTO = roleResDTO;
    }
}

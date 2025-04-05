package com.groupe.Worktopia.dto.user;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
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
public class UserReqDTO {
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String username;
    private String motDePasse;
    @Email(message = "email is not correct !")
    private String email;
    private Integer roleId;

    private ProfilReqDTO profilReqDTO;


    public UserReqDTO() {
    }

    public UserReqDTO(String username, String motDePasse, String email, Integer roleId, ProfilReqDTO profilReqDTO) {
        this.username = username;
        this.motDePasse = motDePasse;
        this.email = email;
        this.roleId = roleId;
        this.profilReqDTO = profilReqDTO;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public ProfilReqDTO getProfilReqDTO() {
        return profilReqDTO;
    }

    public void setProfilReqDTO(ProfilReqDTO profilReqDTO) {
        this.profilReqDTO = profilReqDTO;
    }
}

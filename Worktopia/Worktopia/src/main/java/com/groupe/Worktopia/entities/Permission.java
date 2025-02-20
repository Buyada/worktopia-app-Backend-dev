package com.groupe.Worktopia.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Entity
public class Permission {
@Id
@GeneratedValue
    private Long idPermission;
    private Date dateDepermission;
    private Boolean mariage;
    private int enfantMalade;

    public Permission(Long idPermission, Date dateDepermission, Boolean mariage, int enfantMalade) {
        this.idPermission = idPermission;
        this.dateDepermission = dateDepermission;
        this.mariage = mariage;
        this.enfantMalade = enfantMalade;
    }

    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }

    public Date getDateDepermission() {
        return dateDepermission;
    }

    public void setDateDepermission(Date dateDepermission) {
        this.dateDepermission = dateDepermission;
    }

    public Boolean getMariage() {
        return mariage;
    }

    public void setMariage(Boolean mariage) {
        this.mariage = mariage;
    }

    public int getEnfantMalade() {
        return enfantMalade;
    }

    public void setEnfantMalade(int enfantMalade) {
        this.enfantMalade = enfantMalade;
    }
}

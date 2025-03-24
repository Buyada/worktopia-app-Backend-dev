package com.groupe.Worktopia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Data

public class Absence{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;
    private Boolean justifiee;
    private int nombreAbsence;


    @JsonIgnore // pour éviter la récursivité ou répétition
    @OneToOne(mappedBy = "absence")
    private Permission permission;

    public Absence() {

    }

    public Absence(Long idConge, Date retourConge, String raisonConge, Long idAbsence, Boolean justifiee, int nombreAbsence, Permission permission) {
        super();
        this.idAbsence = idAbsence;
        this.justifiee = justifiee;
        this.nombreAbsence = nombreAbsence;
        this.permission = permission;
    }

    public Long getIdAbsence() {
        return idAbsence;
    }

    public void setIdAbsence(Long idAbsence) {
        this.idAbsence = idAbsence;
    }

    public Boolean getJustifiee() {
        return justifiee;
    }

    public void setJustifiee(Boolean justifiee) {
        this.justifiee = justifiee;
    }

    public int getNombreAbsence() {
        return nombreAbsence;
    }

    public void setNombreAbsence(int nombreAbsence) {
        this.nombreAbsence = nombreAbsence;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}

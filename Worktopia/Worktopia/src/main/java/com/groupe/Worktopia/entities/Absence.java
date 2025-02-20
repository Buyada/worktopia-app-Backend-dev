package com.groupe.Worktopia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Entity
public class Absence {

    @Id
    @GeneratedValue
    private Long idAbsence;
    private Boolean justifiee;
    private int nombreAbsence;


    public Absence(Long idAbsence, Boolean justifiee, int nombreAbsence) {
        this.idAbsence = idAbsence;
        this.justifiee = justifiee;
        this.nombreAbsence = nombreAbsence;
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
}

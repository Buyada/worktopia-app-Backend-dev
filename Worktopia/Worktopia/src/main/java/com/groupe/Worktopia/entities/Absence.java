package com.groupe.Worktopia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
public class Absence {

    @Id
    @GeneratedValue
    private Long idAbsence;
    @Setter
    private Boolean justifiee;
    @Setter
    private int nombreAbsence;

    public Absence() {
    }

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

    public int getNombreAbsence() {
        return nombreAbsence;
    }

    public void setNombreAbsence(int nombreAbsence) {
        this.nombreAbsence = nombreAbsence;
    }

    public Boolean getJustifiee() {
        return justifiee;
    }

    public void setJustifiee(Boolean justifiee) {
        this.justifiee = justifiee;
    }
}

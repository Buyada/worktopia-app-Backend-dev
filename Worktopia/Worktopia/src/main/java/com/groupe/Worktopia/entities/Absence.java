package com.groupe.Worktopia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Entity
public class Absence {

    @Id
    @GeneratedValue
    private Long id;
    @Setter
    @Getter
    private Boolean justifiee;
    @Setter
    @Getter
    private int nombreAbsence;


    public Absence(Long idAbsence, Boolean justifiee, int nombreAbsence) {
        this.id = id;
        this.justifiee = justifiee;
        this.nombreAbsence = nombreAbsence;
    }

    public Long getIdAbsence() {
        return id;
    }

    public void setIdAbsence(Long id) {
        this.id = id;
    }

}

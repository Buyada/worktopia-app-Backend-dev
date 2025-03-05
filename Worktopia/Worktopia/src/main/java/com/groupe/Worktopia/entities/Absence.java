package com.groupe.Worktopia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Absence {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean justifiee;

    private int nombreAbsence;

    public Absence(Long id, Boolean justifiee, int nombreAbsence) {
        this.id = id;
        this.justifiee = justifiee;
        this.nombreAbsence = nombreAbsence;
    }
}

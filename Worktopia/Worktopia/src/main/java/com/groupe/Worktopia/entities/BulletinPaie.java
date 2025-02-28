package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "Bulletin_Paie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class BulletinPaie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bulletinID;

    private double salaireBrut;

    private double salaireNet;

    private double cotisation;

    private LocalDate dateGeneration;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employe employe;

}

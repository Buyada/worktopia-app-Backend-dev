package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Bulletin_Paie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class BulletinPaie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bulletinId;

    private double salaireBrut;

    private double salaireNet;

    private LocalDateTime dateGeneration;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

}

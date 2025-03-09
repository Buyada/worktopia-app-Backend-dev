package com.groupe.Worktopia.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(nullable = false)
    private double salaireBrut;
    @Column(nullable = false)
    private double salaireNet;
    @Column(nullable = false)
    private LocalDateTime dateGeneration;
    @Column(nullable = false)
    private LocalDateTime dateModification;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    @JsonBackReference
    private Employe employe;

    public Long getBulletinId() {
        return bulletinId;
    }

    public void setBulletinId(Long bulletinId) {
        this.bulletinId = bulletinId;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }

    public LocalDateTime getDateGeneration() {
        return dateGeneration;
    }

    public void setDateGeneration(LocalDateTime dateGeneration) {
        this.dateGeneration = dateGeneration;
    }

    public double getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(double salaireNet) {
        this.salaireNet = salaireNet;
    }

    public double getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(double salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public BulletinPaie(Long bulletinId, Employe employe, LocalDateTime dateModification, double salaireNet, LocalDateTime dateGeneration, double salaireBrut) {
        this.bulletinId = bulletinId;
        this.employe = employe;
        this.dateModification = dateModification;
        this.salaireNet = salaireNet;
        this.dateGeneration = dateGeneration;
        this.salaireBrut = salaireBrut;
    }
}
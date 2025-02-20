package com.groupe.Worktopia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.Date;
@NoArgsConstructor
@Entity
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConge;
    private Date retourConge;
    private String raisonConge;

    public Conge(Long idConge, Date retourConge, String raisonConge) {
        this.idConge = idConge;
        this.retourConge = retourConge;
        this.raisonConge = raisonConge;
    }

    public Long getIdConge() { 
        return idConge;
    }

    public void setIdConge(Long idConge) {
        this.idConge = idConge;
    }

    public Date getRetourConge() {
        return retourConge;
    }

    public void setRetourConge(Date retourConge) {
        this.retourConge = retourConge;
    }

    public String getRaisonConge() {
        return raisonConge;
    }

    public void setRaisonConge(String raisonConge) {
        this.raisonConge = raisonConge;
    }
}

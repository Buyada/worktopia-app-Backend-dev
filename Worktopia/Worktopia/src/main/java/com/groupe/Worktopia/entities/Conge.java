package com.groupe.Worktopia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

import java.security.PrivateKey;
import java.util.Date;

@Entity
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConge;
    private Date departConge;
    @Setter
    private Date retourConge;
    @Setter
    private String raisonConge;

    public Conge() {
    }

    public Conge(Date departConge, Date retourConge, String raisonConge) {
        this.departConge = departConge;
        this.retourConge = retourConge;
        this.raisonConge = raisonConge;
    }

    public Long getIdConge() {
        return idConge;
    }

    public void setIdConge(Long idConge) {
        this.idConge = idConge;
    }

    public Date getDepartConge() {
        return departConge;
    }

    public void setDepartConge(Date departConge) {
        this.departConge = departConge;
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

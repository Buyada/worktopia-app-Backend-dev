package com.groupe.Worktopia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.security.PrivateKey;
import java.util.Date;

@Entity
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date departConge;
    private Date retourConge;
    private String raisonConge;

    public Conge() {
    }

    public Conge(Date departConge, Date retourConge, String raisonConge) {
        this.departConge = departConge;
        this.retourConge = retourConge;
        this.raisonConge = raisonConge;
    }

    public String getRaisonConge() {
        return raisonConge;
    }

    public void setRaisonConge(String raisonConge) {
        this.raisonConge = raisonConge;
    }

    public Date getRetourConge() {
        return retourConge;
    }

    public void setRetourConge(Date retourConge) {
        this.retourConge = retourConge;
    }

    public Date getDepartConge() {
        return departConge;
    }

    public void setDepartConge(Date departConge) {
        this.departConge = departConge;
    }
}

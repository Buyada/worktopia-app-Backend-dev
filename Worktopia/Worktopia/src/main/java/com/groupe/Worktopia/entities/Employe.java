package com.groupe.Worktopia.entities;

import java.io.Serializable;

public class Employe extends User implements Serializable {

    private String poste;
    private double salaireBase;
    private double heureSupplementaire;
    private double prime;
    private double cotisationSociale;


}

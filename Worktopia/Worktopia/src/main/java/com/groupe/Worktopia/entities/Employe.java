package com.groupe.Worktopia.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Employe extends User{

    private String poste;
    private double salaireBase;
    private double prime;
    private double cotisationSociale;


}
